# Sincronização Receita

## Objetivo

Criar uma aplicação spring boot que receba um arquivo csv via linha de comando com informações de contas para que seja realizada a 
sincronização dos dados e gere um arquivo csv com os resultados da sincronização de cada conta.

## O que precisa para executar?

- JDK 17 - [Bellsoft - Liberica JDK](https://bell-sw.com/pages/downloads/#/java-17-lts)
- Maven - [Maven](https://maven.apache.org/download.cgi)

## Como utilizar

1. Gere o executável da aplicação
````
mvn package -DskipTests
````

2. Copie e cole o executável para dentro de uma pasta de sua preferência 

````
target/sincronizador-receita-1.0-SNAPSHOT.jar
````
3. Coloque o arquivo csv que deseja sincronizar na mesma pasta que está o executável, 
abra o terminal dentro da pasta e execute

````
java -jar sincronizador-receita-1.0-SNAPSHOT.jar contas.csv
````
4. Confira o resultado no csv gerado de resposta

````
sincronizacao-resultado.csv
````