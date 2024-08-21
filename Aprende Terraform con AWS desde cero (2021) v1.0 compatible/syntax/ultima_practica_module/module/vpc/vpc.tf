
variable "vpcname" {
  type    = string
}


variable "vpc_cidr" {
  type    = string
}


variable "subnet_cidr" {
  type    = string
  
}

variable "az" {
    type = string
}

variable "subnet_name" {
  type    = string  
}

resource "aws_vpc" "vpc1" {
    cidr_block = var.vpc_cidr
    
    tags = {
        Name = var.vpcname
    }
  
}

variable "ec2_private_ip" {
  type    = list(string)
}

resource "aws_subnet" " subnet1a" {
  vpc_id     = aws_vpc.vpc1.id
  cidr_block = var.subnet_cidr
  availability_zone = var.az
  tags = {
    Name = var.subnet_name
  }
}


resource "aws_network_interface" "iface1" { 
    subnet_id   = aws_subnet. subnet1a.id  # Replace with the correct subnet ID for Subnet1a
    private_ips = var.ec2_private_ip
    tags = {
        Name = "primary_network_interface"
    }
}


output "ec2_network_interface" {
  value = aws_network_interface.iface1.id
  
}

