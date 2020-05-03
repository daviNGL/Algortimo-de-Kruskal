public class Application {
	
	public static void main(String[] args) {
		
		//CRIA UM NOVO GRAFO COM 5 VÉRTICES
		Grafo grafo = new Grafo(5);
		
		//ADICIONA AS DEVIDAS ARESTAS NO GRAFO. DO VÉRTICE X AO Y, COM PESO Z
		grafo.adicionarAresta(0, 1, 1);
		grafo.adicionarAresta(0, 2, 2);
		grafo.adicionarAresta(0, 3, 6);
		grafo.adicionarAresta(1, 3, 2);
		grafo.adicionarAresta(2, 3, 4);
		grafo.adicionarAresta(2, 4, 1);
		grafo.adicionarAresta(3, 4, 1);
		
		grafo.exibirGrafo();
		
		Grafo agm = Kruskal.gerarArvoreAGM(grafo);
		
		if(agm != null) {
			System.out.println("\nArvore geradora minima gerada com sucesso!\n");
			agm.exibirGrafo();
		}
	}
}
