# 🔐 Sistema de Administración de Usuarios con Roles y Login

Proyecto de escritorio desarrollado en **Java** para la gestión de usuarios y control de acceso. Implementa un sistema de autenticación (Login) que redirige a distintas interfaces según el rol del usuario (Administrador o Usuario normal). El perfil Administrador cuenta con permisos para gestionar el sistema mediante un CRUD completo (Crear, Leer, Actualizar y Eliminar usuarios), persistiendo los datos de forma relacional en MySQL mediante JPA.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 17)
* **Interfaz Gráfica:** Java Swing (IGU)
* **Persistencia de Datos:** JPA (Java Persistence API) con EclipseLink
* **Base de Datos:** MySQL
* **Gestor de Dependencias:** Maven
* **IDE Recomendado:** Apache NetBeans

## 📸 Capturas de Pantalla

**1. Pantalla de Login (Control de Acceso por Roles):**
<img width="535" height="716" alt="login" src="https://github.com/user-attachments/assets/8ffae8d2-01d1-4b87-93f2-cf4c0d3490b5" />

**2. Panel de Administrador (Vista de tabla y operaciones CRUD):**
<img width="1036" height="735" alt="PrincipalAdmin" src="https://github.com/user-attachments/assets/c5825678-942c-4018-a7b5-d3be16b2ed3b" />

**3. Formulario de Alta y Edición de Usuarios:**
<img width="1032" height="742" alt="altaUsuarios" src="https://github.com/user-attachments/assets/2cadcfca-c4e6-4c7b-a9d5-2110a10b8f08" />

## 📂 Arquitectura del Proyecto

El proyecto sigue un **Patrón de Arquitectura multicapa** altamente estructurado, separando responsabilidades visuales, lógicas y de base de datos:

* `com.sistema.app.login`: Contiene el punto de entrada de la aplicación (`Login.java`).
* `com.sistema.app.login.logica`: Entidades del dominio mapeadas a la base de datos (`Usuario`, `Rol`) y la `Controladora` que concentra la lógica de negocio.
* `com.sistema.app.login.igu`: Formularios gráficos (JFrames) que varían según el contexto (`PantallaLogin`, `PrincipalAdmin`, `PrincipalUsuario`, `AltaUsuarios`, `EdicionUsuario`).
* `com.sistema.app.login.persistencia`: Controladores de JPA (`JpaController`) auto-generados y la fachada `ControladoraPersistencia` para aislar el acceso a datos.
* `com.sistema.app.login.utils`: **[Capa Personalizada]** Clases utilitarias (`Mensajes`, `Navegacion`) para reciclar código, estandarizar las alertas del sistema y manejar el ruteo entre pantallas.
* `src/main/resources`: Contenedor de configuración (`META-INF/persistence.xml`) y recursos estáticos (`images/arrow-back-up-icon.png`).

## 🚀 Instalación y Uso

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/emanuelcantuta/Login-Roles-JavaDesktop.git
   ```

2. **Preparar la Base de Datos:**
   Crea una base de datos vacía en tu gestor MySQL local (asegúrate de que el nombre coincida con tu configuración de JPA):
   ```sql
   CREATE DATABASE login;
   ```

3. **Configurar Credenciales:**
   En `src/main/resources/META-INF/persistence.xml`, busca la unidad de persistencia `loginPU` y actualiza las credenciales de tu servidor local:
   ```xml
   <property name="javax.persistence.jdbc.user" value="TU_USUARIO"/>
   <property name="javax.persistence.jdbc.password" value="TU_CONTRASEÑA"/>
   ```

4. **Ejecutar:**
   Abre el proyecto en tu IDE, permite que Maven descargue las dependencias y ejecuta el archivo principal `Login.java`.

## 💡 Origen del Proyecto y Modificaciones (Valor Agregado)

Este proyecto nació como una práctica guiada del curso de [TodoCode Academy](https://todocodeacademy.com/). 

Para llevar el software a un nivel profesional y mejorar significativamente la Arquitectura y la Experiencia de Usuario (UX), implementé de forma personal las siguientes características:

**Mejoras de Interfaz y UX (User Experience):**
* **Paleta de colores "Flat Design":** Implementación de colores estandarizados en la industria (Verde para Crear, Azul para Editar, Rojo para Eliminar) para un panel de administración intuitivo.
* **Navegación contextualizada:** Arrastre del nombre del usuario logueado por todas las pantallas para mostrar siempre de quién es la sesión activa.
* **Redimensionamiento de JTable:** Anchos de columna personalizados y fijos por código (priorizando el nombre de Usuario sobre el ID) para una lectura más limpia.
* Inclusión de un **botón "Atrás"** visual (con ícono alojado en `resources`) para un retorno seguro al panel principal tras un alta o edición.
* Actualización automática de la tabla por detrás tras realizar cualquier acción (Crear/Editar/Eliminar), eliminando la necesidad de botones de "recarga" manuales.

**Refactorización y Arquitectura (Clean Code):**
* **Inyección de Dependencias:** Refactorización profunda para mantener una única instancia de la `Controladora` viva durante toda la ejecución. Esto evita abrir múltiples conexiones simultáneas a la base de datos y optimiza el consumo de memoria RAM.
* **Navegación Optimizada:** Destrucción de ventanas en desuso (`dispose()`) en lugar de ocultarlas, limpiando credenciales residuales y liberando recursos del sistema operativo al cambiar de pantalla.
* Principio DRY en alertas y navegación mediante las clases estáticas `Mensajes` y `Navegacion`.

**Validaciones:**
* Validaciones `isBlank()` en los formularios de Alta y Edición para asegurar la integridad de los datos.
