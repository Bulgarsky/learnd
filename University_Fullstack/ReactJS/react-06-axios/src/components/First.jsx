import React from 'react';

class First extends React.Component {
    buttonClick = () => {
        console.log("метод - кнопка нажата");
        let test = this.state.a;
        test ++;
        this.setState({a: test});
    }
    static getDerivedStateFromProps(props, state){
        console.log("getDerivedStateFromProps");
        console.log(props);
        console.log(state);
        return null;
    }
    componentDidMount(){
        console.log("componentDidMount");
    }
    componentDidUpdate() {
        console.log("componentDidUpdate");
    }

    constructor(props) {
        console.log("конструктор");
        super();
        this.state = {
            a: props.test
        }
    }

    render(){
        console.log("рендер");
        return (
            <div>
                {console.log("возврат")}
                <button onClick={this.buttonClick} >Кнопка</button>
                <div>
                    счет: {this.state.a}
                </div>
            </div>
        )
    }
}

export default First;