// eslint-disable-next-line no-unused-vars
import React, {Component} from "react";
import Timer from "./Timer.jsx";


class App extends Component{

    state = {
        //нач.состояния
        posts: [],
        loading: true,
        comments: [],

        };


  //жизненные циклы
  componentDidMount() {
      //срабатывает один раз при рендере
        console.log("componentDidMount! - компонент смонтирован");

      //загрузка основных данных
      fetch("http://jsonplaceholder.typicode.com/posts")
      //получить в ответ Obj и преобраховать в json
          .then(response => response.json())
          .then(data => this.setState({posts: data, loading: false}))

      //создание таймера
      this.timerId = setInterval(() => {
          fetch("http://jsonplaceholder.typicode.com/comments")
              .then(response => response.json())
              .then(data => this.setState({comments: data}))
          }, 10000);
  }
    componentDidUpdate() {
        //срабатывает при обновлении компонента
        console.log("componentDidUpdate! - компонент обновлен и перерисован");

        //можно реализовать дозагрузку не первичных данных (лайки, коментариии и тд)

    }

    componentWillUnmount() {
        console.log("componentWillUnmount - компонент удален");

        //очистка таймера
        clearInterval(this.timerId);
    }

    //рендер компонента
  render() {

      return(
        <div className = "App">
            <h3>Hello! JSON data</h3>

            <div>
                {this.state.loading ? <h3>Loading ...</h3> : <h3>{this.state.posts.length} was loading</h3>}
            </div>

            <br />
            <br />

            <Timer />
        </div>
    )
  }

}

export default App;