public class Main {
    public static void main(String[] args) {

        TextUI runner = new TextUI();
        try {
            runner.welcome();
        } catch (Exception e) {
            System.out.println("\n* An Error occurred.");
        }

        runner.goodbye();
    }
}
