type Level = "junior" | "middle" | "senior";

interface IDeveloper {
    login: string,
    skills: string[],
    level: Level
}

export function gradeDeveloper(user:{level: Level}, /*newLevel: Level*/) {
    // user.level = newLevel;

    switch (user.level){
        case "junior":
            user.level = "middle";
            break;
        case "middle":
            user.level = "senior";
            break;
        case "senior":
            console.log("promotion limit has been exhausted")
            break;
        default:
            console.log("f gradeDeveloper: error")
    }

}

const user1503:IDeveloper = {
    login: "bulgarsky",
    skills: ["html/css", "sql", "js/ts" , "java, spring"],
    level: "junior"
}

//gradeDeveloper(user1503, "middle");
gradeDeveloper(user1503);

export {};