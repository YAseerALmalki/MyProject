
import java.util.Scanner;

public class StoreHouseTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("_-_-_-_-_-_-_-_The Main Menu_-_-_-_-_-_-_-_");
            System.out.println(
                    "1_ Add Product                             |\n2_ Update Product                          |\n3_ Delete Product                          |\n4_ Show all products                       |\n5_ Exit                                    |\n___________________________________________\nchoose number: ");


            int chooseNum = scanner.nextInt();
            switch (chooseNum) {

                case 1:
                    Product.addProduct(scanner);
                    break;

                case 2:
                    Product.updateProducts(scanner);
                    break;

                case 3:
                    Product.deleteProducts(scanner);
                    break;

                case 4:
                    Product.showAllProducts();
                    break;

                case 5:
                    exist();
                    break;
            }
        }
    }

    public static void exist() {
        System.exit(0);
    }
}
