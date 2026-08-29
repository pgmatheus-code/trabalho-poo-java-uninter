package moedas;


public class Dolar extends Moeda
{	
	public Dolar(double valor)
	{
		super(valor);
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
