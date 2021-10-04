DROP SCHEMA IF EXISTS tienda_generica;
CREATE SCHEMA tienda_generica;
USE tienda_generica;

  CREATE TABLE `tienda_generica`.`usuarios` (
  `cedula_usuario` BIGINT(20) NOT NULL,
  `email_usuario` VARCHAR(255) NULL,
  `nombre_usuario` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `usuario` VARCHAR(255) NULL,
  PRIMARY KEY (`cedula_usuario`));
  
  CREATE TABLE `tienda_generica`.`clientes` (
  `cedula_cliente` BIGINT(20) NOT NULL,
  `direccion_cliente` VARCHAR(255) NULL,
  `email_cliente` VARCHAR(255) NULL,
  `nombre_cliente` VARCHAR(255) NULL,
  `telefono_cliente` VARCHAR(255) NULL,
  PRIMARY KEY (`cedula_cliente`));
  
  CREATE TABLE `tienda_generica`.`proveedores` (
  `nitproveedor` BIGINT(20) NOT NULL,
  `ciudad_proveedor` VARCHAR(255) NULL,
  `direccion_proveedor` VARCHAR(255) NULL,
  `nombre_proveedor` VARCHAR(255) NULL,
  `telefono_proveedor` VARCHAR(255) NULL,
  PRIMARY KEY (`nitproveedor`));

  CREATE TABLE `tienda_generica`.`productos` (
  `codigo_producto` BIGINT(20) NOT NULL,
  `ivacompra` DOUBLE NOT NULL,
  `nitproveedor` BIGINT(20) NOT NULL,
  `nombre_producto` VARCHAR(255) NULL,
  `precio_compra` DOUBLE NOT NULL,
  `precio_venta` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_producto`),
  INDEX `nitproveedor_idx` (`nitproveedor` ASC) VISIBLE,
  CONSTRAINT `nitproveedor`
    FOREIGN KEY (`nitproveedor`)
    REFERENCES `tienda_generica`.`proveedores` (`nitproveedor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
  CREATE TABLE `tienda_generica`.`ventas` (
  `codigo_venta` BIGINT(20) NOT NULL,
  `cedula_cliente` BIGINT(20) NOT NULL,
  `cedula_usuario` BIGINT(20) NOT NULL,
  `ivaventa` DOUBLE NOT NULL,
  `total_venta` DOUBLE NOT NULL,
  `valor_venta` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_venta`),
  INDEX `cedula_cliente_idx` (`cedula_cliente` ASC) VISIBLE,
  INDEX `cedula_usuario_idx` (`cedula_usuario` ASC) VISIBLE,
  CONSTRAINT `cedula_cliente`
    FOREIGN KEY (`cedula_cliente`)
    REFERENCES `tienda_generica`.`clientes` (`cedula_cliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `cedula_usuario`
    FOREIGN KEY (`cedula_usuario`)
    REFERENCES `tienda_generica`.`usuarios` (`cedula_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
  CREATE TABLE `tienda_generica`.`detalle_ventas` (
  `codigo_detalle_venta` BIGINT(20) NOT NULL,
  `cantidad_producto` INT(11) NOT NULL,
  `codigo_producto` BIGINT(20) NOT NULL,
  `codigo_venta` BIGINT(20) NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  `valor_venta` DOUBLE NOT NULL,
  `valoriva` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_detalle_venta`),
  INDEX `codigo_producto_idx` (`codigo_producto` ASC) VISIBLE,
  INDEX `codigo_venta_idx` (`codigo_venta` ASC) VISIBLE,
  CONSTRAINT `codigo_producto`
    FOREIGN KEY (`codigo_producto`)
    REFERENCES `tienda_generica`.`productos` (`codigo_producto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `codigo_venta`
    FOREIGN KEY (`codigo_venta`)
    REFERENCES `tienda_generica`.`ventas` (`codigo_venta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);