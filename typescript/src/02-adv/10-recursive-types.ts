//вложенность
type NestedNumbers = number | NestedNumbers[];
const numbs: NestedNumbers = [1, 3, 5, [[2, 5, 8], 6, 3]];
numbs.push(3);
numbs.push([2, 4, [2, 6]]);

//JSON
type JSONPrimitive = string | number | boolean | null;
type JSONObject = { [key: string]: JSONValue };
type JSONArray = JSONValue[];
type JSONValue = JSONPrimitive | JSONObject | JSONArray;

function isJSON(arg: JSONValue) {}
isJSON("hello");
isJSON({a: 100, b: [1, {b: "abc"}, 6]});

export {};