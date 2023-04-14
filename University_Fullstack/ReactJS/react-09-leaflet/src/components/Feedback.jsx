import React from 'react';
import { useForm } from "react-hook-form";
import Button from "react-bootstrap/Button";
import 'leaflet/dist/leaflet.css';
import {
    CircleMarker, MapContainer, Marker, Polygon, Popup, TileLayer, Tooltip
} from 'react-leaflet';

<<<<<<< HEAD
//npm i react-leaflet leaflet
=======
>>>>>>> a0158c4be067dd6c0a2c37fe41cd2cccd8e4d2bb
const centerPolygon = [
    [
        [61.245111, 73.455368],
        [61.242885, 73.420644],
        [61.236281, 73.480578],
        [61.243104, 73.471995]

    ]
];
const colorOptions={color:'darkred'};
const ourAddress=[61.243438, 73.393028];

const Feedback = () => {
    const { register, handleSubmit, watch, formState: { errors } } = useForm();
    const onSubmit = data => console.log(data);
    console.log("-> Обратная связь");

    return (
        <div style={{margin: "50px", padding: "50px", width: "80%" }} >
            <h2>Feedback us</h2>
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

            <div className="input-group mb-3">
                <input {...register("files")}
                    type="file" className="form-control" id="inputGroupFile"/>
                    <label className="input-group-text" htmlFor="inputGroupFile">Upload</label>
            </div>
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
            <br/>
            <div/>
            <br/>
            <MapContainer
                center={ourAddress}
                zoom={10} style={{width:'80vw',  height:'400px'}} >
                <TileLayer
                    url='https://api.maptiler.com/maps/basic-v2/256/{z}/{x}/{y}.png?key=PbYzGbTy9BYqNyYlnlfL'
                    attribution='<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>'
                />
                <CircleMarker center={ourAddress} pathOptions={{color: 'black'}} radius={10}>
                </CircleMarker>

                <Marker position={ourAddress}>
                    <Popup>We are here!</Popup>
                    <Tooltip>Our address:</Tooltip>
                </Marker>

                <Polygon positions={centerPolygon} pathOptions={colorOptions} />

            </MapContainer>
        </div>
    );

};

export default Feedback;