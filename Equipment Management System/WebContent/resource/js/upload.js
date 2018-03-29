$(function() {
	console.log("abhkjashfadkjshfk");
	$(".blue").click(
			function() {
				var file = $("#headSculpture").val();
				console.log(file);
				if (file == null || file == "") {
					alert("你还没有选择任何文件，不能上传!");
					return false;
				}
				if (file.lastIndexOf(".") == -1) {
					alert("路径不正确!");
					return false;
				}
				var allImgExt = ".jpg|.jpeg|.gif|.bmp|.png|.mp3|";
				var extName = file.substring(file.lastIndexOf("."));
				if (allImgExt.indexOf(extName + "|") == -1) {
					errMsg = "该文件类型不允许上传。请上传 " + allImgExt + " 类型的文件，当前文件类型为"
							+ extName;
					alert(errMsg);
					return false;
				}
				$('#headpicture').src='';
			});
});
