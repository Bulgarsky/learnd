import 'bootstrap/dist/css/bootstrap.min.css';

import Header from "./components/Header";
import Home from "./components/Home";
import Feedback from "./components/Feedback";
import Products from "./components/Products";
import Favorites from "./components/Favorites";
import Cart from "./components/Cart";
import Footer from "./components/Footer";

import React, {useState, useEffect} from "react";
import axios from "axios";
import {Route, Routes, BrowserRouter as Router} from 'react-router-dom';

import "./App.css";

//npm install
//npm install react-bootstrap bootstrap
//npm install -g react-devtools

//npm i axios
//npm i react-router-dom
//npm i react-hook-form
//npm run start
//rsc

function App() {
    console.log("-> APP.JSX Start");

    const [products, setProducts] = useState([])

    useEffect(()=>{
        async function axiosData(){
            console.log("async function");
            const productsData = await axios.get('https://642ea6618ca0fe3352d53368.mockapi.io/products');
            console.log(productsData);
            setProducts(productsData.data);
            console.log(productsData.data);
        }
        axiosData();
         },[]);

        return (
      <div>
          <Router>
              <Header/>
              <Routes>
                  <Route path='/' element={<Home />} />
                  <Route path='/feedback' element={<Feedback/>} />
                  <Route path='/products' element={<Products item={products}/>} />
                  <Route path='/favorites' element={<Favorites/>} />
                  <Route path='/cart' element={<Cart/>} />
              </Routes>
            <Footer/>
          </Router>
      </div>
  );
}

export default App;
