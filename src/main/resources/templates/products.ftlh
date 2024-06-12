<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>
<hr>
<h4>SOME_PRODUCTS</h4>
<form action="/" method="get">
    Find product by name: <input type="text" name="title"><br>
    <input type="submit" name="find">
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} rub. | <a href="/product/${product.id}">Details...</a></p>
    </div>
    <#else>
    <h3>No products</h3>
</#list>
<hr>
<h3>Create new product</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Title of product: <input type="text" name="title"/><br><br>
    Description of product: <input type="text" name="description"/><br><br>
    Price of product: <input type="number" name="price"/><br><br>
    City of product: <input type="text" name="city"/><br><br>
    Author of product: <input type="text" name="author"/><br><br>
    Photo_1: <input type="file" name="file1"/><br><br>
    Photo_2: <input type="file" name="file2"/><br><br>
    Photo_3 : <input type="file" name="file3"/><br><br>
    <input type="submit" value="add product"/>
</form>
</body>
</html>