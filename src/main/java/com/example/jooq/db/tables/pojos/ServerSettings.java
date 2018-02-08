/*
 * This file is generated by jOOQ.
*/
package com.example.jooq.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;


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
@Table(name = "server_settings", schema = "public", indexes = {
    @Index(name = "server_settings_id", unique = true, columnList = "id ASC")
})
public class ServerSettings implements Serializable {

    private static final long serialVersionUID = -823664322;

    private Short  id;
    private String key;
    private String value;

    public ServerSettings() {}

    public ServerSettings(ServerSettings value) {
        this.id = value.id;
        this.key = value.key;
        this.value = value.value;
    }

    public ServerSettings(
        Short  id,
        String key,
        String value
    ) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, precision = 16)
    public Short getId() {
        return this.id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Column(name = "key")
    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Column(name = "value")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ServerSettings (");

        sb.append(id);
        sb.append(", ").append(key);
        sb.append(", ").append(value);

        sb.append(")");
        return sb.toString();
    }
}
