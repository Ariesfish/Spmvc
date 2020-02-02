<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#sendAjax").click(function () {
                // alert("Sent!");
                // 发送ajax请求
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"name":"Maurice", "password":"suzhou", "age":"30"}',
                    dataType: "json",
                    type: "POST",
                    success: function (data) { // callback
                        // data: 服务器端响应的json数据，客户端进行解析
                        alert(data.name + ', ' + data.password + ', ' + data.age);
                    }
                });
            })
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>
    <br>
    <a href="user/testVoid">testVoid</a>
    <br>
    <a href="user/testModelAndView">testModelAndView</a>
    <br>
    <a href="user/testForward">testForward</a>
    <br>
    <a href="user/testRedirect">testRedirect</a>
    <br>
    <button id="sendAjax">Send Ajax</button>
</body>
</html>
