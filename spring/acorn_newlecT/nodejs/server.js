// let http=require('http');
// let server=http.createServer();

// server.on("request",(req,res)=>{
//     console.log("요청이 왔습니다.");
//     res.write("Hello NodeJS!");
//     res.end();
// })

// server.listen(3000);
// // server.accept();// 접속이 올 때까지 기다린다..
// console.log("accept");

/****************미들웨어(app use) , Express****************** */
// let express=require('express');

// let server =express();
// server.listen(3000);
// server.use("/index",(req,res,next)=>{
//     //res.end("홈페이지");
//     res.send("홈페이지");
//     res.end();
// });
///////////////////////////////////////////////////////
let http=require('http');
let express=require('express');
let indexController=require("./controller/indexController.js");

let app =express();
let server=http.createServer(app);
server.listen(3000);
app.use("/index",indexController.render
);
