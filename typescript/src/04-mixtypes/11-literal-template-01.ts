//text transformation utils:
// Capitalize, Lowercase, Uppercase, Uncapitalize

type Side = "top" | "right" | "bottom" | "left";
type MarginCSS = `margin-${Side}`;
type PaddingCSS = `padding-${Side}`;

//Capitalize
type MarginJS = `margin${'' | Capitalize<Side>}`;
type PaddingJS = `padding${'' | Capitalize<Side>}`;

//Capitalize mix
type Direction = "down" | "left" | "right"| "up";
type Position = "top" | "out";
type Entry = "in" | "out";
type FadeClassName = `fade${Capitalize<Entry>}${Capitalize<'' | Direction | Position>}`;

interface Car {
    brand: string,
    model: string,
    year: number
}
type CarFactory = {
    [K in keyof Car as `set${Capitalize<K>}`]: (car: Car, value: Car[K]) => void;
}