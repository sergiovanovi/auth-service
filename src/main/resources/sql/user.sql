CREATE IF NOT EXISTS TABLE AUTH_LOGIN (
    ID          BIGINT PRIMARY KEY,
    LOGIN       VARCHAR(40) NOT NULL UNIQUE,
    PASSWORD    VARCHAR(75) NOT NULL,
    ENABLED     BOOLEAN DEFAULT TRUE
);

CREATE IF NOT EXISTS TABLE AUTH_USER (
    ID          BIGINT PRIMARY KEY,
    NICKNAME    VARCHAR(40) NOT NULL,
    EMAIL       VARCHAR(40),
    PHONE       VARCHAR(20)
);

CREATE IF NOT EXISTS SEQUENCE SEQ_AUTH_LOGIN INCREMENT BY 1 MINVALUE 1 NO MAXVALUE CACHE 10 NO CYCLE;