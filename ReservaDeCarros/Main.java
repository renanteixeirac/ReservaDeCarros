import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**Classe principal do projeto, com todas as fun��es necess�rias para sua execu��o.
 * @author Renan Teixeira Costa
 * @since 28 de novembro de 2017
 */

public class Main {	

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		int limite = 0;
		int menor = 0;
		int resultado[] = new int[3];
		
		String tipo;
		String linha = "";				
		
		/**
		 * Cria��o dos objetos referentes a cada loja de reserva de carros.
		 * Os valores fornecidos s�o de acordo com os que foram fornecidos no enunciado do
		 * problema.
		 */
		Servicos south_car = new Servicos("South Car", 4, 210, 150, 200, 90, 0);
		Servicos west_car = new Servicos("West Car", 2, 530, 150, 200, 90, 0);
		Servicos north_car = new Servicos("North Car", 7, 630, 580, 600, 590, 0);
		
		/**
		 * Leitura de arquivo como entrada do programa.
		 */
		try{
			BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"));
	        while(br.ready()){
	        	linha = br.readLine();
	            //System.out.println(linha);
	         }
	         br.close();
	    }catch(IOException ioe){
	         ioe.printStackTrace();
	    }
		
		/**
		 * Substitui��es de caracteres e parti��o da entrada em vetores e strings menores.
		 * Aqui s�o eliminados espa�os em brancos e h� a substitui��o de , e : por ;, que
		 * ser�o caracteres usados para fazer a separa��o de cada elemento da entrada em
		 * strings menores.
		 */
		linha = linha.replace(",", ";");
		linha = linha.replace(":", ";");
		linha = linha.replace(" ", "");
		//System.out.println(linha);
		String[] s = linha.split(";");		
		tipo = s[0];
		//System.out.println("Tipo do cliente: " + tipo);
		limite = Integer.parseInt(s[1]);
		//System.out.println("Limite de passageiros: " + limite);
		
		/**
		 * Separa��o das strings de dias, com o objetivo de pegar a qual dia da semana
		 * a entrada est� se referindo.
		 */
		String dias[] = new String[s.length - 2];
		
		/**
		* A separa��o das strings de dias funciona da seguinte forma: aqui o que realmente
		* importa � qual dia da semana �, e n�o o dia no calend�rio. Isso porque os valores das taxas s�o
		* especificados de acordo com o dia da semana, ou seja, se � dia �til ou final de semana.
		* Como a entrada de dias ser� sempre padr�o (Ex.: 17Nov2017 (sex)), n�o h� necessidade dos
		* elementos que est�o fora dos par�nteses. Ent�o, eles ser�o eliminados.
		*
		* Aqui haver� a troca do (, pois � o elemento que separa a parte que queremos da que
		* n�o ser� utilizada. Com isso, ela � substitu�da novamente pelo ; e h� a parti��o da string.
		* Com isso, podemos pegar a segunda parte, referente a sub[1] e armazen�-la no vetor de dias,
		* cujo �ndice deve sempre come�ar em zero. Como o contador do la�o come�a em 2 pelo fato do vetor s[]
		* estar armazenando todo o conte�do da entrada, sabemos que o primeiro elemento e o segundo deste se
		* referem respectivamente ao tipo do cliente e ao limite de passageiros solicitado. Ent�o, os dias
		* estar�o armazenados a partir do terceiro item do vetor em diante. Como o vetor come�a no �ndice 0,
		* basta iniciarmos o �ndice a partir do terceiro item at� o seu final, representado por s.lenght.
		* Por isso inicializamos o �ndice do vetor dias[] com o contador subtra�do por 2.
		*/		
		for(int i = 2; i < s.length; i++){
			s[i] = s[i].replace(")", "");
			s[i] = s[i].replace("(", ";");
			String[] sub = s[i].split(";");
			dias[i-2] = sub[1];
			//System.out.println("dias[" + (i-2) + "] = " + dias[i-2]);
		}
		
		System.out.println("Bem vindo ao servi�o de Reserva de Carros!");		
		
		/**
		 * Verifica��o de pesquisa nas lojas de acordo com o limite informado pelo usu�rio.
		 * Se o limite fornecido for maior que os dos carros fornecidos pelas lojas, a
		 * verifica��o n�o ser� realizada.
		 * 
		 * Caso a verifica��o seja realizada, a soma dos valores � armazenada no objeto da loja
		 * e em uma vari�vel de menor valor, a qual ser� comparada com as demais
		 * verifica��es das lojas caso elas sejam aceitas nas condi��es.
		 */
		if(limite <= south_car.getLimite()){
			resultado[0] = verificacao_loja(south_car, tipo, dias);
			south_car.setTotal(resultado[0]);
			menor = resultado[0];
			//System.out.println("Resultado South Car: " + south_car.getTotal());
		}
		
