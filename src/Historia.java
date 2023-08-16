import java.io.Serializable;
import java.util.Scanner;
import java.util.HashMap;

public class Historia implements Serializable {
        public static void main(String[] args) throws Exception {
                // Carregar Progresso
                boolean saveExistente = Saves.carregarProgresso(Saves.verificaSaveExistente());

                // Escaneador
                Scanner continuar = new Scanner(System.in);

                // Serializadores e Desserializadores
                Serializador serializador = new Serializador();
                Desserializador desserializador = new Desserializador(); // adicional - a remover
                serializador.serializadorDePersonagem();
                HashMap<String, Personagem> personagens = desserializador.desserializadorDePersonagem();
                serializador.serializadorDeCapitulo(personagens); // adicional - a remover
                HashMap<String, Capitulo> capitulos = desserializador.desserializadorDeCapitulo();

                if (saveExistente) {
                        System.out.println("aaa");
                }

                // Início do jogo
                Capitulo inicial = capitulos.get("[CAPÍTULO 1 - O INÍCIO]");
                inicial.executar(continuar);
        }
}