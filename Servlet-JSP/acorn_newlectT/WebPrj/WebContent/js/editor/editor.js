/**
 * 
 */

window.addEventListener("load", function() {
	var editor = document.querySelector(".editor");
	var boldButton = editor.querySelector(".btn-bold");
	var italicButton = editor.querySelector(".btn-italic");
	var imgButton = editor.querySelector(".btn-img");// 트리거 위한 버튼
	var fileButton = editor.querySelector(".btn-file");
	var htmlArea=editor.querySelector(".html-area");
	
	fileButton.oninput = function(e) {
		// e.preventDefault();
		// 상자가 열리고 거기서 파일을 선택하면 상자가 닫힌다.
		// 그럼 현재 선택된 파일의 정보는 어떻게 되는가??
		var files = e.target.files;
		if (files.length > 1) {
			alert('파일은 하나만 선택할 수 있습니다.');
			return;
		}
		
		// console.log(e.target.files.length) //파일이 선택되면 1, 안되면 0이 된다.

		var file = files[0];
		console.log(file.name + "," + file.type);
		// 정규식 문자열 => "image/jpg", "image/png", "image/gif" 만 허락하겠다.
		// "image/(jpg|png|gif)"
		
		var regEx = new RegExp('image/(jpg|png|gif)');
		console.log(regEx);
		console.log(file.type.match(regEx));
		
		//파일사이즈 제한
//		if(file.size>1024*1024*10){ //10MB넘는다면
//			alert('파일 사이즈가 큽니다. 10MB 넘지 않게해주세요.');
//			return;
//		}
		
		//아~ 이미지 파일을 하나를 선택헀고 이제 그것을 업로드 해야겠다.
		var formData = new FormData();
		formData.append("file",file);
		formData.append("title","Hello");
		
		var xhr = new XMLHttpRequest();
		
		xhr.open("POST","/upload",true);
		xhr.upload.addEventListener("progress",function(e){ //파일 올라가는 진척도
			console.log(e.loaded+" / "+e.total);
			//퍼센테이지로 출력하기
			console.log(Math.round(e.loaded*100/e.total)+"%");
		});
		
		xhr.onload= function(){
			console.log(xhr.responseText);
//			document.execCommand("insertImage",null,"/upload/");
			//선택 영역이라는 것이 있어야만 이미지가 그 위치를 알 수 있고,
			//그래야 삽입이 되는구나.
			
			htmlArea.focus();
			
			
			document.execCommand("insertHTML",false,
					`<img style="width:100px;" src="/upload/${file.name}">`);
				
			
		};
		xhr.send(formData);

	};

	imgButton.onclick = function(e) {
		e.preventDefault();

		// fileButton의 onClick을 트리거하는 코드
		var event = new MouseEvent("click", {
			'view' : window,
			'bubbles' : true,
			'cancelable' : true
		});
		fileButton.dispatchEvent(event);

	};

	boldButton.onclick = function(e) {
		e.preventDefault();
		document.execCommand("bold");
	};

	italicButton.onclick = function(e) {
		e.preventDefault();
		document.execCommand("italic");
	}

});