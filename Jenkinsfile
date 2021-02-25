pipeline {
   agent any

   environment {
       // use your actual issuer URL here and NOT the placeholder {yourOktaDomain}
       //OKTA_OAUTH2_ISSUER           = '{yourOktaDomain}/oauth2/default'
       //OKTA_OAUTH2_CLIENT_ID        = credentials('OKTA_OAUTH2_CLIENT_ID')
       //OKTA_OAUTH2_CLIENT_SECRET    = credentials('OKTA_OAUTH2_CLIENT_SECRET')
   }

   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/rivelles/kotlin-ms-users.git'

            // Run Maven on a Unix agent.
            sh "./mvnw clean package"
         }
      }
   }
}

