/*
 * This file is generated by jOOQ.
*/
package com.example.jooq.generated;


import com.example.jooq.generated.tables.Project;
import com.example.jooq.generated.tables.Users;
import com.example.jooq.generated.tables.UsersProject;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.project</code>.
     */
    public static final Project PROJECT = com.example.jooq.generated.tables.Project.PROJECT;

    /**
     * The table <code>public.users</code>.
     */
    public static final Users USERS = com.example.jooq.generated.tables.Users.USERS;

    /**
     * The table <code>public.users_project</code>.
     */
    public static final UsersProject USERS_PROJECT = com.example.jooq.generated.tables.UsersProject.USERS_PROJECT;
}
