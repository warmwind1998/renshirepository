<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
<link href="../libs/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../libs/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../libs/layui/layui.all.js"></script>
<script type="text/javascript" src="../libs/js/util.js"></script>
<script type="text/javascript" src="../libs/js/mylayer.js"></script>
<link href="../css/css.css" rel="stylesheet">
<style type="text/css">
.layui-table{
margin-left: 30px !important;
}
</style>
   </head>
<body>
	<div class="demoTable">
	<script type="text/javascript">
	function del(id){
		if(confirm("确认要删除？")){
			location.href="index?id="+id+"&cmd=delete";
		}
	}
	</script>
	
	<form action="index" method="post">
	<input name="txt"> 
	<button  class="layui-btn" type="submit">查询</button> 
	
	<button  type="button" class="layui-btn" onclick="location.href='edit.jsp'">新增</button>
	</form>

	</div>
<div class="layui-form layui-border-box layui-table-view" >
	<div class="layui-table-box">
		<div class="layui-table-body layui-table-main" >
			<table  class="layui-table">
			<thead>
					<tr>
	<td style="width: 100px;">编号</td>
	<td style="width: 200px;">名称</td><td>操作</td></tr>
				</thead>
				<tbody>
	
  	<c:forEach items="${list}" var="r" varStatus="v">		
		<tr >
		<td>${r.id}</td><td>${r.name}</td>
		
		<td>
		<a href="javascript:del(${r.id})">删除</a>
		<a href="index?cmd=get&id=${r.id}">修改</a>
		</td>
		</tr>
		
	</c:forEach>
  	
			
				</tbody>
			</table>
		</div>
	</div>
	
	
	
</div>

</body>
</html>
