import React, {useState} from 'react';
import "./CostForm.css"

const CostForm = (props) => {
    //document.getElementById().addEventListener('click', (event) = {});


    //сохранение разных состяоний
    const [inputTitle, setInputTitle] = useState('');
    const [inputAmount, setInputAmount] = useState('');
    const [inputDate, setInputDate] = useState('');


    //испольование ОДНОГО состояния
    /*
    const [userInput, setUserInput] = useState({
        name: '',
        amount: '',
        date: ''
    });

     */
    const titleChangeHandler = (event) => {
        setInputTitle(event.target.value);  //сохранит значение
        /*
        //для каждого хендлера:
        setUserInput({
            ...userInput, //берет пары из объекта, чтобы не потерять
            name: event.target.value
        });
         */

        //каждый раз когда вы обновляете состояние  и должны хранить предыдущие значения
        //нужно использовать альтернативную функцию:
        //гарантирует самое последине значение состояния - безопастнее
        /*
        setUserInput((previousState) => {
            return {
                ...previousState,
                name: event.target.value
            }
        });
         */


    };
    const amountChangeHandler = (event) => {
        setInputAmount(event.target.value);  //сохранит значение
    };
    const dateChangeHandler = (event) => {
       setInputDate(event.target.value);  //сохранит значение
    };

    const submitHandler = (event) => {
        //дефолт - очистка формы; предотвращение отправки данных на сервер и отключение обновления
        event.preventDefault();
        const costData = {
            title: inputTitle,
            amount: inputAmount,
            date: new Date(inputDate)
        };

        //вызываем ф, отправка данных материнскому компоненту
        props.onSaveCostData(costData);

        //обнуление полей
        setInputTitle('');
        setInputAmount('');
        setInputDate('');
    };

    return (
        <form onSubmit={submitHandler}>
            <div className="new-cost__controls">
                <div className="new-cost__control">
                    <label>Наименование</label>
                    <input type="text"
                           value={inputTitle}
                           onChange={titleChangeHandler}/>
                </div>

                <div className="new-cost__control">
                    <label>Сумма</label>
                    <input type="number" min="0.01" step="0.01"
                           value={inputAmount}
                           onChange={amountChangeHandler}/>
                </div>

                <div className="new-cost__control">
                    <label>Дата</label>
                    <input type="date" min="2021-01-01" step="2023-12-31"
                           value={inputDate}
                           onChange={dateChangeHandler}/>
                </div>

                <div className="new-cost__actions">
                    <button type="submit">Добавить расход</button>
                </div>
            </div>

        </form>
    );
};

export default CostForm;