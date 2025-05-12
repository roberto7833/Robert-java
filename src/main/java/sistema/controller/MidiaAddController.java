package sistema.controller;

import sistema.SistemaMidias;
import sistema.midias.MidiaFormulario;
import sistema.midias.Midias;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
