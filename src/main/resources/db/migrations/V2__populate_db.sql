INSERT INTO client (NAME)
VALUES ('Ivan Petrenko'),
       ('Olena Shevchenko'),
       ('Andriy Kovalenko'),
       ('Svitlana Moroz'),
       ('Oksana Boyko'),
       ('Mykola Kravchenko'),
       ('Nadiya Litvin'),
       ('Petro Marchenko'),
       ('Yuriy Shapoval'),
       ('Kateryna Bondar');
INSERT INTO planet (ID, NAME)
VALUES ('EARTH', 'Earth'),
       ('MARS', 'Mars'),
       ('VENUS', 'Venus'),
       ('JUPITER', 'Jupiter'),
       ('SATURN', 'Saturn');
INSERT INTO ticket (CLIENT_ID, FROM_PLANET_ID, TO_PLANET_ID)
VALUES (1, 'EARTH', 'MARS'),
       (2, 'MARS', 'VENUS'),
       (3, 'VENUS', 'EARTH'),
       (4, 'EARTH', 'JUPITER'),
       (5, 'SATURN', 'EARTH'),
       (6, 'JUPITER', 'SATURN'),
       (7, 'MARS', 'EARTH'),
       (8, 'VENUS', 'SATURN'),
       (9, 'JUPITER', 'MARS'),
       (10, 'SATURN', 'VENUS');