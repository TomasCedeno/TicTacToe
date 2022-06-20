
package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener, ActionListener{
    
    private final View window;

    public Controller(View w) {
        window = w;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(window.getOurModel().isMyTurn()){
            for(int i=0;i<9;i++){
                if(e.getSource() == window.getOurCanvas()[i]){
                    window.getOurModel().paintXO(i);
                    window.getOurModel().getSocket().sendMove(i);
                    window.getOurModel().setMyTurn(false);
                    break;
                }
            }  
        }
        
        window.getOurModel().gameOver();
        if(window.getOurModel().getOurGame().tie() && window.getOurModel().getOurGame().getWinner().equals("#")){
            window.getLblMessage().setText("Empate");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == window.getBtnAgain()){
            window.getOurModel().resetCanvas(true);
            window.getOurModel().getOurGame().resetMatriz();
            window.getLblMessage().setText("Turno de "+ ((window.getOurModel().getOurGame().getTurn() == 0)?"X":"O"));
            
        }else if (e.getSource() == window.getBtnEnd()){
            window.getOurModel().setActive(false);
            window.getOurModel().finish();
        }  
    }
}
