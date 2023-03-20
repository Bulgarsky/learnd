let userInput = prompt("введите строку: ");

countVowelSymbols(userInput);

function countVowelSymbols (string) {
    let count = 0;
    let ruVowelSymbols = ['у', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю'];
    for (let i = 0; i < string.length; i++ ) {
        let symbol = string.charAt(i);
        if (ruVowelSymbols.includes(symbol.toLowerCase()))  {
            count++;
        }
    }
    return alert("["+string + "] руc.гласных букв: " + count);
}