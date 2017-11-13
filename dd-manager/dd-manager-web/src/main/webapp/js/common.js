
var ddshop = {

    registerMenuEvent:function(){
        var _this=this;
        var $tree = $("#menu .easyui-tree");

        $tree.tree({
            onClick: function (node) {
                //     alert(node.text);  // 在用户点击的时候提示

                var title = node.text;
                var href = node.attributes.href;


             _this.addTabs(title,href);

            }

        });

    },
    closeTabs:function (text) {
        $('#tab').tabs('close',text);
    },

    addTabs:function (text,href) {
        if($('#tab').tabs('exists',text)){
            $('#tab').tabs('select',text)
        }else{
            $('#tab').tabs('add',{
                title: text,
                href: href,
                closable:true
            });
        }

    }
};



