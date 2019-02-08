create table `reservation_request` (
`id` BIGINT AUTO_INCREMENT NOT NULL,
`doctor_id` BIGINT,
`patient_id` BIGINT,
`clinic_id` BIGINT,
`clinic_branch_id` BIGINT,
`status` varchar(255),
`reservation_date_time` DATETIME NOT NULL,
PRIMARY KEY(`id`),
FOREIGN KEY(doctor_id) references user (id) on delete no action on update cascade,
FOREIGN KEY(patient_id) references user (id) on delete no action on update cascade,
FOREIGN KEY(clinic_id) references clinic (id) on delete cascade on update cascade,
FOREIGN KEY(clinic_branch_id) references clinic_branch (id) on delete cascade on update cascade
);