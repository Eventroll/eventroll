create sequence seq_user start 1 increment 50;


create table t_user (
  id            bigint       not null constraint pk_user primary key,
  first_name    varchar(100) not null,
  last_name     varchar(100) not null,
  user_name     varchar(100) not null,
  email_address varchar(100) not null,
  password      varchar(20)  not null,
  enabled       boolean      not null,
  created       timestamp    not null,
  updated       timestamp    not null,
  deleted       timestamp
);

alter table t_event
  add column user_id bigint;

-- todo : uncomment when security context will be ready.
-- alter table t_event
--   alter column user_id set not null;

alter table t_event
  add constraint fk_user_keyword_user foreign key (user_id) references t_user;