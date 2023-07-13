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

    public Capitulo(String nome, String texto1, String texto2, String escolha1,
    String escolha2 , Personagem personagem, int vida) {
        this.nome = nome;
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.arrayEscolhas = new ArrayList<String>();
        this.arrayEscolhas.add(escolha1);
        this.arrayEscolhas.add(escolha2);
        this.personagem = personagem;
        this.vida = vida;
    }

    public ArrayList<String> retornaArray() {
        return this.arrayEscolhas;
    }
    
    public void mostrar1(Scanner continuar) {
        if (this.nome != null) {
            System.out.println(this.nome);
            continuar.nextLine();
        }
        System.out.println(this.texto1);
    }

    public void mostrar2(Scanner continuar) {
        if (this.texto2 != null) {
            System.out.println(texto2);
        }
    }

    public int escolher(Scanner continuar, ArrayList<String> arrayEscolhas) {
        String digitado = continuar.nextLine();
        int retorno = -1;
        while (!digitado.equalsIgnoreCase(arrayEscolhas.get(0)) && !digitado.equalsIgnoreCase(arrayEscolhas.get(1))) {
            System.out.println("Certifique-se se digitou corretamente.");
            System.out.print("Digite novamente aqui:");
            digitado = continuar.nextLine();
        }

        if (digitado.equalsIgnoreCase(arrayEscolhas.get(0))) {
            retorno = 0;
        } else if (digitado.equalsIgnoreCase(arrayEscolhas.get(1))) {
            retorno = 1;
        }
        return retorno;
    }
}
