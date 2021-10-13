package br.com.cwi.reset.rogeriotrusz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws CampoNaoInformadoException,
            NomeSobrenomeException, NomeJaCadastradoException, DataNascimentoException, InicioAtividadeException {

        Integer id = 0;
        String nome = diretorRequest.getNome();
        LocalDate dataNascimento = diretorRequest.getDataNascimento();
        Integer anoInicioAtividade = diretorRequest.getAnoInicioAtividade();

        if(nome == null || nome.isEmpty()){
            throw new CampoNaoInformadoException("nome");
        } else if(!nome.matches("^([A-z\\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$")){
            throw new NomeSobrenomeException("diretor");
        } else if(nomeJaExiste(nome)){
            throw new NomeJaCadastradoException("diretor", nome);
        }

        if(dataNascimento == null){
            throw new CampoNaoInformadoException("dataNascimento");
        } else if(dataNascimento.isAfter(LocalDate.now())){
            throw new DataNascimentoException("diretores");
        }

        if(anoInicioAtividade == null){
            throw new CampoNaoInformadoException("anoInicioAtividade");
        } else if(anoInicioAtividade < dataNascimento.getYear()){
            throw new InicioAtividadeException("diretor");
        }

        id = proximoDiretorId();
        Diretor diretor = new Diretor(id, nome, dataNascimento, anoInicioAtividade);
        fakeDatabase.persisteDiretor(diretor);
    }

    public List<Diretor> listarDiretores() throws CadastroNaoEncontradoException {
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        if(diretores.size() < 1){
            throw new CadastroNaoEncontradoException("diretor");
        }
        return diretores;
    }

    public List<Diretor> listarDiretores(String filtroNome) throws FiltroNaoEncontradoException, CadastroNaoEncontradoException {
        List<Diretor> diretores = listarDiretores();
        List<Diretor> resultadoFiltrado = new ArrayList<>();

        for(Diretor d : diretores){
            if(d.getNome().toLowerCase().contains(filtroNome.toLowerCase())){
                resultadoFiltrado.add(d);
            }
        }

        if(resultadoFiltrado.size() < 1){
            throw new FiltroNaoEncontradoException("Diretor", filtroNome);
        }
        return resultadoFiltrado;
    }






    private Integer proximoDiretorId(){
        return fakeDatabase.recuperaDiretores().size() + 1;
    }

    private boolean nomeJaExiste(String nome){
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        for (Diretor d : diretores) {
            if(d.getNome().equals(nome))
                return true;
        }
        return false;
    }
}
