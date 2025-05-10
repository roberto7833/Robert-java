package sistema.midias;

public class Midias {
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
    public String getGenero(){
        return this.genero;
    }
}
