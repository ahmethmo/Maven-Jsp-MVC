<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.getServletContext().setAttribute("sayfa","anasayfa");%>

<jsp:include page="hader.jsp"></jsp:include>
    <c:choose>
        <c:when test="${not empty filmler}">
            <div class="news_section">            
                <h2>${tur}</h2>
                <c:forEach items="${filmler}" var="film">
                    <a href="filmdetay?FId=${film.FId}">${film.adi}</a><br/>
                </c:forEach> 
            </div>
        </c:when>
        <c:otherwise>
            <h2>Bu kategorite henüz bi film eklenmemiştir.</h2>
        </c:otherwise>
    </c:choose> 
            
<jsp:include page="footer.jsp"></jsp:include>
