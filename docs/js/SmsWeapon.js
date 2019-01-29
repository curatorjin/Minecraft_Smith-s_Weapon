$(function() {
	$("#itemBtn").click(function() {
		$("#headerContent").animate({
				opacity:'0',height:'0px'
			},
			500,function(){
				$("#headerContent").hide();
			});
	});

	$("#weaponBtn").click(function() {
		$("#headerContent").show();
		$("#headerContent").animate({
				opacity:'1',height:'150px'
			},
			500);
	});
})
