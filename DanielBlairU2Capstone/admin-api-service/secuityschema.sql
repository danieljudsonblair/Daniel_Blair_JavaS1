insert into users (username, password, enabled) values ('adminUser', '$2a$10$iYzAW2h8950Uf/dUCDn5jOmaDrTr22lAEN.nBadHRlAwwJWVtgbdm', 1);
insert into users (username, password, enabled) values ('managerUser', '$2a$10$Lmcsc83Ntt9z1vxTA1cmIet42MmaNf1J3gRHRXG9t..CKfkW7hpey', 1);
insert into users (username, password, enabled) values ('teamLeadUser', '$2a$10$nLyNOddjEbnjpHS8KTyopuHXYB9bumbmLZESK8qMA8QEZBqniHGR.', 1);
insert into users (username, password, enabled) values ('employeeUser', '$2a$10$Rugo4eGD63ksttJyq5/nhur5M6sZY8ehjJ7S2cL8BkwCv6bhQaaPy', 1);


insert into authorities (username, authority) values ('adminUser','ROLE_ADMIN');
insert into authorities (username, authority) values ('adminUser','ROLE_MANAGER');
insert into authorities (username, authority) values ('adminUser','ROLE_TEAMLEAD');
insert into authorities (username, authority) values ('adminUser','ROLE_EMPLOYEE');
insert into authorities (username, authority) values ('managerUser','ROLE_MANAGER');
insert into authorities (username, authority) values ('managerUser','ROLE_TEAMLEAD');
insert into authorities (username, authority) values ('managerUser','ROLE_EMPLOYEE');
insert into authorities (username, authority) values ('teamLeadUser','ROLE_TEAMLEAD');
insert into authorities (username, authority) values ('teamLeadUser','ROLE_EMPLOYEE');
insert into authorities (username, authority) values ('employeeUser','ROLE_EMPLOYEE');


 