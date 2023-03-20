function setOpacity() {
    const value = Number(document.getElementById("setOpacityRange").value);
    document.querySelector("img").style.filter = `opacity(${value}%)`;
}
function setContrast() {
    const value = Number(document.getElementById("setInvertRange").value);
    document.querySelector("img").style.filter = `contrast(${value * 10}%)`;
}
function setInvert() {
    const value = Number(document.getElementById("setInvertRange").value);
    document.querySelector("img").style.filter = `invert(${value}%)`;
}
function setGrayscale () {
    const value = Number(document.getElementById("setGrayscaleRange").value);
    document.querySelector("img").style.filter = `grayscale(${value}%)`;
}
function setSaturate () {
    const value = Number(document.getElementById("setSaturateRange").value);
    document.querySelector("img").style.filter = `saturate(${value * 10}%)`;
}

function setSepia() {
    const value = Number(document.getElementById("setSepiaRange").value);
    document.querySelector("img").style.filter = `sepia(${value}%)`;
}
function setHueRotate () {
    const value = Number(document.getElementById("setHueRotateRange").value);
    document.querySelector("img").style.filter = `hue-rotate(${value}deg)`;
    }

function setBlur() {
    const value = Number(document.getElementById("setBlurRange").value);
    document.querySelector("img").style.filter = `blur(${value}px)`;
}
function setBrightness() {
    const value = Number(document.getElementById("setBrightnessRange").value);
    document.querySelector("img").style.filter = `brightness(${value}%)`;
}
function setImgSize() {
    const value = Number(document.getElementById("setImgSizeRange").value);
    document.querySelector("img").style.width = value+"%";
}