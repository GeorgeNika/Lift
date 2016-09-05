<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 31.08.2016
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach items="${solution}" var="step">
<span>
    Next Step: start position - <c:out value="${step.moveStep.startPot}"/> &nbsp;
    <%--bal - <c:out value="${step.moveStep.movedBall}"/> &nbsp;--%>
    target position - <c:out value="${step.moveStep.endPot}"/>
    <br/>
</span>

</c:forEach>
</body>
</html>
