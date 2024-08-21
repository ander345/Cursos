# Práctica VPC

Es hora de practicar a fondo los conceptos que hemos visto hasta el momento. Para ello, vamos a usar otros recursos distintos a `aws_instance` para probarnos a nosotros mismos.

## Crear un VPC

Con los siguientes datos:

- **Región:** `eu-north-1`
- **Nombre:** `vpc_practice1`
- **CIDR Block:** `192.168.0.0/16`

## Crear una Subnet

En este mismo VPC, con estos parámetros:

- **Nombre:** `Subnet1a`
- **Zona de disponibilidad:** `eu-north-1a`
- **CIDR Block:** `192.168.1.0/24`


Documentacion de terraform: [resorce: aws_vpc](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/resources/vpc)

Documentación de terraform subnet: [Resource: aws_subnet](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/resources/subnet)