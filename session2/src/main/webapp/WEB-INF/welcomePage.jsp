<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${welcome.title}</title>
</head>
<body BGCOLOR=#FDF5E6>
	<H1 ALIGN=CENTER>${welcome.title}</H1>
	<HR>
	<h2>We have the following functions:</h2>
	<p><a href="${welcome.url}/kidsBooksPage">Kids Books</a></p>
	<p><a href="${welcome.url}/techBooksPage">Tech Books</a></p>
	<p><a href="${welcome.url}/orderPage">Order Page</a></p>
</body>
</html>