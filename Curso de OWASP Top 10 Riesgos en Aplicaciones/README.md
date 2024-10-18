# Curso de OWASP Top 10 Riesgos en Aplicaciones

## Para practicar:

- [demo.owasp-juice](https://demo.owasp-juice.shop/#/)


## Preparar tus herramientas de trabajo

Para realizar tus prácticas vas a necesitar las siguientes herramientas:

- **Git**: Para descargar y estudiar el repositorio de nuestra aplicación vulnerable.
- **Editor de código**: Para estudiar el código de nuestra aplicación vulnerable, puede ser VS Code.
- **Docker**: Para ejecutar la aplicación vulnerable en contenedores aislados.
- **NodeJS**: Para ejecutar comandos de NPM en la clase de dependencias de vulnerables.
- **Burp Suite**: Como herramienta de pentesting a lo largo del curso.
- **DirBuster**: Como herramienta de pentesting para la clase de security misconfiguration.

Si nunca has utilizado estas herramientas, no te preocupes, en este curso te enseñaremos lo necesario.

## Ejecutar la aplicación vulnerable

Para realizar las diferentes prácticas del curso, necesitarás descargar y configurar la aplicación vulnerable que desarrollamos para ti. Puedes encontrar la documentación y todos los pasos necesarios en el repositorio de GitHub oficial.

Aquí te dejamos algunos tutoriales que pueden servirte:

- [Tutorial de uso e instalación para la aplicación vulnerable](https://github.com/platzi/curso-owasp-top-10)
- [Tutorial de instalación de Docker](https://platzi.com/home/clases/8781-docker-fundamentos/66589-instalacion-de-docker/)
- [Tutorial de instalación de DirBuster](https://platzi.com/blog/como-instalar-dirbuster/)
- [Tutoriales de instalación de Burp Suite: Windows, Linux, MacOS](https://platzi.com/blog/como-instalar-burp-suite-en-windows/)

Recuerda que siempre puedes compartirnos tus dudas y aportes en la sección de comentarios, estamos para ayudarte.



## Comentarios Post Instalación

### Instalación de Burp Suite en Arch Linux

Para instalar Burp Suite en una distribución basada en Arch Linux, puedes usar alguno de los siguientes comandos:

- Si usas `yay` como gestor de paquetes:
    ```sh
    yay -S burpsuite
    ```
    Selecciona la opción de Burp Suite normal.

- Si usas `pamac` como gestor de paquetes:
    ```sh
    sudo pamac install burpsuite
    ```

### Tips para Configuración en macOS 13.6.4

#### Paso 2: Agregar Alias en Sistemas UNIX (MacOS y Linux)

Puedes hacerlo desde la terminal, utilizando el comando:
```sh
sudo nano /etc/hosts
```
para editar con permisos de administrador.

#### Paso 3: Agregar Certificado CA al Navegador (Chrome)

Basado en [este video](https://www.youtube.com/watch?v=UMTDX79sz34):

1. Cuando llegues a la sección "Administrar certificados", se abrirá "Keychain Access".
2. Arrastra el certificado `RootCA.crt` a la pestaña "System".
3. Haz clic derecho en el certificado, selecciona "Get info/Trust", y en la sección "When using this certificate", elige "Always Trust".

### Cambiar al Modo Oscuro en Burp Suite

Hay dos formas de cambiar al modo oscuro:

1. Dirígete al menú superior de Burp: `Settings > User > User interface > Display`. En la ventana derecha, en la sección de "Appearance", encontrarás la opción para activar el modo oscuro.
2. Accede directamente a las configuraciones desde el icono de ajustes en la esquina superior derecha. Repite el camino del punto uno: `User > User interface > Display`. En la ventana derecha, en la sección "Appearance", encontrarás la opción para el modo oscuro.

### Uso de UTM para Virtualizar Kali Linux

Es mejor usar UTM y virtualizar Kali Linux ahí, ya que tendrás todas las herramientas por defecto. No uses la última versión de Kali porque puede traer problemas, y tampoco uses Parrot, ya que no tiene las herramientas necesarias. Tendrás que descargarlas casi todas y varias pueden dar problemas, especialmente cuando quieras empezar con directorio activo.
