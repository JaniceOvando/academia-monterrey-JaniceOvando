# Concepto 2: Spring Security (HTTP Basic, JWT, OAuth2)

## 1. ¿Qué es y qué problema resuelve?
Spring Security protege la aplicación web o API de accesos no autorizados. Resuelve el problema de que cualquier persona pueda leer o modificar datos sensibles si no hay autenticación.

## 2. ¿Dónde se ve en mi código?
- **HTTP Basic**: En la configuración de seguridad (`SecurityConfig.java`), se define que ciertos endpoints requieren autenticación básica.
- **JWT (JSON Web Token)**:
    - Endpoint `/auth/login`: Recibe usuario y contraseña, y devuelve un token JWT si son correctos.
    - Filtro `JwtAuthenticationFilter`: Intercepta cada petición para validar el token.
    - Endpoints protegidos (ej. `/api/tasks`, `/api/projects`): Solo aceptan peticiones con un token válido.
- **OAuth2**: (Si lo tienes) Configuración para autenticar con proveedores externos (Google, GitHub).
- **BCrypt**: Uso de `BCryptPasswordEncoder` en el servicio de usuarios para encriptar las contraseñas antes de guardarlas en la base de datos.

## 3. ¿Qué pasa si no lo uso?
- **Sin Security**: Cualquiera podría acceder a `http://localhost:8080/api/tasks` sin credenciales y ver o borrar todas las tareas.
- **Sin BCrypt**: Las contraseñas se guardarían en texto plano en la base de datos. Si alguien roba la BD, tendría todas las contraseñas.
- **Sin JWT**: No habría forma de mantener una sesión segura y escalable sin guardar estado en el servidor.

## 4. ¿Qué pasa si el token es inválido o falta?
- El servidor responde con **401 Unauthorized** (No autorizado).
- En Swagger UI, verás que al intentar llamar a un endpoint protegido sin token, la petición falla.

## 5. Cómo correrlo
1. Abre la terminal en la carpeta `02-spring-security/taskflow-api`.
2. Ejecuta: `docker compose up`.
3. Abre el navegador en `http://localhost:8080/swagger-ui/index.html`.
4. Prueba el endpoint `/auth/login` para obtener un token.
5. Usa el botón "Authorize" en Swagger para pegar el token y probar endpoints protegidos.
6. Intenta llamar a un endpoint protegido sin token: deberías ver un error 401.