<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assert/layui/css/layui.css">
</head>
<body>
<button type="button" class="layui-btn" id="btn_add">新增</button>

	<div class="layui-form-item">
		<label class="layui-form-label">角色编号</label>
		<div class="layui-input-inline">
			<input name="roleCode" id="roleCode" required lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input">
		</div>
	<button class="layui-btn" id="role_select">查询</button>
	</div>

	<table id="demo" lay-filter="test"></table>

<script type="text/html" id="roleKindTpl">
  {{#  if(d.roleKind == 1){ }}
	<span class="layui-bg-red">超级角色</span>
  {{#  } else if(d.roleKind == 0){ }}
    <span class="layui-bg-cyan">普通角色</span>
  {{#  } }}
</script>

<script type="text/html" id="roleAdmTpl">
  <button class="layui-btn layui-btn-xs" lay-event="edit">修改</button>
{{#  if(d.roleKind == 1){ }}
	 <button class="layui-btn layui-btn-xs layui-btn-disabled">删除</button>
  {{#  } else { }}
     <button class="layui-btn layui-btn-xs" lay-event="delete">删除</button>
  {{#  } }}
</script>

</body>
<script type="text/javascript" src="assert/layui/layui.js"></script>
<script type="text/javascript">

layui.use(['layer','table','form'], function(){
	  var $ = layui.$;
	  var table = layui.table;
	  var form = layui.form;
	  var layer = layui.layer;
	  
	  //通过render方法开始渲染table的数据
	  table.render({
	    elem: '#demo' //要绑定的页面元素
	    ,url: 'role' //数据接口
	    ,page: true //开启分页
	    ,cols: [[ //表头
	      {field: 'rowId', title: 'ID', width:80, sort: true, fixed: 'left'}
	      ,{field: 'roleCode', title: '角色编号', width:100}
	      ,{field: 'roleName', title: '角色名称', width:100}
	      ,{field: 'roleKind', title: '角色类型', width:100,templet:'#roleKindTpl'} 
	      ,{field: 'roleInfo', title: '角色简介', width: 177}
	      ,{field: '', title: '操作', width:180,templet:'#roleAdmTpl'}
	    ]]
	  });
	  
	  table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		  var rowId=data.rowId;
		  switch(layEvent){
		  case 'edit':
			  //查询出该行信息
			  $.ajax({
					url:'role/'+rowId,
					type:'get',
					success:function(role){
						//调出表单进行修改
						  $.ajax({
							  url:'role/goadd',
							  success:function(htmlData){
								  layer.open({
									  type:1,
									  title:'新增用户',
									  area:'850px',//设置宽度，高度自适应
									  content:htmlData,//这里的content是一个DOM，注意，最好该元素存放在body最外层
									  success:function(){//layer打开成功后的回调
										 //给表单赋值
										  $("input[name=roleKind][value=1]").attr("checked", role.roleKind == 1 ? true : false);
										  $("input[name=roleKind][value=0]").attr("checked", role.roleKind == 0 ? true : false);
								 		 	$('#roleCode').val(role.roleCode);
								 			$('#roleName').val(role.roleName);
								 			$('#roleInfo').val(role.roleInfo);
								 			$('#rowId').val(role.rowId);
								 			 //更新表单
								 			 form.render(null,'form_role');
									  }
								  });
							  }
						  })
					}
				}); 
			  break;
		  case 'delete':
			  if(confirm('确定删除？')) {
				   $.ajax({
						url:'role/'+rowId,
						type:'delete',
						success:function(result){
							table.reload('demo');
						}
					}); 
			  };
			  break;
		default:
			 break;
		  }
		  
	  });
	  
	  
	  //绑定新增按钮
 	  $('#btn_add').on('click',function(){
		  $.ajax({
			  url:'role/goadd',
			  success:function(htmlData){
				  layer.open({
					  type:1,
					  title:'新增用户',
					  area:'850px',//设置宽度，高度自适应
					  content:htmlData,//这里的content是一个DOM，注意，最好该元素存放在body最外层
					  success:function(){//layer打开成功后的回调
						  form.render(null,'form_role');
					  }
					  
				  });
			  }
		  })
	  }) 
	  
	//绑定查询按钮
	  $('#role_select').on('click',function(){
	  	var roleCode = $('#roleCode').val();
	  	 //将参数传到后台
	  	 table.reload('demo',{
	  		 where:{'roleCode':roleCode}
	  	 	,page:{curr:1} //重新从第一页开始
	  	 });
	  });
	});

</script>
</html>