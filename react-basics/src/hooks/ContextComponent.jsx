import React, {createContext, useState} from "react";

//createContext для проброса props в компоненты
//в нем два ключа: Consumer, Provider (тут useContext)
export const AppContext = createContext();

export const ContextComponent = (props) => {
    const [books, setBooks] = useState([
        {
            id: 1,
            isbnCode: "abc1",
            title: "War and Society. Tolstoy"
        },
        {
            id: 2,
            isbnCode: "cde2",
            title: "Middle History. Smith-Edison"
        },
        {
            id: 3,
            isbnCode: "fgh3",
            title: "Society 21 century. MIT"
        }
    ]);

    function addBook(book){
      // setBooks(book, ...books])
    }

    function removeBook(id){
        //books.фильтровать(каждую book => проверяя по book.ISBN !== принимаемому ISBN)
        setBooks(books.filter(book => book.id !== id));
    }

    const ourContextProperties = {
        books,
        addBook,
        removeBook
    }
    return(
        // ContextComponent принимает просы через value
        // Обертка провайдера - через него все компоненты получат доступ к props Value
        <AppContext.Provider value={ourContextProperties}>
            {/*<ContextComponent.Provider value={ {books, addBook,removeBook} }>*/}
            {/*передать дочерние элементы через пропсы*/}
            {props.children}
        </AppContext.Provider>
    );
}