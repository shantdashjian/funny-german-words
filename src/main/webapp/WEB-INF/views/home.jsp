<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Funny German Words</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Germania+One" rel="stylesheet">
	
<link rel="stylesheet" href="css/master.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="js/master.js"></script>
<style>
            body {
		        background-image: url('images/flag-map-of-germany-opaque.jpg');
                
            }
        </style>
</head>
<body>
<jsp:include page="navbar.jsp" />

<!-- 	<img src="../images/flag-map-of-germany.png"/>
 -->	<div class="container">
		<div class="row">
			<c:forEach var="word" items="${words}">
				<div class="col-md-3">
			
					<div class="thumbnail">
						<a href="displayWord.do?wordInGerman=${word.wordInGerman}">
							<div class="caption">
								<h4>${word.wordInGerman}</h4>
								<p>${word.literalTranslation}</p>
							</div> <img src=${word.pictureURL } alt=${word.wordInGerman }> 
							
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
