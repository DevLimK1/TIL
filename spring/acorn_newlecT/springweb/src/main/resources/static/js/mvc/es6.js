//1.변수 선언 방법이 달라짐
// var x=3;
//위 문제점
//이 변수는 전역객체의 속성이 됨
//그래서 선언하지 않은 변수도 사용가능
// y=4;
//변수는 중첩 선언이 가능함
// var x=4;
//변수는 자료형을 따지지 않음


//********** let *************** */
// var x=4; // window.x (전역)과 같다.
// var x=4;
// let x=3;
// window.x=50;
// let y=4;

//********var을 쓰면 지역 블록이 의미가 없었다.***********
// {
// var z=3; //window.z=3; 과 같음
// let z=3;
// }
// console.log(z);

//********** const *************** */
//상수형 변수
// const a=30; //자바 final int a=30;과 동일
//a=40; //(x)

// console.log(a);

/********** 2.개체의 정의가 없었음 ************/

// class Exam{
//     constructor(){

//     }

//     constructor(kor,eng,math){

//     }

// }

// let exam=new Exam();

/**********  3.함수 인자 전달에서 나머지 값 처리가 없었다.************* */

/** Rest Parameters **/

// function print(x,y,...z){
//     console.log(x+y);
//     console.log(z[1]);
// }

// print(2,3,5,7,2);

/** 가변적인 매개 변수 **/

// function arrPrint(x,y,z){
//     console.log(x);
//     console.log(y);
//     console.log(z);
// }

// let nums=[2,4,6];
// arrPrint(...nums);

/** 기본값이 없던 함수 **/
// function add(x,y){
//     x=x||0; //꼼수
//     y=y||4;

//     return x+y;
// }

// console.log(add(2,3));
// console.log(add(1));

// function addDefault(x=0,y=4){
//     return x+y;
// }

// console.log(addDefault(2,3));
// console.log(addDefault(1));

// function add2(x,y=10,z)
// {
//     console.log(x+','+y+','+z);
// }

// add2(10,null,30);
// add2(10,undefined,30);
// add2(10,20,30);

// function add3(x,y=10)
// {
//     console.log(arguments.length);//arguments:사용자가 전달한 값
//     console.log(x+','+y);
// }

// add3(10); // arguments.length: 1
// add3(10,30); //arguments.length:2
// add3(undefined); //arguments.length:1

/********* Arrow Function ********* */
// No this
// No arguments
//No super
//No new.target

// function Exam(){
//     this.kor=0;
//     this.eng=0;
//     this.math=0;
// }
// Exam.prototype={
//     total:function(){
//         setTimeout(function(){
//             console.log(this.kor);
//         },1000);
//         return this.kor+this.eng+this.math;
//     },
//     avg:function(){
//         return this.total()/3;
//     }
// };

// // let exam=Exam(); //this가 window가 된다.
// let exam=new Exam(); //this가 new가 된다.
// exam.kor=30; //undefined가 나온다. setTimeout의 function의 this는 다른 this다
// exam.total();

// function Exam2(){
//     this.kor=0;
//     this.eng=0;
//     this.math=0;
// }
// Exam2.prototype={
//     total:function(){
//         setTimeout(()=>{
//             console.log(this.kor);
//         },1000);
//         return this.kor+this.eng+this.math;
//     },
//     avg:function(){
//         return this.total()/3;
//     }
// };

// let exam2=new Exam2(); //this가 new가 된다.
// exam2.kor=30; //30이 나온다. this를 갖지 않기 때문에 가장 근접한 this값을 가져온다.
// exam2.total();

/*************************** */
// let kor=30;
// let eng=40;
// let math=50;

// let exam={
//     kor:kor,
//     eng:eng,
//     math:math
// };
// 아래와 같이 써도 결과는 같게 나온다.
// let exam={
//     kor,
//     eng,
//     math
// };
/////////////////////////////////

// let exam={
//     kor,
//     eng,
//     math,
//     total:function(){
//         return this.kor+this.eng+this.math;
//     }
// };
//아래와 같이 써도 결과는 같다.

