# PROYECTO 1 ORGANIZACION DE LENGUAJES Y COMPILADORES 1

## Comenzando 🚀

_El proyecto esta basado en dos aplicaciones desarroladas en JAVA 11, una aplicacion web y un a app de escritorio de java consumidora de la app web_

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_Los requisitos de ejecucion se basan en los siguiente:_

```
Java en su version 11 LTS o en defecto OPENJDK
Apache Tomcat en su version (9.0.43) *recomendado
```

### Instalación 🔧 / Despliegue 📦

_Ejecutar servidor Apache Tomcat (9.0.43)_

_La ejecucion de Apache Tomcat puede ser realizada de dos formas, por medio de la intalacion Nativa del software o por medio de Apache NetBeans que provee de las herramientas necesarias para poder desplegarla sin la instalacion directa en el sistema_

```
Instalacion Nativa: 
Desde terminal -> $catalina run

Apache NetBeans
- En el apartado de *services* localizamos el apartado *servers* donde agregaremos un servidor Apache Tomcat o TomEE, localizaremos la carpeta de nuestro Apache Tomcat 9.0.43 y asignamos user y password para servicios de tomcat y finalizamos la configuracion.

-Ya agregado el servidor ya aparecera en la lista del apartado *servers* donde daremos click derecho y ejecutaremos el servicio de Apache Tomcat

```

_Asignacion de permisos para la gestion de Apache Tomcat_

_Apache Tomcat integra un sistema de usuarios y permisos por lo cual para desplegar nuestro proyecto necesitaremos de los accesos a el sistema, teniendo una instalacion nativa o un ejecucion desde NetBeans deberemos de acceder a la carpeta **conf** de nuestro Apache Tomcat y modificar el archivo **tomcat-users.xml** en este documento existe un apartado denominado **tomcat-users** que dentro de este apartado deberemos de agregar las siguintes configuraciones si no estuvieran_
```
<role rolename="manager-gui"/>
role rolename="manager-script"/>
role rolename="manager-jnx"/>
role rolename="manager-status"/>
<role rolename="admin"/>
<user password="pass" roles="admin,manager-gui,manager-script" username="admin"/>

```
_Ya realizando la configuracion reiniciamos nuestro servicio de Apache Tomcat para que se aplique los cambios_

_Para el despliege del proyecto_



_Finaliza con un ejemplo de cómo obtener datos del sistema o como usarlos para una pequeña demo_


## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Carlos Pac** - *Trabajo Inicial* - [cresb-49](https://github.com/cresb-49)
