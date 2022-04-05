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
2. Copie e cole o executável que é gerado dentro da pasta target para dentro de uma pasta de sua preferência
````
target/sincronizador-receita-1.0-SNAPSHOT.jar
````
3. Coloque o arquivo csv que deseja sincronizar na mesma pasta que está o executável, 
abra o terminal dentro da pasta e execute
````
java -jar sincronizador-receita-1.0-SNAPSHOT.jar NOME_DO_SEU_ARQUIVO.csv
````
4. Exemplo de csv de entrada
````
agencia;conta;saldo;status
0101;12225-6;100,00;A
0101;12226-8;3200,50;A
3202;40011-1;-35,12;I
3202;54001-2;0,00;P
3202;00321-2;34500,00;B
````
5. Confira o resultado no csv gerado de resposta
````
sincronizacao-resultado.csv
````
6. Exemplo de csv de saída
````
agencia;conta;saldo;status;sincronizado
010;12225-6;100,00;A;false
0101;12226-8;3200,50;A;true
3202;40011-1;-35,12;I;true
3202;54001-2;0,00;P;true
3202;00321-2;34500,00;B;true
````