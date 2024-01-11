import React from "react";

class Form extends React.Component{
    state = {
        firstName: "",
        email: "",
        message: "",
        select: "",
        subscription: false,
        gender: "",
    }

    handleChange = (event) => {
        //для обращения к одному полю
        //this.setState({firstName: event.target.value});

        //динамическое обращение к полям
        this.setState({[event.target.name]: event.target.value});
    }

    validateName = () => {
        if (this.state.firstName.length < 2){
            alert("your firstname cant be less 2 letters");
        }
    }

    validateEmail= () => {
        const pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
        if (!pattern.test(this.state.email.value)){
            alert("your email incorrect");
        }
    }

    handleCheckbox = (event) => {
        this.setState({[event.target.name]: event.target.checked})
    }
    render() {
        //деструктуризация состояний
        const {firstName, email, message, select, subscription, gender} = this.state;

        return (
            <div>
                <input
                    type="text"
                    name="firstName"
                    placeholder="enter first name"
                    value={firstName}
                    onChange={this.handleChange}
                    onBlur={this.validateName}
                />
                <input
                    type="email"
                    name="email"
                    placeholder="enter your e-mail"
                    value={email}
                    onChange={this.handleChange}
                    onBlur={this.validateEmail}
                />
                <br />
                <br />
                <textarea
                    name="message"
                    value={message}
                    onChange={this.handleChange}
                />
                <br />
                <br />
                <select name={select} value={select} onChange={this.handleChange}>
                    <option disabled>Выберите опцию</option>
                    <option>ab1</option>
                    <option>bc2</option>
                    <option>df3</option>
                </select>
                <br />
                <br />
                <label>
                    <input
                        type="checkbox"
                        name="subscription"
                        checked={subscription}
                        onChange={this.handleCheckbox}
                    />
                    Subscription
                </label>
                <br />
                <br />
                <input type="radio" name="gender" value="male" 
                       onChange={this.handleChange}
                       checked={gender === "male"}
                /> Male
                <input type="radio" name="gender" value="female"
                       onChange={this.handleChange}
                       checked={gender === "female"}
                /> Female


            </div>
        )
    }
}

export {Form};