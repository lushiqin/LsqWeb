$("#imgUp").change(function() {
	var objUrl = getimgURL(this.files[0]);
	if(objUrl) {
		$("#imgView").attr("src", objUrl);
	}
});
//建立一個可存取到該file的url
function getimgURL(file) {
	var url = null;
	if(window.createObjectURL != undefined) { // basic
		url = window.createObjectURL(file);
	} else if(window.URL != undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file);
	} else if(window.webkitURL != undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file);
	}
	return url;
}