<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.getServletContext().setAttribute("sayfa","anasayfa");%>
<jsp:include page="hader.jsp"></jsp:include>

    
<p>Merhaba Film istesine hoşgeldiniz.</p>

${pageContext.servletContext.contextPath}

  
<jsp:include page="footer.jsp"></jsp:include>