package com.lilwork.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class BlogApplicationTests {

	@Test
	void contextLoads() {

		int  aa =(int) Calendar.getInstance().getTimeInMillis()/1000;

		System.out.println(aa +"");

	}

}
