package refactoring.basic;

import java.util.Scanner;

public class Potencia {
	private static int calcularPotencia(int base, int exponent) {
		var result = 1;

		if (exponent > 0) {
			for (int i = 0; i < exponent; i++) {
				result = result * base;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int number;
		int exponent;
		int result = 0;
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o número a ser potenciado: ");
		number = scan.nextInt();

		System.out.println("Digite a potência desejada: ");
		exponent = scan.nextInt();

		while (exponent < 0 || number <= 1) {
			System.out.println("Entrada inválida");
			System.out.println("");
			System.out.println("Digite o número a ser potenciado: ");
			number = scan.nextInt();
			System.out.println("Digite a potência desejada: ");
			exponent = scan.nextInt();
		}

		result = calcularPotencia(number, exponent);

		System.out.println("");
		System.out.println(number + " elevado a " + exponent + ": " + result);
		scan.close();
	}
}
