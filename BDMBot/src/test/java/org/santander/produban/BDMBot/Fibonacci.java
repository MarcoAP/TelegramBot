package org.santander.produban.BDMBot;

public class Fibonacci {

	public static void main(String[] args) {
		double soma = 0;
		for (double aux1 = 1, aux2 = 1, count = 1; count <= 100; count++) {
			aux2 += aux1;
			aux1 = aux2 - aux1;
			soma += aux1;
			System.out.println((int)count + ") " + String.format("%.0f", aux1));
		}
		System.out.println(String.format("\nTotal: %.0f\n", soma));
	}

}
