const oHtml = document.getElementsByTagName('html')[0]
const width = oHtml.clientWidth; // 320px的屏幕基准像素为12px 
oHtml.style.fontSize = 12 * (width / 1200) + "px";