const cars=['Mazda','Mersedes','Ford'];
//mutation = str
console.log('длина = '+cars.length+'. Cars: '+cars);
console.log('Запрашиваемый элемент = '+cars[1]);
//
console.log('длина = ',cars.length,'. Cars: ',cars);
console.log('Запрашиваемый элемент = ',cars[1]);
//
//array is const = но всеравно редактируется
const  bikes=['Honda','Suzuki','KTM','Harley-Davidson'];
console.log('bikes: ',bikes);
console.log('Element: ',bikes[2]);
cars[0]='Porsche'; //добавление по номеру элемента
console.log(cars);
cars[3]='mazda'
console.log(cars);
cars[cars.length]='lada'; //добавление в конец
console.log(cars);