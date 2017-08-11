<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>demo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="qnsoft,callcenter,jsreport">
	<meta http-equiv="description" content="qnsoft,callcenter,jsreport">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/styles.css">
	-->
	<style type="text/css">
		body{ 
			font-size:12px; 
		} 
		table{ 
			table-layout:fixed; 
			empty-cells:show; 
			border-collapse: collapse; 
			margin:0 auto;
			font-size:12px; 
		}
		td{
			height:20px; 
		}
		#result table{
			width:80%;
		}
		#container{
			text-align: center;
		}
	</style>
 	<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/json2.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		});
		
		
		function query(){
			$("#oper_zone  input[name='operation']").val("query");
			$("#form").submit();
		}
		function turnToPage(type){
			if(type=="first"){
				$("#oper_zone  input[name='pageNo']").val(-9999);
			}else if(type=="pre"){
				$("#oper_zone  input[name='pageNo']").val(parseInt($("#oper_zone  input[name='pageNo']").val())-1);
			}else if(type=="next"){
				$("#oper_zone  input[name='pageNo']").val(parseInt($("#oper_zone  input[name='pageNo']").val())+1);
			}else if(type=="last"){
				$("#oper_zone  input[name='pageNo']").val(9999);
			}else if(type=="index"){
				$("#oper_zone  input[name='pageNo']").val($("#q_pageNo").val());
			}else if(type=="size"){
				$("#oper_zone  input[name='pageSize']").val($("#q_pageSize").val());
			}
			query();
		}
		
		
		function download(type){
			
		}
		
	</script>
  </head>
  
  <body>
  
    	<div id="container">
   		<h3>demo报表</h3>
   		<div id="oper_zone">
   			<form id="form" action="<%=basePath%>dba/demo" method="post" >
   				<table border=1>
   					<tbody>
 						<tr>
 							<th>aaa</th><th>bbb</th>
   						</tr>
   						<tr>
   							<td><input name="aaa" value="${query.aaa}"/></td><td><input name="bbb"  value="${query.bbb}"/></td>
   						</tr>
   					</tbody>
   					<tfoot>
   					 	<tr align="center">
   					 		<td colspan="3"><button onclick="query()" type="button">查询</button>&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="重填" /></td>
   					 	</tr>
   					</tfoot>
   				</table>
   				<input name="operation" type="hidden" value="query"/>
   				<input name="random" type="hidden" value="<%= System.currentTimeMillis()%>"/>
   				<input name="pageSize" type="hidden" value="${page.pageSize}"/>
   				<input name="pageNo" type="hidden" value="${page.pageNo}"/>
   			</form>
   		</div>
   		<p></p>
   		<div id="result">
   			<table border=1>
   				<caption>本页共&nbsp;${page.resultSize}&nbsp;条记录&nbsp;&nbsp;共&nbsp;${page.resultTotal}&nbsp;条记录&nbsp;&nbsp;共&nbsp;${page.pageTotal}&nbsp;页&nbsp;<button onclick="turnToPage('first')" type="button">首页</button><button onclick="turnToPage('pre')" type="button">上一页</button><button onclick="turnToPage('next')" type="button">下一页</button><button onclick="turnToPage('last')" type="button">末页</button>&nbsp;&nbsp;&nbsp;&nbsp;第<input id="q_pageNo" value="${page.pageNo}" style="width: 50px; text-align: center;"/>页<button onclick="turnToPage('index')" type="button">跳转</button>&nbsp;&nbsp;&nbsp;&nbsp;每页<input id="q_pageSize" value="${page.pageSize}" style="width: 50px; text-align: center;"/>条<button onclick="turnToPage('size')" type="button">设置</button></caption>
   				<thead>
   					<tr>
   						<th>序号</th><th>id</th><th>xxx</th><th>yyy</th>
   					</tr>
   				</thead>
   				<tbody>
			       <c:forEach items="${page.result}" varStatus="varStatus" var="pojo" >  
						<tr>
							<td>${(page.pageNo-1) * page.pageSize + varStatus.count}</td>
							<td>${pojo.aaa}</td>
							<td>${pojo.bbb}</td>
        				</tr>
        			</c:forEach>    				
   				</tbody>
   			</table>
   		</div>
   	</div>
  </body> 
</html>
