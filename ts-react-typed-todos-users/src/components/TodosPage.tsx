import {FC, useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

import {ITodo} from "../interfaces/types.tsx";

import TodoItem from "./TodoItem.tsx";
import List from "./List.tsx";




const TodosPage: FC = () => {
    const [todos, setTodos] = useState<ITodo[]>([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetchTodos();
    }, []);


    async function fetchTodos(){
        try {
            const response = await axios.get<ITodo[]>("https://jsonplaceholder.typicode.com/todos?_limit=10");
            setTodos(response.data);
        } catch (error) {
            alert(error);
        }
    }

    return(
        <>
            <h3> todos list </h3>
            <List
                items={todos}
                renderItem={(todo:ITodo) =>
                    <TodoItem onClick={(todo) =>
                    navigate("/todos/"+todo.id)} todo={todo} key={todo.id}/> }
            />
        </>

    )
}

export default TodosPage;