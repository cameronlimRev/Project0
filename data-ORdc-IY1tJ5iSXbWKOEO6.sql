DROP TABLE IF EXISTS `myTable`;

CREATE TABLE `myTable` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `userID` mediumint,
  `userName` varchar(255) default NULL,
  `userPin` varchar(4),
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (1,"Portia",3956),
  (2,"Donna",8289),
  (3,"Jordan",1704),
  (4,"Randall",6374),
  (5,"Miriam",5486),
  (6,"Melvin",3775),
  (7,"Baxter",4172),
  (8,"Avye",6810),
  (9,"Keane",7922),
  (10,"Cain",9652);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (11,"Alden",3530),
  (12,"Hadassah",7131),
  (13,"Tate",7122),
  (14,"Dustin",4571),
  (15,"Leonard",9180),
  (16,"Avram",3388),
  (17,"Isabelle",3425),
  (18,"Hashim",4970),
  (19,"Tallulah",1743),
  (20,"Levi",8684);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (21,"Anastasia",1895),
  (22,"Wade",5692),
  (23,"Zorita",4532),
  (24,"Whilemina",2547),
  (25,"Elmo",3532),
  (26,"Charles",3612),
  (27,"Ayanna",6179),
  (28,"Vance",2924),
  (29,"Martina",9456),
  (30,"Palmer",7230);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (31,"Reuben",1378),
  (32,"Maxwell",9655),
  (33,"Dennis",9813),
  (34,"Ila",3358),
  (35,"Wayne",3377),
  (36,"Denton",7543),
  (37,"Maxwell",2231),
  (38,"Nissim",5664),
  (39,"Ramona",7009),
  (40,"Gary",4859);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (41,"Brielle",4715),
  (42,"Kimberley",6668),
  (43,"Cailin",4190),
  (44,"Rudyard",7851),
  (45,"Laura",3254),
  (46,"Eliana",4678),
  (47,"Kaitlin",1117),
  (48,"Georgia",2791),
  (49,"Arthur",6226),
  (50,"Arsenio",3320);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (51,"Tate",9838),
  (52,"Oren",3334),
  (53,"Wynter",7197),
  (54,"Helen",7347),
  (55,"Fritz",3873),
  (56,"Alvin",8568),
  (57,"Fatima",7966),
  (58,"Wilma",6437),
  (59,"Faith",9604),
  (60,"Barry",6180);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (61,"Nathaniel",1612),
  (62,"Stephen",4103),
  (63,"Claudia",2602),
  (64,"Colby",4642),
  (65,"Allegra",7467),
  (66,"Zena",3326),
  (67,"Gareth",9169),
  (68,"Juliet",2635),
  (69,"Malik",5800),
  (70,"Hoyt",7772);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (71,"Ishmael",8563),
  (72,"Hanae",1956),
  (73,"Asher",2210),
  (74,"Dieter",2950),
  (75,"India",2744),
  (76,"Adrienne",1517),
  (77,"Wynne",9858),
  (78,"Francis",8398),
  (79,"Tatiana",6187),
  (80,"Cleo",5030);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (81,"Meghan",6527),
  (82,"Deacon",9017),
  (83,"Castor",2466),
  (84,"Fredericka",8060),
  (85,"Isaac",2674),
  (86,"Kelly",5353),
  (87,"Nomlanga",5892),
  (88,"Graham",7134),
  (89,"Kennedy",9080),
  (90,"Felix",3205);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (91,"Ifeoma",3126),
  (92,"Keaton",9081),
  (93,"Quinn",6116),
  (94,"Amber",4210),
  (95,"Vivian",8244),
  (96,"Hedy",9355),
  (97,"Samson",6085),
  (98,"Imelda",3301),
  (99,"Chelsea",7028),
  (100,"Branden",4994);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (101,"Nola",2972),
  (102,"Keith",4642),
  (103,"Tatum",3533),
  (104,"Georgia",1248),
  (105,"Tana",6770),
  (106,"Macey",9696),
  (107,"Ahmed",9778),
  (108,"Lillith",9414),
  (109,"Jonas",8159),
  (110,"Marny",7767);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (111,"Zephania",5485),
  (112,"Travis",4092),
  (113,"Inez",3916),
  (114,"Shaine",6343),
  (115,"Helen",8204),
  (116,"Ann",2645),
  (117,"Irene",4743),
  (118,"Kevyn",8415),
  (119,"Mallory",4480),
  (120,"Lavinia",2116);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (121,"Ivory",8991),
  (122,"Jolene",8061),
  (123,"Zephania",6996),
  (124,"Hammett",2615),
  (125,"Ursa",5767),
  (126,"Isaac",6453),
  (127,"Carter",2216),
  (128,"May",4697),
  (129,"Tara",5648),
  (130,"Jaden",6433);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (131,"Hilda",8930),
  (132,"Daniel",1230),
  (133,"Amena",2197),
  (134,"Ryder",1715),
  (135,"Ruby",6922),
  (136,"Palmer",5586),
  (137,"Jordan",6049),
  (138,"Nolan",2535),
  (139,"Gillian",8458),
  (140,"Xaviera",1768);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (141,"Tanner",1125),
  (142,"Abra",5963),
  (143,"Naida",5506),
  (144,"Maggy",9073),
  (145,"Alvin",6618),
  (146,"Basia",7097),
  (147,"Gemma",7335),
  (148,"Cain",3943),
  (149,"Gage",2101),
  (150,"Cain",8507);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (151,"Tanek",8393),
  (152,"Marah",4581),
  (153,"Malik",7766),
  (154,"Quinlan",2662),
  (155,"Kim",8378),
  (156,"Asher",9158),
  (157,"Lisandra",6809),
  (158,"Ivory",8666),
  (159,"Aaron",8680),
  (160,"Rae",2313);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (161,"Wang",9805),
  (162,"Dieter",4140),
  (163,"Rana",4162),
  (164,"Ahmed",8326),
  (165,"Risa",3434),
  (166,"Sonya",2569),
  (167,"Yvonne",8039),
  (168,"Felicia",9493),
  (169,"Shafira",5375),
  (170,"Dane",8248);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (171,"Rajah",2834),
  (172,"Xenos",4469),
  (173,"Shaeleigh",2257),
  (174,"Olga",2152),
  (175,"Lucian",8557),
  (176,"Madeline",6165),
  (177,"Lenore",2400),
  (178,"Tyler",6815),
  (179,"Tad",3327),
  (180,"Fiona",4954);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (181,"Rhea",9748),
  (182,"Sydney",9838),
  (183,"James",3959),
  (184,"Jasmine",8876),
  (185,"Kathleen",9727),
  (186,"Henry",1877),
  (187,"Elijah",7243),
  (188,"Jerome",1795),
  (189,"Celeste",3555),
  (190,"Ulric",6127);
INSERT INTO `myTable` (`userID`,`userName`,`userPin`)
VALUES
  (191,"Seth",6675),
  (192,"Hedy",3689),
  (193,"Jakeem",4268),
  (194,"Zephania",9899),
  (195,"Wyatt",7637),
  (196,"Lev",4901),
  (197,"Cyrus",6967),
  (198,"Salvador",1915),
  (199,"Cruz",8286),
  (200,"Chloe",8972);
