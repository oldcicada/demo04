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
	$("input[name=address]").val("");
	$("input[name=number]").val("");
	$("select[name=type]").val("");
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
	var address=$("input[name=address]").val();
	var number=$("input[name=number]").val();
	var type=$("select[name=type]").val();
	$.post("view/sys/roomList",
			{"pageIndex":pageIndex,"pageSize":pageSize,"address":address,"number":number,"type":type},
			function(data,status){
				//字符串转成json对象
				data=eval("("+data+")");
				var list=data.list;
				if(status){
					$("#content").empty();
					for(var i=0;i<list.length;i++){
						var content="<tr><td>"+(i+1)
						+"</td><td>"+list[i].address
						+"</td><td>"+list[i].number
						+"</td><td>"+list[i].type
						+"</td><td>" +list[i].linker
						+"</td><td>" +list[i].phone
						+"</td><td>" +list[i].state
						+"</td><td class='text-center'><a href='view/sys/roomEdit?id="+list[i].id+"'>编辑</a> "
						+"<a href='view/sys/roomDelete?id="+list[i].id+"'>删除</a>"
						+"</td></tr>";
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

