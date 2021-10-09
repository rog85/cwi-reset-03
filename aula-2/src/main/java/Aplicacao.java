import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        Diretor diretor1 = new Diretor("Christopher Nolan", LocalDate.parse("1970-07-30"), 10, Genero.MASCULINO);
        Diretor diretor2 = new Diretor("Sidney Lumet", LocalDate.parse("1924-04-25"), 5, Genero.MASCULINO);
        Filme filme1 = null;
        Filme filme2 = null;
        Filme filme3 = null;
        Filme filme4 = null;
        try {
            filme1 = new Filme("Interestelar", "Conta a história de uma equipe de astronautas que viaja através de um buraco de minhoca à procura de um novo lar para a humanidade.", 169, 2014, 6, diretor1);
            filme1.reproduzirFilme();
        } catch (AvaliacaoForaDoPadraoException e) {
            System.out.println(e.getMessage());
        }
        try {
            filme2 = new Filme("12 Homens e Uma Sentença", "Gira em torno de um julgamento, onde um jovem porto-riquenho é acusado de ter matado o próprio pai.", 95, 1957, 5, diretor2);
            filme2.reproduzirFilme();
        } catch (AvaliacaoForaDoPadraoException e) {
            System.out.println(e.getMessage());
        }

        try {
            filme3 = new Filme("A Origem", "Um ladrão especializado em extrair informações do inconsciente dos seus alvos durante o sonho.", 148, 2010, 4, diretor1);
            filme3.reproduzirFilme();
        } catch (AvaliacaoForaDoPadraoException e) {
            System.out.println(e.getMessage());
        }
        try {
            filme4 = new Filme("Batman: O Cavaleiro das Trevas Ressurge", "Oito anos depois da anarquia do Coringa, Batman com ajuda da Mulher Gato, tentam salvar Gotham do terrorista Bane.", 165, 2012, 0, diretor1);
            filme4.reproduzirFilme();
        } catch (AvaliacaoForaDoPadraoException e) {
            System.out.println(e.getMessage());
        }


        //----------

        Ator ator1 = new Ator("Ator", LocalDate.parse("1985-12-01"), 10, Genero.MASCULINO);
        Ator ator2 = new Ator("Ator2", LocalDate.parse("2000-01-01"), 5, Genero.FEMININO);

        ator1.Apresentacao();
        ator2.Apresentacao();


        //----------


        List<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        listaDeFilmes.add(filme4);

        //----------

        for (Filme f : listaDeFilmes){
            if(f != null){
                f.reproduzirFilme();
            }
        }
    }
}
