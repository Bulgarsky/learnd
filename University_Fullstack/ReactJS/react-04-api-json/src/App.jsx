import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "./components/Header";
import Footer from "./components/Footer";
import Slider from "./components/Slider";

import CartItem from "./components/cart/CartItem";
import Item from "./components/cart/Item";

import React, {useState, useEffect} from "react";



//npm install react-bootstrap bootstrap
//npm install -g react-devtools
//npm run build
//rsc


function App() {

    //хранение данных
    const [products, setProducts] = useState([])
        // fetch('https://642ea6618ca0fe3352d53368.mockapi.io/products').then((productJSON) => console.log(productJSON));
    useEffect(()=>{
        fetch('https://642ea6618ca0fe3352d53368.mockapi.io/products').then((productJSON) => {
        return productJSON.json();
        }).then((productJSON) => {
            setProducts(productJSON);
            console.log(productJSON);
        })
    },[]);

  return (
      <div>
          <Header/>
          {/*слайдер галереи*/}
          {/*<Slider/>*/}
          {/*карточка товара с Джейсоном*/}
          <CartItem item={products}/>

          <Footer/>
      </div>
  );
}


export default App;
