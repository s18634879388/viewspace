<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/18
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h1>请选择文件</h1>
    <form method="post" action="<c:url value="/upload.html"/>" enctype="multipart/form-data">
        <input type="text" name="name">
        <input type="file" name="file">
        <input type="submit">
    </form>
</body>
</html>
