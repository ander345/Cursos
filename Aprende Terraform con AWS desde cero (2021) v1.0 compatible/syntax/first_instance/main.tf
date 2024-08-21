
provider "aws" {
  region = "us-west-2"
}

// el ami y instance estan en EC2
resource "aws_instance" "instance1" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = "t3.micro"

  tags = {
    Name = "first_instance"
  }
}