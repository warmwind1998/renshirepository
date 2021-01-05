<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<script type="text/javascript">
function del(id){
	if(confirm("是否删除")){
		open("delete?id="+id,"_self");
	}
}
</script>
<button onclick="location.href='add'">新增</button>
<table>
<tr><td>名称</td><td>操作</td>
<c:forEach items="${list}" var="r">
<tr><td>${r.name}</td>
<td>
<a href="javascript:del(${r.id})">删除</a>
<a href="edit?id=${r.id}">修改</a>
</td>
</c:forEach>
</table>
</body>
</html>
