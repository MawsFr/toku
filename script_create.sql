-- MySQL Script generated by MySQL Workbench
-- 10/10/16 20:03:09
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema toku
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role` ;

CREATE TABLE IF NOT EXISTS `role` (
  `id` INT NOT NULL,
  `id_parent` INT NULL DEFAULT 0,
  `nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `nom_UNIQUE` (`nom` ASC),
  INDEX `fk_role_parent_idx` (`id_parent` ASC),
  CONSTRAINT `fk_role_parent`
    FOREIGN KEY (`id_parent`)
    REFERENCES `role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utilisateur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `utilisateur` ;

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_role` INT NOT NULL DEFAULT 0,
  `pseudo` VARCHAR(45) NOT NULL,
  `mot_de_passe` VARCHAR(45) NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `id_role`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `id_compte_UNIQUE` (`pseudo` ASC),
  INDEX `fk_role_idx` (`id_role` ASC),
  CONSTRAINT `fk_role`
    FOREIGN KEY (`id_role`)
    REFERENCES `role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `permission` ;

CREATE TABLE IF NOT EXISTS `permission` (
  `id` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `nom_UNIQUE` (`nom` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `role_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role_permission` ;

CREATE TABLE IF NOT EXISTS `role_permission` (
  `role_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`),
  INDEX `fk_role_has_permission_permission1_idx` (`permission_id` ASC),
  INDEX `fk_role_has_permission_role1_idx` (`role_id` ASC),
  CONSTRAINT `fk_role_permission_id_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_id_permission`
    FOREIGN KEY (`permission_id`)
    REFERENCES `permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utilisateur_amis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `utilisateur_amis` ;

