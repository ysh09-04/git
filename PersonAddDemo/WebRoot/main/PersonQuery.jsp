<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>�û����</title> 
    <!-- ��ҳΪ����ҳ�������ظ�����link��script��������� -->     
    
  </head>
  
  <body>
    <form action="<%=basePath%>PersonAddSvl" method="post"> 
    <div align=center>
    	<div>
    		�û�����<input type="text" id="uname" name="uname" /> 
    		           <input type="button" onclick="queryPerson()" value="��ѯ"/>
    	</div>
    	<table id="tt"></table>
    	<input type="submit" value="�ύ"/>    	
    </div>	         		  	
      	
      </form>    
      <script type="text/javascript">   
    		
    		$(function(){
    		$('#tt').datagrid({
				title:'δ�λ���Ա�б�',							
				height:350,
				nowrap: false,
				striped: true,								
				url: null,
				rownumbers:true,
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
		    var url = '<%=basePath%>PersonQuerySvl?uname=' + uname;		          
		    $('#tt').datagrid('options').url = url;
		    $('#tt').datagrid('reload');	    				
     	}               	
		
    </script>
   
  </body>
</html>
