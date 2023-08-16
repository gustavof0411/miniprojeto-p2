    import java.nio.file.Files;
    import java.io.File;
    import java.util.Scanner;

    public class Saves {
        public static void copiaDados() {
            if (!Saves.verificaSaveExistente()) {
                try {
                    File diretorioFontePersonagem = new File("HistoriaMiniprojeto/rsc/origin/personagens.txt");
                    File diretorioCopiaPersonagem = new File("HistoriaMiniprojeto/rsc/saves/personagens.txt");
                    Files.copy(diretorioFontePersonagem.toPath(), diretorioCopiaPersonagem.toPath());
                    File diretorioFonteCapitulo = new File("HistoriaMiniprojeto/rsc/origin/capitulos.txt");
                    File diretorioCopiaCapitulo = new File("HistoriaMiniprojeto/rsc/saves/capitulos.txt");
                    Files.copy(diretorioFonteCapitulo.toPath(), diretorioCopiaCapitulo.toPath());
                } catch (Exception e) {
                    System.out.println("Erro ao copiar o arquivo.");
                }
            }
        }

        public static boolean verificaSaveExistente() {
            boolean existeSave = false;
            try {
                File diretorio = new File("HistoriaMiniprojeto/rsc/saves");
                if (diretorio.isDirectory()) {
                    if (diretorio.length() != 0) {
                        existeSave = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro na verificação da existência de saves.");
            }
            return existeSave;
        }

        public static boolean carregarProgresso(boolean existeSave) {
            Scanner digitar = new Scanner(System.in);
            boolean carregarProgresso = false;
            String carregarOuNao = "";
            if (existeSave) {
                System.out.println("Foi verificado um save existente. Deseja carregar o progresso?"
                        + "\n SIM - Digite \"s\" \n NÃO - Digite \"n\"");
                System.out.print("Digite aqui:");
                carregarOuNao = digitar.nextLine();
                while (carregarOuNao.equalsIgnoreCase("s") && carregarOuNao.equalsIgnoreCase("s")) {
                    System.out.println("Certifique-se se digitou corretamente.");
                    System.out.print("Digite novamente aqui:");
                }
            }
            if (carregarOuNao.equalsIgnoreCase("s")) {
                carregarProgresso = true;
            }
            digitar.close();
            return carregarProgresso;
        }
    }