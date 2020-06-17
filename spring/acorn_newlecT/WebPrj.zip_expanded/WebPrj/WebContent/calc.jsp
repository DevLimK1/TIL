<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		int x = 0;
		int y = 0;
		
		String x_ = request.getParameter("x");
		if(x_ != null && !x_.equals(""))
			x = Integer.parseInt(x_);
		
		String y_ = request.getParameter("y");
		if(y_ != null && !y_.equals(""))
			y = Integer.parseInt(y_);
			
		
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="calc.jsp" method="post">
		<fieldset>
			<legend>덧셈을 위한 입력</legend>
			<label>x</label>
			<input type="text" name="x">
			<label>y</label>
			<input type="text" name="y">
			<input type="submit" value="덧셈">
			<span><%=x+y%></span>
		</fieldset>
	</form>
</body>
</html>