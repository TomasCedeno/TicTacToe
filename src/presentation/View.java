package presentation;

import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class View extends javax.swing.JFrame {
    
    private Model ourModel;
    private Controller ourController;
    private Canvas[] ourCanvas = new Canvas[9];

    public View(Model m) {
        ourModel = m;
        ourController = new Controller(this);
        initComponents();
        ourCanvas[0] = canvas1;
        ourCanvas[1] = canvas2;
        ourCanvas[2] = canvas3;
        ourCanvas[3] = canvas4;
        ourCanvas[4] = canvas5;
        ourCanvas[5] = canvas6;
        ourCanvas[6] = canvas7;
        ourCanvas[7] = canvas8;
        ourCanvas[8] = canvas9;        
        catchEvents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgain = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        canvas2 = new java.awt.Canvas();
        canvas3 = new java.awt.Canvas();
        canvas4 = new java.awt.Canvas();
        canvas5 = new java.awt.Canvas();
        canvas6 = new java.awt.Canvas();
        canvas7 = new java.awt.Canvas();
        canvas8 = new java.awt.Canvas();
        canvas9 = new java.awt.Canvas();
        btnEnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnAgain.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnAgain.setText("Volver a jugar");

        lblMessage.setBackground(new java.awt.Color(255, 255, 255));
        lblMessage.setFont(new java.awt.Font("Cooper Black", 1, 36)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(0, 255, 51));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        canvas1.setBackground(new java.awt.Color(255, 255, 255));

        canvas2.setBackground(new java.awt.Color(255, 255, 255));

        canvas3.setBackground(new java.awt.Color(255, 255, 255));

        canvas4.setBackground(new java.awt.Color(255, 255, 255));

        canvas5.setBackground(new java.awt.Color(255, 255, 255));

        canvas6.setBackground(new java.awt.Color(255, 255, 255));

        canvas7.setBackground(new java.awt.Color(255, 255, 255));

        canvas8.setBackground(new java.awt.Color(255, 255, 255));

        canvas9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(canvas7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(canvas8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(canvas9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEnd.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnEnd.setText("Terminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgain)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnEnd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgain)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnd)))
                .addGap(0, 75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean ask(String message){
        return 0 == JOptionPane.showConfirmDialog(this, message, "", JOptionPane.YES_NO_OPTION);
    }
    
    public void report(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public Model getOurModel() {
        return ourModel;
    }

    public Controller getOurController() {        
        return ourController;
    }

    public Canvas[] getOurCanvas() {
        return ourCanvas;
    }

    public JPanel getPanel() {
        return panel;
    }    

    public JLabel getLblMessage() {
        return lblMessage;
    }

    public JButton getBtnAgain() {
        return btnAgain;
    }

    public JButton getBtnEnd() {
        return btnEnd;
    }
    
    public void catchEvents() {
        for(int i=0; i<9 ; i++){
            ourCanvas[i].addMouseListener(ourController);
        }
        
        btnAgain.addActionListener(ourController);
        btnEnd.addActionListener(ourController);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgain;
    private javax.swing.JButton btnEnd;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private java.awt.Canvas canvas3;
    private java.awt.Canvas canvas4;
    private java.awt.Canvas canvas5;
    private java.awt.Canvas canvas6;
    private java.awt.Canvas canvas7;
    private java.awt.Canvas canvas8;
    private java.awt.Canvas canvas9;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
