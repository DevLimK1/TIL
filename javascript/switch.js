window.addEventListener("load", function(){
    var section = document.querySelector("#s1");
    var container=section.querySelector(".container");
    var box = container.querySelector(".box");
    
    var isDragging=false;
    var offset={x:0,y:0};
    
    var left= container.offsetLeft;
    var top= container.offsetTop;
    var current=null;
    var placeHolder=null;

    container.firstElementChild.onmouseenter=function(e){
        console.log("enter 1");
    }
    container.firstElementChild.onmouseenter=function(e){
        console.log("enter 1");
    }

    container.onmousedown= function(e){
        isDragging=true;
        current=e.target;
        offset.x=e.offsetX;
        offset.y=e.offsetY;
        console.log("offset.x ="+offset.x);
        console.log("offset.y ="+offset.y);
        
        var currentStyle=window.getComputedStyle(current);

        var width = currentStyle.getPropertyValue("width");
        var height=currentStyle.getPropertyValue("height")

        current.style.position="absolute";
        //placeHolder를 추가
        placeHolder =document.createElement("div");
        
        placeHolder.style.width= width;
        placeHolder.style.height= height;
        placeHolder.style.background="gray";
        current.parentElement.append(placeHolder);
        

      };
    
    container.onmouseup= function(e){

        var el=document.elementFromPoint(700,300); //위치를 가지고 
        console.log(el);
        el.background="red";
        
        //placeHolder를 제거와 current 박스의 원위치
        if(placeHolder!=null){
            current.style.position="initial";
            current.style.left="initial";
            current.style.top="initial";
            placeHolder.remove();
        }
        isDragging=false;
        current=null;
        
      };

    container.onmousemove= function(e){
       e.preventDefault(); //안에 텍스트가 있다면 드래그가 안되게 막음(모든 엘리먼트 기본 기능에 포함되어 있음 )
    
    
    //안버버벅 방식
    if(current==null)return;
   
    current.style.left=e.x-offset.x-left+"px"
    current.style.top=e.y-offset.y-top+"px"
    

       //버버벅 방식
    //    if(!e.target.classList.contains("box")) return;
    //    console.log(isDragging);
    //     if(!isDragging) return;


    //   console.log("e.x="+e.x);
    //   console.log("e.y="+e.y);
    //   console.log(box.style.left=e.x-offset.x-left+"px");
    //   console.log(box.style.top=e.y-offset.y-top+"px");

    // --------------------------------------
    //   console.log(box.style.right=e.x+"px");

        // console.log(`x:${e.x}, y:${e.y}`);
        // console.log(`clientX:${e.clientX}, clientY:${e.clientY}`);
        // console.log(`screenX:${e.screenX}, screenY:${e.screenY}`);
        // console.log(`offsetX:${e.offsetX}, offsetY:${e.offsetY}`);
    };

});
