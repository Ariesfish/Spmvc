<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="user/testParam?username=maurice">请求参数绑定</a>

    <form action="param/saveAccount" method="post">
        Name: <input type="text" name="username" /><br/>
        Password: <input type="text" name="password" /><br/>
        Money: <input type="text" name="money" /><br/>
        UserName: <input type="text" name="user.name" /><br/>
        UserAge: <input type="text" name="user.age" /><br/>
        <input type="submit" value="提交"/><br/>
    </form>
</body>
</html>
