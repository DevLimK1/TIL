window.addEventListener("load", function () {
  var section = document.querySelector("#s6");
  var boxes = section.querySelectorAll(".box");
  var rotateButton = section.querySelector("input[name=rotate-button]");
  var gobackButton = section.querySelector("input[name=goback-button]");
  // var description =section.querySelectorAll(".description");
  rotateButton.onclick = rotateButtonClick;
  gobackButton.onclick = gobackButtonClick;

  var boxStyle = window.getComputedStyle(boxes[0]); //css에 있는 계산값을 가지고 옴
  boxes[0].style.left = boxStyle.getPropertyValue("left");
  // console.log( boxes[0].style.left);
  boxes[0].style.top = boxStyle.getPropertyValue("top");

  boxes[0].addEventListener("transitionend", function () {
    console.log("transitionend");
    //.description 엘리먼트에서
    // boxes[0].lastElementChild.classList.remove("d-none");
    boxes[0].lastElementChild.classList.add("slide-up");
  });

//   boxes[0].addEventListener("transitionstart", function () {
//     console.log(boxes[0].lastElementChild.className);
//     //.description 엘리먼트에서
    
//     boxes[0].lastElementChild.classList.remove("slide-up");
//   });

  //  boxes[0].addEventListener("transitionstart",function(){
  //     console.log("끝났어요~");
  //     //.description 엘리먼트에서
  //     boxes[0].lastElementChild.classList.add("d-none");

  // });

  function gobackButtonClick() {
    boxes[0].style.left = "0px";
    boxes[0].style.top = "0px";
    boxes[0].style.transform = `translate(0px) scale(1)`;
  }

  function rotateButtonClick() {
    //우리가 transform을 사용할 때는 스타일을 이용한 변경이라서
    //스타일(css)로 초기화 한 것이 적용에 문제가 없음.
    //다만 css로 초기화 한 값을 js 변경할 때 문제가 있다.

    //   var transitionX=Math.random()*150+100; //0~1 => 100~250까지의 값(사이값:150)
    var transitionX = Math.random() * 500 - 250; //0~1 => -250~250까지의 값(사이값:500)
    var scale = Math.random() * 0.5 + 1; //0~1 => 1~1.5 (사이값:0.5)

    boxes[0].style.transform = `translate(${transitionX}px) scale(${scale})`;
  }
});

window.addEventListener("load", function () {
  var section = document.querySelector("#s5");
  var boxes = section.querySelectorAll(".box");
  var rotateButton = section.querySelector("input[name=rotate-button]");
  var gobackButton = section.querySelector("input[name=goback-button]");
  // var description =section.querySelectorAll(".description");
  rotateButton.onclick = rotateButtonClick;
  gobackButton.onclick = gobackButtonClick;

  var boxStyle = window.getComputedStyle(boxes[0]); //css에 있는 계산값을 가지고 옴
  boxes[0].style.left = boxStyle.getPropertyValue("left");
  // console.log( boxes[0].style.left);
  boxes[0].style.top = boxStyle.getPropertyValue("top");

  boxes[0].addEventListener("transitionend", function () {
    console.log("끝났어요~");
    //.description 엘리먼트에서
    boxes[0].lastElementChild.classList.remove("d-none");
  });

  boxes[0].addEventListener("transitionstart", function () {
    console.log("끝났어요~");
    //.description 엘리먼트에서
    boxes[0].lastElementChild.classList.add("d-none");
  });

  function gobackButtonClick() {
    boxes[0].style.left = "0px";
    boxes[0].style.top = "0px";
    boxes[0].style.transform = `translate(0px) scale(1)`;
  }

  function rotateButtonClick() {
    //우리가 transform을 사용할 때는 스타일을 이용한 변경이라서
    //스타일(css)로 초기화 한 것이 적용에 문제가 없음.
    //다만 css로 초기화 한 값을 js 변경할 때 문제가 있다.

    //   var transitionX=Math.random()*150+100; //0~1 => 100~250까지의 값(사이값:150)
    var transitionX = Math.random() * 500 - 250; //0~1 => -250~250까지의 값(사이값:500)
    var scale = Math.random() * 0.5 + 1; //0~1 => 1~1.5 (사이값:0.5)

    boxes[0].style.transform = `translate(${transitionX}px) scale(${scale})`;
  }
});

