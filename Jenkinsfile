pipeline{
    // agent {
    //     label 'linux-node'
    // }

    agent any

    tools{
        maven "maven"
    }

    stages {
        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RutvikShilamkar/devops-jenkins-jenkinsDemo.git']])
            }
        }

        stage("maven build"){
            steps{
                    sh 'mvn clean install'
            }
        }

        stage("Deploy to container"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9090/')], contextPath: 'jenkincicdapp', war: '**/*.war'
            }
        }
    }

    post{
        always{
            emailext attachLog: true, body: '''<html>
            	<body>
            		<p>Build status: ${BUILD_STATUS}</p>
            		<p>Build number: ${BUILD_NUMBER}</p>
            		<p>Check the <a href="${BUILD_URL}">console output</a>.</p>
            	</body>
            </html>''', mimeType: 'text/html', replyTo: 'rutvikshilamkar@gmail.com', subject: 'Pipeline Status: ${BUILD_NUMBER}', to: 'rutvikshilamkar@gmail.com'
        }
    }
}