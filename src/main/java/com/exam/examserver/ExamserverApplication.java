package com.exam.examserver;

import com.exam.examserver.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private User_Service userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("M hu run Method Or m Chal Gya Bc");
//		User user=new User();
//		user.setFirst_name("pop");
//		user.setLast_name("tyagi");
//		user.setAbout("Not Available");
//		user.setPassword("#rascals");
//		user.setEnable(true);
//		user.setPhone("9818796703");
//		user.setEmail("pop@gmail.com");
//
//		Role role=new Role();
//		role.setId(1);
//		role.setRole_name("admin");
//		role.setId(2);
//		role.setRole_name("manager");
//		role.setId(3);
//		role.setRole_name("accountant");
//
//		Set<User_Role>userRoleSet=new HashSet<>();
//		User_Role user_role=new User_Role();
//		user_role.setUser(user);
//		user_role.setRole(role);
//
//		userRoleSet.add(user_role);
//		userService.createUser(user,userRoleSet);
//		System.out.println("in Run===>"+user.getPhone());

	}
}
