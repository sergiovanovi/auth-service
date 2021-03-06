CREATE TABLE AUTH_LOGIN (
    ID          BIGINT PRIMARY KEY,
    LOGIN       VARCHAR(40) NOT NULL UNIQUE,
    PASSWORD    VARCHAR(75) NOT NULL,
    ENABLED     BOOLEAN DEFAULT TRUE
);

CREATE TABLE AUTH_USER (
    ID          BIGINT PRIMARY KEY,
    NICKNAME    VARCHAR(40) NOT NULL,
    EMAIL       VARCHAR(40),
    PHONE       VARCHAR(20)
);

CREATE TABLE AUTH_SESSION (
    ID                  BIGINT PRIMARY KEY,
    TOKEN               VARCHAR(40) NOT NULL,
    REFRESH_TOKEN       VARCHAR(40) NOT NULL,
    EXPIRED_DATE        DATE,
    LOGIN_ID            BIGINT NOT NULL
);

CREATE SEQUENCE SEQ_AUTH_LOGIN INCREMENT BY 1 MINVALUE 1 NO MAXVALUE CACHE 10 NO CYCLE;
CREATE SEQUENCE SEQ_AUTH_SESSION INCREMENT BY 1 MINVALUE 1 NO MAXVALUE CACHE 10 NO CYCLE;