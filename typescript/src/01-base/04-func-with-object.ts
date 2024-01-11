function printPoint(point: {x: string, y: string }): void {
    console.log(`Current Coordinates: x: ${point.x} and y: ${point.y}`);
}

const target1 = {
    x: "123",
    y: "205"
}
printPoint(target1);

const target2 = {
    x: "560",
    y: "20",
    z: "12"
}
//have required params(x,y) and work, bcs obj can have optional params (y)
printPoint(target2);


function printUserInfo (
    user: {
        firstName: string,
        lastName?: string,
    }
): void {
    console.log("Hello, ", user.firstName.toUpperCase());

    if (user.lastName) {
        console.log("Nice to meet you Mr. ", user.lastName.toUpperCase());
    }
//    console.log("Nice to meet you Mr. ", user.lastName?.toUpperCase());
}
printUserInfo({firstName: "Marry"});
printUserInfo({firstName: "Ronald", lastName: "Reagan"});


export {};