var pageIndex=1;
var pageSize=8;
var pageTotal;
var count;

$(function(){
	queryPage();
	$(".page").click(otherOperate);
	$("#query").click(query);
	$("#reset").click(reset);
});

function query(){
	queryPage();
}
function reset(){
	$("input[name=name]").val("");
	$("select[name=type]").val("");
	$("select[name=state]").val("");
	queryPage();
}

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
	var name=$("input[name=name]").val();
	var type=$("select[name=type]").val();
	var state=$("select[name=state]").val();
	$.post("view/equip/equipList",
			{"pageIndex":pageIndex,"pageSize":pageSize,"name":name,"type":type,"state":state},
			function(data,status){
				//字符串转成json对象
				data=eval("("+data+")");
				var list=data.list;
				if(status){
					$("#content").empty();
					for(var i=0;i<list.length;i++){
						var content="<tr><td>"+(i+1)
						+"</td><td>"+list[i].name
						+"</td><td>"+list[i].room_name
						+"</td><td>" +list[i].state+"</td><td class='text-center'>";
						if(list[i].state=="正常"){
						content=content+"<a href='view/equip/applyForm?name="+list[i].name+"&id="+list[i].id+"'>故障申报 </a>&nbsp;"
						}
						content=content+"<a href='view/equip/equipDelete?id="+list[i].id+"'> 删除</a></td></tr>";
						$("#content").append(content);
					}
				}
				if(data.list.length == 0){
					$("#pageControl").css('display','none');
				}
		pageTotal=data.pageTotal;
		count=data.count;
		var nowPage=(pageIndex-1)*pageSize+1;
		$("#pageMessage").text("显示第"+nowPage+"到"+(list.length+nowPage-1)+"条数据，当前"+pageIndex+"/"+pageTotal+"页,共"+count+"条记录");
	});
}

