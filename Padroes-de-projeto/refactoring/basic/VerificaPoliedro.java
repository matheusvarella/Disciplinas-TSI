package refactoring.basic;

import java.util.Scanner;

public class VerificaPoliedro 
{
	//Pelo Teorema de Euler[2] sobre os poliedros convexos com V vértices, A arestas e F faces,
	//vale a seguinte relação: V - A + F = 2. O programa “VerifPoliedro” verifica qual poliedro 
	//em questão e quantas faces ele possui.
    //Programa "VerifPoliedro"
	//Verifica qual poliedro está sendo considerado e mostra sua quantidade de faces.
	//--------------------------------------------------------------------------------
	public static void main(String args[])
	{
		float V, A, F;
		boolean	Resp; //declara variável lógica (booleana)
		Scanner scan = new Scanner(System.in);
		do{
		System.out.print("Digite o número de vértices do poliedro [4-6-8-12-20]: ");
			V=scan.nextFloat();
		}while(V!=4&&V!=6&&V!=8&&V!=12&&V!=20);
			System.out.println("");
			do {
			System.out.print("Digite o número de arestas do poliedro [6-12-30]: ");
			A=scan.nextFloat();
			}while((A!=6) && (A!=12) && !(A==30));
			System.out.println("");
			//{Analisa os dados de entrada e determina o poliedro}
			Resp=false;
			F=2+A-V;
			if((V==4) && (A==6)){
			System.out.println("Tetraedro:"+ F+" faces");
			System.out.println("Forma face: Triângulo");
			Resp=true;}else {
			if((V==8) && (A==12)){
			System.out.println("Hexaedro:"+F+" faces");
			System.out.println("Forma face: Quadrado");
			Resp=true;}
			if((V==6) && (A==12)){
			System.out.println("Octaedro:"+F+" faces");
			System.out.println("Forma face: Triângulo");
			Resp=true;}
			if((V==20) && (A==30)) {
			System.out.println("Dodecaedro:"+F+" faces");
			System.out.println("Forma face: Pentágono");
			Resp=true;}
			if((V==12) && (A==30)){
			System.out.println("Icosaedro:"+F+" faces");
			System.out.println("Forma face: Triângulo");
			Resp=true;}
			}
			if(Resp==false){
			System.out.println("Os dados não indicam nenhum poliedro regular.");
			}
	}
}
