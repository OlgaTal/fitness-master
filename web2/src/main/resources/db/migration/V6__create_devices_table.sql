CREATE TABLE `fitness`.`devices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `serial_number` VARCHAR(45) NOT NULL,
  `product` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `userfk_idx` (`user_id` ASC),
  INDEX `serialn` (`serial_number` ASC),
  CONSTRAINT `userfk`
    FOREIGN KEY (`user_id`)
    REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
