@CINEPERU @SIGNUP @REGRESION
Feature: Registro de usuario en CinePeru

  @E01 @SIGNUP @HAPPYPATH @REGRESION
  Scenario Outline: TC - Registro con valores validos
    Given que USUARIO llama al API
    And obtengo datos dinamicos para nombre, apellido, correo con contraseña <contrasenia>
    When ejecuta el API registrar con los datos dinamico
    Then valido el codigo de respuesta sea 201
    Examples:
      | contrasenia |
      | 123456789   |
      | abcd1234    |
      | SaltaLaRana |
      | C@tIsSad    |

#OBSERVACIÓN
  # Registra con 1 digito de contraseña
  # Registra sin validar formato de correo
  @E02 @SIGNUP @UNHAPPYPATH @REGRESION
  Scenario Outline: TC - Registro con valores invalidos
    Given que USUARIO llama al API
    When ejecuta el API registrar con <nombre>,<apellido>, <correo>, <contrasenia>
    Then valido el codigo de respuesta sea <codigo>
    And valido mensaje sea <mensaje>
    Examples:
      | nombre | apellido | correo            | contrasenia | codigo | mensaje                      |
      | Jorge  | Nuñez    | user@cineperu.com | user123     | 409    | El correo ya está registrado |
      | Juan   | Pérez    | juan@example.com  |             | 400    | Faltan datos requeridos      |
      | Nataly | Rojas    |                   | 1345678     | 400    | Faltan datos requeridos      |
      |        | Torres   | juan@example.com  | 1345678     | 400    | Faltan datos requeridos      |
      | Jazmin |          | user@cineperu.com | user123     | 400    | Faltan datos requeridos      |

