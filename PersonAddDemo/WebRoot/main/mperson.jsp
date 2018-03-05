<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>人员信息</title>  
    <link rel="stylesheet" type="text/css" href="<%=basePath%>themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
    <script type="text/javascript">
    	$(function(){
    		$('#addWinow').window({	
    		title : '添加参会人员',	
    		collapsible : false,	
    		minimizable : false,
    		maximizable : false,
			modal:true
			});
			$('#addWinow').window('close');      		
    	});
    	function remove(pid,mid){
			$.messager.confirm('删除确认', '请确认要移除当前选定的参会人员?', function(r){
				if (r){					
					location.href = "<%=basePath%>PersonRemoveSvl?pid=" + pid + "&mid=" + mid;
				}
			});
		}		
		function openAddWin(){		
			$('#addWinow').window('open');	
			$('#addWinow').window('refresh', '<%=basePath%>main/PersonQuery.jsp');
		}		
    </script>
  </head>
  
  <body >
  <br/><br/>
  <center>
  <table width="800px" border="1" cellpadding="0" cellspacing="0">
  	<tr>
  		<td colspan="6" align="center">
  			<font size="5">反腐倡廉表彰大会---与会人员列表</font>
  		</td>
  	</tr>
  	<tr>
  		<td>员工编号</td><td>姓名</td><td>性别</td><td>出生日期</td><td>地址</td><td>操作</td>
  		
  	</tr>
  		<c:forEach var="p" items="${allPersons}">
  		  <tr><td>${p.pid}</td><td>${p.name}</td><td>${p.sex}</td><td>${p.birthday}</td><td>${p.address}</td><td> <input type="button" onclick="remove('${p.pid}',1)" value="移除"/> </td></tr> 
  		</c:forEach>
  
  	<tr>
  			<td colspan="5" align="center">
  				<input type="button" onclick="openAddWin()" value="添加"/>  				
  			</td>
  			<td ><a href="<%=basePath%>TurnPageSvl">翻页测试</a></td>
  	</tr>
  </table>
  	<div id="addWinow" style="width:580px;height:480px;padding:5px;background: #fafafa;">
	  show PersonAdd.jsp 
	</div>

  </center>
  
  </body>
</html>
