import React from 'react';
import { useForm } from "react-hook-form";
import Button from "react-bootstrap/Button";

const Contacts = () => {
    const { register, handleSubmit, watch, formState: { errors } } = useForm();
    const onSubmit = data => console.log(data);
    console.log("Контакты / форма");

    return (
        <div style={{margin: "10px", padding: "10px"}} >
            <h2>Feedback us</h2>
        <form onSubmit={handleSubmit(onSubmit)}>
            <div className="input-group mb-3">
                <span className="input-group-text" id="inputGroup-sizing-default">Your name: </span>
                <input {...register("name")}
                       type="text" className="form-control" aria-label="name"
                       aria-describedby="inputName"
                       placeholder="John Doe"
                />
            </div>
            <div className="input-group mb-3">
                <span className="input-group-text" id="inputGroup-sizing-default">Your email: </span>
                <input {...register("email")}
                       type="email" className="form-control" aria-label="email"
                       placeholder="johndoe@domen.com" aria-describedby="inputEmail"/>
            </div>
            <div className="input-group mb-3">
                <input {...register("files")}
                    type="file" className="form-control" id="inputGroupFile"/>
                    <label className="input-group-text" htmlFor="inputGroupFile">Upload</label>
            </div>
            <div className="mb-3">
                <label htmlFor="exampleFormControlTextarea1" className="form-label">Your Message: </label>
                <textarea {...register("message")}
                          className="form-control" id="FormControlTextarea" rows="3"
                placeholder="input your message here">

                </textarea>
            </div>
            <br/>
            <Button type="submit" variant="outline-dark">
                Send feedback message
            </Button>
        </form>
        </div>
    );
};

export default Contacts;