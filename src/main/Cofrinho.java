package main;
import moedas.Moeda;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Cofrinho
{
	// cotacoes
	public static double usdToBrl = 5.19;
	public static double eurToBrl = 6.02;
	public static String dataConsulta = "29/08/2026 13:28";
	
	// collection
	List<Moeda> listaMoedas = new ArrayList<Moeda>();
	
	// ponto de entrada
	public static void main(String[] args)
	{
		// flag para romper o main loop
		boolean finalizar = false;
		
		// main loop
		while (finalizar == false)
		{
			// imprime menu principal
			Print(MenuPrincipal());
			
			// le console
			int opcao = LerOpcao();
			Print("---------------------------------------");
			
			switch (opcao)
			{
				case 1:
				{
					Print("\nAdicionar Moeda Escolhido.");
					break;
				}
				case 2:
				{
					Print("\nRemover Moeda escolhido.");
					break;
				}
				case 3:
				{
					Print("\nListar Moedas escolhido.");
					break;
				}
				case 4:
				{
					Print("\nCalcular Total escolhido.");
					break;
				}
				case 5:
				{					
					Print("\nEncerrando programa...");
					finalizar = true;
					break;
				}
				default:
				{
					Print("\nOpção inválida!");
					break;
				}
			}
		}		
	}
	
	public static void Print(String txt)
	{
		System.out.print(txt);
	}
	
	public static int LerOpcao()
	{
		// instancia scanner para ler input da console
		Scanner console = new Scanner(System.in);
		
		// prepara usuario para input
		Print("\nPor favor, digite uma opção: ");
		
		// lê e armazena
		int inteiro = console.nextInt();
		
		//retorna valor lido
		return inteiro;
	}
	
	public static String MenuPrincipal()
	{
		
		String str = "";
		String quebra = "\n---------------------------------------";
		
		str = str.concat(quebra)
		         .concat("\n------Cofrinho-Uninter:-RU-5300260-----")
		         .concat(quebra)
		         .concat( "\n1 - Adicionar moeda"
		         		+ "\n2 - Remover moeda"
		         		+ "\n3 - Listar moedas"
		         		+ "\n4 - Calcular total convertido em reais"
		         		+ "\n5 - Encerrar")
		         .concat(quebra);
			
		return str;
	}
	
	public Moeda Adicionar(Moeda moeda)
	{
		listaMoedas.add(moeda);
		return moeda;
	}
	
	public Moeda RemoverMoeda(Moeda moeda)
	{
		listaMoedas.remove(moeda);
		return moeda;
	}
	
	public void ListagemMoedas()
	{
		// provavelmente retornará uma
		// string construida por loop
		// pois se fosse para retornar
		// a ArrayList não precisaria de
		// método.
	}
	
	public double TotalConvertido()
	{
		double totalConvertido = 0;
		
		// itera igual ao "foreach" do C#
		for (Moeda moeda : listaMoedas)
		{
			// pula moeda atual caso valor nulo
			if (moeda == null) continue;
			
			// incrementa valor da moeda atual no total
			totalConvertido += moeda.valor;
		}
		
		return totalConvertido;
	}
}
