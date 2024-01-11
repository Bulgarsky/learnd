//text transformation utils:
// Capitalize, Lowercase, Uppercase, Uncapitalize
type Style = "none" | "dotted" | "dashed" | "solid";
type Color = "Red" | "Green" | "BLUE" | "Black" | "White";

//border-style: "solid"
type BorderStyle = `${Style} ${Lowercase<Color>}`;
let borderStyle: BorderStyle = "solid red";
let borderStyle2: BorderStyle ="dotted green"