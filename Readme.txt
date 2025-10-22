department:
{
  "name": "Antioquia",
  "description": "Departamento de ejemplo",
  "code": "ANT"
}
municipio:
{
  "name": "Medellín",
  "description": "Municipio ejemplo",
  "code": "MDL",
  "status": 1,
  "department": {
    "id_department": 1
  }
}



gendermusci:

{
  "name": "Rock",
  "description": "Género musical rock",
  "code": "RK"
}

artist:
{
  "name": "Juan",
  "last_name": "Pérez",
  "origen_city": "Medellín",
  "code": "JP01",
  "status": 1,
  "genderMusic": { "id_genderMusic": 1 }
}

locatedevent:
{
  "name": "VPI",
  "description": "ES VIP ",
  "code": "RK"
}


event

{
  "event": {
    "name": "Feria de Música",
    "description": "Edición 2025",
    "code": 1234,
    "status": 1,
    "schedule": "10:00-22:00",
    "date_start": "2025-11-01T00:00:00Z",
    "date_end": "2025-11-02T00:00:00Z",
    "municipio": { "id_municipio": 1 }
  },
  "tickets": [
    {
      "value": 50000,
      "count": 200,
      "locatedEvent": { "id_located_event": 1 }
    }
  ],
  "artistIds": [1]
}

http://localhost:8081/api/v1/event/


registro:

endpoint: http://localhost:8081/api/v1/person/
recibe:
{
  "fullName": "Juan Pérez",
  "numberIdentification": 12345678,
  "typeIdentification": "CC",
  "email": "juan@example.com",
  "password": "Secreto123"
}

login :

endpoint: http://localhost:8081/api/v1/auth/login
recibe:
{
  "email": "juan@example.com",
  "password": "Secreto123"
}

Crear método de pago
POST http://localhost:8081/api/v1/payment-method/
json
{
  "type": "TARJETA",
  "description": "Pago con tarjeta crédito"
}

el menu dbe enviar
http://localhost:8081/api/v1/rolform/menu?roleId=2
el rol segun que tenga vinculado en user 

lo que me devuleve el back
[
    {
        "moduleName": "Gestion de artistas",
        "forms": [
            {
                "formName": "Artistas",
                "path": "/admin/artists"
            }
        ]
    },
    {
        "moduleName": "Gestion de eventos",
        "forms": [
            {
                "formName": "Gestion eventos",
                "path": "/admin/events"
            },
            {
                "formName": "Localidad eventos",
                "path": "/admin/localities"
            }
        ]
    }
]