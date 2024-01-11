//сужение допуст значений
export function keys<O extends  object>(obj: O): Array<keyof O>{
    const currentKeys = [];

    for (let key in obj){
        if (obj.hasOwnProperty(key)){
            currentKeys.push(key);
        }
    }
    return currentKeys;
}


export function  values<O extends object>(obj: O): Array<O[keyof O]>{
    const currentValues = [];

    for (let key in obj){
        currentValues.push(obj[key]);
    }

    return currentValues;
}