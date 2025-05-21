# Microservicios - Sistema de Gestión de Flota

## 1. gestionarUsuarios()

**Responsabilidad**: Administrar usuarios del sistema. Relaciona con: AUTH, gestionarClientes(), gestionarFlota()

### Model

Usuario (id, nombre, email, contraseña, rol_id)
Rol (id, nombre)
Permiso (id, tipo, descripcion)

### Repository

UsuarioRepository
RolRepository
PermisoRepository

### Service

UsuarioService (crearUsuario, actualizarUsuario, eliminarUsuario, listarPorRol)
AuthService (login, validación, generación de tokens)

### Controller

UsuarioController
POST /usuarios
GET /usuarios/{id}
PUT /usuarios/{id}
DELETE /usuarios/{id}
GET /usuarios?rol=ADMIN

---

## 2. gestionarClientes()

**Responsabilidad**: Gestionar clientes de la empresa. Relaciona con: gestionarCarga(), gestionarRuta()

### Model

Cliente (id, nombre, apellido, run, dv, origen, destino)
Empresa (id, nombre, rut, dirección)

### Repository

ClienteRepository
EmpresaRepository

### Service

ClienteService (CRUD + obtenerClientesPorEmpresa)
EmpresaService

### Controller

Nombre Controller: ClienteController
POST /clientes
GET /clientes/{id}
PUT /clientes/{id}
DELETE /clientes/{id}
GET /clientes/empresa/{id}

---

## 3. gestionarCarga()

**Responsabilidad**: Administración de cargas y guías de despacho. Relaciona con: gestionarRuta(), Conductor

### Model

Carga (id, descripcion, peso, volumen, estado)
GuiaCliente (id, cliente_id, ruta_id, carga_id, pago_recibido, fecha_envio)
EstadoCarga (id, estado)

### Repository

CargaRepository
GuiaClienteRepository

### Service

CargaService (crearCarga, actualizar, eliminar, cambiarEstado)
GuiaClienteService (crearGuia, consultarGuia)

### Controller

Nombre Controller: CargaController
POST /cargas
GET /cargas/{id}
PUT /cargas/{id}
DELETE /cargas/{id}
GuiaClienteController
POST /guias-cliente
GET /guias-cliente/{id}

---

## 4. gestionarRuta()

**Responsabilidad**: Crear, asignar y calcular rutas. Relaciona con: gestionarCarga(), gestionarFlota()

### Model

Ruta (id, origen, destino, distancia_km, tiempo_estimado)
Parada (id, ruta_id, ubicación, orden)
TarifaRuta (id, ruta_id, precio)

### Repository

RutaRepository
ParadaRepository
TarifaRutaRepository

### Service

RutaService (crearRuta, calcularTarifa, actualizarRuta, eliminarRuta)

### Controller

Nombre Controller: RutaController
POST /rutas
GET /rutas/{id}
PUT /rutas/{id}
DELETE /rutas/{id}
POST /rutas/calcular-costo

---

## 5. gestionarEmpresa()

**Responsabilidad**: Información y configuración de la empresa.

### Model

Empresa (id, nombre_empresa, rut_empresa, direccion_empresa)

### Repository

EmpresaRepository

### Service

EmpresaService (crear, editar, eliminar empresa)

### Controller

Nombre Controller: EmpresaController
POST /empresa
GET /empresa/{id}
PUT /empresa/{id}
DELETE /empresa/{id}

---

## 6. gestionarUsuarios() (ADMIN)

**Responsabilidad**: CRUD de usuarios internos del sistema (Administrador, Coordinador, Supervisor).

### Model

Administrador (id, nombre, telefono)

### Repository

AdministradorRepository

### Service

AdministradorService (crear, actualizar, leer, eliminar)

### Controller

Nombre Controller: AdministradorController
POST /admin
GET /admin/{id}
PUT /admin/{id}
DELETE /admin/{id}

---

## 7. auth

**Responsabilidad**: Login, registro, tokens JWT.

### Model

Usuario, Rol, Token

### Repository

UsuarioRepository, TokenRepository

### Service

AuthService (login, logout, refreshToken)

### Controller

Nombre Controller: AuthController
POST /auth/login
POST /auth/logout

---

## 8. Conductor

**Responsabilidad**: Acciones del conductor.

### Model

ReporteRuta (id, conductor_id, ruta_id, fecha, observaciones)
EstadoViaje (id, estado, hora_inicio, hora_termino)

### Repository

ReporteRutaRepository

### Service

ViajeService (iniciarViaje, terminarViaje, productoEntregado)
ReporteRutaService

### Controller

Nombre Controller: ConductorActionsController
POST /viaje/iniciar
POST /viaje/terminar
POST /producto/entregado
POST /reporte/generar

---

## 9. vehiculo

**Responsabilidad**: Registro y asignación de vehículos.

### Model

Vehiculo (id, patente, tipo, capacidad, estado)
AsignacionVehiculo (id, conductor_id, vehiculo_id, fecha_asignacion)

### Repository

VehiculoRepository, AsignacionVehiculoRepository

### Service

VehiculoService, AsignacionVehiculoService

### Controller

Nombre Controller: VehiculoController
POST /vehiculos
GET /vehiculos/{id}
PUT /vehiculos/{id}
DELETE /vehiculos/{id}

---

## 10. Sistema

**Responsabilidad**: Enviar notificaciones, crear reportes.

### Model

Notificacion (id, tipo, mensaje, usuario_id, leido)
Informe (id, tipo, fecha, contenido, generado_por)

### Repository

NotificacionRepository, InformeRepository

### Service

NotificacionService, InformeService

### Controller

Nombre Controller: SistemaController
POST /notificaciones
POST /informes
GET /informes/{id}
