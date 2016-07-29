/**
 * 
 */
var open;
var firstClick;
open = false;

function setOpen(val){
	open = val;
}

function openNav() {
    document.getElementById("mySidenav").style.width = "20%";
    document.getElementById("main").style.marginLeft = "20%";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
   /* 
    if (getIsDisplayOpen()==false) {
    	document.getElementById("appContainer").style.marginLeft = "0";
    }    
    */
    
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.body.style.backgroundColor = "white";
    
}

function toggleNav(){
	
	if (open){
		
		closeNav();
	}
	else if (open===false){
		
		openNav();
	}
		
	if (open){
		open=false;
	}
	else {
		open=true;
	}
}