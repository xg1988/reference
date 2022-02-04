<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="./js/vue.js"></script>
 
<script> <!-- 2. 함수 내부 코드가 호출됨 -->
    window.onload = function() { 
        var testView = new Vue({ <!-- Vue 객체 생성 -->
            el : '#test', <!-- # 은 id에 해당. 즉  id가 test인 태그를 탐색 -->
            data : {
                message : "First Vue.js"  <!-- 탐색된 태그 안의 data중 meesage를 바인딩.  -->
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