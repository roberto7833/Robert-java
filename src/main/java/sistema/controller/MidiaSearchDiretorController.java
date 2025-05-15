package sistema.controller;

import sistema.SistemaMidias;
import sistema.midias.Midias;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MidiaSearchDiretorController implements ActionListener {
    private SistemaMidias sistema;
    private JFrame janelaPricipal;

    public MidiaSearchDiretorController(SistemaMidias sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPricipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String diretor = JOptionPane.showInputDialog(janelaPricipal, "digite o nome do diretor: ");
        Collection<Midias> diretorPesq = sistema.pesquisarPorDirecao(diretor);
        if(diretorPesq.size()>0){
            JOptionPane.showMessageDialog(janelaPricipal, "midias encontradas");
            for(Midias m: diretorPesq){
                JOptionPane.showMessageDialog(janelaPricipal, m.toString());
            }
        }else{
            JOptionPane.showMessageDialog(janelaPricipal, "nenhuma midia encontrada com o diretor informado");
        }
    }
}
