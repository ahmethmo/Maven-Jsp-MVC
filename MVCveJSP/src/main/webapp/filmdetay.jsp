<%@page import="com.entity.Filmler"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.getServletContext().setAttribute("sayfa","anasayfa");%>

<jsp:include page="hader.jsp"></jsp:include>
    <h3>${film.adi}</h3>
    <table border="1">
        <tr><td>Filmin Yılı:</td>      <td>${film.yili}</td></tr>
        <tr><td>Filmin Yönetmeni:</td> <td>${film.yonetmen.adi}</td></tr>
        <tr><td>Filmin Türü</td>       <td>${film.tur.adi}</td></tr>
    </table>

    <c:if test="${favvar eq 0}">
        <br/><br/>
        <a href="favoriekle?FId=${film.FId}">Filmi Favorilerine Ekle</a>
    </c:if>
<jsp:include page="footer.jsp"></jsp:include>