pipeline {
   agent any

   environment {
       AWS_ACCESS_KEY_ID     = credentials('jenkins-aws-secret-key-id')
       AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-access-key')
       AWS_S3_BUCKET         = 'lucasrivelles-jar-bucket'
       ARTIFACT_NAME         = 'ms-users-${BUILD_ID}.jar'
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
                    sh 'aws s3 cp ./target/kotlin-ms-users-0.0.1-SNAPSHOT.jar s3://$AWS_S3_BUCKET/$ARTIFACT_NAME'
                }
            }
      }
   }
}