function selectFont() {
    let element = document.querySelector("#editor");
    element.style.fontFamily = document.getElementById("fonts").value;
}
function selectSize() {
    let element = document.querySelector("#editor");
    element.style.fontSize = document.getElementById("fontSize").value+"pt";
}
function selectColor() {
    let element = document.querySelector("#editor");
    element.style.color = document.getElementById("fontColor").value;
}
function selectAlignLeft() {
    let element = document.querySelector("#editor");
    element.style.textAlign = "left";
}
function selectAlignCenter() {
    let element = document.querySelector("#editor");
    element.style.textAlign = "center";
}
function selectAlignRight() {
    let element = document.querySelector("#editor");
    element.style.textAlign = "right";
}
function selectTypeItalic() {
    let element = document.querySelector("#editor");
    if (getComputedStyle(element).fontStyle == "italic") {
        element.style.fontStyle = "normal"
    } else {
        element.style.fontStyle = "italic"
    }
}
function selectTypeBold() {
    let element = document.querySelector("#editor");
    if (getComputedStyle(element).fontWeight == 400) {
        element.style.fontWeight = "700"; // "bold"
    } else {
        element.style.fontWeight = "400"; // "normal"
    }
}
function selectTypeUnderline() {
    let element = document.querySelector("#editor");
    if (getComputedStyle(element).textDecorationLine == "none") {
        element.style.textDecoration = "underline"
    } else {
        element.style.textDecoration = "none"
    }
}