create sequence seq_event start 1 increment 50;
create sequence seq_event_image start 1 increment 50;
create sequence seq_event_video start 1 increment 50;
create sequence seq_event_key start 1 increment 50;
create sequence seq_event_location start 1 increment 50;


create table t_event (
  id                bigint        not null constraint pk_event primary key,
  event_location_id bigint        not null,
  event_name        varchar(100)  not null,
  dsc               varchar(2000) not null,
  category_type     varchar(50)   not null,
  start_date        timestamp     not null,
  end_date          timestamp     not null,
  created           timestamp     not null,
  updated           timestamp     not null,
  deleted           timestamp
);


create table t_event_keyword (
  id       bigint       not null constraint pk_event_keyword primary key,
  event_id bigint       not null constraint fk_event_keyword_event references t_event,
  name     varchar(200) not null,
  created  timestamp    not null,
  updated  timestamp    not null,
  deleted  timestamp
);

create table t_event_image (
  id       bigint        not null constraint pk_event_image primary key,
  event_id bigint        not null constraint fk_event_image_event references t_event,
  name     varchar(200)  not null,
  dsc      varchar(2000) not null,
  data     bytea         not null,
  created  timestamp     not null,
  updated  timestamp     not null,
  deleted  timestamp
);

create table t_event_video (
  id       bigint        not null constraint pk_event_video primary key,
  event_id bigint        not null constraint fk_event_video_event references t_event,
  name     varchar(200)  not null,
  dsc      varchar(2000) not null,
  data     bytea         not null,
  created  timestamp     not null,
  updated  timestamp     not null,
  deleted  timestamp
);

create table t_event_location (
  id   bigint           not null constraint pk_event_location primary key,
  lat  double precision not null,
  lon  double precision not null,
  addr varchar(200)     not null
);