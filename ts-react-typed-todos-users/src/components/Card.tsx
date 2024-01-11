import {FC, PropsWithChildren} from "react";

export enum CardVariant {
    outlined = 'outlined',
    primary = 'primary'
}
interface CardProps extends PropsWithChildren{
    width?: string;
    height?: string;
    variant: CardVariant;
    // onClick: (num: number) => void;
}

//React.FC - functional component
const Card: FC<CardProps> = ( props ) => {
    const {
        width,
        height,
        variant,
        // onClick,
        children} = props;

    // const [state, setState] = useState(0);

    return(
        <div
            style={{width, height,
                border: variant === CardVariant.outlined ? '2px solid gray' : 'none',
                borderRadius: '15px',
                background: variant === CardVariant.primary ? 'lightgray' : ''}}>
            {children}
        </div>
    )
}

export default Card;



/*

// children?: React.ReactChild | React.ReactNode;

const Card = ({width, height}: CardProps) => {

    return(
     <div style={{width, height, border: '2px solid gray', borderRadius: '15px'}}>

     </div>
    )
}

 */