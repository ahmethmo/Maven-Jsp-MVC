<%@page import="com.dao.TurDao"%>
<%@page import="com.entity.Turler"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    ArrayList<Turler> turler=new TurDao().ButunTurleriGetir();
    request.setAttribute("turler", turler);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Music Note - Free Website Template</title>
<meta name="keywords" content="music note, free template, website template, CSS, XHTML" />
<meta name="description" content="Music Note - free CSS template provided by templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="templatemo_container_wrapper">
<div id="templatemo_container"> 
	<div id="templatemo_header">
		<div id="templatemo_site_title">Favori<span>FİLM</span></div>
        	<div id="templatemo_site_slogan">Filmini seç</div>
	</div>

        <jsp:include page="menu.jsp"></jsp:include>
	<div id="templatemo_content">	
            <div id="templatemo_left_column">
		<div class="templatemo_section2">
                    <h1>Türler</h1>
                    <c:forEach items="${turler}" var="tur">
                        <a href="/MVCveJSP/filmler?TId=${tur.TId}">${tur.adi}</a><br/>
                    </c:forEach>
            	</div>    
                <c:if test="${not empty sessionScope.favfilmler}">
                    <div class="templatemo_section2">
                    <h1>Favoriler</h1>
                    <c:forEach items="${sessionScope.favfilmler}" var="fav">
                        <a href="/MVCveJSP/filmdetay?FId=${fav.FId}">${fav.adi}</a>&nbsp;-&nbsp;
                        <a href="/MVCveJSP/filmcikar?FId=${fav.FId}">X</a><br/>
                    </c:forEach>
                    </div>    
                </c:if>
            </div>
        
            <div id="templatemo_right_column">