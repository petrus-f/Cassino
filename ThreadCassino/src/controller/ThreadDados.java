package controller;

public class ThreadDados extends Thread {
	int dado1, dado2, soma, ponto, jogador;
	static boolean fimDeJogo;
	static int colocacao;
	static double valor = 5000.00;

	public ThreadDados(int i) {
		this.jogador = i;
	}

	@Override
	public void run() {
		do {
			jogarDado();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			verificarPonto();
			verificarColocacao();
		} while (!fimDeJogo && ponto != 5);
		
	}

	private void verificarColocacao() {
		if (ponto == 5) {
			colocacao++;
			if (colocacao == 3) {
				fimDeJogo = true;
			}
			if (colocacao <= 3) {
				System.out.println("Jogador " + jogador + " ficou em " + colocacao + " º. colocado e recebeu "+ valor);
				valor -= 1000.00;
			}
		}
	}

	private void verificarPonto() {
		if (soma == 7 || soma == 11) {
			ponto++;
			System.out.println("Jogador " + jogador + " fez " + ponto + " pontos");
		}
	}

	private void jogarDado() {
		dado1 = (int) (Math.random() * 6) + 1;
		dado2 = (int) (Math.random() * 6) + 1;
		soma = dado1 + dado2;
	}

}
