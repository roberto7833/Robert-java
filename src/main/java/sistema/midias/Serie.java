package sistema.midias;

import java.io.Serializable;
import java.util.List;

public class Serie extends Midias implements Serializable {
    private List<Episodio> episodios;

    public Serie(String titulo, String genero, String descricao, String diretor, String [] elenco, int anoLancamento, List<Episodio> episodios){
        super(titulo, genero, descricao, diretor, elenco, anoLancamento);
        this.episodios = episodios;
    }
    public List<Episodio> getEpisodios() {
        return episodios;
    }
    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
    public int duracaoTotal(){
        int duracaoTotal =0;
        for(Episodio e: episodios){
            duracaoTotal += e.getDuracaoEp();
        }return duracaoTotal;
    }
    public int duracaoMedia(){
        int duracaoMedia = 0;
        for(Episodio e: episodios){
            duracaoMedia += e.getDuracaoEp();
        }return duracaoMedia/episodios.size();
    }

    @Override
    public String toString() {
        return " Serie "+ super.getTitulo()+"\nEpisodios "+episodios.size()+"\nDuração "+this.duracaoMedia();
    }
}
