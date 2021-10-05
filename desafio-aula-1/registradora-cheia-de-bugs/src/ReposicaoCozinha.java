public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("pao".equals(item)) {
            ItensPorQuantidade.pao += 3600;
            System.out.println(String.format("Solicitando mais pão!"));
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.torta += 64;
            System.out.println(String.format("Solicitando mais torta!"));
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche += 20;
            System.out.println(String.format("Solicitando mais sanduiche!"));
        }
    }
}
