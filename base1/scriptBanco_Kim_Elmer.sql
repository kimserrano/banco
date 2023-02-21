CREATE DATABASE IF NOT EXISTS banco;
USE banco;

CREATE TABLE IF NOT EXISTS clientes(
idClientes INT PRIMARY KEY AUTO_INCREMENT,
nombres VARCHAR(50) NOT NULL,
apellidoPat VARCHAR(50) NOT NULL ,
apellidoMat VARCHAR(50) NOT NULL ,
fechaNacimiento DATE NOT NULL,
calle VARCHAR(100) NOT NULL,
numDomicilio INT NOT NULL,
cp INT NOT NULL
);

CREATE TABLE IF NOT EXISTS clientesCredenciales(
username VARCHAR (10) PRIMARY KEY,
clave BLOB NOT NULL,
idClientes INT NOT NULL,
FOREIGN KEY (idClientes) REFERENCES clientes(idClientes)
);


CREATE TABLE IF NOT EXISTS cuentasClientes(
idCuentasClientes INT PRIMARY KEY AUTO_INCREMENT,
fechaHoraApertura DATETIME DEFAULT NOW(),
nombre VARCHAR(50) NOT NULL UNIQUE,
saldo FLOAT DEFAULT 0.0,
numCuenta INT(8) DEFAULT (RAND()*100000000) UNIQUE,
idClientes INT NOT NULL,
estado VARCHAR(10) DEFAULT 'ACTIVA',
FOREIGN KEY (idClientes) REFERENCES clientes(idClientes)
);

CREATE TABLE IF NOT EXISTS transferencias(
idTransferencia INT PRIMARY KEY AUTO_INCREMENT,
idCuentaCliente1 INT NOT NULL,
idCuentaCliente2 INT NOT NULL,
monto float DEFAULT 0.0,
estado VARCHAR(20) NOT NULL,
fechaHora DATETIME DEFAULT NOW(),
FOREIGN KEY (idCuentaCliente1) REFERENCES cuentasClientes(idCuentasClientes),
FOREIGN KEY (idCuentaCliente2) REFERENCES cuentasClientes(idCuentasClientes)
);



CREATE TABLE IF NOT EXISTS retirosSinCuenta(
idRetirosSinCuenta INT PRIMARY KEY AUTO_INCREMENT,
idCuentaCliente INT NOT NULL,
fechaHora DATETIME DEFAULT NOW(),
clave BLOB NOT NULL,
folio INT(9) DEFAULT (RAND()*1000000000) UNIQUE,
estado VARCHAR(20) DEFAULT 'NO COBRADO',
monto FLOAT DEFAULT 0.0,
FOREIGN KEY (idCuentaCliente) REFERENCES cuentasClientes(idCuentasClientes)
);

CREATE TABLE IF NOT EXISTS historiales(
idHistorial INT PRIMARY KEY AUTO_INCREMENT,
operacion VARCHAR(30),
idTransferencia INT,
idRetiros INT,
idCuentaCliente1 INT NOT NULL,
idCuentaCliente2 INT NOT NULL,
fechaOperacion DATETIME NOT NULL,
FOREIGN KEY (idCuentaCliente1) REFERENCES cuentasclientes(idCuentasClientes),
FOREIGN KEY (idCuentaCliente2) REFERENCES cuentasclientes(idCuentasClientes),
FOREIGN KEY (idTransferencia) REFERENCES transferencias(idTransferencia),
FOREIGN KEY (idRetiros) REFERENCES retirossincuenta(idRetirosSinCuenta)
);


# Trigger para registrar una transferencia en el historial
    CREATE TRIGGER registroTransferencia AFTER INSERT ON transferencias 
    FOR EACH ROW INSERT INTO historiales(operacion, idCuentaCliente1,idCuentaCliente2,fechaOperacion,idTransferencia)VALUES('Transferencia',new.idCuentaCliente1,new.idCuentaCliente2,now(),new.idTransferencia);
    

