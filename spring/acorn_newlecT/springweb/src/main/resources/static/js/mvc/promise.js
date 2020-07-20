


// 1.producer
// when new Promise is created, the executor runs automatically.
// const promise = new Promise((resolve, reject) => {
//   //promise안에 execute 실행 함수가 바로 실행됨!
//   //doing some heavy work(network,read files)
//   console.log("doing something...");
//   setTimeout(() => {
//     resolve("ellie"); //callback함수, 성공했다면
//     // reject(new Error('no network'));//실패했다면
//   }, 2000);
// });

// //2. Consumers : then,catch,finally
// promise
//   .then((value) => {
//     console.log(value); //ellie
//   })
//   .catch((error) => {
//     console.log(error);
//   })
//   .finally(() => {
//     console.log("finally");
//   });

//3.Promise chaining
// const fetchNumber = new Promise((resolve, reject) => {
//   setTimeout(() => resolve(1), 1000);
// });

// fetchNumber
//   .then((num) => num * 2)
//   .then((num) => num * 3)
//   .then((num) => {
//     return new Promise((resolve, reject) => {
//       setTimeout(() => resolve(num - 1), 1000);
//     });
//   })
//   .then((num) => console.log(num));

//async& await


//1.async
async function fetchUser() {
    // return new Promise((resolve, reject) => {
      //do network request in 10 secs...
    //   resolve('ellie');
    // });

    return 'ell';
  }
  
  const user = fetchUser();
  user.then(console.log);
  console.log(user);

  //2. await
  