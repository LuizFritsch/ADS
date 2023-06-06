package Etapa1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
    private char[][] labirinto;

    public Labirinto() {
        this.labirinto = null;
    }

    public void criaLabirinto(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int linha = 0;
            while ((line = br.readLine()) != null) {
                if (this.labirinto == null) {
                    this.labirinto = new char[line.length()][line.length()];
                }

                for (int coluna = 0; coluna < line.length(); coluna++) {
                    this.labirinto[linha][coluna] = line.charAt(coluna);
                }
                linha++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean percorreLabirinto() {
        if (this.labirinto == null) {
            return false;
        }

        // Verificar se o destino é alcançável antes de iniciar a busca
        boolean destinoAlcancavel = false;
        for (char[] linha : this.labirinto) {
            for (char celula : linha) {
                if (celula == 'D') {
                    destinoAlcancavel = true;
                    break;
                }
            }
            if (destinoAlcancavel) break;
        }

        if (!destinoAlcancavel) return false;

        return percorreLabirinto(0, 0);
    }

    private boolean percorreLabirinto(int linha, int coluna) {
        if (linha < 0 || linha >= this.labirinto.length ||
            coluna < 0 || coluna >= this.labirinto[0].length ||
            this.labirinto[linha][coluna] == 'X') {
            return false;
        }
    
        if (this.labirinto[linha][coluna] == 'D') {
            return true;
        }
    
        this.labirinto[linha][coluna] = 'X';
    
        if (percorreLabirinto(linha + 1, coluna) ||
            percorreLabirinto(linha - 1, coluna) ||
            percorreLabirinto(linha, coluna + 1) ||
            percorreLabirinto(linha, coluna - 1)) {
            return true;
        }
    
        // Não é necessário marcar como 'X' novamente
        return false;
    }

    public void exibeLabirinto() {
        StringBuilder labirintoString = new StringBuilder();
        for (char[] linha : this.labirinto) {
            for (char celula : linha) {
                labirintoString.append(celula).append(" ");
            }
            labirintoString.append("\n");
        }
        System.out.println(labirintoString.toString());
    }

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Você esqueceu de fornecer o nome do arquivo :)");
            return;
        }
        Labirinto lab = new Labirinto();
        lab.criaLabirinto(args[0]);
        lab.exibeLabirinto();
        var existeSaida = lab.percorreLabirinto() ? "Sim" : "Não";
        System.out.println("Existe saída do labirinto? " + existeSaida);
    }
}
