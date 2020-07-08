const readline=require('readline');

const r1=readline.createInterface({
    input:process.stdin,
    output: process.stdout
});


/*
let name=r1.question("당신의 이름은?:"); //이렇게 실행이 안됨, nodejs는 비동기라서 메인스레드를 사용하지 않아서...
console.log(`아~ 당신의 이름은 ${name}이군요~`);*/

r1.question("당신의 이름은 : ", function(name) {
    console.log(`아~ 당신의 이름은 ${name}이군요~`);
});
