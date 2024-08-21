Práctica Módulos
# Última Práctica

En esta última práctica vas a utilizar la mayoría de lo que has visto durante el curso. Tienes que desplegar una instancia dentro de una subnet con los siguientes parámetros:

## VPC:

- Nombre: vpc_module1
- CIDR: 19.82.0.0/16

## Subnet:

- Debe pertenecer al VPC vpc_module1
- AZ: eu-north-1a
- CIDR Subnet: 19.82.1.0/24
- Nombre Subnet: Subnet1a

## Interfaz de red:

- Debe pertenecer a la subnet Subnet1a
- Nombre: primary_network_interface
- IPs Privadas: 19.82.1.82

## Instancia:

- AMI: Amazon Linux 2
- Tipo: t3.micro
- Interfaz: <la que se crea en el apartado de Interfaz de red>
- Nombre: EC2 name from Module

Debes usar dos módulos, uno para la configuración de red (VPC, Subnet e Interfaz de red), llamado vpc; y el otro módulo es para la configuración de la instancia, llamado ec2.

Seguramente los recursos de esta lección te ayuden bastante, ¡ánimo que es la última práctica!

Recursos de esta clase:

- [Terraform Language Modules](https://developer.hashicorp.com/terraform/language/modules)
- [Developing Terraform Modules](https://developer.hashicorp.com/terraform/language/modules/develop)
- [Module Sources](https://developer.hashicorp.com/terraform/language/modules/sources)
- [Registry: Consul Module for AWS](https://registry.terraform.io/modules/hashicorp/consul/aws/latest)
- [Instance Network and Credit Specification Example](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/resources/instance#network-and-credit-specification-example)



Comandos:
terraform init
terraform plan
terraform apply -auto-approve
terraform destroy -auto-aprrove