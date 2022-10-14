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
                            <label class="layui-form-label">旅客名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <a class="layui-btn search_btn" data-type="reload" id="btnSearch"><i class="layui-icon">&#xe615;</i> 搜索</a>
                   </div>
                </form>

            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button type="button" class="layui-btn layui-btn-normal layui-btn-radius" lay-event="add"><i class="layui-icon">&#xe61f;</i> 添加 </button>
                <button type="button" class="layui-btn layui-btn-danger layui-btn-radius" lay-event="delete"><i class="layui-icon">&#xe616;</i> 删除 </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs" id="edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
        </script>

    </div>
</div>
<script src="${ctx}/js/passenger/person.js" charset="utf-8"></script>
<script type="text/javascript">
    var ctx="${ctx}";
</script>
</body>
</html>