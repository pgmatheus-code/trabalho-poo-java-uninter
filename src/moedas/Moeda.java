package moedas;

public abstract class Moeda
{
	public double valor;
	
	public Moeda(double valor)
	{
		this.valor = valor;
	}
	
	public double Info()
	{
		return valor;
	}
	
	public abstract double Converter(double taxaConversao);
}
