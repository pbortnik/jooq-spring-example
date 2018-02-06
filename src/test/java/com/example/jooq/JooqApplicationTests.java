package com.example.jooq;

import com.epam.reportportal.auth.db.tables.records.ProjectRecord;
import com.epam.reportportal.auth.db.tables.records.UsersRecord;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.jooq.impl.DefaultDSLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.InputSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import static com.epam.reportportal.auth.db.Tables.PROJECT;
import static com.epam.reportportal.auth.db.Tables.USERS;
import static com.epam.reportportal.auth.db.Tables.USERS_PROJECT;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JooqApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	@Value("classpath:dataset.xml")
	private Resource dataset;

	@Before
	public void contextLoads() throws SQLException, DatabaseUnitException, IOException {
		DatabaseConnection connection = new DatabaseConnection(dataSource.getConnection());
		connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory() {
			@Override
			public boolean isEnumType(String sqlTypeName) {
				return sqlTypeName.endsWith("enum");
			}

			@Override
			public DataType createDataType(int sqlType, String sqlTypeName) throws DataTypeException {
				if (isEnumType(sqlTypeName)) {
					sqlType = Types.OTHER;
				}
				return super.createDataType(sqlType, sqlTypeName);
			}
		});

		FlatXmlDataSet dataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(dataset.getInputStream())));
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
	}

	@Test
	public void selectTest() {
		System.out.println(aggregateUserProjects());
	}

	@Autowired
	private DefaultDSLContext dsl;

	public Map<UsersRecord, List<ProjectRecord>> aggregateUserProjects() {
		return dsl.select()
				.from(USERS)
				.join(USERS_PROJECT)
				.on(USERS_PROJECT.USER_ID.eq(USERS.ID))
				.join(PROJECT)
				.on(USERS_PROJECT.PROJECT_ID.eq(PROJECT.ID))
				.fetchGroups(
						// Map records first into the USER table and then into the key POJO type
						r -> r.into(USERS).into(UsersRecord.class),

						// Map records first into the ROLE table and then into the value POJO type
						r -> r.into(PROJECT).into(ProjectRecord.class)
				);
	}

	public List<ProjectRecord> getUserProjects(Integer id) {
		return dsl.select()
				.from(USERS)
				.join(USERS_PROJECT)
				.on(USERS_PROJECT.USER_ID.eq(USERS.ID))
				.join(PROJECT)
				.on(USERS_PROJECT.PROJECT_ID.eq(PROJECT.ID))
				.where(USERS.ID.eq(id))
				.fetchInto(PROJECT);
	}

}
