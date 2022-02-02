<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String[] s=(String[])request.getAttribute("list");%>
[
{"ID":1,"OptName":"トッピング無料券","POINT":500},
{"ID":5,"OptName":"チャーハン無料券","POINT":1500},
{"ID":"<%=s[0]%>","OptName":"<%=s[1]%>","POINT":"<%=s[2]%>"},
]
