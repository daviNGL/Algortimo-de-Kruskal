import java.util.ArrayList;
import java.util.List;

public class Kruskal {
	
	private static List<Aresta> arestasOrdenadas;
	private static List<Conjunto> conjuntos;
	private static Grafo arvoreGeradoraMinima;
	
	/**
	 * Gera um grafo que representa a árvore geradora mínima de um dado grafo simples, conexo e não direcional.
	 * @param grafo Grafo simples, conexo não direcional.
	 * @return Retorna um grafo que representa a árvore geradora.
	 */
	public static Grafo gerarArvoreAGM(Grafo grafo) {
		
		//CRIA UM CONJUNTO PARA CADA VERTICE DO GRAFO
		criarConjuntos(grafo);
		
		//CRIA UMA LISTA DE ARESTAS COM ELAS ORDENADAS PELO PESO
		criarListaDeArestasOrdenadas(grafo);
		
		//UNE OS CONJUNTOS ATÉ FORMAR ALGO CONEXO
		for(Aresta a : arestasOrdenadas) {
			
			if( !pertencemAoMesmoConjunto(a.getVerticeOrigem(), a.getVerticeDestino()) ) {
				
				unirConjuntos(a.getVerticeOrigem(), a.getVerticeDestino(), a);
				
			}
			
		}
		
		arvoreGeradoraMinima = conjuntos.get(0).getGrafoAux();
		
		return( arvoreGeradoraMinima );
	}

	
	/**
	 * Dado um grafo, cria um conjunto para cada um de seus vértices, com cada vértice sendo o único elemento do conjunto.
	 * @param grafo Grafo contendo os vértices que terão conjuntos criados e serão inseridos.
	 */
	private static void criarConjuntos(Grafo grafo) {
		
		conjuntos = new ArrayList<>();
		
		for(int i=0; i<grafo.getTotalVertices(); i++) {
			conjuntos.add( new Conjunto(1) );
			conjuntos.get(i).adicionaVertice(i);
		}
	}
	
	
	/**
	 * Dado um grafo não dirigido, cria uma lista com as arestas do grafo ordenadas crescentemente pelo peso das arestas.
	 * @param grafo Grafo contêndo n arestas.
	 */
	private static void criarListaDeArestasOrdenadas(Grafo grafo) {
		
		arestasOrdenadas = new ArrayList<>(grafo.getArestas());
		
		arestasOrdenadas.sort( (Aresta a1, Aresta a2) -> {
			return a1.getPeso() - a2.getPeso();
		});
		
	}
	
	
	/**
	 * Verifica se dois vértices pertencem ao mesmo conjunto.
	 * @param verticeOrigem Primeiro vértice.
	 * @param verticeDestino Segundo vértice.
	 * @return Retorna true se pertencem ao mesmo conjunto e false se não pertencem.
	 */
	private static boolean pertencemAoMesmoConjunto(int verticeOrigem, int verticeDestino) {
		
		for(Conjunto c : conjuntos) {
			
			if( c.getVerticesPertencentes().contains(verticeOrigem) &&
				c.getVerticesPertencentes().contains(verticeDestino)) {
				
				return(true);
				
			}
			
		}
		
		return(false);
	}

	
	/**
	 * Dados dois vértices pertencentes a dois conjuntos distintos, tal que um conjunto não é subconjunto
	 * do outro, insere um novo conjunto na lista, contendo a união desses dois conjuntos e remove eles
	 * da lista. Também insere a aresta que representa a ligação dos dois vertices, nas arestas do novo conjunto.
	 * @param verticeOrigem Vertice pertencente a um conjunto A.
	 * @param verticeDestino Vertice pertencente a um conjunto B.
	 * @param aresta Aresta que une os dois vertices.
	 */
	private static void unirConjuntos(int verticeOrigem, int verticeDestino, Aresta aresta) {
		
		Conjunto c1 = null;
		Conjunto c2 = null;
		
		//DESCOBRE OS CONJUNTOS QUE OS VERTICES PERTENCEM
		for(Conjunto c : conjuntos) {
			
			if(c.getVerticesPertencentes().contains(verticeOrigem))
				c1 = c;
			
			if(c.getVerticesPertencentes().contains(verticeDestino))
				c2 = c;
			
		}
		
		//CRIA UM NOVO CONJUNTO QUE CONTERA OS CONJUNTOS C1 E C2
		Conjunto novo = new Conjunto(0);
		
		//PASSA O CONTEUDO DO CONJUNTO C1 PARA O NOVO CONJUNTO
		for(int vertice : c1.getVerticesPertencentes())
			novo.getVerticesPertencentes().add(vertice);
		
		for(Aresta a : c1.getGrafoAux().getArestas())
			novo.getGrafoAux().getArestas().add(a);
		
		//PASSA O CONTEUDO DO CONJUNTO C2 PARA O NOVO CONJUNTO
		for(int vertice : c2.getVerticesPertencentes())
			novo.getVerticesPertencentes().add(vertice);
		
		for(Aresta a : c2.getGrafoAux().getArestas())
			novo.getGrafoAux().getArestas().add(a);
		
		//ADICIONA A ARESTA QUE LIGA OS DOIS CONJUNTOS
		novo.getGrafoAux().adicionarAresta(aresta.getVerticeOrigem(), aresta.getVerticeDestino(), aresta.getPeso());
		
		//AJUSTA A QUANTIDAE DE VERTICES
		novo.getGrafoAux().setTotalVertices( novo.getVerticesPertencentes().size() );
		
		//REMOVE OS DOIS CONJUNTOS QUE FORAM PASSADOS AO NOVO
		conjuntos.remove(c1);
		conjuntos.remove(c2);
		
		//ADICIONA O NOVO CONJUNTO
		conjuntos.add(novo);
	}

}


