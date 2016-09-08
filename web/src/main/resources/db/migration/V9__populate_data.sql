INSERT INTO `fitness`.`roles` (`version`, `role`) VALUES ('0', 'USER');
INSERT INTO `fitness`.`roles` (`version`, `role`) VALUES ('0', 'ADMIN');

<<<<<<< HEAD
INSERT INTO `fitness`.`users` (`version`, `username`, `password`, `enabled`)
VALUES ('0', 'bob@aol.com', '$2a$10$8jBGVl3r1DCCHqLHUabm2uV3IT8tA2p8yfYmR7Lru1QcspIYwrf8S', '1');
INSERT INTO `fitness`.`users` (`version`, `username`, `password`, `enabled`)
VALUES ('0', 'a1', '$2a$10$FbtTXFrLQCNRCbeOBor8c.6acf2RrB6m6IfKHzVbP0kO5GmZJaZM.', '1');

=======
INSERT INTO `fitness`.`users` (`version`, `username`, `password`, `enabled`) VALUES ('0', 'bob@aol.com', '$2a$10$8jBGVl3r1DCCHqLHUabm2uV3IT8tA2p8yfYmR7Lru1QcspIYwrf8S', '1');
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f

INSERT INTO `fitness`.`roles_users` (`role_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `fitness`.`roles_users` (`role_id`, `user_id`) VALUES ('2', '1');

INSERT INTO `fitness`.`profiles` (`version`, `gender`, `age`, `height`, `weight`, `photo`, `user_id`)
VALUES ('0', 'M', '25', '70', '165', 'http://findicons.com/files/icons/1072/face_avatars/300/i05.png', '1');

<<<<<<< HEAD

INSERT INTO `fitness`.`exercises` (`id`, `version`, `type`, `quantity`, `calories`, `duration`, `created`, `modified`, `user_id`)
VALUES ('1', '1', 'SWIM', '10', '300', '20', '2016-09-01', '2016-09-01', '2');

INSERT INTO `fitness`.`devices` (`id`, `serial_number`, `product`, `category`, `user_id`) VALUES ('1', 'abc123', 'fitthing', 'walking', '1');
=======
INSERT INTO `fitness`.`exercises` (`version`, `type`, `quantity`, `calories`, `duration`, `user_id`)
VALUES ('0', 'RUN', '3', '900', '45', '1');
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
