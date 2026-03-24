# Práctica de Cookies con Spring Boot 🍪⚙️

Este es un proyecto práctico desarrollado en Java con Spring Boot para aprender y demostrar la gestión de **Cookies HTTP** desde el lado del servidor. 

A diferencia de las APIs REST puras, este proyecto utiliza el patrón **MVC (Model-View-Controller)** junto con **Thymeleaf** para renderizar una interfaz web (HTML) desde la que el usuario puede interactuar para generar las cookies.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 21
* **Framework:** Spring Boot
* **Web:** Spring Web MVC
* **Motor de Plantillas:** Thymeleaf
* **Gestor de Dependencias:** Maven

## 🚀 Funcionamiento y Rutas

El proyecto expone las siguientes rutas a través de su controlador principal (`principal.java`):

* `GET /` : Carga la página de inicio (`formulario.html`). Muestra un botón dentro de un formulario y un enlace directo.
* `POST /crear-cookie` : Endpoint que recibe la petición del formulario. Genera una cookie llamada `prueba` con el valor *"contenido de la cookie"* y la inyecta en la cabecera HTTP de la respuesta. Al terminar, redirige automáticamente a la página de inicio.
* `GET /crear-otra-cookie` : Endpoint activado mediante un enlace HTML. Genera una segunda cookie llamada `pruebaOtra` con el valor *"OTRA_cookie"* y redirige al inicio.

## 🛡️ Seguridad Aplicada a las Cookies

Ambas cookies se construyen utilizando la clase `ResponseCookie` de Spring y aplican buenas prácticas de seguridad web:

* `maxAge(60)`: Las cookies tienen un tiempo de vida limitado a 60 segundos, tras los cuales el navegador las elimina automáticamente.
* `httpOnly(true)`: **(Muy importante)** Impide que las cookies puedan ser leídas mediante JavaScript en el navegador del cliente, mitigando ataques de tipo XSS (Cross-Site Scripting).
* `sameSite("lax")`: Ofrece protección contra ataques CSRF (Cross-Site Request Forgery) limitando el envío de la cookie en peticiones de terceros.
* `path("/")`: Hace que la cookie esté disponible en todas las rutas de la aplicación.

## ⚙️ Cómo ejecutar el proyecto

1. Clona el repositorio.
2. Ábrelo en tu IDE favorito (VS Code, IntelliJ, Eclipse).
3. Ejecuta la clase principal `DemoCookiesApplication.java`.
4. Abre tu navegador y dirígete a `http://localhost:8080/`.
5. Abre las **Herramientas de Desarrollador (F12)** de tu navegador, ve a la pestaña **Aplicación** (o Almacenamiento), busca el apartado de **Cookies**, e interactúa con los botones de la web para ver cómo se crean en tiempo real.
