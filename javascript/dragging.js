window.addEventListener("load", function(){
    var section = document.querySelector("#s1");
    var container=section.querySelector(".container");
    var box = container.querySelector(".box");

    
    
    var isDragging=false;
    var offset={x:0,y:0};
    
    var left= container.offsetLeft;
    var top= container.offsetTop;
    
    // var clientRect=container.getBoundingClientRect();
    // var left2=clientRect.left;
    // var top2=clientRect.top;
    // this.console.log(clientRect);

    console.log(left);
    console.log(top);
    
    container.onmousedown= function(e){
        isDragging=true;
        offset.x=e.offsetX;
        offset.y=e.offsetY;
        console.log("offset.x ="+offset.x);
        console.log("offset.y ="+offset.y);
      };
    
    container.onmouseup= function(e){
       isDragging=false;
  
      };

    container.onmousemove= function(e){
       e.preventDefault(); //안에 텍스트가 있다면 드래그가 안되게 막음(모든 엘리먼트 기본 기능에 포함되어 있음 )
        if(!e.target.classList.contains("box")) return;
       console.log(isDragging);
        if(!isDragging) return;


      console.log("e.x="+e.x);
      console.log("e.y="+e.y);
      console.log(box.style.left=e.x-offset.x-left+"px");
      console.log(box.style.top=e.y-offset.y-top+"px");

    //   console.log(box.style.right=e.x+"px");

        // console.log(`x:${e.x}, y:${e.y}`);
        // console.log(`clientX:${e.clientX}, clientY:${e.clientY}`);
        // console.log(`screenX:${e.screenX}, screenY:${e.screenY}`);
        // console.log(`offsetX:${e.offsetX}, offsetY:${e.offsetY}`);
    };

});