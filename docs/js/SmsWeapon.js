weapons = [];
items = [];
blocks = [];


$(function() {
	var itemsDiv = new Vue({
		el: "#itemsDisplay",
		data: {
			list: items
		}
	});
	var blocksDiv = new Vue({
		el: "#blocksDisplay",
		data: {
			list: blocks
		}
	});
	var weaponsDiv = new Vue({
		el: "#weaponsDisplay",
		data: {
			list: weapons
		}
	});

	$("#itemBtn").click(function() {
		$("#blocksDisplay").hide();
		$("#itemsDisplay").show();
		$("#weaponsDisplay").hide();
	});

	$("#weaponBtn").click(function() {
		$("#blocksDisplay").hide();
		$("#itemsDisplay").hide();
		$("#weaponsDisplay").show();
	});
	
	$("#blockBtn").click(function(){
		$("#blocksDisplay").show();
		$("#itemsDisplay").hide();
		$("#weaponsDisplay").hide();
	})
})

function getWeapons(jsonData) {
	weapons = jsonData;
}

function getItems(jsonData) {
	items = jsonData;
}

function getBlocks(jsonData) {
	blocks = jsonData;
}
