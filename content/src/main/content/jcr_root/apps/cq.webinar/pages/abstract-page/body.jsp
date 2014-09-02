<%@page session="false"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/libs/foundation/global.jsp" %>

<body>
    <!-- A JSP based page -->
    <title>${properties["jcr:title"]}</title>

    <h2> Sightly simple example </h2>
        <cq:include path="headerTitle" resourceType="cq.webinar/components/global/glb-header-logo"/>
    <br>

</body>