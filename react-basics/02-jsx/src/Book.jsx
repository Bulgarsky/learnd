export default function Book(props){
    //условие отрисовки через if
    if (!props.name) {
        return null;
    }
    return(
        <>
            <h3>name: {props.name}</h3>
            <p>year: {props.year}</p>
            <p>price: {props.price}</p>
            <p>{props.children}</p>
        </>
    )
}

//условие отрисовки через тернарный оператор
function Book2(props){
    return props.name ? (
        <>
            <h3>name: {props.name}</h3>
            <p>year: {props.year}</p>
            <p>price: {props.price}</p>
            <p>{props.children}</p>
        </>
    ) : null;
}