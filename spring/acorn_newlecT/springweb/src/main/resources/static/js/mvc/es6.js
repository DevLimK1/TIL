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

let exam = {
  kor: 10,
  eng: 20,
  math: 30,
  student: {
    name: "dragon",
    phone: "010-9999-8888",
  },
};

const printExam=({kor,eng,math})=>{
    console.log(`${kor},${eng},${math}`);
}

printExam(exam);

// let name = exam.student.name; //Destructuring
// let phone = exam.student.phone;

//중첩 뽀개기
// let {name,phone}=exam.student;
// let {student:{name,phone}}=exam;
// console.log(`name:${name}, phone:${phone}`);

///////////////////////////////////////////////////
