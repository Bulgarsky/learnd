interface DataModel{
    id: string,
    title: string,
    elements: {
        header: {
            title: string,
            description: string,
            links: string[]
        },
        footer: {
            description: string,
            links: string[]
        },
        body: [
            {
                title: string,
                content: {}
            },
        ],
    }
}
type model = DataModel['elements']['footer'];

type someTuple = [number, string, boolean, ...string[]];
const arr: someTuple = [1, "word", true, "", ""];
type T0 = someTuple[0];

const sizes = ["small", "medium", "large"] as const; //readonly []
type T02 = typeof sizes[1]; //"meduim
type T2= typeof sizes[number]; //return union "small" | "medium" | "large"
