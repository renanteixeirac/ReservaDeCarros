import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**Classe principal do projeto, com todas as funções necessárias para sua execução.
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
		 * Criação dos objetos referentes a cada loja de reserva de carros.
		 * Os valores fornecidos são de acordo com os que foram fornecidos no enunciado do
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
		 * Substituições de caracteres e partição da entrada em vetores e strings menores.
		 * Aqui são eliminados espaços em brancos e há a substituição de , e : por ;, que
		 * serão caracteres usados para fazer a separação de cada elemento da entrada em
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
		 * Separação das strings de dias, com o objetivo de pegar a qual dia da semana
		 * a entrada está se referindo.
		 */
		String dias[] = new String[s.length - 2];
		
		/**
		* A separação das strings de dias funciona da seguinte forma: aqui o que realmente
		* importa é qual dia da semana é, e não o dia no calendário. Isso porque os valores das taxas são
		* especificados de acordo com o dia da semana, ou seja, se é dia útil ou final de semana.
		* Como a entrada de dias será sempre padrão (Ex.: 17Nov2017 (sex)), não há necessidade dos
		* elementos que estão fora dos parênteses. Então, eles serão eliminados.
		*
		* Aqui haverá a troca do (, pois é o elemento que separa a parte que queremos da que
		* não será utilizada. Com isso, ela é substituída novamente pelo ; e há a partição da string.
		* Com isso, podemos pegar a segunda parte, referente a sub[1] e armazená-la no vetor de dias,
		* cujo índice deve sempre começar em zero. Como o contador do laço começa em 2 pelo fato do vetor s[]
		* estar armazenando todo o conteúdo da entrada, sabemos que o primeiro elemento e o segundo deste se
		* referem respectivamente ao tipo do cliente e ao limite de passageiros solicitado. Então, os dias
		* estarão armazenados a partir do terceiro item do vetor em diante. Como o vetor começa no índice 0,
		* basta iniciarmos o índice a partir do terceiro item até o seu final, representado por s.lenght.
		* Por isso inicializamos o índice do vetor dias[] com o contador subtraído por 2.
		*/		
		for(int i = 2; i < s.length; i++){
			s[i] = s[i].replace(")", "");
			s[i] = s[i].replace("(", ";");
			String[] sub = s[i].split(";");
			dias[i-2] = sub[1];
			//System.out.println("dias[" + (i-2) + "] = " + dias[i-2]);
		}
		
		System.out.println("Bem vindo ao serviço de Reserva de Carros!");		
		
		/**
		 * Verificação de pesquisa nas lojas de acordo com o limite informado pelo usuário.
		 * Se o limite fornecido for maior que os dos carros fornecidos pelas lojas, a
		 * verificação não será realizada.
		 * 
		 * Caso a verificação seja realizada, a soma dos valores é armazenada no objeto da loja
		 * e em uma variável de menor valor, a qual será comparada com as demais
		 * verificações das lojas caso elas sejam aceitas nas condições.
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
		 * Quando as verificações forem finalizadas, os valores obtidos serão comparados
		 * para descobrir qual deles é o menor.
		 */
		for (int j = 0; j < 3; j++) {
			if(resultado[j] < menor && resultado[j] != 0){
				menor = resultado[j];
			}
		}
		
		/**
		 * Quando o menor valor for obtido, ele mais uma vez será verificado com as somas
		 * das taxas armazenadas nos objetos. Caso os valores sejam iguais, significa que a 
		 * loja em questão é a que oferecerá o serviço mais rentável ao usuário, imprimindo
		 * o nome da loja juntamente com os carros disponíveis.
		 */
		
		System.out.println("Estas são as melhores indicações de veículos e lojas para você:");
		
		if(menor == south_car.getTotal() && menor != 0)
			System.out.println("FIAT PALIO FIRE, VOLKSWAGEN UP: " + south_car.getNome());
		
		if(menor == west_car.getTotal() && menor != 0)
			System.out.println("FERRARI, VOLVO S60: " + west_car.getNome());
		
		if(menor == north_car.getTotal() && menor != 0)
			System.out.println("NAVIGATOR, PEUGEOT 3008: " + north_car.getNome());
		
		/**
		* No início deste algoritmo, todos os totais são inicializados com 0. Caso este valor continue
		* mesmo após as verificações em cada loja, significa que provavelmente algum parâmetro foi
		* fornecido incorretamente no arquivo de entrada. Sendo assim, o seguinte erro será retornado.
		*/
		if((south_car.getTotal() == 0) && 
		   (west_car.getTotal() == 0) &&
		   (north_car.getTotal() == 0)) {
			System.out.println("Ops! Alguns dos parâmetros estão errados! Verifique o arquivo de texto.");
		}
		
	}

	/**
	 * Função para verificar o valor das taxas de acordo com o pedido do cliente.
	 * @param loja - objeto referente à loja de reserva de carros
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
		* Uma vez que todos os dias forem convertidos para saber se são dias úteis ou finais
		* de semana, será feita a verificação do tipo do cliente juntamente com o dia fornecido
		* na entrada. Com isso, será feita a soma das taxas baseado na declaração dos objetos 
		* no início desta classe e armazenado na variável total, que será retornada para a Main.
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
	 * Função para conversão do dia da semana em "flags" para tornar a verificação e soma
	 * das taxas mais prática. Todos os dias úteis são marcados com a flag util e os finais de semana
	 * serão marcados com a flag fds. Estas flags serão importantes para a soma na função anterior.
	 * @param dia - dia da semana
	 * @return dia - tipo do dia da semana (dia útil ou final de semana)
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