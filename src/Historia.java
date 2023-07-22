import java.util.Arrays;
import java.util.Scanner;

public class Historia {
        public static void main(String[] args) throws Exception {
                // Escaneador
                Scanner continuar = new Scanner(System.in);

                // Personagens
                Personagem protagonista = new Personagem("Caleb", 100);
                Personagem rei = new Personagem("Rei Salaham", 100);
                Personagem magoDoMal = new Personagem("Mago do Mal", 100);

                // Capítulo
                Capitulo capitulo1 = new Capitulo("[CAPÍTULO 1 - O INÍCIO]", "Você é o guerreiro " + protagonista.nome()
                                + ". Em um certo dia, você é conjurado pelo Rei Salaham"
                                + " para recuperar o Anel do Poder roubado por seu rival, o " + magoDoMal.nome()
                                + ". Se não aceitar, pode pôr a vida do " + rei.nome()
                                + " em perigo. Aceitar a proposta? \n ACEITAR - DIGITE \"S\" \n RECUSAR - DIGITE \"N\"",
                                protagonista, 100, null);

                Capitulo capitulo1_1 = new Capitulo(null,
                                "Ao recusar, o " + magoDoMal.nome() + " permanece vivo e executa o " +
                                                rei.nome() + " com todo o poder do Anel. No dia seguinte, o "
                                                + magoDoMal.nome() + " vem até você e o oferece uma"
                                                + " proposta de servir a ele. Se não servir, terá que combatê-lo. \n COMBATER - DIGITE \"LUTAR\" \n"
                                                + " SERVIR - DIGITE \"SERVIR\"",
                                protagonista, protagonista.vida(), null);

                Capitulo capitulo1_2 = new Capitulo(null, "Você decide servir o " + magoDoMal.nome()
                                + ". Com o tempo, você se torna corrompido e deseja matar e conquistar cada território,"
                                + " tornando-se um forte aliado.",
                                protagonista, protagonista.vida(), "[FINAL 3 - FOME DE MATANÇA]");

                Capitulo capitulo1_3 = new Capitulo(null, "Você decide lutar contra o "
                                + magoDoMal.nome()
                                + ". Infelizmente, ele já estava forte demais para ser combatido. Você então é derrotado.",
                                protagonista, protagonista.vida(), "[FINAL 2 - PROTAGONISTA É DERROTADO]");

                Capitulo capitulo2 = new Capitulo("[CAPÍTULO 2 - A JORNADA]",
                                "Você aceita o convite do rei e parte para recuperar o"
                                                + " Anel do Poder. Há dois caminhos para seguir: O da direita é mais seguro, porém é mais longo. O da esquerda é"
                                                + " o mais rápido, porém com muito inimigos. Qual caminho seguir? \n IR PELA DIREITA - DIGITE \"DIREITA\""
                                                + "\n IR PELA ESQUERDA - DIGITE \"ESQUERDA\"",
                                protagonista, protagonista.vida(), null);

                Capitulo capitulo2_1 = new Capitulo("[CAPÍTULO 2.1 - SEGUINDO PELA ESQUERDA]",
                                "Você decide seguir pelo caminho"
                                                + " da esquerda. A viagem é curta, porém cheia de inimigos para derrotar,"
                                                + " o que lhe custou ferimentos intensos.",
                                protagonista, protagonista.vida(), null);

                Capitulo capitulo2_2 = new Capitulo("[CAPÍTULO 2.2 - SEGUINDO PELA DIREITA]",
                                "Você decide seguir pelo caminho da direita."
                                                + " A viagem é longa, com alguns poucos inimigos para derrotar, o que lhe custou ferimentos leves.",
                                protagonista, protagonista.vida(), null);

                Capitulo capitulo3_1 = new Capitulo("[CAPÍTULO 3.1 - A CHEGADA À TORRE]",
                                "Você chega até a torre. O Mago do Mal"
                                                + " deve estar no topo da torre, porém você deve derrotar alguns inimigos que protegiam a torre."
                                                + " Ao derrotá-los, você chega até ao topo da torre e enfrenta o Mago do Mal"
                                                + " em uma batalha. Porém, os ferimentos dos inimigos do caminho afetaram sua vitalidade e o deixou fraco para"
                                                + " a batalha, o que levou à sua derrota.",
                                protagonista, protagonista.vida(), "[FINAL 4 - GUERREIRO DESTEMIDO]");

                Capitulo capitulo3_2 = new Capitulo("[CAPÍTULO 3.2 - A CHEGADA À TORRE]",
                                "Você chega até a torre. O Mago do Mal"
                                                + " deve estar no topo da torre, porém você deve derrotar alguns inimigos que protegiam a torre."
                                                + " Ao derrotá-los, você chega até o topo da torre e enfrenta o Mago do Mal"
                                                + " em uma batalha. Com vitalidade o suficiente, você consegue derrotar o Mago do Mal e devolver o Anel do Poder"
                                                + " de volta para o Rei de forma segura.",
                                protagonista, protagonista.vida(), "[FINAL 1 - O ANEL É RECUPERADO]");

                capitulo1.arrayEscolhas.addAll(Arrays.asList(
                                new Escolha("s", capitulo2),
                                new Escolha("n", capitulo1_1)));

                capitulo1_1.arrayEscolhas.addAll(Arrays.asList(
                                new Escolha("servir", capitulo1_2),
                                new Escolha("lutar", capitulo1_3)));
                capitulo1_2.arrayEscolhas.addAll(Arrays.asList(
                                new Escolha(null, null),
                                new Escolha(null, null)));
                capitulo1_3.arrayEscolhas.addAll(Arrays.asList(
                                new Escolha(null, null),
                                new Escolha(null, null)));

                capitulo2.arrayEscolhas
                                .addAll(Arrays.asList(new Escolha("esquerda", capitulo2_1),
                                                new Escolha("direita", capitulo2_2)));
                capitulo2_1.arrayEscolhas.addAll(Arrays.asList(new Escolha(null, capitulo3_1),
                                new Escolha(null, capitulo3_1)));
                capitulo2_2.arrayEscolhas.addAll(Arrays.asList(new Escolha(null, capitulo3_2),
                                new Escolha(null, capitulo3_2)));
                capitulo3_1.arrayEscolhas.addAll(Arrays.asList(new Escolha(null, null),
                                new Escolha(null, null)));
                capitulo3_2.arrayEscolhas.addAll(Arrays.asList(new Escolha(null, null),
                                new Escolha(null, null)));
                
                

                Capitulo inicial = capitulo1;
                inicial.executar(continuar, capitulo1.arrayEscolhas);

        }
}
