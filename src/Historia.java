import java.util.Scanner;

public class Historia {
        public static void main(String[] args) throws Exception {
                // Escaneador
                Scanner continuar = new Scanner(System.in);

                // Personagens
                Personagem protagonista = new Personagem("Caleb", 100);
                Personagem rei = new Personagem("Rei Salaham", 100);
                Personagem magoDoMal = new Personagem("Mago do Mal", 100);

                int caminhoSeguido = 0;

                // Capítulo 1
                Capitulo capitulo1 = new Capitulo("[CAPÍTULO 1 - O INÍCIO]", "Você é o guerreiro " + protagonista.nome()
                                + ". Em um certo dia, você é conjurado pelo Rei Salaham"
                                + " para recuperar o Anel do Poder roubado por seu rival, o " + magoDoMal.nome()
                                + ". Se não aceitar, pode pôr a vida do " + rei.nome()
                                + " em perigo. Aceitar a proposta? \n ACEITAR - DIGITE \"S\" \n RECUSAR - DIGITE \"N\"",
                                null, "n", "s", protagonista, 100);

                capitulo1.mostrar1(continuar);
                capitulo1.mostrar2(continuar);
                int escolhaCap1 = capitulo1.escolher(continuar, capitulo1.retornaArray());

                if (escolhaCap1 == 0) {
                        Capitulo capitulo1_1 = new Capitulo(null, "Ao recusar, o "
                                        + magoDoMal.nome()
                                        + " permanece vivo e executa o rei com todo o poder do Anel.",
                                        "No dia seguinte, o Mago do Mal"
                                                        + " vem até você e o oferece uma"
                                                        + " proposta de servir a ele. Se não servir, terá que combatê-lo."
                                                        + "\n COMBATER - DIGITE \"LUTAR\" \n SERVIR - DIGITE \"SERVIR\"",
                                        "servir", "lutar", protagonista, protagonista.vida());
                        capitulo1_1.mostrar1(continuar);
                        rei.atacado(rei, 100);
                        capitulo1_1.mostrar2(continuar);
                        int escolhaCap1_1 = capitulo1_1.escolher(continuar, capitulo1_1.retornaArray());
                        if (escolhaCap1_1 == 0) {
                                Capitulo capitulo1_2 = new Capitulo(null, "Você decide servir o " + magoDoMal.nome()
                                                + ". Com o tempo, você se torna corrompido e deseja matar e conquistar cada território,"
                                                + " tornando-se um forte aliado.", null, null, null, protagonista,
                                                protagonista.vida());
                                capitulo1_2.mostrar1(continuar);
                                System.out.print("[FINAL 3 - CORROMPIDO PELO MAL]");
                        } else if (escolhaCap1_1 == 1) {
                                Capitulo capitulo1_2 = new Capitulo(null, "Você decide lutar contra o "
                                                + magoDoMal.nome()
                                                + ". Infelizmente, ele já estava forte demais para ser combatido. Você então é derrotado.",
                                                null,
                                                null, null,
                                                protagonista, protagonista.vida());
                                capitulo1_2.mostrar1(continuar);
                                protagonista.atacado(protagonista, protagonista.vida());
                                capitulo1_2.mostrar2(continuar);
                                System.out.print("[FINAL 4 - DERROTADO COM DIGNIDADE]");
                        }
                } else if (escolhaCap1 == 1) {

                        // Capítulo 2
                        Capitulo capitulo2 = new Capitulo("[CAPÍTULO 2 - A JORNADA]",
                                        "Você aceita o convite do rei e parte para recuperar o"
                                                        + " Anel do Poder. Há dois caminhos para seguir: O da direita é mais seguro, porém é mais longo. O da esquerda é"
                                                        + " o mais rápido, porém com muito inimigos. Qual caminnho seguir? \n IR PELA DIREITA - DIGITE \"DIREITA\""
                                                        + "\n IR PELA ESQUERDA - DIGITE \"ESQUERDA\"",
                                        null, "esquerda", "direita", protagonista, protagonista.vida());
                        capitulo2.mostrar1(continuar);
                        capitulo2.mostrar2(continuar);
                        int escolhaCapitulo2 = capitulo2.escolher(continuar, capitulo2.retornaArray());
                        if (escolhaCapitulo2 == 0) {
                                Capitulo capitulo2_1 = new Capitulo("[CAPÍTULO 2.1 - SEGUINDO PELA ESQUERDA]",
                                                "Você decide seguir pelo caminho"
                                                                + " da esquerda. A viagem é curta, porém cheia de inimigos para derrotar,"
                                                                + " o que lhe custou ferimentos intensos.",
                                                null,
                                                null, null, protagonista, protagonista.vida());
                                capitulo2_1.mostrar1(continuar);
                                protagonista.atacado(protagonista, 40);
                                capitulo2_1.mostrar2(continuar);
                                caminhoSeguido = 1;
                        } else if (escolhaCapitulo2 == 1) {
                                Capitulo capitulo2_2 = new Capitulo("[CAPÍTULO 2.2 - SEGUINDO PELA DIREITA]",
                                                "Você decide seguir pelo caminho da direita."
                                                                + " A viagem é longa, com alguns poucos inimigos para derrotar, o que lhe custou ferimentos leves.",
                                                null, null, null, protagonista,
                                                protagonista.vida());
                                capitulo2_2.mostrar1(continuar);
                                protagonista.atacado(protagonista, 10);
                                capitulo2_2.mostrar2(continuar);
                                caminhoSeguido = 2;
                        }

                        // Capítulo 3

                        Capitulo capitulo3 = new Capitulo("[CAPÍTULO 3 - A CHEGADA À TORRE]",
                                        "Você chega até a torre. O Mago do Mal"
                                                        + " deve estar no topo da torre, porém você deve derrotar alguns inimigos que protegiam a torre.",
                                        null,
                                        null, null, protagonista, protagonista.vida());
                        capitulo3.mostrar1(continuar);
                        protagonista.atacado(protagonista, 30);
                        capitulo3.mostrar2(continuar);
                        if (caminhoSeguido == 1) {
                                Capitulo capitulo3_1 = new Capitulo(null,
                                                "Você chega até ao topo da torre e enfrenta o Mago do Mal"
                                                                + " em uma batalha. Porém, os ferimentos dos inimigos do caminho afetaram sua vitalidade e o deixou fraco para"
                                                                + " a batalha, o que levou à sua derrota.",
                                                null,
                                                null, null, protagonista,
                                                protagonista.vida());
                                capitulo3_1.mostrar1(continuar);
                                protagonista.atacado(protagonista, protagonista.vida());
                                capitulo3_1.mostrar2(continuar);
                                System.out.println("[FINAL 2 - GUERREIRO DESTEMIDO]");
                        } else if (caminhoSeguido == 2) {
                                Capitulo capitulo3_2 = new Capitulo(null,
                                                "Você chega até o topo da torre e enfrenta o Mago do Mal"
                                                                + " em uma batalha. Com vitalidade o suficiente, você consegue derrotar o Mago do Mal e devolver o Anel do Poder"
                                                                + " de volta para o Rei de forma segura.",
                                                null,
                                                null, null, protagonista,
                                                protagonista.vida());
                                capitulo3_2.mostrar1(continuar);
                                protagonista.atacado(protagonista, protagonista.vida());
                                capitulo3_2.mostrar2(continuar);
                                System.out.println("[FINAL 1 - O ANEL É RECUPERADO]");
                        }
                }
        }
}
