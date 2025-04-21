# COMO RODAR A API E BANCO DE DADOS

A aplicação roda com docker-compose e dockerfile e para conseguir executar a api você precisará executar os comandos:
- Para buildar a api e manter os serviços atualizados:
    - `docker-compose build`
- Para rodar a api e o banco de dados:
    - `docker-compose up`
- Para rodar os testes da api via docker:
    - `docker-compose --profile test run --rm api-test`

> Para executar esses comandos você deve ter instalado na sua máquina o docker/ docker-compose.
