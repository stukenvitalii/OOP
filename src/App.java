import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Product fanta = new Product("Fanta", 3, 9);
        Product pepsi = new Product("Pepsi", 25, 10);
        Product pepperoni = new Product("Pepperoni", 200, 10);
        Product margarita = new Product("Margarita", 150, 9);
        System.out.println(fanta.getName());

        ArrayList<Product> drinks = new ArrayList<Product>();
        drinks.add(fanta);
        drinks.add(pepsi);

        ArrayList<Product> pizzas = new ArrayList<Product>();
        pizzas.add(pepperoni);
        pizzas.add(margarita);

        Category drink = new Category("drink", drinks);
        Category pizza = new Category("Pepperoni", pizzas);

        drink.getListOfProducts();
        pizza.getListOfProducts();

        Basket adminBasket = new Basket(pizzas);

        User admin = new User("admin", "admin1234", adminBasket);
        System.out.println(admin);
    }
}

class Product {
    public String _name;
    private int _cost;
    private int _rating;

    public Product(String name, int cost, int rating) {
        this._name = name;
        this._cost = cost;
        this._rating = rating;
    }

    public String getName() {
        return this._name;
    }

    public int getCost() {
        return this._cost;
    }

    public int getRating() {
        return this._rating;
    }

}

class Category {
    private String _name;
    private ArrayList<Product> _products = new ArrayList<Product>();

    public Category(String name, ArrayList<Product> products) {
        this._name = name;
        this._products = products;
    }

    public String getName() {
        return this._name;
    }

    public void getListOfProducts() {
        System.out.printf("%s {\n", this._name);
        for (int i = 0; i < _products.size(); i++) {
            System.out.printf("    Name: %s, Cost: %d, Rating: %d;\n", _products.get(i).getName(),
                    _products.get(i).getCost(), _products.get(i).getRating());
        }
        System.out.printf("}\n");

    }

    public ArrayList<Product> addProductToCategory(Product product) {
        _products.add(product);
        return _products;
    }
}

class Basket {
    private ArrayList<Product> _boughtProducts = new ArrayList<>();

    public Basket(ArrayList<Product> boughtProducts) {
        this._boughtProducts = boughtProducts;
    }

    public void getListOfProducts() {
        System.out.printf("Купленные продукты: {\n");
        for (int i = 0; i < _boughtProducts.size(); i++) {
            System.out.printf("    Name: %s, Cost: %d, Rating: %d;\n", _boughtProducts.get(i).getName(),
                    _boughtProducts.get(i).getCost(), _boughtProducts.get(i).getRating());
        }
        System.out.printf("}\n");
    }

    public ArrayList<Product> addProductToList(Product product) {
        _boughtProducts.add(product);
        return _boughtProducts;
    }

}

class User {
    private String _login;
    private String _password;
    private Basket _shopingList;

    public User(String login, String password, Basket shoppingList) {
        this._login = login;
        this._password = password;
        this._shopingList = shoppingList;
    }

}