// let exam={
//     kor,
//     eng,
//     math,
//     total(){ //total:function(){}
//         return this.kor+this.eng+this.math;
//     }
// };

// exam.kor=2;
// exam.eng=3;
// console.log(exam.total());

/************key값을 변수명으로 사용하기 *************** */
// let kor=30;
// let eng=40;
// let math=50;
// let col="name";
// // let name="newww";

// let exam={
//     kor,
//     eng,
//     math,
//     [col]:'new', //[col] -> name 으로 변경됨
//     total(){
//         return this.kor+this.eng+this.math;
//     }
// };
// console.log(exam.name);

// let exam2={
//     kor,
//     eng,
//     math,
//     [col+1+2]:'newlec', //[col] -> name 으로 변경됨
//     total(){
//         return this.kor+this.eng+this.math;
//     }
// };

// console.log(exam2.name12);

// /***********Destructuring************** */

// //Destructuring
// let kor=exam.kor;
// let eng=exam.eng;

// //ES6에서 지원해주는 Destructuring
// let{kor,eng}=exam;

// console.log(kor);
// console.log(eng);

// let exam1={kor:10,eng:20,math:30};

///////////////////////////////////////

// let exam={
//     kor:10,
//     eng:20,
//     math:30
// };

// let exam1={
//     kor:11,
//     eng:22,
//     math:33
// };

// // let {kor,eng}=exam;
// // console.log(`kor:${kor}, eng:${eng}`);

// // let {kor,eng,test=90}=exam;
// // console.log(`kor:${kor}, eng:${eng}, test:${test}`);

// let {kor:korean,eng:english,test=90}=exam; //별칭을 줄 수 있음
// console.log(`kor:${korean}, eng:${english}, test:${test}`);

// ({kor,eng,test}=exam1); //kor,eng의 변수명이 위와 같기 때문에 이처럼 사용한다.
// console.log(`kor:${kor}, eng:${eng}`);

/////////////////////////////////////////////////

// let exam = {
//   kor: 10,
//   eng: 20,
//   math: 30,
//   student: {
//     name: "dragon",
//     phone: "010-9999-8888",
//   },
// };

// const printExam = ({ kor, eng, math }) => {
//   console.log(`${kor},${eng},${math}`);
// };

// printExam(exam);

// let name = exam.student.name; //Destructuring
// let phone = exam.student.phone;

//중첩 뽀개기
// let {name,phone}=exam.student;
// let {student:{name,phone}}=exam;
// console.log(`name:${name}, phone:${phone}`);

///////////////////////////////////////////////////

/***********String.raw ************************ */

// let content="helelelelelelle";
// let template=String.raw`\n\n\n
//   <section>
//     <div>${content}</div>
//   </section>
// `;
// console.log(template);

/***************** Set ****************** */
// let set = new Set();

// set.add(5);
// set.add("5");
// set.add(2);
// set.add(5);
//아래와 같이 사용가능

// set
// .add(5)
// .add("5")
// .add(2)
// .add(5);

// let set=new Set([2,4,3,5,6,4,3]);

// console.log(set.has(7));
// console.log(set.size);
// console.log(set);
// for(let v of set)
//   console.log(v);

//   let array=[...set]; //set->배열 변경
//   console.log(array);

//   let ws=new WeakSet();
//   ws.add({data:42});

/*********** Generator, iterator**************** */

// const data=[3,5,11,25,45];

// function iterator(){ //직접 iterator 구현
//   let index=-1;
//   return{
//       next:function(){
//         ++index;
//         return {
//           value:[data[index]],
//           done:data[index]!=undefined? false:true
//         };
//     }
//   }
// }

//  function *iterator(){ //function * : generator(iterator을 만들어주는 녀석)
//     for(let v of data)
//       yield v;

//     // yield "hi";
//     // yield 3;
//     // yield "ok";
//     // yield "good";
// }

// let it=iterator();

// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);

/*************** Symbol ***************** */
//함수가 동명인을 피하기 위한 방법
// let s1=Symbol();
// let s2=Symbol();

