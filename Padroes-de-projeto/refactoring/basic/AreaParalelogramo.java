package refactoring.basic;

import java.util.Scanner;

public class AreaParalelogramo {

	private static float calcularAreaParalelogramo(float base, float height) {
		float area = base * height;

		return area;
	}

	public static void main(String[] args) {
		float base;
		float height;
		float area;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o valor da base: ");
		base = scanner.nextFloat();

		base = Math.abs(base);

		System.out.print("Digite o valor da altura: ");
		height = scanner.nextFloat();

		height = Math.abs(height);

		area = calcularAreaParalelogramo(base, height);

		System.out.println("");
		System.out.println("Área do paralelogramo: " + area);
		scanner.close();
	}
}