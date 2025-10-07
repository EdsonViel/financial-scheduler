import { inject, Injectable } from '@angular/core';
import { TransactionInterface } from '../interfaces/transaction-interface';
import { APIWrapper } from '../helpers/APIWrapper';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  httpClient = inject(APIWrapper);

  post(payload: TransactionInterface) {
    return this.httpClient.post('/api/transactions', payload);
  }

  getAll(page: number = 1, size: number = 25): Promise<any> {
    page = page - 1;
    page = page < 0 ? 0 : page;
    return this.httpClient.get(`/api/transactions?page=${page}&size=${size}`);
  }
  
}
