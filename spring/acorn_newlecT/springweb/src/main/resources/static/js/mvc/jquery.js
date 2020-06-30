$(function() {
	// load 된 후 실행
	var section = $("#s1");
	var xInput = section.find(".x-input");
	var span = section.find("span");
	var submitButton = section.find("input[type='submit']");
	var inner = section.find(".inner");

	// console.log(div);
	console.log(submitButton);
	console.log(span);
	// span.html("<b>hello</b>");
	span.addClass("span-style");

	submitButton.click(function() {

		/** ******************$.ajax************************** */
//		$.ajax("/notice/reg", { //header에 뭔가 추가해야할 때도 쓰임
//			url : "/notice/reg",
//			async : false,
//			cache : false
//		});

		/** ******************$.post()************************** */
		 $.post("/notice/reg",{title:"제목", content:"hhhhhho"}); //URL방식으로
		// 보내준다.
		// $.post("/notice/reg",inner.serialize());
		// console.log(inner.serialize()); //post방식
		// inner.load("/notice/list"); //page를 가져온다.
		/** ******************getScript()************************** */
		// $.getScript("/data",function(data){
		// console.log(data);
		// })
		//	  
		/** ******************empty()************************** */

		// inner.empty();
		/** ******************after(),clone()************************** */

		// inner.after(inner.clone());
		/** ******************append(),appendTo()************************** */
		// var span=$("<span>");
		// span.text("hello");
		// var span = $("<span>hello</span>");
		// inner.append(span);
		// inner
		// .append($("<span>hello</span>"));
		// $("<span>hello</span>").appendTo(inner);
		// $("<span>")
		// .text("hohoho")
		// .appendTo(inner);
		/** ******************offsetParent()************************** */
		// inner
		// .children()
		// .eq(2)
		// .parent()
		// // .offsetParent() //나의 위치좌표 기준
		// .css({background:"green"});
		/** ******************each()************************** */
		// var spans= inner
		// .find("span");
		// // for(var i=0;i<spans.length;i++)
		// // spans.eq(i).css({});
		// spans.each(function(idx,val){
		// // console.log(idx);
		// // console.log(val);
		// console.log(this);
		// console.log($(this).text());
		// });
		// // inner.eq(1)
		// // .css({ background: "green" });
		/** ******************odd()************************** */

		// inner.find("span").odd().css({ background: "green" });
		/** ****************first()**************************** */
		// inner
		// .children()
		// .first()
		// .next()
		// .css({background:"green"});
		/** *******************next()************************* */

		// inner
		// .next()
		// .css({background:"green"});
		/** *****************setInterval()*************************** */
		// var i = 0;
		// var timerId = window.setInterval(function () {
		// var height=parseInt(inner.css('height'));
		// height=(height+2)+"px";
		// console.log(height);
		// inner.css({
		// height:height
		// });
		// console.log("알람 울림...띠리릭!");
		// if (height > 300) clearInterval(timerId);
		// }, 17);
		/** **************stop()****************************** */
		// inner
		// .stop() //클릭하면 멈춤
		// .animate({
		// height:"200px"
		// },1000)
		// .animate({
		// left:"400px"
		// },2000);
		/** *******************hide(),show(),queue()************************* */

		// inner.hide(400).show(400).slideUp(500).slideDown(500);
		// setInterval(function(){
		// var ar=inner.queue("fx");
		// console.log(ar.length);
		// },300);
		// console.log("Test");
		/** ******************************************** */
		// inner //반환값을 가지기 때문에 꼬리에 꼬리 물기가 가능함->순차적으로 실행됨
		// .animate(
		// {
		// left: "200px"
		// },
		// 2000,function(){
		// inner
		// .animate({//inner.animate는 fontSize, background 적용이 안된다.
		// opacity:"0"
		// })
		// .animate({
		// height: "200px"
		// },2000)
		// }
		// );
		/** ******************************************** */
		// section.find("."+$.escapeSelector(".div")).css("background","red");
		// span.toggleClass("active");
		// var offset = span.offset();
		// var pos=span.position();
		// var offLeft=span.get(0).offsetLeft;
		// console.log(offLeft);
		// console.log(offset.left+","+offset.top);
		// console.log(pos.left+","+pos.top);
		// if(!span.hasClass("active"))
		// span.addClass("active");
		// else
		// span.removeClass("active");
		// console.log(xInput.width());
		// var w = xInput.width();
		// xInput.width(w + 100);
	});

	// xInput.get(0).value="3"; -> 예외적인 상황에서쓴다.
	// xInput.attr("value","30"); value는 val() 함수를 쓴다.
	// xInput.val("50"); // 값은 val()
	// xInput.attr("type","submit");//속성은 attr()

	// span.text("<b>hello</b>");

	// span.css("background","yellow");
	// span.css("font-size","30px");

	// span.css({
	// color:"yellow",
	// fontSize:"30px"
	// })

	// span.css({
	// color:"red",
	// "font-size":"20px"
	// })
	// .css({
	// backgroundColor:"blue",
	// marginLeft:"50px"
	// });
});