window.addEventListener("load", function () {
  var section = document.querySelector("#s4");
  var boxes = section.querySelectorAll(".box");
  var rotateButton = section.querySelector("input[name=rotate-button]");

  rotateButton.onclick = rotateButtonClick;

  var rotateIndex = 0;

  function rotateButtonClick() {
    for (var i = 0; i < boxes.length; i++) {
      var removeIndex = (i + rotateIndex) % 3;
      var addIndex = (i + 1 + rotateIndex) % 3;

      boxes[i].classList.remove(`pos${removeIndex}`);
      boxes[i].classList.add(`pos${addIndex}`);
    }
    rotateIndex++;
  }
});

window.addEventListener("load", function () {
  var section = document.querySelector("#s3");
  var boxes = section.querySelectorAll(".box");
  var rangeInput = section.querySelector(".range-input");
  var startButton = section.querySelector("input[name=start-button]");
  var rotateButton = section.querySelector("input[name=rotate-button]");

  //   startButton.onclick = startButtonClick;
  rotateButton.onclick = rotateButtonClick;

  function startButtonClick() {
    for (var i = 0; i < boxes.length; i++) {
      boxes[i].classList.add("pos" + i);
    }
  }

  var rotateIndex = 0;

  function rotateButtonClick() {
    //   console.log('rotateIndex:'+rotateIndex);
    //   console.log(removeIndex);
    //   console.log(addIndex);
    for (var i = 0; i < boxes.length; i++) {
      var removeIndex = (i + rotateIndex) % 3;
      var addIndex = (i + 1 + rotateIndex) % 3;
      boxes[i].classList.remove(`pos${removeIndex}`);
      boxes[i].classList.add(`pos${addIndex}`);
      //   console.log(removeIndex);
      //   console.log(addIndex);
    }
    rotateIndex++;
    // alert("회전");
    // boxs[0].classList.remove(`pos${0}`);
    // boxs[0].classList.add(`pos${0+1}`);
    // boxs[1].classList.remove(`pos${1}`);
    // boxs[1].classList.add(`pos${1+1}`);
    // boxs[2].classList.remove(`pos${2}`);
    // boxs[2].classList.add(`pos${0}`);
  }
});

window.addEventListener("load", function () {
  var section = document.querySelector("#s2");

  var rangeInput = section.querySelector(".range-input");
  var xInput = section.querySelector(".x-input");
  var widthInput = section.querySelector(".width-input");

  var rInput = section.querySelector(".r-input");
  var gInput = section.querySelector(".g-input");
  var bInput = section.querySelector(".b-input");

  //   var rgbInput=section.getElementsByTagName("bg-color");

  var container = section.querySelector(".container");
  var box = container.querySelector(".box");
  //변경완료 될 때 change가 일어나고 싶으면 onchange
  //입력 중일 떄는 oninput을 쓴다.
  //   rangeInput.onchange = function (e) {
  //     console.log(rangeInput.value);
  //   };

  rangeInput.oninput = function (e) {
    //   console.log(e);
    // console.log(xInput.checked);
    // console.log(rangeInput.value + 10);

    //x좌표 움직이는
    if (xInput.checked) {
      box.style.left = rangeInput.value + "px";
    }

    // ------------------------------------------------

    //너비 움직이는
    if (widthInput.checked) {
      box.style.width = 100 + parseInt(rangeInput.value) + "px";
    }
    // ------------------------------------------------

    //radio 버튼 누름에 따라 색상이 변화됨
    var r = 0;
    var g = 0;
    var b = 0;
    // console.log(rInput.checked);
    // console.log(gInput.checked);
    // console.log(bInput.checked);

    if (rInput.checked) r = parseInt(rangeInput.value);
    else if (gInput.checked) g = parseInt(rangeInput.value);
    else if (bInput.checked) b = parseInt(rangeInput.value);
    // console.log(r);
    // console.log(g);
    // console.log(b);
    box.style.backgroundColor = `rgb(${r},${g},${b})`;

    // box[0].style.left = (parseInt(rangeInput.value)*3) + "px";
    // box[0].style.height = (parseInt(rangeInput.value)*3) + "px";
    // box[0].style.top = yInput.value + "px";

    // box[0].style["background-color"] = colorInput.value;

    // ------------------------------------------------

    //현재 선택된 색상 정보를 얻기

    //방법1
    var radios = section.getElementsByClassName("color-input");
    // console.log(radios.length);
    var selected = null;
    for (i in radios) {
      if (radios[i].checked) {
        selected = radios[i];
        break;
      }
    }
    console.log(selected.className);

    //또 querySelector를 사용한 다른 방법2
    var selected = section.querySelector("input[type=radio]:checked");
    if (selected != null) {
      var model = selected.value + ":" + rangeInput.value;
      box.innerText = model;
    }

    // ------------------------------------------------
  };
});

