package sistema;

import sistema.exception.AtorNaoExisteException;
import sistema.exception.MidiaInexistenteException;
import sistema.exception.MidiaJaExisteException;
import sistema.midias.Midias;

import java.io.IOException;
import java.util.Collection;

public interface SistemaMidias {
    void cadastrarMidias(Midias midia)throws MidiaJaExisteException;
    Collection<Midias> pesquisarPorTitulo(String titulo);
    Collection<Midias> pesquisarPorGenero(String genero);
    Collection<Midias> pesquisarPorDirecao(String diretor);
    Collection<Midias> pesquisarPorAnoLancamento(int ano);
    Collection<Midias> pesquisarPorAtor(String ator)throws AtorNaoExisteException;
    Collection<Midias> mostrarTodosOsFilmes();
    Collection<Midias> mostrarTodasAsSeries();
    Collection<Midias> mostrarTodasAsMidiasCadastradas();
    void atualizarMidias(String titulo, String novoTitulo, String novoGenero, int anoLancamento)throws MidiaInexistenteException;
    void removerMidia(String titulo)throws MidiaInexistenteException;
    void salvarDados()throws IOException;
    void recuperarDados()throws IOException;
}
