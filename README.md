# Bounded Context

## Nota

Los id auto generados se heredan del `AuditableAbstractAggregateRoot` de la carpeta `shared`.

## Safety Standards

- Bounded Context: `regulations`
- No auditable

### Atributos

- `id` (Long, Primary Key, Autogenerado)
- `infrastructureType` (String, obligatorio, no vacío)
- `parameter` (String, obligatorio)
- `minAcceptableValue` (Double, obligatorio)
- `maxAcceptableValue` (Double, obligatorio)

### Nota

Requiere que su información sea poblada en la base de datos de forma automática asociada al ApplicationReady event.

| `id` | `infrastructureType` | `parameter`     | `minAcceptableValue` | `maxAcceptableValue` |
| ---- | -------------------- | --------------- | -------------------- | -------------------- |
| 1    | TRACK                | rail_alignment  | -2.0                 | 2.0                  |
| 2    | TRACK                | gauge_width     | 1433                 | 1437                 |
| 3    | SWITCH               | point_position  | 0.0                  | 5                    |
| 4    | BRIDGE               | vibration_level | 0.0                  | 1.5                  |

## Inspection Records

- Bounded Context: `inspections`
- Auditable, por ende tiene los atributos `createdAt` y `updatedAt`

### Atributos

- `id` (Long, Primary Key, Autogenerado)
- `vehicleCode` (identificador del negocio, embedded type Obligatorio, No vacío, solo puede contener un valor UUID válido)
- `infrastructureType` (String, obligatorio, no vacío)
- `parameter` (String, obligatorio, no vacío), measuredValue (Double, obligatorio)
- `state` (InspectionState enumeration, obligatorio, no nulo)
- `inspectedAt` (LocalDateTime, obligatorio, no nulo)

### Nota

Especifica que al momento de registrar un inspection record, si el `measuredValue` está fuera del rango aceptable para el `parámetro`, la inspección se registra normalmente, pero se debe emitir un evento `MaintenanceTaskRequiredEvent`.

## Maintenance Tasks

- Bounded Context: `monitoring`
- Auditable, por ende tiene los atributos `createdAt` y `updatedAt`

### Atributos

- `id` (Long, Primary Key, autogenerado)
- `vehicleCode` (identificador del negocio, embedded type obligatorio, no vacío, solo puede contener un valor UUID válido)
- `parameter` (String, obligatorio, no vacío)
- `description` (String, obligatorio, no vacío)
- `priority` (TaskPriority enumeration, obligatorio, no nulo)
- `dueDate` (LocalDate, obligatorio, no nulo)
- `state` (TaskState enumeration, obligatorio, no nulo)

# Business Rules

- Especifica que el atributo `vehicleCode` debe ser embedded y solo puede contener un valor UUID válido, que debe proporcionarse (no autogenerarse) al momento de registrarse el inspection record.
- Especifica que `vehicleCode` se considera un identificador interno del negocio.
- No se debe registrar en la base de datos dos inspection records con el mismo valor de `vehicleCode` en el mismo día.
- Requiere que el valor de `inspectedAt` no sea mayor que la fecha actual.

# Domain Events

## MaintenanceTaskRequiredEvent

El evento debe registrar una maintenance task para el `vehicleCode`, con `HIGH` como `priority` **si el desvío es >10% del rango permitido**, caso contrario `MEDIUM` como `priority`, `inspectedAt` + 3 días como `dueDate` y `OPEN` como `state`.

# Casos de prueba

# Endpoints

## Inspection Records Endpoint `(/api/v1/inspection-records)`

- Implementar una operación `POST`
- El id es autogenerado
- `vehicleCode` se proporciona como String y debe convertirse a un UUID válido.
- Debe retornar un `201`
- Incluir en la response el id generado y los demás atributos, menos los de auditoría.

## Maintenance Tasks Endpoint `(/api/v1/maintenance-tasks)`

- Implementar una operación `GET`
- Retornar un `200`
- Incluir en la response todos los atributos, menos los de auditoría.
