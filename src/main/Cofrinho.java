package main;
import moedas.*;
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
	public static List<Moeda> listaMoedas = new ArrayList<Moeda>();
	
	// ponto de entrada
	public static void main(String[] args)
	{
		ProgramaPrincipal();
	}
	
	// métodos principais
	public static void ProgramaPrincipal()
	{
		// flag para romper o main loop
		boolean finalizar = false;
		
		// main loop
		while (finalizar == false)
		{
			// imprime menu principal
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
			
			Print(str);
			
			// le console
			int opcao = LerOpcao();			
			
			// seleciona e chama menu scundário
			switch (opcao)
			{
				case 1:
				{
					MenuAdicionarMoeda();				
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
	public static void MenuAdicionarMoeda()
	{
		// imprime menu
		String str = "";
		String quebra = "\n---------------------------------------";
		
		str = str.concat(quebra)
		         .concat("\n---------Adicionar-moeda---------------")
		         .concat(quebra)
		         .concat( "\n1 - Real"
		         		+ "\n2 - Dólar"
		         		+ "\n3 - Euro")
		         .concat(quebra);			
		Print(str);
		
		// variaveis locais switch/case
		Moeda moeda;
		double valor = 0;
		
		// le input
		int opcao = LerOpcao();
		
		// seleciona moeda e guarda valor
		switch (opcao)
		{
			case 1: // CASO REAL ----------
			{
				// escreve opção e lê input 
				Print("\nReal escolhido.");
				valor = LerValor("reais");
				
				// testa nulo ou negativo
				if (ValorNuloOuNegativo(valor))
				{
					Print("\nO valor informado deve ser maior do que zero");
					return;
				}
				else
				{
					// insere a moeda caso tudo certo
					moeda = new Real(valor);
					listaMoedas.add(moeda);
				}
				
				break;
			}
			case 2: // CASO DÓLAR ---------
			{
				// escreve opção e lê input 
				Print("\nDólar escolhido.");
				valor = LerValor("dólares");
				
				// testa nulo ou negativo
				if (ValorNuloOuNegativo(valor))
				{
					Print("\nO valor informado deve ser maior do que zero");
					return;
				}
				else
				{
					// insere a moeda caso tudo certo
					moeda = new Dolar(valor);
					listaMoedas.add(moeda);
				}
				
				break;
			}
			case 3: // CASO EURO ----------
			{
				// escreve opção e lê input 
				Print("\nEuro escolhido.");
				valor = LerValor("euros");				
				
				// testa nulo ou negativo
				if (ValorNuloOuNegativo(valor))
				{
					Print("\nO valor informado deve ser maior do que zero");
					return;
				}
				else
				{
					// insere a moeda caso tudo certo
					moeda = new Euro(valor);
					listaMoedas.add(moeda);
				}
				
				break;
			}
			default: // CASO INVÁLIDO -----
			{
				Print("\nValor inválido!");
				return;
			}	
		}
	}
	
	// métodos específicos
	public Moeda AdicionarMoeda(Moeda moeda)
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
	
	// métodos genéricos
	public static int LerOpcao()
	{
		// instancia scanner para ler input da console
		Scanner console = new Scanner(System.in);
		
		// prepara usuario para input
		Print("\nPor favor, digite uma opção: ");
		int inteiro = 0;
		
		// lê e armazena
		try
		{
			inteiro = console.nextInt();		
			Print("---------------------------------------");
		}
		catch(Exception e)
		{
			// caso pegue InputMismatchException
			// ou outra qualquer, não faz nada
			// já foi tratado no switch/case que vem depois
		}
		
		//retorna opcao lida
		return inteiro;
	}
	public static double LerValor(String moeda)
	{
		// instancia scanner para ler input da console
		Scanner console = new Scanner(System.in);
		
		// prepara usuario para input
		Print("\nPor favor, digite o valor em "+moeda+": ");
		double valor = 0;
				
		// lê e armazena
		try
		{
			valor = console.nextDouble();		
			Print("---------------------------------------");
		}
		catch(Exception e)
		{
			// caso pegue InputMismatchException
			// ou outra qualquer, não faz nada
			// já foi tratado no switch/case que vem depois
		}
		
		//retorna valor lido
		return valor;
	}
	public static boolean ValorNuloOuNegativo(double valor)
	{
		return valor <= 0;
	}
	public static void Print(String txt)
	{
		System.out.print(txt);
	}
}
