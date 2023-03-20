function injectSlider() {
    document.getElementById("injection").innerHTML=
        "<input type='range' min='0' max='100' value='0' class='slider' id='sliderRange' onchange='setFilterValue()'>";
}
function setFilterValue() {
    const value = Number(document.getElementById("sliderRange").value);
    const img = document.querySelector("img");

    if (document.getElementById("setOpacity").checked) {
        img.style.filter = `opacity(${value}%)`;
    }
    else if (document.getElementById("setContrast").checked) {
        img.style.filter = `contrast(${value*10}%)`;
    }
    else if (document.getElementById("setInvert").checked) {
        img.style.filter = `invert(${value}%)`;
    }
    else if (document.getElementById("setGrayscale").checked) {
        img.style.filter = `grayscale(${value}%)`;
    }
    else if (document.getElementById("setSaturate").checked) {
        img.style.filter = `saturate(${value*10}%)`;
    }
    else if (document.getElementById("setSepia").checked) {
        img.style.filter = `sepia(${value}%)`;
    }
    else if (document.getElementById("setHueRotate").checked) {
        img.style.filter = `hue-rotate(${value}deg)`;
    }
    else if (document.getElementById("setBlur").checked) {
        img.style.filter = `blur(${value}px)`;
    }
    else if (document.getElementById("setBrightness").checked) {
        img.style.filter = `brightness(${value}%)`;
    }
    //function end
}

function setImgSize() {
    const value = Number(document.getElementById("imgSize").value);
    document.querySelector("img").style.width = value+"%";
}