
public class Triangulo extends Figura implements Dimensionable {

	public Triangulo(double lado) throws ObjetoErroneo {
		super(lado);
	}

	@Override
	public Double superficie() {
		// TODO Auto-generated method stub
		return super.getLado() * super.getLado() * Math.sqrt(3) / 4;
	}

	@Override
	public Double longitud() {
		// TODO Auto-generated method stub
		return super.getLado() * 3;
	}

	@Override
	public String toString() {
		return "Triángulo " + super.toString();
	}

}
