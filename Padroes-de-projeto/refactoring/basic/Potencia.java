package refactoring.basic;

import java.util.Scanner;

public class Potencia 
{
	//Programa "CalculaPotencia"
	//Calcula a potência p de um número N digitado.
	//---------------------------------------------------------
	
	public static void main(String[] args)
	{
	int N, p, Pote, j;
	Scanner scan = new Scanner(System.in);
	System.out.println("Digite o número a ser potenciado: ");
	N=scan.nextInt();
	System.out.println("Digite a potência desejada: ");
	p=scan.nextInt();
	while (p<0||N<=1){
	System.out.println("Entrada inválida");
	System.out.println("");
	System.out.println("Digite o número a ser potenciado: ");
	N=scan.nextInt();
	System.out.println("Digite a potência desejada: ");
	p=scan.nextInt();}
	Pote = 1;
	if(p>0) { //se pot maior que zero
	for(j=0; j<p; j++)//calcula potência com loop
	Pote=Pote*N;
	}
	System.out.println("");
	System.out.println(N + " elevado a"+p+":"+Pote);
	scan.close();
	}
}
