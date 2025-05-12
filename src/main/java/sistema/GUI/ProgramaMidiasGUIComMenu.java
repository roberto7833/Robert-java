package sistema.GUI;

import sistema.ProgramaSistemaMidias;
import sistema.SistemaMidias;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ProgramaMidiasGUIComMenu extends JFrame {
    JLabel linha1, linha2;
    ImageIcon filmeJPG = new ImageIcon("./imgs/filmes.png");
    Image imagemRecondicinada = filmeJPG.getImage().getScaledInstance(400,300, Image.SCALE_SMOOTH);
    ImageIcon imagemFinal = new ImageIcon(imagemRecondicinada);
    SistemaMidias midias = new ProgramaSistemaMidias();
    JMenuBar barraDeMenu = new JMenuBar();

    public ProgramaMidiasGUIComMenu(){
        setTitle("Sistema filmes/series");
        setSize(800,600); //tamanho da janela
        setLocation(150,150);
        setResizable(true);
        setBackground(Color.white);
        linha1 = new JLabel("Sistema filmes/series", JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        //linha2 = new JLabel(filmeJPG, JLabel.CENTER);
        linha2 = new JLabel(imagemFinal, JLabel.CENTER);
        linha2.setPreferredSize(new Dimension(400,300));

        setLayout(new GridLayout(3,1));

        add(linha1);
        add(linha2);

        add(new JLabel());
        JMenu menuCadastrar = new JMenu("cadastrar");
        JMenuItem menuCadastrarMidia = new JMenuItem("cadastrar midia");
        menuCadastrar.add(menuCadastrarMidia);
        JMenu menuPesquisar = new JMenu("pesquisar");
        JMenuItem menuPesquisarPorTitulo = new JMenuItem("pesquisar por titulo");
        menuPesquisar.add(menuPesquisarPorTitulo);
        JMenuItem menuPesquisarPorGenero = new JMenuItem("pesquisar por genero");
        menuPesquisar.add(menuPesquisarPorGenero);
        JMenuItem menuPesquisarPorDiretor = new JMenuItem("pesquisar por diretor");
        menuPesquisar.add(menuPesquisarPorDiretor);
        JMenuItem menuPesquisarPorAtor = new JMenuItem("pesquisar por ator");
        menuPesquisar.add(menuPesquisarPorAtor);
        JMenuItem menuPesquisarPorAno = new JMenuItem("pesquisar por ano");
        menuPesquisar.add(menuPesquisarPorAno);
        JMenu menuMostrarMidias = new JMenu("midias cadastradas");
        JMenuItem menuFilmesCadastrados = new JMenuItem("mostrar todos os filmes cadastrados");
        menuMostrarMidias.add(menuFilmesCadastrados);
        JMenuItem menuSeriesCadastradas = new JMenuItem("mostrar todas as series cadastradas");
        menuMostrarMidias.add(menuSeriesCadastradas);
        JMenuItem menuTodasMidiasCadastradas = new JMenuItem("mostrar todas as midias cadastradas");
        menuMostrarMidias.add(menuTodasMidiasCadastradas);
        JMenu menuRemover = new JMenu("remover");
        JMenuItem menuRemoverMidia = new JMenuItem("remover midia");
        menuRemover.add(menuRemoverMidia);

        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuMostrarMidias);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);
    }

    //...
    public static void main(String [] args)throws IOException {
        JFrame janela = new ProgramaMidiasGUIComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
