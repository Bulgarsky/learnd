import React, {Component} from "react";


export default  class Timer extends Component{

    state = {
        count: 0,
        isCounting: false
    }

    handleStart = () => {
        this.setState({isCounting: true});
        this.counterId = setInterval(() => {
            this.setState({count: this.state.count + 1});
        }, 1000);
    }
    handleStop = () => {
        //переключить флажок
        this.setState({isCounting: false});
        //очистить
        clearInterval(this.counterId);
    }
    handleReset = () => {
        this.setState({isCounting: false, count: 0});
        clearInterval(this.counterId);
    }

    //lifecycle
    componentDidMount() {
        //получить значение по ключу из локал.хранилища
        const userCount = localStorage.getItem("timer");
        if (userCount){
            //+userCount перобразовать в число
            this.setState({count: +userCount});
        }
    }
    componentDidUpdate() {
        //сохранить значние в локал.хранилище пользователя
        localStorage.setItem("timer", this.state.count);
    }
    componentWillUnmount() {
        //очистить из памяти браузера
        clearInterval(this.counterId);
    }

    render(){
        return(
            <div>
                <h3>React timer</h3>
                <p>{this.state.count}</p>
                {!this.state.isCounting ? (
                    <button onClick={this.handleStart}>Start</button>
                ) : (
                    <button onClick={this.handleStop}>Stop</button>
                )}

                <button onClick={this.handleReset}>Reset</button>
            </div>
        )
    }

}