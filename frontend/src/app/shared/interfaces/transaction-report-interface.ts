import { AccountInterface } from "./account-interface";

export interface TransactionReportInterface {
    id: number;
    amount: number;
    sourceAccount: AccountInterface;
    destinationAccount: AccountInterface;
    fee: any;
    scheduledDate: Date;
    createdAt: Date;
}