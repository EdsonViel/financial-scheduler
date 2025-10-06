import { Component, input } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzInputNumberModule } from 'ng-zorro-antd/input-number';
import { NzPageHeaderComponent } from 'ng-zorro-antd/page-header';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { CommonModule } from '@angular/common';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { Transaction as TransactionInterface } from '../../shared/interfaces/transaction';

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
    NzIconModule,
    CommonModule
  ],
  templateUrl: './transaction.html',
  styleUrl: './transaction.scss'
})
export class Transaction {
  transaction = input<TransactionInterface | null>(null);

  form!: FormGroup;

  constructor(private fb: FormBuilder) { 
    this.form = this.fb.group({
      amount: [0, Validators.required],
      sourceAccountId: [null, Validators.required],
      destinationAccountId: [null, Validators.required],
      scheduledDate: [null, Validators.required]
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

  save(): void {
    console.log(this.form.value);
  }
}
