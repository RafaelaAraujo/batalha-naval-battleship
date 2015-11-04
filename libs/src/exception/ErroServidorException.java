package exception;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class ErroServidorException extends Exception{
	
	private static final long serialVersionUID = 5422275156519013919L;

	public ErroServidorException() {
		super();
	}

	public void mostrarAlerta(){
		JOptionPane.showMessageDialog(null, "N�o foi possivel estabelecer conex�o com o servidor do jogo, verifique sua internet");
	}
}
