create table form(
    id bigserial primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    phone varchar(255) not null,
    experience bool not null ,
    strategy varchar not null ,
    has_account bool not null ,
    account_balance varchar not null ,
    goal varchar not null ,
    job varchar not null ,
    salary varchar not null ,
    amount_goal varchar not null ,
    missing_from_achieving_goal varchar not null ,
    investment_amount varchar not null
)