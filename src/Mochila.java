import java.util.ArrayList;

public class Mochila {
	  private  ArrayList<Item> Itens = new ArrayList<Item>();
	  private float size;
	  
	  public Mochila(float size) {
		  this.size = size;
	  }
	  
	  public ArrayList<Item> Listar(){
		  return this.Itens;
	  }
	  
	  public Boolean In(Item i){
		  if(this.Cabe(i)) {
			  this.Itens.add(i);
			  return true;
		  }
		  return false;
	  }
	  
	  public Boolean Out(Item i){
		  int id = 0;
		  for (Item Item: Itens) {
			    if(i.getName() == Item.getName()){
			    	this.Itens.remove(id);
			    	return true;
			    }
			    id++;
		  }
		  return false;
	  }
	  
	  private Boolean Cabe(Item i){
		  float tPeso = i.getPeso();
		  for (Item Item: this.Itens) {
			    tPeso = tPeso + Item.getPeso();
		  }
		  return tPeso <= this.size;
	  }
}
