//import com.lirysBoo.Interface.UserInterface;
import Lirys.logic.GameLogic;

public class Main {
    protected static final GameLogic logic = new GameLogic();
//    private static UserInterface UI = new UserInterface();

    public static void main(String[] args) {
//        UI.createUI();
        logic.gameRunning();
    }
}
