<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>用户添加</title> 
    <!-- 此页为弹出页，不能重复引入link和script，否则出错 -->     
    
  </head>
  
  <body>
    <form action="<%=basePath%>PersonAddSvl" method="post"> 
    <div align=center>
    	<div>
    		用户名：<input type="text" id="uname" name="uname" /> 
    		           <input type="button" onclick="queryPerson()" value="查询"/>
    	</div>
    	<table id="tt"></table>
    	<input type="submit" value="提交"/>    	
    </div>	         		  	
      	
      </form>    
      <script type="text/javascript">   
    		
    		$(function(){
    		$('#tt').datagrid({
				title:'未参会人员列表',							
				height:350,
				nowrap: false,
				striped: true,								
				url: null,
				rownumbers:true,
				loadMsg : 'processing, please wait …',			
				columns:[[					
					{field:'pid',checkbox:true},					
					{field:'name',title:'姓名',width:100},					
					{field:'address',title:'地址',width:180},					
					{field:'sex',title:'性别',width:80}
				]]					
			});			
    	});     	
    	
    	function queryPerson(){		    
		    var uname = document.getElementById("uname").value; 
		    var url = '<%=basePath%>PersonQuerySvl?uname=' + uname;		          
		    $('#tt').datagrid('options').url = url;
		    $('#tt').datagrid('reload');	    				
     	}               	
		
    </script>
   
  </body>
</html>
