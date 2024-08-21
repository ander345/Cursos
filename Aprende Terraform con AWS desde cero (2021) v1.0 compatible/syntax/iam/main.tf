provider "aws" {
  region = "us-west-2"
  
}

resource "aws_iam_user" "iam_user1" {
  name    = var.iam_user1

}

resource "aws_iam_policy" "policy1" {
  name = var.policy1
  policy = <<EOF
    {
        "Version": "2012-10-17",
        "Statement": [
            {
                "Action": "s3:ListAllMyBuckets",
                "Effect": "Allow",
                "Resource": "*"
            }
        ]
    }
EOF
}


resource "aws_aim_policy_attachment" "attachment" {
    user = aws_iam_user.iam_user1.name
    policy_arn = aws_iam_policy.policy1.arn
  
}