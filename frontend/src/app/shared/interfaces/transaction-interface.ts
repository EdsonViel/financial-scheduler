export interface TransactionInterface {
    //id: number;
    amount: number;
    sourceAccountId: number;
    destinationAccountId: number;
    //timestamp: string; // ISO 8601 format
    fee: any;
    scheduledDate: Date;
}
