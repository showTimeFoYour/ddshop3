package com.wdt.ddshop.dao;

import com.wdt.ddshop.pojo.po.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: DHC
 * Date: 2017/11/3
 * Time: 17:57
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class TbUserMapperTest {

    @Autowired
    private TbUserMapper userDao;

    @Test
    public void testSelectByPrimaryKey() throws Exception {
//        TbUser tbUser = userDao.selectByPrimaryKey(5L);
//        System.out.println(tbUser);
   }

}