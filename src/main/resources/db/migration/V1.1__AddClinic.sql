CREATE TABLE `clinic` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`city` varchar(255) NOT NULL,
`street` varchar(255),
`house_number` INT(4) NOT NULL DEFAULT '1',
`owner_id` BIGINT NOT NULL,
PRIMARY KEY (`id`));



CREATE TABLE `clinic_branch` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`type` varchar(255),
`clinic_id` BIGINT NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY(clinic_id) references clinic (id) on delete cascade on update cascade
);

