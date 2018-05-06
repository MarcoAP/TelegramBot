package org.santander.produban.BDMBot.Tests;

public class FlagTests {

	public static void mainX(String[] args) {

		StringBuffer sb = new StringBuffer();

		// for (int i = 127465; i < 127967; i++) {
		// for (int j = 127465; j < 127967; j++) {
		// sb = new StringBuffer();
		// sb.append(Character.toChars(i));
		// sb.append(Character.toChars(j));
		// //if (sb.length() == 1) {
		// System.out.print("SIZE: " + sb.length() + " ==== " + i + " + " + j +
		// " ==> ");
		// System.out.println(sb);
		// //}
		// }
		// }

		sb.append(Character.toChars(127466));
		sb.append(Character.toChars(127480));
		System.out.println(sb);

	}

	public static void main(String[] args) {

		System.out.println(new StringBuffer().append(Character.toChars(127463)).append(Character.toChars(127479)));
	}
}
