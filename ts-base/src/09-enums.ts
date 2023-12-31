enum Shapes {
    Circle = "Круг",
    Square = "Квадрат",
    Triangle = "Треугольник"
}

enum DeliveryServices {
    FivePost,
    Ozon,
    PonyExpress
}

let a = Shapes.Circle;
let o = DeliveryServices.Ozon;

enum Grages {
    Junior = "junior",
    Middle = "middle",
    Senior = "senior"
}
interface Developer{
    login: string,
    level: Grages,
    skills: string[]
}

const dev2:Developer = {
    login: "grak",
    level: Grages.Middle,
    skills: ["devops", "kubernetes"]
}

function promoteDeveloper(user:{ level: Grages}){
    switch (user.level){
        case Grages.Junior:
            user.level = Grages.Middle;
            break;
        case Grages.Middle:
            user.level = Grages.Senior;
            break;
        case Grages.Senior:
            console.log("promotion limit has been exhausted")
            break;
        default:
            console.log("Error: need correct ENUM Grades")
    }
}