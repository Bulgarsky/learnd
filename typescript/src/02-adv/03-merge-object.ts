//aliases and interfaces

//Product: price, isNew, isSale, title
//Vehicle: brand, year, color
//Car: type, model +Product, + Vehicle

interface IProduct {
    title: string,
    price: number,
    isNew: boolean,
    isSale?: boolean
}

interface IVehicle{
    brand: string,
    year: number,
    color: string
}

interface ICar extends IVehicle, IProduct {
    type: string
}

type Product = {
    title: string,
    price: number,
    isNew: boolean,
    isSale: boolean
}

type Vehicle = {
    brand: string,
    year: number,
    color: string
}

type Car = {
    type: "track" | "passenger" | "electro"
} & Vehicle & Product


const car01: ICar = {
    brand: "bmw",
    color: "white",
    isNew: true,
    price: 100,
    title: "bmw 3 turbo",
    type: "passenger",
    year: 2023
}

const track01: Car = {
    brand: "Tesla",
    color: "metalic black",
    isNew: false,
    isSale: true,
    price: 150,
    title: "tesla cube",
    type: "electro" ,
    year: 2020
}

export {};