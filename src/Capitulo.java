import java.util.Scanner;
import java.util.ArrayList;

public class Capitulo {
    String nome;
    String texto1;
    String texto2;
    String escolha1;
    String escolha2;
    Personagem personagem;
    int vida;
    ArrayList<String> arrayEscolhas;

    public Capitulo(String nome, String texto1, String texto2, String escolha1, String escolha2 , Personagem personagem, int vida) {
        this.nome = nome;
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.arrayEscolhas = new ArrayList<String>();
        this.arrayEscolhas.add(escolha1);
        this.arrayEscolhas.add(escolha2);
        this.personagem = personagem;
        this.vida = vida;
    }

    public void mostrar1(Scanner continuar) {
        if (this.nome != null) {
            System.out.println(this.nome);
            continuar.nextLine();
        }
        System.out.println(this.texto1);
        continuar.nextLine();
    }

    public void mostrar2(Scanner continuar) {
        if (this.texto2 != null) {
            System.out.println(texto2);
        }
        for (int escolhas = 0; escolhas < arrayEscolhas.size(); escolhas++) {
            if (arrayEscolhas.get(escolhas) != null) {
                System.out.println(arrayEscolhas.get(escolhas));
            }
        }
    }

    public int escolher(Scanner continuar, String escolha1, String escolha2) {
        String digitado = continuar.nextLine();
        int retorno = 0;
        while (!digitado.equalsIgnoreCase(escolha1) && !digitado.equalsIgnoreCase(escolha2)) {
            System.out.println("Certifique-se se digitou corretamente.");
            System.out.print("Digite novamente aqui:");
            digitado = continuar.nextLine();
        }

        if (digitado.equalsIgnoreCase(escolha1)) {
            retorno = 1;
        } else if (digitado.equalsIgnoreCase(escolha2)) {
            retorno = 2;
        }
        return retorno;
    }
}
