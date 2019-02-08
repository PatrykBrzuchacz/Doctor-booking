INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ROLE_ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'Patient role', 'ROLE_PATIENT');
INSERT INTO role (id, description, name) VALUES (3, 'Doctor role', 'ROLE_DOCTOR');

-- pass same as login

INSERT INTO user(username, password, id_role) VALUES
 ('admin', '$2a$11$70Xpp7/vQsnlZNZMQSx/6OHusrhf8dY8B5YoR6N7TfwNxrMJp4OcK', 1);

INSERT INTO user(username, password,id_role) VALUES
('patient', '$2a$11$TNfx5rjp9ks.C96Nsht0HO50UZtR8YVl3UEEac6Xcu494z8kKUXXa', 2);

INSERT INTO user(username, password,id_role) VALUES
 ('doctor', '$2a$11$qZd1vIxiyzJ.1q3XY4in5.TW5jteWh0Y1wKq8HfqL1Ichcjuvqxo6', 3);

INSERT INTO patient(id,user_id) values (1,2);
INSERT INTO doctor(id,user_id) values (1,3);