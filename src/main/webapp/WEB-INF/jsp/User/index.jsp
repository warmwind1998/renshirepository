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
<script type="text/javascript" src="../js/jquery.js"></script>
<body>
<script type="text/javascript">
var type='${search["id"]}';
$(function(){
	if(type=='')type=0;
	$("[name=id]").val(type)
	if(type==1){
		$("[name=sex]").css("display","inline").removeAttr("disabled");
		$("[name=name]").css("display","none").attr("disabled","disabled");
	}
})
function del(id){
	if(confirm("是否删除")){
		open("delete?id="+id,"_self");
	}
}
function changersearch(o){
	var type=$(o).val();
	if(type==0){
		$("[name=name]").css("display","inline").removeAttr("disabled");
		$("[name=sex]").css("display","none").attr("disabled","disabled");
	}else{
		$("[name=sex]").css("display","inline").removeAttr("disabled");
		$("[name=name]").css("display","none").attr("disabled","disabled");
	}
}
</script>
<form action="index" method="post">
<select name="id" onchange="changersearch(this)">
<option value="0">名称查询</option>
<option value="1">性别查询</option>
</select>
<input name="name" value="${search.name}">
<select name="sex" style="displqy: none;"disabled="disabled">
<c:forEach items="${sexs}" var="r" varStatus="v">
<c:if test="${v.index!=search.sex}">
<option value="${v.index }">${r}</option>
</c:if>
<c:if test="${v.index==search.sex}">
<option value="${v.index }" selected="selected">${r}</option>
</c:if>
</c:forEach>
</select>

<button type="submit">查询</button>
<button type="button" onclick="location.href='add'">新增</button>
</form>
<table>
<tr><td>名称</td><td>性别</td><td>部门</td><td>操作</td>
<c:forEach items="${list}" var="r">
<tr><td>${r.name}</td><td>${r.sexname}</td><td>${r.department_name}</td>
<td>
<a href="javascript:del(${r.id})">删除</a>
<a href="edit?id=${r.id}">修改</a>
</td>
</tr>
</c:forEach>
</table>
<a href="index?pagenno=${pre}">上一页</a>
<a href="index?pagenno=${next}">下一页</a>
</body>
</html>
