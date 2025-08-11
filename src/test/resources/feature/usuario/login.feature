@CINEPERU @LOGIN @REGRESION
Feature: Inicio de sesión del usuario mediante correo y contraseña

  @E01 @LOGIN @HAPPYPATH @REGRESION
  Scenario Outline: TC - Login con valores validos
    Given que USUARIO llama al API
    When ejecuta el API login con correo <correo>, contraseña <contrasenia>
    Then valido el codigo de respuesta sea 200
    Examples:
      | correo             | contrasenia |
      | user@cineperu.com  | user123     |
      | admin@cineperu.com | admin123    |

  @E02 @LOGIN @UNHAPPYPATH @REGRESION
  Scenario Outline: TC - Login con valores invalidos
    Given que USUARIO llama al API
    When ejecuta el API login con correo <correo>, contraseña <contrasenia>
    Then valido el codigo de respuesta sea 400
    And valido mensaje de error sea <mensaje>
    Examples:
      | correo               | contrasenia | mensaje                            |
      | user000@cineperu.com | 000000Abc   | Credenciales inválidas             |
      | admin@cineperu.com   | 1ncorrectO  | Credenciales inválidas             |
      | user@cineperu.com    |             | Correo y contraseña son requeridos |
      |                      | user123     | Correo y contraseña son requeridos |