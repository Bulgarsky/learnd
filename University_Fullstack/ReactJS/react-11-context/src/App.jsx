import 'bootstrap/dist/css/bootstrap.min.css';

import Header from "./components/Header";
import Home from "./components/Home";
import Feedback from "./components/Feedback";
import Products from "./components/Products";
import Favorites from "./components/Favorites";
import Basket from "./components/basket/basket";
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

export const AppContext = React.createContext({});

function App() {
    console.log("-> APP.JSX Start");
    //для хранения товаров
    const [products, setProducts] = useState([]);
    //для хранения избранного
    const [favorites, setFavorites] = useState([]);
    //для хранения корзины
    const [overlayItems, setOverlayItems] = useState([]);

    useEffect(()=>{
        async function axiosData(){
            console.log("async function");
            //товары
            const productsData = await axios.get('https://642ea6618ca0fe3352d53368.mockapi.io/products');
            //избранное
            const favoritesData = await axios.get('https://64399fea90cd4ba563eae64a.mockapi.io/Favorites');
            //корзина
            const cartData = await axios.get('https://64399fea90cd4ba563eae64a.mockapi.io/Cart');

            console.log(productsData);
            setProducts(productsData.data);
            console.log(productsData.data);

            setFavorites(favoritesData.data);
            setOverlayItems(cartData.data);
            }
        axiosData();
         },[]);


    const deleteItems=(id)=>{
        // eslint-disable-next-line no-template-curly-in-string
        axios.delete('https://64399fea90cd4ba563eae64a.mockapi.io/Cart/${id}');
        setOverlayItems((objDelete) => objDelete.filter(item => item.id !== id));
    }

    const isAdded=(myId) => {
        return overlayItems.some((objIsAdded) => objIsAdded.myId === myId)
    }

    const isFavorite=(myId) => {
        return favorites.some((objIsFavorite) => objIsFavorite.myId === myId)
    }

    return (
        <AppContext.Provider
            value={
                    {
                        products,
                        setProducts,
                        overlayItems,
                        setOverlayItems,
                        favorites,
                        setFavorites,
                        isAdded,
                        isFavorite
                    }
                }>
          <div>
              <Router>
                  <Header/>
                  <Routes>
                      <Route path='/' element={<Home />} />
                      <Route path='/feedback' element={<Feedback/>} />
                      <Route path='/products' element={
                          <Products
                              item={products}
                              overlayItems={overlayItems}
                              setOverlayItems={setOverlayItems}
                              favorites={favorites}
                              setFavorites={setFavorites}
                          />}
                      />

                      <Route path='/favorites' element={
                          <Favorites
                              favorites={favorites}
                              setFavorites={setFavorites}
                              item={products}
                              overlayItems={overlayItems}
                              setOverlayItems={setOverlayItems}
                          />}
                      />
                      <Route path='/cart' element={
                          <Basket
                              overlayProps={overlayItems}
                              deleteItems={deleteItems}
                          />}
                      />
                  </Routes>
                <Footer/>
              </Router>
          </div>
      </AppContext.Provider>
  );
}

export default App;