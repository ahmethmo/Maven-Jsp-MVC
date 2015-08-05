<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.getServletContext().setAttribute("sayfa","giris");%>
<jsp:include page="hader.jsp"></jsp:include>

    
    <c:if test="${not empty mesaj}">
        <p style="color: gold">${mesaj}</p>
    </c:if>
    
    <div class="templatemo_section2">
        <h1>Kullanıcı Girişi</h1>
        <form method="post" action="giris">
            <p>Kullanıcı Adı&nbsp;:
            <input name="kullaniciadi" type="text"/></p>
            <p>Şifre&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
            <input name="sifre" type="password"/><p>
            <input class="button" type="submit" value="&nbsp;&nbsp;&nbsp;Giriş&nbsp;&nbsp;&nbsp;" />
        </form>
    </div>
    
<jsp:include page="footer.jsp"></jsp:include>
