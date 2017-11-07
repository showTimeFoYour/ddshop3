<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="tb"></table>
<script>
    $('#tb').datagrid({

        url:'itemsByPage',
        pagination:true,striped:true,
        rownumbers:true,
        fit:true,
        pageSize:10,
        pageList:[10,30,50],

        columns:[[
            {field:'id',title:'商品编号',width:100},
            {field:'title',title:'商品名称',width:100},
            {field:'sellPoint',title:'商品卖点',width:100},
            {field:'price',title:'价格',width:100},
            {field:'catName',title:'商品分类',width:100}

        ]]

    });
</script>

