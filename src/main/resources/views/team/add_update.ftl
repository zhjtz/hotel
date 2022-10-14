<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctx}/lib/layuimini-2/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/lib/layuimini-2/css/public.css" media="all">
    <script src="${ctx}/lib/layuimini-2/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
    <script src="${ctx}/lib/layuimini-2/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>

</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layui-field-title"></fieldset>

        <form class="layui-form" lay-filter="example">
            <#-- 隐藏域Id -->
            <input name="id" type="hidden" value="${(receivetarget.id)!}"/>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">对象类别 <span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <select name="targettypeid" id="targettypeid" lay-verify="required" <#if receivetarget??> disabled="disabled"</#if>>
                            <option value="56" >团队</option>
                        </select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">负责人 <span style="color: red">*</span></label>
                    <div class="layui-input-block" style="width: 216.4px">
                        <input type="text" class="layui-input userName" name="principal" id="principal" lay-verify="required" value="${(receivetarget.principal)!}">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">团队名称 <span style="color: red">*</span></label>
                    <div class="layui-input-block" style="width: 216.4px">
                        <input type="text" class="layui-input userName" name="teamname" id="teamname"  value="${(receivetarget.teamname)!}" lay-verify="required">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">团队编号 <span style="color: red">*</span></label>
                    <div class="layui-input-block" style="width: 216.4px">
                        <input type="text" class="layui-input userName <#if receivetarget??>layui-btn-disabled</#if>" <#if receivetarget??> disabled="disabled"</#if> name="teamcode" id="teamcode"  value="${(receivetarget.teamcode)!}" lay-verify="required">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">

                <div class="layui-inline">
                    <label class="layui-form-label">联系电话 <span style="color: red">*</span></label>
                    <div class="layui-input-block" style="width: 216.4px">
                        <input type="text" class="layui-input userName" name="contactphonenumber" id="contactphonenumber"  value="${(receivetarget.contactphonenumber)!}" lay-verify="required">
                    </div>
                </div>
            </div>

            <br/>
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn" style="position: relative;left: 50%;">取消</button>
                    <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addOrUpdateReceivetarget" >确认</button>

                </div>

        </form>

    </div>
</div>


<script src="${ctx}/js/team/add_update.js" charset="utf-8"></script>
<script type="text/javascript">
    var ctx="${ctx}";

    // 设置回显信息
    // 性别
    var targettypeid=${(receivetarget.targettypeid)!"null"};
    if (targettypeid!=null && targettypeid!="null"){
        $("#targettypeid").find("option").each(function (){
            if ($(this).val()==genderid){
                $(this).attr("selected",true);
            }
        })
    }
</script>

</body>
</html>