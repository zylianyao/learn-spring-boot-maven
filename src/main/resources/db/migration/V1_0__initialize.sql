CREATE TABLE `reader` (
  `id`       BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(25)         NOT NULL,
  `password` VARCHAR(25)         NOT NULL,
  `fullname` VARCHAR(50)         NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `book` (
  `id`              BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `author`          VARCHAR(50)         NOT NULL,
  `description`     VARCHAR(1000)       NOT NULL,
  `isbn`            VARCHAR(10)         NOT NULL,
  `title`           VARCHAR(250)        NOT NULL,
  `reader_username` VARCHAR(25)         NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `reader_username` (`reader_username`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`reader_username`) REFERENCES `reader` (`username`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
SET FOREIGN_KEY_CHECKS = 1;
insert into Reader (username, password, fullname) values ('craig', 'password', 'Craig Walls');