package batalhanaval;

import java.io.Serializable;
import java.util.ArrayList;

import enuns.TipoEstado;


/**
 * Jogo de batalha naval.
 * 
 * @author Darlan P. de Campos
 * @author Roger de C�rdova Farias
 * 
 */

public class Jogo implements Serializable {

    private static final long serialVersionUID = 1L;

    //// Constantes
    // N�veis de dificuldade
    public static final int FACIL = 0;
    public static final int MEDIO = 1;
    public static final int DIFICIL = 2;

    // Estados do jogo
    //public static final int POSICIONANDO_NAVIOS = 0;
    //public static final int VEZ_JOG1 = 1;
    //public static final int VEZ_JOG2 = 2;
    //public static final int TERMINADO = 3;

    private Jogador[] jogadores;

    private int dificuldade;
    private TipoEstado estado;

    // Fila de eventos
    private ArrayList<Evento> eventos;

    public Jogo(int dif) {
        jogadores = new Jogador[2];
        jogadores[0] = new Jogador(this);
        jogadores[1] = new Robo(this);

        dificuldade = dif;

        eventos = new ArrayList<Evento>();

        setEstado(TipoEstado.POSICIONANDO_NAVIOS);
    }

    public void setEstado(TipoEstado estado) {
        if (estado == TipoEstado.POSICIONANDO_NAVIOS) {
            this.addEvento("Prepare-se! A batalha vai come�ar!");
        } else if (estado == TipoEstado.TERMINADO) {
            if (this.getVencedor() == jogadores[0])
                addEvento("A batalha terminou! Voc� foi derrotado!");
            else
                addEvento("A batalha terminou! Voc� venceu!");
        }

        this.estado = estado;
    }

    /**
     * 
     * @param i
     * @return O jogador indicado por <code>i</code>
     */
    public Jogador getJogador(int i) {
        return jogadores[i];
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public Jogador getVencedor () {
        if (this.estado != TipoEstado.TERMINADO)
            return null;

        return this.jogadores[0].getFrotaRestante() == 0
            ? jogadores[1]
            : jogadores[0];           
    }

    /**
     * Adiciona um evento ao final da fila.
     *
     * @param mensagem A mensagem do evento
     */
    public void addEvento (String mensagem) {
        this.eventos.add(new Evento(mensagem));
    }

    /**
     * Remove e retorna o primeiro evento da fila.
     *
     * @return Evento
     */
    public Evento getEvento () {
        if (eventos.size() > 0)
            return eventos.remove(0);
        else
            return null;
    }
}
