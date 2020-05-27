//Ajax-> 비동기로 자바스크립트를 이용해서 원격의 xml(데이터)를 요청해서 화면을 갱신하는 기술

window.addEventListener("load", function () {
  
	
	var notices = [
    { id: 1, title: "hello", writerId: "newlec" },
    { id: 2, title: "hi~", writerId: "newlec" },
  ];

  var section = document.querySelector(".notice");
  var table = section.querySelector(".table");
  var pager = document.querySelector(".pager");
  var ul = pager.querySelector("ul");
  var nums = ul.querySelectorAll("a");

// var section = document.querySelector(".pager");
// var ul = section.querySelector("ul");
// var nums = ul.querySelectorAll("a");
  
  
  ul.onclick = pagerClick;

  // 좋지 않은 방법 : 반복문으로 onclick 함수를 대입함
  // var section =document.querySelector(".pager");
  // var table=section.querySelector(".table");
  // var nums = section.querySelectorAll("ul a");

  // for(var i=0;i<nums.length;i++){
  // nums[i].onclick=function(){
  // alert("clicked");
  // };
  // }

  
  
  function pagerClick(e) {
    // 엘리먼트 노드가 가지는 기본 행위를 막는 함수
    e.preventDefault();
    // A 태그가 클릭 된 것이 아닌 경우 함수를 끝내기 , nodeName은 다 대문자로 나온다!! 소문자로 나오지 않음!!
    console.log(e.target.nodeName);
    
    if (e.target.nodeName != "A") return;
    console.log(e.target);
   
    var page=e.target.innerText;
    console.log(page);
    
    // XmlHttpRequest : callback 개념의 라이브러리
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'list-data?p='+page, true); 
    // 비동기옵션 true : 비동기요청 false:동기형

    xhr.onload = function () {
    	  notices=JSON.parse(xhr.responseText);
    	  bind();
    	  removeShield(".main");
    	  
    };
    xhr.send(null);
    
    showShield(".main");
    
//    var main = document.querySelector(".main");
//    var shield=document.createElement("div");
//    shield.className="shield";
//    //body의 막내로 쉴드를 추가하고
//    //크기는 화면 크기로
//    //배경색은 검은색 opacity는 0.5
//    main.style.position="relative";
//    shield.style.backgroundColor="black";
//    shield.style.opacity=0.5;
//    shield.style.position="absolute";
//    shield.style.left="0px";
//    shield.style.top="0px";
//    shield.style.width="100%";
//    shield.style.height="100%";
//    shield.style.display="flex";
//    shield.style.justifyContent="center";
//    shield.style.alignItems="center";
// 
//    
//    var icon = document.createElement("img");
//    icon.src="../images/ajax-loader.gif";
//    //shield.appendChild(icon) 은 TextNode...
//    shield.append(icon);
//
//    main.appendChild(shield);
   
   
    
    // 동기형(false)으로 처리했기 때문에 응답이 올때까지 기다린다.
    // 만약에 안오면? 물망초가 되기
    
// alert(xhr.responseText);
// notices=JSON.parse(xhr.responseText); => false 일 때는 가능
// bind();
    
    // xhr.send('string');
    // xhr.send(new Blob());
    // xhr.send(new Int8Array());
    // xhr.send(document);
    
    // FetchAPI : promise 개념의 라이브러리 -> es6버전부터 쓸 예정!
  }


// var bind = function () { --> bind() 하면 에러남
  function bind() {
    var tbodyContent = "";
    var tbody = document.querySelector(".table tbody");
    for (var i in notices) {
      var n = notices[i];
      var template = `<tr>
      <td>${n.id}</td>
      <td class="title indent text-align-left"><a href="detail?id=${n.id}">${n.title}</a></td>
      <td>${n.writerId}</td>
  </tr>`;

      tbodyContent = tbodyContent.concat(template);
      // tbodyContent = tbodyContent.concat(template);
      // console.log(tbodyContent);
    }
    tbody.innerHTML = tbodyContent;
  }
});

// window.addEventListener("load", function () {
// var notices = [
// { id: 1, title: "hello", writerId: "newlec" },
// { id: 2, title: "hi~", writerId: "newlec" },
// ];

// var table = document.querySelector(".notice .table");

// bind();

// // var bind = function () { --> bind() 하면 에러남
// function bind() {
// var n = notices[0];
// var template = `<tr>
// <td>${n.id}</td>
// <td class="title indent text-align-left"><a
// href="detail?id=${n.id}">${n.title}</a></td>
// <td>${n.writerId}</td>
// </tr>`;
// var tbody = table.querySelector("tbody");
// tbody.innerHTML = template;
// }
// });
