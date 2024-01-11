import React from "react";

class Sub extends React.Component {
    state = {
        email: "",
        isAgreeTerms: false,
    }

    handleEmail = (event) => {
        this.setState({ email: event.target.value })
    }

    handleTermsCheckbox = (event) => {
        this.setState({ isAgreeTerms: event.target.checked })
    }

    handleSubmit = (event) => {
        const isEmailValid = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/.test(this.state.email.toLowerCase());
        const isCheckboxValid = this.state.isAgreeTerms;


        //форма очищается после проверки!
        if (!isEmailValid){
            alert("your email incorrect");
            return;
        }
        if (!isCheckboxValid){
            alert("You should accept all terms, policy and conditions");
            return;
        }

        this.setState({
            email: '',
            isAgreeTerms: false,
        });

        alert("Congratulation to sub! Enjoy! ");
    }

    render() {
        const {email, isAgreeTerms} = this.state;

        return(
            <div>
                <form>
                    <h3>Subscription</h3>
                    <input
                        type="email"
                        name="email"
                        placeholder="enter your e-mail"
                        value={email}
                        onChange={this.handleEmail}
                    />
                    <br />
                    <label>
                        <input
                            type="checkbox"
                            name="isAgreeTerms"
                            checked={isAgreeTerms}
                            onChange={this.handleTermsCheckbox}
                        />
                        I agree terms, policy and conditions
                    </label>
                    <br />
                    <br />
                    <button onClick={this.handleSubmit}>
                        Send
                    </button>
                </form>
            </div>
        )
    }
}

export {Sub};