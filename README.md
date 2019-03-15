# Projeto-POO
### Projeto da disciplica Programação Orientada a Objetos - IFPB. 

**Objetivo:** Implementar um sistema delivery para restaurante.
#
**Cenário:**
O sistema delivery funciona da seguinte forma:
1. Um cliente telefona, o atendente confirma os dados do cliente e abre um pedido no sistema, registrando
os produtos escolhidos pelo cliente
2. O entregador entrega o pedido no endereço do cliente
3. O cliente paga ao entregador o valor total do pedido
4. O entregador fecha o pedido, registrando no sistema o seu nome
5. O sistema envia para o e-mail do cliente um arquivo PDF com a fatura detalhada do pedido fechado
6. O sistema comercializa produtos “combo” que é a combinação de dois ou mais produtos com um
desconto de 10% no preço.
7. O sistema permite excluir um pedido fechado, excluindo todos os relacionamentos com clientes e
produtos relacionados a ele. 

#

**Regras de negócio:**
1. Um cliente só pode ter no máximo um pedido aberto.
2. Um pedido pode ser alterado (incluir/remover produtos) e excluído desde que esteja aberto.
3. O valor total do pedido é a soma dos preços dos seus produtos mais a taxa de entrega.
4. Um produto pode aparecer várias vezes dentro do mesmo pedido
5. A data do pedido é obtida do computador
6. Os clientes são localizados pelo número do telefone (não precisa ddd).
7. Um cliente não pode ser excluído, mas pode ter seus dados alterados.
8. Os produtos e pedidos são identificados por um número sequencial (1,2, ...) gerado pelo sistema.
9. O preço do combo (getPreco()) é a soma dos preços dos seus produtos componentes com um desconto
de 10%.
10. A listagem de um combo envolve o seu nome e o nome de seus componentes
11. A exclusão de um pedido não exclui o seu cliente nem os seus produtos.

#

**Classes do Modelo de Negócio:**
![modelo-negocio](https://github.com/renathavictor/Projeto-POO/blob/master/modelo-negocio.PNG)
