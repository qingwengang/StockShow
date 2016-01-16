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
  <script type="text/javascript">
    function StockInfoInit(){
      var url="do/ControlController.getStockInfoNew";
      GetAjax(url, function(
              data) {
        alert(data);
      });
    }
    function StockInfoInit(name){
      var url="do/ControlController."+name;
      GetAjax(url, function(
              data) {
        alert(data);
      });
    }
  </script>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br>
<input type="button" onclick="StockInfoInit()" value="StockInfo表初始化">
<input type="button" onclick="StockInfoInit('getTicai')" value="ticai表初始化">
<input type="button" onclick="StockInfoInit('getTicaiStockRelation')" value="ticaistockrelation表初始化">
</body>
</html>
