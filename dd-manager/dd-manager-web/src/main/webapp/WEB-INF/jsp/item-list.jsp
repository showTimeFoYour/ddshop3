<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="tb"></table>
<script>
    var toolbar = [
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

    ];
    $('#tb').datagrid({

        url: 'itemsByPage',
        pagination: true, striped: true,
        rownumbers: true,
        fit: true,
        pageSize: 10,
        pageList: [10, 30, 50],
        toolbar: toolbar,
        columns: [[{field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100},
            {field: 'title', title: '商品名称', width: 100},
            {field: 'sellPoint', title: '商品卖点', width: 100},
            {field: 'price', title: '价格', width: 100},
            {field: 'catName', title: '商品分类', width: 100},
            {field: 'created', title: '创建时间', width: 100,formatter:function(value,row,index){
                return moment(value).format('LL');
            }},
            {field: 'updated', title: '更新时间', width: 100,formatter:function(value,row,index){
                return moment(value).format('LL');
            }},
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

