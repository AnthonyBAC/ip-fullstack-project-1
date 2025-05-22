# Microservicios - Sistema de Gestión de Flota

## 1. gestionarUsuarios()

**Responsabilidad**: Administrar usuarios del sistema. Relaciona con: AUTH, gestionarClientes(), gestionarFlota()

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

## 2. gestionarClientes()

**Responsabilidad**: Gestionar clientes de la empresa. Relaciona con: gestionarCarga(), gestionarRuta()

### Model

- Empresa (id_emp, nombre_emp, rut_emp, dv_emp, dir_emp)
- Cliente (id_cli, nombre_cli, apellido_cli, run_cli, dv_cli, origen_cli, destino_cli, tel_cli)

### Repository

- ClienteRepository CRUD
- EmpresaRepository CRUD

### Service

- EmpresaService (CRUD + obtenerClientesPorEmpresa)
- ClienteService

### Controller

Nombre Controller: ClienteController

- POST /empresa
- GET /empresa/{id_emp}
- PUT /empresa/{id_emp}
- DELETE /empresa/{id_emp}
- GET /empresa/clientes/{id_cli}

---

## 3. gestionarCarga()

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

Nombre Controller: CargaController

- POST /cargas
- GET /cargas/{id_carga}
- PUT /cargas/{id_carga}
- DELETE /cargas/{id_carga}

Nombre Controller: GuiaClienteController

- POST /guias-cliente
- GET /guias-cliente/{id_guia}

---

## 4. gestionarRuta()

**Responsabilidad**: Crear, asignar y calcular rutas. Relaciona con: gestionarCarga(), gestionarFlota()

### Model

- Ruta (origen, destino, distancia_km, tiempo_estimado)
- Parada (id_ruta, ubicación, orden)

### Repository

- RutaRepository
- ParadaRepository

### Service

- RutaService (crearRuta, actualizarRuta, eliminarRuta)

### Controller

Nombre Controller: RutaController

- POST /rutas
- GET /rutas/{id_ruta}
- PUT /rutas/{id_ruta}
- DELETE /rutas/{id_ruta}

---

## 5. gestionarFlota()

**Responsabilidad**: Registro y asignación de vehículos, se relacion con: conductor y sistema

### Model

- Vehiculo (id, patente, estado, km_actual)
- AsignacionVehiculo (id, id_conductor, id_vehiculo, fecha_asignacion)

### Repository

- VehiculoRepository, AsignacionVehiculoRepository

### Service

- VehiculoService (crear, editar, eliminar vehiculo)
- AsignacionVehiculoService (crear, editar, eliminar asignacion)

### Controller

Nombre Controller: gestionarFlotaController

- POST /vehiculos
- GET /vehiculos/{id}
- PUT /vehiculos/{id}
- DELETE /vehiculos/{id}

---

## 6. iniciarViaje()

**Responsabilidad**: Iniciar un viaje.

### Model

- iniciarViaje (id_viaje, hora_inicio, km_actual, id_conductor, id_vehiculo)

### Repository

- iniciarViajeRepository

### Service

- iniciarViaje(id_conductor)

### Controller

Nombre Controller: iniciarViajeController

- POST /viaje/iniciar/{id_conductor}

---

## 7. terminarViaje()

**Responsabilidad**: Finalizar un viaje.

### Model

- terminarViaje (id_viaje, hora_termino, km_final, id_conductor, id_vehiculo)

### Repository

- terminarViajeRepository

### Service

- terminarViaje(id_conductor)

### Controller

Nombre Controller: terminarViajeController

- POST /viaje/terminar/{id_conductor}

---

## 8. cargaEntregada()

**Responsabilidad**: Entrega de una carga.

### Model

- estadoCarga (id, estado, id_conductor, id_viaje)

### Repository

- estadoCargaRepository

### Service

- estadoCargaService (registrarEntrega(id_conductor, id_viaje))

### Controller

Nombre Controller: estadoCargaController

- POST /cargas/{id}/cargaentregada

---

## 9. enviarNotificacion()

**Responsabilidad**: Enviar notificaciones.

### Model

- Notificacion (id_notificacion, hora_notificacion, mensaje_notificacion, id_usuario, estado_notificacion)

### Repository

- NotificacionRepository

### Service

- NotificacionService
  - enviarNotificacion(id_usuario)
  - estadoNotificacion(id_notificacion)

### Controller

Nombre Controller: NotificacionController

- POST /notificaciones
- GET /notificaciones/{id_notificacion}
- DELETE /notificaciones/{id_notificacion}

---

## 10. crearReporte()

**Responsabilidad**: Crear reportes.

### Model

- reporte (id_reporte, nombre_cliente, apellido_cliente, nombre_empresa, rut_empresa, nombre_conductor, hora_reporte, fecha_reporte, patente_vehiculo, observacion, id_viaje, estado_carga)

### Repository

- reporteRepository

### Service

- ReporteService (generarReporte()) hacer validaciones y llamar microservicios
- listarReportes()

### Controller

Nombre Controller: SistemaController

- POST /reportes
- GET /reportes/{id_reporte}
