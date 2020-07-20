window.addEventListener("load",function(){
   var container = document.querySelector('.container');

   
   container.onclick=function(e){
       console.log(e.target.classList.item(1));
   }
});