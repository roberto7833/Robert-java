package sistema.midias;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Midias implements Serializable {
    private String titulo;
    private String genero;
    private String descricao;
    private String diretor;
    private String [] elenco;
    private int anoLancamento;

    public Midias(String titulo, String genero, String descricao, String diretor, String [] elenco, int anoLancamento){
        this.titulo = titulo;
        this.genero = genero;
        this.descricao = descricao;
        this.diretor = diretor;
        this.elenco = elenco;
        this.anoLancamento = anoLancamento;
    }
    public Midias(){
        this("", "", "", "", new String [0], 0);
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getGenero(){
        return this.genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDiretor(){
        return this.diretor;
    }
    public void setDiretor(String diretor){
        this.diretor = diretor;
    }
    public String [] getElenco(){
        return this.elenco;
    }
    public void setElenco(String [] elenco){
        this.elenco = elenco;
    }
    public int getAnoLancamento(){
        return this.anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento){
        this.anoLancamento = anoLancamento;
    }

//    @Override
//    public String toString() {
//        return "Filme "+ titulo +", de genero "+ genero +", descricao "+ descricao +", diretor "+ diretor +", elenco "+ Arrays.toString(elenco) +", ano lancamento "+ anoLancamento;
//    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Midias midias = (Midias) o;
        return Objects.equals(titulo, midias.titulo) && Objects.equals(genero, midias.genero);
    }
    @Override
    public int hashCode() {
        return Objects.hash(titulo, genero);
    }
}
