pipeline {
    agent {
        docker {
            image 'javac:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    environment { 
        HOME = '.'
    }
    stages {
        stage('Build') { 
            steps {
                sh 'javac /SemanaAcademica/SemanaAcademica/src/view/JanelaPrincipal.java' 
            }
        }
    }
}
