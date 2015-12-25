<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <base href="<%=basePath%>">
  <title>题材列表</title>
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="jqueryui/jquery-ui.min.css">
  <script src="js/jquery-2.1.4.min.js"></script>
  <script src="jqueryui/jquery-ui.min.js"></script>
  <script src="js/common.js"></script>
  <script type="text/javascript">
    $(function() {
      var id = getUrlParam("id");
      GetAjax("do/TicaiController.getTicai", function(
              data) {
        jsonResp = eval('(' + data + ')');
        var liHtml = "";
        $.each(jsonResp, function(index, item) {
          if (item.id==id) {
            liHtml += "<li><a href='ticailist.jsp?id=" + item.id
                    + "' style='color: red;'>" + item.name
                    + "</a></li>";
          } else {
            liHtml += "<li><a href='ticailist.jsp?id=" + item.id
                    + "' style='color: #585858;'>" + item.name
                    + "</a></li>";
          }
        });
        $("#ulHeartStock").html(liHtml);
        //加载分析数据
        ReflashAnylysisData();
        //end加载分析数据
      });
    });
    function ReflashAnylysisData(){
      var id = getUrlParam("id");
      if(id!=null){
        var getdataurl="do/TicaiController.GetStockAnalysisByTicaiId?id="+id;
        GetAjax(getdataurl,function(data){
          jsonResp1 = eval('(' + data + ')');
          var tbHtml1="";
          var tbHtml2="";
          var tbHtml3="";
          var tbHtml4="";
          $.each(jsonResp1,function(index,item){
            if(item.level==1){
              tbHtml1+="<tr><td>"+item.code+"</td><td>"+item.name+"</td><td>"+item.currentPrice+"</td><td>"+item.buyPrice+"</td><td>"+item.supportPrice+"</td><td>"+item.pressurePrice+"</td><td>"+item.planSellPrice+"</td><td><input type='button' value='详情' onclick='showTr(\""+item.code+"\",\""+item.symbol+"\")'><input type='button' value='降' onclick='modifyLevel(\""+item.id+"\",\"1\")'><input type='button' value='Eidt' onclick='editAnalysisData(\""+item.id+"\",\""+item.code+"\")'> </td></tr>";
              tbHtml1+="<tr id='"+item.code+"' style='display:none'></tr>";
            }else if(item.level==2){
              tbHtml2+="<tr><td>"+item.code+"</td><td>"+item.name+"</td><td>"+item.currentPrice+"</td><td>"+item.planBuyPrice+"</td><td>"+item.supportPrice+"</td><td>"+item.pressurePrice+"</td><td><input type='button' value='详情' onclick='showTr(\""+item.code+"\",\""+item.symbol+"\")'><input type='button' value='降' onclick='modifyLevel(\""+item.id+"\",\"1\")'><input type='button' value='升' onclick='modifyLevel(\""+item.id+"\",\"-1\")'><input type='button' value='Eidt' onclick='editAnalysisData(\""+item.id+"\",\""+item.code+"\")'>  </td></tr>";
              tbHtml2+="<tr id='"+item.code+"' style='display:none'></tr>";
            }else if(item.level==3){
              tbHtml3+="<tr><td>"+item.code+"</td><td>"+item.name+"</td><td>"+item.currentPrice+"</td><td>"+item.supportPrice+"</td><td>"+item.pressurePrice+"</td><td><input type='button' value='详情' onclick='showTr(\""+item.code+"\",\""+item.symbol+"\")'><input type='button' value='降' onclick='modifyLevel(\""+item.id+"\",\"1\")'><input type='button' value='升' onclick='modifyLevel(\""+item.id+"\",\"-1\")'><input type='button' value='Eidt' onclick='editAnalysisData(\""+item.id+"\",\""+item.code+"\")'> </td></tr>";
              tbHtml3+="<tr id='"+item.code+"' style='display:none'></tr>";
            }else if(item.level==4){
              tbHtml4+="<tr><td>"+item.code+"</td><td>"+item.name+"</td><td>"+item.currentPrice+"</td><td>"+item.supportPrice+"</td><td>"+item.pressurePrice+"</td><td><input type='button' value='详情' onclick='showTr(\""+item.code+"\",\""+item.symbol+"\")'><input type='button' value='升' onclick='modifyLevel(\""+item.id+"\",\"-1\")'><input type='button' value='Eidt' onclick='editAnalysisData(\""+item.id+"\",\""+item.code+"\")'>  </td></tr>";
              tbHtml4+="<tr id='"+item.code+"' style='display:none'></tr>";
            }

          });
          $("#tbAnaly1").html(tbHtml1);
          $("#tbAnaly2").html(tbHtml2);
          $("#tbAnaly3").html(tbHtml3);
          $("#tbAnaly4").html(tbHtml4);
        })
      }
    }
    function AddStock(){
      var code=$("#txtCode").val();
      var id=getUrlParam("id");
      var url="do/TicaiController.addTicaiStock?id="+id+"&code="+code;
      GetAjax(url, function(
              data) {
        alert(data);
        ReflashAnylysisData();
      });
    }
    function showTr(id,code){
      var html="<td colspan='8'><iframe src=\"http://finance.sina.com.cn/flash/cn.swf?symbol="+code+"\" width=\"560\" height=\"500\"></iframe></td>";
      var display =$("#"+id).css('display');
      if(display=='none'){
        $("#"+id).show();
        $("#"+id).html(html);
      }else{
        $("#"+id).hide();
      }
    }
    function modifyLevel(id,addLevel){
      var url="do/TicaiController.ModifyRelationLevel?id="+id+"&addLevel="+addLevel;
      GetAjax(url, function(
              data) {
        alert(data);
        ReflashAnylysisData();
      });
    }
    function editAnalysisData(relationid,code){
      $("#hidEditRelationCode").val(code);
      var url="do/TicaiController.GetStockAnalysisByRelationId?id="+relationid;
      GetAjax(url,function(data){
        var obj = JSON.parse(data);
        $("#txtSupportPrice").val(obj[0].supportPrice);
        $("#txtPressurePrice").val(obj[0].pressurePrice);
        $("#txtPlanBuyPrice").val(obj[0].planBuyPrice);
        $("#txtPlanSellPrice").val(obj[0].planSellPrice);
        $("#txtBuyPrice").val(obj[0].buyPrice);
        $( "#dialog" ).dialog();
      });
    }
    function submitEditAnalysis(){
      var supportPrice=$("#txtSupportPrice").val();
      var pressurePrice=$("#txtPressurePrice").val();
      var planBuyPrice=$("#txtPlanBuyPrice").val();
      var planSellPrice=$("#txtPlanSellPrice").val();
      var buyPrice=$("#txtBuyPrice").val();
      var code=$("#hidEditRelationCode").val();
      var url="do/TicaiController.EditStockAnalysis?code="+code+"&supportPrice="+supportPrice+"&pressurePrice="+pressurePrice+"&planBuyPrice="+planBuyPrice+"&planSellPrice="+planSellPrice+"&buyPrice="+buyPrice;
      GetAjax(url, function(
              data) {
        alert(data);
        ReflashAnylysisData();
        $('#dialog').dialog('close');
      });
    }

  </script>
