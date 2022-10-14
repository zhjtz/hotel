layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    /** 加载数据表格 */
    var  tableIns = table.render({  //返回表格渲染的唯一标识
        id:'passengerTable',// 数据表格的唯一标识
        elem: '#currentTableId', // 表格绑定的ID
        url: ctx+'/passenger/select',// 访问数据的地址
        cellMinWidth : 95,
        page : true, // 开启分页
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        cols : [[
            {type: "checkbox",fixed:"center"},
            {field: 'id',hide:true},
            {field: "name", title:'姓名',align:"center",fixed:"left",width:100},
            {field: 'genderName', title: '性别',align:"center",sort:true,width:100},
            {field: 'birthdate', title: '出生日期',  align:'center',sort:true},
            {field: 'nationName', title: '民族', align:'center',width:100},
            {field: 'passengerLevelName', title: '旅客级别', align:'center',width:100},
            {field: 'papersName', title: '证件类型', align:'center'},
            {field: 'papersnumber', title: '证件号码', align:'center',minWidth: 200},
            {field: 'contactphonenumber', title: '联系电话', align:'center'},
            {title: '操作', templet:'#currentTableBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });

    /** 多条件查询 */
    $("#btnSearch").click(function (){
        tableIns.reload({
            // 设置给后端传递的参数
            where: { //设定异步数据接口的额外参数，任意设
                name:$('[name="username"]').val()
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    /**
     * 监听表格的头部工具栏
     */
    table.on('toolbar(currentTableFilter)', function(data){
        //console.log(data);// obj.event为当前单元格的lay-event="add"属性
        if (data.event=="add"){ //添加操作
            openAddOrUpdateDialog();//打开添加修改的窗口页面
        }else if (data.event=="delete"){ //删除操作 (批量删除)
            deletePassenger(data);
        }
    });

    /**
     * 监听表格的行工具栏
     */
    table.on('tool(currentTableFilter)', function(obj){
        if(obj.event == "edit"){ // 更新操作
            openAddOrUpdateDialog(obj.data.id);
        }else if (obj.event=="del"){ // 删除操作
            // 弹出confirm询问框,询问用户是否删除
            layer.confirm("确认要删除该记录吗?",{icon:3,title:"旅客信息管理"},function (index){
                // 关闭询问框
                layer.close(index);
                // 发送ajax请求,执行删除操作
                $.ajax({
                    type:"post",
                    url:ctx+"/passenger/delete",
                    data:{
                        ids:obj.data.id,
                    },
                    success:function (result){
                        // 判断删除结果
                        if (result.code==200){
                            // 提示成功
                            layer.msg("删除成功!",{icon:6});
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


    /**
     * 批量删除操作
     */
    function deletePassenger(data){
        //console.log(data);
        // 获取数据表格选中的行数据 (固定写法) table.checkStatus("数据表格的ID属性值")
        var checkStatus=table.checkStatus("passengerTable");
        console.log(checkStatus);

        // 获取所有被选中的数据
        var selectedPassengers=checkStatus.data;

        // 判断是否有选中的数据 (选中的数量>0)
        if (selectedPassengers.length<1){
            // 提示用户选择数据
            layer.msg("请选择要删除的数据!",{icon:5});
            return ;
        }

        // 询问用户是否删除
        layer.confirm("您真的的要删除记录吗?",{icon:5,title:"旅客信息删除"},function (index){
            // 关闭询问框
            layer.close(index);

            // 传递的参数是数组 ids=1&ids=2&ids=3
            var ids="ids=";

            // 循环选中行的数据,拼接进数组
            for (var i=0;i<selectedPassengers.length;i++){
                // 判断是否是最后一条数据 (如果是,则不需要再拼接 &ids=)
                if (i<selectedPassengers.length-1){
                    ids = ids+selectedPassengers[i].id + "&ids=";
                }else{
                    ids = ids+selectedPassengers[i].id;
                }
            }
            //console.log(ids);

            // 发送ajax请求,删除旅客
            $.ajax({
                type:"post",
                url:ctx+"/passenger/delete",
                data:ids, // 传递的参数是数组 ids=1&ids=2&ids=3
                success:function (result){
                    // 判断删除结果
                    if (result.code==200){
                        // 提示成功
                        layer.msg("删除成功!",{icon:6});
                        // 表格的重载 (刷新表格)
                        tableIns.reload();
                    }else{
                        // 提示失败
                        layer.msg(result.msg,{icon:5})
                    }
                }});
        })
    }

    /**
     * 打开添加修改的窗口页面
     */
    function openAddOrUpdateDialog(id){
        var title = "<h2>旅客信息新增</h2>";
        var url = ctx + "/passenger/toAddUpdatePage";

        //通过参数id判断目前是修改还是添加操作
        if(id){
            title = "<h2>旅客信息修改</h2>";
            url += "?id="+id;
        }

        //打开修改添加页面
        layui.layer.open({
            type:2,   //ifame
            title:title,
            content: url,   //页面的内容
            area:['800px','620px'], //设置宽高
            maxmin:true //可以伸缩页面大小
        });
    }





})
