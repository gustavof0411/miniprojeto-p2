import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ObterDado {

    HashMap<String, Personagem> carregarPersonagem(String diretorio) {
        HashMap<String, Personagem> personagens = new HashMap<String, Personagem>();
        File arquivo = new File(diretorio);
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String algumaLinha = "";

            while ((algumaLinha = bufferedReader.readLine()) != null) {
                while (!algumaLinha.equals("PERSONAGEM")) {
                    algumaLinha = bufferedReader.readLine();
                }
                Personagem algumPersonagem = new Personagem("", 0);
                algumaLinha = bufferedReader.readLine();
                algumPersonagem.setNome(bufferedReader.readLine());
                algumaLinha = bufferedReader.readLine();
                algumPersonagem.setVida(Integer.parseInt(bufferedReader.readLine()));
                personagens.put(algumPersonagem.getNome(), algumPersonagem);
                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar algum personagem.");
        }
        return personagens;
    }

    HashMap<String, Capitulo> carregarCapitulo(
            String diretório, HashMap<String, Personagem> personagens,
            Scanner escaneadorDeEscolhas) {
        HashMap<String, Capitulo> capitulos = new HashMap<String, Capitulo>();
        File arquivo = new File("HistoriaMiniprojeto/rsc/capitulos.txt");
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String algumaLinha = "";

            while ((algumaLinha = bufferedReader.readLine()) != null) {
                while (!algumaLinha.equals("CAPÍTULO")) {
                    algumaLinha = bufferedReader.readLine();
                }
                Capitulo algumCapitulo = new Capitulo("", "", new Personagem("", 0), 0, "", "");
                algumaLinha = bufferedReader.readLine(); // NOME
                algumaLinha = bufferedReader.readLine();
                if (!(algumaLinha).equalsIgnoreCase("null")) {
                    algumCapitulo.setNome(algumaLinha);
                    algumaLinha = bufferedReader.readLine(); // TEXTO
                } else {
                    algumCapitulo.setNome(null);
                    algumaLinha = bufferedReader.readLine(); // TEXTO
                }
                algumaLinha = bufferedReader.readLine();
                algumCapitulo.setTexto(algumaLinha);
                algumaLinha = bufferedReader.readLine(); // PERSONAGEM
                algumaLinha = bufferedReader.readLine();
                algumCapitulo.setPersonagem(personagens.get(algumaLinha));
                algumaLinha = bufferedReader.readLine(); // VIDA
                algumaLinha = bufferedReader.readLine();
                algumCapitulo.setVida(personagens.get(algumaLinha).getVida());
                algumaLinha = bufferedReader.readLine(); // CONSEQUÊNCIA
                algumaLinha = bufferedReader.readLine();
                if (!algumaLinha.equalsIgnoreCase("null")) {
                    String vidaConsequencia = algumaLinha;
                    vidaConsequencia = bufferedReader.readLine();
                    algumCapitulo.setConsequencia(personagens.get(algumaLinha)
                            .getMensagemAtk((personagens.get(algumaLinha)), Integer.parseInt(vidaConsequencia)));
                    algumaLinha = bufferedReader.readLine();
                } else {
                    algumCapitulo.setConsequencia(null);
                    algumaLinha = bufferedReader.readLine();
                    algumaLinha = bufferedReader.readLine();
                }
                algumaLinha = bufferedReader.readLine(); // FINAL DO CAPÍTULO
                if (!algumaLinha.equalsIgnoreCase("null")) {
                    algumCapitulo.setFinalCap(algumaLinha);
                } else {
                    algumCapitulo.setFinalCap(null);
                }
                capitulos.put(algumCapitulo.getNome(), algumCapitulo);
                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar algum capítulo.");
        }
        return capitulos;
    }
}
