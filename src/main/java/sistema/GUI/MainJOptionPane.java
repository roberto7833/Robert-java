package sistema.GUI;

import sistema.ProgramaSistemaMidias;
import sistema.SistemaMidias;
import sistema.exception.MidiaJaExisteException;

import javax.swing.*;
import java.io.IOException;

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
                    "\n2.pesquisar por titulo: " +
                    "\n3.pesquisar genero: " +
                    "\n4.pesquisar por ano: " +
                    "\n5.pesquisar por ator: " +
                    "\n6. pesquisar por diretor: " +
                    "\n7.mostrar todos os filmes cadastrados: " +
                    "\n8.mostrar todas as series cadastradas: " +
                    "\n9."));
        }
    }
}
