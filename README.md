# tarea-programacion-iii-2023
Tarea Programada sobre Sistema de Evaluaciones de Competencias 360

## Docker
Se utilizar&aacute; Docker para el desarrollo del proyecto, por lo que se debe tener instalado Docker.

```docker
docker run -d -p 1521:1521 --name oracle -e ORACLE_PASSWORD=tremendisimo -e APP_USER=EvaComUNA -e APP_USER_PASSWORD=una -v oracle-volume:/opt/oracle/oradata gvenzl/oracle-xe:latest
```

Esencialmente se utilizaran las siguientes im&aacute;genes:
- [Oracle 21c XE](https://hub.docker.com/r/gvenzl/oracle-xe)
- [Payara Server](https://hub.docker.com/r/payara/server-full)

Cualquier otra imagen que puede facilitar el desarrollo, se puede implementar.

## Git
Se estar&aacute; trabajando con un enfoque de ramas de corta y larga duraci&oacute;n. La primera para ramas temporales, que se vayan creando mientras se va desarrollando, la segunda para ramas principales.

### Convenciones


#### Commits:

Para el commit utilizaremos la siguiente convenci&oacute;n:
```
git commit -m "[<accion>] <seccion trabajada>" -m <mensaje breve/descriptivo>
```

Donde \<accion> puede ser:
- feat: Nueva funcionalidad
- fix: Correcci&oacute;n de errores
- add: Agregado de archivos
- remove: Eliminaci&oacute;n de archivos
- refactor: Refactorizaci&oacute;n de c&oacute;digo
- bug: Se introdujo un bug
- docs: Documentaci&oacute;n

Un ejemplo de un commit ser&iacute;a:
```
git commit -m "[feat] Login" -m "Se agrego la funcionalidad de login"
```

De esta manera cuando se verifique el log, se podr&aacute; ver de manera m&aacute;s clara que se hizo en cada commit.

#### Ramas principales:
Para las ramas de larga duraci&oacute;n, se utilizar&aacute; la siguiente convenci&oacute;n:
- master

La rama master ser&aacute; la rama principal, cualquier cambio que se agregue a esta rama, debe de ser aprobado por los dem&aacute;s miembros del equipo. Solo se debe de hacer merge a esta rama cuando se tenga una versi&oacute;n estable del proyecto.

- dev

La rama dev ser&aacute; la rama de desarrollo, se implementan las nuevas funcionalidades en esta rama. Cuando se tenga una versi&oacute;n estable, se hace merge a la rama master.

- test

La rama test ser&aacute; la rama de pruebas, se prueba el funcionamiento del c&oacute;digo en esta rama. Utilizando JUnit5 como framework de pruebas. 

#### Ramas temporales:
Para las ramas de corta duraci&oacute;n, se utilizar&aacute; la siguiente convenci&oacute;n:

- feature/\<nombre>

#### Merge Conflicts:
Para los merge coflicts, deben de estar al menos 2 personas presentes para resolverlos. Preferiblemente, se debe de resolver en conjunto con la persona que hizo el commit.

## Herramientas
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)
- [Trello](https://trello.com/)
