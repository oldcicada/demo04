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
	$.post("view/sys/roleList",
			{"pageIndex":pageIndex,"pageSize":pageSize,"name":name},
			function(data,status){
				//字符串转成json对象
				data=eval("("+data+")");
				var list=data;
				if(status){
					$("#content").empty();
					for(var i=0;i<list.length;i++){
						var content="<tr><td>"+(i+1)
						+"</td><td>"+list[i].name
						+"</td><td>"+list[i].description
						+"</td><td class='text-center'><a href='view/sys/roleEdit?id="+list[i].id+"'>编辑</a> "
						+"<a href='view/sys/roleDelete?id="+list[i].id+"'>删除</a> "
					$("#content").append(content);
					}
				}
				if(list.length <= 8){
					$("#pageControl").css('display','none');
				}
		pageTotal=data.pageTotal;
		count=data.count;
		var nowPage=(pageIndex-1)*pageSize+1;
		$("#pageMessage").text("显示第"+nowPage+"到"+(list.length+nowPage-1)+"条数据");
	});
}

