var express = require("express");
var router = express.Router();
let NoticeService = require("../service/noticeService.js");

/* GET users listing. */
router.get("/list", function (req, res, next) {

  let noticeService=new NoticeService();
  
  (async ()=>{
    let list=await noticeService.getList();
    // res.render("./notice/list",{list}); //list라는 키워드를 가지고 배열로 보낸다. 
    res.json({list});// 키워드 없이 배열로 보낸다.
  })(); //함수 정의 되자마자 바로 실행됨

  //Promise를 활용한 방법
  // noticeService
  // .getList()
  // .then(function(list){
  //   res.render("./notice/list",{list});
  // });
  
  
  // res.render("./notice/list", { list: results }); //ejs 가져다 쓴다 list이름으로 쓴다
  //res.send('notice list');
});

module.exports = router;

// var express = require('express');
// var router = express.Router();
// var mysql=require("mysql");

// /* GET users listing. */

// router.get('/list', function(req, res, next) {
//   var con=mysql.createConnection({
//     host:"dev.notepubs.com",
//     port:9898,
//     database:"newlecture",
//     user:"newlecture",
//     password:"111",
//     insecureAuth:true
//   });

//   con.connect(function(err){ //콜백
//     if(err) throw err;
//     console.log("connected");

//     con.query("SELECT * FROM Notice",function(err,results,fields){ //콜백
//       if(err) throw err;
//       console.log(results[0]); //서버 콘솔에 찍힌다. 브라우저 콘솔이 아님

//       con.end();
//       res.render("notice/list.",{list:results}); //list.ejs 확장자 쓰지 않음
//     });

//   });
//   // res.send('notice list');
// });

// module.exports = router;
