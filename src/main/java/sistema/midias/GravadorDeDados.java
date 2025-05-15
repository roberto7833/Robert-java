package sistema.midias;

import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {

    public static final String ARQUIVOS_MIDIAS = "Midias.dat";

    public HashMap<String, Midias> recuperarDados()throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVOS_MIDIAS))){
            return (HashMap<String, Midias>) in.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }
    public void salvarMidias(HashMap<String, Midias> midias)throws IOException{
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVOS_MIDIAS))){
            out.writeObject(midias);
        } catch (IOException e) {
            throw new IOException("Erro ao salvar mídias: " + e.getMessage(), e);
        }
    }
}
