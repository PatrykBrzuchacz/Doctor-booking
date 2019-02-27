create table doctor (
`id` BIGINT AUTO_INCREMENT,
`user_id` BIGINT NOT NULL,
PRIMARY KEY(`id`),
FOREIGN KEY(`user_id`) references `user` (`id`) on delete cascade on update cascade
);

create table patient (
`id` BIGINT AUTO_INCREMENT,
`user_id` BIGINT NOT NULL,
PRIMARY KEY(`id`),
FOREIGN KEY(`user_id`) references `user` (`id`) on delete cascade on update cascade
);

create table doctor_branch (
`doctor_id` BIGINT,
`branch_id` BIGINT,
Primary Key(`doctor_id`, `branch_id`),
FOREIGN KEY (doctor_id) references doctor(id),
FOREIGN KEY (branch_id) references clinic_branch(id)
);

alter table clinic
add CONSTRAINT `fk_clinic_owner`
FOREIGN KEY(`owner_id`) REFERENCES `doctor` (`id`)
 ON DELETE cascade
 ON UPDATE CASCADE;