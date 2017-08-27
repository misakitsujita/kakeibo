package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domein.AdminUser;
import com.example.demo.repository.AdminUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserRepositoryTest {
	@Autowired
	AdminUserRepository adminUserRepository;
	
	@Test
	public void loadTest(){
		adminUserRepository.load(1);
	}
	@Test
	public void findAllTest(){
		adminUserRepository.findAll();
	}
	
	@Test
	public void findByNameTest(){
		adminUserRepository.findByName("admin");
	}
	
	@Test
	public void insertTest(){
		AdminUser adminUser = new AdminUser();
		adminUser.setName("hghg");
		adminUser.setPassword("hghg");
		adminUserRepository.save(adminUser);
	}
	
	@Test
	public void updateTest(){
		AdminUser adminUser = new AdminUser();
		adminUser.setId(1);
		adminUser.setName("update1");
		adminUser.setPassword("update1");
		adminUserRepository.save(adminUser);
	}
	
}
