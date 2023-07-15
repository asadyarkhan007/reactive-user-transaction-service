create table if not exists user_account (
    id bigserial primary key,
    name varchar(255) not null,
    balance decimal,
    CONSTRAINT name_unique unique (name)
);

create table if not exists user_transaction (
        id bigserial primary key,
        amount decimal,
        user_account_id bigint,
        foreign key (user_account_id) references user_account (id) on delete cascade
);

insert into user_account(name,balance) values('asad', 123.4) ON CONFLICT DO NOTHING;
insert into user_account(name,balance) values('hamid', 223.4) ON CONFLICT DO NOTHING;
insert into user_account(name,balance) values('shahid', 453.1) ON CONFLICT DO NOTHING;


