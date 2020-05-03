import java.util.ArrayList;
import java.util.List;

public class Conjunto {
	
	//LISTA DE V�RTICES QUE PERTENCEM A ESSE CONJUNTO
	private List<Integer> verticesPertencentes;
	//GRAFO AUXILIAR PARA REPRESENTAR O CONJUNTO DE ARESTAS
	private Grafo grafoAux;
	
	/**
	 * Cria um novo conjunto.
	 * @param vertices Quantidade de v�rtices inicial do conjunto.
	 */
	public Conjunto(int vertices) {
		this.verticesPertencentes = new ArrayList<>();
		this.grafoAux = new Grafo(vertices);
	}
	
	//GETTERS AND SETTERS
	public List<Integer> getVerticesPertencentes() {
		return verticesPertencentes;
	}

	public void setVerticesPertencentes(List<Integer> verticesPertencentes) {
		this.verticesPertencentes = verticesPertencentes;
	}

	public Grafo getGrafoAux() {
		return grafoAux;
	}

	public void setGrafoAux(Grafo grafoAux) {
		this.grafoAux = grafoAux;
	}
	
	
	/**
	 * Adiciona um v�rtice na lista de v�rtices pertencentes ao conjunto.
	 * @param i N�mero do v�rtice.
	 */
	public void adicionaVertice(int i) {
		Integer valor = Integer.valueOf(i);
		this.verticesPertencentes.add(valor);
	}
	
}
