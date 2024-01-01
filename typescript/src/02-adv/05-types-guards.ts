type Fish = { swim: () => void }
type Bird = { fly: () => void }

//нуно протестировать, чтобы результат был предсказуемым
function isFish (pet: Fish | Bird): pet is Fish {
    // (удтверждение) !==
    return (pet as Fish).swim !== undefined;
}

function move(animal: Fish | Bird): void {
    if (isFish(animal)){
        return animal.swim();
    }
    return animal.fly();
}

export {};