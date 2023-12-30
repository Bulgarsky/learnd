import {FC} from 'react';
import {IUser} from "../interfaces/types.tsx";

interface UserItemProps{
    user: IUser;
    onClick: (user: IUser) => void;
}
const UserItem: FC<UserItemProps> = ({user, onClick}) => {
    return (
        <div onClick={() => onClick(user)}
            style={{padding: 15, border: '1px solid gray'}}>
            {user.id}. {user.name} lives in city {user.address.city} on {user.address.street}
        </div>
    );
};

export default UserItem;