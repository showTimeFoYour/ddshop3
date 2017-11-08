<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="tb"></table>
<script>
    var toolbar=[
        {
            iconCls: 'icon-edit',
            text:'编辑',
            handler: function(){alert('编辑按钮')}

        },{}];
    $('#tb').datagrid({

        url: 'itemsByPage',
        pagination: true, striped: true,
        rownumbers: true,
        fit: true,
        pageSize: 10,
        pageList: [10, 30, 50],
        toolbar:toolbar,
        columns: [[{field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100},
            {field: 'title', title: '商品名称', width: 100},
            {field: 'sellPoint', title: '商品卖点', width: 100},
            {field: 'price', title: '价格', width: 100},
            {field: 'catName', title: '商品分类', width: 100},
            {
                field: 'status', title: '商品状态(前台)', width: 100,
                formatter: function (value, row, index) {
                    console.group();
                    console.log(value);
                    console.log(row);
                    console.log(index);
                    console.groupEnd();
                    switch (value) {
                        case 1:
                            return '正常';
                            break;
                        case 2:
                            return '下架';
                            break;
                        case 3:
                            return '删除';
                            break;
                            default:
                            return '未知';
                            break;

                    }
                }
            }

        ]]

    });
</script>

