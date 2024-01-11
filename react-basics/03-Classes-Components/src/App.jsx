// eslint-disable-next-line no-unused-vars
import React, {Component} from "react";

const countStyle = {
    margin: "0 1rem",
    display: "inline-block"
}

class App extends Component{

    //запись с конструктором
    constructor(props) {
        super(props);
        //состояния
        this.state = {
              //нач.состояние
             count: 0,
             someKey: false
        };

        //привязка внутреннего контекста
        this.handleClickSub = this.handleClickSub.bind(this);
    }

    //короткая запись стейта
    /*
    state  = {
       count: 0
    };
    */

    //1) создание метода через стрел.функцию
    handleClickAdd = () => {
      //изменение стейта через сет
      this.setState({count: this.state.count +1});
      console.log("PrevState", this.state.count);

      //если нужно изменить стейт несолько раз:
      //this.setState((prevState) => ({count: prevState.count + 1}));
      //this.setState((prevState) => ({count: prevState.count + 1}));

      //гарантированное получение пред.стейта
        /*
      this.setState(
          //вып. вторым
          (prevState) => ({count: prevState.count + 1}),
          () => {
          console.log("setState(complete")
          })
      console.log('handleClick()'); //вып. первым
         */
  }

  //2) создание метода через функцию с привязкой(bind) контекста ранее
  handleClickSub() {
      this.setState({count: this.state.count - 1});
      console.log("PrevState", this.state.count);
  }



    //рендер компонента
  render() {
        console.log("render: ", this.state.count);

    return(
        <div
            className="App"
            style={countStyle}>
          <h3>Hello! That is react classes</h3>
            <button
                onClick={this.handleClickSub}>
                -
            </button>
            <span
                style={countStyle}>
                {this.state.count}
            </span>

            <button onClick={this.handleClickAdd}> + </button>

            <br />
            <br />
            {/*3) анонимная функция*/}
            <button onClick={() => this.setState({count: this.state.count + 2})}> +2 </button>

        </div>
    )
  }

}

export default App;