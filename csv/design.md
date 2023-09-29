## Entrada ##

A solução deve ser capaz de receber como entrada o conteúdo de um arquivo csv, na primeira linha com o título das colunas separados por vírgulas com quebra de linha no fim, seguido dos dados também separados por vírgula. Exemplo:
coluna1,coluna2
valor1,valor3
valor2,valor4

## Tratamento ##

Pós entrada dos dados eles devem ser tratados, para que haja a transformação de texto para número e assim seja possível realizar a soma dos números.

## Gerando a solução em CSV ##

A geração do arquivo com as mesmas linhas e soma no fim, pode ser feita em tempo de execução, da seguinte maneira:

- Leitura da primeira linha, ao fim da leitura quando identificar o caractere de quebra de linha, já adiciona essa mesma linha em um novo arquivo, adicionando também uma nova coluna.
- Após a leitura da primeira linha de valores, eles também já serão inseridos no arquivo resposta com o valor de soma ao fim.

Dessa maneira, o novo arquivo conterá as mesmas linhas do arquivo de entrada, porém com uma nova coluna soma e seus respectivos valores linha por linha.

## Outros ##

Ao fim dessa proposta também pode ser conveniente citar a encapsulação dos atributos e métodos, ou a utilização do Java com o StringBuilder e File para manipulação das linhas lidas e arquivos.