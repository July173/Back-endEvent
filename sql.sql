-- Usar la base de datos
USE control_event;

-- 1) Department
INSERT INTO department (id, name, description, code, status)
VALUES
  (1, 'Antioquia', 'Departamento Antioquia', 'DEP-001', 1);

-- 2) Municipio (FK -> department.id)
INSERT INTO municipio (id, name, description, code, status, id_department)
VALUES
  (1, 'Medellín', 'Municipio de Medellín', 'MUN-001', 1, 1);

-- 3) Gender Music
INSERT INTO gender_music (id, name, description, status)
VALUES
  (1, 'Rock', 'Género Rock', 1),
  (2, 'Pop', 'Género Pop', 1);

-- 4) Artist (FK -> gender_music.id)
-- Columnas según [model/artist.java](cci:7://file:///c:/Nueva%20carpeta/gestionEventsBackend/src/main/java/com/back/control_event/model/artist.java:0:0-0:0): id, name, lastName, origenCity, code, status, id_genderMusic
INSERT INTO artist (id, name, last_name, origen_city, code, status, id_gender_music)
VALUES
  (1, 'Artista Uno', 'Pérez', 'Bogotá', 'ART-001', 1, 1),
  (2, 'Artista Dos', 'Gómez', 'Medellín', 'ART-002', 1, 2);

-- 5) Roles (dos: admin y client)
-- Columnas según [model/role.java](cci:7://file:///c:/Nueva%20carpeta/gestionEventsBackend/src/main/java/com/back/control_event/model/role.java:0:0-0:0): id_role, name, description
INSERT INTO role (id_role, name, description)
VALUES
  (1, 'ADMIN', 'Administrator role'),
  (2, 'CLIENT', 'Client role');

-- 6) LocatedEvent
-- Columnas según [model/locatedEvent.java](cci:7://file:///c:/Nueva%20carpeta/gestionEventsBackend/src/main/java/com/back/control_event/model/locatedEvent.java:0:0-0:0): id, name, description, code, status
INSERT INTO located_event (id, name, description, code, status)
VALUES
  (1, 'Gradería A', 'Zona gradería A', 'LOC-001', 1),
  (2, 'Palco VIP', 'Zona palco VIP', 'LOC-002', 1);