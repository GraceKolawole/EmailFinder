import controller.EmailContentCheckerOGK;
import controller.FileContentCheckerOGK;
import view.FileContentCheckerGUIOGK;

public class Main {
    public static void main(String[] args) {
        new FileContentCheckerGUIOGK(new FileContentCheckerOGK(new EmailContentCheckerOGK()));
    }
}