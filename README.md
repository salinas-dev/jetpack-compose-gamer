
# APP JETPACK COMPOSE EN KOTLIN CON AUTENTIFICACIÓN FIRESBASE

#### Estructura del Proyecto:

La aplicación está organizada en paquetes como core, data, domain, di (Dagger Hilt), y presentation. Esto ayuda a mantener un código limpio y modular.

#### Constants:

Esto es para gestionar valores que se utilizan en múltiples lugares, como nombres de colecciones en Firebase.

#### AuthRepositoryImpl:

Aquí se ha implementado la lógica para interactuar con la autenticación de Firebase. Hay funciones para iniciar sesión, registrarse, obtener el usuario actual y cerrar sesión.
Se utiliza la biblioteca kotlinx.coroutines para realizar operaciones asíncronas de manera más eficiente en un hilo separado.

#### PostsRepositoryImpl:

Este repositorio se encarga de la manipulación de datos relacionados con las publicaciones (posts). Se utiliza Firestore para almacenar los posts y Storage para manejar las imágenes asociadas.
La función getPosts utiliza un flujo (Flow) y un callbackFlow para emitir actualizaciones en tiempo real cuando hay cambios en los posts.

####UsersRepositoryImpl:

Similar al PostsRepositoryImpl, este repositorio se ocupa de las operaciones relacionadas con los usuarios. Se almacenan datos de usuario en Firestore y se gestionan las imágenes en Storage.

#### Dagger Hilt (di):

Dagger Hilt se utiliza para la inyección de dependencias, facilitando la creación y administración de instancias de clases en toda la aplicación.
Los módulos AppModule definen las dependencias necesarias, como las instancias de Firebase, las referencias a las colecciones y almacenamientos, y los repositorios.

#### Use Cases:

Se han creado casos de uso en el dominio, que actúan como una capa intermedia entre la interfaz de usuario y los repositorios. Esto ayuda a mantener una separación clara entre la lógica de presentación y la lógica de negocio.

#### Modelos de Datos:

La clase Post y User en el paquete domain.model representan los datos de las publicaciones y usuarios respectivamente. Estos modelos se utilizan para interactuar con Firebase y para la comunicación entre capas.

#### Presentación (UI):

La actividad principal (MainActivity) establece el tema de la aplicación y configura la estructura de navegación a través de NavHostController.
La interfaz de usuario aún no está detallada en el código proporcionado, pero se mencionan funciones de composición (Composable) que probablemente estén destinadas a construir la IU.
## 🛠 Skills
Kotlin, Android Studio, Firebase...


## Aplicación Android:

#### Menu principal
![App Screenshot](https://i.ibb.co/ZLh9Bgz/Captura-de-pantalla-2024-02-01-170937.png)

## 
El menu principal se conforma por card que contienen los detalles del videojuego.
Tambien un icono para dar like.

#### Crear nuevo post
![App Screenshot](https://i.ibb.co/wMpVXSm/Captura-de-pantalla-2024-02-01-171010.png)

## 
La creacion de un nuevo post contiene la parte de la imagen, nombre, descripción y categorias del juego.

#### Visualizar post
![App Screenshot](https://i.ibb.co/NCM7MP1/Captura-de-pantalla-2024-02-01-170950.png)

## 
Aqui se muestran todos los detalles del pots.

#### Cerrar sesión
![App Screenshot](https://i.ibb.co/0YGHyFs/Captura-de-pantalla-2024-02-01-171023.png)

## 
Se presentan dos opciones cerrar sesion y editar datos.

#### Actualizar perfil
![App Screenshot](https://i.ibb.co/SXT6zkt/Captura-de-pantalla-2024-02-01-171047.png)

## 
Solo se actualiza nombre e imagen.
