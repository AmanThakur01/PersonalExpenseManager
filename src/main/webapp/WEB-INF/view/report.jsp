<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>  
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
    </head>
    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">

        window.onload = function () {

            var options = {
                title: {
                    text: "Budget Report"
                },
                subtitles: [{
                        text: "Total Budget : " +${budget.getAmount()}
                    }],
                animationEnabled: true,
                data: [{
                        type: "pie",
                        startAngle: 40,
                        toolTipContent: "<b>{label}</b>: {y}Rs.",
                        showInLegend: "true",
                        legendText: "{label}",
                        indexLabelFontSize: 16,
                        indexLabel: "{label} - {y}Rs.",
                        dataPoints: [
                            {y:${budget.getPersonalCare()}, label: "Personal Care"},
                            {y: ${budget.getTransportational()}, label: "Transportational"},
                            {y: ${budget.getRent()}, label: "Rent"},
                            {y: ${budget.getFood()}, label: "Food"},
                            {y: ${budget.getMiscellaneous()}, label: "Miscellaneous"},
                            {y: ${budget.getBills()}, label: "Bills"}
                        ]
                    }]
            };
            $("#reportChart").CanvasJSChart(options);
        }
    </script>
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
                <td>
                    <div id="reportChart" style="width: 100%; height: 300px;display: inline-block;"></div>
                </td>
            </tr>
<!--            <tr>
                <td height="350px" valign="top">
                    <h3>Budget Report</h3>
                    <table border="1" cellpadding="3"  width="100%">
                        <tr>
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
                            <tr>
                                <td>${e.sr}</td>
                                <td>${e.date}</td>
                                <td>${e.category}</td>
                                <td>${e.amount}</td>
                                <td>${e.remark}</td>

                            </tr> 
                        </c:forEach>
                    </table>

                </td>
            </tr>-->
            <tr>
                <td height="25px">
                    <%-- Footer --%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
