# conversor-temperatura — Build e testes automáticos com Jenkins + GitHub

Projeto da disciplina de Gerência de Configuração: um processo inicial de build e teste
automáticos com **Jenkins** (rodando localmente em Docker) integrado a este repositório no GitHub.

## O projeto
`src/main/java/br/ufam/gcs/ConversorTemperatura.java` tem dois métodos:

| Método | Fórmula |
|---|---|
| `celsiusParaFahrenheit(double c)` | F = C × 9/5 + 32 |
| `fahrenheitParaCelsius(double f)` | C = (F − 32) × 5/9 |

Casos de teste (JUnit 5) em `src/test/java/br/ufam/gcs/ConversorTemperaturaTest.java`:
0 °C → 32 °F, 100 °C → 212 °F, 32 °F → 0 °C, 98,6 °F → 37 °C e −40 °F → −40 °C.

## Pipeline (`Jenkinsfile`)
1. **Build** — `mvn clean compile`
2. **Testes** — `mvn test` + publicação dos resultados JUnit (teste falhando ⇒ build **INSTÁVEL**)
3. **Cobertura** (opcional, parâmetro `COBERTURA`) — perfil Maven `cobertura` com JaCoCo + plugin JaCoCo do Jenkins

## Branches usadas nos cenários
| Branch | Cenário |
|---|---|
| `main` | 1 (sucesso), 4 (agendado) e bônus (cobertura) |
| `cenario2-erro-compilacao` | 2 — erro de compilação ⇒ build **FALHOU** |
| `cenario3-teste-falhando` | 3 — fórmula errada em um método ⇒ build **INSTÁVEL** |

## Subindo o Jenkins local
```bash
cd jenkins
echo "JENKINS_ADMIN_PASSWORD=<sua-senha>" > .env
docker compose up -d --build   # http://localhost:8080 (usuário admin)
```
A imagem (`jenkins/Dockerfile`) já vem com Maven e os plugins Git, Pipeline, JUnit, JaCoCo e Timestamper.
