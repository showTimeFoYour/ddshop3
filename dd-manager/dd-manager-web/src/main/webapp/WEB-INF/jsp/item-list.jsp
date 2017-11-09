<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">

        <div>
            <label>商品标题:</label>
            <input class="easyui-textbox" type="text" id="title"/>

            <label>商品状态：</label>
            <select id="status" class="easyui-combobox">
                <option value="0">全部</option>
                <option value="1">正常</option>
                <option value="2">下架</option>
            </select>
            <button type="button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchForm()">
                查询
            </button>
        </div>
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

<table id="tb"></table>
<script>

    function add() {
        console.log("add");
    }
    function remove() {

        var selections = $('#tb').datagrid('getSelections');
//        $.messager.alert(selections);
        if (selections.length == 0) {
            //客户没有选择记录
            $.messager.alert('提示', '请至少选中一条记录！');
            return;
        }
        $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
            if (r) {
                var ids = [];
                for (var i = 0; i < selections.length; i++) {
                    ids.push(selections[i].id);
                }
                $.post(
                    //  //url:请求后台的哪个地址来进行处理，相当于url,String类型
                    'items/bacth',
                    //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                    {'ids[]': ids},
                    //callback:后台处理成功的回调函数，相当于success，function类型
                    function (data) {
                        $("#tb").datagrid("reload");
                    },
                    //返回数据类型
                    'json'
                );
            }
        });
    }
    function edit() {
        console.log("edit");
    }
    function up() {
        console.log("up");
    }
    function down() {
        console.log("down");
    }
    function searchForm(){

        $('#tb').datagrid('load',{
            title:$("#title").val(),
            status:$('#status').combobox("getValue")

        });

    }
    
     /*   [
        {
            iconCls: 'icon-add',
            text: '新增',
            handler: function () {
                alert('新增');
            }

        },
        {
            iconCls: 'icon-remove',
            text: '删除',
            handler: function () {

                var selections = $('#tb').datagrid('getSelections');
                $.messager.alert(selections);
                if (selections.length == 0) {
                    //客户没有选择记录
                    $.messager.alert('提示', '请至少选中一条记录！');
                    return;
                }
                $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                    if (r) {
                        var ids = [];
                        for (var i = 0; i < selections.length; i++) {
                            ids.push(selections[i].id);
                        }
                        $.post(
                            //  //url:请求后台的哪个地址来进行处理，相当于url,String类型
                            'items/bacth',
                            //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                            {'ids[]': ids},
                            //callback:后台处理成功的回调函数，相当于success，function类型
                            function (data) {
                                $("#tb").datagrid("reload");
                            },
                            //返回数据类型
                            'json'
                        );
                    }
                });


            }
        },
        {
            iconCls: 'icon-edit',
            text: '编辑',
            handler: function () {
                alert('编辑按钮');
            }

        },

        {
            iconCls: 'icon-up',
            text: '上架',
            handler: function () {
                alert('编辑按钮');
            }

        },
        {
            iconCls: 'icon-down',
            text: '下架',
            handler: function () {
                alert('下架按钮');
            }

        }

    ];*/
    $('#tb').datagrid({

        url: 'itemsByPage',
        multiSort: true,// 允许多列排序
        pagination: true, //分页栏显示
        striped: true,//隔行变色
        rownumbers: true,//显示第几列
        fit: true,//调整面板屏幕
        pageSize: 20, //初始分页列表大小
        pageList: [20, 30, 50],
        toolbar:'#toolbar',
        /**
         * columns 工具栏
         *
         */
        columns: [[{field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100},
            {field: 'title', title: '商品名称', width: 100, sortable: true},
            {field: 'sellPoint', title: '商品卖点', width: 100, sortable: true},
            {field: 'priceView', title: '价格', width: 100},
            {field: 'catName', title: '商品分类', width: 100},
            {
                field: 'created', title: '创建时间', width: 100, formatter: function (value, row, index) {
                return moment(value).format('LL');
            }
            },
            {
                field: 'updated', title: '更新时间', width: 100, formatter: function (value, row, index) {
                return moment(value).format('LL');
            }
            },
            {
                field: 'status', title: '商品状态(前台)', width: 100,
                formatter: function (value, row, index) {
//                    console.group();
//                    console.log(value);
//                    console.log(row);
//                    console.log(index);
//                    console.groupEnd();
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

