public class Main {
    public static void main(String[] args) {
        Lyrra card = new Lyrra(10);
        System.out.println(card);

        card.load_money(15);
        System.out.println(card);

        card.load_money(10);
        System.out.println(card);

        card.load_money(200);
        System.out.println(card);

    }
}
