import { Product } from "./product";

export interface Consigment {
    id?: number;
    codeConsignment?: number;
    product?: Product;
    quantity?: number;
    dateIn?: string;
    dateOut?: string;
    endOfDate?: string;
}
