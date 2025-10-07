import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzFormItemComponent } from 'ng-zorro-antd/form';
import { TransactionService } from '../../shared/services/transaction-service';
import { TransactionReportInterface } from '../../shared/interfaces/transaction-report-interface';
import { NzFormLabelComponent, NzFormControlComponent} from 'ng-zorro-antd/form';
import { LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from "@angular/forms";

@Component({
  standalone: true,
  selector: 'app-report',
  imports: [
    NzCardModule,
    NzFormItemComponent,
    NzFormLabelComponent,
    CommonModule,
    NzFormControlComponent,
    FormsModule
],
  templateUrl: './report.html',
  styleUrl: './report.scss',
  providers: [{ provide: LOCALE_ID, useValue: 'pt-BR' }]
})
export class Report implements OnInit {

  transactions: TransactionReportInterface[] = [];
  labels: string[] = ['ID', 'Valor', 'Conta de Origem', 'Conta de Destino', 'Taxa', 'Data Agendada', 'Criado Em'];
  columns: string[] = ['id', 'amount', 'sourceAccount.accountNumber', 'destinationAccount.accountNumber', 'fee', 'scheduledDate', 'createdAt'];

  constructor(
    protected route: ActivatedRoute,
    protected router: Router,
    public service: TransactionService
  ) { }

  ngOnInit(): void {
    this.read(1);
  }

  read(page: number) {
    this.service.getAll().then((resolve: any) => {
      console.log(resolve);
      this.transactions = resolve.content;
      console.log(this.transactions)

    });}

  getValue(obj: any, path: string): any {
    return path.split('.').reduce((acc, part) => acc && acc[part], obj);
  }
}
