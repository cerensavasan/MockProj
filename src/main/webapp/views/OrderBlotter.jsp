<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="org.springframework.context.support.AbstractApplicationContext"%>
<%
	response.addHeader("Refresh", "10");
%>
<%@page import="com.mock.project.config.AppConfig"%>
<%@page
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mock.project.model.Order"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Order Blotter</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://rawgit.com/Govind-jha/online-resources/master/pm-home.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	
	
	function send(){
	       var data=[];
	             var status=[];       
	        $('#orderBlotter tr').each(function(){
	                     if($(this).find("input[type=checkbox]").prop("checked")===true)
	                     {
	                            var out1=$(this).find('.OrderId').html();
	                            var out3=$(this).find('.OrderStatus').html();data.push(out1);status.push(out3);
	                     }});
	        console.log(data);
	        $.ajax({
	                type: "POST",
	                url: "SendToTrader",
	                data: "data="+data ,
	                success: function(data) {
	                  console.log("data is sent");
	                },
	                     error:function(jqXHR, textStatus, errorThrown) {
	                       console.log(textStatus, errorThrown);
	                     
	                }
	              });
	     }

	
	
</script>
<style>
.btn {
	font-size: 0.9em;
}

#order-blotter-headers {
	margin-bottom: 2px;
	font-weight: bolder;
	overflow-y: scroll;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
}

#order-blotter-headers div {
	margin: auto;
}

#order-blotter-data {
	height: 70vh;
	overflow-y: scroll;
	font-size: 0.85em;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
}

#order-blotter-data div {
	margin: auto;
	margin-bottom: 8px;
	height: 35px;
	font-weight: 600;
	line-height: 35px;
	vertical-align: middle;
}

#orderId1-send {
	float: right;
	font-size: 18px;
}

//
scroll bar cutomization . #order-blotter-headers::-webkit-scrollbar {
	width: 1em;
}

#order-blotter-headers::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px transparent;
}

#order-blotter-headers::-webkit-scrollbar-thumb {
	background-color: transparent;
	outline: 1px solid slategrey;
}

#order-blotter-data::-webkit-scrollbar {
	width: 1em;
}

#order-blotter-data::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

#order-blotter-data::-webkit-scrollbar-thumb {
	background-color: darkgrey;
	outline: 1px solid slategrey;
}
</style>
</head>



<body>

       <nav class="navbar navbar-default">
              <div class="container-fluid">
                     <div class="navbar-header">
                           <a class="navbar-brand" href="#">Portfolio Manager</a>
                     </div>
                     <ul class="nav navbar-nav">
                           <li ><a href="PMHome.jsp">Home Page</a></li>           
                           <li><a href="CreateTrade.jsp">Create Trader</a></li>
                           <li class="active"><a href="ViewOrderBlotter">Order Blotter</a></li>
                           <li><a href="./PendingOrder.jsp">Pending Orders</a></li>
                           <li><a href="PMHistory.jsp">History</a></li>
                     </ul>
              </div>
              <div class="container">
                     <div class="well">
                           <h2>Order Blotter</h2>
                           <div class="panel-group" id="accordion">
                                  <div class="panel panel-default">
                                         <div class="panel-heading">
                                         
                                         
                                         <!--  <form action="SendToTrader" method="POST" >  -->
                                         
                                                <table class="table" id="orderBlotter">

                                                       <tr>
                                                              <th></th>
                                                              <th>Order ID</th>
                                                              <th>Symbol</th>
                                                              <th>Side</th>
                                                              <th>Status</th>
                                                              <th>Quantity</th>
                                                              <th>Order Type</th>
                                                              <th>Account Type</th>
                                                              <th></th>
                                                              <th></th>
                                                       </tr>
                                                       
                                                       
                                                       <c:forEach items='${Orders}'  var="Orders">     
    <c:forEach var="listValue" items="${lists}">
                           <li>${listValue}</li>
                     </c:forEach>

                     <tr>
                     <td> <label><input type="checkbox" id="checkbox" name="check" ></label></td>
                     <td class="OrderId"><c:out value='${Orders.orderId}'/></td> 
                      <td><c:out value='${Orders.symbol}'/></td>
                       <td><c:out value='${Orders.side}'/></td>
                       <td class="OrderStatus"><c:out value='${Orders.status}'/></td>
                       <td><c:out value='${Orders.qtyPlaced}'/></td>
                        <td><c:out value='${Orders.orderType}'/></td>
                        <td><c:out value='${Orders.accountType}'/></td>
                        <td> <button id="orderId-edit" type="button" class="btn btn-warning">Edit</button></td>
                        <td> <button id="orderId-cancel" type="button" class="btn btn-danger">Cancel</button></td>

                     </tr> 
                     
                     </c:forEach> 
                     
                     
                     
                           </table>
                                            
                                                 
      <button type="submit" class="btn btn-info" data-toggle="collapse" id="check" onclick="send()">Send to Trader
      </button>
                                                  
                                                
                                                

                                  
                                                
                                         <!--   </form> -->
                                                
                                         </div>
                                  </div>
                           </div>
                           
                     </div>
              </div>
       </nav>
</body>














</html>