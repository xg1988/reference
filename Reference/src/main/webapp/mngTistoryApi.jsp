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

<h1>Ƽ���丮 ��α� API����</h1>
<input type="radio" id="method" name="method" onclick="choiceService(1)">
<h2>1. ����</h2>
<input type="radio" id="method" name="method" onclick="choiceService(2)">
<h2>2. �� ���</h2>
<input type="radio" id="method" name="method" onclick="choiceService(3)">
<h2>3. �� ��</h2>


<div id="showDiv1">
	�ּ�: <input type="text" id="url" name="url"><br/>
	�Է��Ķ����: <input type="text" id="url" name="url"><br/>
</div>

</body>
</html>