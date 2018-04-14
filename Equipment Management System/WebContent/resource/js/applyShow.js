var pageIndex=1;
var pageSize=5;
var pageTotal;
var count;

$(function(){
	queryPage();
	$(".page").click(otherOperate);
});

function otherOperate(){
	var operate=$(this).attr("id");
	if(operate == "first"){
		pageIndex=1;
		queryPage();
	}else if(operate == "previou"){
		if(pageIndex ==1){
			alert("已经是第一页");
		}else{
			pageIndex--;
			queryPage();
		}
		
	}else if(operate == "next"){
		if(pageIndex ==pageTotal){
			alert("已经是最后一页");
		}else{
			pageIndex++;
			queryPage();
		}
	}
	else if(operate == "last"){
		pageIndex=pageTotal;
		queryPage();
	}
}


function queryPage(){
	var ids=$("input[name=id]").val();
	$.post("view/equip/applyShow",
			{"id":id},
			function(data,status){
				//字符串转成json对象
				data=eval("("+data+")");
				if(status){
					$("#content").empty();
					for(var i=0;i<list.length;i++){
						var content="<tr><td>"+(i+1)
						+"</td><td>"+data.equipment_name
						+"</td><td>"+data.room_name
						+"</td><td>" +data.states
						+"</td></tr>";
						$("#content").append(content);
					}
				}
		pageTotal=data.pageTotal;
		count=data.count;
		var nowPage=(pageIndex-1)*pageSize+1;
		$("#pageMessage").text("显示第"+nowPage+"到"+(list.length+nowPage-1)+"条数据，当前"+pageIndex+"/"+pageTotal+"页,共"+count+"条信息");
	});
}

