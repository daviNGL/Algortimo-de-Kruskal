import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private int totalVertices;
	private int totalArestas;
	private List<Aresta> arestas;
	
	
	/**
	 * Cria um grafo com n vértices.
	 * @param qtdVertices Quantidade de vértices que o grafo possui.
	 */
	public Grafo(int qtdVertices) {
		
		this.totalVertices = qtdVertices;
		this.totalArestas = 0;
		this.arestas = new ArrayList<>();
		
	}
	
	
	//GETTERS AND SETTERS
	public int getTotalVertices() {
		return totalVertices;
	}

	public int getTotalArestas() {
		return totalArestas;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}
	
	public void setTotalVertices(int totalVertices) {
		this.totalVertices = totalVertices;
	}
	
	
	
	/**
	 * Adiciona uma nova aresta ligada por dois vertices pertencentes ao grafo.
	 * @param verticeOrigem Vertice origem da aresta.
	 * @param verticeDestino Vertice destino da aresta.
	 * @param peso Peso da aresta.
	 */
	public void adicionarAresta(int verticeOrigem, int verticeDestino, int peso) {
		
		Aresta aresta = new Aresta(verticeOrigem, verticeDestino, peso);
		this.arestas.add(aresta);
		this.totalArestas++;
	}
	
	
	/**
	 * Exibe todas as arestas do grafo e seus respectivos pesos.
	 */
	public void exibirGrafo() {
		
		System.out.println("===========================================");
		System.out.println("                G R A F O                  ");
		System.out.println("===========================================");
		System.out.println("        ARESTA        |       PESO         ");
		System.out.println("===========================================");
		
		for( Aresta a : this.arestas ) {
			
			System.out.printf("    %d------------%d            (%d)        ", 
					a.getVerticeOrigem(), a.getVerticeDestino(), a.getPeso());
			System.out.println("");
		}
		
		System.out.println("===========================================");
		
	}
	
}
