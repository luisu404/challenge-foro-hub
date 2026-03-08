alter table cursos add column activo tinyint;

update cursos set activo = 1;
