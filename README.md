# 🛒 Food Ordering API - Spring Boot REST Service

Este proyecto implementa un servicio RESTful en Java 21 utilizando Spring Boot para gestionar pedidos en un sistema de food delivery. Está basado en un modelo entidad-relación que cubre usuarios, direcciones, pedidos, productos y su historial.

## ✅ Tecnologías

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Spring Web
- Lombok
- H2 / MySQL (según configuración)
- Maven
- OpenAPI (Swagger UI)

## 🎯 Funcionalidad

La API permite:

### Usuarios (`/api/users`)
- Crear, obtener, actualizar y eliminar usuarios.
- Relacionar usuarios con direcciones.

### Direcciones (`/api/addresses`)
- Gestionar direcciones asociadas a usuarios.

### Productos (`/api/products`)
- CRUD completo de productos disponibles para ordenar.

### Pedidos (`/api/orders`)
- Registrar pedidos realizados por usuarios.
- Asociar productos al pedido (ítems del pedido).
- Calcular totales de pedido.
- Registrar estado del pedido con su historial.

### Historial de Pedidos (`/api/orders/history`)
- Consultar cambios de estado (ej. creado, pagado, enviado, entregado).

## 📦 Estructura del Proyecto

- `controller/`: Exposición de endpoints REST.
- `service/`: Lógica de negocio y reglas de validación.
- `repository/`: Interfaces para acceso a datos con Spring Data JPA.
- `model/`: Entidades mapeadas desde el modelo ER.
- `dto/`: Objetos de transferencia de datos para entrada/salida de la API.

## 🧪 Buenas Prácticas Implementadas

- Java 21 con records, switch mejorado y mejoras de rendimiento.
- Separación por capas (Controller, Service, Repository).
- Validaciones con `javax.validation`.
- Manejo de errores global con `@ControllerAdvice`.
- Documentación de API con Swagger/OpenAPI.
- Uso de DTOs para proteger el modelo interno.

## 📄 Diagrama Entidad-Relación

![ERD](https://code-boxx.com/wp-content/uploads/2022/12/erd-food-231028.webp)

---

**Autor:** _[Alexisfllv]_  
**Licencia:** Este proyecto está bajo la Licencia MIT. Consulta el archivo  
