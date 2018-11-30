package com.example.demo;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    private ApplicationContext appContext;

	@Test
	public void contextLoads() {
	    assertThat("App context should not be null", appContext, notNullValue());
	    assertThat("Should find book repository", appContext.getBean(BookRepository.class), notNullValue());
	}

}
