package refactoring.basic;

import java.util.Scanner;

public class AreaParalelogramo 
{
	//Programa "AreaParalelogramo"
	//Calcula a �rea de um paralelogramo.
	//--------------------------------------------------
public static void main(String args)
{
	float B, h, Area;
	Scanner scan = new Scanner(System.in);
	System.out.print("Digite o valor da base: ");
	B=scan.nextFloat();
	B = Math.abs(B ); //garante base positiva
	System.out.print("Digite o valor da altura: ");
	h=scan.nextFloat();
	h=Math.abs(h ); //garante altura positiva
	Area=B*h; //f�rmula da �rea do paralelogramo
	System.out.println("");//pula linha
	System.out.println("�rea do paralelogramo:"+ Area);
	scan.close();
}
}
