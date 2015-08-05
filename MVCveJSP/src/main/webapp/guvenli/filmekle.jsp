<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.getServletContext().setAttribute("sayfa","filmekle");%>
<jsp:include page="/hader.jsp"></jsp:include>
    
    
<p>Film Ekle</p>
${pageContext.servletContext.contextPath}
  
<jsp:include page="/footer.jsp"></jsp:include>