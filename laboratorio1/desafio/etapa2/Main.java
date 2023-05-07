import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        principal();
    }

    private static void principal() {
        Scanner keyboard = new Scanner(System.in);
        int opcao = 0;

        do {
        System.out.println("\n(1) criar uma loja");
        System.out.println("(2) criar um produto");
        System.out.println("(3) sair");

        try {
            opcao = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            // caso o usuário digite algo que não seja um número
            System.out.println("Opção inválida.");
            continue; // pula para a próxima iteração do loop
        }

        switch(opcao) {
            case 1:
                LojaEtapa2 l = criarLoja(keyboard);
                System.out.println(l.toString());
                System.out.println("gastos com salario: " + l.gastosComSalario());
                break;

            case 2:
                Produto p = criarProduto(keyboard);
                System.out.println(p.toString());
                System.out.println("" + (p.estaVencido(new Data(20, 10, 2023)) ? "PRODUTO VENCIDO": "PRODUTO NÃO VENCIDO" ));   
                break;

            case 3:
                System.out.println("Programa encerrado.");
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    } while (opcao != 3);
        keyboard.close();
    }

    public static Produto criarProduto(Scanner keyboard) {
        System.out.println("Digite o nome do produto:");
        String nome = keyboard.nextLine();
        
        System.out.println("Digite o preço do produto:");
        Double preco = keyboard.nextDouble();

        System.out.println("-------------------------");
        System.out.println("DATA DE INAUGURACAO DA LOJA");
        Data dataValidade = criarData(keyboard);
        
        return new Produto(nome, preco, dataValidade);
    }

    private static LojaEtapa2 criarLoja(Scanner keyboard) {
    
        System.out.println("Digite o nome da loja:");
        String nome = keyboard.nextLine();
        
        System.out.println("Digite a quantidade de funcionários da loja:");
        int quantidadeFuncionarios = Integer.parseInt(keyboard.nextLine());
        
        System.out.println("Digite o salário base dos funcionários da loja:");
        double salarioBaseFuncionario = Double.parseDouble(keyboard.nextLine());
    
        System.out.println("-------------------------");
        System.out.println("ENDERECO DA LOJA");
        
        Endereco endereco = criarEndereco(keyboard);
        
        System.out.println("-------------------------");
        System.out.println("DATA DE INAUGURACAO DA LOJA");
        Data dataFundacao = criarData(keyboard);
    
        return new LojaEtapa2(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
    }

    private static Data criarData(Scanner keyboard) {
        keyboard.next();
        System.out.println("Digite o dia:");
        int dia = keyboard.nextInt();
    
        System.out.println("Digite o mês:");
        int mes = keyboard.nextInt();
    
        System.out.println("Digite o ano:");
        int ano = keyboard.nextInt();
    
        return new Data(dia, mes, ano);
    }

    private static Endereco criarEndereco(Scanner keyboard) {
    
        System.out.println("Digite o nome da rua:");
        String nomeDaRua = keyboard.nextLine();
    
        System.out.println("Digite o número:");
        String numero = keyboard.nextLine();
    
        System.out.println("Digite o complemento:");
        String complemento = keyboard.nextLine();
    
        System.out.println("Digite a cidade:");
        String cidade = keyboard.nextLine();
    
        System.out.println("Digite o estado:");
        String estado = keyboard.nextLine();
    
        System.out.println("Digite o país:");
        String pais = keyboard.nextLine();
    
        System.out.println("Digite o CEP:");
        String cep = keyboard.nextLine();
    
        return new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);
    }
}
