<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="array" method="post">
name:<input type="text" name="name"/> <br/>

address 1:<input type="text" name="addresses[0].location" id="location0"/> <input type="text" name="addresses[0].postcode" id="postcode0"/> <br/>
address 1:<input type="text" name="addresses[1].location"" id="location1"/> <input type="text" name="addresses[1].postcode" id="postcode1"/> <br/>
<form:input path="addresses[0].location" />
<input type="submit">
</form>
</body>
</html>