DROP TABLE IF EXISTS `meeseeks` CASCADE; 
CREATE TABLE `meeseeks` (
    id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(255),
    purpose VARCHAR(255),
    dateActivated VARCHAR(255),
    PRIMARY KEY (id)
);