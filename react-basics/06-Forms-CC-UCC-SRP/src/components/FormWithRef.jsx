import React, {Component} from "react";

//REF - некий указатель на узел (NODE)
class FormWithRef extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            card: "",
            email: "",
        }
        //ref - object, со свойством current, нач.значение null
        //ссылки на рефы (references)
        this.cardRef = React.createRef();
        this.emailRef = React.createRef();
    }

    handleChange = (event) => {
        this.setState(() => ({[event.target.name]: event.target.value}), () => {
            if (this.state.card.length === 16){
                //focus to email input
                this.emailRef.current.focus();
            }
        });
    }
    componentDidMount() {
        //current (null тоже лежит тут)
        console.log(this.cardRef);
        //focus card input
        this.cardRef.current.focus();
    }

    render(){
        const {card, email} = this.state;


        return(
            <div>
                <input
                    type="text"
                    name="card"
                    placeholder="card"
                    value={card}
                    onChange={this.handleChange}
                    ref={this.cardRef}
                />
                <br />
                <input
                    type="email"
                    name="email"
                    placeholder="enter your e-mail"
                    value={email}
                    onChange={this.handleChange}
                    ref={this.emailRef}
                />

            </div>

        )
    }
}

export {FormWithRef};