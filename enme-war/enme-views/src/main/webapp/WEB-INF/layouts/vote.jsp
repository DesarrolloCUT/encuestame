<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>
  <c:if test="${detectedDevice}">
     <%@ include file="mobile/vote.jsp"%>
  </c:if>

  <c:if test="${!detectedDevice}">
     <%@ include file="web/vote.jsp"%>
  </c:if>