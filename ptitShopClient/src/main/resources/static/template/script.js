
//jquery push-down dropdown
$(document).ready(function() {
	$(".menu-li-product").click(function() {
    //slide up all the link lists

    $(".dropdown-box-product").slideUp();

    if (!$(this).next().is(":visible")) {
    	$(this).next().slideDown();
    }
    //slide down the link list below the h3 clicked - only if its closed
    
})
})

$(document).ready(function() {
	$(".menu-li-report").click(function() {
    //slide up all the link lists

    $(".dropdown-box-report").slideUp();

    if (!$(this).next().is(":visible")) {
    	$(this).next().slideDown();
    }
    //slide down the link list below the h3 clicked - only if its closed
    
})
})

//js pop-up form
function openFormAddEmployee() {
	document.getElementById("add-employee-fullscreen-container").style.display = "block";
}

function addProduct(){
	document.getElementById("category").style.display = "block";
	document.getElementById("employee").style.display = "none";
	document.getElementById("reportProduct").style.display = "none";
	document.getElementById("reportCustomer").style.display = "none";
	document.getElementById("down-products").style.display = "block";
}
function closeFormAddEmployee() {
	document.getElementById("add-employee-fullscreen-container").style.display = "none";
}

function openFormAddCategory() {
	document.getElementById("add-category-fullscreen-container").style.display = "block";
}

function closeFormAddCategory() {
	document.getElementById("add-category-fullscreen-container").style.display = "none";
}

function openFormEditEmployee() {
	document.getElementById("edit-employee-fullscreen-container").style.display = "none";
}

function closeFormEditEmployee() {
	document.getElementById("edit-employee-fullscreen-container").style.display = "none";
}

function openFormEditCategory() {
	document.getElementById("edit-category-fullscreen-container").style.display = "none";
}

function closeFormEditCategory() {
	document.getElementById("edit-category-fullscreen-container").style.display = "none";
}

function switchCategory() {
	document.getElementById("category").style.display = "block";
	document.getElementById("employee").style.display = "none";
	document.getElementById("reportProduct").style.display = "none";
	document.getElementById("reportCustomer").style.display = "none";
}

function switchEmployee() {
	document.getElementById("employee").style.display = "block";
	document.getElementById("category").style.display = "none";
	document.getElementById("reportProduct").style.display = "none";
	document.getElementById("reportCustomer").style.display = "none";
}

function switchReportProduct() {
	document.getElementById("reportProduct").style.display = "block";
	document.getElementById("category").style.display = "none";
	document.getElementById("employee").style.display = "none";
	document.getElementById("reportCustomer").style.display = "none";
}

function switchReportCustomer() {
	document.getElementById("reportCustomer").style.display = "block";
	document.getElementById("category").style.display = "none";
	document.getElementById("employee").style.display = "none";
	document.getElementById("reportProduct").style.display = "none";
}