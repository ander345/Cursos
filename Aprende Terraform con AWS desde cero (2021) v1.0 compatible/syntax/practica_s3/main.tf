provider "aws" {
  region = var.aws_region
}

resource "aws_s3_bucket" "bucket1" {
  bucket = var.bucket1
  acl    = "public-read"
  website {
    index_document = "index.html"
  }
}



resource "aws_s3_bucket_object" "object1" {
  bucket = aws_s3_bucket.bucket1.bucket
  key    = "index.html"
  acl    = "public-read"
  content = var.content
  content_type = "text/html"
}