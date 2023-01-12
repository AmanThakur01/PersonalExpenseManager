<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>


<s:url var="url_expense" value="/expense_form"/>
<s:url var="url_new_budget" value="/new_budget"/>
<s:url var="url_index" value="/index"/>
<s:url var="url_view_budget" value="/view_Budget"/>
<s:url var="url_report" value="/report"/>
<a href="${url_index}">Home</a> | <a href="${url_new_budget}">New Budget</a> | 
<a href="${url_expense}">New Expense</a> | <a href="${url_view_budget}">View Budget</a> | 
<a href="${url_report}">Report</a> | <a href="#">Help</a>   