// console.log(s1==s2); //false
// console.log(s1===s2); //false

// let s1 = Symbol();
// let s2 = Symbol();

// console.log(s1 == s2);
// console.log(s1 === s2);

// let obj={
//   [Symbol()]:1,
//   [Symbo1()]:30
// };

// // console.log(obj);

// let sbs=Object.getOwnPropertySymbols(obj);
// console.log(obj[sbs[1]]);
//위 코드는 내 코드인데 실행이 안돼서 아래꺼 받아서 하니깐 됨..

// let obj = {
//   [Symbol()]:1,
//   [Symbol()]:30
// };

// let sbs = Object.getOwnPropertySymbols(obj);
// console.log(obj[sbs[1]]);

// let total=Symbol("total 함수를 위한 심볼");

// let exam1 = {
//   kor: 10,
//   eng: 20,
//   [total]: function () {
//     return this.kor + this.eng;
//   },
// };

// let obj1 = {
//   name: "dragon",
//   [total]: function(){
//     console.log('그냥함수');
//     return 120;
//   }
// };

// let ar = [exam1, obj1];

// for (let i = 0; i < 2; i++){
//   console.log(ar[i][total]());
// }

// const lotto={
//   nums: [3,15,11,25,45],
//   print(){
//     console.log(nums);
//   },
//   [Symbol.iterator](){ // iterator라는 함수를 javascript가 인식할 수 있게끔,Symbol로 구현되었다는 것을 나타냄
//       let index=-1;
//       return{
//           next:function(){
//             ++index;
//             return {
//               value:lotto.nums[index],
//               done:lotto.nums[index]!=undefined? false:true
//             };
//         }
//       }
//     }
// }

// for(let n of lotto) //iterator 객체가 내부적으로 돈다.
//   console.log(n);

/**************** 클래스를 정의하는 새로운 방법********************** */

// class Exam{
//   constructor(kor,eng,math){
//     this.kor=kor||0;
//     this.eng=eng||0;
//     this.math=math||0;
//   }

//   total(){
//     return this.kor+this.eng+this.math;
//   }

// }


//new 를 통해서 사용가능
// class Exam {
//   constructor(kor = 0, eng = 0, math = 0) { //기본값 설정
//     this.kor = kor;
//     this.eng = eng;
//     this.math = math;
//   }

//   total() {
//     return this.kor + this.eng + this.math;
//   }
// }
// let exam2=new Exam();
// console.log(typeof Exam);
// console.log(exam2.total());

//상속
// class NewlecExam extends Exam{
//   constructor(kor=0,eng=0,math=0,com=0){
//     super(kor,eng,math);
//     this.com=com;
//   }

//   total(){
//     return super.total()+this.com;
//   }
// }

// let exam2=new NewlecExam(1,1,1,1);
// console.log(exam2.total());

/////////////////////////////////////////

// class MyArray extends Array{
//   constructor(myarg,...args){
//     super(...args);
//     this.myarg=myarg;
//   }

//   print(){
//     console.log(this.myarg); 
//     super.push(this.myarg);
//   }

// }

// let mar=new MyArray("hoho",1,2,3,4);
// let myarg=5;
// mar.print(); //hoho
// console.log(mar.pop());//hoho
// console.log(mar.pop());//4
// console.log(mar.pop());//3
// console.log(mar.pop());//2
// console.log(mar.pop());//1


/*******************Promise , async/await **************************** */

