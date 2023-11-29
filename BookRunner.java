public class BookRunner {
		public static void main(String[] args) {
			Book taocp = new Book();
			taocp.setTitle("The Art Of Computer Programming");
			Book ej = new Book();
			ej.setTitle("Effective Java");
			Book cc = new Book();
			cc.setTitle("Clean Code");
			System.out.println(taocp.getTitle());
			System.out.println(ej.getTitle());
			System.out.println(cc.getTitle());
		}
	}
