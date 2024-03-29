/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import dominio.Cliente;
import implementaciones.ClientesDAO;
import implementaciones.CuentasClientesDAO;
import implementaciones.TransaccionesDAO;
import interfaces.IClientesDAO;
import java.awt.Color;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 * Frame encargado de que el usuario pueda ver sus datos y editar los mismos
 *
 * @author Elmer y Kim
 */
public class FrmUsuario extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    private final Cliente cliente;

    /**
     * Creates new form FrmUsuario
     */
    public FrmUsuario(ClientesDAO clientesDAO, Cliente cliente) {
        this.clientesDAO = clientesDAO;
        this.cliente = cliente;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtFieldNumDomicilio = new javax.swing.JTextField();
        txtFieldCp = new javax.swing.JTextField();
        txtFieldCalle = new javax.swing.JTextField();
        txtFieldApellidoMat = new javax.swing.JTextField();
        txtFieldApellidoPat = new javax.swing.JTextField();
        txtFieldNombre = new javax.swing.JTextField();
        btnEditarApellidoMat = new javax.swing.JButton();
        btnEditarCalle = new javax.swing.JButton();
        btnEditarCp = new javax.swing.JButton();
        btnEditarNumDomicilio = new javax.swing.JButton();
        btnEditarApellidoPat = new javax.swing.JButton();
        btnEditarNombre = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnCuenta = new javax.swing.JButton();
        btnDesconectarse = new javax.swing.JButton();
        btnTransacciones = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblBotonDerecha = new javax.swing.JLabel();
        lblPestanaCuenta = new javax.swing.JLabel();
        lblPestanaUser = new javax.swing.JLabel();
        lblPestanaTransac = new javax.swing.JLabel();
        lblRecuadro = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFieldNumDomicilio.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldNumDomicilio.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldNumDomicilio.setText(String.valueOf(this.cliente.getNumDomicilio()));
        txtFieldNumDomicilio.setBorder(null);
        txtFieldNumDomicilio.setFocusable(false);
        txtFieldNumDomicilio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldNumDomicilioFocusLost(evt);
            }
        });
        txtFieldNumDomicilio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldNumDomicilioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldNumDomicilioMouseExited(evt);
            }
        });
        txtFieldNumDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNumDomicilioActionPerformed(evt);
            }
        });
        txtFieldNumDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldNumDomicilioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldNumDomicilioKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldNumDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 398, 270, 20));

        txtFieldCp.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldCp.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldCp.setText(String.valueOf(this.cliente.getCp()));
        txtFieldCp.setBorder(null);
        txtFieldCp.setFocusable(false);
        txtFieldCp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldCpFocusLost(evt);
            }
        });
        txtFieldCp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldCpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldCpMouseExited(evt);
            }
        });
        txtFieldCp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCpActionPerformed(evt);
            }
        });
        txtFieldCp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldCpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCpKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 433, 270, 20));

        txtFieldCalle.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldCalle.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldCalle.setText(this.cliente.getCalle());
        txtFieldCalle.setBorder(null);
        txtFieldCalle.setFocusable(false);
        txtFieldCalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldCalleFocusLost(evt);
            }
        });
        txtFieldCalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldCalleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldCalleMouseExited(evt);
            }
        });
        txtFieldCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCalleActionPerformed(evt);
            }
        });
        txtFieldCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldCalleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCalleKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 363, 270, 20));

        txtFieldApellidoMat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldApellidoMat.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldApellidoMat.setText(this.cliente.getApellidoMaterno());
        txtFieldApellidoMat.setBorder(null);
        txtFieldApellidoMat.setFocusable(false);
        txtFieldApellidoMat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldApellidoMatFocusLost(evt);
            }
        });
        txtFieldApellidoMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldApellidoMatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldApellidoMatMouseExited(evt);
            }
        });
        txtFieldApellidoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldApellidoMatActionPerformed(evt);
            }
        });
        txtFieldApellidoMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldApellidoMatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldApellidoMatKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldApellidoMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 331, 270, 20));

        txtFieldApellidoPat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldApellidoPat.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldApellidoPat.setText(this.cliente.getApellidoPaterno());
        txtFieldApellidoPat.setBorder(null);
        txtFieldApellidoPat.setFocusable(false);
        txtFieldApellidoPat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldApellidoPatFocusLost(evt);
            }
        });
        txtFieldApellidoPat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldApellidoPatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldApellidoPatMouseExited(evt);
            }
        });
        txtFieldApellidoPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldApellidoPatActionPerformed(evt);
            }
        });
        txtFieldApellidoPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldApellidoPatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldApellidoPatKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldApellidoPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 292, 270, 20));

        txtFieldNombre.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldNombre.setText(this.cliente.getNombre());
        txtFieldNombre.setBorder(null);
        txtFieldNombre.setFocusable(false);
        txtFieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldNombreFocusLost(evt);
            }
        });
        txtFieldNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldNombreMouseExited(evt);
            }
        });
        txtFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNombreActionPerformed(evt);
            }
        });
        txtFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 251, 270, 20));

        btnEditarApellidoMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgUsuarios/editar.png"))); // NOI18N
        btnEditarApellidoMat.setBorder(null);
        btnEditarApellidoMat.setBorderPainted(false);
        btnEditarApellidoMat.setContentAreaFilled(false);
        btnEditarApellidoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarApellidoMatActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarApellidoMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 330, -1, -1));

        btnEditarCalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgUsuarios/editar.png"))); // NOI18N
        btnEditarCalle.setBorder(null);
        btnEditarCalle.setBorderPainted(false);
        btnEditarCalle.setContentAreaFilled(false);
        btnEditarCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCalleActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 362, -1, -1));

        btnEditarCp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgUsuarios/editar.png"))); // NOI18N
        btnEditarCp.setBorder(null);
        btnEditarCp.setBorderPainted(false);
        btnEditarCp.setContentAreaFilled(false);
        btnEditarCp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCpActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 437, -1, -1));

        btnEditarNumDomicilio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgUsuarios/editar.png"))); // NOI18N
        btnEditarNumDomicilio.setBorder(null);
        btnEditarNumDomicilio.setBorderPainted(false);
        btnEditarNumDomicilio.setContentAreaFilled(false);
        btnEditarNumDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNumDomicilioActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarNumDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 401, -1, -1));

        btnEditarApellidoPat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgUsuarios/editar.png"))); // NOI18N
        btnEditarApellidoPat.setBorder(null);
        btnEditarApellidoPat.setBorderPainted(false);
        btnEditarApellidoPat.setContentAreaFilled(false);
        btnEditarApellidoPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarApellidoPatActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarApellidoPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 292, -1, -1));

        btnEditarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgUsuarios/editar.png"))); // NOI18N
        btnEditarNombre.setBorder(null);
        btnEditarNombre.setBorderPainted(false);
        btnEditarNombre.setContentAreaFilled(false);
        btnEditarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNombreActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 252, -1, -1));

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgUsuarios/userSelected.png"))); // NOI18N
        btnUser.setBorder(null);
        btnUser.setBorderPainted(false);
        btnUser.setContentAreaFilled(false);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 111, 40, -1));

        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgTransacciones/btnCuentas.png"))); // NOI18N
        btnCuenta.setBorder(null);
        btnCuenta.setBorderPainted(false);
        btnCuenta.setContentAreaFilled(false);
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 120, 50, -1));

        btnDesconectarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/desconectarse.png"))); // NOI18N
        btnDesconectarse.setBorder(null);
        btnDesconectarse.setBorderPainted(false);
        btnDesconectarse.setContentAreaFilled(false);
        btnDesconectarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesconectarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 740, -1, -1));

        btnTransacciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/btnTransacciones.png"))); // NOI18N
        btnTransacciones.setBorder(null);
        btnTransacciones.setBorderPainted(false);
        btnTransacciones.setContentAreaFilled(false);
        btnTransacciones.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgTransacciones/btnTransaccionesSelected.png"))); // NOI18N
        btnTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 110, 50, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnAceptar.png"))); // NOI18N
        btnAceptar.setBorder(null);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgTransacciones/btnTransaccionesSelected.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 590, 40, 30));

        lblBotonDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiro.png"))); // NOI18N
        jPanel1.add(lblBotonDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 485, -1, -1));

        lblPestanaCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        jPanel1.add(lblPestanaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblPestanaUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        jPanel1.add(lblPestanaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 1140, -1));

        lblPestanaTransac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        jPanel1.add(lblPestanaTransac, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1080, -1));

        lblRecuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgUsuarios/operaciones.png"))); // NOI18N
        jPanel1.add(lblRecuadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png"))); // NOI18N
        lblFondo.setAlignmentY(0.0F);
        lblFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
        new FrmCuentas(new CuentasClientesDAO(this.clientesDAO.getGENERADOR_CONEXIONES()), this.cliente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCuentaActionPerformed

    private void btnTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionesActionPerformed
        new FrmTransacciones(new TransaccionesDAO(this.clientesDAO.getGENERADOR_CONEXIONES()), this.cliente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransaccionesActionPerformed

    private void txtFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusLost
        if (txtFieldNombre.getText().equals("")) {
            txtFieldNombre.setText("Ingrese su usuario");
        }
    }//GEN-LAST:event_txtFieldNombreFocusLost

    private void txtFieldNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseEntered
        if (txtFieldNombre.getText().equals("Ingrese su usuario"))
            txtFieldNombre.setText("");
    }//GEN-LAST:event_txtFieldNombreMouseEntered

    private void txtFieldNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseExited
        if (txtFieldNombre.getText().equals("")) {
            txtFieldNombre.setText("Ingrese su usuario");
        } else if (!txtFieldNombre.getText().equals("Ingrese su usuario")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldNombreMouseExited

    private void txtFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombreActionPerformed

    }//GEN-LAST:event_txtFieldNombreActionPerformed

    private void txtFieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyReleased
        // TODO add your handling code here:
        txtFieldNombre.setText(txtFieldNombre.getText().trim());
    }//GEN-LAST:event_txtFieldNombreKeyReleased

    private void txtFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyTyped
        txtFieldNombre.setText(txtFieldNombre.getText().trim());
        if (txtFieldNombre.getText().equals("Ingrese su usuario")) {
            txtFieldNombre.setText("");
        }
    }//GEN-LAST:event_txtFieldNombreKeyTyped

    private void txtFieldApellidoPatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoPatFocusLost

    private void txtFieldApellidoPatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoPatMouseEntered

    private void txtFieldApellidoPatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoPatMouseExited

    private void txtFieldApellidoPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoPatActionPerformed

    private void txtFieldApellidoPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoPatKeyReleased

    private void txtFieldApellidoPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoPatKeyTyped

    private void txtFieldCpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCpFocusLost

    private void txtFieldCpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldCpMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCpMouseEntered

    private void txtFieldCpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldCpMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCpMouseExited

    private void txtFieldCpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCpActionPerformed

    private void txtFieldCpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCpKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCpKeyReleased

    private void txtFieldCpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCpKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCpKeyTyped

    private void txtFieldApellidoMatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoMatFocusLost

    private void txtFieldApellidoMatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoMatMouseEntered

    private void txtFieldApellidoMatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoMatMouseExited

    private void txtFieldApellidoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoMatActionPerformed

    private void txtFieldApellidoMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoMatKeyReleased

    private void txtFieldApellidoMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoMatKeyTyped

    private void txtFieldNumDomicilioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNumDomicilioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNumDomicilioFocusLost

    private void txtFieldNumDomicilioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNumDomicilioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNumDomicilioMouseEntered

    private void txtFieldNumDomicilioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNumDomicilioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNumDomicilioMouseExited

    private void txtFieldNumDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNumDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNumDomicilioActionPerformed

    private void txtFieldNumDomicilioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNumDomicilioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNumDomicilioKeyReleased

    private void txtFieldNumDomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNumDomicilioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNumDomicilioKeyTyped

    private void txtFieldCalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCalleFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCalleFocusLost

    private void txtFieldCalleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldCalleMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCalleMouseEntered

    private void txtFieldCalleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldCalleMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCalleMouseExited

    private void txtFieldCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCalleActionPerformed

    private void txtFieldCalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCalleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCalleKeyReleased

    private void txtFieldCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCalleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCalleKeyTyped


    private void btnEditarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNombreActionPerformed
        if (this.txtFieldNombre.isFocusable() == false) {
            this.txtFieldNombre.setForeground(Color.BLACK);

            this.txtFieldNombre.setFocusable(true);
        } else {
            this.txtFieldNombre.setFocusable(false);
            this.txtFieldNombre.setForeground(Color.GRAY);

        }
    }//GEN-LAST:event_btnEditarNombreActionPerformed

    private void btnDesconectarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarseActionPerformed

        new FrmLogin(new ClientesDAO(this.clientesDAO.getGENERADOR_CONEXIONES())).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDesconectarseActionPerformed

    private void btnEditarApellidoPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarApellidoPatActionPerformed
        if (this.txtFieldApellidoPat.isFocusable() == false) {
            this.txtFieldApellidoPat.setForeground(Color.BLACK);

            this.txtFieldApellidoPat.setFocusable(true);
        } else {
            this.txtFieldApellidoPat.setFocusable(false);
            this.txtFieldApellidoPat.setForeground(Color.GRAY);

        }
    }//GEN-LAST:event_btnEditarApellidoPatActionPerformed

    private void btnEditarApellidoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarApellidoMatActionPerformed
        if (this.txtFieldApellidoMat.isFocusable() == false) {
            this.txtFieldApellidoMat.setForeground(Color.BLACK);

            this.txtFieldApellidoMat.setFocusable(true);
        } else {
            this.txtFieldApellidoMat.setFocusable(false);
            this.txtFieldApellidoMat.setForeground(Color.GRAY);

        }
    }//GEN-LAST:event_btnEditarApellidoMatActionPerformed

    private void btnEditarCpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCpActionPerformed
        if (this.txtFieldCp.isFocusable() == false) {
            this.txtFieldCp.setForeground(Color.BLACK);

            this.txtFieldCp.setFocusable(true);
        } else {
            this.txtFieldCp.setFocusable(false);
            this.txtFieldCp.setForeground(Color.GRAY);

        }    }//GEN-LAST:event_btnEditarCpActionPerformed

    private void btnEditarCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCalleActionPerformed
        if (this.txtFieldCalle.isFocusable() == false) {
            this.txtFieldCalle.setForeground(Color.BLACK);

            this.txtFieldCalle.setFocusable(true);
        } else {
            this.txtFieldCalle.setFocusable(false);
            this.txtFieldCalle.setForeground(Color.GRAY);

        }
    }//GEN-LAST:event_btnEditarCalleActionPerformed

    private void btnEditarNumDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNumDomicilioActionPerformed
        if (this.txtFieldNumDomicilio.isFocusable() == false) {
            this.txtFieldNumDomicilio.setFocusable(true);
            this.txtFieldNumDomicilio.setForeground(Color.BLACK);
        } else {
            this.txtFieldNumDomicilio.setFocusable(false);
            this.txtFieldNumDomicilio.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_btnEditarNumDomicilioActionPerformed
    /**
     * Boton qu actualiza los datos de los clientes con los que ellos ingresaron
     * en los txtField
     *
     * @param evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (this.txtFieldNumDomicilio.getText().matches("^([+]?\\d*\\.?\\d*)$") && this.txtFieldCp.getText().matches("^([+]?\\d*\\.?\\d*)$")) {

            clientesDAO.actualizarNumDomicilio(cliente.getId(), Integer.parseInt(this.txtFieldNumDomicilio.getText()));
            clientesDAO.actualizarCalle(cliente.getId(), this.txtFieldCalle.getText());
            clientesDAO.actualizarCP(cliente.getId(), Integer.parseInt(this.txtFieldCp.getText()));
            clientesDAO.actualizarApellidoMat(cliente.getId(), this.txtFieldApellidoMat.getText());
            clientesDAO.actualizarApellidoPat(cliente.getId(), this.txtFieldApellidoPat.getText());
            clientesDAO.actualizarNombre(cliente.getId(), this.txtFieldNombre.getText());
            
            cliente.setNumDomicilio(Integer.parseInt(this.txtFieldNumDomicilio.getText()));
            cliente.setCalle(this.txtFieldCalle.getText());
            cliente.setCp(Integer.parseInt(this.txtFieldCp.getText()));
            cliente.setApellidoMaterno(this.txtFieldApellidoMat.getText());
            cliente.setApellidoPaterno(this.txtFieldApellidoPat.getText());
            cliente.setNombre(this.txtFieldNombre.getText());

            new JOptionPane().showMessageDialog(this, "Usuario actualizado en la base de datos!", "¡Actualizado!", JOptionPane.QUESTION_MESSAGE);
            
        } else {
            new JOptionPane().showConfirmDialog(this, "Error en num Domicilio o CP\nUsar solo números", "Error!!", JOptionPane.YES_NO_OPTION);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnDesconectarse;
    private javax.swing.JButton btnEditarApellidoMat;
    private javax.swing.JButton btnEditarApellidoPat;
    private javax.swing.JButton btnEditarCalle;
    private javax.swing.JButton btnEditarCp;
    private javax.swing.JButton btnEditarNombre;
    private javax.swing.JButton btnEditarNumDomicilio;
    private javax.swing.JButton btnTransacciones;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBotonDerecha;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblPestanaCuenta;
    private javax.swing.JLabel lblPestanaTransac;
    private javax.swing.JLabel lblPestanaUser;
    private javax.swing.JLabel lblRecuadro;
    private javax.swing.JTextField txtFieldApellidoMat;
    private javax.swing.JTextField txtFieldApellidoPat;
    private javax.swing.JTextField txtFieldCalle;
    private javax.swing.JTextField txtFieldCp;
    private javax.swing.JTextField txtFieldNombre;
    private javax.swing.JTextField txtFieldNumDomicilio;
    // End of variables declaration//GEN-END:variables
}
