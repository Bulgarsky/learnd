import React, {useContext} from "react";
import {AppContext} from "../hooks/ContextComponent.jsx";
import Book from "./Book.jsx";

export default function Books(){
    const {
        books=[],
    } = useContext(AppContext);

    console.log(books);

    return (
        <div className="books">
            <h3>
                Total books
                <sup>{" " + books.length}</sup>
            </h3>
            {
                books.map(book =>{
                    return (
                        <Book
                            key={book.id}
                            {...book}
                        />
                    )
                })
            }
        </div>
    )
}
