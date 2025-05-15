package sistema.controller;

import sistema.SistemaMidias;
import sistema.exception.MidiaJaExisteException;
import sistema.midias.*;
import sistema.midias.GravadorDeDados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MidiaAddController implements ActionListener {
    private SistemaMidias sistema;
    private JFrame janelaPrincipal;


    public MidiaAddController(SistemaMidias sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int start = obterOpcaoNumerica("1. cadastrar Filme/Serie \nEscolha uma opção");
        if(start !=1){
            JOptionPane.showMessageDialog(janelaPrincipal, "opção invalida");
            return;
        }
        int tipoMidia = obterOpcaoNumerica("1.Filme \n2.Serie \nEscolha a opção");
        Midias midia = MidiaFormulario.criaFormularioMidias();

        if(midia != null){
            String titulo = midia.getTitulo();
            String genero = midia.getGenero();
            String descricao = midia.getDescricao();
            String diretor = midia.getDiretor();
            String [] elenco = midia.getElenco();
            int anoLancamento = midia.getAnoLancamento();

            try {
                if(tipoMidia==1){
                    //cadastra filme
                    int duracao = obterOpcaoNumerica("duração (em minutos)");
                    midia = new Filme(titulo, genero, descricao, diretor, elenco, anoLancamento, duracao);
                }else if(tipoMidia==2){
                    // cadastra serie
                    List<Episodio> eps = new ArrayList<>();
                    int quantEps = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "quantos episodios deseja casdastrar? "));

                    for(int k=0; k<quantEps; k++){
                        String nomeEp = JOptionPane.showInputDialog(janelaPrincipal, "nome episodio "+(k+quantEps));
                        int duracaoEp = obterOpcaoNumerica("duracao do episodio "+(k+quantEps)+"em minutos");
                        Episodio episodio = new Episodio(nomeEp, duracaoEp);
                        eps.add(episodio);
                    }
                    midia = new Serie(titulo, genero, descricao, diretor, elenco, anoLancamento, eps);
                }else{
                    JOptionPane.showMessageDialog(janelaPrincipal, "opção invalida");
                    return;
                }
                sistema.cadastrarMidias(midia);
                sistema.salvarDados();
                JOptionPane.showMessageDialog(janelaPrincipal, "midia cadastrada com sucesso");
            }catch (MidiaJaExisteException ex){
                JOptionPane.showMessageDialog(janelaPrincipal, "erro! midia já existe no sistema");
                ex.printStackTrace();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(janelaPrincipal, "erro ao cadastrar a midia"+ex.getMessage());
                ex.printStackTrace();
            }

        }
    }
    private int obterOpcaoNumerica(String msg){
        int opcao = -1;
        try {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, msg));

        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, "insira um numero valido");
        }
        return opcao;
    }
}
