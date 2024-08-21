# main.tf, provider declaration

provider "aws" {
  region = "us-west-2"
}


/*<BLOCK TYPE> "<BLOCK LABEL>" "<BLOCK LABEL>" {
  # Block body
  #¿De qué se compone un argumento en HCL?
  #identificador y expresión
  <IDENTIFIER> = <EXPRESSION> # Argument
}
*/

//
resource "aws_instance" "example" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = "t2.micro"

  tags = {
    Name = "example-instance"
  }
}