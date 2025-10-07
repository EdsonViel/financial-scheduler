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

  getAll() {
    return this.httpClient.get('/api/transactions');
  }
  
}
