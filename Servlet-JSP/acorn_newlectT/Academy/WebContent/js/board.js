/**
 * 
 */

window.addEventListener("load", function() {
	var addListButton = document.querySelector(".add-list-button");
	var cancelListButton = document.querySelector(".cancel-list-button");
	var listAddForm = document.querySelector(".list-add-form");
	var listTitleInput = document.querySelector(".list-title-input");
	var contentBox= document.querySelector(".content-box");
	
	listAddForm.onsubmit = function(e) {
		e.preventDefault(); // post하는 작업을 막아버림, 따로 작업을 해줘야한다.

		var title = listTitleInput.value;
		
		if (title == "") {
			alert("제목을 입력하지 않았습니다.");
			return;
		}
		
		
		
		var xhr = new XMLHttpRequest();
		xhr.open('POST', 'reg', true); // 비동기 옵션
		// 비동기옵션 true : 비동기요청 false:동기형
		
	
		xhr.onload = function() {
			//전송할 데이터를 보내는 문자열
			//t=?
			var result=JSON.parse(xhr.responseText);
			console.log(result.title);
			var formDiv=contentBox.lastElementChild;
			
			//노드 추가: appendChild / append 
			//노드 삽입 : insertBefore/ insertAdjacentElement / insertAdjacentHTML
			var template =`<div>
				<section class="todo-list-box">
					<header>
						<h1>${result.title}</h1>
						<div>숨김버튼</div>
					</header>
					<div></div>

				</section>
			</div>`;
			console.log(template);
			formDiv.insertAdjacentHTML("beforebegin", template);
			
			console.log(result);
			
		};
	
//		1번째 방법
//		var data=`t=${title}`; -> url-encoded 방식
//		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
//		2번째 방법
		var json={"title":title, "regMemberId":"devlimk1"}; //json 방식
		var data=JSON.stringify(json) //객체를 문자열로 바꾸기
		xhr.setRequestHeader("Content-type", "application/json");
		
		xhr.send(data);//url-encoded,json,binary....등으로 보내질 수 있다.
	}

	addListButton.onclick = function(e) { //리스트 추가버튼
		e.preventDefault();
		/* alert("aa"); */

		// 1. 숨겨진 입력 박스를 띄우고, 라벨은 숨긴다.
		var spans = document.querySelectorAll(".list-add-form span");

		var labelSpan = spans[0];
		var inputSpan = spans[1];

		inputSpan.classList.remove("d-none");
		labelSpan.classList.add("d-none");

		// 2. 입력된 값을 등록하는 이벤트가 발생하면 서버로 전송

		// 3. 새로 입력된 리스트를 데이터를 받아서 화면을 갱신한다.
	};

	cancelListButton.onclick = function(e) { //취소버튼
		e.preventDefault();

		var spans = document.querySelectorAll(".list-add-form span");
		var labelSpan = spans[0];
		var inputSpan = spans[1];

		inputSpan.classList.add("d-none");
		labelSpan.classList.remove("d-none");
	}
});