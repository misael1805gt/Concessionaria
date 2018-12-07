/**
 * 
 */
package model;

/**
 * @author Misael
 *
 */
public class Carro {
	private String nome;
	private String ano;
	private String fabricante;
	private float preco;
	/**
	 * @return the nome
	 * 
	 */
	public Carro() {
		
		
	}
	public Carro(String nome, String ano, String fabricante, float preco) {
		this.setAno(ano);
		this.setFabricante(fabricante);
		this.setNome(nome);
		this.setPreco(preco);
	}
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}
	/**
	 * @param ano the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
	/**
	 * @return the fabricante
	 */
	public String getFabricante() {
		return fabricante;
	}
	/**
	 * @param fabricante the fabricante to set
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	/**
	 * @return the preco
	 */
	public float getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String toString(){
		return ""+this.getNome()+" "+this.getFabricante();
	}
}
