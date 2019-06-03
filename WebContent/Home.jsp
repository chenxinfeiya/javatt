<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主界面</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$("form").hide();
		$.post("Computer.do",{"method":"show"},function(data,status){
			showAll(data);
		});
		
		function showAll(data){
			var objs=eval('('+data+')');
			var coms = objs.coms;
			var page = objs.pb;
			$.each(coms,function(index,com){
				var trobj=$("<tr></tr>");
				var tdobj1=$("<td></td>");
				tdobj1.text(com.cid);
				var tdobj2=$("<td></td>");
				tdobj2.text(com.cname);
				
				var tdobj3=$("<td></td>");
				var image=$("<img />");
				image.attr("src",com.cimg);
				tdobj3.append(com.cimg);
				
				var tdobj4=$("<td></td>");
				tdobj4.text(com.cprice);
				
				var tdobj5=$("<td></td>");
				var btn = $("<button>编辑</button>");
				btn.attr("id","btn");
				tdobj5.append(btn);
				
				var aobj2 = $("<a></a>");
				var tdobj6=$("<td></td>");
				aobj2.text("删除");
				aobj2.attr("href","Computer.do?method=delete&cid="+com.cid);
				tdobj6.append(aobj2);
				
				trobj.append(tdobj1);
				trobj.append(tdobj2);
				trobj.append(tdobj3);
				trobj.append(tdobj4);
				trobj.append(tdobj5);
				trobj.append(tdobj6);
				
				trobj2=$("<tr></tr>");
				var btn1=$("<a>首页</a>");
				btn1.attr("href","Computer.do?method=show&pageNum="+pb.pageNum);
				var btn2=$("<a>上一页</<a>");
				btn2.attr("href","Computer.do?method=show&pageNum="+(pb.pageNum-1));
				var btn3=$("<a>下一页</<a>");
				btn3.attr("href","Computer.do?method=show&pageNum="+(pb.pageNum+1));
				var btn4=$("<a>末页</<a>");
				btn4.attr("href","Computer.do?method=show&pageNum="+pb.countPage);
				trobj2.append(btn1);
				trobj2.append(btn2);
				trobj2.append(btn3);
				trobj2.append(btn4);
				
				$("tbody").append(trobj);
				$("tbody").append(trobj2);
				
				
				$("#btn").click(function(){
					$("form").show();
					$("form").attr("action","Computer.do?method=edit");
					$("#bnn").val("编辑");
					$("#cid").val(com.cid);
					$("#cname").val(com.cname);
					$("#cimg").val(com.cimg);
					$("#cprice").val(com.cprice);
				});
				
			});
			
		}
		
		$("#bnn1").click(function(){
			$("form").show();
			$("form").attr("action","Computer.do?method=add");
			$("#bnn").val("添加");
		});
		
	});
</script>
</head>
<body>
	<table width="1200px" align="center" border="1">
		<caption>computer</caption>
		<thead>
			<tr>
				<th>序号</th>
				<th>名称</th>
				<th>图片</th>
				<th>价格</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	<button id="bnn1">添加</button>
	
	<form enctype="multipart/form-data">
		<input type="hidden" name="cid" id="cid"/><br />
		cname:<input type="text" name="cname" id="cname"/><br />
		cimg:<input type="file" name="cimg" id="cimg" /><br />
		cprice:<input type="text" name="cprice" id="cprice" /><br />
		<button id="bnn"></button><button type="reset">重置</button>
	</form>
</body>
</html>