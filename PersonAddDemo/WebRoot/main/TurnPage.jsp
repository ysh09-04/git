<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TurnPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
  </head>
  
  <body>

    <div align=center >
    	<div>
    		�û�����<input type="text" id="uname" name="uname" /> 
    		           <input type="button" onclick="queryPerson()" value="��ѯ"/>
    	</div>
    	<table id="tt" width="800"  ></table>
    	
    </div>	
	
    
      <script type="text/javascript">   
    		
    		$(function(){
    		$('#tt').datagrid({
				title:'δ�λ���Ա�б�',							
				height:350,
				nowrap: false,
				striped: true,												
				url: null,
				rownumbers:true,
				pagination:true,				
				pageList:[10,20,30],
				loadMsg : 'processing, please wait ��',			
				columns:[[					
					{field:'pid',checkbox:true},					
					{field:'name',title:'����',width:100},					
					{field:'address',title:'��ַ',width:180},					
					{field:'sex',title:'�Ա�',width:80}
				]]					
			});			
    	});     	
    	
    	function queryPerson(){    		   
		   
		    var uname = document.getElementById("uname").value; 
		    var url = '<%=basePath%>TurnPageSvl?uname=' + uname;		          
		    $('#tt').datagrid('options').url = url;		    
		    $('#tt').datagrid('reload');	    				
     	}               	
		
    </script>
  </body>
</html>
