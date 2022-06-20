
import presentation.Model;


public class TicTacToe {

    private Model program;
    
    public TicTacToe(){
        program = new Model();
        program.starts();
    }
    
    public static void main(String[] args) {
        new TicTacToe();
    }
    
}
