# Sistemas-Distribuidos-2
Repositorio voltado para disciplina de SD2

#I unidade
#Calculadora RMI
* Criar aplicativo Calculadora Distribu�da usando Java RMI

opera��es a serem fornecidas: +,-,*,/
	1) criar abordagem com opera��es rodando na mesma m�quina, sem invoca��o remota. Um �nico cliente.
	2) criar abordagem com todas as opera��es rodando em 1 m�quina distribu�da. Um �nico cliente.
	3) criar abordagem com opera��es rodando em 4 m�quina distribu�das, cada uma com uma opera��es. Um �nico cliente.
	4) criar abordagem com todos os servi�os rodando em 4 m�quina distribu�das, cada uma com as 4 opera��es. Um �nico cliente.

         Para a abordagem 4, o cliente deve selecionar o servidor e a opera��o do servidor de forma aleat�ria. 
         Podem registrar o objeto no rmiregistry de forma incremental, ex: soma0, soma1, soma2, soma3. 
         O cliente seleciona o objeto no servidor de forma aleat�ria: "soma"+ (i mod 4); 

         O ip dos servidor tamb�m seria selecionado aleatoriamente em um array de ips: servidor[(i mod 4)]) previamente armazenado.

       Para t�tulo de compara��o entre as abordagens, usar 20 express�es com pelo menos 12 opera��es em cada. 

       A seguir, o exemplo de 1 express�o:

	su[3].subtrair(5.4, mu[2].multiplicar(4.65, so[0].somar(so[1].somar(di[3].dividir(5.53,so[0].somar(4.234, 6.742)),
	 mu[3].multiplicar(su[2].subtrair(3.325, so[1].somar(3.752, su[3].subtrair(6.23,8.63))), di[0]dividir(6.323,4.342))),
	 mu[1].multiplicar(7.26, 5.432))));
 
	Os m�todos fornecidos dever�o ter as seguintes assinaturas (interface).

	double somar (double a, double b)
	double subtrair (double a, double b)
	double multiplicar (double a, double b)
	double dividir (double a, double b)


      Implementar camada de transpar�ncia de distribui��o usu�rio digitar via teclado algo como:  (3/2*4+3)*2 - e transformar isso em chamadas de m�todos remotos, como a seguir: 
multiplicar(somar(3,multiplicar(dividir(3,2),4)),2);
---------------------------------------------------------------------------

         Implementar transpar�ncia de falha no item 4. Caso um servidor n�o esteja dispon�vel, 
         tentar realizar a opera��o em outro servidor. Mas n�o elimin�-lo pois num futuro ele pode voltar a estar online novamente.

   Usar o System.currentTimeMillis() para obten��o dos tempos. Caso a execu��o seja muito r�pida, e esse m�todo n�o apresente respostas adequadas, usar o System.nanoTime();

Data de Entrega: 03/05/2016

#II unidade

*  (pontos) � Data de Entrega: xx/xx/2016

#III unidade

*  (pontos) � Data de Entrega: xx/xx/2016
