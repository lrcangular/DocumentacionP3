package gestion;

public interface Dimensionable {
	public default Double superficie() {
		return null;
	}
	
	public default Double longitud() {
		return null;
	};
}
