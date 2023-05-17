import java.sql.Date;
import java.util.Scanner;

public class AppMain {
	public static final Seguradora seguradora_global = new Seguradora("MC322 INSURANCE", "(19)99955-6678", "mcinsurance@hotmail.com", "Barao Geraldo");
	//exibir menu externo
	private static void exibirMenuExterno() {
		MenuOperacoes menuOperacoes[] = MenuOperacoes.values();
		System.out.println("Menu principal");
		for(MenuOperacoes op: menuOperacoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
	private static void exibirSubmenu(MenuOperacoes op) {
		SubmenuOperacoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOperacoes lerOpcaoMenuExterno() {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		MenuOperacoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOperacoes.values().length - 1);
		opUsuarioConst = MenuOperacoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//ler opção dos submenus
	private static SubmenuOperacoes lerOpcaoSubmenu(MenuOperacoes op) {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		SubmenuOperacoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOperacoes op) {
		Scanner scanner = new Scanner(System.in);
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case GERAR_SINISTRO:
			if(seguradora_global.listaClientes.size() == 0){
				System.out.println("Nao podemos gerar sinistros. Nenhum cliente e/ou veiculo foi cadastrado ate o momento");
				System.out.println("Cadastre algum cliente e algum veiculo e retorne para gerar sinistros");
			}
			else{
				System.out.println("Entre com a data do sinistro valida (formato yyyy-mm-dd, ex: 1999-04-11): ");
				String data = scanner.nextLine();
				System.out.println("Entre com o endereco: ");
				String endereco = scanner.nextLine();

				System.out.println("A qual cliente deseja associar o sinistro?");
				for(Cliente x: seguradora_global.listaClientes){
					System.out.println(x.getNome());
				}
				String nome;
				boolean valido = false;
				do {
					System.out.println("Entre com um nome valido");
					nome = scanner.nextLine();
					for(Cliente x: seguradora_global.listaClientes){
						if(nome.equals(x.getNome())){
							System.out.println("A Qual veiculo de " + nome + " deseja gerar o sinistro?");
							for(Veiculo v: x.listaVeiculos){
								System.out.println(v.getModelo() + " " + v.getPlaca());
							}
							String placa;
							boolean deucerto = false;
							do {
								System.out.println("Digite uma placa valida: ");
								placa = scanner.nextLine();
								for(Veiculo v: x.listaVeiculos){
									if(placa.equals(v.getPlaca())){
										seguradora_global.gerarSinistro(Date.valueOf(data), endereco, seguradora_global, v, x);
										deucerto = true;
										break;
									}
								}
							} while (deucerto == false);
							valido = true;
							break;
						}
					}
				} while (valido == false);
				
			}
				break;
			case TRANSFERIR_SEGURO:
				System.out.println("Lista de clientes: ");
				for(Cliente c: seguradora_global.listaClientes){
					System.out.println(c.getNome());
				}
				String nome1;
				String nome2;
				System.out.println("Digite o nome do cliente que transferirá o seguro");
				nome1 = scanner.nextLine();
				System.out.println("Entre com o nome do cliente que receberá o seguro");
				nome2 = scanner.nextLine();
				for(Cliente c: seguradora_global.listaClientes){
					if(nome1.equals(c.getNome())){
						for(Cliente c2: seguradora_global.listaClientes){
							if(nome2.equals(c2.getNome())){
								seguradora_global.transferenciaSeguro(c, c2);
							}
						}
					}
				}
				break;
			case CALCULAR_RECEITA:
				System.out.println("RECEITA: " + seguradora_global.calculaReceita());
				break;
			case SAIR:
                break;
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu) {
		Scanner scanner = new Scanner(System.in);	
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
			System.out.println("Entre com o espefificador PF (digite 1) ou PJ (digite 2)");
			String especificador = scanner.nextLine();
			
			if(especificador.equals("1")){
				String nome;
				do {
					System.out.println("Entre com um nome valido: ");
					nome = scanner.nextLine();
				} while (MenuOperacoes.Validacao.validaNome(nome) == false);

				System.out.println("Entre com o endereco: ");
				String endereco = scanner.nextLine();

				String cpf;
				do {
					System.out.println("Entre com um cpf valido: (dica: 11.444.777-35)");
					cpf = scanner.nextLine();
				} while (MenuOperacoes.Validacao.validaCPF(cpf) == false);
				System.out.println("Entre com o genero: ");
				String genero = scanner.nextLine();
				System.out.println("Entre com uma data de licenca valida (formato yyyy-mm-dd, ex: 1999-04-11): ");
				String dataLicenca = scanner.nextLine();
				System.out.println("Entre com o nivel de escolaridade: ");
				String educacao = scanner.nextLine();
				System.out.println("Entre com uma data de nascimento valida (formato yyyy-mm-dd, ex: 1999-04-11): ");
				String dataNascimento = scanner.nextLine();
				System.out.println("Entre com a classe economica: ");
				String classeEconomica = scanner.nextLine();

				ClientePF cliente = new ClientePF(nome, endereco, 0, cpf, genero, Date.valueOf(dataLicenca), educacao, Date.valueOf(dataNascimento), classeEconomica);
				seguradora_global.cadastroCliente(cliente);
			}
			else{
				String nome;
				do {
					System.out.println("Entre com o nome da empresa valido: ");
					nome = scanner.nextLine();
				} while (MenuOperacoes.Validacao.validaNome(nome) == false);
				System.out.println("Entre com o endereco: ");
				String endereco = scanner.nextLine();
				String cnpj;
				do {
					System.out.println("Entre com um cnpj valido: (dica: 18781203/0001-28)");
					cnpj = scanner.nextLine();
				} while (MenuOperacoes.Validacao.validaCNPJ(cnpj) == false);
				System.out.println("Entre com uma data de fundacao da empresa valida (formato yyyy-mm-dd, ex: 1999-04-11): ");
				String dataFundacao = scanner.nextLine();
				System.out.println("Entre com a quantidade de funcionarios na empresa: ");
				String qtdeFuncionarios = scanner.nextLine();
				int qtde = Integer.valueOf(qtdeFuncionarios);
				ClientePJ cliente = new ClientePJ(nome, endereco, 0, cnpj, Date.valueOf(dataFundacao), qtde);
				seguradora_global.cadastroCliente(cliente);
			}
			break;
		case CADASTRAR_VEICULO:
			if(seguradora_global.listaClientes.size() == 0){
				System.out.println("Nao podemos cadastrar veiculos. Nenhum cliente foi cadastrado ate o momento");
				System.out.println("Cadastre algum cliente e retorne para cadastrar seu veiculo");
			}
			else{
				System.out.println("Entre com a placa do carro: ");
				String placa = scanner.nextLine();
				System.out.println("Entre com a marca do carro: ");
				String marca = scanner.nextLine();
				System.out.println("Entre com o modelo do carro: ");
				String modelo = scanner.nextLine();
				System.out.println("Entre com o ano de fabricacao do carro (um numero inteiro)");
				String anoFabricacao = scanner.nextLine();

				int ano = Integer.valueOf(anoFabricacao);
				Veiculo veiculo = new Veiculo(placa, marca, modelo, ano);
				System.out.println("A qual cliente deseja associar o veiculo? ");
				for(Cliente x: seguradora_global.listaClientes){
					System.out.println(x.getNome());
				}
				String nome;
				boolean valido = false;
				do {
					System.out.println("Digite um nome valido: ");
					nome = scanner.nextLine();
					for(Cliente x: seguradora_global.listaClientes){
						if(nome.equals(x.getNome())){
							x.adicionaVeiculo(veiculo);
							seguradora_global.adicionaVeiculo(veiculo);
							valido = true;
							break;
						}
					}
				} while (valido == false);

			}
			break;
		case CADASTRAR_SEGURADORA:
			System.out.println("Por comodidade, criamos uma seguradora global, em que todos os demais cadastros são realizados");
			System.out.println("Aperte enter para voltar");
			String sair = scanner.nextLine();
			break;
		case LISTAR_CLIENTES:
			if(seguradora_global.listaClientes.size() == 0){
				System.out.println("Nao podemos listar clientes. Nenhum cliente foi cadastrado ate o momento");
				System.out.println("Cadastre algum cliente e retorne para consultar a lista de clientes");
			}
			else{
				seguradora_global.listarClientes();
			}
			break;
		case LISTAR_SINISTROS:
			if(seguradora_global.listaSinistros.size() == 0){
				System.out.println("Nao podemos listar sinistros. Nenhum sinistro foi gerado ate o momento");
				System.out.println("Gere algum sinsitro e retorne para cadastrar seu veiculo");
			}
			else{
				seguradora_global.listarSinistros();
			}
			break;
		case LISTAR_VEICULOS:
			int ncarros = 0;
			for(Cliente x: seguradora_global.listaClientes){
				ncarros += x.listaVeiculos.size();
			}
			if(ncarros == 0){
				System.out.println("Nenhum veiculo encontrado! Volte para cadastrar um veiculo");
			}
			else{
				for(Cliente x: seguradora_global.listaClientes){
					for(Veiculo v: x.listaVeiculos){
						v.toString();
					}
				}
			}
			break;
		case EXCLUIR_CLIENTE:
			System.out.println("Entre com o nome do cliente que deseja excluir: ");
			for(Cliente x: seguradora_global.listaClientes){
				System.out.println(x.getNome());
			}
			String nome;
			boolean valido = false;
			do {
				System.out.println("Digite um nome valido: ");
				nome = scanner.nextLine();
				for(Cliente x: seguradora_global.listaClientes){
					if(nome.equals(x.getNome())){
						seguradora_global.removerCliente(x);
						valido = true;
						break;
					}
				}
			} while (valido == false);
			break;
		case EXCLUIR_VEICULO:
			System.out.println("Qual veiculo deseja excluir? ");
			for(Veiculo v: seguradora_global.listaVeiculos){
				System.out.println(v.getModelo() + " " + v.getPlaca());
			}
			String placa;
			boolean valido3 = false;
			do {
				System.out.println("Entre com uma placa valida");
				placa = scanner.nextLine();
				for(Veiculo v: seguradora_global.listaVeiculos){
					if(placa.equals(v.getPlaca())){
						seguradora_global.listaVeiculos.remove(v);
						valido3 = true;
						break;
					}
				}
			} while (valido3 == false);
			
			
			break;
		case EXCLUIR_SINISTRO:
			for(Sinistro x: seguradora_global.listaSinistros){
				System.out.println("ID: " + x.getId() + " Nome: " + x.getCliente().getNome());
			}
			String id;
			boolean valido2 = false;
			do {
				System.out.println("Digite um id valido: ");
				id = scanner.nextLine();
				int ID = Integer.valueOf(id);
				for(Sinistro x: seguradora_global.listaSinistros){
					if(x.getId() == ID){
						seguradora_global.listaSinistros.remove(x);
						valido2 = true;
						break;
					}
				}
			} while (valido2 == false);
			break;
		case VOLTAR:
			break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOperacoes op) {
		SubmenuOperacoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu);
		}while(opSubmenu != SubmenuOperacoes.VOLTAR);
	}
	
	//executa o menu externo: exibição do menu, leitura da opção e execução da opção
	public static void main(String[] args) {

        // Instanciando 2 veiculos:
        Veiculo veiculo1 = new Veiculo("JEK8899", "Ford", "Maverick", 1976);
        Veiculo veiculo2 = new Veiculo("PAC3355", "Mercedes", "C-180", 2002);
        
        //Instanciando 2 clientes (PF e PJ) e uma seguradora:
        ClientePF clientepf = new ClientePF("Gabriel", "Barao Geraldo", 0.0, "111.444.777-35", "masculino", Date.valueOf("2023-03-10"), "Universitario", Date.valueOf("2002-03-10") , "Classe media");
        ClientePJ clientepj = new ClientePJ("Localiza", "Aeroporto VCP", 0, "18781203/0001-28", Date.valueOf("2007-04-11"), 1000);
        Seguradora  seguradora1 = new Seguradora("MC322 INSURANCE", "(19)99955-6678", "mcinsurance@hotmail.com", "Barao Geraldo");

        //Adicionando pelo menos 1 veiculo em cada cliente instanciado:
        clientepf.adicionaVeiculo(veiculo1);
        clientepj.adicionaVeiculo(veiculo2);

        //Cadastrando pelo menos um cliente (pf e pj) na seguradora:
        seguradora1.cadastroCliente(clientepf);
        seguradora1.cadastroCliente(clientepj);

        //Gerando 2 sisnistros:
        seguradora1.gerarSinistro(Date.valueOf("2013-04-11"), "Campinas", seguradora1, veiculo1, clientepf);
        seguradora1.gerarSinistro(Date.valueOf("2023-02-10"), "Brasilia", seguradora1, veiculo2, clientepj);
        
        // O CÁLCULO DO PRECO DO SEGURO E A ATUALIZACAO DO MESMO ESTAO ACONTECENDO AUTOMATICAMENTE NA CLASSE SEGURADORA
        System.out.println("***CLIENTES***");
        seguradora1.listarClientes();
        System.out.println("***SINISTROS***");
        seguradora1.listarSinistros();
        System.out.println("***VISUALIZANDO SINISTRO DE GABRIEL***");
        seguradora1.visualzarSinistro("Gabriel");
        System.out.println("***CALCULO DA RECEITA***");
        System.out.println(seguradora1.calculaReceita());


        //CHAMANDO O MENU DE OPERACOES
		MenuOperacoes op;
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}while(op != MenuOperacoes.SAIR);
		System.out.println("Saiu do sistema");
        
	}

}