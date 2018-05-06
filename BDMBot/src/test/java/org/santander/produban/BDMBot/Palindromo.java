package org.santander.produban.BDMBot;

public class Palindromo {

	public boolean isPalindromo(String texto){
		StringBuffer textoNormalizado = new StringBuffer().append(texto);
		if(textoNormalizado.toString().trim().replace(" ", "").
				equalsIgnoreCase(
						textoNormalizado.reverse().toString().trim().replace(" ", ""))){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Palindromo().isPalindromo("ama")); //true
		System.out.println(new Palindromo().isPalindromo("arara")); //true
		System.out.println(new Palindromo().isPalindromo("racificar")); //true
		System.out.println(new Palindromo().isPalindromo("radar")); //true
		System.out.println(new Palindromo().isPalindromo("reviver")); //true
		System.out.println(new Palindromo().isPalindromo("marco")); //false
	}

}
