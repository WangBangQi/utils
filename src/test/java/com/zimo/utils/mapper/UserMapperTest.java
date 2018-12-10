package com.zimo.utils.mapper;

import com.zimo.utils.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @SuppressWarnings("all")
    @Autowired
    UserMapper userMapper;

    @Test
    public void list() throws Exception {
        Assert.assertTrue(userMapper.list().size()>=1);
    }

    @Test
    public void searchById() throws Exception {
        assertNotNull(userMapper.searchById(10));
//        assertFalse(userMapper.searchById(30)!=null);
//        assertEquals("状态的",userMapper.searchById(2).getUserName());
    }

    @Test
    public void searchByUserName()throws Exception{
        Integer pageNo = 1;
        Integer pageSize = 10;
        List<User> list = userMapper.searchByNamePage("%48%",(pageNo-1)*pageSize,pageSize);
        for (User user : list){
            System.out.println(user.toString());
        }
    }
    @Test
    public void countAll()throws Exception{
        count_all();
    }

    @Test
    public void countParam()throws Exception{
        count_param();

    }



    @Test
    public void addUser()throws Exception{
//        add10000Users();
    }

    private void add10000Users(){
        for (int i =0;i<100;i++){
            for (int j=0;j<500;j++){
                userMapper.addUser("name"+i+j,"1234567"+i+j,"image/user/1315"+i+j+".jpg");
            }
        }
    }

    private void count_all(){
        Assert.assertTrue(userMapper.countByParam("%48%","%48%")>1);
    }
    private void count_param(){
        Assert.assertTrue(userMapper.countByParam("%48%","%48%")>1);
    }
}