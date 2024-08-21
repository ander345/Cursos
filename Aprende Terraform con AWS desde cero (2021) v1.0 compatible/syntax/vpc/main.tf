provider "aws" {
  region = var.aws_region
}

resource "aws_vpc" "vpc1" {
    cidr_block = var.vpc_cidr
    
    tags = {
        Name = var.vpcname
    }
  
}

resource "aws_subnet" "subnet1" {
  vpc_id     = aws_vpc.vpc1.id
  cidr_block = var.subnet1[0]
  availability_zone = var.az[0]
  tags = {
    Name = var.subnet_name[0]
  }
}