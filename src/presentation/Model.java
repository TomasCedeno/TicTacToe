
package presentation;

import Logic.Client;
import Logic.Server;
import java.awt.Graphics;
import logic.Game;
import java.awt.Color;
import java.awt.Font;
import logic.SocketConnection;

public class Model implements Runnable{
    
    private Game ourGame;
    private View window;
    private StartGameView startWindow;
    private Graphics pencil;
    private final Thread process;
    private int colorCounter;
    private boolean active;
    private SocketConnection socket;
    private boolean myTurn;
    
    public Model(){
        startWindow = new StartGameView(this);
        window = new View(this);
        ourGame = new Game();
        process = new Thread(this);
        colorCounter = 0;
        active = true;
    }
    
    public void starts() {        
        startWindow.setVisible(true);
        startWindow.setLocationRelativeTo(null); 
                
    }
    
    public void startBoard(String mode){
        try {
            if(mode.equals("create")){
                socket = new Server(); 
                myTurn = true;
            } else {
                socket = new Client(Integer.valueOf(startWindow.getTxtPort().getText()), 
                        startWindow.getTxtIp().getText());
                myTurn = false;
            }
            
            startWindow.dispose();
            window.setSize(500, 580);
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            //board();
            process.start();
            new Thread(new UpdateBoard()).start();
            
        } catch (Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    public void finish(){
        process.stop(); 
        System.exit(0);
    } 
    
    public void paintXO(int i) {
        pencil = window.getOurCanvas()[i].getGraphics();
        pencil.setFont(new Font("CooperBlack", Font.BOLD, 180));
        pencil.drawString(ourGame.pressed(i), 10, 140);
        window.getLblMessage().setText("Turno de "+ ((ourGame.getTurn() == 0)?"X":"O"));
    }
    
    public void gameOver(){
        switch(ourGame.win()){
            case 0:
                paintWinner(0); paintWinner(1); paintWinner(2); break;
            case 1:
                paintWinner(3); paintWinner(4); paintWinner(5); break;
            case 2:
                paintWinner(6); paintWinner(7); paintWinner(8); break;
            case 3:
                paintWinner(0); paintWinner(3); paintWinner(6); break;
            case 4:
                paintWinner(1); paintWinner(4); paintWinner(7); break;
            case 5:
                paintWinner(2); paintWinner(5); paintWinner(8); break;
            case 6:
                paintWinner(0); paintWinner(4); paintWinner(8); break;
            case 7:
                paintWinner(2); paintWinner(4); paintWinner(6); break;             
            default: break;
        }
    }
    
    public void paintWinner(int i){
        pencil = window.getOurCanvas()[i].getGraphics();
        pencil.setFont(new Font("CooperBlack", Font.BOLD, 180));
        pencil.setColor(Color.green);
        pencil.drawString(ourGame.getWinner(), 10, 140);
        window.getLblMessage().setText("Ganador: " + ourGame.getWinner());
    }
    
    public void animatePanel() {
        Color colors[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.LIGHT_GRAY};
        if(colorCounter == 9) colorCounter = 0;
        Color color = colors[colorCounter++];
        window.getPanel().setBackground(color);
        window.getLblMessage().setForeground(color);
    }
    
    @Override
    public void run(){
        try{
            while(active){
                animatePanel();
                Thread.sleep(1700);
            }    
        }catch(Exception e){
        }
                
    }
    
    
    public void animateCanvas() {              
        for (int k=0; k<4; k++){
            int i = ourGame.selectCanvas();

            window.getOurCanvas()[i].setBackground(Color.BLACK);
        }
        
        ourGame.resetAccount();
    }
    
    
    public void board(){             
        String load = "";
        
        pencil = window.getOurCanvas()[4].getGraphics();
        pencil.setFont(new Font("CooperBlack", Font.BOLD, 20));
        
        for(int i=0; i<4; i++){
            
            animateCanvas();
            
            switch(i){
                case 0: load = "I";break;
                case 1: load = "I-NI";break;
                case 2: load = "I-NI-CIAN";break;
                case 3: load = "I-NI-CIAN-DO";break;
                default: break;
            }
            
            pencil.drawString(load, 10, 80);  
            
            try{
                Thread.sleep(1000);
            } catch (Exception e){
            }
            resetCanvas(false);
        }  
        window.getOurCanvas()[4].repaint();
        window.getLblMessage().setText("Turno de X");
    }
    
    public void resetCanvas(boolean clear){
        for(int i=0; i<9; i++){
            if(!clear){
                window.getOurCanvas()[i].setBackground(Color.WHITE);
            }else{
                window.getOurCanvas()[i].repaint();
            }   
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }
     
    public Game getOurGame() {
        return ourGame;
    }
    
    public View getWindow() {
        return window;
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    public SocketConnection getSocket() {
        return socket;
    }
    
    private class UpdateBoard implements Runnable{
        @Override
        public void run() {
            while(true){
                if (!myTurn){
                    int move = socket.getMove();
                    paintXO(move);
                    myTurn = true;
                }
                
                gameOver();
                if(ourGame.tie()){
                    window.getLblMessage().setText("Empate");
                }
            }  
        }
    }
    
}
