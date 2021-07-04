export class CartItem
{
    name: String;
    price: String;
    url: String;
    id: Number;
    qty:Number;
    constructor( name: String,price : String , url : String, qty : number)
    {
        this.name=name;
        this.price=price;
        this.url=url;
        this.qty=qty;
    }
}