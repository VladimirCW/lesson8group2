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
                bat 'mvn clean -DsuiteXml=unitTests.xml test'
            }
        }
        stage('UI tests') {
            steps{
                bat 'mvn clean -DsuiteXml=testng.xml test'
            }
        }
    }
}