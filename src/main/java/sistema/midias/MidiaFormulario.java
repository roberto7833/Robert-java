package sistema.midias;

import javax.swing.*;
import java.awt.*;

public class MidiaFormulario {

    public static Midias criaFormularioMidias(){

        JTextField tituloField = new JTextField(10);
        JTextField generoField = new JTextField(10);
        JTextField descricaoField = new JTextField(20);
        JTextField diretorField = new JTextField(10);
        JTextField elencoField = new JTextField(20);
        JTextField anoField = new JTextField(4);

        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.add(new JLabel("titulo"));
        panel.add(tituloField);
        panel.add(new JLabel("genero"));
        panel.add(generoField);
        panel.add(new JLabel("descricao"));
        panel.add(descricaoField);
        panel.add(new JLabel("diretor"));
        panel.add(diretorField);
        panel.add(new JLabel("elenco (separado por virgula)"));
        panel.add(elencoField);
        panel.add(new JLabel("ano de lancamento"));
        panel.add(anoField);

        int result = JOptionPane.showConfirmDialog(null
                , panel
                , "confirme os dados"
                ,JOptionPane.OK_CANCEL_OPTION
                ,JOptionPane.PLAIN_MESSAGE );
        if(result==JOptionPane.OK_OPTION){
            String titulo = tituloField.getText();
            String genero = generoField.getText();
            String descricao = descricaoField.getText();
            String diretor = diretorField.getText();
            String[] elenco = elencoField.getText().split(",");
            int ano = Integer.parseInt(anoField.getText());

            return new Midias(titulo, genero, descricao, diretor, elenco, ano);
        }
        return null;
    }
}
