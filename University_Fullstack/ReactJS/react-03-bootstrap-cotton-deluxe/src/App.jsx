import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "./components/Header";
import Slider from "./components/Slider";
import CartItem from "./components/cart/CartItem";
import Footer from "./components/Footer";
import React, {useState} from "react";
import ProductCard from "./components/ProductCard";


//npm install react-bootstrap bootstrap
//npm install -g react-devtools
//npm run build
//rsc


function App() {

    //хранение данных
    const [products, setProducts] = useState([])
        fetch('https://642ea6618ca0fe3352d53368.mockapi.io/products').then((productJSON) => console.log(productJSON));

  return (
      <div>
          <Header/>
          {/*слайдер галереии*/}
          {/*<Slider/>*/}
          {/*каточка товара*/}
          {/*<ProductCard/>*/}
          <CartItem item={products} />
          <Footer/>
      </div>
  );
}


export default App;
