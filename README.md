# Pipeline Jenkins

Exemplo de um Pipeline Jenkins para uma aplicação Spring. A pipeline tem 3 etapas: 

**1.Build** 
O Maven é usado para compilar o projeto.
**2.Test**
Maven é usado para executar os testes definidos no  arquivo CalculatorApplicationTests.java 
**3.Deliver**    
Construção e upload de uma imagem Docker para o Dockerhub.


## Calculadora REST

A Calculadora REST é um exexmplo de aplicação REST usando a framework Spring. A aplicação cria um endpoint `/calculator` na porta 8080 capaz de aceitar 2 operandos e um operador.

## Executando o Projeto localmente
> git clone https://github.com/lbaes/DemoSpringApp
> cd DemoSpringApp
> mvn clean install
> mvn spring-boot:run

Um Servidor será aberto na porta 8080 que responderá requisições GET no endpoint `/calculator` 

Envie uma requisicão GET para o url http://localhost:8080/calculator/?A=10&B=20&op=ADD e receberá um resposta no formato JSON contendo o resultado, os operandos e o operador

Os parametro `A` e `B` aceitam operandos numéricos e o parametro `op` aceita um dos seguintes valores:

- ADD
- SUB
- DIV
- MUL

O retorno do valor `ERR` no campo `operator` significa que houve um erro no processamento da requisição.

