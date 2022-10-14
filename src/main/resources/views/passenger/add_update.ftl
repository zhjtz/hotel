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
            <input name="id" type="hidden" value="${(passenger.id)!}"/>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">姓名 <span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input userName <#if passenger??>layui-btn-disabled</#if>" <#if passenger??>disabled</#if> lay-verify="required" name="name" id="name"
                               value="${(passenger.name)!}" placeholder="请输入姓名">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">性别 <span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <select name="genderid" id="genderid" lay-verify="required" <#if passenger??> disabled="disabled"</#if>>
                            <option value="" >请选择</option>
                            <option value="31" >男</option>
                            <option value="32" >女</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">出生日期 <span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input userName <#if passenger??>layui-btn-disabled</#if>" lay-verify="required" <#if passenger??>disabled</#if> name="birthdate" id="birthdate"  value="${(passenger.birthdate)!}" placeholder="年-月-日">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">民族 <span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <select name="nationid" id="nationid" <#if passenger??> disabled="disabled"</#if> lay-verify="required">
                            <option value="" >请选择</option>
                            <option value="33" >汉族</option>
                            <option value="34" >苗族</option>
                            <option value="35" >壮族</option>
                            <option value="36" >其他</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">发证机关 <span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input userName <#if passenger??>layui-btn-disabled</#if>" lay-verify="required"  <#if passenger??> disabled="disabled"</#if> name="licenceissuingauthorty" id="licenceissuingauthorty"  value="${(passenger.licenceissuingauthorty)!}">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">证件有效期 <span style="color: red">*</span></label>
                    <div class="layui-input-block" style="width: 216.4px">
                        <input type="text" class="layui-input userName <#if passenger??>layui-btn-disabled</#if>" lay-verify="required" name="papersvalidity" id="papersvalidity"  value="${(passenger.papersvalidity)!}" <#if passenger??> disabled="disabled"</#if>  placeholder="年-月-日 至 年-月-日">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">联系电话 <span style="color: red">*</span></label>
                    <div class="layui-input-block" >
                        <input type="text" class="layui-input userName" lay-verify="required" name="contactphonenumber" id="contactphonenumber"  value="${(passenger.contactphonenumber)!}"  placeholder="请输入联系电话">
                    </div>
                </div>


                <div class="layui-inline">
                    <label class="layui-form-label">证件类型 <span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <select name="papersid" id="papersid" <#if passenger??> disabled="disabled"</#if> lay-verify="required">
                            <option value="" >请选择</option>
                            <option value="37" >二代身份证</option>
                            <option value="38" >护照</option>
                            <option value="39" >其他</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">证件号码 <span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input userName <#if passenger??>layui-btn-disabled</#if>" lay-verify="required" <#if passenger??> disabled="disabled"</#if> name="papersnumber" id="papersnumber"  value="${(passenger.papersnumber)!}" placeholder="请输入证件号码">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">职业</label>
                    <div class="layui-input-block" style="width: 216.4px">
                        <input type="text" class="layui-input userName"  name="profession" id="profession"  value="${(passenger.profession)!}">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label" >旅客级别</label>
                    <div class="layui-input-block" style="width: 186.4px">
                        <select name="passengerlevelid" id="passengerlevelid">
                            <option value="52" >首次</option>
                            <option value="53" >熟客</option>
                            <option value="54" >VIP</option>
                        </select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">单位或住址</label>
                    <div class="layui-input-block" style="width: 216.4px">
                        <input type="text" class="layui-input userName" name="unitsoraddress" id="unitsoraddress"  value="${(passenger.unitsoraddress)!}">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">事由</label>
                    <div class="layui-input-block" style="width: 186.4px">
                        <select name="thingreasonid" id="thingreasonid">
                            <option value="51" >个人旅行</option>
                            <option value="50" >公务出差</option>
                        </select>
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">从何处来</label>
                    <div class="layui-input-block" style="width: 216.4px">
                        <input type="text" class="layui-input userName" name="wherearefrom" id="wherearefrom"  value="${(passenger.wherearefrom)!}">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">到啦里去</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input userName" name="wheretogo" id="wheretogo"  value="${(passenger.wheretogo)!}">
                    </div>
                </div>


            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" class="layui-textarea" style="width: 530px" name="remarks" id="remarks"> ${(passenger.remarks)!}</textarea>
                </div>
            </div>

            <br/>
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn" style="position: relative;left: 50%;">取消</button>
                    <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addOrUpdatePassenger" >确认</button>

                </div>

        </form>

    </div>
</div>


<script src="${ctx}/js/passenger/add_update.js" charset="utf-8"></script>
<script type="text/javascript">
    var ctx="${ctx}";

    // 设置回显信息
    // 性别
    var genderid=${(passenger.genderid)!"null"};
    if (genderid!=null && genderid!="null"){
        $("#genderid").find("option").each(function (){
            if ($(this).val()==genderid){
                $(this).attr("selected",true);
            }
        })
    }

    // 民族
    var nationid=${(passenger.nationid)!"null"};
    if (nationid!=null && nationid!="null"){
        $("#nationid").find("option").each(function (){
            if ($(this).val()==nationid){
                $(this).attr("selected",true);
            }
        })
    }

    // 证件类型
    var papersid=${(passenger.papersid)!"null"};
    if (papersid!=null && papersid!="null"){
        $("#papersid").find("option").each(function (){
            if ($(this).val()==papersid){
                $(this).attr("selected",true);
            }
        })
    }

    // 旅客级别
    var passengerlevelid=${(passenger.passengerlevelid)!"null"};
    if (passengerlevelid!=null && passengerlevelid!="null"){
        $("#passengerlevelid").find("option").each(function (){
            if ($(this).val()==passengerlevelid){
                $(this).attr("selected",true);
            }
        })
    }

    // 事由
    var thingreasonid=${(passenger.thingreasonid)!"null"};
    if (thingreasonid!=null && thingreasonid!="null"){
        $("#thingreasonid").find("option").each(function (){
            if ($(this).val()==thingreasonid){
                $(this).attr("selected",true);
            }
        })
    }

</script>

</body>
</html>