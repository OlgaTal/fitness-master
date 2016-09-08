CREATE TABLE `fitness`.`exercises` (
  `id` INT NOT NULL AUTO_INCREMENT,
<<<<<<< HEAD
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
=======
  `version` INT NOT NULL DEFAULT 0,
  `type` ENUM('RUN', 'SWIM', 'BIKE', 'LIFT') NULL,
  `quantity` INT NULL,
  `calories` INT NULL,
  `duration` INT NULL,
  `user_id` INT NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_v5`
  FOREIGN KEY (`user_id`)
  REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
