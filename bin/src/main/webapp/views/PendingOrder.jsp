
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Pending Order</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.btn {
	font-size: 0.9em;
}

#pending-order-headers {
	margin-bottom: 2px;
	font-weight: bolder;
	overflow-y: scroll;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
}

#pending-order-headers div {
	margin: auto;
}

#pending-order-data {
	height: 70vh;
	overflow-y: scroll;
	font-size: 0.85em;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
}

#pending-order-data div {
	margin: auto;
	margin-bottom: 8px;
	height: 35px;
	font-weight: 600;
	line-height: 35px;
	vertical-align: middle;
}

//
scroll bar cutomization .

#pending-order-headers::-webkit-scrollbar {
	width: 1em;
}

#pending-order-headers::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px transparent;
}

#pending-order-headers::-webkit-scrollbar-thumb {
	background-color: transparent;
	outline: 1px solid slategrey;
}

#pending-order-data::-webkit-scrollbar {
	width: 1em;
}

#pending-order-data::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

#pending-order-data::-webkit-scrollbar-thumb {
	background-color: darkgrey;
	outline: 1px solid slategrey;
}
</style>
</head>
<body>

	<!-- Navigation Bar -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./PMHome.jsp">Portfolio Manager</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="./PMHome.jsp">Home</a></li>
				<li><a href="./CreateTrade.jsp">Create Trade</a></li>
				<li><a href="./OrderBlotter.jsp">Order Blotter</a></li>
				<li class="active"><a href="./PendingOrder.jsp">Pending
						Orders</a></li>
				<li><a href="./PMHistory.jsp">History</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h2 id="pending-order-title">Pending Order</h2>
		<div id="pending-order-container">
			<!-- order in blotter -->
			<div class="row well" id="pending-order-headers">
				<div class="col col-sm-1">Order ID</div>
				<div class="col col-sm-1">Symbol</div>
				<div class="col col-sm-1">Side</div>
				<div class="col col-sm-2 col-centered">Type</div>
				<div class="col col-sm-1">Qualifier</div>
				<div class="col col-sm-1">Trader</div>
				<div class="col col-sm-1">Quantiy</div>
				<div class="col col-sm-1">Stop</div>
				<div class="col col-sm-1">Limit</div>
				<div class="col col-sm-1">Ammend</div>
				<div class="col col-sm-1">Cancel</div>
			</div>

			<div class="row well" id="pending-order-data">
				<!-- order 1 -->
				<div class="row " id="orderid1-data">
					<div class="col col-sm-1">
						<label>1211</label>
					</div>
					<div class="col col-sm-1">AAPL</div>
					<div class="col col-sm-1">BUY</div>
					<div class="col col-sm-2 col-centered">MARKET</div>
					<div class="col col-sm-1">GTC</div>
					<div class="col col-sm-1">T1</div>
					<div class="col col-sm-1">1000</div>
					<div class="col col-sm-1">-</div>
					<div class="col col-sm-1">-</div>
					<div class="col col-sm-1">
						<button id="orderId1-ammend" type="button" class="btn btn-warning">Ammend</button>
					</div>
					<div class="col col-sm-1">
						<button id="orderId1-cancel" type="button" class="btn btn-danger">Cancel</button>
					</div>
				</div>

				<!-- order 2 -->
				<div class="row " id="orderid2-data">
					<div class="col col-sm-1">
						<label>1232</label>
					</div>
					<div class="col col-sm-1">DELL</div>
					<div class="col col-sm-1">SELL</div>
					<div class="col col-sm-2 col-centered">LIMIT</div>
					<div class="col col-sm-1">GTC</div>
					<div class="col col-sm-1">T2</div>
					<div class="col col-sm-1">500</div>
					<div class="col col-sm-1">-</div>
					<div class="col col-sm-1">32.05</div>
					<div class="col col-sm-1">
						<button id="orderId2-ammend" type="button" class="btn btn-warning">Ammend</button>
					</div>
					<div class="col col-sm-1">
						<button id="orderId2-cancel" type="button" class="btn btn-danger">Cancel</button>
					</div>
				</div>

				<!-- order 3 -->
				<div class="row " id="orderid3-data">
					<div class="col col-sm-1">
						<label>1542</label>
					</div>
					<div class="col col-sm-1">SKODA</div>
					<div class="col col-sm-1">BUY</div>
					<div class="col col-sm-2 col-centered">STOP-LIMIT</div>
					<div class="col col-sm-1">GTC</div>
					<div class="col col-sm-1">T1</div>
					<div class="col col-sm-1">1200</div>
					<div class="col col-sm-1">25.02</div>
					<div class="col col-sm-1">32.65</div>
					<div class="col col-sm-1">
						<button id="orderId3-ammend" type="button" class="btn btn-warning">Ammend</button>
					</div>
					<div class="col col-sm-1">
						<button id="orderId3-cancel" type="button" class="btn btn-danger">Cancel</button>
					</div>
				</div>

			</div>


			<!-- pop up form -->

			<!-- pop up form ends here -->

		</div>
	</div>

</body>
</html>