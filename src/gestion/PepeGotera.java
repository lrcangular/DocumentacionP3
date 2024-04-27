package gestion;
import java.util.ArrayList;
import java.util.List;

public class PepeGotera {

	public static void main(String[] args) {

		List<Baldosa> catalogo = new ArrayList<>();
		List<Presupuesto> pedidos = new ArrayList<>();
		final String[] MENU = { "Salir", "Alta baldosa", "Baja baldosa", "Modificaci�n baldosas", "Listado de baldosas",
				"Crea presupuesto", "A�ade baldosa a presupuesto", "Lista presupuestos" };
		final String[] FIGURA = { "Salir", "Tri�ngulo", "Cuadrado", "Hex�gono" };
		int opcion = -1, pos;
		String cliente;
		double superficie;
		Baldosa b = null;
		Presupuesto p = null;
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				creaBaldosa(catalogo, FIGURA);
				break;
			case 2:
				pos = selecciona(catalogo, " a borrar");
				b = catalogo.remove(pos);
				System.out.println("Baldosa borrada " + b);
				break;
			case 3:
				modificaBaldosa(catalogo, FIGURA);
				break;
			case 4:
				imprimeBaldosas(catalogo);
				break;
			case 5:
				cliente = Leer.cadena("Nombre del cliente");
				superficie = Leer.doble("Superficie a alicatar");
				try {
					p = new Presupuesto(cliente, superficie);
					pedidos.add(p);
				} catch (ObjetoErroneo e) {
					System.out.println("Datos err�neos para elaborar un presupuesto");
				}
				break;
			case 6:
				pos = seleccionaPre(pedidos, " a a�adir baldosas");
				p = pedidos.get(pos);
				System.out.println(p);
				pos = selecciona(catalogo, " a a�adir");
				b = catalogo.get(pos);
				if(p.anadeOfertas(b)) {
					System.out.println("Baldosa a�adida correctamente");
				} else {
					System.out.println("No se puede a�adir la baldosa");
				}
				break;
			case 7:
				for (Presupuesto pre : pedidos) {
					System.out.println(pre + "\n-------");
				}
				break;
			}
			opcion = Leer.menu(MENU);
		}
		System.out.println("FIN DE PROGRAMA");
	}

	public static int selecciona(List<Baldosa> cat, String texto) {
		int pos = -1;
		imprimeBaldosas(cat);
		while (pos < 0 || pos > cat.size() - 1) {
			pos = Leer.entero("Selecciona la baldosa" + texto);
		}
		return pos;
	}

	private static void imprimeBaldosas(List<Baldosa> cat) {
		for (int i = 0; i < cat.size(); i++) {
			System.out.println(i + " " + cat.get(i).toString());
		}
	}
	
	public static int seleccionaPre(List<Presupuesto> pre, String texto) {
		int pos = -1;
		for (int i = 0; i < pre.size(); i++) {
			System.out.println(i + " " + pre.get(i).getCliente() + " superficie " + String.format(" %7.2f", pre.get(i).getSuperficie()));
		}
		while (pos < 0 || pos > pre.size() - 1) {
			pos = Leer.entero("Selecciona el presupuesto" + texto);
		}
		return pos;
	}
	
	public static void creaBaldosa(List<Baldosa> catalogo, String[] FIGURA) {
		int opcion = -1;
		String modelo, color;
		double precio, lado;
		Baldosa b = null;
		Figura forma = null;
		
		modelo = Leer.cadena("Modelo de la baldosa");
		color = Leer.cadena("Color de la baldosa");
		precio = Leer.doble("Precio de la baldosa");
		lado = Leer.doble("Longitud del lado");
		opcion = -1;
		while (opcion < 0 || opcion > 3) {
			opcion = Leer.menu(FIGURA);
		}
		try {
			switch (opcion) {
			case 1:
				forma = new Triangulo(lado);
				break;
			case 2:
				forma = new Cuadrado(lado);
				break;
			case 3:
				forma = new Hexagono(lado);
				break;
			}
			b = new Baldosa(modelo, forma, color, precio);
			if (catalogo.contains(b)) {
				System.out.println("La baldosa ya existe");
			} else {
				catalogo.add(b);
			}
		} catch (ObjetoErroneo e) {
			System.out.println("Hay errores en la forma de la baldosa");
		}
	}
	
	public static void modificaBaldosa(List<Baldosa> catalogo, String[] FIGURA) {
		int opcion = -1, pos;
		String modelo, color;
		double precio, lado;
		Baldosa b = null;
		Figura forma = null;
		
		pos = selecciona(catalogo, " a modificar");
		try {
			b = (Baldosa) catalogo.get(pos).clone();
			System.out.println(b + "\n Con Intro se valida el valor existente");
			modelo = Leer.cadena("Modelo de la baldosa");
			if (!modelo.equals("")) {
				b.setModelo(modelo);
			}
			color = Leer.cadena("Color de la baldosa");
			if (!modelo.equals("")) {
				b.setColor(color);
			}
			precio = Leer.doble("Precio de la baldosa");
			if (precio > 0.0) {
				b.setPrecio(precio);
			}
			lado = Leer.doble("Longitud del lado");
			if (lado == 0.0) {
				lado = b.getForma().getLado();
			}
			opcion = -1;
			while (opcion < 0 || opcion > 3) {
				opcion = Leer.menu(FIGURA);
			}
			try {
				switch (opcion) {
				case 0:
					forma = b.getForma();
					forma.setLado(lado);
				case 1:
					forma = new Triangulo(lado);
					break;
				case 2:
					forma = new Cuadrado(lado);
					break;
				case 3:
					forma = new Hexagono(lado);
					break;
				}
				b.setForma(forma);
				if (catalogo.indexOf(b) == pos || catalogo.indexOf(b) == -1) {
					catalogo.set(pos, b);
				} else {
					System.out.println("La baldosa ya existe");
				}
			} catch (ObjetoErroneo e) {
				System.out.println("Hay errores en la forma de la baldosa");
			}
		} catch (CloneNotSupportedException e) {
			System.out.println("Error al clonar");
		}
	}
}
