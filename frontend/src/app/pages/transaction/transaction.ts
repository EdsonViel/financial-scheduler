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
import { NzNotificationPlacement, NzNotificationService } from 'ng-zorro-antd/notification';
import { TransactionInterface } from '../../shared/interfaces/transaction-interface';
import { Router } from '@angular/router';
import { TransactionService } from '../../shared/services/transaction-service';
import { AccountService } from '../../shared/services/account-service';

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
  accountService = inject<AccountService>(AccountService);
  router = inject(Router);

  form: FormGroup;

  accounts: any[] = [];
  accountsExcluding: any[] = [];

  constructor(private notification: NzNotificationService) { 
    this.form = new FormGroup({
      amount: new FormControl<number>(0, {nonNullable: true, validators: [Validators.required]}),
      sourceAccountId: new FormControl<number | null>(null, {nonNullable: true, validators: [Validators.required]}),
      destinationAccountId: new FormControl<number | null>(null, {nonNullable: true, validators: [Validators.required]}),
      scheduledDate: new FormControl<Date | null>(null, {nonNullable: true, validators: [Validators.required]})
    });
  }

  ngOnInit(): void {
    this.readAccounts();
  }

  onSubmit(): void {
    // console.log(this.form.value);
  }

  back(): void {
    window.history.back();
  }

  save(transaction: TransactionInterface): void {
    console.log(this.form.value);
    if (transaction.amount <= 0) {

      this.create_notification('error', 'Erro', 'O valor da transação deve ser maior que zero.', 'topRight');
      
      return;
    }
    if (transaction.sourceAccountId === transaction.destinationAccountId) {

      this.create_notification('error', 'Erro', 'A conta de origem e destino devem ser diferentes.', 'topRight');
      
      return;
    }

    let now = new Date();
    now.setHours(0, 0, 0, 0);
    transaction.scheduledDate.setHours(0, 0, 0, 0);
    if (transaction.scheduledDate < now) {

      this.create_notification('error', 'Erro', 'A data agendada deve ser igual ou maior que a data atual.', 'topRight');

      return;
    }
    this.transactionService.post(transaction);
  }

  create_notification(type: string, title: string, content: string, placement: NzNotificationPlacement): void {
    this.notification.create(
      type,
      title,
      content,
      { nzPlacement: placement }
    );
  }

  readAccounts(): void {
    this.accountService.getAll().then((resolve: any) => {
      this.accounts = resolve;
      this.form.get('destinationAccountId')?.setValue(null);
      this.accountsExcluding = [];
    });
  }

  readAccountsExcluding(id: any): void {
    console.log(id);
    if (this.form.get('destinationAccountId')?.value === id) {
      this.form.get('destinationAccountId')?.setValue(null);
    }
      this.accountService.getAllExcluding(id).then((resolve: any) => {
      console.log(resolve);
      this.accountsExcluding = resolve;
      
    });
  }
}