CREATE TABLE IF NOT EXISTS `utilisateur_amis` (
  `id_utilisateur` INT NOT NULL,
  `id_ami` INT NOT NULL,
  PRIMARY KEY (`id_utilisateur`, `id_ami`),
  INDEX `fk_utilisateur_has_utilisateur_utilisateur2_idx` (`id_ami` ASC),
  INDEX `fk_utilisateur_has_utilisateur_utilisateur1_idx` (`id_utilisateur` ASC),
  UNIQUE INDEX `id_ami_UNIQUE` (`id_ami` ASC),
  UNIQUE INDEX `id_utilisateur_UNIQUE` (`id_utilisateur` ASC),
  CONSTRAINT `fk_utilisateur_amis_id_utilisateur`
    FOREIGN KEY (`id_utilisateur`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_utilisateur_amis_id_ami`
    FOREIGN KEY (`id_ami`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `groupe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `groupe` ;

CREATE TABLE IF NOT EXISTS `groupe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_createur` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `id_moderateur` INT NOT NULL,
  PRIMARY KEY (`id`, `id_createur`, `id_moderateur`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `nom_UNIQUE` (`nom` ASC),
  INDEX `fk_groupe_utilisateur_id_createur_idx` (`id_createur` ASC),
  INDEX `fk_groupe_utilisateur_id_moderateur_idx` (`id_moderateur` ASC),
  CONSTRAINT `fk_groupe_utilisateur_id_createur`
    FOREIGN KEY (`id_createur`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_groupe_utilisateur_id_moderateur`
    FOREIGN KEY (`id_moderateur`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utilisateur_groupe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `utilisateur_groupe` ;

CREATE TABLE IF NOT EXISTS `utilisateur_groupe` (
  `id_utilisateur` INT NOT NULL,
  `id_groupe` INT NOT NULL,
  PRIMARY KEY (`id_utilisateur`, `id_groupe`),
  INDEX `fk_groupe_has_utilisateur_utilisateur1_idx` (`id_utilisateur` ASC),
  INDEX `fk_groupe_has_utilisateur_groupe1_idx` (`id_groupe` ASC),
  CONSTRAINT `fk_groupe_utilisateur_id_groupe`
    FOREIGN KEY (`id_groupe`)
    REFERENCES `groupe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_groupe_utilisateur_id_utilisateur`
    FOREIGN KEY (`id_utilisateur`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message` ;

CREATE TABLE IF NOT EXISTS `message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_utilisateur` INT NOT NULL,
  `id_groupe` INT NOT NULL,
  `texte` TEXT NOT NULL,
  `date_creation` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `id_utilisateur`, `id_groupe`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_message_utilisateur_groupe1_idx` (`id_utilisateur` ASC, `id_groupe` ASC),
  CONSTRAINT `fk_message_id_utilisateur_groupe`
    FOREIGN KEY (`id_utilisateur` , `id_groupe`)
    REFERENCES `utilisateur_groupe` (`id_utilisateur` , `id_groupe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = eucjpms;


-- -----------------------------------------------------
-- Table `message_prive`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message_prive` ;

CREATE TABLE IF NOT EXISTS `message_prive` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_message` INT NOT NULL,
  `id_destinataire` INT NOT NULL,
  `accuse_reception` TINYINT(1) NOT NULL DEFAULT 0,
  `lu` TINYINT(1) NOT NULL DEFAULT 0,
  `expiration` INT NOT NULL DEFAULT 0,
  `prioritaire` TINYINT(1) NOT NULL DEFAULT 0,
  `chiffre` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`, `id_message`, `id_destinataire`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_message_prive_id_message_idx` (`id_message` ASC),
  INDEX `fk_message_prive_id_destinaire_idx` (`id_destinataire` ASC),
  CONSTRAINT `fk_message_prive_id_message`
    FOREIGN KEY (`id_message`)
    REFERENCES `message` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_prive_id_destinaire`
    FOREIGN KEY (`id_destinataire`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `centre_interet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centre_interet` ;

CREATE TABLE IF NOT EXISTS `centre_interet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_parent` INT NULL,
  `nom` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_centre_interet_parent_idx` (`id_parent` ASC),
  CONSTRAINT `fk_centre_interet_parent`
    FOREIGN KEY (`id_parent`)
    REFERENCES `centre_interet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `demande_ami`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `demande_ami` ;

CREATE TABLE IF NOT EXISTS `demande_ami` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_utilisateur` INT NOT NULL,
  `id_destinataire` INT NOT NULL,
  `traitee` TINYINT(1) NOT NULL DEFAULT 0,
  `action_faite` TINYINT(1) NULL,
  PRIMARY KEY (`id`, `id_destinataire`, `id_utilisateur`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_demande_ami_utilisateur_id_utilisateur_idx` (`id_utilisateur` ASC),
  INDEX `fk_demande_ami_utilisateur_id_destinataire_idx` (`id_destinataire` ASC),
  CONSTRAINT `fk_demande_ami_utilisateur_id_utilisateur`
    FOREIGN KEY (`id_utilisateur`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_demande_ami_utilisateur_id_destinataire`
    FOREIGN KEY (`id_destinataire`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `utilisateur_centre_interet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `utilisateur_centre_interet` ;

CREATE TABLE IF NOT EXISTS `utilisateur_centre_interet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `utilisateur_id` INT NOT NULL,
  `centre_interet_id` INT NOT NULL,
  PRIMARY KEY (`id`, `utilisateur_id`, `centre_interet_id`),
  INDEX `fk_utilisateur_has_centre_interet_centre_interet1_idx` (`centre_interet_id` ASC),
  INDEX `fk_utilisateur_has_centre_interet_utilisateur1_idx` (`utilisateur_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_utilisateur_centre_interet_id_utilisateur`
    FOREIGN KEY (`utilisateur_id`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_utilisateur_centre_interet_id_centre_interet`
    FOREIGN KEY (`centre_interet_id`)
    REFERENCES `centre_interet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notification` ;

CREATE TABLE IF NOT EXISTS `notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_utilisateur` INT NOT NULL,
  `texte` TEXT NOT NULL,
  `supprimee` TINYINT(1) NULL,
  PRIMARY KEY (`id`, `id_utilisateur`),
  INDEX `fk_notification_utilisateur1_idx` (`id_utilisateur` ASC),
  CONSTRAINT `fk_notification_id_utilisateur`
    FOREIGN KEY (`id_utilisateur`)
    REFERENCES `utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO toku;
 DROP USER toku;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'toku' IDENTIFIED BY 'toku';

GRANT ALL ON * TO 'toku';
GRANT SELECT ON TABLE * TO 'toku';
GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'toku';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'toku';
GRANT EXECUTE ON ROUTINE * TO 'toku';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
