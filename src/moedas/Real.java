package moedas;


public class Real extends Moeda
{	
	public Real(Moeda moeda)
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
		return super.valor;
	}
}
