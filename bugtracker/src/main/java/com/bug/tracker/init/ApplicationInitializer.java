package com.bug.tracker.init;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bug.tracker.entity.Issue;
import com.bug.tracker.entity.Project;
import com.bug.tracker.entity.Role;
import com.bug.tracker.entity.User;
import com.bug.tracker.enums.Priority;
import com.bug.tracker.enums.Status;
import com.bug.tracker.service.IssueService;
import com.bug.tracker.service.ProjectService;
import com.bug.tracker.service.RoleService;
import com.bug.tracker.service.UserService;

public class ApplicationInitializer {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	IssueService issueService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationInitializer.class);

	public void init() {
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		
		LOG.info("##### ---- Application data initialization started ---- #####");
		
		LOG.info("-------Started to add user roles ------");
		
		Role role_user = new Role();
		role_user.setName("ROLE_USER");
		roleService.save(role_user);
		
		Role role_admin = new Role();
		role_admin.setName("ROLE_ADMIN");
		roleService.save(role_admin);
		
		LOG.info("-------Completed adding user roles ------");
		
		
		LOG.info("-------Started to add users and assign roles ------");

		User u = new User();
		u.setUsername("dbuser1");

		u.setPassword(encode.encode("12345"));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleService.findByName("ROLE_USER"));

		u.setRoles(roles);
		
		userService.save(u);
		
		User admin = new User();
		admin.setUsername("dbadmin");
		admin.setPassword(encode.encode("12345"));

		List<Role> rRoles = new ArrayList<Role>();
		rRoles.add(roleService.findByName("ROLE_USER"));
		rRoles.add(roleService.findByName("ROLE_ADMIN"));
		admin.setRoles(rRoles);
		
		userService.save(admin);

		LOG.info("-------Completed adding users and assign roles ------");
		
		LOG.info("-------Started to add issues ------");
		Project project = new Project();
		project.setName("Hybris project");
		project.setStartDate(new Date());
		
		Calendar c=new GregorianCalendar();
		c.add(Calendar.DATE, 30);
		project.setTargetEndDate(c.getTime());
		
		c= new GregorianCalendar();
		c.add(Calendar.DATE, 60);
		project.setActualEndDate(c.getTime());
		
		List<User> pUsers = new ArrayList<User>();
		pUsers.add(userService.findByusername("dbuser1"));
		
		project.setAssignedUser(pUsers);
		
		projectService.save(project);

		
		LOG.info("-------End of add issues ------");
		
		LOG.info("-------Started to add issues ------");
		User issueUser = userService.findByusername("dbuser1");
		
		Issue issue = new Issue();
		issue.setSummary("Adding the header");
		issue.setDescription("Add header with banner to the application");
		issue.setStatus(Status.NEW.toString());
		issue.setPriority(Priority.MEDIUM.toString());
		issue.setAssignedTo(issueUser);
		issue.setCreatedBy(issueUser);
		issue.setProject(projectService.findByName("Hybris project"));
		
		issueService.save(issue);
		
		issue = new Issue();
		issue.setSummary("Simple bug");
		issue.setDescription("Fix the menu navigation");
		issue.setStatus(Status.WORKINGON.toString());
		issue.setPriority(Priority.HIGH.toString());
		issue.setAssignedTo(issueUser);
		issue.setCreatedBy(issueUser);
		issue.setProject(projectService.findByName("Hybris project"));
		
		issueService.save(issue);
		LOG.info("-------End of adding issues ------");

	}
}
