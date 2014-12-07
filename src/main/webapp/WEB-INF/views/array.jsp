<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>


<P>  username: ${user.name}. </P>

Address: <br/>
<table border="1">
<tr>
    <td>location</td>   
    <td>post code</td> 
    <td>type</td> 
    <td>mobile</td>
    <td>email</td>    
  </tr>
<c:forEach items="${user.addresses}" var="element">    
  <tr>
    <td>${element.getLocation()}</td>   
    <td>${element.getPostcode()}</td> 
    <td>${element.getFlag()}</td> 
   
    <c:choose> 
    	<c:when test="${element.getFlag() == 0}">
    		<td>${element.getMobile()}</td> 
    	</c:when>
    	 <c:otherwise>
    	 	<td>-</td> 
    	 </c:otherwise>
    </c:choose>
    <c:choose>
    	<c:when test="${element.getFlag() == 1}">
    		<td>${element.getEmail()}</td> 
    	</c:when>
    	 <c:otherwise>
    	 	<td>-</td> 
    	 </c:otherwise>   
    
    </c:choose>
    
  </tr>
</c:forEach>
<table>
<br/><hr/>
<%-- 
<form:form modelAttribute="user" action="array">
Name <form:input path="name" /> <br/>
Address: <form:input path="address.location" /><form:input path="address.postcode" />
<br>
Addresses: <br/>
<table>
<c:forEach items="${user.addresses}" var="address" varStatus="loop">
<tr>
	<td> ${loop.count} </td>
	
	<td><form:input path="addresses[${loop.index}].location" /></td>
	<td><form:input path="addresses[${loop.index}].postcode" /></td>
	<td><form:input path="addresses[${loop.index}].flag" /></td>
	<c:if test="${address.getFlag() == 0}">
    	<td><form:input path="addresses[${loop.index}].mobile" /></td>
    </c:if>  
    <c:if test="${address.getFlag() == 1}">
    	<td><form:input path="addresses[${loop.index}].email" /></td>
    </c:if>
</tr>
</c:forEach>
</table>
<input type="submit" value="Save"/>
</form:form>
--%>
</body>
</html>
