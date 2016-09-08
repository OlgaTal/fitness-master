CREATE TABLE `fitness`.`positions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `run_id` INT NOT NULL,
  `latitude` FLOAT NULL,
  `longitude` FLOAT NULL,
  `altitude` FLOAT NULL,
  `cur_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `runfk_idx` (`run_id` ASC),
  CONSTRAINT `runfk`
    FOREIGN KEY (`run_id`)
    REFERENCES `fitness`.`runs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
