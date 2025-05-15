package sistema.controller;

import sistema.SistemaMidias;
import sistema.midias.Midias;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MidiaTodosFilmesCadastrados implements ActionListener {
    private SistemaMidias sistema;
    private JFrame janelaPrincipal;

    public MidiaTodosFilmesCadastrados(SistemaMidias sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Collection<Midias> filmesCadastrados = sistema.mostrarTodosOsFilmes();
        for(Midias m: filmesCadastrados){
            JOptionPane.showMessageDialog(janelaPrincipal, m.toString());
        }
    }
}
