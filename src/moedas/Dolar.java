package moedas;


public class Dolar extends Moeda
{	
	public Dolar(double valor)
	{
		super("Dolar", valor);
	}
	
	@Override
	public double info()
	{
		return super.valor;
	}
	
	@Override
	public double converter(double taxaConversao)
	{
		return super.valor * taxaConversao;
	}
}
