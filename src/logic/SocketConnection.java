package logic;


public interface SocketConnection{
    
    /*
        Protocolo:
        Se envia y recibe una cadena compuesta por la jugada y el estado/opcion del juego
        separados por dos puntos --> "jugada:estado"
    */
    
    public void sendInfo(String info);
    
    public String[] getInfo();
    
    public void close();
}
