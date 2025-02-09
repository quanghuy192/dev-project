CREATE TABLE IF NOT EXISTS `users`
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    username            VARCHAR(250)                                                     NOT NULL,
    password            VARCHAR(250)                                                     NOT NULL,
    created_at          DATETIME   DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
    updated_at          DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    deleted_at          DATETIME   DEFAULT CURRENT_TIMESTAMP                             NOT NULL
);
