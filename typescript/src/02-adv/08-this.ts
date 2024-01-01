//this context

const user = {
    id: 123,
    admin: false,
    becomeAdmin: function() {
        this.admin = true;
    },
};

/*
<button onClick="handleClick"> Click </button>
 */

//this не является передаваемым в функцию параметром, он передастся по умолчанию
//this ссылается на тип обьект
function handlerClick(this: HTMLButtonElement, event: Event){
    this.disabled = true;
}
