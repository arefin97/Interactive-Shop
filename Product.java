import java.util.ArrayList;
import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

//import jdk.internal.util.xml.impl.Input;

class Product {

  private static int balance = 0;
  private static int total_profit = 0;

  private static boolean isValidInput(boolean whileCondition) {
    try {
      return whileCondition;
    } catch (Exception e) {
      return false;
    }

  }

  private static void viewProducts(ArrayList<Product> product) {

    if(!product.isEmpty()){
      for (Product ppp : product) {
      System.out.println("Product Name"+ "   " + "Product Buy Price"+ "   " + "Product Sell Price"+ "   " + "Product Quantity"+ "    " + "Profit");
      System.out.println(ppp.name + "                   " + ppp.b_price + "                    " + ppp.s_price + "                    " + ppp.count + "             " + ppp.profit);
    }
  }
  else{
    System.out.println("No Products Available.");
  }
  }

  private static void sellProduct(ArrayList<Product> product) {
    int i;
    int f = 0;

    if(!product.isEmpty()){
      System.out.println("Here is the available Products List:");
      System.out.println("Product Name"+ "   " + "Product Buy Price"+ "   " + "Product Sell Price"+ "   " + "Product Quantity"+ "    " + "Profit");
      for (Product ppp : product) {
        System.out.println(ppp.name + "                   " + ppp.b_price + "                    " + ppp.s_price + "                " + ppp.count + "                 " + ppp.profit);
    }
  }
  
    Scanner kb = new Scanner(System.in);
    System.out.println("Plz Enter the Product's name you want to sell:");
    String input = kb.nextLine();
    for (i = 0; i < product.size(); i++) {
      if (input.equalsIgnoreCase(product.get(i).name)) {
        f = 1;
        System.out.println("Enter amount:");
        int t = kb.nextInt();
        while(t>product.get(i).count||t<0){
        System.out.println("Not available that many! Enter another valid Quantity.");
        t = kb.nextInt();
        }
        product.get(i).count -= t;
        total_profit = product.get(i).profit*t;
        balance += (t * product.get(i).s_price);
        break;
      }
    }
    if(f==0){
      System.out.println("Please Select a Valid Product.");
    }

  }

  private static void buyProduct(ArrayList<Product> product) {
    int i;
    int f = 0;
    Scanner kb = new Scanner(System.in);
    System.out.println("Plz Enter the Product's name:");
    String input = kb.nextLine();
    for (i = 0; i < product.size(); i++) {
      if (input.equalsIgnoreCase(product.get(i).name)) {
        f = 1;
        System.out.println("Plz Enter the Product's Quantity:");
        product.get(i).count+= kb.nextInt();
        balance -= (product.get(i).count * product.get(i).b_price);
        break;
      }
    }
    if (f == 0) {
      Product pp = new Product();
      pp.name = input;
      System.out.println("Plz Enter the Product's Buy Price::");
      pp.b_price = kb.nextInt();
      System.out.println("Plz Enter the Product's Sell Price:");
      pp.s_price = kb.nextInt();
      System.out.println("Plz Enter the Product's Quantity:");
      pp.count = kb.nextInt();
      pp.profit = pp.s_price - pp.b_price;
      balance -= pp.count * pp.b_price;
      product.add(pp);
    }
    // int tt=product.indexOf(input);
    // System.out.println("tt "+tt);
    // pp.name=input;

  }

  private static void deleteProducts(ArrayList<Product> product) {
    int i;
    Scanner kb = new Scanner(System.in);
    System.out.println("Plz Enter the Product's name:");
    String input = kb.nextLine();
    if(!product.isEmpty()){
    for (i = 0; i < product.size(); i++) {
      if (input.equalsIgnoreCase(product.get(i).name)) {
        product.remove(product.get(i));
      }
    }
  }
  else{
    System.out.println("Product not Found");
  }
}

  private String name;
  private int b_price;
  private int s_price;
  private int count;
  private int profit;

  private static void addProduct(Product pp, ArrayList<Product> product) {

    // Product pp=new Product();

    int i;
    int f = 0;
    Scanner kb = new Scanner(System.in);
    System.out.println("Plz Enter the Product's name:");
    String input = kb.nextLine();
    for (i = 0; i < product.size(); i++) {
      if (input.equalsIgnoreCase(product.get(i).name)) {
        System.out.println("This Product is already exist!");
        f = 1;
        ;
      }
    }
    if (f == 1) {
      return;
    }
    pp.name = input;
    System.out.println("Plz Enter the Product's Buy Price::");
    pp.b_price = kb.nextInt();
    System.out.println("Plz Enter the Product's Sell Price:");
    pp.s_price = kb.nextInt();
    System.out.println("Plz Enter the Product's Quantity:");
    pp.count = kb.nextInt();
    pp.profit = pp.s_price - pp.b_price;
    product.add(pp);
   
  }

  public static void main(String[] args) {

    ArrayList<Product> product = new ArrayList<>();
    while (true) {
      System.out.println("");
      System.out.println("What would you like to do?");
      System.out.println("(1) Add Product");
      System.out.println("(2) Buy Product");
      System.out.println("(3) Sell Product");
      System.out.println("(4) View Available Products");
      System.out.println("(5) Delete Products");
      System.out.println("(6) Check Balance and Profit");
      System.out.println("(0) Quit");

      Scanner kb = new Scanner(System.in);
      String input = kb.nextLine();
      while (isValidInput(
          !"1".equals(input) && !"2".equals(input) && !"3".equals(input) && !"4".equals(input) && !"0".equals(input) && !"5".equals(input) && !"6".equals(input))) {
        System.err.println("Please enter 1, 2 ,3,4,5,6 or '0' only");
        input = kb.nextLine();
      }
      switch (input) {
      case "1":
        Product cc1 = new Product();
        addProduct(cc1, product);
        /*
         * Product cc2 = new Product();
         * Product cc3 = new Product(); 
         * Product cc4 = new Product();
         *  Product cc5 = new Product();
         * 
         * addProduct(cc2,product);
         * addProduct(cc3,product);
         * addProduct(cc4,product);
         * addProduct(cc5,product);
         */
        break;
      case "2":
        buyProduct(product);
        break;
      case "3":
        sellProduct(product);
        break;
      case "4":
        viewProducts(product);
        break;
      case "5":
        deleteProducts(product);
        break;
      case "6":
        System.out.println("Available balance:");
        System.out.println(balance);
        System.out.println("Total profit:");
        System.out.println(total_profit);
        break;
      case "0":
        System.out.println("Thank you");
        System.exit(0);
        break;
      }
    }
  }

}