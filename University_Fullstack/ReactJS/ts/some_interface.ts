interface News {
    readonly author: string,
    title: string,
    short: string,
    article: string
    datestamp?: string
    img?: string
}

let news01: News = {
    author: 'Gabriel A.',
    title: 'freeway accident',
    short: 'On the 25th, there was an accident',
    article: 'On the 25th there was an accident, three cars collided. Five people were killed, three were hospitalized',
    img: 'accident.png'
}

console.log(news01);
console.log(news01.author +" - "+news01.article+" : "+ news01.article);

//readonly
//news01.author = "Alexandro Gabriel";
interface EditorCorrection extends News {
    readonly editor: string,
    [index:string]: any
}
interface NewsCorrection {
    readonly editor: string,
    newsTitle: string,
    [index:string]: any
}

let correction01: NewsCorrection ={
    editor: 'Alexa Bravo',
    newsTitle: 'freeway accident',
    note01: 'add more photos',
    note02: 'add more eyewitness comments'
}

console.log(correction01);
console.log(correction01.editor+": "+ correction01.note01+", "+correction01.note02);