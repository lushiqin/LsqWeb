/**
 * 导航栏移动效果
 */
$(".navname a").on("mouseover", function() {
	$(this).addClass("active");
	var leftsize = $(window).width()*0.5;
	var size = leftsize-200;
	$(".navmsg").css("margin-left",size+"px");
	$(".navmsg").removeClass("hide");
	$(".navmsg").text($(this).text());
	$(this).on("mouseout", function() {
		$(this).removeClass("active");
		$(".navmsg").addClass("hide");
	})
});


/**
 * 自动切换轮播图
 */
var time = 3000;
setInterval(imgchange, time);
function imgchange() {
	var val = $(".imgbox").css("left");
	if(val == "0px") {
		$(".imgbox").css("left", "-200px");
	} else {
		$(".imgbox").css("left", "0px");
	}
}