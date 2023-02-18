pipeline {
    agent any

    options{
    buildDiscarder(logRotator(daysToKeepStr: '30', numToKeepStr: '3'))
    timestamps()
    }

    stages {

          stage("Run tests") {
            steps {
              script{
                   def mvnHome = tool name: 'mvn', type: 'maven'

                       sh "mvn clean test"

                    }

              }
          }

          stage("Compile Package") {
            steps {
              script{
                   def mvnHome = tool name: 'mvn', type: 'maven'

                       sh "mvn clean install"

                    }
              }
          }


        stage("Deploying Application") {

             steps {

                       sh "mvn spring-boot:run"
                   }

            }

     }
}
