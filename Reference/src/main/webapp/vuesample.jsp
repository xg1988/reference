<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="./js/vue.js"></script>
 
<script> <!-- 2. �Լ� ���� �ڵ尡 ȣ��� -->
    window.onload = function() { 
        var testView = new Vue({ <!-- Vue ��ü ���� -->
            el : '#test', <!-- # �� id�� �ش�. ��  id�� test�� �±׸� Ž�� -->
            data : {
                message : "First Vue.js"  <!-- Ž���� �±� ���� data�� meesage�� ���ε�.  -->
            }
        })
    }
</script>
</head>
<body>
    <div id="test">
        <h1>{{message}}</h1>
    </div>
</body>
</html>