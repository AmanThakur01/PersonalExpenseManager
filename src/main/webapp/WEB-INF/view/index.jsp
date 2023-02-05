<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PEM - Personal Expense Manager </title>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>  
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
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
                    <h3>Expense List</h3>
                    <c:if test="${param.act eq 'reg'}">
                        <p class="success">Budget Registered Successfully.</p>
                    </c:if> 
                     
                    <c:if test="${param.act eq 'sv'}">
                        <p class="success">Expense Saved Successfully</p>
                    </c:if>
                    <c:if test="${param.act eq 'del'}">
                        <p class="success">Expense Deleted Successfully</p>
                    </c:if>
                    <c:if test="${param.act eq 'nr'}">
                        <p class="success">No Report Found For This Month</p>
                    </c:if>
                    <c:if test="${param.act eq 'ag'}">
                        <p class="success">Try Again!!!</p>
                    </c:if>


                    <table width="100%">
                        <tr>
                            <td align="right" >
                                <form action="<s:url value="/expense_search"/>">
                                    <input type="text" name="freeText" value="${param.freeText}" placeholder="Enter Text To Search">
                                    <button>Find</button>
                                </form>
                            </td>                           
                        </tr>
                    </table>

                    <form action="<s:url value="/bulk_edelete"/>">           
                        <button>Delete Selected Records</button> <br/><br/>
                        <table border="1" cellpadding="3"  width="100%">
                            <tr>
                                <th>SELECT</th>
                                <th>ID</th>
                                <th>DATE</th>
                                <th>CATEGORY</th>
                                <th>AMOUNT</th>
                                <th>REMARK</th>
                            </tr>

                            <c:if test="${empty expenseList}">
                                <tr>
                                    <td align="center" colspan="8" class="error">No Records Present</td>
                                </tr>
                            </c:if>

                            <c:forEach var="e" items="${expenseList}" varStatus="st">
                                <input type="hidden" name="eid" value="-1"/>
                                <tr>
                                    <td align="center"><input type="checkbox" name="eid" value="${e.sr}"/></td>
                                    <td>${e.sr}</td>
                                    <td>${e.date}</td>
                                    <td>${e.category}</td>
                                    <td>${e.amount}</td>
                                    <td>${e.remark}</td>
                                    <s:url var="url_del" value="/del_expense">
                                        <s:param name="eid" value="${e.sr}"/>
                                    </s:url>   
                                    <s:url var="url_edit" value="/edit_expense">
                                        <s:param name="eid" value="${e.sr}"/>
                                    </s:url> 
                                    <td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>
                                </tr> 
                            </c:forEach>
                        </table>
                    </form>     
                
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
