<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="assert/layui/css/layui.css">
</head>
<body>

	<form class="layui-form" lay-filter="form_student">
		<div class="layui-form-item">
			<label class="layui-form-label">学生姓名</label>
			<div class="layui-input-block">
				<input name="stuName" required lay-verify="required|checkstuname" placeholder="请输入姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学生年龄</label>
			<div class="layui-input-inline">
				<input name="stuAge" required lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学生生日</label>
			<div class="layui-input-inline">
				<input name="stuBirthday" id="stuBirthday" required lay-verify="required" placeholder="请输入生日" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学生性别</label>
			<div class="layui-input-block">
				<input type="radio" name="stuSex" value="1" title="男"> <input type="radio" name="stuSex" value="0" title="女" checked>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>

</body>

<script type="text/javascript" src="assert/layui/layui.js"></script>
<script type="text/javascript">
	//一般直接写在一个js文件中
	layui.use([ 'layer', 'form', 'laydate' ], function() {
		var layer = layui.layer;
		var form = layui.form;
		var laydate = layui.laydate;

		//layer内置jQuey
		var $ = layui.$;

		//渲染日历
		laydate.render({
			elem : '#stuBirthday' //指定元素
		});

		//表单的自定义校验
		form.verify({
			checkstuname:function(value,item){//value,表单的值  item,表单的DOM对象
				var msg;
				$.ajax({
					type : 'get',
					async:false, //为了让layui可以唯一性的校验，需要将ajax的异步提交关闭
					url : 'student/checkname',
					data : {"stuName":value},
					success : function(result) {
						if(result==0){
							msg = '此名称已被使用';
						}
					}
				})
				return msg;
			}
		})
		
		
		//绑定提交按钮
		form.on('submit(formDemo)', function() {
			var data = form.val('form_student');
			console.log(data);
			$.ajax({
				type : 'post',
				url : 'student',
				data : data,
				success : function(result) {
					layer.msg('提交成功');
				}
			})

			//将按钮自带的提交动作屏蔽
			return false;

		});

	});
</script>
</html>