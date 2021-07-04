export class JwtResponse
{
    status: number;
    username: string; /**(or userid)***/
    token: Token;


}

export class Token
{
    token : string;
    username: string;

}
