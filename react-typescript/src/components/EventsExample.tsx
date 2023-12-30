import {FC, useRef, useState} from "react";


const EventsExample: FC = () => {
    const [value, setValue] = useState<string>("");
    const [isDrag, setIsDrag] = useState<boolean>(false);
    const inputRef = useRef<HTMLInputElement>(null);

    //event оборачивается в СинтетикЕвент
    function handleChange (event: React.ChangeEvent<HTMLInputElement>) {
        setValue(event.target.value);
    }

    function handleClick(event: React.MouseEvent<HTMLButtonElement>){
        //console.log("event: ", value);
        console.log(inputRef.current?.value);
    }

    function handleDrag(event: React.DragEvent<HTMLDivElement>){
        //event.dataTransfer
        console.log('Drag !');
    }
    function handleDragWithPrevent(event: React.DragEvent<HTMLDivElement>){
        event.preventDefault();
        setIsDrag(true);
    }
    function handleLeave(event: React.DragEvent<HTMLDivElement>){
        event.preventDefault();
        setIsDrag(false);
    }
    function handleDrop(event: React.DragEvent<HTMLDivElement>){
        event.preventDefault();
        setIsDrag(false);
        console.log("Drop !");
    }


    return(
        <>
            <h3>Event</h3>
            <input
                value={value}
                onChange={handleChange}
                type="text" placeholder="Controlled"/>
            <input ref={inputRef}
                type="text" placeholder="Uncontrolled"/>
            <button onClick={handleClick}>Event! </button>
            <br/>
            <br/>
            <div onDrag={handleDrag} draggable style={{width: '100px', height: '100px', background: 'royalblue'}}></div>
            <div onDrop={handleDrop}
                 onDragLeave={handleLeave}
                 onDragOver={handleDragWithPrevent}
                 style={{width: '100px', height: '100px', background: isDrag ? 'green' : 'coral', marginTop: '10px'}}></div>
        </>
    )
}

export default EventsExample;