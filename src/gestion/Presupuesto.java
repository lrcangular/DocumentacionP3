package gestion;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private String cliente;
	private Double superficie;
	private List<Baldosa> ofertas;

	public Presupuesto(String cliente, double superficie) throws ObjetoErroneo {
		setCliente(cliente);
		setSuperficie(superficie);
		ofertas = new ArrayList<>();
		if (this.cliente == null || this.superficie == null) {
			throw new ObjetoErroneo();
		}
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		if (cliente != null && cliente.trim().length() > 0) {
			this.cliente = cliente;
		}
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		if (superficie > 0.0) {
			this.superficie = superficie;
		}
	}

	public List<Baldosa> getOfertas() {
		return ofertas;
	}

	public boolean anadeOfertas(Baldosa bal) {
		if (bal != null && ofertas.size() < 3 && !ofertas.contains(bal)) {
			ofertas.add(bal);
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Presupuesto)) {
			return false;
		}
		Presupuesto other = (Presupuesto) obj;
		if (cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!cliente.equals(other.cliente)) {
			return false;
		}
		if (superficie == null) {
			if (other.superficie != null) {
				return false;
			}
		} else if (!superficie.equals(other.superficie)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String texto = "";
		int nbal;
		for (Baldosa baldosa : ofertas) {
			nbal = (int) (Math.round((Math.round(superficie / baldosa.getForma().superficie() + 0.5)) * 1.03 + 0.5));
			texto += "\n\t" + baldosa.toString() + "\n\t N�mero de baldosas: " + nbal + " Precio total "
					+ String.format(" %7.2f", nbal * baldosa.getPrecio());
		}
		return "Presupuesto  cliente=" + cliente + ", superficie a alicatar =" + superficie + "\n ofertas:" + texto;
	}

}
