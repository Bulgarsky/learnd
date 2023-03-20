function setImgSize() {
    let value = Number(document.getElementById("setImgSizeRange").value);
    document.querySelector("img").style.width = value+"%";
}

function filtersAtOnce() {
    const img = document.getElementById("img");
    const opacity = Number(document.getElementById("setOpacityRange").value);
    const contrast = Number(document.getElementById("setContrastRange").value);
    const invert = Number(document.getElementById("setInvertRange").value);
    const grayscale = Number(document.getElementById("setGrayscaleRange").value);
    const saturate = Number(document.getElementById("setSaturateRange").value);
    const sepia = Number(document.getElementById("setSepiaRange").value);
    const huerotate = Number(document.getElementById("setHueRotateRange").value);
    const blur = Number(document.getElementById("setBlurRange").value);
    const brightness = Number(document.getElementById("setBrightnessRange").value);

    img.style.filter = `
        opacity(${opacity}%)
         contrast(${contrast * 10}%)
          invert(${invert}%)
           grayscale(${grayscale}%)
            saturate(${saturate * 10}%)
             sepia(${sepia}%)
              hue-rotate(${huerotate}deg)
               blur(${blur}px)
                brightness(${brightness}%)`
                ;
}
