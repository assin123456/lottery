<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$("#btn1").click(function(){
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/user/getlist",
						data:{},
						dataType : "json",
						success : function(data) {
							alert(data);
					}
				});					
					
			});
	});

</script>

</head>
<body>
	<form action="user/getlist" method="post">
		<input value="点击查询" type="button" id="btn1" />
	</form>

</body>
</html>