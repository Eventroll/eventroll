CREATE SEQUENCE seq_user START 1 INCREMENT 50;


CREATE TABLE t_user (
  id            BIGINT       NOT NULL CONSTRAINT pk_user PRIMARY KEY,
  first_name    VARCHAR(100) NOT NULL,
  last_name     VARCHAR(100) NOT NULL,
  user_name     VARCHAR(100) NOT NULL,
  email_address VARCHAR(100) NOT NULL,
  password      VARCHAR(20)  NOT NULL,
  enabled       BOOLEAN      NOT NULL,
  created       TIMESTAMP    NOT NULL,
  updated       TIMESTAMP    NOT NULL,
  deleted       TIMESTAMP
);

ALTER TABLE t_event
  ADD COLUMN user_id BIGINT;

-- TODO : Uncomment when security context will be ready.
-- ALTER TABLE t_event
--   ALTER COLUMN user_id SET NOT NULL;

ALTER TABLE t_event
  ADD CONSTRAINT fk_user_keyword_user FOREIGN KEY (user_id) REFERENCES t_user;