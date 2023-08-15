import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Historia implements Serializable {
        public static void main(String[] args) throws Exception {
                // Escaneador
                Scanner continuar = new Scanner(System.in);

                ObterDado personagem = new ObterDado();
                HashMap<String, Personagem> personagens = personagem
                                .carregarPersonagem(
                                                "C:/Users/Usuário/Documents/Projetos Java/HistoriaMiniprojeto/HistoriaMiniprojeto/rsc/personagens.txt");

                // Capítulos
                ObterDado obterCapitulo = new ObterDado();
                HashMap<String, Capitulo> capitulos = obterCapitulo
                                .carregarCapitulo(
                                                "C:/Users/Usuário/Documents/Projetos Java/HistoriaMiniprojeto/HistoriaMiniprojeto/rsc/capitulos.txt",
                                                personagens, continuar);
                Capitulo capitulo1 = capitulos.get("[CAPÍTULO 1 - O INÍCIO]");
                Capitulo capitulo1_1 = capitulos.get("[CONTINUAÇÃO - CAPÍTULO 1.1]");
                Capitulo capitulo1_2 = capitulos.get("[CONTINUAÇÃO - CAPÍTULO 1.2]");
                Capitulo capitulo1_3 = capitulos.get("[CONTINUAÇÃO - CAPÍTULO 1.3]");
                Capitulo capitulo2 = capitulos.get("[CAPÍTULO 2 - A JORNADA]");
                Capitulo capitulo2_1 = capitulos.get("[CAPÍTULO 2.1 - SEGUINDO PELA ESQUERDA]");
                Capitulo capitulo2_2 = capitulos.get("[CAPÍTULO 2.2 - SEGUINDO PELA DIREITA]");
                Capitulo capitulo3_1 = capitulos.get("[CAPÍTULO 3.1 - A CHEGADA À TORRE]");
                Capitulo capitulo3_2 = capitulos.get("[CAPÍTULO 3.2 - A CHEGADA À TORRE]");
                // Atribuições das Escolhas

                /*
                 * capitulo1.setArray(new ArrayList<>(Arrays.asList(
                 * new Escolha("s", capitulo2),
                 * new Escolha("n", capitulo1_1))));
                 * 
                 * capitulo1_1.setArray(new ArrayList<>(Arrays.asList(
                 * new Escolha("servir", capitulo1_2),
                 * new Escolha("lutar", capitulo1_3))));
                 * capitulo1_2.setArray(new ArrayList<>(Arrays.asList(
                 * new Escolha(null, null),
                 * new Escolha(null, null))));
                 * capitulo1_3.setArray(new ArrayList<>(Arrays.asList(
                 * new Escolha(null, null),
                 * new Escolha(null, null))));
                 * 
                 * capitulo2.setArray(new ArrayList<>(Arrays.asList(new Escolha("esquerda",
                 * capitulo2_1),
                 * new Escolha("direita", capitulo2_2))));
                 * capitulo2_1.setArray(new ArrayList<>(Arrays.asList(new Escolha(null,
                 * capitulo3_1),
                 * new Escolha(null, capitulo3_1))));
                 * capitulo2_2.setArray(new ArrayList<>(Arrays.asList(new Escolha(null,
                 * capitulo3_2),
                 * new Escolha(null, capitulo3_2))));
                 * capitulo3_1.setArray(new ArrayList<>(Arrays.asList(new Escolha(null, null),
                 * new Escolha(null, null))));
                 * capitulo3_2.setArray(new ArrayList<>(Arrays.asList(new Escolha(null, null),
                 * new Escolha(null, null))));
                 */

                capitulos.get("[CAPÍTULO 1 - O INÍCIO]");
                Capitulo inicial = capitulo1;
                inicial.executar(continuar);
        }
}