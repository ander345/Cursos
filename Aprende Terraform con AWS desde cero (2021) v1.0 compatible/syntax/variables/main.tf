provider "aws" {
  region = "us-west-2"
}

//1
variable "flavor" {
  type    = string
  default = "t3.micro"
}

//2
/*
declarar comando por comando:
variable "flavor" {
  type    = string
}

#por consola escribios:
#terraform apply -var="flavor=t3.micro"
*/

//3
/*
otra manera es en otro fichero y ejecutamos terraform plan
*/

//4
/* 
hay otra manera es creando otro archivo para crear los valores de las variables
*/

//5
/*
la ultima forma es pasarle el fichero de variables.auto.tfvars
terraform plan -var-file variables.auto.tfvars
*/

//6
/*
input variables
si no se agrega el valor de la variable cuando ejecutamos el nos pedira el valor
*/



// el ami y instance estan en EC2
resource "aws_instance" "instance1" {
  #ami           = "ami-0c55b159cbfafe1f0"
  ami          = var.amis.amazon
  instance_type = var.flavor

  tags = {
    Name = "first_instance"
    "Environment" = var.enviroment[0]
  }
  #ebs_optimized = var.ebs_opt
  #cpu_core_count = var.core_count
  
}


//7
//output variables
//con esto se genera tras una ejecucion de terraform apply -auto-approve
// esto sirve para obtener el valor de la variable
output "instance_public_ip" {
  value = aws_instance.instance1.public_ip

}