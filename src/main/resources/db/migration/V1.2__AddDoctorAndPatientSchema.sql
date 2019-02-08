create table doctor (
`id` BIGINT AUTO_INCREMENT,
`user_id` BIGINT NOT NULL,
`clinic_branch_id` BIGINT,
PRIMARY KEY(`id`),
FOREIGN KEY(`clinic_branch_id`) references `clinic_branch` (`id`) on delete no action on update cascade,
FOREIGN KEY(`user_id`) references `user` (`id`) on delete cascade on update cascade
);

create table patient (
`id` BIGINT AUTO_INCREMENT,
`user_id` BIGINT NOT NULL,
PRIMARY KEY(`id`),
FOREIGN KEY(`user_id`) references `user` (`id`) on delete cascade on update cascade
);

alter table clinic
add CONSTRAINT `fk_clinic_owner`
FOREIGN KEY(`owner_id`) REFERENCES `doctor` (`id`)
 ON DELETE cascade
 ON UPDATE CASCADE;