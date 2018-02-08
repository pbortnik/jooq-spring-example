/*
 * This file is generated by jOOQ.
*/
package com.example.jooq.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


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
@Entity
@Table(name = "issue_type_project_configuration", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"configuration_id", "issue_type_id"})
}, indexes = {
    @Index(name = "issue_type_project_configuration_pk", unique = true, columnList = "configuration_id ASC, issue_type_id ASC")
})
public class IssueTypeProjectConfiguration implements Serializable {

    private static final long serialVersionUID = -1975638646;

    private Integer configurationId;
    private Integer issueTypeId;

    public IssueTypeProjectConfiguration() {}

    public IssueTypeProjectConfiguration(IssueTypeProjectConfiguration value) {
        this.configurationId = value.configurationId;
        this.issueTypeId = value.issueTypeId;
    }

    public IssueTypeProjectConfiguration(
        Integer configurationId,
        Integer issueTypeId
    ) {
        this.configurationId = configurationId;
        this.issueTypeId = issueTypeId;
    }

    @Column(name = "configuration_id", nullable = false, precision = 32)
    public Integer getConfigurationId() {
        return this.configurationId;
    }

    public void setConfigurationId(Integer configurationId) {
        this.configurationId = configurationId;
    }

    @Column(name = "issue_type_id", nullable = false, precision = 32)
    public Integer getIssueTypeId() {
        return this.issueTypeId;
    }

    public void setIssueTypeId(Integer issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("IssueTypeProjectConfiguration (");

        sb.append(configurationId);
        sb.append(", ").append(issueTypeId);

        sb.append(")");
        return sb.toString();
    }
}