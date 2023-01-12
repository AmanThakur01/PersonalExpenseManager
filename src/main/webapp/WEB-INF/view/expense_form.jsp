<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PEM - New Expense </title>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>  
    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"/>
<body background="${url_bg}">
    <table border="1" width="80%" align="center">
        <tr>
            <td height="80px">
                <%-- Header --%>
                <jsp:include page="include/header.jsp"/>
            </td>
        </tr>
        <tr>
            <td height="25px">
                <%-- Menu --%>
                <jsp:include page="include/menu.jsp"/>
            </td>
        </tr>
        <tr>
            <td height="350px" valign="top">
                <%-- Page Content Area--%>
                <h3>Expense</h3>
        <c:if test="${err!=null}">
            <p class="error">${err}</p>
        </c:if>   
        <c:if test="${param.act eq 'reg'}">
            <p class="success">Expense Registered Successfully.</p>
        </c:if>  
        <s:url var="url_add"  value="/add_expense"/>
        <f:form action="${url_add}" modelAttribute="command">
            <!--`date`, `category`, `amount`, `remark`-->
            <table border="1">
                <tr>
                    <td>Date</td>
                    <td><f:input path="date" type="date"/> </td>
                </tr>
                <tr>
                    <td>Category</td>
                    <td>
                <f:select path="category">  
                    <!--`personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills`-->

                    <f:option value="personalCare" label="Personal Care"/>  
                    <f:option value="transportational" label="Transport"/>  
                    <f:option value="rent" label="Rent"/>  
                    <f:option value="food" label="Food"/>  
                    <f:option value="miscellaneous" label="Miscellaneous"/>  
                    <f:option value="bills" label="Bills"/>  
                </f:select>  
                </td>
                </tr>
                <tr>
                    <td>Amount</td>
                    <td><f:input path="amount" type="number"/> </td>
                </tr>
                <tr>
                    <td>Remark</td>
                    <td><f:textarea path="remark"/> </td>
                </tr>
                <tr>                                
                    <td colspan="" align="right">
                        <button type="submit">Save</button> <br/>                                  
                    </td>
                    <td colspan="" align="right">
                        <button type="reset">Reset</button> <br/>                                  
                    </td>
                </tr>                   

            </table>
        </f:form>
    </td>
</tr>
<tr>
    <td height="25px">
        <%-- Footer --%>
        <jsp:include page="include/footer.jsp"/>
    </td>
</tr>
</table>
</body>
</html>
