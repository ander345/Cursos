Lo has hecho muy bien hasta ahora, ahora vamos a probar Terraform con IAM:
## Crear usuario y política en IAM

1. Crea un usuario llamado `user1` en IAM.

2. Crea una política llamada `policy_s3_listAllMyBuckets` con el siguiente contenido:

```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "s3:ListAllMyBuckets"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```

3. Asocia la política `policy_s3_listAllMyBuckets` con el usuario `user1`.

4. Prueba la simulación de políticas con el usuario `user1` y diferentes acciones de S3.

Recuerda que puedes utilizar los recursos proporcionados en esta lección para completar este desafío.

Recursos de esta clase


 [Resource: aws_iam_policy](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/resources/iam_policy)

 [Resource: aws_iam_user](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/resources/iam_user)

 [Resource: aws_iam_user_policy_attachment](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/resources/iam_user_policy_attachment)

 [simulador de politicas AWS](https://signin.aws.amazon.com/oauth?SignatureVersion=4&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAI4ROL3CW4VDSU42Q&X-Amz-Date=2024-08-20T18%3A24%3A45.076Z&X-Amz-Signature=48f5302acd1ff93f46f7db5b0505366c96f7d35972abcf1673dbbd3eda3da0aa&X-Amz-SignedHeaders=host&client_id=arn%3Aaws%3Aiam%3A%3A015428540659%3Auser%2Fpolicysim&code_challenge=V-nMhVLoh_xv45W8WFAAZ-DJDLhAZL_45SNXTA1_77k&code_challenge_method=SHA-256&redirect_uri=https%3A%2F%2Fpolicysim.aws.amazon.com%2Fhome%2Findex.jsp%3Fstate%3DhashArgs%2523%26isauthcode%3Dtrue&response_type=code&state=hashArgs%23)