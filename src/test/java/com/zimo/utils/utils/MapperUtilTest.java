package com.zimo.utils.utils;

import com.zimo.utils.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperUtilTest {

    @Test
    public void getResultsStr() throws Exception {
        System.out.println(MapperUtil.getResultsStr(User.class));
    }

}