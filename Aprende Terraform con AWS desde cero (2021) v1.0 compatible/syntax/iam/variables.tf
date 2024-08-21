provider "aws" {
  region = "us-west-2"
  
}

variable "iam_user1" {
  type = string
    default = "user1"
}

variable "policy1" {
  type = string
    default = "policy_s3_listAllMyBuckets"
}