/**Classe para objetos do tipo Servicos, onde serão contidos, valores e métodos para o mesmo.
 * @author Renan Teixeira Costa
 * @since 28 de novembro de 2017
 */

public class Servicos {
	
	private String nome;
	private int limite;
	private int diaUtil_reg;
	private int diaUtil_prem;
	private int fds_reg;
	private int fds_prem;
	private int total;
	
	public Servicos(String n, int l, int dr, int dp, int fr, int fp, int t){
		this.nome = n;
		this.limite = l;
		this.diaUtil_reg = dr;
		this.diaUtil_prem = dp;
		this.fds_reg = fr;
		this.fds_prem = fp;
		this.total = t;
	}
	
	/** Método para retorno do nome do serviço
     *   @return String - Nome do serviço*/	
	public String getNome(){
		return nome;
	}
	
	/** Método para definição do nome do serviço
	 * @param nome - nome do serviço
     */
	public void setNome(String nome){
		this.nome = nome;
	}
	
	/** Método para retorno do limite de passageiros dos carros oferecidos pelo serviço
     *   @return int - limite de passageiros*/
	public int getLimite(){
		return limite;
	}
	
	/** Método para definição do limite de passageiros dos carros oferecidos pelo serviço
	 * @param limite - limite de passageiros
     */
	public void setLimite(int limite){
		this.limite = limite;
	}
	
	/** Método para retorno do valor da taxa de reserva em dias úteis para clientes regulares
     * @return int - valor da taxa em dias úteis
     */
	public int getDiaUtilRegular(){
		return diaUtil_reg;
	}
	
	/** Método para definição do valor da taxa de reserva em dias úteis para clientes regulares
	 * @param diaUtil_reg - valor da taxa em dias úteis
     */
	public void setDiaUtilRegular(int diaUtil_reg){
		this.diaUtil_reg = diaUtil_reg;
	}
	
	/** Método para retorno do valor da taxa de reserva em dias úteis para clientes premium
     * @return int - valor da taxa em dias úteis
     */
	public int getDiaUtilPremium(){
		return diaUtil_prem;
	}
	
	/** Método para definição do valor da taxa de reserva em dias úteis para clientes premium
	 * @param diaUtil_prem - valor da taxa em dias úteis
     */
	public void setDiaUtilPremium(int diaUtil_prem){
		this.diaUtil_prem = diaUtil_prem;
	}
	
	/** Método para retorno do valor da taxa de reserva nos finais de semana para 
	 * clientes regulares
     *   @return int - valor da taxa em finais de semana
     */
	public int getFimDeSemanaRegular(){
		return fds_reg;
	}
	
	/** Método para definição do valor da taxa de reserva nos finais de semana para 
	 * clientes regulares
	 * @param fds_reg - valor da taxa em finais de semana
	 */
	public void setFimDeSemanaRegular(int fds_reg){
		this.fds_reg = fds_reg;
	}
	
	/** Método para retorno do valor da taxa de reserva nos finais de semana para clientes
	 * premium
     * @return int - valor da taxa em finais de semana
     */
	public int getFimDeSemanaPremium(){
		return fds_prem;
	}
	
	/** Método para definição do valor da taxa de reserva nos finais de semana para 
	 * clientes premium
	 * @param fds_prem - valor da taxa em finais de semana
	 */
	public void setFimDeSemanaPremium(int fds_prem){
		this.fds_prem = fds_prem;
	}
	
	/** Método para retorno do valor da soma das taxas de acordo com o pedido do cliente
     * @return int - valor total das taxas
     */
	public int getTotal(){
		return total;
	}
	
	/** Método para definição do valor da soma das taxas de acordo com o pedido do cliente 
	 * @param total - valor total das taxas
	 */
	public void setTotal(int total){
		this.total = total;
	}

}