package refactoring.basic;

import java.util.Scanner;

public class VerificaPoliedro {
	public static void identifyPolihedron(float vertice, float aresta) {
		float face;

		face = 2 + aresta - vertice;

		if (vertice == 4 && aresta == 6) {
			System.out.println("Tetraedro: " + face + " faces");
			System.out.println("Forma face: Triângulo");
		} else if (vertice == 8 && aresta == 12) {
			System.out.println("Hexaedro: " + face + " faces");
			System.out.println("Forma face: Quadrado");
		} else if (vertice == 6 && aresta == 12) {
			System.out.println("Octaedro: " + face + " faces");
			System.out.println("Forma face: Triângulo");
		} else if (vertice == 20 && aresta == 30) {
			System.out.println("Dodecaedro: " + face + " faces");
			System.out.println("Forma face: Pentágono");
		} else if (vertice == 12 && aresta == 30) {
			System.out.println("Icosaedro: " + face + " faces");
			System.out.println("Forma face: Triângulo");
		} else {
			System.out.println("Os dados não indicam nenhum poliedro regular.");
		}
	}

	public static void main(String[] args) {
		float vertice;
		float aresta;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("Digite o número de vértices do poliedro [4-6-8-12-20]: ");
			vertice = scanner.nextFloat();
		} while (vertice != 4 && vertice != 6 && vertice != 8 && vertice != 12 && vertice != 20);

		System.out.println("");

		do {
			System.out.print("Digite o número de arestas do poliedro [6-12-30]: ");
			aresta = scanner.nextFloat();
		} while (aresta != 6 && aresta != 12 && aresta != 30);

		System.out.println("");

		identifyPolihedron(vertice, aresta);

		scanner.close();
	}
}