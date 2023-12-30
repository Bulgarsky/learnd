import {FC, useEffect, useState} from "react";
import {IUser} from "../interfaces/types.tsx";
import axios from "axios";
import {useNavigate, useParams} from "react-router-dom";

interface UserItemPageParams{
    id: string;
}


export const UserItemPage: FC = () => {
    const [user, setUser] = useState<IUser | null>(null);
    const params = useParams<UserItemPageParams>();
    const navigate = useNavigate();

    useEffect(() => {
        fetchUser();
    }, []);
    async function fetchUser(){
        try {
            const response = await axios.get<IUser>("https://jsonplaceholder.typicode.com/users/"+params.id);
            setUser(response.data);
        } catch (error) {
            alert(error);
        }
    }

    return(
        <>
            <button onClick={() => navigate('/users')}> back to list</button> <br />
            <h3>user page: {user?.name}</h3>
            <p>email: {user?.email}</p>
            <p>Address: {user?.address.zipcode}, {user?.address.city}, {user?.address.street}</p>
        </>
    )
}