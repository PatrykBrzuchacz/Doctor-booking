create table examination (
`id` BIGINT AUTO_INCREMENT,
`examination_name` varchar(255) not null,
PRIMARY KEY(`id`)
);

create table doctor_examination (
`doctor_id` BIGINT,
`examination_id` BIGINT,
Primary Key(`doctor_id`, `examination_id`),
FOREIGN KEY (doctor_id) references doctor(id),
FOREIGN KEY (examination_id) references examination(id)
);