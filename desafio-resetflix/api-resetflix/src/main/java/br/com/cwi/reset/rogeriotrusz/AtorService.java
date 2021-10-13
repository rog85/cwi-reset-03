package br.com.cwi.reset.rogeriotrusz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws CampoNaoInformadoException,
            NomeCompostoException, DataNascimentoException, AnoInvalidoException, NomeJaCadastradoException {

        Integer id = 0;
        String nome = atorRequest.getNome();
        LocalDate dataNascimento = atorRequest.getDataNascimento();
        StatusCarreira statusCarreira = atorRequest.getStatusCarreira();
        Integer anoInicioAtividade = atorRequest.getAnoInicioAtividade();

        if(nome == null || nome.isEmpty()){
            throw new CampoNaoInformadoException("nome");
        } else if(!nome.matches("^([A-z\\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$")){
            throw new NomeCompostoException("ator");
        } else if(nomeJaExiste(nome)){
            throw new NomeJaCadastradoException("ator", nome);
        }

        if(dataNascimento == null){
            throw new CampoNaoInformadoException("dataNascimento");
        } else if(dataNascimento.isAfter(LocalDate.now())){
            throw new DataNascimentoException("atores");
        }

        if(statusCarreira == null){
            throw new CampoNaoInformadoException("statusCarreira");
        }

        if(anoInicioAtividade == null){
            throw new CampoNaoInformadoException("anoInicioAtividade");
        } else if(anoInicioAtividade < dataNascimento.getYear()){
            throw new AnoInvalidoException("ator");
        }

        id = proximoAtorId();
        Ator ator = new Ator(id, nome, dataNascimento, statusCarreira, anoInicioAtividade);
        fakeDatabase.persisteAtor(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade() throws CadastroNaoEncontradoException {
        List<Ator> atores = fakeDatabase.recuperaAtores();
        if(atores.size() < 1){
            throw new CadastroNaoEncontradoException("ator");
        }

        List<AtorEmAtividade> resultado = new ArrayList<>();
        AtorEmAtividade atorAtividade = null;

        for (Ator a : atores) {
            if(a.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)){
                atorAtividade = new AtorEmAtividade(a.getId(), a.getNome(), a.getDataNascimento());
                resultado.add(atorAtividade);
            }
        }
        return resultado;
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws FiltroNaoEncontradoException, CadastroNaoEncontradoException {
        List<AtorEmAtividade> atoresEmAtividade = listarAtoresEmAtividade();
        List<AtorEmAtividade> resultadoFiltrado = new ArrayList<>();

        for(AtorEmAtividade a : atoresEmAtividade){
            if(a.getNome().toLowerCase().contains(filtroNome.toLowerCase())){
                resultadoFiltrado.add(a);
            }
        }

        if(resultadoFiltrado.size() < 1){
            throw new FiltroNaoEncontradoException("Ator", filtroNome);
        }
        return resultadoFiltrado;
    }

    public Ator consultarAtor(Integer id) throws CampoNaoInformadoException, IdNaoEncontradoException {
        if(id == null){
            throw new CampoNaoInformadoException("id");
        }
        List<Ator> atores = fakeDatabase.recuperaAtores();
        Ator resultado = null;
        for (Ator a : atores){
            if(a.getId() == id){
                resultado = a;
            }
        }
        if(resultado == null){
            throw new IdNaoEncontradoException("ator", id);
        }
        return resultado;
    }

    public List<Ator> consultarAtores() throws CadastroNaoEncontradoException {
        List<Ator> atores = fakeDatabase.recuperaAtores();
        if(atores.size() < 1){
            throw new CadastroNaoEncontradoException("ator");
        }

        return atores;
    }

    private Integer proximoAtorId(){
        return fakeDatabase.recuperaAtores().size() + 1;
    }

    private boolean nomeJaExiste(String nome){
        List<Ator> atores = fakeDatabase.recuperaAtores();
        for (Ator a : atores) {
            if(a.getNome().equals(nome))
                return true;
        }
        return false;
    }

}
