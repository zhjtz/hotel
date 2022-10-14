layui.use(['form', 'layedit', 'laydate'], function () {
    var layer = parent.layer === undefined ? layui.layer : top.layer
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        , table = layui.table
        , $ = layui.jquery;

    //日期
    laydate.render({
        elem: '#startDate'
    });
    laydate.render({
        elem: '#endDate'
    });

    /** 加载数据表格 */
    var  tableIns = table.render({  //返回表格渲染的唯一标识
        id:'commentsTable',// 数据表格的唯一标识
        elem: '#commentsTableId', // 表格绑定的ID
        url: ctx+'/comment/select',// 访问数据的地址
        cellMinWidth : 95,
        page : true, // 开启分页
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        cols : [[
            {field: 'id',hide:true},
            {field: "name", title:'旅客信息',align:"center",fixed:"left"},
            {field: 'evaluationlevelName', title: '评价星级', align:'center',templet:function(d){
                    return formatterState(d.evaluationlevelName); //调用函数,返回格式化的结果
                }},
            {field: 'evaluationdate', title: '评论时间',align:"center",sort:true},
            {field: 'evaluationtext', title: '评论内容',  align:'center'},
            {title: '操作', templet:'#currentTableBar',fixed:"right",align:"center", minWidth:200}
        ]]
    });

    /** 多条件查询 */
    $("#btnSearch").click(function (){
        tableIns.reload({
            // 设置给后端传递的参数
            where: { //设定异步数据接口的额外参数，任意设
                evaluationlevelID:$('[name="evaluationLevelID"]').val(),
                startDate:$("#startDate").val(),
                endDate:$("#endDate").val()
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    /**
     * 监听表格的行工具栏
     */
    table.on('tool(currentTableFilter)', function(obj){
        if(obj.event == "look"){ // 更新操作
            openDetailsDialog(obj.data.passengerid);
        }else if (obj.event=="delete"){ // 删除操作
            // 弹出confirm询问框,询问用户是否删除
            layer.confirm("确认要屏蔽该记录吗?",{icon:3,title:"评论管理"},function (index){
                // 关闭询问框
                layer.close(index);
                // 发送ajax请求,执行删除操作
                $.ajax({
                    type:"post",
                    url:ctx+"/comment/delete",
                    data:{
                        ids:obj.data.id,
                    },
                    success:function (result){
                        // 判断删除结果
                        if (result.code==200){
                            // 提示成功
                            layer.msg("屏蔽成功!",{icon:6});
                            // 表格的重载 (刷新表格)
                            tableIns.reload();
                        }else{
                            // 提示失败
                            layer.msg(result.msg,{icon:5})
                        }
                    }
                })
            })
        }
    });

    /* 格式化星级 */
    function formatterState(evaluationlevelName){
        if(evaluationlevelName=='一星') {
            return "<div style='color: white;width: 100px;height: 30px;line-height: 30px;font-weight: 700;background: red;" +
                "'>体验感极差!</div>";
        } else if(evaluationlevelName=='二星') {
            return "<div style='color: white;width: 100px;height: 30px;line-height: 30px;font-weight: 700;background: orange;" +
                "'>体验感不好!</div>";
        } else if(evaluationlevelName=='三星') {
            return "<div style='color: white;width: 100px;height: 30px;line-height: 30px;font-weight: 700;background: yellow;" +
                "'>体验感中等!</div>";
        }else if(evaluationlevelName=='四星') {
            return "<div style='color: white;width: 100px;height: 30px;line-height: 30px;font-weight: 700;background: blue;'" +
                ">体验感还行!</div>";
        }else if(evaluationlevelName=='五星') {
            return "<div style='color: white;width: 100px;height: 30px;line-height: 30px;font-weight: 700;background: #00FF00;'" +
                ">体验感极好!</div>";
        }
    }

    /**
     * 打开旅客信息的详情页面
     */
    function openDetailsDialog(passengerid){
        var title = "<h3>旅客个人信息</h3>";
        var url = ctx + "/comment/toDetailsPage?passengerid="+passengerid;

        //打开修改添加页面
        layui.layer.open({
            type:2,   //ifame
            title:title,
            content: url,   //页面的内容
            area:['400px','600px'], //设置宽高
            maxmin:true //可以伸缩页面大小
        });
    }

});