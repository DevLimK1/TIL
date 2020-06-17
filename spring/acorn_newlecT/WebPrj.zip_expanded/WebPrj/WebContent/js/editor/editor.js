window.addEventListener("load", function(){
	
	var editor = document.querySelector(".editor");
	var htmlArea = editor.querySelector(".html-area");
	var boldButton = editor.querySelector(".btn-bold");
	var italicButton = editor.querySelector(".btn-italic");
	var imgButton = editor.querySelector(".btn-img");
	var fileButton = editor.querySelector(".btn-file");
	
	fileButton.oninput = function(e){		
		//상자가 열리고 거기서 파일을 선택하면 상자가 닫힌다.
		// 그럼 현재 선택된 파일의 정보는 어떻게 되는가?
		var files = e.target.files;
		if(files.length > 1){
			alert("파일은 하나만 선택할 수 있습니다.");
			return;
		}
		
		var file = files[0];
		//for(var k in file)
			console.log(file.name + "," + file.type);
		
		//var regEx = new RegExp("image/(jpg|png|gif)");
		//console.log(file.type.match(regEx));
		/*if(file.size > 1024*1024*10){
			alert("너무 파일이 부담되요. 연료부족!!!");
			return;
		}*/
			
		// 아~ 이미지 파일을 하나를 선택했고 이제 그것을 업로드 해야겠다.
		var formData = new FormData();
		formData.append("file", file);
		formData.append("title", "Hello");		
		
		var xhr = new XMLHttpRequest();
		
		xhr.open("POST", "/upload", true);
		xhr.upload.addEventListener("progress", function(e){
			console.log(Math.round(e.loaded*100/e.total)+"%");
		});
		xhr.onload = function(){
			// 선택 영역이라는 것이 있어야만 이미지가 그 위치를 알 수 있고
			// 그래야 삽입이 되는구나.
						
			htmlArea.focus();
			
			document.execCommand("insertHTML" ,
					false, 
					`<img style="width:200px;" src="/upload/${file.name}" >`);
			
		};
		xhr.send(formData);		
		
			
		
	};
	imgButton.onclick = function(e){		
		e.preventDefault();		
		
		console.log("test");
		//fileButton의 onClick을 트리커하는 코드
		var event = new MouseEvent("click", {
	        'view': window,
	        'bubbles': true,
	        'cancelable': true
	    });
	    
		fileButton.dispatchEvent(event);
	};
	boldButton.onclick = function(e){		
		e.preventDefault();
		document.execCommand("bold");
	};
	italicButton.onclick = function(e){		
		e.preventDefault();
		document.execCommand("italic");
	};
});