provider "aws" {
  region = "us-east-1"
  
}

module "vpc" {
  source = "./module/vpc"
  vpcname = "vpc_module1"
  vpc_cidr = "19.82.0.0/16"
  az = "us-east-1a"
  subnet_cidr = "19.82.1.0/24"
  subnet_name = "subnet1a"
  ec2_private_ip = ["19.82.1.82"]
}

module "ec2" {
  source = "./module/ec2"
  ec2_ami = "ami-0c94855ba95c71c99"
  ec2type = "t3.micro"
  ec2iface = module.vpc.ec2_network_interface
  ec2name = "EC2 name from module"
  
}