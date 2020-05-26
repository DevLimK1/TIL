window.addEventListener("load", function () {
  var section = document.querySelector("#s1");
  var addButton = section.querySelector(".add-button");
  var delButton = section.querySelector(".del-button");
  var changeButton = section.querySelector(".change-button");
  var loadButton = section.querySelector(".load-button");
  var table = section.querySelector("table");

  var notices = [
    { id: 1, title: "id:1 is good", wirterId: "id:1" },
    { id: 2, title: "id:2 is good", wirterId: "id:2" },
    { id: 3, title: "id:3 is good", wirterId: "id:3" },
  ];

  addButton.onclick = addButtonClick;
  delButton.onclick = delButtonClick;
  changeButton.onclick = changeButtonClick;
  loadButton.onclick = loadButtonClick;

  function addButtonClick() {
    alert("add");
  }

  function delButtonClick() {
    alert("del");
  }

  function changeButtonClick() {
    alert("change");
  }

  function loadButtonClick() {
    var tbody = table.querySelector("tbody");

    console.log(tbody);

    //1.노드 생성방법

    //1-3 복잡한 엘리먼트 노드 생성

    // 나름 꼼수인데 괜찮은 노드 생성방법

    for(var i in notices){
        var trContent = `<td>${notices[i].id}</td>
        <td>${notices[i].title}</td>
        <td>${notices[i].wirterId}</td>    `;

      var tr = document.createElement("tr");
      tr.innerHTML = trContent;
      tbody.appendChild(tr);
    }

    // for (var i = 0; i < notices.length; i++) {
    //   var trContent = `<td>${notices[i].id}</td>
    //     <td>${notices[i].title}</td>
    //     <td>${notices[i].wirterId}</td>    `;

    //   var tr = document.createElement("tr");
    //   tr.innerHTML = trContent;
    //   tbody.appendChild(tr);
    // }

    // -------------------------------------
    // var tr=document.createElement("tr");
    // var tds=[
    //     document.createElement("td"),
    //     document.createElement("td"),
    //     document.createElement("td"),
    // ];

    // tds[0].innerText=notices[0].id;
    // tds[1].innerText=notices[0].title;
    // tds[2].innerText=notices[0].wirterId;

    // tr.appendChild(tds[0]);
    // tr.appendChild(tds[1]);
    // tr.appendChild(tds[2]);

    // tbody.appendChild(tr);

    // -------------------------------------

    //1-2 엘리먼트 노드 생성
    //** innerHTML을 사용하는 방법은 노! 절대로 사용하지 말것!! 왜? [ object -> string변환 -> innerHTML += ] 실행 사이클 반복됨 */
    // tr.innerHTML+=`<td>${notices[0].title}</td>`;
    //tr.innerHTML=`<td>${notices[0].title}</td>`; 은 사용해도 괜찮음!
    // 아래코드를 사용하자! 직접 appendchild해라!
    // var td=document.createElement("td");
    // tr.appendChild(td);

    //1-1. 텍스트 노드 생성
    // var textNode= document.createTextNode(notices[0].wirterId);
    // td.appendChild(textNode);
    // td.innerText=notices[0].wirterId;
  }
});
