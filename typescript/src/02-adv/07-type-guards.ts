interface  IOrder {
    address: string;
}

interface IOrderFromPhone extends IOrder {
    callNumber: string;
}

interface IOrderFromInternet extends IOrder{
    email: string;
}

type PossibleOrder = IOrderFromPhone | IOrderFromInternet | undefined;

//претикаты функций - выражение, возвращают boolean( true | false )
function isInternetOrder (order: PossibleOrder): order is IOrderFromInternet {
    return !!order && "email" in order;
}
// function isInternetOrder (order: PossibleOrder): order is IOrderFromInternet {
//     return (order as IOrderFromInternet).email !== undefined;
// }

function isPhoneOrder (order: PossibleOrder): order is IOrderFromPhone {
    return !!order && "callPhone" in order;
}

function createOrder(order: PossibleOrder){

    if (isInternetOrder(order)) {
        console.log(order.email)
    } else if (isPhoneOrder(order)) {
        console.log(order.callNumber)
    }

}

export {};