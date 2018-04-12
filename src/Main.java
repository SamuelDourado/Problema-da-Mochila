import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Carregador carregador = new Carregador();
		carregador.LerItens();
		Mochila m1 = carregador.Guloso();
		carregador.printMochila(m1);
	}
	
	public float Dinamico(int i, int s,float[][] res, ArrayList<Item> allItens) {
		if(i == 0 || s == 0) {
			return 0;
		}
		Item novoItem = allItens.get(i+1);
		float novo = (novoItem.getValue() + this.Dinamico(i, (int) (s - novoItem.getPeso()) , res, allItens));
		float old = this.Dinamico(i-1, s, res, allItens);
		if(novo > old) {
			return novo;
		}
		return old;
	}

}
