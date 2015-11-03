package exception;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class ErroServidorException extends RemoteException{
	
	private static final long serialVersionUID = 5422275156519013919L;

	public ErroServidorException(String msg) {
		super(msg);
		//JOptionPane.showMessageDialog(null, "N�o foi possivel estabelecer conex�o com o servidor do jogo, verifique sua internet");
	}

}
