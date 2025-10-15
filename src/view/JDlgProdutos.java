/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import bean.RpsProdutos;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;
import dao.ProdutosDAO;

public class JDlgProdutos extends javax.swing.JDialog {

    private boolean incluir;
    private MaskFormatter mascaraDataNasc;

    public JDlgProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jLabel1.setForeground(Color.BLACK);
        jLabel2.setForeground(Color.BLACK);
        jLabel3.setForeground(Color.BLACK);
        jLabel4.setForeground(Color.BLACK);
        jLabel5.setForeground(Color.BLACK);
        jLabel6.setForeground(Color.BLACK);
        jLabel7.setForeground(Color.BLACK);

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/img/telaProduto.jpg"));
        Image image = backgroundIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(background);
        getContentPane().setComponentZOrder(background, getContentPane().getComponentCount() - 1);
        Util.habilitar(false, jBtnConfirmar, jBtnCancelar, jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
        try {
            mascaraDataNasc = new MaskFormatter("##/##/####");
            jFmtAnoLançamento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNasc));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // === FORMATAÇÃO AUTOMÁTICA DE SALDO COM R$ ===
        jFmtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                // Remove tudo que não for número
                String texto = jFmtValor.getText().replaceAll("[^0-9]", "");

                if (texto.isEmpty()) {
                    jFmtValor.setText("R$ 0,00");
                    return;
                }

                // Garante pelo menos 3 dígitos (para manter 2 casas decimais)
                while (texto.length() < 3) {
                    texto = "0" + texto;
                }

