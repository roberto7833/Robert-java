package sistema.midias;

import java.io.Serializable;

public class Filme extends Midias implements Serializable {
    private int duracao;

    public Filme(String titulo, String genero, String descricao, String diretor, String [] elenco, int anoLancamento, int duracao){
        super(titulo, genero, descricao, diretor, elenco, anoLancamento);
        this.duracao = duracao;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    @Override
    public String toString() {
        return "Filme "+super.getTitulo()+"\nGenero"+super.getGenero()+"\nDescrição"+super.getDescricao()+"\nDiretor"+super.getDiretor()+"\nElenco"+String.join(",",super.getElenco());
    }
}
