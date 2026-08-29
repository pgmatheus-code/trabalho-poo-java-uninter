package moedas;

public abstract class Moeda
{
	public double valor;
	
	public Moeda(Moeda moeda)
	{
		return;
	}
	
	public abstract double Info();	
	public abstract double Converter(double taxaConversao);
}
