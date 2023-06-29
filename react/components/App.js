import React, {useMemo, useState} from 'react';
//import MinMax from "/components/MinMax";
import MinMax from "/components/MinMaxLazyRef";

//temp data parsed json
import productStub from "../src/productStub";

const App = () => {

    let [ products, setProducts ] = useState( productStub() );

    let total = products.reduce( (sum, product) => sum + product.price * product.count, 0 );

    //useMemo, для больших данных
    //let total = useMemo( () => products.reduce( (sum, product) => sum + product.price * product.count, 0 ), [products]);

    //передать id или номер товара, чтобы поинмать для какого товара изменен каунт
    //для каждого товара будет создана функция, при переборке массива
    //callback func
    const setCount = (id, count) => {
        console.log("app.setCount");
        console.log("id: " + id + ", count: " + count);

        setProducts(
            //разбивка массива на элементы
            products.map(product =>
                //тернар
                //сравниваем айди элемента с полученным айди
                product.id !== id
                    //если не совпали возвр. элемент
                    ? product
                    //иначе если айди совпали, распаковываем элемент, меняем count у элемента
                    // ~ { ...product, product.count = count }
                    : ({ ...product, count })
            )
        );
    }

    const deleteProduct = (id) => {
        //фильтровать, если айди не равен переданному
        setProducts( products.filter(element => element.id !== id) );
    }

    return (
        <div>
            <h2> Product list <sup> { products.length } </sup> </h2>
            <hr />
            <table>
                <tbody>
                    <tr>
                        <td> # ---</td>
                        <td> title </td>
                        <td> price </td>
                        <td> count </td>
                        <td> total ---- </td>
                        <td> delete </td>
                    </tr>
                    { products.map((product, i) => (
                        <tr key={product.id}>
                            <td> { i+1 } </td>
                            <td> { product.title } </td>
                            <td> { product.price } </td>
                            <td>
                                <br />
                                <MinMax
                                    max={ product.rest }
                                    current={ product.count }
                                    onChange={ count => setCount(product.id, count) }
                                />
                                <br />
                            </td>
                            <td>{ product.price * product.count }</td>
                            <td>
                                <button type="button" onClick={ () => deleteProduct(product.id) }> X </button>
                                <button type="button" onClick={ () => setCount(product.id, product.rest) }>MAX</button>
                            </td>
                        </tr>
                    ))}
            </tbody>
                <tfoot>
                    <strong>Total: { total } </strong>
                </tfoot>
            </table>

            <br />

        </div>
    );
};

export default App;