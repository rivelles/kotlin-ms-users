pipeline {
   agent any

   environment {
       // use your actual issuer URL here and NOT the placeholder {yourOktaDomain}
       //OKTA_OAUTH2_ISSUER           = '{yourOktaDomain}/oauth2/default'
       //OKTA_OAUTH2_CLIENT_ID        = credentials('OKTA_OAUTH2_CLIENT_ID')
       //OKTA_OAUTH2_CLIENT_SECRET    = credentials('OKTA_OAUTH2_CLIENT_SECRET')
       AWS_ACCESS_KEY_ID     = credentials('jenkins-aws-secret-key-id')
       AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-access-key')
       AWS_S3_BUCKET         = 'lucasrivelles-jar-bucket'
       ARTIFACT_NAME        = 'ms-users-${currentBuild.startTimeInMillis}.jar'
   }

   stages {
      stage('Test') {
         steps {
            // Get some code from a GitHub repository
            //git 'https://github.com/rivelles/kotlin-ms-users.git'

            // Run Maven on a Unix agent.
            sh "mvn clean test"
         }
      }
      stage('Build on S3') {
            steps {
                sh "mvn package"
            }
            post{
                success {
                    archiveArtifacts 'target/*.jar'
                    sh 'aws configure set region sa-east-1'
                    sh 'aws s3 cp ./target/calculator-0.0.1-SNAPSHOT.jar s3://$AWS_S3_BUCKET/$ARTIFACT_NAME'
                }
            }
      }
   }
}