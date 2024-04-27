
public class Hexagono extends Figura implements Dimensionable {

	public Hexagono(double lado) throws ObjetoErroneo {
		super(lado);
	}

	@Override
	public Double superficie() {
		// TODO Auto-generated method stub
		return super.getLado() * super.getLado() * Math.sqrt(3) * 3 / 2;
	}

	@Override
	public Double longitud() {
		// TODO Auto-generated method stub
		return super.getLado() * 6;
	}

	@Override
	public String toString() {
		return "Hexágono " + super.toString();
	}

}
