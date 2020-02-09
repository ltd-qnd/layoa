<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="layui-form" lay-filter="form_role">
	<div class="layui-form-item">
		<label class="layui-form-label">角色编号</label>
		<div class="layui-input-block">
			<input name="roleCode" id="roleCode" required lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色名称</label>
		<div class="layui-input-block">
			<input name="roleName" id="roleName" required lay-verify="required|checkstuname" placeholder="请输入名称" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色类型</label>
		<div class="layui-input-block">
			<input type="radio" name="roleKind" value="1" title="超级角色"> <input type="radio" name="roleKind" value="0" title="普通角色">
		</div>
	</div>
	<div class="layui-form-item layui-form-text">
		<label class="layui-form-label">角色简介</label>
		<div class="layui-input-block">
			<textarea name="roleInfo" id="roleInfo" placeholder="请输入内容" class="layui-textarea"></textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<input type="hidden" id="rowId" name="rowId" />
			<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>

<script type="text/javascript">
	//一般直接写在一个js文件中
	layui.use([ 'layer', 'form' ], function() {
		var layer = layui.layer;
		var form = layui.form;

		//layer内置jQuey
		var $ = layui.$;

		//表单的自定义校验
		form.verify({
			checkstuname : function(value, item) {//value,表单的值  item,表单的DOM对象
				var msg;
				$.ajax({
					type : 'get',
					async : false, //为了让layui可以唯一性的校验，需要将ajax的异步提交关闭
					url : 'role/checkname',
					data : {
						"roleName" : value
					},
					success : function(result) {
						var data = form.val('form_role');
						if (result == 1 && data.rowId=="" ) {
							msg = '此名称已被使用';
						}
					}
				})
				return msg;
			}
		})

		//绑定提交按钮
		form.on('submit(formDemo)', function() {
			var data = form.val('form_role');
			console.log("aaaaaa");
			if (data.rowId=="") {
				$.ajax({
					type : 'post',
					url : 'role',
					data : data,
					success : function(result) {
						layer.msg('提交成功');
						//关闭弹出层
						layer.close(layer.index);
						//将按钮自带的提交动作屏蔽
						return false;
					}
				})
			} else {
				$.ajax({
					type : 'put',
					url : 'role',
					data : data,
					success : function(result) {
						layer.msg('提交成功');
						//关闭弹出层
						layer.close(layer.index);
						//将按钮自带的提交动作屏蔽
						return false;
					}
				})
			}

		});

	});
</script>
