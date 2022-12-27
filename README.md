# ProyectoFinalJava-CaC

Proyecto realizado para el trabajo integrador del curso Java-FullStack de Codo a Codo 2022

Benetucci Ignacio
DNI: 43110500
Comision: JAVA 22541

Server: GlassFishServer
Java EE Version: Jakarta EE 9 Web
Java Plataform: JDK 19
Compile-time Libraries: mysql-connector-java-5.1.49.jar

Documento con capturas de las pruebas realizadas a la aplicación: https://drive.google.com/file/d/1AWLJreKfnpgPoKn86-wXdPzSoeNgpw9U/view?usp=sharing

	Se cumple con las consignas minimas solicitadas
		-> Comunicacion front end - back end ingresando con un usuario previamente registrado en la base de datos

	Agregados:
		-> Registrar un nuevo usuario(registrarUsuario.html, registeruser.java)
	
	Consideraciones
		-> Se añade una base de datos con algunas registros insertados en la tabla "usuarios"
		-> No se contempla que el campo "usuario" sea unico, por lo tanto si existen dos usuarios iguales registrados en la base de datos pueden haber conflictos a la hora de ingresar al sistema.
		-> El formulario de un nuevo pedido no impacta en el back-end