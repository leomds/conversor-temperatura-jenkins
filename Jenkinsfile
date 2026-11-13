// Pipeline do conversor-temperatura
// Parametros (definidos no job do Jenkins):
//   BRANCH     -> branch do GitHub a ser construida
//   COBERTURA  -> se true, mede a cobertura de codigo com JaCoCo
pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
        stage('Build (compilacao)') {
            steps {
                sh 'mvn -B clean compile'
            }
        }

        stage('Testes') {
            steps {
                // Falha de teste nao derruba o Maven; o plugin JUnit marca o build como INSTAVEL
                sh "mvn -B test -Dmaven.test.failure.ignore=true ${params.COBERTURA ? '-Pcobertura' : ''}"
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Cobertura de codigo') {
            when { expression { return params.COBERTURA } }
            steps {
                jacoco execPattern: 'target/jacoco.exec',
                       classPattern: 'target/classes',
                       sourcePattern: 'src/main/java'
            }
        }
    }

    post {
        success  { echo 'Build e testes OK' }
        unstable { echo 'Build OK, mas ha testes falhando (INSTAVEL)' }
        failure  { echo 'Build FALHOU' }
    }
}
