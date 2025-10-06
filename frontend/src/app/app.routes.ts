import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  { path: 'welcome', loadChildren: () => import('./pages/welcome/welcome.routes').then(m => m.WELCOME_ROUTES) },
  { path: 'transaction', loadChildren: () => import('./pages/transaction/transaction.routes').then(m => m.TRANSACTION_ROUTES) },
  { path: 'report', loadChildren: () => import('./pages/report/report.routes').then(m => m.REPORT_ROUTES) }
];
