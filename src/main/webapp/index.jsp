<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="user/testParam?username=maurice">请求参数绑定</a>

    <!-- 自定义类型转换器 -->
    <form action="param/saveUser" method="post">
        Name: <input type="text" name="name" /><br/>
        Age: <input type="text" name="age" /><br/>
        Birthday: <input type="text" name="birthday" /><br/>
        <input type="submit" value="提交"/><br/>
    </form>
</body>
</html>
