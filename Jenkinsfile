pipeline {
    agent any

    stages{
        stage('Preparation') {
            steps {
                git 'https://github.com/VladimirCW/lesson8group2.git'
            }
        }
        stage('Unit tests') {
            steps{
                bat 'mvn clean -DsuiteXmlFile=unitTests.xml test'
            }
        }
        //stage('UI tests') {
        //    steps{
        //        bat 'mvn clean -DsuiteXmlFile=testng.xml test'
        //    }
        //}
    }
    post{
        always{
            script {
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                ])
                emailext body: '''${SCRIPT, template="allure-report.groovy"}''',
                        subject: "Jenkins Build result: ${currentBuild.currentResult}. Job '${env.JOB_NAME}'. Build # ${env.BUILD_NUMBER}",
                        to: "vova0996577028@gmail.com, vova0996577027@gmail.com"
            }
        }
    }
}