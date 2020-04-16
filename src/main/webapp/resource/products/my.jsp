
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

</head>
<body>
<div id="my">

</div>

<script>
$(function(){
    $.ajax({
        url:"getMy",
        type:"post",
        success:function(data){
            for(var i in data){
                $("#my").append("<h1>"+i+"</h1>");

                for(var j=0;j<data[i].length;j++){
                    var str=
                        "    <p>"+data[i][j].brand+"</p>";
                      $("#my").append(str);
                }

            }
        }
    });
})


</script>

</body>
</html>
