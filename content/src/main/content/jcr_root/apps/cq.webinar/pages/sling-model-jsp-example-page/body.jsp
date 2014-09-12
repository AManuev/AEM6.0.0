<%@page session="false" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/libs/foundation/global.jsp" %>
<%
    slingRequest.setAttribute("requestDescription", "Something");
%>

<!-- NOTE: You should manually change version os Sling tag library in global.jsp -->
<sling2:adaptTo adaptable="${resource}" adaptTo="com.epam.webinar.sling.model.SlingModel" var="model"/>
<body>

    <!-- A JSP Sling Model based page
     NOTE: show section in POM.XML where package as added to MANIFEST.MF
     -->
    <h3>1.Example with tag.</h3>
    <div>
        Page title from Sling model in JSP: <b><i>${model.title}</i></b>
    </div>
    <br><br><br>
    <h3>2.Example with function.</h3>
    <div>
        <c:set var="model2" value="${sling2:adaptTo(resource, 'com.epam.webinar.sling.model.SlingExtendedModel')}" />
        Page title from Sling model in JSP: <b><i>[${model2.title}]</i></b><br>
        Description: <b><i>[${model2.description}]</i></b><br>
        DefaultTitle:<b><i>[${model2.defaultTitle}]</i></b><br>
        Integers:<b><i>[${fn:join(model2.array, ', ')}]</i></b><br>
        Repository name:<b><i>[${model2.repositoryName}]</i></b><br>
    </div>
    <br><br><br>
    <h3>3.Example with model based on interface.</h3>
    <div>
        <sling2:adaptTo adaptable="${slingRequest}" adaptTo="com.epam.webinar.sling.model.SlingThirdModel" var="model3"/>
        Property my description: <b><i>[${model3.myDescription}]</i></b><br>
        Current Resource: <b><i>[${model3.resource.path}]</i></b><br>
        Property my request: <b><i>[${model3.requestDescription}]</i></b><br>
    </div>

</body>
