@CINEPERU @RECUPERAR-CONTRASEÑA @REGRESION
Feature: Recuperación de contraseña del usuario

  @E01 @RECUPERAR-CONTRASEÑA @HAPPYPATH @REGRESION
  Scenario Outline: TC - Recuperar contraseña con valores validos
    Given que USUARIO llama al API
    When ejecuta el API recuperar contraseña con <correo>, <contrasenia1>, <contrasenia2>
    Then valido el codigo de respuesta sea 200
    And valido mensaje sea <mensaje>
    Examples:
      | correo                | contrasenia1  | contrasenia2  | mensaje                              |
      | usertest@cineperu.com | nuevaClave123 | nuevaClave123 | Contraseña actualizada correctamente |
      | usertest@cineperu.com | 123456789     | 123456789     | Contraseña actualizada correctamente |

  @E02 @RECUPERAR-CONTRASEÑA @UNHAPPYPATH @REGRESION
  Scenario Outline: TC - Recuperar contraseña con valores invalidos
    Given que USUARIO llama al API
    When ejecuta el API recuperar contraseña con <correo>, <contrasenia1>, <contrasenia2>
    Then valido el codigo de respuesta sea <codigo>
    And valido mensaje de error sea <mensaje>
    Examples:
      | correo                   | contrasenia1  | contrasenia2   | codigo | mensaje                                              |
      |                          | 123456789     | 123456789      | 400    | Correo, nueva contraseña y repetición son requeridos |
      | usertest@cineperu.com    |               | 123456789      | 400    | Correo, nueva contraseña y repetición son requeridos |
      | usertest@cineperu.com    | 123456789     |                | 400    | Correo, nueva contraseña y repetición son requeridos |
      | usertest@cineperu.com    | nuevaClave123 | ElGatoConBotas | 400    | Las contraseñas no coinciden                         |
      | usertest123@cineperu.com | user123       | user123        | 404    | Usuario no encontrado                                |