import {FC} from "react";
import {ITodo} from "../interfaces/types.tsx";

export interface TodoItemProps{
    todo: ITodo;
    onClick: (todo: ITodo)=> void;
}

const TodoItem: FC<TodoItemProps> = ({todo, onClick}) => {

    return (
        <div onClick={() => onClick(todo)}>
            <input type="checkbox" checked={todo.completed}/>
            {todo.id}. {todo.title}
            <br />
        </div>
    );
}

export default TodoItem;