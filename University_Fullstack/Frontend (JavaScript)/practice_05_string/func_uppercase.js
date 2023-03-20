let userInput = prompt("введите строку:").toString();

alert("С большой буквы: "+firstSymbolUp(userInput));
alert(firstSymbolUp(userInput));
alert(firstSymbolUp("грузовик перевернулся"));

function firstSymbolUp (String) {
    let firstSymbol = String.toUpperCase().charAt(0);
    let result = String.replace(String.charAt(0), firstSymbol);
    return result;
}