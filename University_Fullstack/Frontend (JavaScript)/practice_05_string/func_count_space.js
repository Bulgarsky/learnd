let userInput = prompt("введите строку: ");
//1:
//alert(countSpaces(userInput));
//2:
//alert("в вашей строке " +countSpaces(userInput)+" пробелов");
//3:
countSpaces(userInput);
countSpaces("в этой строке 5 пробелов !");
function countSpaces (string) {
    let count = 0;
    let textSpace = " ";
    for (let i = 0; i < string.length; i++ ) {
        let symbol = string.charAt(i);
        if (symbol == textSpace) {count++}
    }
    //1:
    //return "в строке ["+string+"] пробелов: "+count;
    //2:
    //return count;
    //3:
    return alert("количество пробелов: " + count);
}