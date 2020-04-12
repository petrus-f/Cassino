package view;

import controller.ThreadDados;

public class Principal {
	
	public static void main(String[] args) {
		
		
		for(int i = 0; i < 10; i++) {
			Thread t = new ThreadDados(i+1);
			t.start();
		}
	}
}
