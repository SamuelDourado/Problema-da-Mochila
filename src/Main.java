import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Carregador carregador = new Carregador();
		carregador.LerItens();
		Mochila m1 = carregador.Guloso();
		carregador.printMochila(m1);
		
		System.out.println("***** \n Dinâmico");
		int s = (int) m1.getSize();
		int i = m1.Listar().size();
		System.out.println(s + " " + i);
		float[][] res = null;
		res = new float[i][s+1];
		System.out.println(res[0][0]);
		int i1 = 0, i2 =0;
		while(i-1 >= i1) {
			//System.out.print("i = " + i1);
			while(s >= i2) {
				res[i1][i2] = Dinamico2(i1,i2,res,m1.Listar());
				System.out.println(i1 + " " + i2 + " = " + res[i1][i2]);
				i2++;
			}
			i1++;
			i2=0;
		}
	}
	
	public static float Dinamico2(int i, int s,float[][] res, ArrayList<Item> allItens) {
		System.out.println("start");
		if(s <= 0) {
			System.out.print(" A " );
			return 0;
		}
		Item novoItem = allItens.get(i);
		
		if((int)novoItem.getPeso() > s) {
			System.out.print( novoItem.getPeso() + " B " + s + " ");
			if(i == 0)
				return 0;
			return res[i-1][s];
		}else if (i ==0) {
			return novoItem.getValue();
		}
		
		float novo = (novoItem.getValue() + res[i][(int) (s - novoItem.getPeso())]);
		float old = res[i-1][s]; 
		if(novo > old) {
			System.out.print(" C ");
			return novo;
		}
		System.out.print(" D ");
		return old;
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
