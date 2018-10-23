USE LO54;

INSERT INTO location VALUES
(1, "Paris", "48.864716", "2.349014"),
(2, "Milan", "45.464211", "9.191383"),
(3, "Berlin", "52.520008", "13.404954"),
(4, "Seattle", "47.608013", "-122.335167");

INSERT INTO course VALUES
(1, "Anthropologie des canibales"),
(2, "C++ niveau 1"),
(3, "C++ niveau 2"),
(4, "C++ niveau 3"),
(5, "Sociologie animale"),
(6, "Etude comparative des souris et éléphants"),
(7, "Management des chimpanzé"),
(8, "Etude sur l'impact du battement d'aile de papillon"),
(9, "Les dictateurs sont-ils de moins en moins cruels ?"),
(10, "Peut-on vraiment dire que 1+1=2 ?"),
(11, "Out of the box thinking"),
(12, "Le minimalisme est-il une tarre dans notre société technologique ?");

INSERT INTO course_session VALUES
(1, "2018-10-28", "2018-10-28", 5, 1, 1),
(2, "2018-10-30", "2018-11-01", 5, 1, 2),
(3, "2018-11-03", "2018-11-04", 5, 1, 2),
(4, "2018-11-01", "2018-11-01", 30, 2, 4),
(5, "2018-11-02", "2018-11-02", 30, 3, 4),
(6, "2018-11-03", "2018-11-03", 30, 4, 4),
(7, "2018-11-03", "2018-11-05", 100, 5, 3),
(8, "2018-11-04", "2018-11-05", 100, 6, 2),
(9, "2018-11-06", "2018-11-10", 25, 7, 1),
(10, "2018-11-08", "2018-11-09", 5, 8, 2),
(11, "2018-11-10", "2018-11-12", 15, 9, 3),
(12, "2018-11-10", "2018-11-20", 10, 10, 1),
(13, "2018-11-10", "2018-11-12", 30, 2, 1),
(14, "2018-11-15", "2018-11-16", 10, 11, 4),
(15, "2018-11-17", "2018-11-17", 20, 12, 2);

INSERT INTO client VALUES
(1, "Michel", "Rodrigez", "456 avenuda del paniero", "666666666", "michel.rodrigez@gmail.com", 1),
(2, "Michel", "Rodrigez", "456 avenuda del paniero", "666666666", "michel.rodrigez@gmail.com", 7),
(3, "Michel", "Rodrigez", "456 avenuda del paniero", "666666666", "michel.rodrigez@gmail.com", 10),
(4, "Jean-Ferdinant", "De la mulatière", "456 rue de Paris", "0123456789", "jean.ferdinant@gmail.com", 8),
(5, "Jean-Ferdinant", "De la mulatière", "456 rue de Paris", "0123456789", "jean.ferdinant@gmail.com", 15),
(6, "Brian", "Tyler", "456 Suicid street", "4567237821", "brian.tyler@gmail.com", 14),
(7, "Brian", "Tyler", "456 Suicid street", "4567237821", "brian.tyler@gmail.com", 4),
(8, "Brian", "Tyler", "456 Suicid street", "4567237821", "brian.tyler@gmail.com", 5),
(9, "Brian", "Tyler", "456 Suicid street", "4567237821", "brian.tyler@gmail.com", 6),
(10, "Marie", "Etoinette", "456 avenue de la révolution", "4567822213", "marie.etoinette@gmail.com", 9),
(11, "Marie", "Etoinette", "456 avenue de la révolution", "4567822213", "marie.etoinette@gmail.com", 12),
(12, "Marie", "Etoinette", "456 avenue de la révolution", "4567822213", "marie.etoinette@gmail.com", 13);
