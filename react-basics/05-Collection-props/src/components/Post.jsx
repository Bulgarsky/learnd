export default function  Post({id, name, cb, removePost}){
    //деструктуризация пропсов в принимаемых значениях

    return (
        <>
            <h3> {name}
                <button onClick={() => removePost(id)}> x </button>
            </h3>
        </>
    )
}