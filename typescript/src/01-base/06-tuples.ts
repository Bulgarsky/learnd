//кортеж ограничен каким то колвом элементов (c не разрозненными типами данных)
const pairs: [string, string][] = [["key1", "value1"], ["key2", "value2"]];

const someData:[number, boolean, string] = [1, true, "title"];

//CSV - Comma Separated Value (значения разделенные запятой)
const doc: [string, string, number, Date][] = [];
doc.push(["John", "Doe", 1987, new Date(2023,12,31)]);

export {};