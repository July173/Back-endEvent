-- Usar la base de datos
USE control_event;

-- Insertar 4 departamentos
INSERT INTO department (status, code, description, name, latitude, longitude) VALUES
(1, 'DEP-001', 'Departamento Antioquia', 'Antioquia', 6.244203, -75.581215),
(1, 'DEP-002', 'Departamento Valle del Cauca', 'Valle del Cauca', 3.451647, -76.532822),
(1, 'DEP-003', 'Departamento Atlántico', 'Atlántico', 10.968540, -74.781320),
(1, 'DEP-004', 'Departamento Boyacá', 'Boyacá', 5.535000, -73.367000);

-- Insertar 5 municipios por cada departamento (id_department referencia a departamentos.id)
INSERT INTO municipio (id_department, status, code, description, name, latitude, longitude) VALUES
-- Antioquia (id_department = 1)
(1, 1, 'MUN-ANT-001', 'Municipio de Medellín', 'Medellín', 6.244203, -75.581215),
(1, 1, 'MUN-ANT-002', 'Municipio de Envigado', 'Envigado', 6.171389, -75.588889),
(1, 1, 'MUN-ANT-003', 'Municipio de Bello', 'Bello', 6.337500, -75.558056),
(1, 1, 'MUN-ANT-004', 'Municipio de Rionegro', 'Rionegro', 6.148611, -75.376389),
(1, 1, 'MUN-ANT-005', 'Municipio de Apartadó', 'Apartadó', 7.884444, -76.668056),

-- Valle del Cauca (id_department = 2)
(2, 1, 'MUN-VDC-001', 'Municipio de Cali', 'Cali', 3.451647, -76.532822),
(2, 1, 'MUN-VDC-002', 'Municipio de Buenaventura', 'Buenaventura', 3.883333, -77.033333),
(2, 1, 'MUN-VDC-003', 'Municipio de Palmira', 'Palmira', 3.535000, -76.303333),
(2, 1, 'MUN-VDC-004', 'Municipio de Tuluá', 'Tuluá', 4.085000, -76.196111),
(2, 1, 'MUN-VDC-005', 'Municipio de Guadalajara de Buga', 'Buga', 3.900278, -76.300833),

-- Atlántico (id_department = 3)
(3, 1, 'MUN-ATL-001', 'Municipio de Barranquilla', 'Barranquilla', 10.968540, -74.781320),
(3, 1, 'MUN-ATL-002', 'Municipio de Soledad', 'Soledad', 10.913333, -74.764444),
(3, 1, 'MUN-ATL-003', 'Municipio de Malambo', 'Malambo', 10.795000, -74.827500),
(3, 1, 'MUN-ATL-004', 'Municipio de Sabanalarga', 'Sabanalarga', 10.526111, -74.807500),
(3, 1, 'MUN-ATL-005', 'Municipio de Baranoa', 'Baranoa', 10.865000, -74.861000),

-- Boyacá (id_department = 4)
(4, 1, 'MUN-BOY-001', 'Municipio de Tunja', 'Tunja', 5.535000, -73.367000),
(4, 1, 'MUN-BOY-002', 'Municipio de Duitama', 'Duitama', 5.829444, -73.028333),
(4, 1, 'MUN-BOY-003', 'Municipio de Sogamoso', 'Sogamoso', 5.709167, -72.933333),
(4, 1, 'MUN-BOY-004', 'Municipio de Chiquinquirá', 'Chiquinquirá', 5.629444, -73.814444),
(4, 1, 'MUN-BOY-005', 'Municipio de Paipa', 'Paipa', 5.720278, -72.934444);


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