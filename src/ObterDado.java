import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class ObterDado {

    HashMap<String, Personagem> carregarPersonagem(String diretorio) {
        HashMap<String, Personagem> personagens = new HashMap<String, Personagem>();
        File arquivo = new File(diretorio);
        try {
            Scanner scanner = new Scanner(arquivo, "UTF-8");
            String algumaLinha = "";

            while (scanner.hasNextLine()) {
                while (!algumaLinha.equals("PERSONAGEM")) {
                    algumaLinha = scanner.nextLine();
                }
                Personagem algumPersonagem = new Personagem("", 0);
                algumaLinha = scanner.nextLine();
                algumPersonagem.setNome(scanner.nextLine());
                algumaLinha = scanner.nextLine();
                algumPersonagem.setVida(Integer.parseInt(scanner.nextLine()));
                personagens.put(algumPersonagem.getNome(), algumPersonagem);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar algum personagem.");
        }
        return personagens;
    }

    HashMap<String, Capitulo> carregarCapitulo(
            String diretório, HashMap<String, Personagem> personagens,
            Scanner escaneadorDeEscolhas) {
        HashMap<String, Capitulo> capitulos = new HashMap<String, Capitulo>();
        File arquivo = new File(diretório);
        try {
            Scanner scanner = new Scanner(arquivo, "UTF-8");
            String algumaLinha = "";

            while ((algumaLinha = scanner.nextLine()) != null) {
                while (!algumaLinha.equalsIgnoreCase("CAPITULO") ||
                        !algumaLinha.equalsIgnoreCase("ESCOLHA")) {
                    algumaLinha = scanner.nextLine();
                }
                if (algumaLinha.equalsIgnoreCase("CAPÍTULO")) {
                    Capitulo algumCapitulo = new Capitulo("", "", new Personagem("", 0), 0, "", "");
                    algumaLinha = scanner.nextLine(); // NOME
                    algumaLinha = scanner.nextLine();
                    if (!(algumaLinha).equalsIgnoreCase("null")) {
                        algumCapitulo.setNome(algumaLinha);
                        algumaLinha = scanner.nextLine(); // TEXTO
                    } else {
                        algumCapitulo.setNome(null);
                        algumaLinha = scanner.nextLine(); // TEXTO
                    }
                    algumaLinha = scanner.nextLine();
                    algumCapitulo.setTexto(algumaLinha);
                    algumaLinha = scanner.nextLine(); // PERSONAGEM
                    algumaLinha = scanner.nextLine();
                    algumCapitulo.setPersonagem(personagens.get(algumaLinha));
                    algumaLinha = scanner.nextLine(); // VIDA
                    algumaLinha = scanner.nextLine();
                    algumCapitulo.setVida(personagens.get(algumaLinha).getVida());
                    algumaLinha = scanner.nextLine(); // CONSEQUÊNCIA
                    algumaLinha = scanner.nextLine();
                    if (!algumaLinha.equalsIgnoreCase("null")) {
                        String vidaConsequencia = algumaLinha;
                        vidaConsequencia = scanner.nextLine();
                        algumCapitulo.setConsequencia(personagens.get(algumaLinha)
                                .getMensagemAtk((personagens.get(algumaLinha)), Integer.parseInt(vidaConsequencia)));
                        algumaLinha = scanner.nextLine();
                    } else {
                        algumCapitulo.setConsequencia(null);
                        algumaLinha = scanner.nextLine();
                        algumaLinha = scanner.nextLine();
                    }
                    algumaLinha = scanner.nextLine(); // FINAL DO CAPÍTULO
                    if (!algumaLinha.equalsIgnoreCase("null")) {
                        algumCapitulo.setFinalCap(algumaLinha);
                    } else {
                        algumCapitulo.setFinalCap(null);
                    }
                    capitulos.put(algumCapitulo.getNome(), algumCapitulo);
                } else if (algumaLinha.equalsIgnoreCase("ESCOLHA")) {

                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar algum capítulo.");
        }
        return capitulos;
    }
}
