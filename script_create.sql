-- MySQL Script generated by MySQL Workbench
-- 12/01/16 23:08:49
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema toku
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema toku
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `toku` DEFAULT CHARACTER SET utf8 ;
USE `toku` ;

-- -----------------------------------------------------
-- Table `toku`.`projet_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `toku`.`projet_role` ;

CREATE TABLE IF NOT EXISTS `toku`.`projet_role` (
  `id` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `toku`.`projet_role` (`id` ASC);

CREATE UNIQUE INDEX `nom_UNIQUE` ON `toku`.`projet_role` (`nom` ASC);


-- -----------------------------------------------------
-- Table `toku`.`projet_utilisateur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `toku`.`projet_utilisateur` ;

CREATE TABLE IF NOT EXISTS `toku`.`projet_utilisateur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_role` INT NOT NULL DEFAULT 0,
  `pseudo` VARCHAR(45) NOT NULL,
  `mot_de_passe` VARCHAR(45) NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `pseudo_archive` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `id_role`),
  CONSTRAINT `fk_role`
    FOREIGN KEY (`id_role`)
    REFERENCES `toku`.`projet_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `toku`.`projet_utilisateur` (`id` ASC);

CREATE UNIQUE INDEX `id_compte_UNIQUE` ON `toku`.`projet_utilisateur` (`pseudo` ASC);

CREATE INDEX `fk_role_idx` ON `toku`.`projet_utilisateur` (`id_role` ASC);


-- -----------------------------------------------------
-- Table `toku`.`projet_utilisateur_amis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `toku`.`projet_utilisateur_amis` ;

CREATE TABLE IF NOT EXISTS `toku`.`projet_utilisateur_amis` (
  `id_utilisateur` INT NOT NULL,
  `id_ami` INT NOT NULL,
  `etat` INT NOT NULL,
  PRIMARY KEY (`id_utilisateur`, `id_ami`),
  CONSTRAINT `fk_utilisateur_amis_id_utilisateur`
    FOREIGN KEY (`id_utilisateur`)
    REFERENCES `toku`.`projet_utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_utilisateur_amis_id_ami`
    FOREIGN KEY (`id_ami`)
    REFERENCES `toku`.`projet_utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_utilisateur_has_utilisateur_utilisateur2_idx` ON `toku`.`projet_utilisateur_amis` (`id_ami` ASC);

CREATE INDEX `fk_utilisateur_has_utilisateur_utilisateur1_idx` ON `toku`.`projet_utilisateur_amis` (`id_utilisateur` ASC);


-- -----------------------------------------------------
-- Table `toku`.`projet_discussion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `toku`.`projet_discussion` ;

CREATE TABLE IF NOT EXISTS `toku`.`projet_discussion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_moderateur` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `date_creation` DATETIME NULL,
  PRIMARY KEY (`id`, `id_moderateur`),
  CONSTRAINT `fk_groupe_utilisateur_id_moderateur`
    FOREIGN KEY (`id_moderateur`)
    REFERENCES `toku`.`projet_utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `toku`.`projet_discussion` (`id` ASC);

CREATE UNIQUE INDEX `nom_UNIQUE` ON `toku`.`projet_discussion` (`nom` ASC);

CREATE INDEX `fk_groupe_utilisateur_id_moderateur_idx` ON `toku`.`projet_discussion` (`id_moderateur` ASC);


-- -----------------------------------------------------
-- Table `toku`.`projet_utilisateur_discussion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `toku`.`projet_utilisateur_discussion` ;

CREATE TABLE IF NOT EXISTS `toku`.`projet_utilisateur_discussion` (
  `id_utilisateur` INT NOT NULL,
  `id_discussion` INT NOT NULL,
  `etat` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_utilisateur`, `id_discussion`),
  CONSTRAINT `fk_discussion_utilisateur_id_discussion`
    FOREIGN KEY (`id_discussion`)
    REFERENCES `toku`.`projet_discussion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_discussion_utilisateur_id_utilisateur`
    FOREIGN KEY (`id_utilisateur`)
    REFERENCES `toku`.`projet_utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_groupe_has_utilisateur_utilisateur1_idx` ON `toku`.`projet_utilisateur_discussion` (`id_utilisateur` ASC);

CREATE INDEX `fk_groupe_has_utilisateur_groupe1_idx` ON `toku`.`projet_utilisateur_discussion` (`id_discussion` ASC);


-- -----------------------------------------------------
-- Table `toku`.`projet_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `toku`.`projet_message` ;

CREATE TABLE IF NOT EXISTS `toku`.`projet_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_discussion` INT NOT NULL,
  `id_utilisateur` INT NOT NULL,
  `texte` TEXT NOT NULL,
  `date_creation` DATETIME NOT NULL,
  `type` INT NOT NULL,
  `accuse_reception` TINYINT(1) NOT NULL DEFAULT 0,
  `lu` TINYINT(1) NOT NULL DEFAULT 0,
  `expiration` INT NOT NULL DEFAULT -1,
  `prioritaire` TINYINT(1) NOT NULL DEFAULT 0,
  `chiffre` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`, `id_utilisateur`, `id_discussion`),
  CONSTRAINT `fk_message_discussion`
    FOREIGN KEY (`id_discussion`)
    REFERENCES `toku`.`projet_discussion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_utilisateur`
    FOREIGN KEY (`id_utilisateur`)
    REFERENCES `toku`.`projet_utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = eucjpms;

CREATE UNIQUE INDEX `id_UNIQUE` ON `toku`.`projet_message` (`id` ASC);

CREATE INDEX `fk_message_discussion1_idx` ON `toku`.`projet_message` (`id_discussion` ASC);

CREATE INDEX `fk_message_utilisateur1_idx` ON `toku`.`projet_message` (`id_utilisateur` ASC);

SET SQL_MODE = '';
GRANT USAGE ON *.* TO toku;
 DROP USER toku;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'toku' IDENTIFIED BY 'toku';

GRANT ALL ON `toku`.* TO 'toku';
GRANT SELECT ON TABLE `toku`.* TO 'toku';
GRANT SELECT, INSERT, TRIGGER ON TABLE `toku`.* TO 'toku';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `toku`.* TO 'toku';
GRANT EXECUTE ON ROUTINE `toku`.* TO 'toku';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
