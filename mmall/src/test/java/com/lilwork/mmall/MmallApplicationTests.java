package com.lilwork.mmall;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class MmallApplicationTests {

    @Test
    void contextLoads() {

        long  i = Calendar.getInstance().getTimeInMillis()/1000;
        int  aa = (int)i;




        System.out.println(aa +"");
    }

}
