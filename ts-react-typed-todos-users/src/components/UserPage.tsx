import axios from "axios";
import {useNavigate} from "react-router-dom";

import {FC, useEffect, useState} from "react";
import {IUser} from "../interfaces/types.tsx";

import List from "./List.tsx";
import UserItem from "./UserItem.tsx";

const UserPage: FC = () => {
    const [users, setUsers] = useState<IUser[]>([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetchUsers();
    }, []);
    async function fetchUsers(){
        try {
            const response = await axios.get<IUser[]>("https://jsonplaceholder.typicode.com/users");
            setUsers(response.data);
        } catch (error) {
            alert(error);
        }
    }
    return(
        <>
            <h3>User list</h3>
            <List
                items={users}
                renderItem={(user:IUser) => <UserItem onClick={(user) => navigate('/users/' + user.id)} user={user} key={user.id} /> }
            />
        </>

    )
}

export default UserPage;