-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdrestaurante
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdrestaurante
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdrestaurante` DEFAULT CHARACTER SET utf8mb3 ;
USE `bdrestaurante` ;

-- -----------------------------------------------------
-- Table `bdrestaurante`.`puesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrestaurante`.`puesto` (
  `idpuesto` INT NOT NULL AUTO_INCREMENT,
  `puesto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpuesto`),
  UNIQUE INDEX `puesto_UNIQUE` (`puesto` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdrestaurante`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrestaurante`.`empleado` (
  `idempleado` INT NOT NULL AUTO_INCREMENT,
  `nombreEmpleado` VARCHAR(45) NOT NULL,
  `apellidoEmpleado` VARCHAR(45) NOT NULL,
  `usuarioEmpleado` VARCHAR(45) NOT NULL,
  `teléfonoEmpleado` INT NOT NULL,
  `direccionEmpleado` VARCHAR(70) NOT NULL,
  `sueldoEmpleado` DOUBLE NOT NULL,
  `idPuesto` INT NOT NULL,
  PRIMARY KEY (`idempleado`),
  UNIQUE INDEX `usuarioEmpleado_UNIQUE` (`usuarioEmpleado` ASC) VISIBLE,
  UNIQUE INDEX `teléfonoEmpleado_UNIQUE` (`teléfonoEmpleado` ASC) VISIBLE,
  INDEX `idPuesto_idx` (`idPuesto` ASC) VISIBLE,
  CONSTRAINT `idPuesto`
    FOREIGN KEY (`idPuesto`)
    REFERENCES `bdrestaurante`.`puesto` (`idpuesto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdrestaurante`.`platillo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrestaurante`.`platillo` (
  `idplatillo` INT NOT NULL AUTO_INCREMENT,
  `nombrePlatillo` VARCHAR(45) NOT NULL,
  `precioPlatillo` DOUBLE NOT NULL,
  PRIMARY KEY (`idplatillo`),
  UNIQUE INDEX `nombrePlatillo_UNIQUE` (`nombrePlatillo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdrestaurante`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrestaurante`.`proveedor` (
  `idproveedor` INT NOT NULL AUTO_INCREMENT,
  `nombreProveedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idproveedor`),
  UNIQUE INDEX `nombreProveedor_UNIQUE` (`nombreProveedor` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdrestaurante`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdrestaurante`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `costoProducto` DOUBLE NOT NULL,
  `cantidadProducto` INT NOT NULL,
  `idProveedor` INT NOT NULL,
  PRIMARY KEY (`idproducto`),
  INDEX `idProveedor_idx` (`idProveedor` ASC) VISIBLE,
  CONSTRAINT `idProveedor`
    FOREIGN KEY (`idProveedor`)
    REFERENCES `bdrestaurante`.`proveedor` (`idproveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
