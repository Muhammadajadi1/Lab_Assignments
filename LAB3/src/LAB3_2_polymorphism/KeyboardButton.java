package LAB3_2_polymorphism;

public class KeyboardButton {

	//data field
	protected String name;
	protected int code;
	protected String impliesSymbol = "->";

	//constructor
	public KeyboardButton(String buttons, int codes){
		setName(buttons);
		setCode(codes);
	}

	//Methods

	public String checkCode(int codes){
		return Integer.toString(getCode()) + impliesSymbol + getName();
	}

	public String getName(){
		return name;
	}

	public int getCode(){ return code;}

	public void setName(String newName){ name = newName;}

	public void setCode(int newCodes){ code = newCodes;}

	@Override
	public String toString(){
		return "KeyboardButton{" + "name='" + name + "\'" + ", code=" + code +
				", impliesSymbol='" + impliesSymbol + "\'" + "}" ;
	}
}
