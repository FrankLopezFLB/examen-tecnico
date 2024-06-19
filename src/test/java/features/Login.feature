# language: es
@escenario-login
Característica: Login User

  @caso-1
  Esquema del escenario: Validar que el correcto flujo de Login
    Dado que el usuario ingresa al aplicativo
    Cuando el "<user>" ingresa en el modal de Login
    Y ingresa la contrasena "<pass>" en el modal de Login
    Entonces se motrara "Welcome frank19921" en el menu
    Ejemplos:
      | user       | pass       |
      | frank19921 | frank19921 |