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
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane">
                    <div class="layui-form-item">

                        <div class="layui-inline">
                            <label class="layui-form-label">评论星级</label>
                            <div class="layui-input-inline">
                                <select name="evaluationLevelID" id="evaluationLevelID" >
                                    <option value="" >请选择</option>
                                    <option value="82" >一星评论</option>
                                    <option value="83" >二星评论</option>
                                    <option value="84" >三星评论</option>
                                    <option value="85" >四星评论</option>
                                    <option value="86" >五星评论</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-inline">
                            <label class="layui-form-label">起始日期</label>
                            <div class="layui-input-block">
                                <input type="text" id="startDate" class="layui-input">
                            </div>
                        </div>至
                        <div class="layui-inline">
                            <label class="layui-form-label">结束日期</label>
                            <div class="layui-input-block">
                                <input type="text" id="endDate" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn search_btn" data-type="reload" id="btnSearch"><i class="layui-icon">&#xe615;</i> 搜 索</a>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>


        <table class="layui-hide" id="commentsTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-warm layui-btn-xs data-count-edit" lay-event="look">查看旅客</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">屏蔽</a>
        </script>

    </div>
</div>

<script src="${ctx}/js/comments/comments.js" charset="utf-8"></script>
<script>
    var ctx="${ctx}";
</script>

</body>
</html>