</head>
<body>
<div id="main">
  <div id="left">
    <ul id="ulHeartStock">
    </ul>
  </div>
  <div id="right">
    <input type="text" id="txtCode"><input type="button" value="添加股票" onclick="AddStock()"><br>
    已买入：
    <table class="table table-bordered">
      <tr>
        <th>代码</th>
        <th>名称</th>
        <th>当前价</th>
        <th>买入价</th>
        <th>短期支撑</th>
        <th>短期压力位</th>
        <th>计划卖价</th>
        <th>操作</th>
      </tr>
      <tbody id="tbAnaly1">
      </tbody>
    </table>
    <br>
    计划买入：
    <table class="table table-bordered">
      <tr>
        <th>代码</th>
        <th>名称</th>
        <th>当前价</th>
        <th>计划买价</th>
        <th>短期支撑</th>
        <th>短期压力位</th>
        <th>操作</th>
      </tr>
      <tbody id="tbAnaly2">
      </tbody>
    </table>
    <br>
    暂时不买：
    <table class="table table-bordered">
      <tr>
        <th>代码</th>
        <th>名称</th>
        <th>当前价</th>
        <th>短期支撑</th>
        <th>短期压力位</th>
        <th>操作</th>
      </tr>
      <tbody id="tbAnaly3">
      </tbody>
    </table>
    股池：
    <table class="table table-bordered">
      <tr>
        <th>代码</th>
        <th>名称</th>
        <th>当前价</th>
        <th>短期支撑</th>
        <th>短期压力位</th>
        <th>操作</th>
      </tr>
      <tbody id="tbAnaly4">
      </tbody>
    </table>
  </div>
</div>
<div id="dialog" title="编辑参数" style="display: none;">
  <table>
    <tr>
      <td>支撑点</td><td><input type="text" id="txtSupportPrice"></td>
    </tr>
    <tr>
      <td>压力点</td><td><input type="text" id="txtPressurePrice"></td>
    </tr>
    <tr>
      <td>计划买入</td><td><input type="text" id="txtPlanBuyPrice"></td>
    </tr>
    <tr>
      <td>计划卖出</td><td><input type="text" id="txtPlanSellPrice"></td>
    </tr>
    <tr>
      <td>买入价</td><td><input type="text" id="txtBuyPrice"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="button" value="提交" onclick="submitEditAnalysis();"><input type="button" value="取消" onclick="$('#dialog').dialog('close') "> </td>
    </tr>
  </table>
  <input type="hidden" id="hidEditRelationCode">
</div>
</body>
</html>
