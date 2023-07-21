public class Personagem {
    String nome;
    int vida;

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    public String nome() {
        return nome;
    }

    public int vida() {
        return vida;
    }

    public String atacado(Personagem personagem, int moduloDoAtaque, boolean exibirAtk) {
        this.vida = personagem.vida() - moduloDoAtaque;
        if (exibirAtk == true) {
            exibirAtk(personagem, moduloDoAtaque);
        }
        return null;
    }

    public String exibirAtk(Personagem personagem, int moduloDoAtaque) {
        System.out.println(personagem.nome() + " perde " + moduloDoAtaque + " pontos de vida!");
        System.out.println(personagem.nome() + " agora possui " + personagem.vida() + " pontos de vida.");
        if (personagem.vida() == 0) {
            System.out.println(personagem.nome() + " é derrotado.");
        }        
        return null;
    }
}
