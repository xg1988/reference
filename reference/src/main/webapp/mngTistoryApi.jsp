<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	h2{
		display: inline;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	function choiceService(val){
		
	}
</script>
</head>
<body>

<h1>티스토리 블로그 API관리</h1>
<input type="radio" id="method" name="method" onclick="choiceService(1)">
<h2>1. 정보</h2>
<input type="radio" id="method" name="method" onclick="choiceService(2)">
<h2>2. 글 목록</h2>
<input type="radio" id="method" name="method" onclick="choiceService(3)">
<h2>3. 글 상세</h2>


<div id="showDiv1">
	주소: <input type="text" id="url" name="url"><br/>
	입력파라미터: <input type="text" id="url" name="url"><br/>
</div>

</body>
</html>