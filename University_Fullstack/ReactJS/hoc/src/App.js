import logo from './logo.svg';
import './App.css';
import React from 'react';
import Counter from "./counter/Counter";
import Component from "./Component";

class App extends React.Component{
  state = {
    count: 0,
    text: 'placeholder'
  }

  render(){
    const{count, text} = this.state;

    return(
        <div style={{margin: '50px'}}>
        <Counter
            count = {count}
            countDown={() => this.setState({count: count -1})}
            countUp={() => this.setState({count: count +1})}
        />

          <Component
              text={text}
              inputChange={(value) => this.setState({text: value})}
          />
        </div>
    )
  }

}

export default App;
