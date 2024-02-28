CREATE SCHEMA UitlaatService;

USE UitlaatService;

CREATE TABLE `Klant` (
  `klantnr` int NOT NULL,
  `voorletters` varchar(10) NOT NULL,
  `voorvoegsels` varchar(10) DEFAULT NULL,
  `achternaam` varchar(45) NOT NULL,
  `telefoon` varchar(10) NOT NULL,
  PRIMARY KEY (`klantnr`)
);


CREATE TABLE `Hond` (
  `chipnr` varchar(10) NOT NULL,
  `hondnaam` varchar(45) NOT NULL,
  `ras` varchar(45) NOT NULL,
  `klantnr` int NOT NULL,
  PRIMARY KEY (`chipnr`),
  KEY `fk_Hond_Klant1_idx` (`klantnr`),
  CONSTRAINT `fk_Hond_Klant1` FOREIGN KEY (`klantnr`) REFERENCES `Klant` (`klantnr`)
) ;

CREATE TABLE `Medewerker` (
  `medewerkercode` varchar(3) NOT NULL,
  `medewerkernaam` varchar(45) NOT NULL,
  PRIMARY KEY (`medewerkercode`)
);


CREATE TABLE `Wandeling` (
  `wandelingId` INT NOT NULL AUTO_INCREMENT,
  `chipnr` VARCHAR(10) NOT NULL,
  `datum` DATE NOT NULL,
  `duur` DOUBLE NOT NULL,
  `medewerkercode` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`wandelingId`),
  CONSTRAINT `fk_Uitlaatbeurt_Hond`
    FOREIGN KEY (`chipnr`)
    REFERENCES `Hond` (`chipnr`),
  CONSTRAINT `fk_Wandeling_Medewerker1`
    FOREIGN KEY (`medewerkercode`)
    REFERENCES `Medewerker` (`medewerkercode`)
);

-- Gebruiker definiëren en toegang verlenen
CREATE USER 'userUitlaatService'@'localhost' IDENTIFIED BY 'pwUitlaatService';
GRANT ALL PRIVILEGES ON UitlaatService . * TO 'userUitlaatService'@'localhost';