/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import com.mycompany.practica.Aeropuerto;
import com.mycompany.practica.Avion;

/**
 *
 * @author elia3
 */
public class ventana2 extends javax.swing.JFrame {

    /**
     * Creates new form ventana2
     */
    Aeropuerto aeroM;
    Aeropuerto aeroB;
    public ventana2() {
        initComponents();
        Avion av;
        aeroM = new Aeropuerto(jTextHangarM, jTextAreaEstcM);
        aeroB = new Aeropuerto(jTextHangarB, jTextAreaEstcB);
        for (int i=1; i<=100; i++)
        {
            if (esPar(i)){
                av=new Avion(i,aeroM);
                av.start();
            }else{
                av=new Avion(i,aeroB);
                av.start();
            }
            
        }
    }
    
    private boolean esPar(int num){
        return (num%2 == 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextHangarM = new javax.swing.JTextField();
        LabelHangarM = new javax.swing.JLabel();
        LabelAEM = new javax.swing.JLabel();
        jTextAreaEstcM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextHangarB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextAreaEstcB = new javax.swing.JTextField();
        LabelTCM = new javax.swing.JLabel();
        LabelTallerM = new javax.swing.JLabel();
        LabelPasajerosM = new javax.swing.JLabel();
        LabelTAM = new javax.swing.JLabel();
        LabelARM = new javax.swing.JLabel();
        LabelPE1M = new javax.swing.JLabel();
        LabelPE2M = new javax.swing.JLabel();
        LabelPE3M = new javax.swing.JLabel();
        LabelPE4M = new javax.swing.JLabel();
        LabelPE6M = new javax.swing.JLabel();
        LabelPE5M = new javax.swing.JLabel();
        LabelP1M = new javax.swing.JLabel();
        LAbelP2M = new javax.swing.JLabel();
        LabelP3M = new javax.swing.JLabel();
        LabelP4M = new javax.swing.JLabel();
        jTextTCM = new javax.swing.JTextField();
        jTextTAM = new javax.swing.JTextField();
        jTextPasajerosM = new javax.swing.JTextField();
        jTextTallerM = new javax.swing.JTextField();
        jTextPE1M = new javax.swing.JTextField();
        jTextPE2M = new javax.swing.JTextField();
        jTextPE3M = new javax.swing.JTextField();
        jTextPE4M = new javax.swing.JTextField();
        jTextPE5M = new javax.swing.JTextField();
        jTextPE6M = new javax.swing.JTextField();
        jTextARM = new javax.swing.JTextField();
        jTextP1M = new javax.swing.JTextField();
        jTextP2M = new javax.swing.JTextField();
        jTextP3M = new javax.swing.JTextField();
        jTextP4M = new javax.swing.JTextField();
        jTextTallerB = new javax.swing.JTextField();
        jTextPE1B = new javax.swing.JTextField();
        jTextPE2B = new javax.swing.JTextField();
        jTextPE3B = new javax.swing.JTextField();
        jTextPE4B = new javax.swing.JTextField();
        LabelTallerB = new javax.swing.JLabel();
        jTextPE5B = new javax.swing.JTextField();
        jTextPE6B = new javax.swing.JTextField();
        jTextARB = new javax.swing.JTextField();
        LabelARM1 = new javax.swing.JLabel();
        jTextP1B = new javax.swing.JTextField();
        LabelPE1M1 = new javax.swing.JLabel();
        LabelPE2M1 = new javax.swing.JLabel();
        LabelPE3M1 = new javax.swing.JLabel();
        LabelPE4M1 = new javax.swing.JLabel();
        LabelPE6M1 = new javax.swing.JLabel();
        LabelPE5M1 = new javax.swing.JLabel();
        LabelP1M1 = new javax.swing.JLabel();
        LAbelP2M1 = new javax.swing.JLabel();
        LabelP3M1 = new javax.swing.JLabel();
        LabelP4M1 = new javax.swing.JLabel();
        jTextP2B = new javax.swing.JTextField();
        jTextP3B = new javax.swing.JTextField();
        jTextP4B = new javax.swing.JTextField();
        LabelPasajerosB = new javax.swing.JLabel();
        jTextPasajerosB = new javax.swing.JTextField();
        LabelTCB = new javax.swing.JLabel();
        LabelTAB = new javax.swing.JLabel();
        jTextTCB = new javax.swing.JTextField();
        jTextTAB = new javax.swing.JTextField();
        LabelAMB = new javax.swing.JLabel();
        LabelABM = new javax.swing.JLabel();
        jTextAMB = new javax.swing.JTextField();
        jTextABM = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextHangarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextHangarMActionPerformed(evt);
            }
        });

        LabelHangarM.setText("Hangar:");

        LabelAEM.setText("Area Estc:");

        jTextAreaEstcM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAreaEstcMActionPerformed(evt);
            }
        });

        jLabel3.setText("Aeropuerto Madrid");

        jLabel4.setText("Aeropuerto Barcelona");

        jLabel5.setText("Hangar:");

        jTextHangarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextHangarBActionPerformed(evt);
            }
        });

        jLabel6.setText("Area Estc:");

        LabelTCM.setText("Transfers Ciudad");

        LabelTallerM.setText("Taller");

        LabelPasajerosM.setText("Nº Pasajeros en Aeropuerto ");

        LabelTAM.setText("Transfers Aeropuerto");

        LabelARM.setText("Area de Rodaje");

        LabelPE1M.setText("Puerta 1:");

        LabelPE2M.setText("Puerta 2:");

        LabelPE3M.setText("Puerta 3:");

        LabelPE4M.setText("Puerta 4:");

        LabelPE6M.setText("Puerta 6:");

        LabelPE5M.setText("Puerta 5:");

        LabelP1M.setText("Pista 1:");

        LAbelP2M.setText("Pista 2:");

        LabelP3M.setText("Pista 3:");

        LabelP4M.setText("Pista 4:");

        jTextTCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTCMActionPerformed(evt);
            }
        });

        LabelTallerB.setText("Taller");

        LabelARM1.setText("Area de Rodaje");

        LabelPE1M1.setText("Puerta 1:");

        LabelPE2M1.setText("Puerta 2:");

        LabelPE3M1.setText("Puerta 3:");

        LabelPE4M1.setText("Puerta 4:");

        LabelPE6M1.setText("Puerta 6:");

        LabelPE5M1.setText("Puerta 5:");

        LabelP1M1.setText("Pista 1:");

        LAbelP2M1.setText("Pista 2:");

        LabelP3M1.setText("Pista 3:");

        LabelP4M1.setText("Pista 4:");

        LabelPasajerosB.setText("Nº Pasajeros en Aeropuerto");

        LabelTCB.setText("Transfers Ciudad");

        LabelTAB.setText("Transfers Aeropuerto");

        LabelAMB.setText("Aerovia Madrid-Barcelona");

        LabelABM.setText("Aerovia Barcelona-Madrid");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(207, 207, 207))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelAMB)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelPasajerosM)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextPasajerosM))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelP1M)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextP1M, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelARM)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextARM, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelAEM, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LabelPE1M)
                                            .addComponent(LabelPE2M)
                                            .addComponent(LabelPE3M)
                                            .addComponent(LabelHangarM))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextHangarM, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextAreaEstcM, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jTextPE2M, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextPE1M, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextPE3M, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jTextTallerM))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelTCM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextTCM, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LabelTAM)
                                .addGap(18, 18, 18)
                                .addComponent(jTextTAM, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LabelTallerM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextAMB, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(LAbelP2M)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextP2M, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LabelP4M))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(191, 191, 191)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(LabelPE4M)
                                                .addComponent(LabelPE5M)
                                                .addComponent(LabelPE6M)
                                                .addComponent(LabelP3M))))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextPE4M)
                                        .addComponent(jTextPE5M)
                                        .addComponent(jTextPE6M)
                                        .addComponent(jTextP3M, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                        .addComponent(jTextP4M)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelPasajerosB)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextPasajerosB))
                                    .addComponent(jTextABM)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextHangarB, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(LabelTallerB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(23, 23, 23)
                                                    .addComponent(jTextTallerB)
                                                    .addGap(131, 131, 131))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(LabelPE1M1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LabelPE2M1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LabelPE3M1, javax.swing.GroupLayout.Alignment.LEADING))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextAreaEstcB, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jTextPE2B, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(198, 198, 198)
                                                            .addComponent(jTextPE5B, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jTextPE3B, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(198, 198, 198)
                                                            .addComponent(jTextPE6B, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jTextPE1B, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(198, 198, 198)
                                                            .addComponent(jTextPE4B, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(LabelARM1)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jTextARB, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LAbelP2M1)
                                                        .addComponent(LabelP1M1, javax.swing.GroupLayout.Alignment.TRAILING))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(LabelP3M1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(LabelPE4M1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(LabelPE5M1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(LabelPE6M1, javax.swing.GroupLayout.Alignment.TRAILING)))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addComponent(jTextP2B, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(LabelP4M1)))
                                                            .addGap(18, 18, 18)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jTextP3B)
                                                                .addComponent(jTextP4B, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jTextP1B, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(LabelABM))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(112, 112, 112))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(LabelTCB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextTCB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelTAB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextTAB, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTCM)
                    .addComponent(LabelTAM)
                    .addComponent(jTextTCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTCB)
                    .addComponent(LabelTAB)
                    .addComponent(jTextTCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPasajerosM)
                    .addComponent(jTextPasajerosM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPasajerosB)
                    .addComponent(jTextPasajerosB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LabelHangarM)
                    .addComponent(jTextHangarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextHangarB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTallerM)
                    .addComponent(jTextTallerM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTallerB)
                    .addComponent(jTextTallerB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAEM)
                    .addComponent(jTextAreaEstcM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextAreaEstcB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPE1M)
                    .addComponent(jTextPE1M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE4M)
                    .addComponent(jTextPE4M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE1M1)
                    .addComponent(jTextPE1B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE4M1)
                    .addComponent(jTextPE4B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPE2M)
                    .addComponent(jTextPE2M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE5M)
                    .addComponent(jTextPE5M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE2M1)
                    .addComponent(jTextPE2B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE5M1)
                    .addComponent(jTextPE5B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPE3M)
                    .addComponent(jTextPE3M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE6M)
                    .addComponent(jTextPE6M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE3M1)
                    .addComponent(jTextPE3B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPE6M1)
                    .addComponent(jTextPE6B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelARM)
                    .addComponent(jTextARM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelARM1)
                    .addComponent(jTextARB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelP1M)
                    .addComponent(LabelP3M)
                    .addComponent(jTextP1M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextP3M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelP1M1)
                    .addComponent(jTextP1B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelP3M1)
                    .addComponent(jTextP3B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LAbelP2M)
                    .addComponent(LabelP4M)
                    .addComponent(jTextP2M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextP4M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LAbelP2M1)
                    .addComponent(LabelP4M1)
                    .addComponent(jTextP4B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextP2B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAMB)
                    .addComponent(LabelABM))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextAMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextABM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextHangarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextHangarMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextHangarMActionPerformed

    private void jTextAreaEstcMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAreaEstcMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaEstcMActionPerformed

    private void jTextHangarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextHangarBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextHangarBActionPerformed

    private void jTextTCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTCMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTCMActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LAbelP2M;
    private javax.swing.JLabel LAbelP2M1;
    private javax.swing.JLabel LabelABM;
    private javax.swing.JLabel LabelAEM;
    private javax.swing.JLabel LabelAMB;
    private javax.swing.JLabel LabelARM;
    private javax.swing.JLabel LabelARM1;
    private javax.swing.JLabel LabelHangarM;
    private javax.swing.JLabel LabelP1M;
    private javax.swing.JLabel LabelP1M1;
    private javax.swing.JLabel LabelP3M;
    private javax.swing.JLabel LabelP3M1;
    private javax.swing.JLabel LabelP4M;
    private javax.swing.JLabel LabelP4M1;
    private javax.swing.JLabel LabelPE1M;
    private javax.swing.JLabel LabelPE1M1;
    private javax.swing.JLabel LabelPE2M;
    private javax.swing.JLabel LabelPE2M1;
    private javax.swing.JLabel LabelPE3M;
    private javax.swing.JLabel LabelPE3M1;
    private javax.swing.JLabel LabelPE4M;
    private javax.swing.JLabel LabelPE4M1;
    private javax.swing.JLabel LabelPE5M;
    private javax.swing.JLabel LabelPE5M1;
    private javax.swing.JLabel LabelPE6M;
    private javax.swing.JLabel LabelPE6M1;
    private javax.swing.JLabel LabelPasajerosB;
    private javax.swing.JLabel LabelPasajerosM;
    private javax.swing.JLabel LabelTAB;
    private javax.swing.JLabel LabelTAM;
    private javax.swing.JLabel LabelTCB;
    private javax.swing.JLabel LabelTCM;
    private javax.swing.JLabel LabelTallerB;
    private javax.swing.JLabel LabelTallerM;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextABM;
    private javax.swing.JTextField jTextAMB;
    private javax.swing.JTextField jTextARB;
    private javax.swing.JTextField jTextARM;
    private javax.swing.JTextField jTextAreaEstcB;
    private javax.swing.JTextField jTextAreaEstcM;
    private javax.swing.JTextField jTextHangarB;
    private javax.swing.JTextField jTextHangarM;
    private javax.swing.JTextField jTextP1B;
    private javax.swing.JTextField jTextP1M;
    private javax.swing.JTextField jTextP2B;
    private javax.swing.JTextField jTextP2M;
    private javax.swing.JTextField jTextP3B;
    private javax.swing.JTextField jTextP3M;
    private javax.swing.JTextField jTextP4B;
    private javax.swing.JTextField jTextP4M;
    private javax.swing.JTextField jTextPE1B;
    private javax.swing.JTextField jTextPE1M;
    private javax.swing.JTextField jTextPE2B;
    private javax.swing.JTextField jTextPE2M;
    private javax.swing.JTextField jTextPE3B;
    private javax.swing.JTextField jTextPE3M;
    private javax.swing.JTextField jTextPE4B;
    private javax.swing.JTextField jTextPE4M;
    private javax.swing.JTextField jTextPE5B;
    private javax.swing.JTextField jTextPE5M;
    private javax.swing.JTextField jTextPE6B;
    private javax.swing.JTextField jTextPE6M;
    private javax.swing.JTextField jTextPasajerosB;
    private javax.swing.JTextField jTextPasajerosM;
    private javax.swing.JTextField jTextTAB;
    private javax.swing.JTextField jTextTAM;
    private javax.swing.JTextField jTextTCB;
    private javax.swing.JTextField jTextTCM;
    private javax.swing.JTextField jTextTallerB;
    private javax.swing.JTextField jTextTallerM;
    // End of variables declaration//GEN-END:variables
}
