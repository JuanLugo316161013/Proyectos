package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Pila;
import mx.unam.ciencias.edd.Lista;
/**
 * Genera codigo SVG que representa a un Pila.
 */
public class GeneradorPilaSVG implements GeneradorEstructuraSVG {

	/** Pila de Integer interna. */
	private Pila<Integer> pila;

	/** elementos en la estructura */
	private int elementos;
	
	/**
	 * Constructor vacío.
	 */
	private GeneradorPilaSVG() {}

	/**
	 * Constructor que recibe una Lista de elementos del Pila.
	 * @throws ExcepcionFormatoEquivocado si algun elemento es caracter no imprimible.
	 * @throws NumberFormatException si algun elemento no es un numero entero.
	 */
	public GeneradorPilaSVG(Lista<String> elementos) {
		pila = new Pila<Integer>();
		for(String numero : elementos)
			if (numero.isEmpty()) {
				throw new ExcepcionFormatoEquivocado();
			} else {
				pila.mete(new Integer(numero));
				this.elementos++;
			}
	}
	
	/**
	 * Regresa un segmento de codigo que coloca un elemento en un casiila en SVG,
	 * a partir de la posicion de la casilla en el plano (x,y).
	 * @param x punto en la recta x.
	 * @param y punto en la recta y.
	 * @return representacion del elemento
	 */
	private String elemento(int x, int y, int elemento) {
		return  String.format("<text fill='black' font-family='sans-serif' font-size='20' x='%d' y='%d' text-anchor='middle'>%d</text>",
			x+25, (y+30)-7, elemento);
	}

	/**
	 * Regresa un un rectangulo de 50px por 30px en codigo SVG, a partir del punto el plano (x,y).
	 * @param x punto en la recta x.
	 * @param y punto en la recta y.
	 * @return rectangulo de 50px por 30px en codigo SVG.
	 */
	private String rectangulo(int x, int y) {
		return String.format("<rect x = '%d' y = '%d' width = '50' height = '30' stroke-width = '2' stroke = 'black' fill = 'white'/>", x, y);
	}

	/**
	 * Imprime el codigo SVG que representa a la Estructura de Datos.
	 */
	@Override public void imprimirCodigoSVG() {
		int x = 40, y = 40;
		System.out.printf("<svg width='150' height='%d' >\n\n", 100 + elementos*30);

		while (!pila.esVacia()) {
			System.out.println(rectangulo(x,y));
			System.out.println(elemento(x,y,pila.saca()));
			y += 30;
		}
		System.out.println("\n</svg");
	}
}