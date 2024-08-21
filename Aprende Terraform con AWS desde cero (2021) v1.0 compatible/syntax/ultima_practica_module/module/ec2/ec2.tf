variable "ec2_ami" {
    type = string
}

variable "ec2type" {
    type = string
}
variable "ec2iface" {
    type = string
}
variable "ec2name" {
    type = string
}


resource "aws_instance" "ec2instance" {
    ami           = var.ec2_ami
    instance_type = var.ec2type
    subnet_id     = "Subnet1a" 
    network_interface {
        device_index         = 0
        network_interface_id = var.ec2iface
    }
    tags = {
        Name = var.ec2name
    }
}
