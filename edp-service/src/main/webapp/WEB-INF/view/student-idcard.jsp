<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<!--_meta 作为公共模版分离出去-->
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
<!--/meta 作为公共模版分离出去-->

<title>新增机构</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-12 col-sm-6"><span class="c-red"><h3>请在机器上放置身份证</h3></span></label>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-12 col-sm-6"><button onClick="getMockData();" type="button">模拟读取身份证</button></span></label>
		</div>
		<div class="row cl"></br></div>
		<div class="row cl"></br></div>
		<div class="row cl"></br></div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">读取到的信息</span></span></div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>身份证号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="cardnum" name="cardnum" readonly="true">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>学生姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="studentname" name="studentname" readonly="true">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 确认信息并下一步</button>
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$.fn.serializeObject = function()    
	{    
	   var o = {};    
	   var a = this.serializeArray();    
	   $.each(a, function() {    
	       if (o[this.name]) {    
	           if (!o[this.name].push) {    
	               o[this.name] = [o[this.name]];    
	           }    
	           o[this.name].push(this.value || '');    
	       } else {
	       	   if (this.value != ""){    
	           		o[this.name] = this.value || '';    
	       	   }
	       }    
	   });    
	   return o;    
	};

	//表单验证
	$("#form-article-add").validate({
		rules:{
			responsible:{
			},
			regionid:{
				number:true,
			},
			employeecount:{
				number:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
	// 	submitHandler:function(form){
	// 		var options={
	// 	  		type: 'GET',//提交方式  
 //                url:  'institutions-update/submit',
 //                data:{
 //                	institutionsid:${id},
 //                },
 //                contentType:'application/json;charset=UTF-8',
 //                success: function() {
 //                	layer.msg('已修改成功!',{icon: 6,time:1000});
	// 				var index = parent.layer.getFrameIndex(window.name);
	// 				parent.location.replace(parent.location.href)
 //                }   
 //            };
	// 		$(form).ajaxSubmit(options);
	// 	}
	});
	
});

function getMockData(){
	//$("#form-article-add").cardnum.value = '203203199303030303';
	document.getElementById("cardnum").value='203203199303030303';
	document.getElementById("studentname").value='小明';
}

function article_save_submit(){
	//alert('dianji!');
	var data = $("#form-article-add").serializeObject(); //自动将form表单封装成json  
    alert(JSON.stringify(data));
    if(data.cardnum!=null && data.studentname!=null){
		window.location.href="student-fingerprint"
	}else{
		alert("没有读取到数据，请重试！");
	}
}

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>