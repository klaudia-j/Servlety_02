<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int number1 = 0; %>
	<form action="add_to_cookie" method="POST">
	    <label>
	        Klucz:
	        <input type="text" name="key">
	    </label>
	    <label>
	        Wartość:
	        <input type="text" name="value">
	    </label>
	<% System.out.println("działa"); 
		request.setAttribute("number1", number1); //!!!!!!! nie ma dostępu do bezpośrednio do zmiennych, musi być atrybut
	%>
	<select>
	<% int counter = 10;
		for (int i=0; i<counter; i++){ %> 
		<option><%= i %></option>
	<%}%>
	</select>
	<input type="submit">
	</form>
	<%= new Date() %>
	<br>
	<%-- <%= out.println(new Date()); %> --%>
	<% int number2 = 0; %>
	<br>
	<%= number1++ %>
	<br>
	<%= number2++ %>
	<br>
	<p>${number1}</p>
</body>
</html>