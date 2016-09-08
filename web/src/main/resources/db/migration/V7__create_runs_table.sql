CREATE TABLE `fitness`.`runs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `device_id` INT NOT NULL,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NULL,
  `active` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `devicefk_idx` (`device_id` ASC),
  INDEX `id_active` (`id` ASC, `active` ASC),
  CONSTRAINT `devicefk`
    FOREIGN KEY (`device_id`)
    REFERENCES `fitness`.`devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);