layui.use(['form', 'layer'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    // 点击取消按钮 关闭弹出层
    $("#closeBtn").click(function (){
        //当你在iframe页面关闭自身时
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    })

    // 团队新增
    form.on('submit(addOrUpdateReceivetarget)',function (data) {
        var index= top.layer.msg("数据提交中,请稍后...",{icon:16,time:false,shade:0.8});
        // 发送ajax请求
        var url = ctx+"/receivetarget/add";// 添加操作

        // 通过获取影藏域中的ID
        var Id=$("[name='id']").val();
        // 判断Id是否为空
        if (Id != null && Id !=''){
            // 执行更新操作的接口
            url = ctx+"/receivetarget/update";
        }

        $.post(url,data.field,function (result) {
            if(result.code==200){
                layer.msg("操作成功!",{icon:6});
                layer.close(index);
                layer.closeAll("iframe");
                // 刷新父页面
                parent.location.reload();
            }else{
                layer.msg(result.msg);
            }
        });
        return false;
    });



})