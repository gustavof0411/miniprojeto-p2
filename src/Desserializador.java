import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Desserializador {

    public HashMap<String, Personagem> desserializadorDePersonagem() {
        HashMap<String, Personagem> personagens = new HashMap<>();
        try {
            final String DIRETÓRIO = "HistoriaMiniprojeto/rsc/origin/personagens.txt";
            File arquivo = new File(DIRETÓRIO);
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            for (int i = 0; i < 3; i++) {
                Personagem algumPersonagem = (Personagem) ois.readObject();
                personagens.put(algumPersonagem.getNome(), algumPersonagem);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("Erro ao desserializar o objeto Personagem.");
        }
        return personagens;
    }

    public HashMap<String, Capitulo> desserializadorDeCapitulo() {
        HashMap<String, Capitulo> capitulos = new HashMap<>();
        try {
            final String DIRETÓRIO = "HistoriaMiniprojeto/rsc/origin/capitulos.txt";
            FileInputStream fis = new FileInputStream(new File(DIRETÓRIO));
            ObjectInputStream ois = new ObjectInputStream(fis);
            for (int i = 0; i < 9; i++) {
                Capitulo algumCapitulo = (Capitulo) ois.readObject();
                capitulos.put(algumCapitulo.getNome(), algumCapitulo);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("Erro ao desserializar o objeto Capítulo.");
        }
        return capitulos;
    }
}