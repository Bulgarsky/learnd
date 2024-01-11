//mapped types about dynamic
type PcBrand = {
    name: string,
    country: string,
    createdAt: Date
}

type WellKnownBrands = "hp" | "apple" | "dell";
type PcRecord = {
    //[key: "a" | "b" ]: PcBrand  //impossible
    //[Type param in Type]
    [BrandKey in WellKnownBrands]?: PcBrand
}

const brandRecord: PcRecord = {
    apple: {
        country: "USA",
        createdAt: new Date(1980, 1,1 ),
        name: "Apple"
    }
}

function printPcItem(pcItem: PcRecord){
    console.log(pcItem.apple?.country);
}


//
type PartOfWindow = {
    //create dynamic Type in union]
    [Key in "document" | "screen" | "navigator"]?: Window[Key];
}
const p: PartOfWindow = {
    screen: window.screen,
}

export {};