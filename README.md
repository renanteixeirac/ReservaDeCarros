# ReservaDeCarros

Programa em Java para resolução do Problema de reserva de carros.

No programa existem três lojas, cada uma trabalhando com um tipo diferente de carro. A SouthCar, que trabalha com carros compactos; a WestCar, que trabalha com carros esporte; e a NorthCar, que trabalha com carros SUV. Cada uma possui taxas variando com o tipo do cliente (que é definido pela sua fidelidade às lojas, podendo então ser Normal ou Premium) que a procura e o dia da semana em que o carro será alugado (há uma taxa específica para dias úteis e uma para finais de semana).

Cada carro possui um limite de passageiros. Os carros compactos tem um limite de 4 passageiros, os esporte comportam até 2 passageiros, e os SUV's comportam no máximo 7 passageiros.

O objetivo deste programa é ajudar o cliente a encontrar um carro mais barato de acordo com o seu tipo (Normal ou Premium), a quantidade de passageiros (entre 1 e 7 passageiros) e os dias em que o carro será alugado.

Este projeto é executável via linha de comando. Para isso, basta acessar a pasta ReservaDeCarros por terminal e compilar o programa principal. Isso pode ser feito inserindo os seguintes comandos no terminal:

**_javac Main.java_**

**_java Main_**

Como entrada do projeto, é necessário um *arquivo de texto* com o nome de **"arquivo.txt"**. Este arquivo deve conter apenas uma linha com os parâmetros para execução do mesmo. Os parâmetros devem ser posicionados da seguinte forma:

<TIPO_CLIENTE>: <QUANTIDADE_DE_PASSAGEIROS>: <DATA_1>, <DATA_2>, <DATA_3>, ...

Exemplo: Normal: 1: 16Mar2009 (seg), 17Mar2009 (ter), 18Mar2009 (qua)

Como saída, o programa mostrará o valor da soma das taxas de cada loja baseado nos parâmetros fornecidos pelo cliente. A saída será disponibilizada no terminal da seguinte forma:

<CARROS_DISPONIVEIS: LOCADORA>

Exemplo: FIAT PALIO FIRE, VOLKSWAGEN UP: South Car
