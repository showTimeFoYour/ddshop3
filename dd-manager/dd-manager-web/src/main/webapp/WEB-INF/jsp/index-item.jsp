<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="padding:5px;" >
    <%--不管是a标签还是button标签只要class="easyui-linkbutton"，那么按钮的样式的是一样的，type="button"--%>
    <a id="import" class="easyui-linkbutton" onclick="importItems()">一键导入商品数据到索引库</a>
    <span id="msg"></span>
</div>
<script>
    function importItems() {
        //点击完之后不可再次点击，除非刷新
        $('#import').linkbutton('disable');
        //往span添加提示信息
        $('#msg').html('导入中，请稍后...');
        $.post(
            //url：提交给后台谁去处理
            'item/search/import',
            //data:没有传递参数
            null,
            //success:后台处理成功之后的回调函数
            function (data) {
                if(data.success){
                    $.messager.alert('提示', data.message);
                } else {
                    $.messager.alert('提示','导入索引库失败！');
                }
                $('#msg').html('');
            }

        );
    }

</script>
