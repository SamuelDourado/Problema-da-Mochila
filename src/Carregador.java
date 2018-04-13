import java.util.ArrayList;
import java.util.Scanner;

public class Carregador {
	protected ArrayList<Item> allItens = new ArrayList<Item>();
	
	public void LerItens() {
		Boolean stop = false;
		Scanner entrada = new Scanner(System.in);
		while(!stop) {
			System.out.println("* Adicionar Item:");
			
			System.out.print("** Nome:");
			String nome = entrada.next();
			
			System.out.print("** Valor:");
			float value = entrada.nextFloat();
			
			System.out.print("** Peso:");
			float peso = entrada.nextFloat();
			
			allItens.add( new Item(nome, value, peso) );
			System.out.print("** Parar:");
			stop = entrada.nextBoolean();
			System.out.println("*****");
		}
	}
	
	public Mochila Guloso(){
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe o tamanho da mochila:");
		float size = entrada.nextFloat();
		Mochila mochila = new Mochila(size);
		
		for (Item Item: this.allItens) {
			Item maxItem = this.maxItem();
			mochila.In(maxItem);
			maxItem.adicionado = true;
			//allItens.remove(maxItem);
		}
		
		return mochila;
	}
	
	public Item maxItem() {
		Item maxItem = null;
		for (Item Item: this.allItens) {
			if(maxItem == null || (!Item.adicionado && Item.getValue() > maxItem.getValue())){
				maxItem = Item;
			}
		}
		return maxItem;
	}
	
	public void printMochila(Mochila mochila) {
		for (Item Item: mochila.Listar()) {
			System.out.print(Item.getName() + ' ');
		}
		System.out.println();
	}
	
	public float getTotalValorMochila(Mochila mochila) {
		float total = 0;
		for (Item Item: mochila.Listar()) {
			total = Item.getValue() + total;
		}
		return total;
	}
	
	public float getTotalPesoMochila(Mochila mochila) {
		float peso = 0;
		for (Item Item: mochila.Listar()) {
			peso = Item.getPeso() + peso;
		}
		return peso;
	}
	
	public static void imprimirMatriz(float[][] res) {
		for(float[] linha: res) {
			for(float item: linha) {
				System.out.print(" " + item);
			}
			System.out.println();
		}
	}
	
	public ArrayList<Item> getAllItens(){
		return this.allItens;
	}

}

