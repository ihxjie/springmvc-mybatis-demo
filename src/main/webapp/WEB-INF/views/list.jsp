<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Captivate
  Date: 2019/12/5
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>pageHelperTest</h3>
<table width="200" border="1">
    <tr>
        <th scope="col">名称</th>
        <th scope="col">原价</th>
        <th scope="col">现价</th>
        <th scope="col">库存</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="product">
        <tr>
            <td>${product.productName}</td>
            <td>${product.productOriginalPrice}</td>
            <td>${product.productCurrentPrice}</td>
            <td>${product.productStock}</td>
        </tr>
    </c:forEach>
</table>
<p>
    当前${pageInfo.pageNum}页,总${pageInfo.pages}页,总${pageInfo.total}条记录
</p>
<ul>
    <li>
        <a href="list?pageNo=${pageInfo.firstPage}">首页</a>
    </li>

        <c:if test="${pageInfo.hasPreviousPage}">
            <li>
        </c:if><c:if test="${pageInfo.hasPreviousPage}">

        </c:if>
            <a href="list?pageNo=${pageInfo.pageNum-1}">上一页</a>
    </li>
    <li>

    </li>
    <c:forEach begin="1" end="${pageInfo.pages}" var="i">
        <c:if test="${pageInfo.pageNum == i}">
         <li class="active"> <a href="list?pageNo=${i}">${i}</a> </li>
    </c:if><c:if test="${pageInfo.pageNum != i}">
        <li> <a href="pr?pageNo=${i}">${i}</a> </li>
    </c:if>
    </c:forEach>
        <c:if test="${pageInfo.hasNextPage}">
            <li>
        </c:if><c:if test="${pageInfo.hasNextPage}">
            <li class="disabled">
            </c:if>
            <a href="list?pageNo=${pageInfo.pageNum+1}">下一页</a>
        </li>
    <li>
        <a href="list?pageNo=${pageInfo.lastPage}">末页</a>
    </li>
</ul>

</body>
</html>