/*
//비동기 처리를 가지는 함수 정의하는 과거 방식
function getNotice(callback){
    console.log("가짜 요청 시작");
    setTimeout(()=>{ //비동기
      //완료되면
      callback({id:1,title:'공지가있습니다.'});
    },2000);
}

//비동기 처리를 가진 함수를 호출하는 과거 방식
getNotice(function(notice){
  console.log(notice.title);
});
*/
/////////////////////////////////////////
/*
function getNotice(callback){
  console.log("가짜 요청 시작");
  // return new Promise(resolve=>{
    setTimeout(()=>{ //비동기
      //완료되면
      // callback({id:1,title:'공지가있습니다.'});
        callback({id:1,title:'공지에유'});
    },2000);
  // });
}
*/
//아래처럼 사용가능! 
// function getNotice(id/*callback*/){
//   console.log("가짜 요청 시작");
//   return new Promise((resolve,reject)=>{ //Promise는 콜백함수를 담을 수 있는 녀석
//     setTimeout(()=>{ //비동기
//       //완료되면
//     if(id<40)
//         resolve(`{"id":1,"title":"공지에유"}`); //문자열로 전달함
//     else
//         reject({status:"error",message:"오류났"});
//       },2000);
      
//   });
// }

/*
async function test(){ //async를 쓰면 비동기함수를 만들어준다.(쓰레드를 하나 더만든거와 같다.)
  console.log("process test")
  let notice=await getNotice(32); //기다리는건 좋은데 ui는 다운시키지마랏
  //await가 없으면 promise 객체가 바로 반환된다. await은 화면쓰레드를 잡아 먹지 않는 곳에서 써야하기 때문에 async funtion안에서만 사용하게 제약을 걸어놓음

  // let notice=getNotice(32);
  console.log(notice);
  console.log(notice.title);
}
*/

// function test1(){
//   console.log("process test1");
//   let pro=getNotice(41);
//   pro//순서대로 promise를 전달하고 있음.
//   .then(function(n){ //문자열 데이터를 객체화 해서 제목을 반환
//     let notice=JSON.parse(n);
//     // console.log(typeof n);
//     // console.log(n);
//     return notice.title;
//   })
//   .then(function(title){//반환된 데이터를 출력
//     console.log(title);
//   })
//   .catch(function(e){
//       // console.log(e.message);
//       return e.message;
//   })
//   .then(m=>{
//       console.log(m);
//   });
  
// }

// test1();
// console.log("after test");


// let notice=await getNotice(32);// await:기다리겠다.(동기형)->비동기실행된 함수안에서 사용이 가능하다.(UI가 다운되는 걸 방지하고자)
// console.log(notice.title);

// getNotice(32,function(n){
//   console.log(n.title);
// },function(){

// });
// //아래와 같이 사용하면 더 간결하다.
// getNotice(32) //Promise가 callback함수를 가지고, 업무완료되면 반환되고,
// .then((n)=>{
//   console.log(n.title);
// })
// .catch(function(){

// });

// let notice=await getNotice();
// console.log(notice.title);

// console.log("호호호");


/*********** module ****************** */

// const { Exam } = require("./module1");

//함수명과 동일해야한다.
// 별칭을 as로 해서 줘서 함수명이 충돌나면 피할 수 있다.
// import {test1 as t1,test2,test3  } from "./module1.js";

//export default를 쓰게되면 아무 별칭으로 함수를 사용가능하다.
// import asd,{test1,test3,Exam} from "./module1.js";

// function test(){
//   console.log("hello");
// }

// let exam=new Exam();
// console.log(exam.total());

// // function test1(){
// //   console.log("asdf");
// // }

// asd(); //default로 넘어온 값이 호출됨
// // test();
// test1();
// // test2();
// test3();
// // t1();

/******************* Proxy ******************************8 */
class Exam{
  constructor(){
    this.kor=10;
    this.eng=20;
  }
  total(){
    return this.kor+this.eng;
  }
}

//왕자
let exam= new Exam();
const handler={
  get: function(target, prop, receiver) { //속성을 달라고 할 때 먼저 호출됨
    // if (prop === 'secret') {
    //   return `${target.secret.substr(0, 4)} ... shhhh!`;
    // }
    // if(prop==='kor')
    //   return 50000;

      console.log("앞부분 코드");
      let v = Reflect.get(...arguments);
      console.log("뒷부분 코드");

    return v;
  }
}; //곁다리

//거지
const p = new Proxy(exam ,handler); //exam의 속성을 handler로 중간에 가로채기가능
console.log(p.total());
// console.log(`kor:${p.kor},eng:${p.eng}`); 