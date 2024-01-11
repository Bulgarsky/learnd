import Book from "./Book.jsx";
import Preloader from "./Preloader.jsx";
export default function App(props) {

  return props.isLoading ? <Preloader /> : (
    <>
        <h1> Book for beginners </h1>
        <Book name="Java Script for dumb" year="2005" price="100"> Text placeholder </Book>
        <Book name="HTML and CSS" year="2010" price="50"/>
        <Book name="React to the Moon" year="2018" price="300"/>
        <Book name="" year="2012" price="550"/>
    </>
  )
}



//pug, twig, jsx - шаблонизаторы