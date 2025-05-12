package sistema;

import sistema.exception.AtorNaoExisteException;
import sistema.exception.MidiaInexistenteException;
import sistema.exception.MidiaJaExisteException;
import sistema.midias.Filme;
import sistema.midias.GravadorDeDados;
import sistema.midias.Midias;
import sistema.midias.Serie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ProgramaSistemaMidias implements SistemaMidias{
    private HashMap<String, Midias> midias;
    private GravadorDeDados gravador;

    public ProgramaSistemaMidias(){
        this.midias = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }
    @Override
    public void cadastrarMidias(Midias midia) throws MidiaJaExisteException {
        if(this.midias.containsKey(midia.getTitulo())){
            throw new MidiaJaExisteException("já existe uma midia cadastrada com esse nome");
        }
        midias.put(midia.getTitulo(), midia);
    }
    @Override
    public Collection<Midias> pesquisarPorTitulo(String titulo) {
        Collection<Midias> tituloPesq = new ArrayList<>();
        for(Midias m: midias.values()){
            if(m.getTitulo().equalsIgnoreCase(titulo)){
                tituloPesq.add(m);
            }
        }
        return tituloPesq;
    }
    @Override
    public Collection<Midias> pesquisarPorGenero(String genero) {
        Collection<Midias> generoPesq = new ArrayList<>();
        for(Midias m: midias.values()){
            if(m.getGenero().equalsIgnoreCase(genero)){
                generoPesq.add(m);
            }
        }
        return generoPesq;
    }
    @Override
    public Collection<Midias> pesquisarPorDirecao(String diretor) {
        Collection<Midias> diretorPesq = new ArrayList<>();
        for(Midias m: midias.values()){
            if(m.getDiretor().equalsIgnoreCase(diretor)){
                diretorPesq.add(m);
            }
        }
        return diretorPesq;
    }
    @Override
    public Collection<Midias> pesquisarPorAnoLancamento(int ano) {
        Collection<Midias> anopesq = new ArrayList<>();
        for(Midias m: midias.values()){
            if(m.getAnoLancamento()==ano){
                anopesq.add(m);
            }
        }
        return anopesq;
    }

    @Override
    public Collection<Midias> pesquisarPorAtor(String ator) throws AtorNaoExisteException {
        Collection<Midias> atorPesq = new ArrayList<>();
        for(Midias m: midias.values()){
            String [] elenco = m.getElenco();//obtem array dos atores
            for(String nome: elenco){
                if(nome.equalsIgnoreCase(ator)){
                    atorPesq.add(m);
                    break;//já achou o ator, não precisa continuar
                }
            }
        }
        if(atorPesq.isEmpty()){
            throw new AtorNaoExisteException("nenhum ator encontrado com esse nome "+ator);
        }
        return atorPesq;
    }
    @Override
    public Collection<Midias> mostrarTodosOsFilmes() {
        Collection<Midias> filmes = new ArrayList<>();
        for(Midias m: midias.values()){
            if(m instanceof Filme){
                filmes.add(m);
            }
        }
        return filmes;
    }
    @Override
    public Collection<Midias> mostrarTodasAsSeries() {
        Collection<Midias> series = new ArrayList<>();
        for(Midias m: midias.values()){
            if(m instanceof Serie){
                series.add(m);
            }
        }
        return series;
    }
    @Override
    public Collection<Midias> mostrarTodasAsMidiasCadastradas() {
        return midias.values();
    }
    @Override
    public void atualizarMidias(String titulo, String novoTitulo, String novoGenero, int anoLancamento) throws MidiaInexistenteException {
        if(midias.containsKey(titulo)){
            throw new MidiaInexistenteException("midia não encontrada"+titulo);
        }else{
            Midias midia = midias.get(titulo);
            midia.setTitulo(novoTitulo);
            midia.setGenero(novoGenero);
            midia.setAnoLancamento(anoLancamento);
            midias.remove(titulo);
            midias.put(titulo, midia);
        }
    }
    public Midias getMidias(String titulo)throws MidiaInexistenteException{
        if(!midias.containsKey(titulo)){
            throw new MidiaInexistenteException("midia não encontrada");
        }
        return midias.get(titulo);
    }
    @Override
    public void removerMidia(String titulo) throws MidiaInexistenteException {
        if(!midias.containsKey(titulo)){
            throw new MidiaInexistenteException("midia não encontrada");
        }else{
            midias.remove(titulo);
        }
    }

    @Override
    public void salvarDados()throws IOException {
        this.gravador.salvarMidias(midias);
    }
    @Override
    public void recuperarDados()throws IOException {
        this.midias = this.gravador.recuperarMidias();
    }
}
