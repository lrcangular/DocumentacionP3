package gestion;

public class Cuadrado extends Figura implements Dimensionable{

	public Cuadrado(double lado) throws ObjetoErroneo {
		super(lado);
	}
	
	@Override
	public Double superficie() {
		// TODO Auto-generated method stub
		return super.getLado() * super.getLado();
	}

	@Override
	public Double longitud() {
		// TODO Auto-generated method stub
		return super.getLado() * 4;
	}


	@Override
	public String toString() {
		return "Cuadrado " + super.toString();
	}

}
