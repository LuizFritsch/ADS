public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (!validarData(dia, mes, ano)) {
            System.out.println("Data inválida! Alterando para 01/01/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        } else {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    // Getter e Setter para o atributo dia
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    // Getter e Setter para o atributo mes
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    // Getter e Setter para o atributo ano
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return String.format("\nData\n%d/%d/%d", dia, mes, ano);
    }

    // Método para verificar se o ano é bissexto (Fevereiro tem 29 dias)
    public boolean verificaAnoBissexto() {
        if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
            return true;
        }
        return false;
    }

    // Método para verificar se a data é válida
    // meses válidos: 1 a 12
    // dias válidos: 1 a 31 (dependendo do mês)
    private boolean validarData(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) {
            return false;
        }

        if (dia < 1 || dia > numeroDiasNoMes(mes, ano)) {
            return false;
        }

        if(ano < 0){
            return false;
        }

        return true;
    }

    // Método para retornar o número de dias no mês
    // Copiado de uma colega pois achei bonito
    private int numeroDiasNoMes(int mes, int ano) {
        switch (mes) {
            case 2:
                if (verificaAnoBissexto()) {
                    return 29;
                }
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}
