create table `doctors_On_Clinic_Branch` (
`id_clinic_branch` BIGINT NOT NULL,
`id_doctor` BIGINT NOT NULL,
FOREIGN KEY (`id_clinic_branch`) references clinic_branch (`id`),
FOREIGN KEY (`id_doctor`) references user (`id`)
);