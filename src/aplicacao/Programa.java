package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezExcecao;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while (true) {
			try {
				/* Limpa a tela */
				UI.clearScreen();
				
				/* Imprime tabuleiro na tela */
				UI.imprimirTabuleiro(partidaXadrez.getPecas());
				
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
				
				PecaXadrez pecaCapturada = PartidaXadrez.executarMovimentoXadrez(origem, destino);
				System.out.println(pecaCapturada);
			}
			catch (XadrezExcecao e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}