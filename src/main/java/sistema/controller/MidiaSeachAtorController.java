package sistema.controller;

import sistema.SistemaMidias;
import sistema.exception.AtorNaoExisteException;
import sistema.midias.Midias;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MidiaSeachAtorController implements ActionListener {
    private SistemaMidias sistema;
    private JFrame janelaPrincipal;

    public MidiaSeachAtorController(SistemaMidias sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ator = JOptionPane.showInputDialog(janelaPrincipal, "qual o nome do ator a pesquisar? ");
        try {
            Collection<Midias> atorPesq = sistema.pesquisarPorAtor(ator);
            if(atorPesq.size()>0){
                JOptionPane.showMessageDialog(janelaPrincipal, "Midias encontradas");
                for(Midias m: atorPesq){
                    JOptionPane.showMessageDialog(janelaPrincipal, m.toString());
                }
            }
        }catch (AtorNaoExisteException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, "nenhum ator encontrado com o nome pesquisado");
        }
    }
}
