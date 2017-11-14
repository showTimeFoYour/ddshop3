<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/13
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-panel" title="商品规格参数模板详情" data-options="fit:true">

    <form class="form" id="itemParamAddForm" name="itemParamAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">商品类目：</td>
                <td>
                    <input id="cid" name="cid" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">规格参数：</td>
                <td>
                    <button class="easyui-linkbutton" onclick="addGroup()" type="button"
                            data-options="iconCls:'icon-add'">添加分组
                    </button>
                    <ul id="item-param-group">

                    </ul>
                    <ul id="item-param-group-template" style="display:none;">
                        <li>
                            <input name="group">
                            <button title="添加参数" class="easyui-linkbutton" onclick="addParam(this)" type="button"
                                    data-options="iconCls:'icon-add'"></button>
                            <button title="删除分组" class="easyui-linkbutton" onclick="delGroup(this)" type="button"
                                    data-options="iconCls:'icon-cancel'"></button>
                            <ul class="item-param">
                                <li>
                                    <input name="param">
                                    <button title="删除参数" class="easyui-linkbutton" onclick="delParam(this)"
                                            type="button" data-options="iconCls:'icon-cancel'"></button>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button class="easyui-linkbutton" onclick="submitFormParam()" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button class="easyui-linkbutton" onclick="clearFormParam()" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    /**
     * 重置表单
     * */
    function clearFormParam() {
        $("#itemParamAddForm").form("reset");

    }

    /**
     * 保存表单
     * */
    function submitFormParam() {
        var groupValues = [];
        var $groups = $("#item-param-group  [name=group]");//获取组表
        //遍历分组
        $groups.each(function (index, eg) {

            var paramValues = [];
            /**
             * 获取参数组
             * */
            var $params = $(eg).parent().find(".item-param [name=param]");
            //遍历参数组

            $params.each(function (i, ep) {

                var value = $(ep).val();
                if ($.trim(value).length > 0) {
                    paramValues.push(value);
                }
            });
            var val = $(eg).val();
            var o = {};
            o.group = val;
            o.params = paramValues;
            /**
             * $.trim(val)去掉val 首尾空格
             * */
            if ($.trim(val).length > 0 && paramValues.length > 0) {
                groupValues.push(o);
            }

        });
        console.log(groupValues);

        var cid = $('#cid').combotree('getValue');
        var url = 'item/param/save/' + cid;
        var jsonStr = JSON.stringify(groupValues);
        $.post(
            url,
            {paramData: jsonStr},
            function (data) {
                if (data > 0) {
                    $.messager.alert('温馨提示', '保存成功！');
                    ddshop.addTabs('规格参数', 'item-param-list');
                    ddshop.closeTabs("新增商品规格表");
                }

            }
        );
    }

    /**
     * 删除组列表
     * */
    function delGroup(ect) {
        $(ect).parent().remove();
    }

    /**
     * 删除参数列表
     * */
    function delParam(ect) {
        $(ect).parent().remove();

    }


    /**
     * 添加参数列表
     * */
    function addParam(ect) {
        var $param = $("#item-param-group-template .item-param li").eq(0).clone();
        $(ect).parent().find('.item-param').append($param);

    }

    /**
     * 添加组列表
     * */
    function addGroup() {
        var $group = $("#item-param-group-template li").eq(0).clone();
        $("#item-param-group").append($group);
    }

    /**
     * 分类
     * */
    $("#cid").combotree({
        url: 'itemCatList?parentId=0',
        required: true,
        onBeforeExpand: function (node) {

            var currentTree = $("#cid").combotree('tree');//获取当前节点树
            var options = currentTree.tree("options");//获取当前组件
            console.log(options);
            options.url = 'itemCatList?parentId=' + node.id;//改变url
        },
        onBeforeSelect: function (node) {
            /**
             node -->id: 1, text: "图书、音像、电子书刊", state: "closed", domId: "_easyui_tree_7", checkState: undefined
             */
            var isleaf = $("#cid").tree('isLeaf', node.target);
            if (!isleaf) {
                $.messager.alert("警告", "请选中最终的类别！", "warning");
                return false;
            }
        }

    });


</script>