import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Serializador {

        public void serializadorDePersonagem() {
                try {
                        final String DIRETÓRIO = "HistoriaMiniprojeto/rsc/origin/personagens.txt";
                        File arquivo = new File(DIRETÓRIO);
                        FileOutputStream fos = new FileOutputStream(arquivo);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Personagem protagonista = new Personagem("Caleb", 100);
                        Personagem rei = new Personagem("Rei Salaham", 100);
                        Personagem magoDoMal = new Personagem("Mago do Mal", 100);
                        oos.writeObject(protagonista);
                        oos.writeObject(rei);
                        oos.writeObject(magoDoMal);
                        oos.close();
                } catch (Exception e) {
                        System.out.println("Erro ao serializar o objeto Personagem.");
                }
        }

        public void serializadorDeCapitulo(HashMap<String, Personagem> personagens) {
                try {
                        final String DIRETÓRIO = "HistoriaMiniprojeto/rsc/origin/capitulos.txt";
                        File arquivo = new File(DIRETÓRIO);
                        FileOutputStream fos = new FileOutputStream(arquivo);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Capitulo capitulo1 = new Capitulo("[CAPÍTULO 1 - O INÍCIO]", "Você é o guerreiro "
                                        + "Caleb. Em um certo dia, você é conjurado pelo Rei Salaham"
                                        + " para recuperar o Anel do Poder roubado por seu rival, o Mago do Mal"
                                        + ". Se não aceitar, pode pôr a vida do Rei"
                                        + " em perigo. Aceitar a proposta? \n ACEITAR - DIGITE \"S\" \n RECUSAR - DIGITE \"N\"",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(), null, null);

                        Capitulo capitulo1_1 = new Capitulo("[CONTINUAÇÃO - CAPÍTULO 1.1]",
                                        "Ao recusar, o Mago do Mal permanece vivo e executa o " +
                                                        "Rei com todo o poder do Anel. No dia seguinte, o Mago do Mal"
                                                        + " vem até você e o oferece uma"
                                                        + " proposta de servir a ele. Se não servir, terá que combatê-lo. \n COMBATER - DIGITE \"LUTAR\" \n"
                                                        + " SERVIR - DIGITE \"SERVIR\"",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(),
                                        personagens.get("Rei Salaham").getMensagemAtk(
                                                        personagens.get("Rei Salaham").getVida()),
                                        null);

                        Capitulo capitulo1_2 = new Capitulo("[CONTINUAÇÃO - CAPÍTULO 1.2]",
                                        "Você decide servir o Mago do Mal"
                                                        + ". Com o tempo, você se torna corrompido e deseja matar e conquistar cada território,"
                                                        + " tornando-se um forte aliado.",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(), null,
                                        "[FINAL 3 - FOME DE MATANÇA]");

                        Capitulo capitulo1_3 = new Capitulo("[CONTINUAÇÃO - CAPÍTULO 1.3]",
                                        "Você decide lutar contra o Mago do Mal"
                                                        + ". Infelizmente, ele já estava forte demais para ser combatido. Você então é derrotado.",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(),
                                        personagens.get("Caleb").getMensagemAtk(personagens.get("Caleb").getVida()),
                                        "[FINAL 2 - PROTAGONISTA É DERROTADO]");

                        Capitulo capitulo2 = new Capitulo("[CAPÍTULO 2 - A JORNADA]",
                                        "Você aceita o convite do rei e parte para recuperar o"
                                                        + " Anel do Poder. Há dois caminhos para seguir: O da direita é mais seguro, porém é mais longo. O da esquerda é"
                                                        + " o mais rápido, porém com muito inimigos. Qual caminho seguir? \n IR PELA DIREITA - DIGITE \"DIREITA\""
                                                        + "\n IR PELA ESQUERDA - DIGITE \"ESQUERDA\"",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(), null, null);

                        Capitulo capitulo2_1 = new Capitulo("[CAPÍTULO 2.1 - SEGUINDO PELA ESQUERDA]",
                                        "Você decide seguir pelo caminho"
                                                        + " da esquerda. A viagem é curta, porém cheia de inimigos para derrotar,"
                                                        + " o que lhe custou ferimentos intensos.",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(),
                                        personagens.get("Caleb").getMensagemAtk(40), null);

                        Capitulo capitulo2_2 = new Capitulo("[CAPÍTULO 2.2 - SEGUINDO PELA DIREITA]",
                                        "Você decide seguir pelo caminho da direita."
                                                        + " A viagem é longa, com alguns poucos inimigos para derrotar, o que lhe custou ferimentos leves.",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(),
                                        personagens.get("Caleb").getMensagemAtk(10), null);

                        Capitulo capitulo3_1 = new Capitulo("[CAPÍTULO 3.1 - A CHEGADA À TORRE]",
                                        "Você chega até a torre. O Mago do Mal"
                                                        + " deve estar no topo da torre, porém você deve derrotar alguns inimigos que protegiam a torre."
                                                        + " Ao derrotá-los, você chega até ao topo da torre e enfrenta o Mago do Mal"
                                                        + " em uma batalha. Porém, os ferimentos dos inimigos do caminho afetaram sua vitalidade e o deixou fraco para"
                                                        + " a batalha, o que levou à sua derrota.",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(),
                                        personagens.get("Caleb").getMensagemAtk(60),
                                        "[FINAL 4 - GUERREIRO DESTEMIDO]");

                        Capitulo capitulo3_2 = new Capitulo("[CAPÍTULO 3.2 - A CHEGADA À TORRE]",
                                        "Você chega até a torre. O Mago do Mal"
                                                        + " deve estar no topo da torre, porém você deve derrotar alguns inimigos que protegiam a torre."
                                                        + " Ao derrotá-los, você chega até o topo da torre e enfrenta o Mago do Mal"
                                                        + " em uma batalha. Com vitalidade o suficiente, você consegue derrotar o Mago do Mal e devolver o Anel do Poder"
                                                        + " de volta para o Rei de forma segura.",
                                        personagens.get("Caleb"), personagens.get("Caleb").getVida(),
                                        personagens.get("Caleb").getMensagemAtk(60),
                                        "[FINAL 1 - O ANEL É RECUPERADO]");

                        capitulo1.setArray(new ArrayList<>(Arrays.asList(
                                        new Escolha("s", capitulo2),
                                        new Escolha("n", capitulo1_1))));

                        capitulo1_1.setArray(new ArrayList<>(Arrays.asList(
                                        new Escolha("servir", capitulo1_2),
                                        new Escolha("lutar", capitulo1_3))));
                        capitulo1_2.setArray(new ArrayList<>(Arrays.asList(
                                        new Escolha(null, null),
                                        new Escolha(null, null))));
                        capitulo1_3.setArray(new ArrayList<>(Arrays.asList(
                                        new Escolha(null, null),
                                        new Escolha(null, null))));

                        capitulo2.setArray(new ArrayList<>(Arrays.asList(new Escolha("esquerda",
                                        capitulo2_1),
                                        new Escolha("direita", capitulo2_2))));
                        capitulo2_1.setArray(new ArrayList<>(Arrays.asList(new Escolha(null,
                                        capitulo3_1),
                                        new Escolha(null, capitulo3_1))));
                        capitulo2_2.setArray(new ArrayList<>(Arrays.asList(new Escolha(null,
                                        capitulo3_2),
                                        new Escolha(null, capitulo3_2))));
                        capitulo3_1.setArray(new ArrayList<>(Arrays.asList(new Escolha(null, null),
                                        new Escolha(null, null))));
                        capitulo3_2.setArray(new ArrayList<>(Arrays.asList(new Escolha(null, null),
                                        new Escolha(null, null))));
                        oos.writeObject(capitulo1);
                        oos.writeObject(capitulo1_1);
                        oos.writeObject(capitulo1_2);
                        oos.writeObject(capitulo1_3);
                        oos.writeObject(capitulo2);
                        oos.writeObject(capitulo2_1);
                        oos.writeObject(capitulo2_2);
                        oos.writeObject(capitulo3_1);
                        oos.writeObject(capitulo3_2);
                        oos.close();
                } catch (Exception e) {
                        System.out.println("Erro ao serializar o objeto Capítulo.");
                }
        }
}