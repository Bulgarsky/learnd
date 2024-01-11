//Record (one types data)
// record("key1", 10);
type Names = Record<string, number>;

type Brands = "apple" | "samsung" | "hitachi";
type BrandNames = Record<Brands, string>;
const brand01: { apple: string } = {
    apple: "some link"
}

//works with object, and help take keys
interface ITodo{
    id: string,
    title: string,
    desc: string,
    isCompleted: boolean
}
//pick (take)
type SimpleTodo = Pick<ITodo, "id" | "title" | "isCompleted">
const todo01:SimpleTodo = {
    id: "1",
    title: "first todo",
    isCompleted: true
}

//omit (throw out)
type SimpleTodo2 = Omit<ITodo, "desc" | "isCompleted">
const todo02: SimpleTodo2 = {
    id: "2",
    title: "second"
}

type NewTodo = Pick<ITodo, "title" | "desc">;

export {};