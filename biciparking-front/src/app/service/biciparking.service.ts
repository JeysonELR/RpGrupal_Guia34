import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BiciparkingService {

  private API_SERVER = "http://localhost:8080/";

  constructor(private httpClient: HttpClient) { }



  public getAllBiciparking(): Observable<any>{
    return this.httpClient.get(this.API_SERVER + "registrosBicicletas");
  }

  public saveBiciparking (biciparking:any): Observable<any>{
    const options = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Accept': '*/*'
      }),
      responseType: 'text' as const,
    };
    return this.httpClient.post(this.API_SERVER + "registroBicicleta", biciparking, options);
  }

  public getPersonaById(id: any):Observable<any>{
    return this.httpClient.get(this.API_SERVER + "registroBicicleta/"+id);
  }

  public getPersonaDatos(id: any):Observable<any>{
    return this.httpClient.get(this.API_SERVER + "registroBicicleta/"+id);
  }

  public registrarSalida(id: any):Observable<any>{
    const options = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Accept': '*/*'
      }),
      responseType: 'text' as const,
    };
    return this.httpClient.get(this.API_SERVER + "salidaRegistroBicicleta/"+id, options);
  }

  public eliminarRegistro(id: any):Observable<any>{
    const options = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Accept': '*/*'
      }),
      responseType: 'text' as const,
    };
    return this.httpClient.delete(this.API_SERVER + "registroBicicleta/"+id,options);
  }
}
