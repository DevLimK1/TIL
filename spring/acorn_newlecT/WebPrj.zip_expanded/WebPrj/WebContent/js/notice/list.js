window.addEventListener("load", function(){	
	var notices = [
		{id:1, title:"hello", writerId:"newlec"},
		{id:2, title:"hi~", writerId:"newlec"}
	];
    
    var section = document.querySelector(".notice");
    var table = section.querySelector(".table");
    var pager = document.querySelector(".pager");
    var ul = pager.querySelector("ul");
    var nums = ul.querySelectorAll("a");
    var shield = new Shield(".main");
        
    ul.onclick = function(e){
    	// 엘리먼트 노드가 가지는 기본 행위를 막는 함수
    	e.preventDefault();
    	// A 태그가 클릭 된 것이 아닌 경우 함수를 끝내기 
    	if(e.target.nodeName != "A") return;
    	console.log(e.target);
    	
    	var page = e.target.innerText;
    	console.log(page);
    	
    	// XmlHttpRequest : callback 개념의 라이브러리
    	var xhr = new XMLHttpRequest();
    	xhr.open('GET', 'list-data?p='+page, true); // 비동기옵션
    	xhr.onload = function () {
    		notices = JSON.parse(xhr.responseText);
        	bind();
        	shield.hide();
    	};
    	xhr.send(null);    	
    	
    	shield.show();
    	// body의 막내로 쉴드를 추가하고
    	// 크기는 화면 크기로
    	// 배경색은 검은색 opacity는 0.5
    	
    	
    	// 동기형으로 처리 했기 때문에 응답이 올때까지 기다린다. 만약에 안오면? 물망초가 되기
    	
    	// xhr.send('string');
    	// xhr.send(new Blob());
    	// xhr.send(new Int8Array());
    	// xhr.send(document);  	    	
    	
    	// FetchAPI : promise 개념의 라이브러리
    	
    };
    
    /*for(var i=0; i<nums.length; i++){
        nums[i].onclick = function(){
            alert("clicked");
        };
    }*/

	//bind(); // 데이터를 dom으로 출력하는 작업
	
	//----------------------------------
	
	function bind(){
		var tbody = table.querySelector("tbody");
		
		var tbodyContent = "";
		for(var i in notices){
	        var n = notices[i];
	        var template = `<tr>
	                            <td>${n.id}</td>
	                            <td class="title indent text-align-left"><a href="detail?id=${n.id}">${n.title}</a></td>
	                            <td>${n.writerId }</td>
	                            <td>	                                
	                            </td>
	                            <td></td>
                            </tr>`;
            
            tbodyContent = tbodyContent.concat(template);
            //tbodyContent = tbodyContent + template;
		}
		tbody.innerHTML = tbodyContent;
	};
});