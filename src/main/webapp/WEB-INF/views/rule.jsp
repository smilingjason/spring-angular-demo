<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%-- 
JSTL form:
<form:form modelAttribute="rule" action="save">
Rule Name ${ rule.name } <br/>
Condition: <br/>
<table border="1">
<tr>
    <td>No</td>
    <td>System parameter</td>
    <td>comparison</td>
    <td>value</td>   
    <td>start</td> 
    <td>end</td>       
  </tr>
<c:forEach items="${rule.conditions}" var="condition" varStatus="status">    
  <tr>
     <td>${status.count}</td>
     <c:choose> 
    	<c:when test="${condition.getFlag() == 1}">
    		<td>Current Resource Value</td> 
    	</c:when>
    	<c:when test="${condition.getFlag() == 2}">
    		<td>Current System time</td> 
    	</c:when>
    	 <c:otherwise>
    	 	<td>unknown</td> 
    	 </c:otherwise>
    </c:choose>
    <c:choose>
    	<c:when test="${condition.getFlag() == 1}">
    		<td>${condition.getComparison()}</td> 
    		<td>${condition.getValue()}</td> 
    	</c:when>    	
    	 <c:otherwise>
    	 	<td>-</td> 
    	 	<td>-</td> 
    	 </c:otherwise>
    </c:choose>
    <c:choose>
    	<c:when test="${condition.getFlag() == 2}">
    		<td>${condition.getStart()}</td> 
    		<td>${condition.getEnd()}</td> 
    	</c:when>    	
    	 <c:otherwise>
    	 	<td>-</td> 
    	 	<td>-</td> 
    	 </c:otherwise>
    </c:choose>
  </tr>
</c:forEach>
<table>
<br/><hr/>
</form:form>
--%>
<br/><hr/>
Spring forms: <br/>

<form:form modelAttribute="rule" action="save">
Rule Name <form:input path="name" /> <br/>

Conditions: <br/>
<table border="1">
<tr>
    <td>No</td>
    <td>System parameter</td>
    <td>comparison</td>
    <td>value</td>   
    <td>start</td> 
    <td>end</td>       
  </tr>
<c:forEach items="${rule.conditions}" var="condition" varStatus="loop">
<tr>
	<td> ${loop.count} </td>
	<td>
	<form:select path="conditions[${loop.index}]" >
		<form:option value="" label="---Select---" />
        <form:options items="${system_params}" />
	</form:select>
	</td>
	
	<c:choose>
    	<c:when test="${condition.getFlag().equals(\"1\")}">
    		<td><form:input path="conditions[${loop.index}].comparison" size="5"/></td>
    		<td><form:input path="conditions[${loop.index}].value" size="5"/></td>
    	</c:when>    	
    	 <c:otherwise>
    	 	<td><input id="conditions${loop.index}.comparison" name="conditions[${loop.index}].comparison" type="text" value="" size="5"/></td>
    	 	<td><input id="conditions${loop.index}.value" name="conditions[${loop.index}].value" type="text" value="" size="5"/></td>
    	 </c:otherwise>
    </c:choose>
    <c:choose>
    	<c:when test="${condition.getFlag().equals(\"2\")}">
    		<td><form:input path="conditions[${loop.index}].start" size="15"/></td>
    		<td><form:input path="conditions[${loop.index}].end" size="15"/></td>
    	</c:when>    	
    	 <c:otherwise>
    	 	<td><input id="conditions${loop.index}.start" name="conditions[${loop.index}].start" type="text" value="" size="15"/></td>
    		<td><input id="conditions${loop.index}.end" name="conditions[${loop.index}].end" type="text" value="" size="15"/></td>
    	 </c:otherwise>
    </c:choose>
</tr>
</c:forEach>
 <tr>
 		<td>${rule.conditions.size() + 1}</td> 
    	<td>
    	
    	<select name="conditions[${rule.conditions.size()}]" >
		
        <option value="" selected="selected" >---Select---</option>
		<option value="1">Current Resource Value</option>
		<option value="2">System time</option>

		<select>
		</td> 
    		<td><input id="conditions${rule.conditions.size()}.comparison" name="conditions[${rule.conditions.size()}].comparison" type="text" value="" size="5"/></td>
    		<td><input id="conditions${rule.conditions.size()}.value" name="conditions[${rule.conditions.size()}].value" type="text" value="" size="5"/></td>
    	   	<td><input id="conditions${rule.conditions.size()}.start" name="conditions[${rule.conditions.size()}].start" type="text" value="" size="15"/></td>
    	 	<td><input id="conditions${rule.conditions.size()}.end" name="conditions[${rule.conditions.size()}].end" type="text" value="" size="15"/></td>
    </tr>
</table>
<input type="submit" value="Save"/>
</form:form>
</body>
</html>
