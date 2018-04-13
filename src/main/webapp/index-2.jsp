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

	<!-- Modal -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加员工</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">empName</label>
			    <div class="col-sm-10">
			      <input type="text" name="empName" class="form-control" id="empName_add" placeholder="姓名">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">email</label>
			    <div class="col-sm-10">
			      <input type="text" name="email" class="form-control" id="email_add" placeholder="email@163.com">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">gender</label>
			    <div class="col-sm-10">
				    <label class="radio-inline">
					  <input type="radio" name="gender" id="gender1_add" value="M" checked> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="gender" id="gender2_add" value="F"> 女
					</label>
				</div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">deptName</label>
			    <div class="col-sm-4">
			    	<select class="form-control" name="dId" id="dept_add">
					</select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="emp_save">保存</button>
	      </div>
	    </div>
	  </div>
	</div>


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
				<button type="button" class="btn btn-success" id="emp_add_modal_btn">新增</button>
				<button type="button" class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>#</th>
							<th>name</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<div class="col-md-6" id="page_info">
			</div>
			<div class="col-md-6" id="page_nav">
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var totalRecord;//总记录数
		//1、页面加载完成后ajax请求获取数据
		$(function() {
			to_page(1);
		});
		
		//获取页面信息请求
		function to_page(pn) {
			$.ajax({
				url: "emps",
				data: "pn=" + pn,
				type: "get",
				success: function(result) {
					console.log(result);
					var r = eval('(' + result + ')');
					//1、解析并显示员工数据
					build_emps_table(r);
					//2、显示分页信息
					build_page_info(r);
					//显示分页条
					build_page_nav(r);
				}
			})
		}
		
		//显示表格
		function build_emps_table(result) {
			$("#emps_table tbody").empty();
			var emps = result.extend.pageInfo.list;
			$.each(emps, function(index, item) {
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(item.gender == "M" ? "男" : "女");
				var emailTd = $("<td></td>").append(item.email);
				var deptNameTd = $("<td></td>").append(item.department.deptName);
				
				var eitrBtn = $("<button></button>").addClass("btn btn-primary btn-xs")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
								.append("编辑");
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs")
								.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
								.append("删除");
				var btnTd = $("<td></td>").append(eitrBtn)
											.append(" | ")
											.append(delBtn)
				//append方法执行完成以后还是返回定义的元素
				$("<tr></tr>").append(empIdTd)
					.append(empNameTd)
					.append(genderTd)
					.append(emailTd)
					.append(deptNameTd)
					.append(btnTd)
					.appendTo("#emps_table tbody");
			})
		}
		
		//显示分页信息
		function build_page_info(result) {
			$("#page_info").empty();
			$("#page_info").append("当前第-" + result.extend.pageInfo.pageNum + "-页，总页数-" 
					+ result.extend.pageInfo.pages + "-页，总记录数-" 
					+ result.extend.pageInfo.total + "-条记录")
			totalRecord = result.extend.pageInfo.total;
		}
		
		//显示分页条
		function build_page_nav(result) {
			$("#page_nav").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
			var perPageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));
			//判断如果没有前一页则不能点击
			if(result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				perPageLi.addClass("disabled");
			} else {
				//为元素添加翻页事件
				firstPageLi.click(function() {
					to_page(1);
				});
				perPageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1)
				});
			}
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href", "#"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
			//判断是否有下一页，没有则不能点击
			if(result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum + 1)
				});
				lastPageLi.click(function() {
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			ul.append(firstPageLi).append(perPageLi);
			$.each(result.extend.pageInfo.navigatepageNums, function(index, item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
				if(result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_page(item);
				})
				ul.append(numLi);
			})
			ul.append(nextPageLi).append(lastPageLi);
			
			var nav = $("<nav></nav>").append(ul);
			nav.appendTo("#page_nav");
		}
		//点击新增按钮弹出状态框
		$("#emp_add_modal_btn").click(function() {
			//获取部门信息
			getDepts();
			//弹出状态框
			$("#empAddModal").modal({
				backdrop: "static"
			})
		});
		
		function getDepts() {
			$.ajax({
				url: "depts",
				type: "get",
				success: function(result) {
					console.log(result);
					var r = eval('(' + result + ')');
					$.each(r.extend.depts, function(index, item) {
						var optionEle = $("<option></option>")
										.append(item.deptName)
										.attr("value", item.deptId);
						optionEle.appendTo("#dept_add");
					})
					//$("#dept_add").append("")
				}
			});
		}
		
		//增加校验
		function vaildate_add() {
			var empName = $("#empName_add").val();
			var regName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2, 5})/;
			if(!regName.test(empName)) {
				//用户名不正确
				show_validate_msg("#empName_add", "error", "用户名为2-5为中文或者6-16位英文")
				return false;
			} else {
				show_validate_msg(ele, status, msg)
				$("#empName_add").parent().addClass("has-success");
				$("#empName_add").next("span").text("");
			}
			var email = $("#email_add").val();
			var regEmail = 	/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)) {
				//邮箱不正确
				$("#email_add").parent().addClass("has-error");
				$("#email_add").next("span").text("邮箱格式不正确");
				return false;
			} else {
				$("#email_add").parent().addClass("has-success");
				$("#email_add").next("span").text("");
			}
			return true;
		}
		
		function show_validate_msg(ele, status, msg) {
			if(status == "success") {
				
			} else if(status == "error") {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		//模态框保存
		$("#emp_save").click(function() {
			//1、先对要提交的数据进行校验
			if(!vaildate_add()) {
				return false;
			}
			//增加员工
			$.ajax({
				url: "emp",
				type: "post",
				data: $("#empAddModal form").serialize(),
				success: function(result) {
					alert(result.msg);
					//员工保存成功
					//1、关闭模态框
					$("#empAddModal").modal("hide");
					//2、跳转到最后一页，查询添加信息
					to_page(totalRecord);
				}
			})
		})
		
	</script>
</body>
</html>