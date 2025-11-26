package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JFrmPrincipal extends javax.swing.JFrame {

    public JFrmPrincipal() {
        initComponents();
        setTitle("Sistema de Vendas de Jogos");
        setExtendedState(MAXIMIZED_BOTH);

        try {
            File arquivoMusica = new File("src/musica/musicainicial.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivoMusica);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            //clip.start(); // toca uma vez só 
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = screenSize.width;
        int altura = screenSize.height;

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/img/telaPrincipal.jpg"));
        Image image = backgroundIcon.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, largura, altura);

        getContentPane().add(background);
        getContentPane().setComponentZOrder(background, getContentPane().getComponentCount() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        rps_jMnuCadastros = new javax.swing.JMenu();
        rps_jMnuClientes = new javax.swing.JMenuItem();
        rps_jMnuProdutos = new javax.swing.JMenuItem();
        rps_jMnuUsuarios = new javax.swing.JMenuItem();
        rps_jMnuVendedores = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        rps_jMnuSair = new javax.swing.JMenuItem();
        rps_jMnuMovimentos = new javax.swing.JMenu();
        rps_jMnuVendas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rps_jMnuCadastros.setMnemonic('c');
        rps_jMnuCadastros.setText("Cadastros");

        rps_jMnuClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        rps_jMnuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Clientes.png"))); // NOI18N
        rps_jMnuClientes.setMnemonic('c');
        rps_jMnuClientes.setText("Clientes");
        rps_jMnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rps_jMnuClientesActionPerformed(evt);
            }
        });
        rps_jMnuCadastros.add(rps_jMnuClientes);

        rps_jMnuProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        rps_jMnuProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Produtos.png"))); // NOI18N
        rps_jMnuProdutos.setMnemonic('p');
        rps_jMnuProdutos.setText("Produtos");
        rps_jMnuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rps_jMnuProdutosActionPerformed(evt);
            }
        });
        rps_jMnuCadastros.add(rps_jMnuProdutos);

        rps_jMnuUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        rps_jMnuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Usuario.png"))); // NOI18N
        rps_jMnuUsuarios.setMnemonic('u');
        rps_jMnuUsuarios.setText("Usuários");
        rps_jMnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rps_jMnuUsuariosActionPerformed(evt);
            }
        });
        rps_jMnuCadastros.add(rps_jMnuUsuarios);

        rps_jMnuVendedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        rps_jMnuVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vendedora.png"))); // NOI18N
        rps_jMnuVendedores.setMnemonic('v');
        rps_jMnuVendedores.setText("Vendedores");
        rps_jMnuVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rps_jMnuVendedoresActionPerformed(evt);
            }
        });
        rps_jMnuCadastros.add(rps_jMnuVendedores);
        rps_jMnuCadastros.add(jSeparator1);

        rps_jMnuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        rps_jMnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        rps_jMnuSair.setMnemonic('s');
        rps_jMnuSair.setText("Sair");
        rps_jMnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rps_jMnuSairActionPerformed(evt);
            }
        });
        rps_jMnuCadastros.add(rps_jMnuSair);

        jMenuBar1.add(rps_jMnuCadastros);

        rps_jMnuMovimentos.setMnemonic('m');
        rps_jMnuMovimentos.setText("Movimentos");

        rps_jMnuVendas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        rps_jMnuVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda.png"))); // NOI18N
        rps_jMnuVendas.setMnemonic('v');
        rps_jMnuVendas.setText("Vendas");
        rps_jMnuVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rps_jMnuVendasActionPerformed(evt);
            }
        });
        rps_jMnuMovimentos.add(rps_jMnuVendas);

        jMenuBar1.add(rps_jMnuMovimentos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rps_jMnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rps_jMnuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_rps_jMnuSairActionPerformed

    private void rps_jMnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rps_jMnuUsuariosActionPerformed
        JDlgUsuarios jDlgUsuarios = new JDlgUsuarios(this, true);
        jDlgUsuarios.setVisible(true);
    }//GEN-LAST:event_rps_jMnuUsuariosActionPerformed

    private void rps_jMnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rps_jMnuClientesActionPerformed
        JDlgClientes jDlgClientes = new JDlgClientes(this, true);
        jDlgClientes.setVisible(true);
    }//GEN-LAST:event_rps_jMnuClientesActionPerformed

    private void rps_jMnuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rps_jMnuProdutosActionPerformed
        JDlgProdutos jDlgProdutos = new JDlgProdutos(this, true);
        jDlgProdutos.setVisible(true);
    }//GEN-LAST:event_rps_jMnuProdutosActionPerformed

    private void rps_jMnuVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rps_jMnuVendedoresActionPerformed
        JDlgVendedor jDlgVendedor = new JDlgVendedor(this, true);
        jDlgVendedor.setVisible(true);
    }//GEN-LAST:event_rps_jMnuVendedoresActionPerformed

    private void rps_jMnuVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rps_jMnuVendasActionPerformed
        JDlgVendas jDlgVendas = new JDlgVendas(this, true);
        jDlgVendas.setVisible(true);
    }//GEN-LAST:event_rps_jMnuVendasActionPerformed
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
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu rps_jMnuCadastros;
    private javax.swing.JMenuItem rps_jMnuClientes;
    private javax.swing.JMenu rps_jMnuMovimentos;
    private javax.swing.JMenuItem rps_jMnuProdutos;
    private javax.swing.JMenuItem rps_jMnuSair;
    private javax.swing.JMenuItem rps_jMnuUsuarios;
    private javax.swing.JMenuItem rps_jMnuVendas;
    private javax.swing.JMenuItem rps_jMnuVendedores;
    // End of variables declaration//GEN-END:variables
}
