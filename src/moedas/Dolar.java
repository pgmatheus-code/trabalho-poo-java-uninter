package moedas;


public class Dolar extends Moeda
{	
	public Dolar(Moeda moeda)
	{
		super(moeda);
	}
	
	@Override
	public double Info()
	{
		return super.valor;
	}
	
	@Override
	public double Converter(double taxaConversao)
	{
		return super.valor * taxaConversao;
	}
}
