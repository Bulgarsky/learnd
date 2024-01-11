import React, {Component} from "react";
import Posts from "./components/Posts.jsx";

//класс.понимание, что класс.компонент нужно использовть, когда есть состояния
//а функц.компонент, когда состояния нет
class App extends Component {

  state = {
    posts: [
      {id: 'abc1', name: "John Doe"},
      {id: 'abc2', name: "Marry Smith"},
      {id: 'abc3', name: "Sammy Handsome-Potter"}
    ],
  }

  handleSome = () => {
      console.log("App/jsx setState update");
  }

  removePost = (id) => {
      this.setState({posts: this.state.posts.filter(post => post.id !== id)});
  }

  render() {
      //деструктуризация
      const {posts} = this.state;


    return (
        <>
          <div className="App">
            <Posts
                posts={posts}
                //передаем метод вниз, во внутренние компоненты
                cb={this.handleSome}
                removePost={this.removePost}
            />
          </div>
        </>
    )
  }
}

export default App;
