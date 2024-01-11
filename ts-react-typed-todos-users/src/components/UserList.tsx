import {FC} from "react";
import {IUser} from "../interfaces/types.tsx";
import UserItem from "./UserItem.tsx";

interface UserListProps{
    users: IUser[]
}

//rsf
const UserList: FC<UserListProps> = ({users}) => {


    return (
        <div>
            {
                users.map(user =>
                    <UserItem key={user.id} user={user} />
                )
            }
        </div>
    );
}

export default UserList;