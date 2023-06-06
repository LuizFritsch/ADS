import java.util.Stack;

public class MainBrackets {
    public static void testBrackets(String[] args){
        if (args.length < 1) {
            System.out.println("Uso: java Main \"<expressao>\"");
            return;
        }

        String expressao = args[0];
        Stack<Character> pilhaExpressao = new Stack<>();
        for (char c : expressao.toCharArray()) {
            pilhaExpressao.push(c);
        }

        Etapa3 etapa3 = new Etapa3();
        boolean bracketsCorretos = etapa3.checkBrackets(pilhaExpressao);
        System.out.println("Os parênteses na expressão estão agrupados corretamente? " + (bracketsCorretos == true ? "Sim" : "Não"));
    }
    
    public static void main(String[] args) {
        testBrackets(args);
    }
}
