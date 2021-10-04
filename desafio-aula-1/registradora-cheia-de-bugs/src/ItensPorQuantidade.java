public class ItensPorQuantidade {

    static int pao = 3600;
    static int torta = 4;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;


    public static int calcularQuantidadeVendida(String item, int quantidade) {
        int qtdVendida = 0;
        switch (item){
            case "pao":
                if(pao < quantidade * 60){
                    qtdVendida = pao / 60;
                } else{
                    qtdVendida = quantidade;
                }
                pao -= qtdVendida * 60;
                break;

            case "torta":
                if(torta < quantidade){
                    qtdVendida = torta;
                } else{
                    qtdVendida = quantidade;
                }
                torta -= qtdVendida;
                break;

            case "sanduiche":
                if(sanduiche < quantidade){
                    qtdVendida = sanduiche;
                } else{
                    qtdVendida = quantidade;
                }
                sanduiche -= qtdVendida;
                break;

            case "leite":
                if(leite < quantidade){
                    qtdVendida = leite;
                } else{
                    qtdVendida = quantidade;
                }
                leite -= qtdVendida;
                break;

            case "cafe":
                if(cafe < quantidade){
                    qtdVendida = cafe;
                } else{
                    qtdVendida = quantidade;
                }
                cafe -= qtdVendida;
                break;
        }

        return qtdVendida;
    }
}
