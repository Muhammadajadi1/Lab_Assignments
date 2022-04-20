package lab4_Exception;

import java.io.File;

public class OSTaskException extends Exception {

	private static final long serialVersionUID = 0;

	private String operation;

	private File file;

	//constructor

	public OSTaskException(String path, String newOperation){
		super(newOperation);
		operation = newOperation;
	}

	// Methods
	public File getFile(){
		return file;
	}

	public String getOperation(){
		return operation;
	}

}
