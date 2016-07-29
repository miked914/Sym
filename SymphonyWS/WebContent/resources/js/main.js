
var isInfoDisplay = false;
var isDisplayOpen = true;

document.getElementById("appButton").onclick = function() {
	if(isInfoDisplay == false){
		document.getElementById("appContainer").style.width = "7%";
//		document.getElementById("appContainer").style.height = "15%";
//		document.getElementById("appButton").style.width = "52px";
//		document.getElementById("appButton").style.margin = "2%";
//		document.getElementById("infoContainer").style.margin = "0";
//		document.getElementById("infoContainer").style.width = "0";
//		document.getElementById("infoContainer").style.height = "0";
		document.getElementById("infoContainer").style.opacity = 0;
		document.getElementById("infoContainer").style.visibility = "hidden";
//		document.getElementById("infoContainer").getElementByTagName("td").style.width = "0";
		document.getElementById("appButton").style.transform = "rotate(180deg)";
//		document.getElementById("appButton").style.width = "80%";
//		document.getElementById("appButton").style.transform = "translate(200,0)";
		isInfoDisplay = true;
		isDisplayOpen = false;

	} else if(isInfoDisplay == true){
		document.getElementById("appContainer").style.width = "80%";
//		document.getElementById("appContainer").style.height = "15%";
//		document.getElementById("appButton").style.width = "52px";
//		document.getElementById("infoContainer").style.width = "70%";
		document.getElementById("infoContainer").style.visibility = "visible";
		document.getElementById("infoContainer").style.opacity = 1;
//		document.getElementById("appButton").style.width = "%";
		document.getElementById("appButton").style.transform = "rotate(0deg)";
		
	//	document.getElementById("appButton").style.width = "5%";
		isInfoDisplay = false;
		isDisplayOpen = true;
	} else {
		alert("Doesn't Work");
		isInfoDisplay = true;
	}
}

function getIsDisplayOpen() {
	return isDisplayOpen;
}