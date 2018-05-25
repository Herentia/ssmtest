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

	<!-- 修改Modal -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">修改员工</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">empName</label>
			    <div class="col-sm-10">
			      <p class="form-control-static" id="empName_update"></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">email</label>
			    <div class="col-sm-10">
			      <input type="text" name="email" class="form-control" id="email_update" placeholder="email@163.com">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">gender</label>
			    <div class="col-sm-10">
				    <label class="radio-inline">
					  <input type="radio" name="gender" id="gender1_update" value="M" checked> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="gender" id="gender2_update" value="F"> 女
					</label>
				</div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">deptName</label>
			    <div class="col-sm-4">
			    	<select class="form-control" name="dId" id="dept_update">
					</select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="emp_update">更新</button>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- 新增Modal -->
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
				<button type="button" class="btn btn-danger" id="emp_del_modal_btn">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all" />
							</th>
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
		var currentPage;//当前页
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
				dataType: "json",
				success: function(r) {
					console.log(r);
					//var r = eval('(' + result + ')');
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
				var checkBoxTd = $("<td><input type='checkbox' class='check_item' /></td>")
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(item.gender == "M" ? "男" : "女");
				var emailTd = $("<td></td>").append(item.email);
				var deptNameTd = $("<td></td>").append(item.department.deptName);
				
				var eitrBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
								.append("编辑");
				//为编辑按钮添加一个自定义属性，来标识员工ID
				eitrBtn.attr("edit_id", item.empId);
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs del_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
								.append("删除");
				delBtn.attr("del_id", item.empId);
				var btnTd = $("<td></td>").append(eitrBtn)
											.append(" | ")
											.append(delBtn);
				//append方法执行完成以后还是返回定义的元素
				$("<tr></tr>").append(checkBoxTd)
					.append(empIdTd)
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
			currentPage = result.extend.pageInfo.pageNum;
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
		
		//清除表单状态
		function reset_form(ele) {
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}
		
		//点击新增按钮弹出状态框
		$("#emp_add_modal_btn").click(function() {
			//表单重置
			reset_form("#empAddModal form");
			//获取部门信息
			getDepts("#dept_add");
			//弹出状态框
			$("#empAddModal").modal({
				backdrop: "static"
			})
		});
		
		//获取部门信息
		function getDepts(ele) {
			//清空之前下拉列表的值
			$(ele).empty();
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
						optionEle.appendTo(ele);
					})
					//$("#dept_add").append("")
				}
			});
		}
		
		//增加校验
		function vaildate_add() {
			console.log("前端验证。。。");
			var empName = $("#empName_add").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u4e00-\u9fa5]{2,5}$)/;
			if(!regName.test(empName)) {
				//用户名不正确
				show_validate_msg("#empName_add", "error", "用户名为2-5为中文或者6-16位英文")
				return false;
			} else {
				show_validate_msg("#empName_add", "success", "");
			}
			var email = $("#email_add").val();
			var regEmail = 	/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)) {
				//邮箱不正确
				show_validate_msg("#email_add", "error", "邮箱格式不正确");
				return false;
			} else {
				show_validate_msg("#email_add", "success", "");
			}
			return true;
		}
		
		//显示校验结果提示信息
		function show_validate_msg(ele, status, msg) {
			//清除元素的效验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if(status == "success") {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if(status == "error") {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		//姓名文本框发生改变时发送ajax请求验证姓名
		$("#empName_add").change(function() {
			//var empName = this.value;    //当前#empName_add的dom属性，可以直接通过.value获取值
			var empName = $(this).val();   //jquery获取的#empName_add属性的数组，$(this)[0] = this
			$.ajax({
				url: "checkuser",
				type: "post",
				data: "empName=" + empName,
				success: function(result) {
					var result = eval('(' + result + ')');
					if(result.code == 200) {
						show_validate_msg("#empName_add", "success", "用户名可以使用");
						//给保存按钮添加自定义属性和值，让单击保存按钮时进行判断
						$("#emp_save").attr("ajax-va", "success");
					} else {
						show_validate_msg("#empName_add", "error", result.extend.va_msg);
						$("#emp_save").attr("ajax-va", "error");
					}
				}
			})
		});
		
		//模态框保存,点击保存，保存员工数据
		$("#emp_save").click(function() {
			//2、ajax对提交数据进行效验
			if($(this).attr("ajax-va") == "error")
				return false;
			//1、先对要提交的数据进行校验
			/**
			if(!vaildate_add()) {
				return false;
			}
			*/
			//3、增加员工
			$.ajax({
				url: "emp",
				type: "post",
				data: $("#empAddModal form").serialize(),
				success: function(result) {
					var result = eval("(" + result + ")");
					if(result.code == 200) {
						//员工保存成功
						//1、关闭模态框
						$("#empAddModal").modal("hide");
						//2、跳转到最后一页，查询添加信息
						to_page(totalRecord);
					} else {
						console.log(result.extend.errorFields);
						//有哪个错误信息就显示哪个
						if(undefined != result.extend.errorFields.email) {
							//显示邮箱错误信息
							show_validate_msg("#email_add", "error", result.extend.errorFields.email);
						}
						if(undefined != result.extend.errorFields.empName) {
							//显示员工姓名错误信息
							show_validate_msg("#empName_add", "error", result.extend.errorFields.empName);
						}
					}
				}
			})
		})
		
		//增加编辑按钮事件
		$(document).on("click", ".edit_btn", function(){
			//1、获取员工信息，显示员工信息
			getEmp($(this).attr("edit_id"));
			//将员工的ID传递给更新按钮
			$("#emp_update").attr("edit_id", $(this).attr("edit_id"));
			//2、获取部门信息，显示部门信息
			getDepts("#dept_update");
			//3、弹出状态框
			$("#empUpdateModal").modal({
				backdrop: "static"
			})
		})
		
		//获取回显员工信息
		function getEmp(id) {
			$.ajax({
				url: "editEmp/" + id,
				type: "get",
				success: function(result) {
					var result = eval("(" + result + ")");
					console.log(result);
					var empData = result.extend.emp;
					$("#empName_update").text(empData.empName);
					$("#email_update").val(empData.email);
					$("#empUpdateModal input[name='gender']").val([empData.gender]);//单选框选中
					$("#empUpdateModal select").val([empData.dId]);//下拉框选中
				}
			});
		}
		
		//点击更新, 更新员工信息
		$("#emp_update").click(function() {
			//邮箱验证
			var email = $("#email_update").val();
			var regEmail = 	/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)) {
				//邮箱不正确
				show_validate_msg("#email_update", "error", "邮箱格式不正确");
				return false;
			} else {
				show_validate_msg("#email_update", "success", "");
			}
			//发送ajax更新员工信息
			$.ajax({
				url: "editEmp/" + $(this).attr("edit_id"),
				type: "post",
				data: $("#empUpdateModal form").serialize() + "&_method=put",
				success: function(result) {
					var result = eval("(" + result + ")");
					//alert(result.msg);
					//关闭模态框
					$("#empUpdateModal").modal("hide");
					//刷新当前页面
					to_page(currentPage);
				}
			});
		});
		
		//给删除按钮绑定click事件
		$(document).on("click", ".del_btn", function() {
			//弹出是否确认删除对话框
			var empName = $(this).parents("tr").find("td:eq(2)").text();
			if(confirm("确认删除【" + empName + "】吗？")) {
				//确认发送ajax请求删除
				$.ajax({
					url: "emp/" + $(this).attr("del_id"),
					type: "delete",
					success: function(result) {
						to_page(currentPage);
					}
				})
			}
		});
		
		//完成全选全不选功能
		$("#check_all").click(function() {
			//prop修改读取dom原生属性的值
			$(".check_item").prop("checked", $(this).prop("checked"));
		});
		//check_item
		$(document).on("click", ".check_item", function() {
			//判断当前选中的元素是否是五个，是五个则√上check_all
			var flag = $(".check_item:checked").length == $(".check_item").length;
			$("#check_all").prop("checked", flag);
		});
		
		//删除多个用户记录
		$("#emp_del_modal_btn").click(function() {
			var empNames = "";
			var empIds = "";
			$.each($(".check_item:checked"), function() {
				empNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
				//组装员工id字符串
				empIds += $(this).parents("tr").find("td:eq(1)").text() + "-";
			});
			empNames = empNames.substring(0, empNames.length - 1);
			empIds = empIds.substring(0, empIds.length - 1);
			if(confirm("确认删除【" + empNames + "】")) {
				$.ajax({
					url: "emp/" + empIds,
					type: "delete",
					success: function(result) {
						to_page(currentPage);
					}
				});
			}
		});
		
		
	</script>
</body>
</html>