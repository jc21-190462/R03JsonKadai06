<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>

<%
Optional<List<String[]>> optList = Optional.ofNullable((List<String[]>) request.getAttribute("list"));
List<String[]> list = new ArrayList<>();
if (optList.isPresent()) {
	list = optList.get();
}
%>
{"POINT":3580}
<%
for (String[] s : list) {
%>
{"POINT":<%=s[0]%>}
<%
}
%>
