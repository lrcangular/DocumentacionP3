
public class Baldosa implements Cloneable {
	private String modelo;
	private Figura forma;
	private String color;
	private Double precio;

	public Baldosa(String modelo, Figura forma, String color, double precio) throws ObjetoErroneo {
		setModelo(modelo);
		setForma(forma);
		this.color = color;
		setPrecio(precio);
		if (this.modelo == null || this.forma == null || this.precio == null) {
			throw new ObjetoErroneo();
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Figura getForma() {
		return forma;
	}

	public void setForma(Figura forma) {
		if (forma != null) {
			this.forma = forma;
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		if (precio != null && precio > 0.0) {
			this.precio = precio;
		}
	}

	@Override
	public String toString() {
		return "Modelo de baldosa=" + modelo + ", forma=" + forma + ", color=" + color + ", superficie=" + String.format("%7.2f", forma.superficie())+ ", precio=" + String.format("%7.2f", precio) ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Baldosa)) {
			return false;
		}
		Baldosa other = (Baldosa) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (forma == null) {
			if (other.forma != null) {
				return false;
			}
		} else if (!forma.equals(other.forma)) {
			return false;
		}
		if (modelo == null) {
			if (other.modelo != null) {
				return false;
			}
		} else if (!modelo.equals(other.modelo)) {
			return false;
		}

		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Baldosa nueva = null;
		try {
			nueva = new Baldosa(this.modelo, this.forma, this.color, this.precio);
		} catch (ObjetoErroneo e) {
			// Como la baldosa existe la clonará y este error no se dará
			System.out.println("Error imposible al clonar");
		}
		return nueva;
	}

}
