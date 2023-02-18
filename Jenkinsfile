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

                       sh "${mvnHome}/bin/mvn clean test"

                    }

              }
          }

          stage("Compile Package") {
            steps {
              script{
                   def mvnHome = tool name: 'mvn', type: 'maven'

                       sh "${mvnHome}/bin/mvn clean install"

                    }
              }
          }


        stage("Deploying Application") {

             steps {

                       sh('start "" /D C:/ProgramData/Jenkins/war/scripts/backend.bat')
                   }

            }

     }
}
