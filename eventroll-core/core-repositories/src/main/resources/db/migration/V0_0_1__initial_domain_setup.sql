CREATE SEQUENCE seq_event START 1 INCREMENT 50;
CREATE SEQUENCE seq_event_image START 1 INCREMENT 50;
CREATE SEQUENCE seq_event_video START 1 INCREMENT 50;
CREATE SEQUENCE seq_event_key START 1 INCREMENT 50;
CREATE SEQUENCE seq_event_location START 1 INCREMENT 50;


CREATE TABLE t_event (
  id                BIGINT        NOT NULL CONSTRAINT pk_event PRIMARY KEY,
  event_location_id BIGINT        NOT NULL,
  event_name        VARCHAR(100)  NOT NULL,
  dsc               VARCHAR(2000) NOT NULL,
  category_type     VARCHAR(50)   NOT NULL,
  start_date        TIMESTAMP     NOT NULL,
  end_date          TIMESTAMP     NOT NULL,
  created           TIMESTAMP     NOT NULL,
  updated           TIMESTAMP     NOT NULL,
  deleted           TIMESTAMP
);


CREATE TABLE t_event_keyword (
  id       BIGINT       NOT NULL CONSTRAINT pk_event_keyword PRIMARY KEY,
  event_id BIGINT       NOT NULL CONSTRAINT fk_event_keyword_event REFERENCES t_event,
  name     VARCHAR(200) NOT NULL,
  created  TIMESTAMP    NOT NULL,
  updated  TIMESTAMP    NOT NULL,
  deleted  TIMESTAMP
);

CREATE TABLE t_event_image (
  id       BIGINT        NOT NULL CONSTRAINT pk_event_image PRIMARY KEY,
  event_id BIGINT        NOT NULL CONSTRAINT fk_event_image_event REFERENCES t_event,
  name     VARCHAR(200)  NOT NULL,
  dsc      VARCHAR(2000) NOT NULL,
  data     BYTEA         NOT NULL,
  created  TIMESTAMP     NOT NULL,
  updated  TIMESTAMP     NOT NULL,
  deleted  TIMESTAMP
);

CREATE TABLE t_event_video (
  id       BIGINT        NOT NULL CONSTRAINT pk_event_video PRIMARY KEY,
  event_id BIGINT        NOT NULL CONSTRAINT fk_event_video_event REFERENCES t_event,
  name     VARCHAR(200)  NOT NULL,
  dsc      VARCHAR(2000) NOT NULL,
  data     BYTEA         NOT NULL,
  created  TIMESTAMP     NOT NULL,
  updated  TIMESTAMP     NOT NULL,
  deleted  TIMESTAMP
);

CREATE TABLE t_event_location (
  id   BIGINT           NOT NULL CONSTRAINT pk_event_location PRIMARY KEY,
  lat  DOUBLE PRECISION NOT NULL,
  lon  DOUBLE PRECISION NOT NULL,
  addr VARCHAR(200)     NOT NULL
);