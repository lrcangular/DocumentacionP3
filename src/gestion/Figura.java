package gestion;

public abstract class Figura implements Dimensionable {
	private Double lado;
	
	public Figura(double lado) throws ObjetoErroneo {
		setLado(lado);
		if (this.lado == null) {
			throw new ObjetoErroneo();
		}
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		if(lado>0.0) {
			this.lado = lado;		
		}
	}

	@Override
	public String toString() {
		return "lado=" + String.format(" %5.2f",lado) ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lado == null) ? 0 : lado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Figura)) {
			return false;
		}
		Figura other = (Figura) obj;
		if (lado == null) {
			if (other.lado != null) {
				return false;
			}
		} else if (!lado.equals(other.lado)) {
			return false;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		return true;
	}
	
	
}
