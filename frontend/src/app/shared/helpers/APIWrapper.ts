import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../../../environments/environment";

@Injectable({
  providedIn: 'root',
})

export class APIWrapper {

  baseURL = `${environment.api_url}`;

  constructor(private http: HttpClient) {
  }

  public post(url: string, data: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.post(`${this.baseURL}${url}`, data).subscribe({
        next: (data) => {
          resolve(data);
        },
        error(err) {

          reject(err);
        }
      });
    });
  }

  public get(url: string): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.get(`${this.baseURL}${url}`).subscribe({
        next: (data) => {
          resolve(data);
        },
        error(err) {
          reject(err);
        }
      });
    });
  }

}  
