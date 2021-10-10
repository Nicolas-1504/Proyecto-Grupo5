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
  `codigo_detalle_venta` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cantidad_producto` INT(11) NOT NULL,
  `codigo_producto` BIGINT(20) NOT NULL,
  `codigo_venta` BIGINT(20) NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  `valor_venta` DOUBLE NOT NULL,
  `ivacompra` DOUBLE NOT NULL,
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
    
INSERT INTO `tienda_generica`.`usuarios` (`cedula_usuario`, `email_usuario`, `nombre_usuario`, `password`, `usuario`) VALUES ('12345', 'nicolas@gmail.com', 'Nicolas Ahumada', '123', 'nico');
INSERT INTO `tienda_generica`.`usuarios` (`cedula_usuario`, `email_usuario`, `nombre_usuario`, `password`, `usuario`) VALUES ('98765', 'william@gmail.com', 'William Montealegre', '987', 'will');
INSERT INTO `tienda_generica`.`usuarios` (`cedula_usuario`, `email_usuario`, `nombre_usuario`, `password`, `usuario`) VALUES ('45678', 'johanna@gmail.com', 'Johanna Briceño', '456', 'joha');
INSERT INTO `tienda_generica`.`usuarios` (`cedula_usuario`, `email_usuario`, `nombre_usuario`, `password`, `usuario`) VALUES ('65478', 'daniel@gmail.com', 'Daniel Bergano', '654', 'dani');
INSERT INTO `tienda_generica`.`usuarios` (`cedula_usuario`, `email_usuario`, `nombre_usuario`, `password`, `usuario`) VALUES ('54321', 'jonathan@gmail.com', 'Jonathan Rojas', '543', 'jona');

INSERT INTO `tienda_generica`.`clientes` (`cedula_cliente`, `direccion_cliente`, `email_cliente`, `nombre_cliente`, `telefono_cliente`) VALUES ('12345', 'Calle falsa 123', 'pepe@gmail.com', 'Pepe Perez', '123');
INSERT INTO `tienda_generica`.`clientes` (`cedula_cliente`, `direccion_cliente`, `email_cliente`, `nombre_cliente`, `telefono_cliente`) VALUES ('98765', 'Calle falsa 987', 'juan@gmail.com', 'Juan Gomez', '987');

INSERT INTO `tienda_generica`.`proveedores` (`nitproveedor`, `ciudad_proveedor`, `direccion_proveedor`, `nombre_proveedor`, `telefono_proveedor`) VALUES ('12345', 'Bogota', 'Calle falsa 123', 'Ebook', '123');
INSERT INTO `tienda_generica`.`proveedores` (`nitproveedor`, `ciudad_proveedor`, `direccion_proveedor`, `nombre_proveedor`, `telefono_proveedor`) VALUES ('98765', 'Medellin', 'Calle falsa 987', 'Libros', '987');

INSERT INTO `tienda_generica`.`productos` (`codigo_producto`, `ivacompra`, `nitproveedor`, `nombre_producto`, `precio_compra`, `precio_venta`) VALUES ('1', '19', '12345', 'Harry Potter', '30000', '40000');
INSERT INTO `tienda_generica`.`productos` (`codigo_producto`, `ivacompra`, `nitproveedor`, `nombre_producto`, `precio_compra`, `precio_venta`) VALUES ('2', '19', '98765', 'El alquimista', '25000', '30000');
INSERT INTO `tienda_generica`.`productos` (`codigo_producto`, `ivacompra`, `nitproveedor`, `nombre_producto`, `precio_compra`, `precio_venta`) VALUES ('3', '19', '12345', 'Romeo y Julieta', '15000', '25000');
INSERT INTO `tienda_generica`.`productos` (`codigo_producto`, `ivacompra`, `nitproveedor`, `nombre_producto`, `precio_compra`, `precio_venta`) VALUES ('4', '19', '12345', 'La cronica de una muerte anunciada', '20000', '35000');
INSERT INTO `tienda_generica`.`productos` (`codigo_producto`, `ivacompra`, `nitproveedor`, `nombre_producto`, `precio_compra`, `precio_venta`) VALUES ('5', '19', '98765', 'Carta al padre', '5000', '10000');
INSERT INTO `tienda_generica`.`productos` (`codigo_producto`, `ivacompra`, `nitproveedor`, `nombre_producto`, `precio_compra`, `precio_venta`) VALUES ('6', '19', '98765', 'Lo que el viento se llevo', '15000', '20000');
INSERT INTO `tienda_generica`.`productos` (`codigo_producto`, `ivacompra`, `nitproveedor`, `nombre_producto`, `precio_compra`, `precio_venta`) VALUES ('7', '19', '98765', 'La culpa es de la vaca', '25000', '35000');
