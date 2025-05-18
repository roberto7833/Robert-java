package sistema.GUI;

import sistema.ProgramaSistemaMidias;
import sistema.SistemaMidias;
import sistema.exception.AtorNaoExisteException;
import sistema.exception.MidiaInexistenteException;
import sistema.exception.MidiaJaExisteException;
import sistema.midias.Episodio;
import sistema.midias.Filme;
import sistema.midias.Midias;
import sistema.midias.Serie;
import sistema.ProgramaSistemaMidias;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainJOptionPane {
    public static void main(String [] args)throws IOException {
        SistemaMidias sistema = new ProgramaSistemaMidias();

        try {
            sistema.salvarDados();
            JOptionPane.showMessageDialog(null, "dados recuperados com sucesso");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "erro ao recuperar os dados");
        }

        boolean sair = false;
        while(!sair){
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("escolha uma Opção: " +
                    "\n1.cadastrar midia: " +
                    "\n2.pesquisar" +
                    "\n3.mostrar midias cadastradas" +
                    "\n4. atualizar midia" +
                    "\n5.remover midia" +
                    "\n6.SAIR"));
            switch (opcao){
                case 1:
                    opcao = Integer.parseInt(JOptionPane.showInputDialog("1.Filme \n2.Serie"));
                    String titulo = JOptionPane.showInputDialog("digite o titulo: ");
                    String genero = JOptionPane.showInputDialog("digite o genero: ");
                    String descricao = JOptionPane.showInputDialog("digite a descricao: ");
                    String diretor = JOptionPane.showInputDialog("nome do diretor: ");
                    String [] elenco = JOptionPane.showInputDialog("Elenco (nomes separadoos por virgula, )").split(",");
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("digite o ano de lancamento: "));

                    if(opcao==1){
                        int duracao = Integer.parseInt(JOptionPane.showInputDialog("duracao do filme: "));
                        Filme filme = new Filme(titulo, genero, descricao, diretor, elenco, ano, duracao);
                        try {
                            sistema.cadastrarMidias(filme);
                            JOptionPane.showMessageDialog(null, filme);
                        }catch (MidiaJaExisteException e){
                            e.printStackTrace();
                        }
                    }else{
                        int quantEps = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de eps: "));

                        List<Episodio> eps = new ArrayList<>();
                        for(int k =0; k<quantEps; k++){
                            String nomeEp = JOptionPane.showInputDialog("digite o nome do epidodio: "+(k+1))+": ";
                            int duracaoEp = Integer.parseInt(JOptionPane.showInputDialog("duracao do episodio "+(k+1)+": "));
                            Episodio episodio = new Episodio( nomeEp, duracaoEp);
                            eps.add(episodio);
                        }
                        Serie serie = new Serie(titulo, genero, descricao, diretor, elenco, ano, eps);
                        JOptionPane.showMessageDialog(null, serie.toString());

                        try {
                            sistema.cadastrarMidias(serie);
                        }catch (MidiaJaExisteException e){
                            e.printStackTrace();
                        }
                    }break;

                case 2:
                    opcao = Integer.parseInt(JOptionPane.showInputDialog("1.pesquisar por titulo: " +
                            "\n2.pesquisar genero: " +
                            "\n3.pesquisar por ano: " +
                            "\n4.pesquisar por ator: " +
                            "\n5. pesquisar por diretor: "));
                    switch (opcao){
                        case 1:
                            String tituloPesq = JOptionPane.showInputDialog("digite o titulo: ");
                            JOptionPane.showMessageDialog(null, sistema.pesquisarPorTitulo(tituloPesq));
                            break;

                        case 2:
                            String generoPesq = JOptionPane.showInputDialog("digite o genero: ");
                            JOptionPane.showMessageDialog(null, sistema.pesquisarPorGenero(generoPesq));
                            break;

                        case 3:
                            int anoPesq = Integer.parseInt(JOptionPane.showInputDialog("digite o ano: "));
                            JOptionPane.showMessageDialog(null, sistema.pesquisarPorAnoLancamento(anoPesq));
                            break;

                        case 4:
                            String atorPesq = JOptionPane.showInputDialog("digite o nome do ator: ");
                            try {
                                JOptionPane.showMessageDialog(null, sistema.pesquisarPorAtor(atorPesq));

                            }catch (AtorNaoExisteException a){
                                JOptionPane.showMessageDialog(null, "ator nao encontrado");
                            }
                            break;

                        case 5:
                            String diretorPesq = JOptionPane.showInputDialog("digite o nome do diretor");
                            JOptionPane.showMessageDialog(null, sistema.pesquisarPorDirecao(diretorPesq));
                            break;
                    }break;

                case 3:
                    opcao = Integer.parseInt(JOptionPane.showInputDialog("1.mostrar todos os filmes cadastrados: " +
                            "\n2.mostrar todas as series cadastradas: " +
                            "\n3.mostrar todas as midias cadastradas: "));
                    switch (opcao){
                        case 1:
                            JOptionPane.showMessageDialog(null,sistema.mostrarTodosOsFilmes());
                            break;

                        case 2:
                            JOptionPane.showMessageDialog(null,sistema.mostrarTodasAsSeries());
                            break;

                        case 3:
                            JOptionPane.showMessageDialog(null,sistema.mostrarTodasAsMidiasCadastradas());
                    }
                    break;

                case 4:
                    String tituloAtualizar = JOptionPane.showInputDialog("Digite o título da mídia a ser atualizada: ");
                    try {
                        JOptionPane.showMessageDialog(null, "Midia encontrada:\n" + sistema.getMidias(tituloAtualizar));// Confirmação
                        // Novos dados:
                        String novoTitulo = JOptionPane.showInputDialog("Titulo: ");
                        String novoGenero = JOptionPane.showInputDialog("Gênero: ");
                        int novoAnoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento: "));;
                        sistema.getMidias(tituloAtualizar).setTitulo(novoTitulo);
                        sistema.getMidias(tituloAtualizar).setGenero(novoGenero);
                        sistema.getMidias(tituloAtualizar).setAnoLancamento(novoAnoLancamento);

                        JOptionPane.showMessageDialog(null, "Midia atualizada com sucesso: " + sistema.getMidias(tituloAtualizar));
                    } catch (MidiaInexistenteException m){
                        m.printStackTrace();
                    } break;
                case 5:
                    String tituloRemover = JOptionPane.showInputDialog("Digite o título a ser removido: ");
                    try {
                        JOptionPane.showMessageDialog(null, "Midia a ser removida:\n" + sistema.getMidias(tituloRemover));// Confirmação
                        sistema.removerMidia(tituloRemover);
                    } catch (MidiaInexistenteException m) {
                        m.printStackTrace();
                    } break;
                case 6:
                    sair = true;
                    sistema.salvarDados();
            }
        }
    }
}
