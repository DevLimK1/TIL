/**
 * 저작자 : 라면모아 생성이 : 라면모아 저작권 : 라면모아 설명: 참고 url:
 */

function removeShield(selector) {
	// shield를 수거해야함
	var parentNode = document.querySelector(selector);
	var shield = parentNode.querySelector(".shield");
	// 부모.appendChild < = > 부모.removeChild()
	// 부모.append <=> 자신.remove()
	// s.parentElementNode.removeChild(s);
	shield.remove();
}

// 1.showShield(".main");
// 2. showShield(,true);
function showShield(selector, fullscreen) {

	var hostNode = document.querySelector(selector);

	var shield = document.createElement("div");
	shield.className = "shield";
	// body의 막내로 쉴드를 추가하고
	// 크기는 화면 크기로
	// 배경색은 검은색 opacity는 0.5
	hostNode.style.position = "relative";
	shield.style.backgroundColor = "black";
	shield.style.opacity = 0.5;
	shield.style.position = "absolute";
	shield.style.left = "0px";
	shield.style.top = "0px";
	shield.style.width = "100%";
	shield.style.height = "100%";
	shield.style.display = "flex";
	shield.style.justifyContent = "center";
	shield.style.alignItems = "center";

	var icon = document.createElement("img");
	// icon.src="../images/ajax-loader.gif";
	icon.src = "/images/ajax-loader.gif"; // 컨택스트경로가 / 일때 절대경로
	// shield.appendChild(icon) 은 TextNode...
	shield.append(icon);

	hostNode.append(shield);

}
