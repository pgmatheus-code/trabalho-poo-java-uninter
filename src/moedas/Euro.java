package moedas;


public class Euro extends Moeda
{	
	public Euro(double valor)
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
