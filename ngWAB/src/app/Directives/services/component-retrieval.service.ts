import { Injectable, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ComponentRetrievalService {
    constructor(private http: HttpClient) {}

    private httpOptions: HttpHeaders;

    /*httpGetDefinedComponents(): void {
        this.http.get<Array<DefinedComponent>>('theUrl').subscribe(
            data => {
                this.defComps = data;
                this.defCompsBack.emit(data);
            }
        );
    }

    getDefComps(): Array<DefinedComponent> {
        return this.defComps;
    }*/
}
