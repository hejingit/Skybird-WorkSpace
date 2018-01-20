<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="验证码输入框名称"%>
<%@ attribute name="inputCssStyle" type="java.lang.String" required="false" description="验证框样式"%>
<%@ attribute name="imageCssStyle" type="java.lang.String" required="false" description="验证码图片样式"%>
<%@ attribute name="inputClass" type="java.lang.String" required="false" description="验证框样式类"%>
<%@ attribute name="imageClass" type="java.lang.String" required="false" description="验证码图片样式类"%>
<%@ attribute name="buttonCssStyle" type="java.lang.String" required="false" description="看不清按钮样式"%>
<input type="text" id="${name}" name="${name}" maxlength="4" class=" required login-input login-yzm" style="${inputCssStyle}"/>
<img src="${pageContext.request.contextPath}/servlet/validateCodeServlet" onclick="$('.${name}Refresh').click();" class=" ${name} yzm-img" style="${imageCssStyle}"/>
<a href="javascript:" onclick="$('.${name}').attr('src','${pageContext.request.contextPath}/servlet/validateCodeServlet?'+new Date().getTime());" class="mid ${name}Refresh" style="${buttonCssStyle}"></a>