		if(limite <= west_car.getLimite()){
			resultado[1] = verificacao_loja(west_car, tipo, dias);
			west_car.setTotal(resultado[1]);
			menor = resultado[1];
			//System.out.println("Resultado West Car: " + west_car.getTotal());
		}
		
		if(limite <= north_car.getLimite()){
			resultado[2] = verificacao_loja(north_car, tipo, dias);
			north_car.setTotal(resultado[2]);
			menor = resultado[2];
			//System.out.println("Resultado North Car: " + north_car.getTotal());
		}
		
		/**
		 * Quando as verifica��es forem finalizadas, os valores obtidos ser�o comparados
		 * para descobrir qual deles � o menor.
		 */
		for (int j = 0; j < 3; j++) {
			if(resultado[j] < menor && resultado[j] != 0){
				menor = resultado[j];
			}
		}
		
		/**
		 * Quando o menor valor for obtido, ele mais uma vez ser� verificado com as somas
		 * das taxas armazenadas nos objetos. Caso os valores sejam iguais, significa que a 
		 * loja em quest�o � a que oferecer� o servi�o mais rent�vel ao usu�rio, imprimindo
		 * o nome da loja juntamente com os carros dispon�veis.
		 */
		
		System.out.println("Estas s�o as melhores indica��es de ve�culos e lojas para voc�:");
		
		if(menor == south_car.getTotal() && menor != 0)
			System.out.println("FIAT PALIO FIRE, VOLKSWAGEN UP: " + south_car.getNome());
		
		if(menor == west_car.getTotal() && menor != 0)
			System.out.println("FERRARI, VOLVO S60: " + west_car.getNome());
		
		if(menor == north_car.getTotal() && menor != 0)
			System.out.println("NAVIGATOR, PEUGEOT 3008: " + north_car.getNome());
		
		/**
		* No in�cio deste algoritmo, todos os totais s�o inicializados com 0. Caso este valor continue
		* mesmo ap�s as verifica��es em cada loja, significa que provavelmente algum par�metro foi
		* fornecido incorretamente no arquivo de entrada. Sendo assim, o seguinte erro ser� retornado.
		*/
		if((south_car.getTotal() == 0) && 
		   (west_car.getTotal() == 0) &&
		   (north_car.getTotal() == 0)) {
			System.out.println("Ops! Alguns dos par�metros est�o errados! Verifique o arquivo de texto.");
		}
		
	}

	/**
	 * Fun��o para verificar o valor das taxas de acordo com o pedido do cliente.
	 * @param loja - objeto referente � loja de reserva de carros
	 * @param tipo - tipo do cliente (normal ou premium)
	 * @param dias - vetor com os dias solicitados pelo cliente
	 * @return total - soma dos valores das taxas
	 */
	private static int verificacao_loja(Servicos loja, String tipo, String[] dias) {
		
		int total = 0;
		int cont = 0;
		
		for(int i = 0; i < dias.length; i++)
			dias[i] = converterDias(dias[i]);
		
		/**
		* Uma vez que todos os dias forem convertidos para saber se s�o dias �teis ou finais
		* de semana, ser� feita a verifica��o do tipo do cliente juntamente com o dia fornecido
		* na entrada. Com isso, ser� feita a soma das taxas baseado na declara��o dos objetos 
		* no in�cio desta classe e armazenado na vari�vel total, que ser� retornada para a Main.
		*/
		while(cont < dias.length){
			
			if(tipo.equals("Normal") && dias[cont].equals("util"))
				total = total + loja.getDiaUtilRegular();
			
			if(tipo.equals("Normal") && dias[cont].equals("fds"))
				total = total + loja.getFimDeSemanaRegular();
			
			if(tipo.equals("Premium") && dias[cont].equals("util"))
				total = total + loja.getDiaUtilPremium();
			
			if(tipo.equals("Premium") && dias[cont].equals("fds"))
				total = total + loja.getFimDeSemanaPremium();
			
			cont++;
		}
		
		return total;
	}

	/**
	 * Fun��o para convers�o do dia da semana em "flags" para tornar a verifica��o e soma
	 * das taxas mais pr�tica. Todos os dias �teis s�o marcados com a flag util e os finais de semana
	 * ser�o marcados com a flag fds. Estas flags ser�o importantes para a soma na fun��o anterior.
	 * @param dia - dia da semana
	 * @return dia - tipo do dia da semana (dia �til ou final de semana)
	 */
	private static String converterDias(String dia) {

			switch (dia) {
	            case "seg":
	                dia = "util";
	                break;
	            case "ter":
	            	dia = "util";
	                break;
	            case "qua":
	            	dia = "util";
	                break;
	            case "qui":
	            	dia = "util";
	                break;
	            case "sex":
	            	dia = "util";
	                break;
	            case "sab":
	            	dia = "fds";
	                break;
	             case "dom":
	            	dia = "fds";
	                break;
	         }

		return dia;
	}

}