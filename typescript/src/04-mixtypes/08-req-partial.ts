interface ITodo{
    id: string,
    title: string,
    desc?: string,
    isCompleted: boolean
}

type ReadOnlyTodo = Readonly<ITodo>; // mark #all readonly
type PartialTodo = Partial<ITodo>; // mark #all ?

function updateTodo(todo: ITodo, fieldsToUpdate: PartialTodo){
    return {...todo, ...fieldsToUpdate};
}

type ReqTodo = Required<ITodo>; // mark #all required

export {};

