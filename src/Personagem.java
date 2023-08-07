public class Personagem {
    private String nome;
    private int vida;

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return this.vida;
    }

    public String getMensagemAtk(int moduloDoAtaque) {
        return getNome() + " perde " + moduloDoAtaque + " pontos de vida!\n" +
                getNome() + " agora possui " + (this.vida - moduloDoAtaque) + " pontos de vida.\n";
    }
}