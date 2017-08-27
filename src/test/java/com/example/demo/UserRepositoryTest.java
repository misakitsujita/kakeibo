package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domein.User;
import com.example.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void インサートアップデート検証() {
		User user = new User();
		user.setId(1);
		user.setName("test");
		user.setPassword("test");
		repository.saveUser(user);
		System.out.println("インサートアップデート検証 : " + user);
	}

	@Test
	public void ぜんけん検証() {
		List<User> userList = repository.findAll();
		System.out.println("全件検索 : " + userList);
	}

	@Test
	public void ネームパスワード() {
		List<User> userList = repository.findByNameAndPassword("test", "test");
		System.out.println("ネームパスワード : " + userList);
	}

	@Test
	public void ロード検証() {
		List<User> userList = repository.load(1);
		System.out.println("ロード : " + userList);
	}

}
