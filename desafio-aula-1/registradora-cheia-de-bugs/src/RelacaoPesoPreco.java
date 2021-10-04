public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;
        double qtdDouble = qtd;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * (qtdDouble * 60 / 1000);
        }

        if ("torta".equals(item)) {
            precoTotal = 96.00 * (qtdDouble / 16);
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * qtdDouble;
        }

        if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtdDouble;
        }

        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtdDouble;
        }

        return precoTotal;
    }
}
