
import java.util.ArrayList;
import java.util.Scanner;

public class Product {

    static ArrayList<Product> productsList = new ArrayList();

    private String name;
    private double price;
    private String type;

    Product() {
    }

    public Product(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    
    
    
    //-------------------هذا الكود لإضافة منتج-------------------
    public static void addProduct(Scanner scanner) {
        System.out.println("Add the number of products: ");
        int countProduct = scanner.nextInt();
        if (countProduct < 0) {
            System.out.println("Not Valid");
        } else {
            for (int i = 0; i < countProduct ; i++) {
                System.out.println("Enter product name No.(" + (i + 1) + ")");
                String nameProduct = scanner.next();
                System.out.println("Enter the product type No.(" + (i + 1) + ")");
                String typeProduct = scanner.next();
                System.out.println("Enter the price of product No.(" + (i + 1) + ")");
                double priceProduct = scanner.nextDouble();

                
                Product p = new Product();
                p.setName(nameProduct);
                p.setType(typeProduct);
                p.setPrice(priceProduct);

                Product.productsList.add(p);
            }
            System.out.println("\nAdd successfuly");
        }
    }

    
   
    
    
    
    
    
    //-------------------هذا الكود يعمل على تحديث المنتج-------------------
    public static Product getProductByName(String name) {

        for (Product product : productsList) {
            if (product.name.equals(name)) {
                return product;
            }
        }
        return null;
    }
    static void updateProducts(Scanner scanner) {
        boolean TheList = true;
        while (TheList) {
            System.out.println("_-_-_-_-_-_-_-_Update Menu_-_-_-_-_-_-_-_\n1- Update product name                   |\n2- Update product type                   |\n3- update Product price                  |\n4- Back To Main Menu                     |\n5- Exit                                  |");
            System.out.println("\nChoose number: ");

            int chooseNum = scanner.nextInt();
            switch (chooseNum) {
                case 1:
                    System.out.println("Enter the product name: ");
                    String productName = scanner.next();
                    Product firstProduct = Product.getProductByName(productName);
                    Product newProduct = Product.getProductByName(productName);
                    if (firstProduct == null) {
                        System.out.println("**There is no product with this name**");
                    } else {
                        System.out.println("Enter the name of the new product : ");
                        String newName = scanner.next();

                        newProduct.setName(newName);
                        if (Product.updateProduct(newProduct, firstProduct)) {
                            System.out.println("updated successfluty");
                        } else {
                            System.out.println("updated failed");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter the product name: ");
                    String productName1 = scanner.next();
                    Product firstProduct1 = Product.getProductByName(productName1);
                    Product newProduct1 = Product.getProductByName(productName1);
                    if (firstProduct1 == null) {
                        System.out.println("**There is no product with this name**");
                    } else {
                        System.out.println("Enter the new product type: ");
                        String newType = scanner.next();

                        newProduct1.setType(newType);
                        if (Product.updateProduct(newProduct1, firstProduct1)) {
                            System.out.println("updated successfuly");
                        } else {
                            System.out.println("updated failed");
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("Enter the product name: ");
                    String productName2 = scanner.next();
                    Product firstProduct2 = Product.getProductByName(productName2);
                    Product newProduct2 = Product.getProductByName(productName2);
                    if (firstProduct2 == null) {
                        System.out.println("**There is no product with this name**");
                    } else {
                        System.out.println("Enter the new product price: ");
                        Double newPrice = scanner.nextDouble();

                        newProduct2.setPrice(newPrice);
                        if (Product.updateProduct(newProduct2, firstProduct2)) {
                            System.out.println("updated successfuly");
                        } else {
                            System.out.println("updated failed");
                        }
                    }
                    break;

                case 4:
                    TheList = false;
                    break;

                case 5:
                    StoreHouseTest.exist();
                    break;

            }
        }
    }
    public static boolean updateProduct(Product newProduct, Product firstProduct) {
        if (productsList.size() >= 0) {
            int index = -1;
            for (int i = 0; i < productsList.size(); i++) {
               if (productsList.get(i).getName().equals(firstProduct.getName())) {
                   index = i;
                    break;
                }
            }
            if (index != -1) {
                productsList.get(index).setName(newProduct.getName());
                productsList.get(index).setType(newProduct.getType());
                productsList.get(index).setPrice(newProduct.getPrice());

                return true;
            }
        }
        return false;
    }

    
   
    
    
    
    //-------------------هذا الكود يقوم بحذف المنتج-------------------
    static boolean deleteProduct(Product product) {
        if (!productsList.isEmpty()) {
            productsList.remove(product);
            return true;
        }
        return false;
    }

    static void deleteProducts(Scanner scanner) {
        System.out.println("Enter the product name: ");
        String productName = scanner.next();
        Product product = Product.getProductByName(productName);
        if (product == null) {
            System.out.println("**There is no product with this name**");
        } else {
            //delete
            if (Product.deleteProduct(product)) {
                System.out.println("deleted successfuly");
            } else {
                System.out.println("deleted failed");

            }
        }
    }
    
    
    
    
    
    
    
    //-------------------هذا الكود لمشاهدة جميع المنتجات-------------------
    public static void showAllProducts() {
        ArrayList<Product> listProduct = Product.productsList;
        if (listProduct.isEmpty()) {
            System.out.println("**There are no products**");
        } else {
            for (Product product : listProduct) {
                System.out.println("___________________________");
                System.out.println("Name Product: " + product.getName() + "\nType: " + product.getType() + "\nPrice: " + product.getPrice());
                System.out.println("___________________________");
            }
        }
    }
}
