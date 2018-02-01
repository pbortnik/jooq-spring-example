/*
 * Copyright 2017 EPAM Systems
 *
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/service-api
 *
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.example.jooq;

import com.example.jooq.generated.tables.daos.ProjectDao;
import com.example.jooq.generated.tables.daos.UsersDao;
import com.example.jooq.generated.tables.pojos.Project;
import com.example.jooq.generated.tables.pojos.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Pavel Bortnik
 */
@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private UsersDao usersDao;

	@RequestMapping(method = GET, value = "/projects")
	@ResponseStatus(OK)
	@ResponseBody
	public String getProjects() {
		List<Project> all = projectDao.findAll();
		return all.toString();
	}

	@RequestMapping(method = GET, value = "/users")
	@ResponseStatus(OK)
	@ResponseBody
	public String getUsers() {
		List<Users> all = usersDao.findAll();
		return all.toString();
	}

	@RequestMapping(method = GET, value = "/update")
	@ResponseStatus(OK)
	@ResponseBody
	public String getUsersProjects() {
		List<Users> all = usersDao.findAll();
		all.forEach(it -> it.setLogin("pavel"));
		usersDao.update(all);
		return "ok";
	}


}