                try {
                    double valor = Double.parseDouble(texto) / 100.0;
                    java.text.DecimalFormat df = new java.text.DecimalFormat("#,##0.00");
                    jFmtValor.setText("R$ " + df.format(valor));
                } catch (NumberFormatException e) {
                    // em caso de erro de conversão, reseta o campo
                    jFmtValor.setText("R$ 0,00");
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                // bloqueia qualquer caractere que não seja número
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });

        // inicializa o campo bonitinho
        jFmtValor.setText("R$ 0,00");
        jFmtValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFmtValor.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        jFmtValor.setForeground(new java.awt.Color(34, 139, 34)); // verde "saldo positivo"

        iniciarRelogio("Cadastro de Produtos"); // coloque o nome do usuário logado aqui
    }

    private void iniciarRelogio(String nomeUsuario) {
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            java.text.SimpleDateFormat sdfHora = new java.text.SimpleDateFormat("HH:mm:ss");
            java.text.SimpleDateFormat sdfData = new java.text.SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");

            String hora = sdfHora.format(new java.util.Date());
            String data = sdfData.format(new java.util.Date());

            // Capitaliza o dia da semana
            data = data.substring(0, 1).toUpperCase() + data.substring(1);

            // Define título com usuário, data e hora
            setTitle(nomeUsuario + " | " + data + " | " + hora);
        });
        timer.start();
    }

    public void beanView(RpsProdutos produtos) {
        jTxtCodigoJogo.setText(Util.intToStr(produtos.getRpsIdJogo()));
        jTxtNomeJogo.setText(produtos.getRpsNome());
        jTxtQuantEstoque.setText(Util.intToStr(produtos.getRpsQuantEstoque()));
        jFmtValor.setText(Util.doubleToStr(produtos.getRpsValor()));
        jFmtAnoLançamento.setText(Util.dateToStr(produtos.getRpsAnoLancamento()));
        jCboGeneroJogo.setSelectedIndex(produtos.getRpsGenero());
        jCboPlataforma.setSelectedIndex(produtos.getRpsPlataforma());
    }

    public RpsProdutos viewBean() {
        RpsProdutos Rpsprodutos = new RpsProdutos();
        int cod = Util.strToInt(jTxtCodigoJogo.getText());
        Rpsprodutos.setRpsIdJogo(cod);
        Rpsprodutos.setRpsNome(jTxtNomeJogo.getText());
        int quantidade = Util.strToInt(jTxtQuantEstoque.getText());
        Rpsprodutos.setRpsQuantEstoque(quantidade);
        Rpsprodutos.setRpsValor(Util.strToDouble(jFmtValor.getText()));
        try {
            Rpsprodutos.setRpsAnoLancamento(Util.strToDate(jFmtAnoLançamento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        Rpsprodutos.setRpsGenero(jCboGeneroJogo.getSelectedIndex());
        Rpsprodutos.setRpsPlataforma(jCboPlataforma.getSelectedIndex());
        return Rpsprodutos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxtCodigoJogo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtNomeJogo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCboGeneroJogo = new javax.swing.JComboBox<>();
        jCboPlataforma = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jFmtAnoLançamento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtQuantEstoque = new javax.swing.JTextField();
        jFmtValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gravar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setDisplayedMnemonic('c');
        jLabel1.setText("Código do Jogo");

        jTxtCodigoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigoJogoActionPerformed(evt);
            }
        });

        jLabel2.setDisplayedMnemonic('n');
        jLabel2.setText("Nome do Jogo");

        jTxtNomeJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeJogoActionPerformed(evt);
            }
        });

        jLabel3.setDisplayedMnemonic('g');
        jLabel3.setText("Gênero do Jogo");

        jLabel4.setDisplayedMnemonic('p');
        jLabel4.setText("Plataforma");

        jCboGeneroJogo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ação", "Aventura", "RPG (Role-Playing Game)", "Tiro (Shooter)", "Plataforma", "Corrida", "Luta (Fighting)", "Estratégia", "Esportes", "Simulação", "Terror (Horror)", "Puzzle / Quebra-cabeça", "Sandbox / Mundo Aberto", "MOBA (Multiplayer Online Battle Arena)", "Battle Royale", "MMO (Massively Multiplayer Online)", "Stealth (Furtividade)" }));
        jCboGeneroJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboGeneroJogoActionPerformed(evt);
            }
        });

        jCboPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "Consoles", "Mobile", "Navegador", "Arcade", "VR (Realidade Virtual)", "Nuvem (Cloud Gaming)", "Cross-Platform (Multiplataforma)" }));

        jLabel5.setDisplayedMnemonic('a');
        jLabel5.setText("Ano de Lançamento");

        jFmtAnoLançamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtAnoLançamentoActionPerformed(evt);
            }
        });

        jLabel6.setDisplayedMnemonic('q');
        jLabel6.setText("Quantidade no Estoque");

        jLabel7.setDisplayedMnemonic('v');
        jLabel7.setText("Valor");

        jFmtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPesquisar))
                    .addComponent(jTxtCodigoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jFmtAnoLançamento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCboPlataforma, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCboGeneroJogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jTxtQuantEstoque)
                            .addComponent(jFmtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodigoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboGeneroJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtQuantEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFmtAnoLançamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        Util.habilitar(true, jBtnConfirmar, jBtnCancelar, jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
        Util.limpar(jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
        Util.habilitar(false, jBtnIncluir, jBtnExcluir, jBtnAlterar, jBtnPesquisar);
        jTxtCodigoJogo.grabFocus();
        incluir = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jTxtCodigoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigoJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoJogoActionPerformed

    private void jTxtNomeJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeJogoActionPerformed

    private void jCboGeneroJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboGeneroJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboGeneroJogoActionPerformed

    private void jFmtAnoLançamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtAnoLançamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtAnoLançamentoActionPerformed

    private void jFmtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtValorActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        ProdutosDAO produtosDAO = new ProdutosDAO();
        RpsProdutos Rpsprodutos = viewBean();
        if (incluir == true) {
            produtosDAO.insert(Rpsprodutos);

        } else {
            produtosDAO.update(Rpsprodutos);
        }
        Util.habilitar(false, jBtnConfirmar, jBtnCancelar, jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
        Util.habilitar(true, jBtnIncluir, jBtnExcluir, jBtnAlterar, jBtnPesquisar);
        Util.limpar(jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        Util.habilitar(false, jBtnConfirmar, jBtnCancelar, jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
        Util.habilitar(true, jBtnIncluir, jBtnExcluir, jBtnAlterar, jBtnPesquisar);
        Util.limpar(jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        if (jTxtCodigoJogo.getText().trim().isEmpty()) {
            Util.mensagem("Pesquise um usuário antes de Alterar");
            return;
        }
        Util.habilitar(true, jBtnConfirmar, jBtnCancelar, jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
        Util.habilitar(false, jBtnIncluir, jBtnExcluir, jBtnAlterar, jBtnPesquisar);
        Util.habilitar(false, jTxtCodigoJogo);
        jTxtNomeJogo.grabFocus();
        incluir = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        JDlgProdutosPesquisar jDlgProdutosPesquisar = new JDlgProdutosPesquisar(null, true);
        jDlgProdutosPesquisar.setTelaAnterior(this);
        jDlgProdutosPesquisar.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if (jTxtCodigoJogo.getText().trim().isEmpty()) {
            Util.mensagem("Pesquise um usuário antes de Excluir");
            return;
        }

        if (Util.pergunta("Deseja excluir ?") == true) {
            ProdutosDAO produtosDAO = new ProdutosDAO();
            RpsProdutos rpsProdutos = viewBean();
            produtosDAO.delete(rpsProdutos);
        }
        Util.limpar(jTxtCodigoJogo, jTxtNomeJogo, jTxtQuantEstoque, jFmtAnoLançamento, jFmtValor, jCboGeneroJogo, jCboPlataforma);
    }//GEN-LAST:event_jBtnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgProdutos dialog = new JDlgProdutos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboGeneroJogo;
    private javax.swing.JComboBox<String> jCboPlataforma;
    private javax.swing.JFormattedTextField jFmtAnoLançamento;
    private javax.swing.JFormattedTextField jFmtValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTxtCodigoJogo;
    private javax.swing.JTextField jTxtNomeJogo;
    private javax.swing.JTextField jTxtQuantEstoque;
    // End of variables declaration//GEN-END:variables

}
