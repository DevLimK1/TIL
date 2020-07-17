class SecurityContext  {
    constructor() {
        this._userName = null;
        this._authorities=[];
        this._defaultRole=null;
    }

    get userName(){
        return this._userName;
    }

    set userName(userName){
        this._userName=userName;
    }


}

export default new SecurityContext();