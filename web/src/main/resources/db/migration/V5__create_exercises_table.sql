CREATE TABLE `fitness`.`exercises` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `type` ENUM('SWIM', 'RUN', 'BIKE', 'LIFT') NOT NULL,
  `quantity` INT NOT NULL,
  `calories` INT NOT NULL,
  `duration` INT NOT NULL,
  `created` DATE NOT NULL,
  `modified` DATE NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_idx` (`user_id` ASC),
  CONSTRAINT `fk_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

