import { inject, Injectable } from '@angular/core';
import { APIWrapper } from '../helpers/APIWrapper';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  httpClient = inject(APIWrapper);

  getAll(): Promise<any> {
    return this.httpClient.get(`/api/accounts`);
  }

  getAllExcluding(id: number): Promise<any> {
    return this.httpClient.get(`/api/accounts/exclude/${id}`);
  }
}
