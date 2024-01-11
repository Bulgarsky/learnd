type WindowProps = keyof Window;
//window global obj
const value: WindowProps = "ontoggle";

interface  PC{
    brand: string,
    year: string
}

type Type1 = keyof PC; // brand | year
const value1: Type1 = "brand";

type Tuplez1 = keyof [string, number]; //сужение до двух типов
const value2: Tuplez1 = 1; // "0"

export {};