# transferencia 
DELIMITER $$
USE `banco`$$
CREATE PROCEDURE  `transferir` (
IN id1 INT,
IN numCuentaTransferencia INT,
IN monto FLOAT, 
IN estado VARCHAR(20)
)
BEGIN
START TRANSACTION;
IF (SELECT saldo FROM cuentasClientes WHERE idCuentasClientes=id1) >= monto THEN
  SELECT idCuentasClientes INTO @id2 FROM cuentasClientes WHERE numCuenta=numCuentaTransferencia;
	insert into transferencias(idCuentaCliente1,idcuentacliente2,monto,estado)values(id1,@id2,monto,estado);
    update cuentasClientes SET saldo=saldo-monto WHERE idCuentasClientes=id1;
    update cuentasClientes SET saldo=saldo+monto WHERE idCuentasClientes=@id2;
    END IF;
COMMIT;
END$$
DELIMITER ;

#mayores de edad 
DELIMITER $$
USE `banco`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `edadNecesaria`(
IN nombres_ VARCHAR(500),
IN apellidoPat_ VARCHAR(50),
IN apellidoMat_ VARCHAR(50) ,
IN fechaNacimiento_ DATE ,
IN calle_ VARCHAR(100) ,
IN numDomicilio_ INT ,
IN cp_ INT, 
IN username_ VARCHAR(10),
IN clave_ VARCHAR(8)
)
BEGIN
START TRANSACTION;
IF TIMESTAMPDIFF(YEAR, fechaNacimiento_, NOW()) >= 18 THEN
INSERT INTO clientes(nombres, apellidoPat, apellidoMat, fechaNacimiento, calle, numDomicilio, cp)
VALUES(nombres_, apellidoPat_, apellidoMat_, fechaNacimiento_, calle_, numDomicilio_, cp_);
INSERT INTO clientesCredenciales (username, clave, idClientes) VALUES (username_, AES_ENCRYPT(clave_,'yorx'), 
(select last_insert_id()));
END IF;
COMMIT;
END$$

DELIMITER ;
;


#Crear retiro 
DELIMITER $$
USE `banco`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearRetiro`(
IN idCuentaCliente_ INT,
IN monto_ FLOAT
)
BEGIN
IF (SELECT saldo from cuentasClientes WHERE idCuentasClientes= idCuentaCliente_)>= monto_
THEN 
INSERT INTO retirossincuenta (idCuentaCliente, monto)
values(idCuentaCliente_, monto_);
END IF;
END$$
DELIMITER ;

DELIMITER $$
USE `banco`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `retiro`(
IN clave_ INT(8), 
IN folio_ INT(92)
)
BEGIN
START TRANSACTION;
IF TIMESTAMPDIFF(MINUTE, (SELECT fechaHora from retirossincuenta WHERE clave=aes_encrypt(clave_,'yorx') 
AND folio=folio_), NOW()) <=10
AND (SELECT estado from retirossincuenta WHERE clave=aes_encrypt(clave_,'yorx') AND folio=folio_) LIKE 'NO COBRADO'
THEN
SELECT idCuentaCliente INTO @idCuentaCliente_ from retirossincuenta WHERE clave=aes_encrypt(clave_,'yorx') AND folio=folio_;
SELECT monto INTO @monto from retirossincuenta WHERE clave=aes_encrypt(clave_,'yorx') AND folio=folio_;
SELECT idRetirosSinCuenta INTO @idRetiros from retirossincuenta WHERE clave=aes_encrypt(clave_,'yorx') AND folio=folio_;
UPDATE CuentasClientes SET saldo=saldo-@monto WHERE idCuentasClientes=@idCuentaCliente_;
UPDATE retirossincuenta SET estado = 'COBRADO' WHERE clave=aes_encrypt(clave_,'yorx') AND folio=folio_;

INSERT INTO historiales(operacion, idCuentaCliente1,idCuentaCliente2,fechaOperacion,idRetiros)
VALUES('Retiro sin cuenta', @idCuentaCliente_, @idCuentaCliente_,now(),@idRetiros);
    

END IF;
COMMIT;
END$$

DELIMITER ;
;
