<%@page import="com.dao.TurDao"%>
<%@page import="com.entity.Turler"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div id="templatemo_menuleft"></div>    
	<div id="templatemo_menu">
            <ul>
            <li><a href="${pageContext.servletContext.contextPath}/index.jsp"           class="<c:if test="${sayfa eq 'anasayfa'}">current</c:if>"    >Ana Sayfa</a></li>    
            <li><a href="${pageContext.servletContext.contextPath}/hakkinda.jsp"      class="<c:if test="${sayfa eq 'hakkinda'}">current</c:if>"   >Hakkımızda</a></li>
            <c:choose>
                <c:when test="${empty KId}">
                    <li><a href="${pageContext.servletContext.contextPath}/giris.jsp"   class="<c:if test="${sayfa eq 'giris'}">current</c:if>"       >Giriş</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.servletContext.contextPath}/guvenli/filmekle.jsp"  class="<c:if test="${sayfa eq 'filmekle'}">current</c:if>"    >Film Ekle</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/cikis">Çıkış</a></li>    
                    <li>${sessionScope.Adi}&nbsp${sessionScope.Soyadi}</li>
                </c:otherwise>
            </c:choose> 
            </ul>    	
    	</div>