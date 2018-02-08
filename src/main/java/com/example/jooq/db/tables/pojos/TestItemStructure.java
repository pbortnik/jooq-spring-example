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
@Table(name = "test_item_structure", schema = "public", indexes = {
    @Index(name = "test_item_structure_item_id_key", unique = true, columnList = "item_id ASC"),
    @Index(name = "test_item_structure_pk", unique = true, columnList = "id ASC")
})
public class TestItemStructure implements Serializable {

    private static final long serialVersionUID = 1873959229;

    private Long    id;
    private Long    itemId;
    private Long    launchId;
    private Long    parentId;
    private Long    retryOf;
    private Boolean hasChildren;

    public TestItemStructure() {}

    public TestItemStructure(TestItemStructure value) {
        this.id = value.id;
        this.itemId = value.itemId;
        this.launchId = value.launchId;
        this.parentId = value.parentId;
        this.retryOf = value.retryOf;
        this.hasChildren = value.hasChildren;
    }

    public TestItemStructure(
        Long    id,
        Long    itemId,
        Long    launchId,
        Long    parentId,
        Long    retryOf,
        Boolean hasChildren
    ) {
        this.id = id;
        this.itemId = itemId;
        this.launchId = launchId;
        this.parentId = parentId;
        this.retryOf = retryOf;
        this.hasChildren = hasChildren;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, precision = 64)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "item_id", unique = true, nullable = false, precision = 64)
    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Column(name = "launch_id", nullable = false, precision = 64)
    public Long getLaunchId() {
        return this.launchId;
    }

    public void setLaunchId(Long launchId) {
        this.launchId = launchId;
    }

    @Column(name = "parent_id", precision = 64)
    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "retry_of", precision = 64)
    public Long getRetryOf() {
        return this.retryOf;
    }

    public void setRetryOf(Long retryOf) {
        this.retryOf = retryOf;
    }

    @Column(name = "has_children")
    public Boolean getHasChildren() {
        return this.hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TestItemStructure (");

        sb.append(id);
        sb.append(", ").append(itemId);
        sb.append(", ").append(launchId);
        sb.append(", ").append(parentId);
        sb.append(", ").append(retryOf);
        sb.append(", ").append(hasChildren);

        sb.append(")");
        return sb.toString();
    }
}
