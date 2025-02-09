CREATE TABLE IF NOT EXISTS `movies`
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    title               VARCHAR(250)                                                     NOT NULL,
    shared_by           VARCHAR(250)                                                     NOT NULL,
    content             VARCHAR(250)                                                     NOT NULL,
    created_at          DATETIME   DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
    updated_at          DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    deleted_at          DATETIME   DEFAULT CURRENT_TIMESTAMP                             NOT NULL
);