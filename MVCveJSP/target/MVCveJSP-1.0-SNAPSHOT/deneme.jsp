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
    
	<div id="templatemo_menuleft"></div>    
	<div id="templatemo_menu">
            <ul>
            <li><a href="/MVCveJSP/index.jsp" class="current">Ana Sayfa</a></li>
            <li><a href="/MVCveJSP/hakkimizda.jsp" >Hakkımızda</a></li>
            <c:choose>
                <c:when test="${empty KId}">
                    <li><a href="/MVCveJSP/giris.jsp">Giriş</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="guvenli/filmekle.jsp">Film Ekle</a></li>
                    <li><a href="/MVCveJSP/cikis">Çıkış</a></li>    
                    <li>${sessionScope.Adi}&nbsp${sessionScope.Soyadi}</li>
                </c:otherwise>
            </c:choose> 
            </ul>    	
    	</div>
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
        	<h1>Welcome to our music corner</h1>
		<p>asdasdasd</p>
                <div class="news_section">            
                <h2>News</h2>
                
                <h3>news title one</h3>
                <p>Sed nec est. Suspendisse a nibh tristique justo rhoncus volutpat. Suspendisse vitae neque eget ante tristique vestibulum.</p>
                <div class="more"><a href="#">more</a></div>
                
                <h3>news title two</h3>
                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Ut iaculis lacinia purus. </p>
                <div class="more"><a href="#">more</a></div>
                </div>
            
                <div class="promotion_section">         
                    <h2>Promotion</h2>   
                    <img src="images/templatemo_speaker.jpg" alt="photo" title="photo title" />
                    <p>Duis vitae velit sed dui malesuada dignissim. Donec mollis aliquet ligula. Duis vitae velit sed dui malesuada dignissim.</p><div class="more"><a href="#">more</a></div>
                </div>
            </div>
	</div>
	<div id="templatemo_footer">
		<a href="#">Home</a> | <a href="#">About Us</a> | <a href="#">Prices</a> | <a href="#">Member</a> | <a href="#">Contact Us</a><br />
        Copyright © 2048 <a href="#">Your Company Name</a> | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_blank">templatemo.com</a>
	</div>

</div>
</div>
</body>
</html>
