CREATE TABLE `clinic` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`city` varchar(255) NOT NULL,
`street` varchar(255),
`house_number` BIGINT NOT NULL,
`owner_id` BIGINT NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_clinic_owner`
FOREIGN KEY(`owner_id`) REFERENCES `user` (`id`)
 ON DELETE cascade
 ON UPDATE CASCADE);


CREATE TABLE `clinic_branch` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`type` varchar(255),
`clinic_id` BIGINT NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY(clinic_id) references clinic (id) on delete cascade on update cascade
);

