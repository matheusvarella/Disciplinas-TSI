package refactoring.basic;

import java.util.Scanner;

public class Potencia 
{
	//Programa "CalculaPotencia"
	//Calcula a pot�ncia p de um n�mero N digitado.
	//---------------------------------------------------------
	
	public static void main(String[] args)
	{
	int N, p, Pote, j;
	Scanner scan = new Scanner(System.in);
	System.out.println("Digite o n�mero a ser potenciado: ");
	N=scan.nextInt();
	System.out.println("Digite a pot�ncia desejada: ");
	p=scan.nextInt();
	while (p<0||N<=1){
	System.out.println("Entrada inv�lida");
	System.out.println("");
	System.out.println("Digite o n�mero a ser potenciado: ");
	N=scan.nextInt();
	System.out.println("Digite a pot�ncia desejada: ");
	p=scan.nextInt();}
	Pote = 1;
	if(p>0) { //se pot maior que zero
	for(j=0; j<p; j++)//calcula pot�ncia com loop
	Pote=Pote*N;
	}
	System.out.println("");
	System.out.println(N + " elevado a"+p+":"+Pote);
	scan.close();
	}
}
