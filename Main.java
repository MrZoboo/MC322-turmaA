public class Main {

    public static void main(String[] args){

        // Criando um objeto da classe Veículo

        Veiculo CarroBrabo = new Veiculo("JEK4499", "Ford", "Maverick V8 1976");

        // Testando Getters e Setters:
        System.out.println("****VEICULO ORIGINAL****");
        System.out.println("Placa: " + CarroBrabo.getPlaca());
        System.out.println("Marca: " + CarroBrabo.getMarca());
        System.out.println("Modelo: " + CarroBrabo.getModelo());

        CarroBrabo.setPlaca("KEJ6677");
        CarroBrabo.setMarca("NISSAN");
        CarroBrabo.setModelo("Kicks 6cc 2020");

        System.out.println("\n****VEICULO ALTERADO****");
        System.out.println("Placa: " + CarroBrabo.getPlaca());
        System.out.println("Marca: " + CarroBrabo.getMarca());
        System.out.println("Modelo: " + CarroBrabo.getModelo());

        System.out.println("\n#################\n");


        //Criando um objeto da classe Sinistro

        Sinistro sinistro = new Sinistro(5668899, "24/08/2002", "Guará 2, Brasília");

        // Testando Getters e Setters
        System.out.println("****SINISTRO ORIGINAL****");
        System.out.println("Id: " + sinistro.getId());
        System.out.println("Data: " + sinistro.getData());
        System.out.println("Endereco: " + sinistro.getEndereco());
        
        sinistro.setId(1111111);
        sinistro.setData("28/02/2003");
        sinistro.setEndereco("Barao Geraldo, Campinas");

        System.out.println("\n****SINISTRO ALTERADO****");
        System.out.println("Id: " + sinistro.getId());
        System.out.println("Data: " + sinistro.getData());
        System.out.println("Endereco: " + sinistro.getEndereco());

        System.out.println("\n#################\n");

        //Criando um objeto da classe Seguradora

        Seguradora seguradora = new Seguradora("Carros Seguros", "(19)3776-8899", "carrosseguros@gmail.com", "Faria lima");
        
        // Testando Getters e Setters:
        System.out.println("****SEGURADORA ORIGINAL****");
        System.out.println("Nome: " + seguradora.getNome());
        System.out.println("Email: " + seguradora.getEmail());
        System.out.println("Telefone: " + seguradora.getTelefone());
        System.out.println("Endereco: " + seguradora.getEndereco());

        seguradora.setNome("Carros Nada Seguros");
        seguradora.setTelefone("(61)9966-5544");
        seguradora.setEmail("carrosvulneraveis@hotmail.com");
        seguradora.setEndereco("Brasilia");

        System.out.println("\n****SEGURADORA ALTERADA****");
        System.out.println("Nome: " + seguradora.getNome());
        System.out.println("Email: " + seguradora.getEmail());
        System.out.println("Telefone: " + seguradora.getTelefone());
        System.out.println("Endereco: " + seguradora.getEndereco());

        System.out.println("\n#################\n");
        

        // Criando um objeto da classe Cliente

        Cliente Gabriel = new Cliente("Gabriel","111.444.777-35.", "26/04/2002", 20, "Barao Geraldo" );

        // Testando o Método ToString
        System.out.println("****CLIENTE ORIGINAL****");
        System.out.println(Gabriel.toString());

        Gabriel.setNome("Biel");
        Gabriel.setCpf("555.333.222-43");
        Gabriel.setDataNascimento("20/08/1992");
        Gabriel.setIdade(30);
        Gabriel.setEndereco("Sao Jose dos Cammpos");

        System.out.println("****CLIENTE ALTERADO****");
        System.out.println(Gabriel.toString());

        // Testando o metodo de validacao do cpf
        System.out.println(Gabriel.validarCPF(Gabriel.getCpf())); // 555.333.222-43 não é valido
        Gabriel.setCpf("111.111.111-11");
        System.out.println(Gabriel.validarCPF(Gabriel.getCpf())); // 111.111.111-11 não é válido
        Gabriel.setCpf("111.444.777-35"); 
        System.out.println(Gabriel.validarCPF(Gabriel.getCpf())); // 111.444.777-35 é válido
        Gabriel.setCpf("111.111-56");
        System.out.println(Gabriel.validarCPF(Gabriel.getCpf())); // 111.111-56 não é válido
    }
}
