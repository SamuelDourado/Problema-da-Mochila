import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Item> allItens = new ArrayList<Item>();
		Boolean stop = false;
		
		Scanner entrada = new Scanner(System.in);
		while(!stop) {
			System.out.println("Adicionar Item:");
			
			System.out.print("Nome:");
			String nome = entrada.next();
			
			System.out.print("Valor:");
			float value = entrada.nextFloat();
			
			System.out.print("Peso:");
			float peso = entrada.nextFloat();
			
			allItens.add( new Item(nome, value, peso) );
			stop = entrada.nextBoolean();
			System.out.println("___");
		}
		//entrada.close();

		Main res = new Main();
		Mochila mochila = res.Guloso(allItens);
		System.out.println("guloso");
		res.printMochila(mochila);
	}
	
	public Item maxItem(ArrayList<Item> Itens) {
		Item maxItem = null;
		for (Item Item: Itens) {
			if(maxItem == null || (!Item.adicionado && Item.getValue() > maxItem.getValue())){
				maxItem = Item;
			}
		}
		return maxItem;
	}
	
	public Mochila Guloso(ArrayList<Item> allItens){
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe o tamanho da mochila:");
		float size = entrada.nextFloat();
		Mochila mochila = new Mochila(size);
		
		for (Item Item: allItens) {
			Item maxItem = this.maxItem(allItens);
			mochila.In(maxItem);
			maxItem.adicionado = true;
			//allItens.remove(maxItem);
		}
		
		return mochila;
	}
	
	public void printMochila(Mochila mochila) {
		for (Item Item: mochila.Listar()) {
			System.out.println(Item.getName());
		}
	}

}
