package eventos;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.rmi.RemoteException;

import batalhanaval.JogadorServer;
import telas.TelaTabuleiroOponente;

public class TratadorMouseOponente implements MouseListener, MouseMotionListener {
	private TelaTabuleiroOponente painel;

	public TratadorMouseOponente(TelaTabuleiroOponente painel) {
		this.painel = painel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			if (JogadorServer.getEstadoJogo() == JogadorServer.jogadorId) {
				painel.adicionarJogada();
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		painel.posicaoAtual = new Point(e.getX() / 30, e.getY() / 30);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	// M�todos n�o usados
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
