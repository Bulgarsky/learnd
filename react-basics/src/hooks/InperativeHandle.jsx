//06
//useImperativeHandle - редко используемый, дает возможность вернуть пропсы снизу вверх
import {useImperativeHandle, useRef, useState} from "react";
export default function App() {
    return (
        <div className="App">
            <Form />
        </div>
    );
}


const TextInput = React.forwardRef((props, ref) =>{
    const  {hasError, placeholder, value, update} = props;
    console.log(update);
    const inputRef = useRef();

    //принимает реф и добавляет {объект} в поле ref.current
    useImperativeHandle(ref, () =>{

        return {
            //вызывает метов фокус
            focus(){
                //добавляет фокус в реф
                inputRef.current.focus();
            }
        };
    });

    return(
        <input
        ref={inputRef}
        value={value}
        onChange={(event) => update(event.target.value) }
        placeholder={placeholder}
        style={{
            borderColor: hasError ? "red" : "black"
        }}
        />
    );
});

const Form= () => {
    const [card, setCard] = useState("");
    const [phone, setPhone] = useState("");
    const [error, setError] = useState("");

    const cardElement = useRef(); //current = {focus(){} }
    const phoneElement = useRef();

    const validate = () => {
        if (card.length < 16) {
            //если не прошло проверку - добавить ошибку
            setError("card");
            cardElement.current.focus();  //этот метод пришел снизу
            return;
        }

        if (phone.length < 11) {
            //если не прошло проверку - добавить ошибку
            setError("phone");
            //добавить в currend - функцию focus()
            phoneElement.current.focus();
            return;
        }
        //если нет ошибок - обнулить error
        setError("");
    };

    return(
      <div>
          <h2>useImperativeHandle hook</h2>

          <TextInput
            hasError={error == "card"}
            placeholder={"Card"}
            value={card}
            update={setCard}
            ref={cardElement}
          />

          <TextInput
              hasError={error == "phone"}
              placeholder={"Phone"}
              value={phone}
              update={setPhone}
              ref={phoneElement}
          />

          <button onClick={validate}> Validate</button>
      </div>
    )

}
