function setImgSize() {
    let value = Number(document.getElementById("setImgSizeRange").value);
    document.querySelector("img").style.width = value+"%";
}

function filtersAtOnce() {
    let img = document.getElementById("img");
    let Opacity = Number(document.getElementById("setOpacityRange").value);
    let Contrast = Number(document.getElementById("setContrastRange").value);
    let Invert = Number(document.getElementById("setInvertRange").value);
    let Grayscale = Number(document.getElementById("setGrayscaleRange").value);
    let Saturate = Number(document.getElementById("setSaturateRange").value);
    let Sepia = Number(document.getElementById("setSepiaRange").value);
    let Huerotate = Number(document.getElementById("setHueRotateRange").value);
    let Blur = Number(document.getElementById("setBlurRange").value);
    let Brightness = Number(document.getElementById("setBrightnessRange").value);

    img.style.filter = `
        opacity(${Opacity}%)
         contrast(${Contrast * 10}%)
          invert(${Invert}%)
           grayscale(${Grayscale}%)
            saturate(${Saturate * 10}%)
             sepia(${Sepia}%)
              hue-rotate(${Huerotate}deg)
               blur(${Blur}px)
                brightness(${Brightness}%)`
                ;
}
