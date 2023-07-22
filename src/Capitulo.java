import java.util.Scanner;
import java.util.ArrayList;

public class Capitulo {
    String nome;
    String texto;
    Personagem personagem;
    int vida;
    ArrayList<Escolha> arrayEscolhas;
    String finalCap;

    public Capitulo(String nome, String texto, Personagem personagem, int vida, String finalCap) {
        this.nome = nome;
        this.texto = texto;
        this.arrayEscolhas = new ArrayList<Escolha>();
        this.personagem = personagem;
        this.vida = vida;
        this.finalCap = finalCap;
    }

    public ArrayList<Escolha> retornaArray() {
        return this.arrayEscolhas;
    }

    public Capitulo capituloSemEscolha(int escolhaAutomatica) {
        return this.arrayEscolhas.get(escolhaAutomatica).proximo;
    }

    public void mostrar(Scanner continuar) {
        if (this.nome != null) {
            System.out.println(this.nome);
            continuar.nextLine();
        }
        System.out.println(this.texto);
    }

    public int escolher(Scanner continuar, ArrayList<Escolha> arrayEscolhas) {
        boolean escolhaValida = false;
        int escolhido = -1;
        if (arrayEscolhas.get(0).texto != null) {
            String digitado = continuar.nextLine();
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
        }
        return escolhido;
    }

    int executar(Scanner continuar, ArrayList<Escolha> arrayEscolhas) {
        this.mostrar(continuar);
        int escolhido;
        if (this.finalCap != null) {
            escolhido = -1;
            System.out.println(finalCap);
            System.out.println("Fim da história!");
            System.exit(0);
        } else {
            escolhido = this.escolher(continuar, arrayEscolhas);
            if (escolhido >= 0 && escolhido < arrayEscolhas.size()) {
                Capitulo proximoCapitulo = arrayEscolhas.get(escolhido).proximo;
                if (proximoCapitulo.arrayEscolhas.get(escolhido).texto == null) {
                    Capitulo escolhaAutomatica = proximoCapitulo.arrayEscolhas.get(0).proximo;
                    proximoCapitulo.executar(continuar, proximoCapitulo.retornaArray());
                    escolhaAutomatica.mostrar(continuar);
                    if (escolhaAutomatica.arrayEscolhas.get(0).proximo == null) {
                        System.out.println(escolhaAutomatica.finalCap);
                    }
                } else {
                    proximoCapitulo.executar(continuar, proximoCapitulo.retornaArray());
                }
            }
        }
        return escolhido;
    }
}