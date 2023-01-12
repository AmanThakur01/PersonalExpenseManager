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
                    <h3>Budget List</h3>
                    
                    <c:if test="${param.act eq 'del'}">
                        <p class="success">Budget Deleted Successfully</p>
                    </c:if>


                    <table width="100%">
                        <tr>
                            <td align="right" >
                                <form action="<s:url value="/budget_search"/>">
                                    <input type="text" name="freeText" value="${param.freeText}" placeholder="Enter Text To Search">
                                    <button>Find</button>
                                </form>
                            </td>                           
                        </tr>
                    </table>
                    <s:url var="url_bdelete" value="/bulk_bdelete"/>
                    <form action="${url_bdelete}">           
                        <button>Delete Selected Records</button> <br/><br/>
                        <table border="1" cellpadding="3"  width="100%">
                            <tr>
                           <!--`from`, `to`, `amount`, `personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills`-->
                                <th>SELECT</th>
                                <th>BUDGET FROM</th>
                                <th>BUDGET TO</th>
                                <th>AMOUNT</th>
                                <th>PERSONAL CARE</th>
                                <th>TRANSPORTATIONAL</th>
                                <th>RENT</th>
                                <th>FOOD</th>
                                <th>MISCELLANEOUS</th>
                                <th>BILLS</th>
                            </tr>

                            <c:if test="${empty budgetList}">
                                <tr>
                                    <td align="center" colspan="10" class="error">No Records Present</td>
                                </tr>
                            </c:if>

                            <c:forEach var="b" items="${budgetList}" varStatus="st">
                                <tr>
                                    <td align="center"><input type="checkbox" name="bid" value="${b.from}"/></td>
                                    <td>${b.from}</td>
                                    <td>${b.to}</td>
                                    <td>${b.amount}</td>
                                    <td>${b.personalCare}</td>
                                    <td>${b.transportational}</td>
                                    <td>${b.rent}</td>
                                    <td>${b.food}</td>
                                    <td>${b.miscellaneous}</td>
                                    <td>${b.bills}</td>
                                    <s:url var="url_del" value="/del_budget">
                                        <s:param name="bid" value="${b.from}"/>
                                    </s:url>   
                                    <s:url var="url_report" value="/report_budget">
                                        <s:param name="bid" value="${b.from}"/>
                                    </s:url> 
                                    <td><a href="${url_del}">Delete</a> | <a href="${url_report}">Report</a></td>
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
