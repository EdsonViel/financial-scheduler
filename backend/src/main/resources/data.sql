insert into account (account_number) values ('0000000001');
insert into account (account_number) values ('0000000002');
insert into account (account_number) values ('0000000003');
insert into account (account_number) values ('0000000004');
insert into account (account_number) values ('0000000005');
insert into account (account_number) values ('0000000006');

insert into fee_rule (min_days_ahead, max_days_ahead, fee_percentage) values (0, 0, 2.5);
insert into fee_rule (min_days_ahead, max_days_ahead, fee_percentage) values (1, 10, 0.0);
insert into fee_rule (min_days_ahead, max_days_ahead, fee_percentage) values (11, 20, 8.2);
insert into fee_rule (min_days_ahead, max_days_ahead, fee_percentage) values (21, 30, 6.9);
insert into fee_rule (min_days_ahead, max_days_ahead, fee_percentage) values (31, 40, 4.7);
insert into fee_rule (min_days_ahead, max_days_ahead, fee_percentage) values (41, 50, 1.7);
