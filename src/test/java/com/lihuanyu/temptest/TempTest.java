package com.lihuanyu.temptest;

import com.lihuanyu.LearnmoocApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Created by skyADMIN on 16/5/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LearnmoocApplication.class)
@WebAppConfiguration
public class TempTest {

    @Test
    public void tempTest() {
        Date date = new Date();
        System.out.println(date.toString());
    }

}
