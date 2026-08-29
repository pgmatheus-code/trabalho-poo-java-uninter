package moedas;


public class Real extends Moeda
{	
	public Real(double valor)
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
		return super.valor;
	}
}
