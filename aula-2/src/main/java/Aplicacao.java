public class Aplicacao {

    public static void main(String[] args) {
        Filme filme1 = new Filme("Interestelar", "Conta a história de uma equipe de astronautas que viaja através de um buraco de minhoca à procura de um novo lar para a humanidade.", 169, 2014, 5, new Diretor("Christopher Nolan", 51, 10));
        Filme filme2 = new Filme("12 Homens e Uma Sentença", "Gira em torno de um julgamento, onde um jovem porto-riquenho é acusado de ter matado o próprio pai.", 95, 1957, 5, new Diretor("Sidney Lumet", 87, 5));

        filme1.reproduzirFilme();
        filme2.reproduzirFilme();
    }

}
