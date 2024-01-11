import React, {Component} from "react";

//REF - некий указатель на узел (NODE)
class UncontrolledForm extends React.Component {

    constructor(props) {
        super(props);

        //ref - object, со свойством current, нач.значение null
        //ссылки на рефы (references)
        //при работе с неконтролируемыми полями - на каждое поле вешаем Реф, без обработки value
        //Рефы не приводят ререндера (как стейты), живут в DOM
        this.cardRef = React.createRef();
        this.emailRef = React.createRef();
    }

    //на кнопку или на форму вешаем 1 обработчик
    handleSubmit = (event) => {
        //чтобы форма не оптравлялась:
        event.preventDefault();
        //делаем валидацию
        if (this.cardRef.current.value.length < 16) {
            alert("invalid card number < 16");
            return;
        }
        //проверка почты с регуляркой
        //send to server

        //сбросс значений
        this.cardRef.current.value = "";
        this.emailRef.current.value = "";
    }

    render(){

        return(
            <form onSubmit={this.handleSubmit}>
                <input
                    type="text"
                    name="card"
                    placeholder="card"
                    ref={this.cardRef}
                />
                <br />
                <input
                    type="email"
                    name="email"
                    placeholder="enter your e-mail"
                    ref={this.emailRef}
                />
                <br />
                <br />
                <button>Send</button>
            </form>

        )
    }
}

export {UncontrolledForm};