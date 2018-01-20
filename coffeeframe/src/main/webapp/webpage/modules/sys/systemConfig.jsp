<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>系统配置管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function(){

		$("#inputForm").validate({  
	        rules: {  
			mailName: {  
	    required: true,  
	    email: true  
	   }}});


	});
	function modifyMail(){
		if($("#inputForm").valid() == false){
			return;
		}
		$.ajax({
	        async: false,
	        url: "${ctx}/sys/systemConfig/save",
	        data:{"smtp":$("#smtp").val(),"port":$("#port").val(),"mailName":$("#mailName").val(),"mailPassword":$("#mailPassword").val()},
	        dataType: "json",
	        success: function (data) {
	    	    if(data.success){
	    	    	top.layer.alert("更新成功！");
	    	    }else{
	    	    	top.layer.alert("更新失败！");
	    	    }
	        }
		});
	}

	function modifySms(){
		$.ajax({
	        async: false,
	        url: "${ctx}/sys/systemConfig/save",
	        data:{"smsName":$("#smsName").val(),"smsPassword":$("#smsPassword").val()},
	        dataType: "json",
	        success: function (data) {
	    	    if(data.success){
	    	    	top.layer.alert("更新成功！");
	    	    }else{
	    	    	top.layer.alert("更新失败！");
	    	    }
	        }
		});
	}
	</script>
</head>
<body class="skin-coffee gray-bg">
	<div class="wrapper wrapper-content">
		<div class="ibox">
			<div class="ibox-content coffee-content">
				<h2 class="coffee-title">系统配置</h2>
				<div class="row">
					<div class="col-sm-6">
						<form:form id="inputForm" modelAttribute="systemConfig"
							action="${ctx}/sys/systemConfig/save" method="post">
							<div class="panel coofee-panel">
								<div class="panel-heading">
									<i class="fa fa-envelope"></i> 系统邮箱设置
									<div class="pull-right">
										<a href="#" onclick="modifyMail()"><i class="fa  fa-save"></i></a>
									</div>
								</div>
								<div class="panel-body">
									<table class="table">
										<tbody>
											<tr>
												<td class="width-15 active"><label class="table-label">邮箱服务器地址</label></td>
												<td class="width-35"><form:input path="smtp"
														htmlEscape="false" maxlength="64" class="input-text" /></td>
											</tr>
											<tr>
												<td class="width-15 active"><label class="table-label">邮箱服务器端口</label></td>
												<td class="width-35"><form:input path="port"
														htmlEscape="false" maxlength="64" class="input-text" /></td>
											</tr>
											<tr>
												<td class="width-15 active"><label class="table-label">系统邮箱地址</label></td>
												<td class="width-35"><form:input path="mailName"
														htmlEscape="false" maxlength="64" class="input-text" /></td>
											</tr>
											<tr>
												<td class="width-15 active"><label class="table-label">系统邮箱密码</label></td>
												<td class="width-35"><form:password path="mailPassword"
														htmlEscape="false" maxlength="64"
														class="input-text required" /></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</form:form>
					</div>
<%-- 					<div class="col-sm-6">
						<form:form id="inputForm1" modelAttribute="systemConfig"
							action="${ctx}/sys/systemConfig/save" method="post">
							<div class="panel coofee-panel">
								<div class="panel-heading">
									<i class="fa fa-comment"></i> 短信设置(<a
										href="http://www.cnsms.cn/" target="_blank"><font>企信通</font></a>)
									<div class="pull-right">
										<a href="#" onclick="modifySms()"><i
											style="font-size: 20px" class="fa  fa-save"></i></a>
									</div>
								</div>
								<div class="panel-body">
									<table class="table">
										<tr>
											<td class="width-15 active"><label class="table-label">短信用户名</label></td>
											<td class="width-35"><form:input path="smsName"
													htmlEscape="false" maxlength="64" class="input-text" /></td>
										</tr>
										<tr>
											<td class="width-15 active"><label class="table-label">短信密码</label></td>
											<td class="width-35"><form:password path="smsPassword"
													htmlEscape="false" maxlength="64" class="input-text" /></td>
										</tr>
									</table>
								</div>
							</div>

						</form:form>
					</div> --%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>