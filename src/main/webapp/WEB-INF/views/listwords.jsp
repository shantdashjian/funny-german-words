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
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />

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


	<div class="container">
		<div class="row">

			<ul class="list-group">
				<c:forEach var="word" items="${words}">
					<li class="list-group-item">${word.wordInGerman}:
						${word.literalTranslation} 
						<a href="deleteWord.do?wordInGerman=${word.wordInGerman}"><button type="button" class="btn pull-right btn-danger btn-sm">Delete</button></a>
						<a href="editWord.do?wordInGerman=${word.wordInGerman}"><button type="button" class="btn pull-right btn-primary btn-sm">Edit</button></a>
					</li>
				</c:forEach>
			</ul>

		</div>
	</div>
</body>
</html>
