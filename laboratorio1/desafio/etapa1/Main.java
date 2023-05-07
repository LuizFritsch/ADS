class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Pepino", 10.0);
        Loja loja = new Loja("Taqi", 20);
        Loja loja2 = new Loja("Lebes", 100, 2500);
        Endereco endereco = new Endereco("Albertino Saraiva", "Taquari", "RS", "Brasil", "95860-000", "123", "-");
        Data data = new Data(1, 1, 2000);
        
        System.out.println(produto.toString());
        System.out.println(loja.toString());
        System.out.println(loja2.toString());
        System.out.println(endereco.toString());
        System.out.println(data.toString());
    }
}