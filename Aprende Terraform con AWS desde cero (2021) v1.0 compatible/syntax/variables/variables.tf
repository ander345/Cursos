variable "flavor" {
  type    = string
  default = "t3.micro"
}

//forma 2:(el valor esta en el otro archivo) 
/*
variable "flavor" {
  type    = string
}
*/

//tipos de variables
variable "ebs_opt" {
  type    = bool
  default = false
}

variable "core_count" {
  type    = number
  default = 4
}

variable "enviroment" {
  type    = list(string)
  default = ["dev", "qa", "prod"]
}

variable "amis" {
  type    = map()
    default = {
        amazon = "ami-0c55b159cbfafe1f0"
        ubuntu = "ami-0c55b159cbfafe1f0"
        redhat = "ami-0c55b159cbfafe1f0"
    }
}
