package com.wdt.ddshop.lucene.dao.impl;

import com.wdt.ddshop.lucene.dao.IFlowerDao;
import com.wdt.ddshop.lucene.po.Flower;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FlowerDaoImpl implements IFlowerDao{

    @Override
    public List<Flower> listBooks() {
        //数据库连接
        Connection connection = null;
        //预编译语句对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        //图书列表
        List<Flower> list = new ArrayList<Flower>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowershop", "root", "123456");
            preparedStatement = connection.prepareStatement("select * from flower");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Flower book=new Flower();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setFlowerType(resultSet.getString("flowerType"));
                book.setDescription(resultSet.getString("description"));
                list.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
