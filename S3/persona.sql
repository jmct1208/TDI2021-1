CREATE TABLE persona(
	id integer NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    apellidos varchar(255),
	fecha_nacimiento timestamp,
    domicilio varchar(255),
    rfc varchar(255),
	PRIMARY KEY (id)
);

INSERT INTO persona (nombre,apellidos,fecha_nacimiento,domicilio,rfc) VALUES ('Ivan','Saavedra','1992-01-01','Av. Universidad S/N, Coyoacán','SAIV920101');
INSERT INTO persona (nombre,apellidos,fecha_nacimiento,domicilio,rfc) VALUES ('María','Salazar','1974-05-12','Insurgentes Sur 1431, Mixcoac','SAMA740512');
INSERT INTO persona (nombre,apellidos,fecha_nacimiento,domicilio,rfc) VALUES ('Juan','Pérez','1970-08-25','Paseo de la Reforma 4312, Centro','PEJU501025');

SELECT * FROM persona;