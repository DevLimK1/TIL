function f1(a,b,c) {
  console.log(`kor:${this.kor},a:${a},b:${b}`);
}

// function f2() {
//   console.log(`f2:${this.kor}`);
// }
var kor=20;

//window 객체가 this에 전달 된다.
// f1();
// var exam={kor:10,eng:20};
f1.call(1,2,3);
f1.apply(1,{a:2});
let f3 = f1;
f3();
// f1.call({kor:10,eng:20});
// new f1(); //새로운 객체가 this에 전달된다.
// f1.call();
// f1.apply();
let f4 = f1.bind(1,2,3);
// f3();
f4();
