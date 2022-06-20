package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartController implements ActionListener{
    
    private final StartGameView window;

    public StartController(StartGameView w) {
        window = w;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {          
        if(e.getSource() == window.getBtnCreate()){
            window.getModel().startBoard("create");
            
        } else if (e.getSource() == window.getBtnJoin()){
            window.getModel().startBoard("join");
        }
    }
}
