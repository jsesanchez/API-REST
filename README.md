# API-REST 

API Rest - SpringBoot

# Puesta en marcha

1) Clonar el repositorio.
2) En Springboot Tool suite 4:
  a) Importar proyecto maven.
  b) Seleccionar el repo descargado.
  c) Ejecutar como SpringBoot App

## Dependencias

En el archivo application.properties se tienen los datos de conexión a la base de datos, debe introducir el usuario y contraseña correspondientes a la base de datos local que tenga en la máquina.

## MySQL - Docker

1) Abra una consola en la carpeta en la que se encuentra este repo.
2) Execute `docker-compose up -d`
3) Cree el Esquema db
  a) Cree la tabla "location".
  b) Cree los campos:
    -id: NUMBER, llave primaria, autoincrementar.
    -name: TEXT
    -area_m2: NUMBER

  
