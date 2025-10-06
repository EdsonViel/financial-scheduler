export interface Transaction {
    id: number;
    amount: number;
    sourceAccountId: number;
    destinationAccountId: number;
    //timestamp: string; // ISO 8601 format
    scheduledDate: Date;
}
