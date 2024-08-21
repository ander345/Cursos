variable "aws_region" {
  type    = string
  default = "eu-north-1"
  
}

variable "vpc_cidr" {
  type    = string
  default = "192.168.0.0/16"
  
}

variable "vpcname" {
  type    = string
  default = "vpc_practice1"
  
}

variable "subnet_cidr" {
  type    = list(string)
  default = ["192.168.1.0/24", "192.168.2.0/24", "192.168.3.0/24"]
  
}

variable "az" {
    type = list(string)
    default = [ "eu-north-1a","eu-north-1b","eu-north-1c"]
  
}

variable "subnet_name" {
  type    = list(string)
  default = ["subnet_practice1", "subnet_practice2", "subnet_practice3"]    
  
}