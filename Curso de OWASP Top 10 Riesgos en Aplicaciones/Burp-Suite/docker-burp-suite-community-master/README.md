# Burp Suite Community

> If you're looking for the Burp Suite Professional Docker container, look [here](https://github.com/koenrh/docker-burp-suite-pro) (separately maintained).

This allows you to run Burp Suite Community in a Docker container. This guide describes
the steps to run Burp on a Mac, but steps for Linux and Windows should be fairly similar.

## Prerequisites

- You need to have the following installed on your host:
  - [Docker](https://docs.docker.com/install/)
  - An X Server (macOS: [XQuartz](https://www.xquartz.org/))

:warning: Reboot your system after installing an X Server

## Setup

This process can be replicated on Windows or Linux with your choice of X11 server by setting it to listen on 127.0.0.1.

1. Enable `XQuartz` > `Preferences` > `Security` > [`Allow connections from network clients`](https://user-images.githubusercontent.com/8162609/121715279-4a9a3700-caa4-11eb-8205-fff0fb5dfbf6.png)
2. Start the X window server on localhost with XQuartz

```
xhost + 127.0.0.1
```

Note that you need to run this command from your host, not the XQuartz terminal.

### Windows Setup with VcXsrv

To replicate this process on Windows using VcXsrv, follow these steps:

1. **Install VcXsrv**:
   - Download and install VcXsrv from [here](https://sourceforge.net/projects/vcxsrv/).

2. **Configure and run VcXsrv**:
   - Open VcXsrv and select "Multiple windows".
   - Click "Next".
   - Select "Start no client".
   - Click "Next".
   - Check the option "Disable access control".
   - Click "Finish" to start the X11 server.

3. **Set the DISPLAY variable**:
   - Open a command prompt and run the following command to set the DISPLAY variable:
     ```sh
     setx DISPLAY 127.0.0.1:0
     ```

4. **Modify the docker-compose.yml file**:
   - Ensure your docker-compose.yml file is correctly configured:
     ```yaml
     version: '3'
     services:
       burpsuite:
         image: hexcowboy/burpsuite
         ports:
           - "8081:8080"
         environment:
           DISPLAY: <TU_DIRECCION_IP>:0
         volumes:
           - /tmp/.X11-unix:/tmp/.X11-unix
     ```

5. **Restart the Docker container**:
   - Open a command prompt and navigate to the directory where your docker-compose.yml file is located.
   - Run the following command to restart the Docker container:
     ```sh
     docker-compose up
     ```

Following these steps, you should be able to set up and run the X11 server on Windows and allow Burp Suite to connect correctly.

## Installing

### From Docker Hub

The prebuilt container can be retrieved from [Docker Hub](https://hub.docker.com/repository/docker/hexcowboy/burpsuite).

```bash
docker pull hexcowboy/burpsuite
docker image tag hexcowboy/burpsuite burpsuite
```

### Building the image

First, clone this [GitHub repository](https://github.com/hexcowboy/docker-burp-suite-community) on your host:

```bash
git clone https://github.com/hexcowboy/docker-burp-suite-community.git && cd docker-burp-suite-community
```

Then, build the Docker image using the following command.

```bash
docker build -t burpsuite .
```

While building the image, the latest JAR (Java ARchive) of Burp Suite Community is pulled from the PortSwigger portal.

## Usage

```bash
docker run --rm \
  -p 8080:8080 \
  burpsuite
```

You could make this command more easily accessible by putting it an executable,
and make sure that it is available in your `$PATH`. Alternative, you could create
wrapper functions for your `docker run` commands ([example](https://github.com/jessfraz/dotfiles/blob/master/.dockerfunc)).

### Burp Proxy

By default the container listens on port 8080 on all interfaces (see [`config/project_options.json`](config/project_options.json)).

1. Verify that the proxy is working by running the following command on your host:

```bash
curl -x http://127.0.0.1:8080 http://example.com
```

## Notes

* When prompted, do not updated Burp Suite through the GUI. Pull and build an updated image instead.
* Any changes to the `config/` files will be loaded by Burp Suite after building.

## Using Docker Compose

To simplify running Burp Suite Community, you can use Docker Compose. Create a `docker-compose.yml` file with the following content:

```yaml
version: '3'
services:
  burpsuite:
    image: hexcowboy/burpsuite
    ports:
      - "8080:8080"
    environment:
      DISPLAY: host.docker.internal:0
    volumes:
      - /tmp/.X11-unix:/tmp/.X11-unix
```

### Running with Docker Compose

Start the container using Docker Compose:

```bash
docker-compose up
```

This will start Burp Suite Community and map port 8080 on your host to port 8080 in the container.

