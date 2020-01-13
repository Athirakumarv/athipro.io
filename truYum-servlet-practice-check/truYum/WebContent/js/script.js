function validateMenuItemForm(){
    var name=document.forms["menuItemForm"]["name"].value;
    if(name== ""){
        alert("name is required");
        return false;
    }
var nameLength=name.length;
if(nameLength < 2 || nameLength > 65){
    alert("name should have 2 to 65 characters");
    return false;
}
var price = document.forms["menuItemForm"]["price"].value;
if(isNaN(price)){
    alert("Price has to be a number");
    return false;
}
if(price == ""){
    alert("Price is required");
    return false;
}
var dateOfLaunch = document.forms["menuItemForm"]["dateOfLaunch"].value;
if(dateOfLaunch == ""){
    alert("Date of Launch is required");
    return false;
}
if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
    alert("Incorrect data format.Expected format(dd/mm/yyyy)");
    return false;
}
var genre=document.forms["menuItemForm"]["category"].value;
if(genre==''){
    alert("Select one Category");
    return false;
}
}
