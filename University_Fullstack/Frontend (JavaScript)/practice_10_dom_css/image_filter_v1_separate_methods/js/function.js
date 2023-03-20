function setOpacity() {
    let value = Number(document.getElementById("setOpacityRange").value);
    document.querySelector("img").style.filter = `opacity(${value}%)`;
}
function setContrast() {
    let value = Number(document.getElementById("setInvertRange").value);
    document.querySelector("img").style.filter = `contrast(${value * 10}%)`;
}
function setInvert() {
    let value = Number(document.getElementById("setInvertRange").value);
    document.querySelector("img").style.filter = `invert(${value}%)`;
}
function setGrayscale () {
    let value = Number(document.getElementById("setGrayscaleRange").value);
    document.querySelector("img").style.filter = `grayscale(${value}%)`;
}
function setSaturate () {
    let value = Number(document.getElementById("setSaturateRange").value);
    document.querySelector("img").style.filter = `saturate(${value * 10}%)`;
}

function setSepia() {
    let value = Number(document.getElementById("setSepiaRange").value);
    document.querySelector("img").style.filter = `sepia(${value}%)`;
}
function setHueRotate () {
    let value = Number(document.getElementById("setHueRotateRange").value);
    document.querySelector("img").style.filter = `hue-rotate(${value}deg)`;
    }

function setBlur() {
    let value = Number(document.getElementById("setBlurRange").value);
    document.querySelector("img").style.filter = `blur(${value}px)`;
}
function setBrightness() {
    let value = Number(document.getElementById("setBrightnessRange").value);
    document.querySelector("img").style.filter = `brightness(${value}%)`;
}
function setImgSize() {
    let value = Number(document.getElementById("setImgSizeRange").value);
    document.querySelector("img").style.width = value+"%";
}