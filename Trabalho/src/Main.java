import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Pizza frango=new Pizza(50.00, new Date(), 0.500,"frango", "Frango", "cheddar", "Molho de tomate");
		Pizza calabresa=new Pizza(60.00, new Date(), 0.600,"calabresa", "Calabresa", "queijo", "Molho de tomate");
		Pizza diabetes=new Pizza(65.00, new Date(), 0.500,"diabetes", "brigadeiro", "chocolate", "doce de leite");
		
		Lanches sanduiche=new Lanches(30.00, new Date(), 0.200, "4 queijos", "mortadela", "maionese", "pão com mortadela");
		
		Salgadinho coxinha=new Salgadinho(4.50, new Date(), 0.150, "frango", "farinha", "frita", "coxinha");
		
		ArrayList<Prato> pedidos = new ArrayList();
		
		pedidos.add(sanduiche);
		pedidos.add(frango);
		pedidos.add(coxinha);
		
		Pedido pedido1=new Pedido("Leonardo", pedidos, 100.00);
		pedido1.NF();
		pedidos.clear();
		
		pedidos.add(diabetes);
		pedidos.add(calabresa);
		
		Pedido pedido2=new Pedido("Roberto", pedidos, 150.00);
		pedido2.NF();
		pedidos.clear();
		
		pedidos.add(frango);
		pedidos.add(diabetes);
		
		Pedido pedido3=new Pedido("Joao", pedidos, 200.00);
		pedido3.NF();
		pedidos.clear();
	}

}
