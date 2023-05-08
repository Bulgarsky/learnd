import React from 'react';
import { useForm } from "react-hook-form";
import Button from "react-bootstrap/Button";
import axios from 'axios';

const Feedback = () => {
    const { register, handleSubmit, watch, formState: { errors } } = useForm();

    const onSubmit = (data) => {
        axios.post('https://642ea6618ca0fe3352d53368.mockapi.io/feedback', data);
        alert('Отправлено');
        console.log(watch(data));
    }

    console.log('Компонент "Обратная связь"');

    return (
        <div  class="feedback-form" >
            <h2>Feedback us</h2>
            <br/>
        <form onSubmit={handleSubmit(onSubmit)}>
            <div className="input-group mb-3">
                <span className="input-group-text" id="inputGroup-sizing-default">Your name: </span>
                <input {...register("name", {maxLength: 50, required:true})}
                       type="text" className="form-control" aria-label="name"
                       aria-describedby="inputName"
                       placeholder="John Doe"
                /><br/>

            </div>
                {errors?.name?.type === 'required'&&(
                    <span style={{color: "red"}} >Please fill in your name</span>
                )
                }
                <br/>

            <div className="input-group mb-3">
                <span className="input-group-text" id="inputGroup-sizing-default">Your email: </span>
                <input {...register("email", {required:true})}
                       type="email" className="form-control" aria-label="email"
                       placeholder="johndoe@domen.com" aria-describedby="inputEmail"/>
            </div>
            {errors?.email?.type === 'required'&&(
                <span style={{color: "red"}} >Please fill in email address</span>
            )
            }
            <br/>
            {/*для отправки файлов*/}
            {/*<div className="input-group mb-3">*/}
            {/*    <input {...register("files")}*/}
            {/*        type="file" className="form-control" id="inputGroupFile"/>*/}
            {/*        <label className="input-group-text" htmlFor="inputGroupFile">Upload</label>*/}
            {/*</div>*/}
            <div className="mb-3">
                <label htmlFor="exampleFormControlTextarea1" className="form-label">Your Message: </label>
                <textarea {...register("message", {required:true, minLength: 10})}
                          className="form-control" id="FormControlTextarea" rows="3"
                placeholder="input your message here">
                </textarea>
            </div>
            {errors?.message?.type === 'required'&&(
                <span style={{color: "red"}} >Please fill message</span>
            )
            }
            {errors?.message?.type === 'minLength'&&(
                <span style={{color: "red"}} >min.length message 10 symbols</span>
            )
            }
            <br/>
            <Button type="submit" variant="outline-dark">
                Send feedback message
            </Button>
        </form>
        </div>
    );

};

export default Feedback;