pipeline {
   agent any

   environment {
       AWS_ACCESS_KEY_ID     = credentials('jenkins-aws-secret-key-id')
       AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-access-key')
       AWS_S3_BUCKET         = 'lucasrivelles-jar-bucket'
       ARTIFACT_NAME         = 'ms-users.jar'
       AWS_EB_APP_NAME = 'users-ms'
       AWS_EB_ENVIRONMENT = ' Usersms-env'
       AWS_EB_APP_VERSION = "${BUILD_ID}"
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
      stage('Sonar Analysis') {
            steps {
                withSonarQubeEnv('SonarQube', envOnly: true) {
                    println ${env.SONAR_HOST_URL}
                }
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
      stage('Deploy on EBS') {
            steps {
                sh 'aws elasticbeanstalk create-application-version --application-name $AWS_EB_APP_NAME --version-label $AWS_EB_APP_VERSION --source-bundle S3Bucket=$AWS_S3_BUCKET,S3Key=$ARTIFACT_NAME'
                sh 'aws elasticbeanstalk update-environment --application-name $AWS_EB_APP_NAME --environment-name $AWS_EB_ENVIRONMENT --version-label $AWS_EB_APP_VERSION'
            }
      }
   }
}