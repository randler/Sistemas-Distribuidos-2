# Sistemas-Distribuidos-2
Repositorio voltado para disciplina de SD2

#I unidade
#Calculadora RMI
* Criar aplicativo Calculadora DistribuÃ­da usando Java RMI

operaÃ§Ãµes a serem fornecidas: +,-,*,/

* 1) criar abordagem com operações rodando na mesma máquina, sem invocações remota. Um único cliente.
* 2) criar abordagem com todas as operações rodando em 1 máquina distribuída. Um único cliente.
* 3) criar abordagem com operações rodando em 4 máquina distribuídas, cada uma com uma operações. Um único cliente.
* 4) criar abordagem com todos os serviços rodando em 4 máquina distribuídas, cada uma com as 4 operações. Um único cliente.

        Para a abordagem 4, o cliente deve selecionar o servidor e a operação do servidor de forma aleatária. 
        Podem registrar o objeto no rmiregistry de forma incremental, ex: soma0, soma1, soma2, soma3. 
        O cliente seleciona o objeto no servidor de forma aleatória: "soma"+ (i mod 4); 

      	O ip dos servidor também seria selecionado aleatoriamente em um array de ips: servidor[(i mod 4)]) previamente armazenado.

       	Para título de comparação entre as abordagens, usar 20 expressões com pelo menos 12 operações em cada. 

       	A seguir, o exemplo de 1 expressão:
       	su[3].subtrair(5.4, mu[2].multiplicar(4.65, so[0].somar(so[1].somar(di[3].dividir(5.53,so[0].somar(4.234, 6.742)),
       	mu[3].multiplicar(su[2].subtrair(3.325, so[1].somar(3.752, su[3].subtrair(6.23,8.63))), di[0]dividir(6.323,4.342))), 
       	mu[1].multiplicar(7.26, 5.432))));
       
       	Os métodos fornecidos deverão ter as seguintes assinaturas (interface).
       	double somar (double a, double b)
       	double subtrair (double a, double b)
       	double multiplicar (double a, double b)
       	double dividir (double a, double b)


      	Implementar camada de transparáncia de distribuição usuário digitar via teclado algo como:  (3/2*4+3)*2 
      	e transformar isso em chamadas de métodos remotos, como a seguir: 
      	multiplicar(somar(3,multiplicar(dividir(3,2),4)),2);

        Implementar transparáncia de falha no item 4. Caso um servidor não esteja disponível, 
        tentar realizar a operação em outro servidor. Mas não eliminá-lo pois num futuro ele pode voltar a estar online novamente.
        Usar o System.currentTimeMillis() para obtenção dos tempos.
        Caso a execução seja muito rápida, e esse método não apresente respostas adequadas, usar o System.nanoTime();

* Para Rodar o RMI: 

        (Linux)
        * Entrar na pasta da Abordagem Compilar tudo normalmente:   javac *.java
        * Gerar stub (Operacoes_Stub.class), e adicioná-lo ao lado cliente e servidor(Caso não esteja): rmic -v1.2 Operacoes 
        * Executar o servidor de nomes: rmiregistry &
        * Executar o servidor: java ServidorCalc <nome_do_obj_a_ser_registrado>
        * Executar cliente: java ClienteCalc <ipservidor> <nome_do_obj_registrado_no_servidor>
        
        (Windows)
        * Entrar na pasta da Abordagem Compilar tudo normalmente:   javac *.java
        * Gerar stub (Operacoes_Stub.class), e adicioná-lo ao lado cliente e servidor(Caso não esteja): rmic -v1.2 Operacoes 
        * Executar o servidor de nomes (irá aparecer uma tela, espere registrar e continue após ela sair):start rmiregistry
        * Executar o servidor(irá aparecer o servidor): start java ServidorCalc <nome_do_obj_a_ser_registrado>
        * Executar cliente: java ClienteCalc <ipservidor> <nome_do_obj_registrado_no_servidor>
        
#Criar CRUD

1) Criar CRUD (C = Create, R = Retrieve, U = Update, D = Delete) para Produto num servidor, em um Colletion.
2) Criar cliente que invoca remotamente os métodos CRUD.

Para essa atividade necessitarão dos códigos criados referentes a:
SOCKET TPC, REFLEXÃO E SERIALIZAÇÃO DE OBJETOS

![alt tag](https://github.com/randler/Sistemas-Distribuidos-2/blob/master/img/20160419_213734.jpg)

#Apresentação em Slide
* Web Server MultiThread
* Análise de desempenho com o JMeter
* Calculadora RMI
* Análise de desempenho da Calculadora

Data de Entrega: 03/05/2016

#II unidade
         * RPC
         Ordenação de um vetor de 10.000 números double aleátorios. Servidores executam bublesort e o coordenador o merge (do mergesort).
         * CORBA
         Calculadora Distribuída para números double (soma, subtração, multiplicação e divisão).
         * WS
         CRUD de Pessoa {String nome, java.awt.Image foto, char sexo, java.util.Date dataNascimento, double altura, double peso}
         * Desenvolver Tutorial: https://netbeans.org/kb/docs/websvc/flower_overview.html

Data de Entrega: 05/07/2016

#III unidade
#Desenvolvimento
Desenvolver um programa similar ao exemplo disponibilizado pelo JGroups, onde o desenho que é feito em uma tela, é replicada
para os demais processos que fazem parte do mesmo cluster.

Para isso, vocês terão em mãos, um Chat Simples com JGroups, o exemplo do JGroups que deverão seguir, e alguns exemplos de Applets 


         * 1. Para rodar o exemplo disponibilizado pelo JGroups disponível aqui:
                http://jgroups.org/tutorial/index.html#_running_a_demo_program
         * 1.1) Executar o seguinte comando na pasta onde foi salvado o JGroups, ficando atento a substituição do nome do arquivo .jar, de acordo ao nome do arquivo baixado.
                java -cp jgroups-3.6.10.Final.jar -Djava.net.preferIPv4Stack=true org.jgroups.demos.Draw
         * 1.2) Uma outra alternativa é adicionar o arquivo .jar na variável de ambiente CLASSPATH. desta forma só precisaria executar o seguinte comando:
                java -Djava.net.preferIPv4Stack=true org.jgroups.demos.Draw


         * 2. Material com exemplo de Applets
                http://www.realapplets.com/tutorial/MouseClickExample.html
                http://www.inf.pucrs.br/flash/lapro2/aula_applets.html
                http://www.inf.pucrs.br/flash/lapro2/11-applets.pdf
                http://www.inf.pucrs.br/flash/lapro2/exapplets.zip
         Anexo também tem alguns códigos fontes, o do link acima, e o que eu fiz em sala de aula.

         * 3. Link para o chat simples
                http://jgroups.org/tutorial/index.html#_writing_a_simple_application

        * 4. Download do toolkit JGroups
                https://sourceforge.net/projects/javagroups/files/JGroups/

#Apresentação
Estudo das tecnologias de computação em nuvem a seguir. O que é, para que serve, como funciona, arquitetura, componentes, funcionalidades, como utilizar/instalar/configurar, etc. 
* Microsoft Azure
* Apache CloudStack

* A apresentação deve durar entre 10 e 15 min.

Data de Entrega: 19/07/2016
