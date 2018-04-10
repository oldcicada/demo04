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

function resetPass(){
	$.post("view/sys/resetPass",{"userId":$(this).attr("data")},function(data,status){
		if(status){
			alert("密码重置成功");
		}
	});
}
function query(){
	queryPage();
}
function reset(){
	$("input[name=login_name]").val("");
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
	var login_name=$("input[name=login_name]").val();
	var name=$("input[name=name]").val();
	$.post("view/sys/employeeList",
			{"pageIndex":pageIndex,"pageSize":pageSize,"login_name":login_name,"name":name},
			function(data,status){
				//字符串转成json对象
				data=eval("("+data+")");
				var list=data.list;
				if(status){
					$("#content").empty();
					for(var i=0;i<list.length;i++){
						var content="<tr><td>"+(i+1)
						+"</td><td>"+list[i].login_name
						+"</td><td>"+list[i].name
						+"</td><td>"+list[i].email
						+"</td><td>" +list[i].sex
						+"</td><td class='text-center'><a href='view/sys/employeeEdit?id="+list[i].id+"'>编辑</a> "
						+"<a href='view/sys/employeeDelete?id="+list[i].id+"'>删除</a> "
						+"<a href='javascript:void(0)' class='resetPass' data='"+list[i].id+"'>密码重置</a></td></tr>";
						$("#content").append(content);
					}
				}
				if(data.list.length == 0){
					$("#pageControl").css('display','none');
				}
		$(".resetPass").click(resetPass);
		pageTotal=data.pageTotal;
		count=data.count;
		var nowPage=(pageIndex-1)*pageSize+1;
		$("#pageMessage").text("显示第"+nowPage+"到"+(list.length+nowPage-1)+"条数据，当前"+pageIndex+"/"+pageTotal+"页,共"+count+"条记录");
	});
}

