<%--
  Created by IntelliJ IDEA.
  User: wgqing
  Date: 2015/12/24
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>控制中心</title>
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="jqueryui/jquery-ui.min.css">
  <script src="js/jquery-2.1.4.min.js"></script>
  <script src="jqueryui/jquery-ui.min.js"></script>
  <script src="js/common.js"></script>
  <script type="javascript">
    function StockInfoInit(){
      var url="do/ControlController.getStockInfoNew";
      GetAjax(url, function(
              data) {
        alert(data);
      });
    }
  </script>
</head>
<body>
<input type="button" onclick="StockInfoInit();" value="StockInfo表初始化">
</body>
</html>
