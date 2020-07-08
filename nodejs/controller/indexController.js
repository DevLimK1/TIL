// //Commons JS 방식
// exports.render=(req,res,next)=>{
//     //res.end("홈페이지");
//     res.send("홈페이지");
//     res.end();
// }

// export default render;

/*********라우터를 반환하는 indexController.js *************** */
// let express=require('express');
// let router=express.Router();

// router.get('/index',function(req,res,next){
//    res.send('Hello World'); 
//    res.end();
// });

// module.exports=router;
/*********ejs를 활용하여 view 엔진 사용하기************ */
let express=require('express');
let router=express.Router();

router.get('/index',function(req,res,next){
//    res.send('Hello World'); 
//    res.end();

    // res.render('index.ejs',{test:'hello'});
    res.json({"test":"hello"}); //브라우저에 json 객체로 출력됨
});

module.exports=router;