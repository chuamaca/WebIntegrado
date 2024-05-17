<%-- 
    Document   : indexjsp
    Created on : 6 abr. 2024, 10:27:58
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body onload="reloj()">
<h1>Programa de Saludo</h1>
<h2> <div id="lbhora"></div> </h2>
<%
Calendar t=Calendar.getInstance();
int hora=t.get(Calendar.HOUR_OF_DAY);


int min=t.get(Calendar.MINUTE);
int seg=t.get(Calendar.SECOND);
String cad="",chora;
chora=hora+":"+min+":"+seg;
if(hora<12)cad="Buenos dias";
else if(hora<18) cad="Buenas tardes";
else cad="buenas noches";
out.print("<h2>"+cad+"</h2");
%>
<br><h1> hora : <%=chora%></h1>
</body>

<<script>
function reloj(){
t=new Date();
hh=t.getHours();
mi=t.getMinutes();
sg=t.getSeconds();
cad=hh+":"+mi+":"+sg;
document.getElementById("lbhora").innerHTML="hora:"+cad;
setTimeout("reloj()",1000);
}
</script>

</html>