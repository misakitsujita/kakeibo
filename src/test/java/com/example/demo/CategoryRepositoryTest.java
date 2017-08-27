package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domein.Category;
import com.example.demo.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void ロード検証(){
		List<Category> categories =repository.load(1);
		System.out.println("ロード : " + categories);
	}

	@Test
	public void カテゴリー名で検索() {
		List<Category> categories = repository.findByCategory("飲み代");
		System.out.println("カテゴリー名で検索 : " + categories);
	}

}
