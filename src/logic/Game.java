
package logic;

public class Game {
    
    private int turn;
    private char[] matrix;
    private int[][] win;
    private boolean finish;
    private String winner;
    private int[] account;
    
    public Game(){
        matrix = new char[9];
        for(int i=0;i<9;i++){
            matrix[i] = '#';
        }
        
        turn = 0;
        
        int[][] _win = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        win = _win;
        
        finish = false;
        winner = "#";
        
        int[] _account = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        account = _account;
    }
    
    public String pressed(int pos){
        if(matrix[pos] == '#' && !finish){
            if(turn == 0){
                matrix[pos] = 'X';
                turn = 1;
                return "X";
            }else{
                matrix[pos] = 'O';
                turn = 0;
                return "O";
            }
        }
        
        return "";
    }
    
    public int win(){
        for(int i=0;i<win.length;i++){
            if(matrix[win[i][0]] == 'X' && matrix[win[i][1]] == 'X' && matrix[win[i][2]] == 'X'){
                finish = true;
                winner = "X";
                return i;
            }
        }
        
        for(int i=0;i<win.length;i++){
            if(matrix[win[i][0]] == 'O' && matrix[win[i][1]] == 'O' && matrix[win[i][2]] == 'O'){
                finish = true;
                winner = "O";
                return i;
            }
        }
        
        return 10;
    }
    
    public boolean tie(){        
        for(int i=0;i<9;i++){
            if(matrix[i] == '#'){
                return false;
            }
        }
        
        return true;
    }
    
    public int selectCanvas(){
        int randomNum;
        
        while(true){
            randomNum = (int)(Math.random() * (8));
            if(account[randomNum] != 4){
                account[randomNum] = 4;
                break;
            }
        }
        
        return randomNum;
    }
    
    public void resetAccount(){
        int[] _account = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        account = _account;
    }
    
    public void resetMatriz(){
        for(int i=0;i<9;i++){
            matrix[i] = '#';
        }
        finish = false;
        winner = "#";
    }
    
    public String getWinner() {
        return winner;
    }

    public int getTurn() {
        return turn;
    }
}
