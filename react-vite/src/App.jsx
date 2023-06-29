import {useState} from "react";

import MinMax from "./MinMax";

import productStub from "./productStub.js";

function App() {
  const [ products, setProducts ] = useState( productStub() );

  //передать id или номер товара, чтобы поинмать для какого товара изменен каунт
  //для каждого товара будет создана функция, при переборке массива
  //callback func
  const setCount = (id, count) => {
    console.log("app.setCount");
    console.log("id: " + id + ", count: " + count);

    /*
    //иммутабельность (из коробки реакта), нельзя менять старые данные
    //скопировать массив поэлементно, заменить каунт у элемента, сохранить в новом массиве
    let newProducts = [ ... products ];
    let productIndex = products.findIndex(product => product.id == id);
    let newProduct = { ...products[productIndex] };
    newProduct.count = count;
    newProducts[productIndex] = newProduct;
    setProducts(newProducts);
     */

    setProducts(
    //разбивка массива на элементы
      products.map(product =>
      //тернар
      //сравниваем айди элемента с полученным айди
        product.id !== id
        //если не совпали возвр. элемент
          ? product
          //иначе если айди совпали, распаковываем элемент, меняем каунт у элемента
          // { ...product, product.count = count }
          : ({ ...product, count })

      ));
  };

  return (
    <div className="m-3 p-2">
      <h2> Product list <sup> { products.length } </sup> </h2>
      <hr />
      <table>
        <tbody>
          <tr>
            <td> # </td>
            <td> title </td>
            <td> price </td>
            <td> count </td>
            <td> total </td>
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
            </tr>
          ))}
        </tbody>
      </table>
      <br />

    </div>
  );
};

export default App;

//temp data parsed json


/*
    "крючки цепляемые к компонентам"
    useState    - созд. состояния
    useEffect   - действие в произвольный момент действия
    useCallback - кеширование функции (чтобы не пересоздавалась заного)
    useMemo     - кеширует вычисления которые тяжело расщитываются
    useReducer  - создание сложного стейта в Redux стиле
    useContext  - проброс данных сквозь уровни
    useRef      - возможность дотянутся до конкретного тега с помощью создания прямой ссылки на конкретнгный узел дом
 */

/*
    pure js callback

    function fn(i, ev) {
        //some
    }

    let elements = document.querySelectorAll("some");

    elements.forEach( (element, i) => {
        element.addEventListener("click", e => fn(i, e))
    } );
 */