CREATE TABLE `mydb`.`Cliente` ( `Nombre` VARCHAR(50) NOT NULL , `Rut` VARCHAR(50) NOT NULL , `Mail` VARCHAR(50) NOT NULL , `Telefono` INT(50) NOT NULL , `id_Cliente` INT(50) NOT NULL AUTO_INCREMENT , PRIMARY KEY (`id_Cliente`)) ENGINE = InnoDB;

CREATE TABLE `mydb`.`Fila` ( `Fila` INT(100) NOT NULL , `Numero` INT(100) NOT NULL AUTO_INCREMENT , `Disponibilidad` BOOLEAN NOT NULL , PRIMARY KEY (`Numero`)) ENGINE = InnoDB;

CREATE TABLE `mydb`.`Director` ( `Nombre` VARCHAR(100) NOT NULL , `Rut` VARCHAR(100) NOT NULL , `Nacionalidad` VARCHAR(100) NOT NULL , PRIMARY KEY (`Rut`)) ENGINE = InnoDB;

CREATE TABLE `mydb`.`Venta` ( `id_Venta` INT(100) NOT NULL AUTO_INCREMENT , `TipoVenta` VARCHAR(50) NOT NULL , `rut_Cliente` VARCHAR(50) NOT NULL , `id_Proyeccion` INT(100) NOT NULL , `Monto` INT(255) NOT NULL , `cantidad_Asientos` INT(100) NOT NULL , PRIMARY KEY (`id_Venta`)) ENGINE = InnoDB;

CREATE TABLE `mydb`.`Pelicula` ( `idPelicula` INT(50) NOT NULL AUTO_INCREMENT , `DuracionHora` INT(50) NOT NULL , `DuracionMinutos` INT(50) NOT NULL , `Idioma` VARCHAR(50) NOT NULL , `Rut_Director` VARCHAR(100) NOT NULL , `Resumen` VARCHAR(250) NOT NULL , PRIMARY KEY (`idPelicula`)) ENGINE = InnoDB;

CREATE TABLE `mydb`.`Proyeccion` ( `idProyeccion` INT(100) NOT NULL AUTO_INCREMENT , `id_Pelicula` INT(100) NOT NULL , `Horario` INT(50) NOT NULL , `Fecha` DATE NOT NULL , `nro_Sala` INT(50) NOT NULL , `Localidad` VARCHAR(50) NOT NULL , `precio` INT(100) NOT NULL , PRIMARY KEY (`idProyeccion`)) ENGINE = InnoDB;