import {Routes, Route, BrowserRouter, NavLink} from "react-router-dom";

// import UserList from "./components/UserList.tsx";
// import {users} from "./mock/users.ts";
import Card, {CardVariant} from "./components/Card.tsx";
import EventsExample from "./components/EventsExample.tsx";

import UserPage from "./components/UserPage.tsx";
import {UserItemPage} from "./components/UserItemPage.tsx";

import TodosPage from "./components/TodosPage.tsx";
import {TodoItemPage} from "./components/TodoItemPage.tsx";


function App() {

  return (
    <>
        <BrowserRouter>
            <div>
                <NavLink to="/users" >Users</NavLink>
                <br />
                <NavLink to="/todos" >Todos</NavLink>
                <br />
                <NavLink to="/events" >Events</NavLink>
                <br />
                <NavLink to="/card" >Card</NavLink>
            </div>
            <Routes>
                <Route path={'/users'} element={  <UserPage /> } />
                <Route path={'/users/:id'} element={ <UserItemPage />} />
                <Route path={'/todos/'} element={ <TodosPage /> } />
                <Route path={'/todos/:id'} element={ <TodoItemPage />} />
                <Route path={'/events'} element={ <EventsExample /> } />
                <Route path={'/card'} element={
                    <Card
                        width='200px'
                        height='200px'
                        variant={CardVariant.primary}
                    >
                        <button> click! </button>
                    </Card>
                } />

            </Routes>
        </BrowserRouter>



    </>
  )
}

export default App;
{/*<UserList users={users} />*/}