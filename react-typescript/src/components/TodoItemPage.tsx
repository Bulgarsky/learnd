import {FC, useEffect, useState} from "react";
import {ITodo} from "../interfaces/types.tsx";
import axios from "axios";
import {useNavigate, useParams} from "react-router-dom";

interface TodoItemPageParams{
    id: number;
}
export const TodoItemPage: FC = () => {
    const [todo, setTodo] = useState<ITodo | null>(null);
    const params = useParams<TodoItemPageParams>();
    const navigate = useNavigate();

    useEffect(() => {
        fetchTodo();
    }, []);


    async function fetchTodo(){
        try {
            const response = await axios.get<ITodo>("https://jsonplaceholder.typicode.com/todos/"+params.id);
            setTodo(response.data);
        } catch (error) {
            alert(error);
        }
    }
    return(
        <>
            <br />
            <button onClick={() => navigate('/todos')}> back to list</button> <br />
            <h3>{todo?.id}</h3>
            <p>Todo: {todo?.title}</p>
        </>
    )
}