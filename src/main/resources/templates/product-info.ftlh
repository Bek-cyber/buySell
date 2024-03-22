<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Details about product</h4>
<b>Title of product </b>${product.title}<br>
<b>Description of product </b>${product.description}<br>
<b>Price of product </b>${product.price}<br>
<b>City of product </b>${product.city}<br>
<b>Author of product </b>${product.author}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="remove product"/>
</form>
</body>
</html>