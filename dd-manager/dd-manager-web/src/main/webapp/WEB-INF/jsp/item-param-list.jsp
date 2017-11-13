<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/13
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="toolbarParam">
    <div style="padding: 5px; background-color: #fff;">


        <div>
            <button class="easyui-linkbutton" type="button" onclick="add()"data-options="iconCls:'icon-add',plain:true">新增</button>
            <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
            <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除
            </button>
            <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
            <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>

        </div>


    </div>

</div>

             <table id="dgParamList"></table>

<script>

    //初始化数据表格
    $('#dgParamList').datagrid({
        title: '商品规格模板列表',
        url:'itemParams',
        fit: true,
        rownumbers: true,
        pagination: true,
        pageSize:20,
        toolbar: '#toolbar',
        columns:[[
            {field:'ck', checkbox: true},
            {field:'id',title:'ID', sortable: true},
            {field:'catName',title:'商品类目'},
            {field:'paramData',title:'规格(只显示分组名称)', formatter:function(value,row,index){
                console.log(value);
                return value;
            }},
            {field:'createdView',title:'创建日期', formatter:function(value,row,index){
                return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
            }},
            {field:'updated',title:'更新日期', formatter:function(value,row,index){
                return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
            }}
        ]]
    });

</script>