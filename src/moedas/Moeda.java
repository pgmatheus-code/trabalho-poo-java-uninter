package moedas;

public abstract class Moeda
{
	public String nome;
	public double valor;
	
	public Moeda(String nome, double valor)
	{
		this.nome = nome;
		this.valor = valor;
	}
	
	public double info()
	{
		return valor;
	}
	
	public abstract double converter(double taxaConversao);
}
