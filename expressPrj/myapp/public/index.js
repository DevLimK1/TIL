//JSX 작성할 때 주의사항
// 1. <input /> 닫는 괄호를 해야한다!!
// 2. 태그안에 class -> className 으로 써야한다.
// 3.<img style="width:100px;" -> <img style={{width:100px;}} //바깥 {}는 bind이다.

// ReactDOM.render(<h1>hello~</h1>,document.getElementById("root")); //<h1> 태그 사용X , JSX 처리를 해야한다.

// const element=(
//     <div>
//         <h1>Hello, world</h1>
//         <h2>It is {new Date().toLocaleTimeString()}</h2>
//     </div>
// );
// ReactDOM.render(element,document.getElementById("root"));

// function Clock(props) {
//   let time = new Date().toLocaleTimeString("en-US", {
//     timeZone: "America/Toronto",
//   });
//   const element = (
//     <div>
//             <h1>America/Toronto</h1>
//             <h2>It is {time}</h2>
//     </div>
//   );

//   return element;
// }

// function tick() {
//   const element = (
//     //감싸는 부모가 있어야함.
//     // <Clock/>는 function Clock함수를 호출한다.
//     <div>
//       <Clock />
//       <hr />
//       <Clock />
//     </div>
//   );
//   ReactDOM.render(element, document.getElementById("root"));
// }

// setInterval(tick, 1000);
//위의 코드처럼 변경가능!
// function tick() {
//   const element = (
//     //감싸는 부모가 있어야함.
//     // <Clock/>는 function Clock함수를 호출한다.
//     <div>
//       <div>
//               <h1>America/Toronto</h1>
//               <h2>It is {time}</h2>
//       </div>
//       <hr />
//       <div>
//               <h1>America/Toronto</h1>
//               <h2>It is {time}</h2>
//       </div>
//     </div>
//   );
//   ReactDOM.render(element, document.getElementById("root"));
// }

/************계산기구현하기******************* */
class Calc extends React.Component {
  constructor(props) {
    super(props); //상속받았으면 생성자안에 super에 props를 넘긴다.
    this.state = {
      //초기 셋팅
      x: "0",
      y: "0",
      result: "0",
    };
  }

  btnClick() {
    //   this.state.x=7; 이렇게 대입할 수는 없다, 
    // this.state={x:"7"}; 이렇게 대입할 수 없다.
    //아래와 같이 setState로 세팅해줘야한다.
    
    // alert(this.state.x);
    
  }

  render() {
    return (
      <section>
                                
        <h1>계산기 프로그램</h1>
        <div>
                              
          <input type="text" dir="rtl" value={this.state.x} 
          onInput={e=>{this.setState({x:e.target.value})}}/>
                              
          <input type="text" dir="rtl" value={this.state.y} 
          onInput={e=>{this.setState({y:e.target.value})}}/>
                          
          {/* bind는 javascript의 기본 기능     */}
          {/* bind(this)->를 사용하 this를 위임하게 되고, btnClick()에서 state값을 쓸 수 있다. */}
          <input
            type="button"
            value="계산"
            onClick={this.btnClick.bind(this)}
          />
                              
          <input type="text" dir="rtl" value={this.state.result} />
        </div>
      </section>
    );
  }
}

ReactDOM.render(<Calc />, document.getElementById("root"));
// <Calc/> 는 클래스, 함수 두개 호출방법이있음
