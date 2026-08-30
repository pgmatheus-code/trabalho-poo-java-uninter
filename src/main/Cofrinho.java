package main;
import moedas.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Cofrinho
{
	// cotacoes (hard coded)
	public static double usdToBrl = 5.19;
	public static double eurToBrl = 6.02;
	public static String dataConsulta = "29/08/2026 13:28";
	public static String quebra = "\n"; // "\n---------------------------------------";
	
	// collection
	public static List<Moeda> listaMoedas = new ArrayList<Moeda>();
	
	// ponto de entrada
	public static void main(String[] args)
	{
		menuPrincipal();
	}
	
	// métodos de menu
	public static void menuPrincipal()
	{
		// flag para romper o main loop
		boolean finalizar = false;
		
		// main loop
		while (finalizar == false)
		{
			
			// imprime menu principal
			String str = "";
			
			str = str.concat(quebra)
			         .concat("\n----- Cofrinho Uninter: RU-5300260 ----")
			         .concat(quebra)
			         .concat( "\n1 - Adicionar moeda"
			         		+ "\n2 - Remover moeda"
			         		+ "\n3 - Listar moedas"
			         		+ "\n4 - Calcular total convertido em reais"
			         		+ "\n5 - Cotação"
			         		+ "\n6 - Encerrar")
			         .concat(quebra);
			
			print(str);
			
			// le console
			int opcao = lerOpcao();			
			
			// seleciona e chama menu scundário
			switch (opcao)
			{
				case 1:
				{
					menuAdicionarMoeda();				
					break;
				}
				case 2:
				{
					menuRemoverMoeda();
					break;
				}
				case 3:
				{
					listarMoedas();
					break;
				}
				case 4:
				{
					exibirTotalConvertido();
					break;
				}
				case 5:
				{
					exibirCotacao();
					break;
				}
				case 6:
				{					
					print("\nEncerrando programa...");
					finalizar = true;
					break;
				}
				default:
				{
					print("\nOpção inválida!");
					break;
				}
			}
		}
	}
	public static void menuAdicionarMoeda()
	{
		// imprime menu
		String str = "";
		
		str = str.concat(quebra)
		         .concat("\n-------- Adicionar moeda --------------")
		         .concat(quebra)
		         .concat( "\n1 - Real"
		         		+ "\n2 - Dólar"
		         		+ "\n3 - Euro")
		         .concat(quebra);			
		print(str);
		
		// variaveis locais switch/case
		Moeda moeda;
		double valor = 0;
		
		// le input
		int opcao = lerOpcao();
		
		// seleciona moeda e guarda valor
		switch (opcao)
		{
			case 1: // CASO REAL ----------
			{
				// escreve opção e lê input 
				print("\nReal escolhido.");
				valor = lerValor();
				
				// testa nulo ou negativo
				if (valorNuloOuNegativo(valor))
				{
					print("\nO valor informado deve ser maior do que zero");
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
				print("\nDólar escolhido.");
				valor = lerValor();
				
				// testa nulo ou negativo
				if (valorNuloOuNegativo(valor))
				{
					print("\nO valor informado deve ser maior do que zero");
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
				print("\nEuro escolhido.");
				valor = lerValor();				
				
				// testa nulo ou negativo
				if (valorNuloOuNegativo(valor))
				{
					print("\nO valor informado deve ser maior do que zero");
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
				print("\nValor inválido!");
				return;
			}	
		}
	}
	public static void menuRemoverMoeda()
	{
		// imprime menu
		String str = "";
		String quebra = "\n---------------------------------------";
		
		str = str.concat(quebra)
				 .concat("\n----------- Remover moeda -------------")
		         .concat(quebra)
		         .concat( "\n1 - Real"
		         		+ "\n2 - Dólar"
		         		+ "\n3 - Euro")
		         .concat(quebra);			
		print(str);
		
		// variaveis locais switch/case
		double valor = 0;
		
		// le input
		int opcao = lerOpcao();
		
		// seleciona moeda e guarda valor
		switch (opcao)
		{
			case 1: // CASO REAL ----------
			{
				// escreve opção e lê input 
				print("\nReal escolhido.");
				valor = lerValor();
				
				// testa nulo ou negativo
				if (valorNuloOuNegativo(valor))
				{
					print("\nO valor informado deve ser maior do que zero");
					return;
				}
				else
				{
					// busca para eliminação
					for (Moeda moeda : listaMoedas)
					{
						if (moeda.valor == valor && moeda instanceof Real)
						{
							// elimina o primeiro que encontra e retorna
							print("\n" + valor + " em " + moeda.nome + " for removido.");
							listaMoedas.remove(moeda);
							return;
						}
					}
					
					// exibe mensagem caso não encontre
					print("\nNenhuma moeda encontrada com o valor desejado.");	
				}
				
				break;
			}
			case 2: // CASO DÓLAR ---------
			{
				// escreve opção e lê input 
				print("\nDólar escolhido.");
				valor = lerValor();
				
				// testa nulo ou negativo
				if (valorNuloOuNegativo(valor))
				{
					print("\nO valor informado deve ser maior do que zero");
					return;
				}
				else
				{
					// busca para eliminação
					for (Moeda moeda : listaMoedas)
					{
						if (moeda.valor == valor && moeda instanceof Dolar)
						{
							// elimina o primeiro que encontra e retorna
							print("\n" + valor + " em " + moeda.nome + " for removido.");
							listaMoedas.remove(moeda);
							return;
						}
					}
					
					// exibe mensagem caso não encontre
					print("\nNenhuma moeda encontrada com o valor desejado.");
				}
				
				break;
			}
			case 3: // CASO EURO ----------
			{
				// escreve opção e lê input 
				print("\nEuro escolhido.");
				valor = lerValor();				
				
				// testa nulo ou negativo
				if (valorNuloOuNegativo(valor))
				{
					print("\nO valor informado deve ser maior do que zero");
					return;
				}
				else
				{
					// busca para eliminação
					for (Moeda moeda : listaMoedas)
					{
						if (moeda.valor == valor && moeda instanceof Euro)
						{
							// elimina o primeiro que encontra e retorna
							print("\n" + valor + " em " + moeda.nome + " for removido.");
							listaMoedas.remove(moeda);
							return;
						}
					}
					
					// exibe mensagem caso não encontre
					print("\nNenhuma moeda encontrada com o valor desejado.");
				}
				
				break;
			}
			default: // CASO INVÁLIDO -----
			{
				print("\nValor inválido!");
				return;
			}	
		}
	}	
	
	// métodos específicos
	public static void listarMoedas()
	{				
		// early return caso a lista esteja vazia
		if (listaMoedas.size() <= 0)
		{
			print(quebra);
			print("\nA lista de moedas está vazia!");
			return;
		}
		
		String str = "";
		// imprime lista	
		str = str.concat(quebra)
		         .concat("\n----------- Listar moedas -------------")
		         .concat(quebra);			
		
		for (Moeda moeda : listaMoedas)
		{
			if (moeda == null) continue;
							
			// escrever a moeda atual
			str = str.concat("\n" + moeda.nome + " - " + moeda.valor);
		}
		
		print(str);
	}
	public static void exibirTotalConvertido()
	{
		// imprime total
		String str = "";
		
		str = str.concat(quebra)
		         .concat("\n---------- Total convertido -----------")
		         .concat("\nO total convertido é: R$ " + String.valueOf(totalConvertido()))
		         .concat(quebra);		
		print(str);
	}
	public static void exibirCotacao()
	{
		// imprime total
		String str = "";
		
		str = str.concat(quebra)
		         .concat("\n--------------Cotação------------------")
		         .concat(quebra)			
		         .concat("\nDolar: " + usdToBrl)
		         .concat("\nEuro: " + eurToBrl)
		         .concat("\nData da cotação: " + dataConsulta);		
		print(str);
	}	
	
	// métodos genéricos
	public static double totalConvertido()
	{
		double totalConvertido = 0;
		
		// itera igual ao "foreach" do C#
		for (Moeda moeda : listaMoedas)
		{
			// pula moeda atual caso valor nulo
			if (moeda == null) continue;
			
			double valor;
			
			// converter se necessário
			if (moeda instanceof Dolar)
			{
				valor = moeda.converter(usdToBrl);
			}
			else if (moeda instanceof Euro)
			{
				valor = moeda.converter(eurToBrl);
			}
			else
			{
				valor = moeda.valor;
			}
			
			// incrementa valor da moeda atual no total
			totalConvertido += valor;
		}
		
		return totalConvertido;
	}
	public static int lerOpcao()
	{
		// instancia scanner para ler input da console
		Scanner console = new Scanner(System.in);
		
		// prepara usuario para input
		print("\nPor favor, digite uma opção: ");
		int inteiro = 0;
		
		// lê e armazena
		try
		{
			inteiro = console.nextInt();		
			print(quebra);
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
	public static double lerValor()
	{
		// instancia scanner para ler input da console
		Scanner console = new Scanner(System.in);
		
		// prepara usuario para input
		print("\nDigite o valor desejado:");
		double valor = 0;
				
		// lê e armazena
		try
		{
			valor = console.nextDouble();		
			print(quebra);
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
	public static boolean valorNuloOuNegativo(double valor)
	{
		return valor <= 0;
	}
	public static void print(String txt)
	{
		System.out.print(txt);
	}
}
