<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="js/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<!-- 搭建员工显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class=".col-md-12">
				<h2>SSM-CRUD</h2>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-success">新增</button>
				<button type="button" class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>#</th>
						<th>name</th>
						<th>gender</th>
						<th>email</th>
						<th>deptName</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<td>${emp.empId }</td>
							<td>${emp.empName }</td>
							<td>${emp.gender == "M" ? "男" : "女" }</td>
							<td>${emp.email }</td>
							<td>${emp.department.deptName }</td>
							<td>
								<button class="btn btn-primary btn-xs">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
								</button>
								<button class="btn btn-danger btn-xs">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
								</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<div class="col-md-6">
				当前第-${pageInfo.pageNum }-页，总页数-${pageInfo.pages }-页，总记录数-${pageInfo.total }-条记录
			</div>
			<div class="col-md-6">
				<nav aria-label="Page navigation">
			  		<ul class="pagination">
			  			<li><a href="emps?pn=1">首页</a></li>
			  			<c:if test="${pageInfo.hasPreviousPage }">
				  			<li>
				      			<a href="emps?pn=${pageInfo.pageNum-1 }" aria-label="Previous">
				        			<span aria-hidden="true">&laquo;</span>
				      			</a>
				    		</li>
			  			</c:if>
			    		
			    		<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
			    			<c:if test="${page_Num == pageInfo.pageNum }">
			    				<li class="active"><a href="#">${page_Num }</a></li>
			    			</c:if>
			    			<c:if test="${page_Num != pageInfo.pageNum }">
			    				<li><a href="emps?pn=${page_Num }">${page_Num }</a></li>
			    			</c:if>
			    		</c:forEach>
			    		
			    		<c:if test="${pageInfo.hasNextPage }">
				    		<li>
				      			<a href="emps?pn=${pageInfo.pageNum+1 }" aria-label="Next">
				        			<span aria-hidden="true">&raquo;</span>
				      			</a>
				    		</li>
			    		</c:if>
			    		
			    		<li><a href="emps?pn=${pageInfo.pages }">末页</a></li>
			  		</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>