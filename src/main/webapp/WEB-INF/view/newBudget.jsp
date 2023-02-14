<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PEM - New Budget </title>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>  
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
        <script>
            $(document).ready(function () {
                $("#check").click(function () {
                    $.ajax({
                        url: 'check_avail',
                        data: {datef: $("#dfrom").val(), datet: $("#dto").val()},
                        success: function (data) {
                            if (data == "true") {
                                $("#id_res_div").html("You can add Budget.");
                                $('#submit').prop('disabled', false);
                            } else {
                                $("#id_res_div").html(data);
                            }
                        }

                    });
                });
            });
        </script>
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
                    <h3>New Budget</h3>
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
                    <s:url var="url_add"  value="/add_budget"/>
                    <f:form action="${url_add}" modelAttribute="command">
                        <!--`from`, `to`, `amount`, `personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills`-->

                        <table border="1">
                            <tr>
                                <td>Budget From</td>
                                <td><f:input path="budget.from" type="date" id="dfrom"/> </td>
                            </tr>
                            <tr>
                                <td>Budget To</td>
                                <td>
                                    <f:input path="budget.to" type="date" id="dto"/>
                                    <br><button id="check" type="button">Check</button>
                                    <div id="id_res_div" class="error"></div>
                                </td>
                </tr>

                <tr>
                    <td>Personal Care</td>
                    <td><f:input path="budget.personalCare" type="number" min="0" required="true"/> </td>
                </tr>
                <tr>
                    <td>Transportational</td>
                    <td><f:input path="budget.transportational" type="number" min="0" required="true"/> </td>
                </tr>
                <tr>
                    <td>Rent</td>
                    <td><f:input path="budget.rent" type="number" min="0" required="true"/> </td>
                </tr>
                <tr>
                    <td>Food</td>
                    <td><f:input path="budget.food" type="number" min="0" required="true"/> </td>
                </tr>
                <tr>
                    <td>Miscellaneous</td>
                    <td><f:input path="budget.miscellaneous" type="number" min="0" required="true"/> </td>
                </tr>
                <tr>
                    <td>Bills(Electricity,TV,WiFi,etc)</td>
                    <td><f:input path="budget.bills" type="number" min="0" required="true"/> </td>
                </tr>
                <!--                            <tr>
                                                <td>Total Amount</td>
                                                <td id="amount">
                //here input  
                                                    <button id="check" type="button">verify</button>
                                                </td>
                
                                            </tr>-->
                <tr>                                
                    <td colspan="2" align="right">
                        <button type="submit" id="submit" disabled="disabled">Submit</button> <br/>  
                        
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
