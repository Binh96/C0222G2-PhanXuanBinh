import { Customertype } from "./customertype";

export interface Customer {
    id?: string;
    name?: string;
    gender?: string;
    dob?: string;
    numberPhone?: string;
    email?: string;
    address?: string;
    type?: Customertype;
    idCard?: string;
}
