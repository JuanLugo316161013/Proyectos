package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.Lista;
/**
 * Genera codigo SVG que representa a un ArbolAVL.
 */
public class GeneradorArbolAVLSVG extends GeneradorArbolBinarioSVG {

	/**
	 * Constructor que recibe una Lista de elementos del ArbolAVL.
	 * @throws ExcepcionFormatoEquivocado si algun elemento es caracter no imprimible.
	 * @throws NumberFormatException si algun elemento no es un numero entero.
	 */
	public GeneradorArbolAVLSVG(Lista<String> elementos) {	
		super(elementos);
	}

	/**
	 * Devuelve una instancia de un nuevo arbol binario, usando una instancia de {@link ArbolAVL}
	 */
	@Override protected ArbolBinario<Integer> nuevoArbolBinario() {
		return new ArbolAVL<Integer>();
	}
}