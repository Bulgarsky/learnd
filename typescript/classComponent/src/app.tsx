import React from "react";

type AppProps = {
    title: string
}

type AppState = {
    count: number
}

export default class App extends React.Component<AppProps, AppState> {
    state = {
        count: 0
    }

    increment = () =>{
        this.setState({count: this.state.count + 1});
    }
    render(){

        return(

            <div className="App">
                <h3>{this.props.title}</h3>
                <span>{this.state.count}</span>
                <br />
                <button onClick={this.increment}> + </button>
            </div>
        )
    }
}