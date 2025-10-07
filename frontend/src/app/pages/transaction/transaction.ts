import { Component, inject, input } from '@angular/core';
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzInputNumberModule } from 'ng-zorro-antd/input-number';
import { NzPageHeaderComponent } from 'ng-zorro-antd/page-header';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzFlexModule } from 'ng-zorro-antd/flex';
import { TransactionInterface } from '../../shared/interfaces/transaction-interface';
import { Router } from '@angular/router';
import { TransactionService } from '../../shared/services/transaction-service';

@Component({
  standalone: true,
  selector: 'app-transaction',
  imports: [
    FormsModule, 
    NzPageHeaderComponent, 
    NzFormModule, 
    NzInputModule, 
    NzInputNumberModule, 
    ReactiveFormsModule, 
    NzSelectModule, 
    NzDatePickerModule, 
    NzButtonModule,
    NzFlexModule
  ],
  templateUrl: './transaction.html',
  styleUrl: './transaction.scss'
})
export class Transaction {
  
  transactionService = inject<TransactionService>(TransactionService);
  router = inject(Router);

  form: FormGroup;

  constructor() { 
    this.form = new FormGroup({
      amount: new FormControl<number>(0, {nonNullable: true, validators: [Validators.required]}),
      sourceAccountId: new FormControl<number | null>(null, {nonNullable: true, validators: [Validators.required]}),
      destinationAccountId: new FormControl<number | null>(null, {nonNullable: true, validators: [Validators.required]}),
      scheduledDate: new FormControl<Date | null>(null, {nonNullable: true, validators: [Validators.required]})
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    // console.log(this.form.value);
  }

  back(): void {
    window.history.back();
  }

  save(transaction: TransactionInterface): void {
    console.log(this.form.value);
    this.transactionService.post(transaction);
  }
}
