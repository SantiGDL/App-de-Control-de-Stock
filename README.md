# StockApp

Aplicación de escritorio para administrar inventario, compras, proveedores y alertas de stock. Fue desarrollada en Java Swing y utiliza MySQL mediante Jakarta Persistence e Hibernate.

La interfaz permite trabajar con catálogos, registrar compras y ventas, consultar movimientos y controlar existencias desde una misma aplicación. Sus menús principales se adaptan al tamaño de la ventana y reorganizan las opciones cuando el espacio disponible cambia.

## Funcionalidades

- Creación y eliminación de productos.
- Catálogo general de productos.
- Registro, listado y eliminación de proveedores.
- Catálogo de productos por proveedor.
- Registro de compras y ventas.
- Consulta del stock disponible.
- Historial general y por proveedor.
- Configuración de alertas de stock preventivas y críticas.
- Carga y visualización de imágenes para productos y proveedores.
- Interfaz adaptable con desplazamiento vertical cuando es necesario.

## Flujo de trabajo

1. Creá un producto para incorporarlo al catálogo general.
2. Registrá un proveedor o utilizá el proveedor predeterminado.
3. Desde **Comprar ítem**, seleccioná el producto y el proveedor.
4. Registrá la compra para agregar unidades al stock.
5. Consultá el stock, registrá ventas y configurá alertas de cantidad.

## Tecnologías

- Java 21
- Java Swing
- Maven
- Jakarta Persistence 3.1
- Hibernate ORM 6.5
- MySQL 8
- FlatLaf

## Requisitos

Antes de ejecutar el proyecto necesitás tener instalado:

- JDK 21 o una versión compatible.
- Apache Maven.
- MySQL Server 8.

Podés comprobar las instalaciones con:

```bash
java -version
mvn -version
mysql --version
```

## Configuración de MySQL

Ingresá a MySQL con una cuenta administradora:

```bash
mysql -u root -p
```

Creá la base de datos y el usuario utilizados por la aplicación:

```sql
CREATE DATABASE IF NOT EXISTS stockappDB
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'StockUser'@'localhost'
    IDENTIFIED BY 'StockPass';

GRANT ALL PRIVILEGES ON stockappDB.*
    TO 'StockUser'@'localhost';

FLUSH PRIVILEGES;
```

No es necesario crear las tablas manualmente. Hibernate las crea o actualiza al iniciar la aplicación mediante `hibernate.hbm2ddl.auto=update`.

La conexión se encuentra en [`src/main/resources/META-INF/persistence.xml`](src/main/resources/META-INF/persistence.xml). Si usás otras credenciales o un servidor diferente, modificá ese archivo antes de compilar.

## Ejecutar el proyecto

Cloná el repositorio y entrá en su carpeta:

```bash
git clone URL_DEL_REPOSITORIO
cd inventory-management-system-master
```

Compilá y verificá el proyecto:

```bash
mvn clean test
```

Generá el JAR ejecutable:

```bash
mvn clean package
```

Luego iniciá la aplicación:

```bash
java -jar target/AppControlStock.jar
```

También podés ejecutar la clase principal `GUI.FramePrincipal` desde NetBeans, IntelliJ IDEA o VS Code.

## Archivos de imágenes

Las imágenes seleccionadas por el usuario se copian a la carpeta `StockAppSources`, creada automáticamente dentro del directorio personal de quien ejecuta la aplicación. De esta forma, la ruta funciona tanto en Linux como en Windows y no depende del nombre de un usuario específico.

## Capturas de pantalla

### Menú principal

![Menú principal de StockApp](docs/screenshots/MenuPrincipal.png)

### Flujo principal

| Crear un producto | Registrar una compra |
|:---:|:---:|
| ![Formulario para crear un producto](docs/screenshots/CrearItem2.png) | ![Formulario para registrar una compra](docs/screenshots/ComprarItem4.png) |

| Consultar el catálogo | Registrar una venta |
|:---:|:---:|
| ![Catálogo general de productos](docs/screenshots/CatalogoGeneral.png) | ![Formulario para vender un producto](docs/screenshots/VenderItem2.png) |

Hay más capturas de los catálogos, proveedores, alertas y pasos intermedios en la [galería completa](docs/screenshots/README.md).

## Estructura principal

```text
src/main/java/
├── GUI/                 # Ventanas, paneles y controladores visuales
├── ImagenesHelpers/     # Escalado, renderizado y estilos de imágenes
├── Logica/              # Operaciones del dominio
└── Persistencia/        # Entidades, DTO y acceso a datos

src/main/resources/
├── Imagenes/            # Recursos visuales incluidos en la aplicación
└── META-INF/
    └── persistence.xml # Configuración de JPA y MySQL
```
