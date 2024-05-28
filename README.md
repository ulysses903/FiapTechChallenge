# Fiap tech challenge
Link do miro https://miro.com/app/board/uXjVKRWbQW0=/?share_link_id=57096918249
Este projeto consiste em uma api REST para o fluxo de restaurante solicitado no tech challenge FIAP.

## ✔️ Tecnologias e bibliotecas usadas
- `Java 21`
- `Spring Boot`
- `Lombok`
- `MySQL` 
- `Docker` para conteinerização
  
# Fluxo a ser seguido
Ao clonar o projeto, é possivel executar o docker com `docker compose up --build`, isso gerar uma instancia do banco e da aplicação. O banco esta na porta 5432 e a aplicação na 8080, então certifiquesse que as portas estejam livres.
Para acessar o swager do projeto acesse a URL http://localhost:8080/swagger-ui/index.html.
O fluxo da lanchonete se inicia na tela de cadastro do cliente, ele informa o CPF ou decide continuar sem se identificar.
Caso ele informar o cpf o sistema ira consulta se o usuario já existe pelo endpoint `GET .../clientes/cpf`, se o cpf não existir ele terá que informar o nome e email para se cadastrar pelo endpoint `POST .../clientes`.
Caso o cadastro seja um sucesso, o cadastro seja um sucesso ou ele não se identifique o usuário será redicionado para a tela de seleção de combos, os produtos são buscados de acordo com cada tela:
- Para selcionar o lanche consulte o endpoint `GET .../lanches`
- Para selcionar o acompanhamento consulte o endpoint `GET .../acompanhamentos`
- Para selcionar o bebida consulte o endpoint `GET .../bebidas`
- Para selcionar o sobremesa consulte o endpoint `GET .../sobremesas`
  
Para finalizar o pedido e gerar o link de pagamento deve ser chamado o endpoint `POST .../pedidos`, será retornado um objeto com link de pagamento, id do pagamento do mercado pago e o id do pedido, com isso será redirecionado para o link de pagamento do mercado pago.
Ao acessar o link de pagamento você terá diversas opções para realizar o pagamento, ela possuíra a opção de pagar com QR Code, para pagar com QR Code você pode logar com o celular na conta teste com saldo para realizar o pagamento
- Conta com dinheriro: TESTUSER576019611/FP20xNG7f4
- Conta sem dinheiro: TESTUSER1657611808/eSPnfrpujr

No caso de sucesso de pagamento o link de pagamento redirecionará para o endpoint `PUT .../pedidos/{id}/confirmarPagamento` caso contrário `DELETE .../pedidos/{id}/cancelar`.
Então, no sucesso de pagamento o pedido irá ter seu status alterado para RECEBIDO pelo endpoint que confirmou o pagamento, caso contrário será deletado.
Caso de erro e o link de pagamento não redirecione automaticamente faça esse passo manualmente para testes.

Para listar todos pedidos temos o endpoint `GET .../pedidos`

Para a cozinha e os atendentes atualizarem o status do pedido temos os endpoints
- `PUT .../pedidos/{id}/atualizarPedidoParaEmPreparacao`
- `PUT .../pedidos/{id}/atualizarPedidoParaPronto`
- `PUT .../pedidos/{id}/atualizarPedidoParaFinalizado`

Para o CRUD de lanche temos
- `GET .../produtos/lanches`
- `GET .../produtos/lanches/{id}`
- `POST .../produtos/lanches`
- `PUT .../produtos/lanches/{id}`
- `DELETE .../produtos/lanches/{id}`

Para o CRUD de acompanhamentos temos
- `GET .../produtos/acompanhamentos`
- `GET .../produtos/acompanhamentos/{id}`
- `POST .../produtos/acompanhamentos`
- `PUT .../produtos/acompanhamentos/{id}`
- `DELETE .../produtos/acompanhamentos/{id}`

Para o CRUD de bebidas temos
- `GET .../produtos/bebidas`
- `GET .../produtos/bebidas/{id}`
- `POST .../produtos/bebidas`
- `PUT .../produtos/bebidas/{id}`
- `DELETE .../produtos/bebidas/{id}`

Para o CRUD de sobremesas temos
- `GET .../produtos/sobremesas`
- `GET .../produtos/sobremesas/{id}`
- `POST .../produtos/sobremesas`
- `PUT .../produtos/sobremesas/{id}`
- `DELETE .../produtos/sobremesas/{id}`

Para consultar todos os clientes temos 
- `GET .../clientes`
