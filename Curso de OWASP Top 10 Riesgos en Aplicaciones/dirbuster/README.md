# DirBuster

DirBuster es una herramienta de código abierto diseñada para descubrir directorios y archivos ocultos en servidores web mediante ataques de fuerza bruta. Este tutorial te guiará a través de los pasos básicos para utilizar DirBuster de manera efectiva.

## Paso 1: Descarga e Instalación de DirBuster

DirBuster generalmente se distribuye como parte de la suite Kali Linux, pero también se puede descargar por separado desde el repositorio oficial. Puedes descargarlo desde su repositorio oficial usando el comando:

```bash
git clone https://gitlab.com/kalilinux/packages/dirbuster.git
```

## Paso 2: Ejecutar DirBuster

Navega hasta el directorio donde has descargado DirBuster y ejecuta el archivo ejecutable correspondiente a tu sistema operativo. En el caso de Linux o MacOS sería el archivo:

```bash
DirBuster-1.0-RC1.sh
```

Para el caso de Windows sería el archivo:

```bash
DirBuster-1.0-RC1.bat
```

Ambos archivos ejecutan internamente el comando:

```bash
java -Xmx256M -jar DirBuster-1.0-RC1.jar
```

Por lo que necesitarás tener Java instalado y disponible en el PATH.

## Cómo utilizar DirBuster

### Paso 1: Configuración del Objetivo

En la interfaz de DirBuster, introduce la URL del sitio web que deseas escanear en el campo “URL to scan”.

### Selección de la Lista de Directorios

DirBuster utiliza una lista de directorios predeterminada para realizar ataques de fuerza bruta. Puedes seleccionar la lista predeterminada o cargar una lista personalizada si lo deseas.

### Paso 3: Ejecución del escaneo

Una vez que hayas configurado el objetivo y la lista de directorios, puedes comenzar el escaneo haciendo clic en el botón “Start Scan”. DirBuster comenzará a enumerar los directorios y archivos en el sitio web objetivo utilizando ataques de fuerza bruta.

### Paso 4: Análisis de resultados

DirBuster mostrará los resultados del escaneo en tiempo real en su interfaz. Podrás ver los directorios y archivos descubiertos, así como el estado del escaneo (por ejemplo, directorio encontrado, no encontrado, prohibido, etc.).

### Paso 5: Interpretación de los resultados

Una vez que el escaneo haya finalizado, revisa los resultados cuidadosamente para identificar posibles puntos de entrada o áreas de interés en el sitio web. Presta especial atención a los directorios y archivos que puedan contener información confidencial o vulnerabilidades de seguridad.

## 3 Consejos adicionales para usar DirBuster

1. **Personaliza las configuraciones:** Experimenta con diferentes configuraciones y opciones de DirBuster para adaptar el escaneo a tus necesidades específicas.
2. **Utiliza listas de directorios personalizadas:** Si tienes información sobre la estructura del sitio web objetivo, puedes crear listas de directorios personalizadas para aumentar la eficacia del escaneo.
3. **Ten en cuenta la legalidad y ética:** Asegúrate de tener permiso explícito para realizar pruebas de penetración en el sitio web objetivo y respeta las leyes y regulaciones locales relacionadas con la seguridad informática.

## Continúa aprendiendo sobre DirBuster

DirBuster es una herramienta poderosa para descubrir directorios y archivos ocultos en servidores web mediante ataques de fuerza bruta. Utiliza este tutorial como punto de partida para explorar las capacidades de DirBuster y mejorar tu habilidad para identificar posibles vulnerabilidades en aplicaciones web.