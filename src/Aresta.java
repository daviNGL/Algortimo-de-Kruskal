
public class Aresta {
	
	private int verticeOrigem;
	private int verticeDestino;
	private int peso;
	
	/**
	 * Cria uma aresta com peso.
	 * @param origem V�rtice origem.
	 * @param destino V�rtice destino.
	 * @param peso Peso da aresta.
	 */
	public Aresta(int origem, int destino, int peso) {
		this.verticeOrigem = origem;
		this.verticeDestino = destino;
		this.peso = peso;
	}

	public int getVerticeOrigem() {
		return verticeOrigem;
	}

	public int getVerticeDestino() {
		return verticeDestino;
	}

	public int getPeso() {
		return peso;
	}
	
}
