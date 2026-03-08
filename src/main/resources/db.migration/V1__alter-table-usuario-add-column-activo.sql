alter table usuarios add column activo tinyint;

update usuarios set activo = 1;
