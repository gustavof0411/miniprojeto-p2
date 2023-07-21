import java.util.Scanner;
import java.util.ArrayList;

public class Capitulo {
    String nome;
    String texto;
    Personagem personagem;
    int vida;
    ArrayList<Escolha> arrayEscolhas;

    public Capitulo(String nome, String texto, Personagem personagem, int vida, String consequencia) {
        this.nome = nome;
        this.texto = texto;
        this.arrayEscolhas = new ArrayList<Escolha>();
        this.personagem = personagem;
        this.vida = vida;
        this.consequencia = consequencia;
    }

    public ArrayList<Escolha> retornaArray() {
        return this.arrayEscolhas;
    }

    public void mostrar(Scanner continuar) {
        if (this.nome != null) {
            System.out.println(this.nome);
            continuar.nextLine();
        }
        System.out.println(this.texto);
    }

    public int escolher(Scanner continuar, ArrayList<Escolha> arrayEscolhas) {
        String digitado = continuar.nextLine();
        boolean escolhaValida = false;
        int escolhido = -1;
        while (!escolhaValida) {

            for (int i = 0; i < arrayEscolhas.size(); i++) {
                if (digitado.equalsIgnoreCase(arrayEscolhas.get(i).texto)) {
                    escolhido = i;
                    escolhaValida = true;
                    break;
                }
            }
            if (!escolhaValida) {
                System.out.println("Certifique-se se digitou corretamente.");
                System.out.print("Digite novamente aqui:");
                digitado = continuar.nextLine();
            }
        }
        return escolhido;
    }

    void executar(Scanner continuar, ArrayList<Escolha> arrayEscolhas) {
        this.mostrar(continuar);
        this.escolher(continuar, arrayEscolhas);
    }
}
