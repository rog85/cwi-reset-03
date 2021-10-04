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
                qtdVendida = pao < quantidade * 60 ? pao / 60 : quantidade;
                pao -= qtdVendida * 60;
                break;

            case "torta":
                qtdVendida = Math.min(torta, quantidade);
                torta -= qtdVendida;
                break;

            case "sanduiche":
                qtdVendida = Math.min(sanduiche, quantidade);
                sanduiche -= qtdVendida;
                break;

            case "leite":
                qtdVendida = Math.min(leite, quantidade);
                leite -= qtdVendida;
                break;

            case "cafe":
                qtdVendida = Math.min(cafe, quantidade);
                cafe -= qtdVendida;
                break;
        }

        return qtdVendida;
    }

    public static int retornaQuantidadeItem(String item){
        int qtd = 0;
        switch (item){
            case "pao":
                qtd = pao;
                break;
            case "torta":
                qtd = torta;
                break;
            case "sanduiche":
                qtd = sanduiche;
                break;
            case "leite":
                qtd = leite;
                break;
            case "cafe":
                qtd = cafe;
                break;
        }
        return qtd;
    }
}
