
export class SignUpRequest
{
    
    username: string;
    email: string;
    password: string;
    confirmPassword: string;
    telephone: bigint;
    constructor(username: string, email: string,password: string,confirmPassword : string,telephone: bigint){
        this.username=username;
        this.email=email;
        this.password=password;
        this.confirmPassword=confirmPassword;
        this.telephone=telephone;
    }
}