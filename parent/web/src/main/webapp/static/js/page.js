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