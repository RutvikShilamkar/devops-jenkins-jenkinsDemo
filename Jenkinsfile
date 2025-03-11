pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven-local"
    }

    stages {
        stage("SCM checkout") {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RutvikShilamkar/devops-jenkins-jenkinsDemo.git']])
            }
        }

        stage("build project") {
            steps {
                sh 'mvn clean install'
            }
        }

        stage("deploy to tomcat") {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat-cred', path: '', url: 'http://localhost:9090/')], contextPath: '/jenkinsfileapproach', war: '**/*.war'
            }
        }
    }

    post {
        always {
            emailext attachLog: true, body: '''<body>
                <p>Build status: ${BUILD_STATUS}</p>
                <p>Build number: ${BUILD_NUMBER}</p>
                <p>Check the <a href="${BUILD_URL}">console output</a>.</p>
            </body>''', mimeType: 'text/html', subject: 'Build status: ${BUILD_NUMBER}', to: 'rutvikshilamkarrms@gmail.com'
        }
    }
}
