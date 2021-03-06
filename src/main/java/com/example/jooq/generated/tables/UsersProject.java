/*
 * This file is generated by jOOQ.
*/
package com.example.jooq.generated.tables;


import com.example.jooq.generated.Indexes;
import com.example.jooq.generated.Keys;
import com.example.jooq.generated.Public;
import com.example.jooq.generated.tables.records.UsersProjectRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersProject extends TableImpl<UsersProjectRecord> {

    private static final long serialVersionUID = 1055950165;

    /**
     * The reference instance of <code>public.users_project</code>
     */
    public static final UsersProject USERS_PROJECT = new UsersProject();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersProjectRecord> getRecordType() {
        return UsersProjectRecord.class;
    }

    /**
     * The column <code>public.users_project.project_id</code>.
     */
    public final TableField<UsersProjectRecord, Integer> PROJECT_ID = createField("project_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.users_project.user_id</code>.
     */
    public final TableField<UsersProjectRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.users_project</code> table reference
     */
    public UsersProject() {
        this(DSL.name("users_project"), null);
    }

    /**
     * Create an aliased <code>public.users_project</code> table reference
     */
    public UsersProject(String alias) {
        this(DSL.name(alias), USERS_PROJECT);
    }

    /**
     * Create an aliased <code>public.users_project</code> table reference
     */
    public UsersProject(Name alias) {
        this(alias, USERS_PROJECT);
    }

    private UsersProject(Name alias, Table<UsersProjectRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsersProject(Name alias, Table<UsersProjectRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USERS_PROJECT_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersProjectRecord> getPrimaryKey() {
        return Keys.USERS_PROJECT_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersProjectRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersProjectRecord>>asList(Keys.USERS_PROJECT_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UsersProjectRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UsersProjectRecord, ?>>asList(Keys.USERS_PROJECT__PROJECT___FK, Keys.USERS_PROJECT__USERS___FK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersProject as(String alias) {
        return new UsersProject(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersProject as(Name alias) {
        return new UsersProject(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersProject rename(String name) {
        return new UsersProject(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersProject rename(Name name) {
        return new UsersProject(name, null);
    }
}
