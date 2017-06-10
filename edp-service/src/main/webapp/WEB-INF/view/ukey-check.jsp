<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>Ukey管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 培训检查 <span class="c-gray en">&gt;</span> 检查结果 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l">学生信息对照</span> <!-- <span class="r">共有数据：<strong>88</strong> 条</span> --> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="80">ID</th>
				<th width="100">学生姓名</th>
				<th width="100">数据库照片</th>
				<th width="100">现场检查照片</th>
				<th width="20">学生信息验证</th>
				<th width="20">机构负责人</th>
			</tr>
		</thead>
		<tbody>
			<tr class="text-c">
				<td>1</td>
				<td>小王</td>
				<td><img src="img/personimg.jpg"  alt="pimg" height="100" width="80"/></td>
				<td><img src="img/personimg.jpg"  alt="pimg" height="100" width="80"/></td>
				<td><span class="label label-success radius">已验证</span></td>
				<td>王老师</td>
			</tr>
		</tbody>
	</table>
	</div>
	</br>
	</br>
	<div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l">机构负责人信息</span> <!-- <span class="r">共有数据：<strong>88</strong> 条</span> --> </div>
	<div class="mt-20">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">负责人姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="fingernum" name="fingernum">
			</div>
		</div>
	</div>
	<div class="mt-20">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">手机号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="fingernum" name="fingernum" >
			</div>
		</div>
	</div>
	<div class="mt-20">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">审核信息：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="abstract" cols="" rows="" class="textarea"  placeholder="本人确认检查过程中的信息没有虚假、遗漏、和伪造。" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
	</div>
	<div class="mt-20">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">Ukey签名：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<img src="img/timg.jpg"  alt="timg" height="100" width="150"/>
			</div>
		</div>
	</div>
	<div class="mt-20">
	<button onClick="article_save_submit();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  // {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			data:{
				id:id
			},
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,${s.studentid})" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
				$(obj).remove();
				layer.msg('已停用!',{icon: 5,time:1000});
				javascript:location.replace(location.href)
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			data:{
				id:id
			},
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,${s.studentid})" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
				$(obj).remove();
				layer.msg('已启用!',{icon: 6,time:1000});
				javascript:location.replace(location.href)
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	var urls = window.location.href;
	urls = urls.substring(0,urls.length-5);
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: urls+'/delete',
			data:{
				id:id
			},
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
/*用户-批量删除*/
function datadel(){
	var text="";  
    $("input[name=items]").each(function() {  
        if ($(this).is(":checked")) {  
            text += $(this).val()+",";  
        }
    });
    if(text==""){
    	alert("请至少选择一项！");
    	return;
    }
    text = text.substring(0,text.length-1);
    data = text.split(',')
    var urls = window.location.href;
	urls = urls.substring(0,urls.length-5);
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: urls+'/deleteall',
			data:{
				ids:data
			},
			dataType: 'json',
			success: function(data){
				layer.msg('已删除!',{icon:1,time:1000});
				location.replace(location.href);
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}
</script> 
</body>
</html>