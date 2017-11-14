<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/13
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="toolbarParam">


    <div>
        <button type="button" onclick="addParams()" class="easyui-linkbutton"
                data-options="iconCls:'icon-add',plain:true">新增
        </button>
        <button type="button" onclick="editParam()" class="easyui-linkbutton"
                data-options="iconCls:'icon-edit',plain:true">编辑
        </button>
        <button type="button" onclick="removeParam()" class="easyui-linkbutton"
                data-options="iconCls:'icon-cancel',plain:true">删除
        </button>
    </div>


</div>

<table id="dgParamList"></table>

<script>
//添加商品规格
function addParams(){
    ddshop.addTabs("新增商品规格表","item-param-add");
}
    //初始化数据表格
    $('#dgParamList').datagrid({
        title: '商品规格模板列表',
        url: 'itemParams',
        fit: true,
        rownumbers: true,
        pagination: true,
        pageSize: 20,
        toolbar: '#toolbarParam',
        columns: [[
            {field: 'ck', checkbox: true},
            {field: 'id', title: 'ID', sortable: true},
            {field: 'catName', title: '商品类目'},
            {
                field: 'paramData', title: '规格(只显示分组名称)', formatter: function (value, row, index) {
                    //将json字符串转化为json对象
                var obj =JSON.parse(value);
                var arry=[];
                $.each(obj,function (i,e) {

                            arry.push(e.group);
                });
                return arry;
            }
            },
            {
                field: 'createdView', title: '创建日期', formatter: function (value, row, index) {
                return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
            }
            },
            {
                field: 'updated', title: '更新日期', formatter: function (value, row, index) {
                return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
            }
            }
        ]]
    });

</script>