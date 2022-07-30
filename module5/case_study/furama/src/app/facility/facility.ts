import { TypeFacility } from "./type-facility";

export interface Facility {
    id?: string;
    type?: TypeFacility;
    nameService?: string;
    cost?: string;
    typeRent?: string;
    quantity?: string;
    area?: string;
    facilityFree?: string;
    numberOfFloor?: string;
    description?: string;
    standardRoom?: string;
    poolArea?: string;
}
