# Microservicios - Sistema de Gestión de Flota

- Este documento presenta una arquitectura basada en microservicios para nuestro sistema Gestión de Flota, diseñado para facilitar la administración y escalabilidad de los distintos procesos operativos.

- Cada microservicio está orientado a una responsabilidad única y específica, lo que permite una mayor organización y control del sistema. Este enfoque modular facilita la gestión y el control de clientes, vehículos, rutas, entradas y salidas de vehículos, usuarios y reportes.

- A través de la división funcional en microservicios, se mejora el mantenimiento y se permite escalar de forma independiente cada componente, adaptándose a las necesidades del negocio con mayor flexibilidad.

- A continuación, se presentan los microservicios implementados, junto con sus responsabilidades, modelos principales y el puerto asignado para cada uno. Estos puertos son únicos por servicio, lo que facilita la realización de pruebas organizadas e independientes mediante herramientas como Postman.

- Cabe destacar que cada microservicio está conectado a una base de datos mediante Oracle, lo cual permite iniciar el proceso de pruebas de forma efectiva desde Postman.

---

## Puertos de Microservicios

- microservicioVehiculo = 8080
- microservicio-Ruta = 8081
- microservicio-ReporteGeneral = 8082
- microservicio-GestionUsuario = 8083
- microservicio-GestionSalida = 8084
- microservicio-GestionPago = 8085
- microservicio-gestionEntrada = 8086
- microservicio-GestionCarga = 8087
- microservicio-Empresa = 8088
- microservicio-clientes = 8089

---

## 1. gestionUsuario()

**Responsabilidad**: Administrar usuarios del sistema.

### Model

- Usuario (id_usuario, nombre, email, contraseña, id_rol)
- Rol (id_rol, nombre_rol)

### Repository

- UsuarioRepository
- RolRepository

### Service

- UsuarioService (crearUsuario, actualizarUsuario, eliminarUsuario, listarPorRol)
- AuthService (login, validación, generación de tokens)

### Controller

Nombre Controller: UsuarioController

- POST /usuarios
- GET /usuarios/{id}
- PUT /usuarios/{id}
- DELETE /usuarios/{id}
- GET /usuarios?rol=ADMIN

---

## 2. gestionarCliente()

**Responsabilidad**: Gestionar clientes de la empresa. Relaciona con: gestionarCarga(), gestionarRuta()

### Model

- Cliente (id_cli, nombre_cli, apellido_cli, run_cli, dv_cli, origen_cli, destino_cli, tel_cli)

### Repository

- ClienteRepository CRUD

### Service

- ClienteService

### Controller

ClienteController api/v1/clientes

- GET /clientes: obtener todos los clientes
- GET /clientes/{id_cli}: obtener cliente específico
- POST /clientes: crear cliente
- PUT /clientes/{id_cli}: actualizar cliente
- DELETE /clientes/{id_cli}: eliminar cliente

---

## 3. Empresa()

**Responsabilidad**: Gestionar clientes de la empresa.

### Model

- Empresa (id_emp, nombre_emp, rut_emp, dv_emp, dir_emp)

### Repository

- EmpresaRepository CRUD

### Service

- EmpresaService (CRUD + obtenerClientesPorEmpresa)

### Controller

EmpresaController api/v1/empresa

- GET /empresa: listar todas las empresas
- GET /empresa/{id_emp}: obtener una empresa por ID
- POST /empresa: crear empresa
- PUT /empresa/{id_emp}: actualizar empresa
- DELETE /empresa/{id_emp}: eliminar empresa

---

## 4. gestionarCarga()

**Responsabilidad**: Administración de cargas y guías de despacho. Relaciona con: gestionarRuta(), Conductor

### Model

- Carga (id, descripcion)
- GuiaCliente (id, id_cliente, id_ruta, id_carga)

### Repository

- CargaRepository
- GuiaClienteRepository

### Service

- CargaService (crearCarga, actualizar, eliminar, cambiarEstado)
- GuiaClienteService (crearGuia, consultarGuia)

### Controller

CargaController api/v1/carga

- POST /carga
- GET /carga/{id_carga}
- PUT /carga/{id_carga}
- DELETE /carga/{id_carga}

GuiaClienteController api/v1/guiacliente

- POST /guiacliente
- GET /guiacliente/{id_guia}

---

## 5. Ruta()

**Responsabilidad**: Crear, asignar y calcular rutas.

### Model

- Ruta (origen, destino, distancia_km, tiempo_estimado)

### Repository

- RutaRepository

### Service

- RutaService (crearRuta, actualizarRuta, eliminarRuta)

### Controller

RutaController api/v1/ruta

- POST /ruta
- GET /ruta/{id_ruta}
- PUT /ruta/{id_ruta}
- DELETE /ruta/{id_ruta}

---

## 6. gestionEntrada()

**Responsabilidad**: Iniciar un viaje.

### Model

- iniciarViaje (id_viaje, hora_inicio, km_actual, id_conductor, id_vehiculo)

### Repository

- iniciarViajeRepository

### Service

- iniciarViaje(id_conductor)

### Controller

iniciarViajeController api/v1/viaje/iniciar/{id_conductor}

- POST /viaje/iniciar/{id_conductor}

---

## 7. gestionSalida()

**Responsabilidad**: Finalizar un viaje.

### Model

- terminarViaje (id_viaje, hora_termino, km_final, id_conductor, id_vehiculo)

### Repository

- terminarViajeRepository

### Service

- terminarViaje(id_conductor)

### Controller

terminarViajeController api/v1/viaje/terminar/{id_conductor}

- POST /viaje/terminar/{id_conductor}

---

## 8. gestionPago()

**Responsabilidad**: Revision de pago

### Model

- egestionPago

### Repository

- gestionPagoRepository

### Service

- gestionPagoService

### Controller

estadoCargaController api/v1/pago

- POST /pagos
- GET /pagos
- Get /pagos/{id}
- Put /pagos/{id}
- Delete /pagos/{id}

---

## 9. Vehiculo()

**Responsabilidad**: Aisgnacion de vehiculos

### Model

- vehiculo{iid, patente, estado, km_actual}

### Repository

- vehiculoRepository{obtener, guardar,eliminar buscarporId, actualizar}

### Service

- Service {vehiculoRepository}

### Controller

VehiculoController api/v1/vehiculos

- POST /vehiculos
- GET /vehiculos
- Put /vehiculos/{id}
- Eliminar /vehiculos/{id}

---

## 10. reporteGeneral()

**Responsabilidad**: Crear reportes.

### Model

- reporte (id_reporte, nombre_cliente, apellido_cliente, nombre_empresa, rut_empresa, nombre_conductor, hora_reporte, fecha_reporte, patente_vehiculo, observacion, id_viaje, estado_carga)

### Repository

- reporteRepository

### Service

- ReporteService (generarReporte()) hacer validaciones y llamar microservicios
- listarReportes()

### Controller

SistemaController api/v1/reportes

- POST /reportes
- GET /reportes/{id_reporte}
