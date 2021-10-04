public class ItensPorQuantidade {

    static int pao = 3600;
    static int torta = 4;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;


    public static int calcularQuantidadeVendida(String item, int quantidade) {
        int qtdVendida = quantidade;
        switch (item){
            case "pao":
                pao -= quantidade;
                if(pao < 0){
                    qtdVendida = quantidade + pao;
                    pao = 0;
                }
                break;
            case "torta":
                torta -= quantidade;
                if(torta < 0){
                    qtdVendida = quantidade + torta;
                    torta = 0;
                }
                break;
            case "sanduiche":
                sanduiche -= quantidade;
                if(sanduiche < 0){
                    qtdVendida = quantidade + sanduiche;
                    sanduiche = 0;
                }
                break;
            case "leite":
                leite -= quantidade;
                if(leite < 0){
                    qtdVendida = quantidade + leite;
                    leite = 0;
                }
                break;
            case "cafe":
                cafe -= quantidade;
                if(cafe < 0){
                    qtdVendida = quantidade + cafe;
                    cafe = 0;
                }
                break;
        }

        return qtdVendida;
    }
}
