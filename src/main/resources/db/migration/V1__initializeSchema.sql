CREATE TABLE homelessness.homeless (
                                       location_id VARCHAR(15) NOT NULL,
                                       year VARCHAR(45) NOT NULL,
                                       quarter VARCHAR(2) NOT NULL,
                                       location_name VARCHAR(80) NULL,
                                       total_init INT NULL,
                                       total_oprd INT NULL,
                                       threatened INT NULL,
                                       homeless_relief_duty INT NULL,
                                       PRIMARY KEY (location_id, year, quarter));


INSERT INTO homelessness.homeless (location_id, year, quarter, location_name, total_init, total_oprd, threatened, homeless_relief_duty) VALUES ('E92000001', '2022', 'Q3', 'ENGLAND', '76880', '74230', '37260', '36970');
INSERT INTO homelessness.homeless (location_id, year, quarter, location_name, total_init, total_oprd, threatened, homeless_relief_duty) VALUES ('E12000007', '2022', 'Q3', 'London', '13610', '13050', '6140', '6910');