window.addEventListener("load", function () {
  var section = document.querySelector("#s1");
  var xInput = section.querySelector(".x-input");
  var yInput = section.querySelector(".y-input");
  var movButton = section.querySelector(".mov-button");
  var colorInput = section.querySelector(".color-input");
  var box = section.querySelectorAll(".box");

  /* <input type="button" value="더하기" onclick="buttonClick();"> " 
    onclick="buttonClick(); 은 아래와 같이 됨
    movButton.onclick=function(){buttonClick();};*/

  //   {
  /* <input type="button" value="더하기" /> */
  //   }
  movButton.onclick = movButtonClick; //함수가 참조되는거임 -->script에서 사용

  function movButtonClick() {
    // console.log(box);
    box[0].style.left = xInput.value + "px";
    box[0].style.top = yInput.value + "px";

    //다음 스타일 속성은 오류를 유발한다.
    //box[0].style.background-color=colorInput.value;
    //해결방법1 : javascript 카멜케이스방식 제공
    // box[0].style.backgroundColor=colorInput.value;
    //해결방법2
    box[0].style["background-color"] = colorInput.value;
    // box[0]["style"]["background-color"]=colorInput.value;
  }
});

//function buttonClick() {
//   var section = document.querySelector("#s1");
//   //console.log(section.innerText);
//   var xInput = section.querySelector(".x-input");
//   var yInput = section.querySelector(".y-input");
//   var resultInput = section.querySelector(".result-input");

//   console.log(xInput.value);
//   console.log(yInput.value);

//  var x=  parseInt(xInput.value);
//  var y= parseInt(yInput.value);
//   resultInput.value = x + y;
//   // resultInput.value=eval(xInput.value+yInput.value);
// }

// console.log(xInput.value);
// alert(xInput.value);
// var ul = section.querySelector("ul");
// // var next=first.nextSibling;
// var first = ul.firstElementChild;
// first.innerText = "굳굳";
// var next = first.nextElementSibling;
// next.innerText = "찾았다";

// //노드 순회하기
// var section = document.querySelector("#some-menu");
// //console.log(section.innerText);

// var ul = section.querySelector("ul");
// // var next=first.nextSibling;
// var first = ul.firstElementChild;
// first.innerText = "굳굳";
// var next = first.nextElementSibling;
// next.innerText = "찾았다";

//노드 선택방법 5: Selectors API를 이용하여 선택하기
// var test=document.querySelector("#s1 input");
// test.value="진짜?  css 선택자를 사용가능??";

// =========예제==================================
//짜장면 메뉴를 삼선짜장으로 변경하시오.

// var section =document.querySelector("#some-menu");
// var menuItem=section.querySelector("li:first-child");
// menuItem.innerText="양장피";

// var menuItem= document.querySelector("#some-menu ul li:first-child");
// menuItem.innerText="삼선짜장";

// var menuItems= document.querySelectorAll("#some-menu ul li");
// menuItems[0].innerText="삼선짜장";

//노드 선택방법 4: 클래스,name 속성, 태그명을 이용한 선택
// var s1 = document.getElementById("s1");
// var tests = s1.getElementsByClassName("test"); //클래스명
// var tests2=s1.getElementsByTagName("input"); //태그명
// tests2[0].value= "잘 된다";
// tests[0].value = "굳굳";
// var test=document.getElementsByClassName("test");
// test[0].value="오잉 진짜?";

//노드 선택방법 3: 엘리먼트에 이름(식별자)를 부여해서 순회하는 방식
// var noticeTitle=document.getElementById("notice-title");
// noticeTitle.value="오잉 진짜?";

//노드 선택방법 2: 엘리먼트 노드만을 순회하는 방식
// window
//   .document
//   .body
//   .children[0]
//   .children[1]
//   .children[0].value = "엘리먼트 찾았당";

//노드 선택방법 1: 노드를 순회하는 방식
// window
//   .document
//   .body
//   .childNodes[1] //section
//   .childNodes[3] //div
//   .childNodes[0].value = "나 찾았어?"; //input

// alert(window
//   .document
//   .body
//   .childNodes[3].nodeType);
// }
