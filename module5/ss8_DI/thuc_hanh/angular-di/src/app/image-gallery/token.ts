import { InjectionToken } from "@angular/core";

export interface Token {
}

export const GalleryConfig = new InjectionToken<number>('GalleryConfig');
