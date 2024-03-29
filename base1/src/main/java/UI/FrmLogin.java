/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import dominio.Cliente;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.CuentasClientesDAO;
import implementaciones.RetirosSinCuentaDAO;
import interfaces.IClientesDAO;
import interfaces.ICuentasClientesDAO;
import interfaces.IRetiroSinCuentaDAO;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Frm de login para iniciar sesión o realizar un retiro sin cuenta
 *
 * @author Kim y Elmer
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * ClientesDAO
     */
    private final IClientesDAO clientesDao;
    /**
     * Interfaz RetiroSinCuentaDAO
     */
    private final IRetiroSinCuentaDAO restiroSinCuentaDAO;

    /**
     * Creates new form Login
     */
    public FrmLogin(IClientesDAO clientesDao) {
        initComponents();
        this.clientesDao = clientesDao;
        this.restiroSinCuentaDAO = new RetirosSinCuentaDAO(clientesDao.getGENERADOR_CONEXIONES());
        this.pswFieldPassword.setEchoChar((char) 0); //Descifrar password field
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        btnEaster = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        pswFieldPassword = new javax.swing.JPasswordField();
        txtFieldUser = new javax.swing.JTextField();
        lblRegistro = new javax.swing.JLabel();
        lblNoEstasRegistrado = new javax.swing.JLabel();
        lblIconos = new javax.swing.JLabel();
        lblRecuadro = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BancoElmerKim");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setResizable(false);

        pnlFondo.setFocusable(false);
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiro.png"))); // NOI18N
        btnEaster.setBorder(null);
        btnEaster.setBorderPainted(false);
        btnEaster.setContentAreaFilled(false);
        btnEaster.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSelected.png"))); // NOI18N
        btnEaster.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiro.png"))); // NOI18N
        btnEaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEasterActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEaster, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 423, -1, -1));

        btnRetiroSinCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSinCuenta.png"))); // NOI18N
        btnRetiroSinCuenta.setBorder(null);
        btnRetiroSinCuenta.setBorderPainted(false);
        btnRetiroSinCuenta.setContentAreaFilled(false);
        btnRetiroSinCuenta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSinCuentaSelected.png"))); // NOI18N
        btnRetiroSinCuenta.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSinCuentaSelected.png"))); // NOI18N
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRetiroSinCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, -1, -1));

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnIniciarSesion.png"))); // NOI18N
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnIniciarSesionSelected.png"))); // NOI18N
        btnIniciarSesion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnIniciarSesion.png"))); // NOI18N
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        pnlFondo.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        pswFieldPassword.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        pswFieldPassword.setForeground(new java.awt.Color(153, 153, 153));
        pswFieldPassword.setText("Ingrese su contraseña");
        pswFieldPassword.setBorder(null);
        pswFieldPassword.setPreferredSize(new java.awt.Dimension(96, 16));
        pswFieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pswFieldPasswordFocusLost(evt);
            }
        });
        pswFieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pswFieldPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pswFieldPasswordMouseExited(evt);
            }
        });
        pswFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pswFieldPasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pswFieldPasswordKeyTyped(evt);
            }
        });
        pnlFondo.add(pswFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 337, 310, -1));

        txtFieldUser.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldUser.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldUser.setText("Ingrese su usuario");
        txtFieldUser.setBorder(null);
        txtFieldUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldUserFocusLost(evt);
            }
        });
        txtFieldUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldUserMouseExited(evt);
            }
        });
        txtFieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldUserActionPerformed(evt);
            }
        });
        txtFieldUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldUserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldUserKeyTyped(evt);
            }
        });
        pnlFondo.add(txtFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 291, 310, -1));

        lblRegistro.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblRegistro.setForeground(new java.awt.Color(51, 153, 0));
        lblRegistro.setText("Registrate aquí");
        lblRegistro.setToolTipText("Comeinza tu registro ;)");
        lblRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistroMouseClicked(evt);
            }
        });
        pnlFondo.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        lblNoEstasRegistrado.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblNoEstasRegistrado.setForeground(new java.awt.Color(153, 153, 153));
        lblNoEstasRegistrado.setText("¿No estás registrado?");
        pnlFondo.add(lblNoEstasRegistrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        lblIconos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblIconos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos.png"))); // NOI18N
        pnlFondo.add(lblIconos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblRecuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recuadroWeb.png"))); // NOI18N
        lblRecuadro.setAlignmentY(0.0F);
        pnlFondo.add(lblRecuadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png"))); // NOI18N
        lblFondo.setAlignmentY(0.0F);
        lblFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldUserActionPerformed

    }//GEN-LAST:event_txtFieldUserActionPerformed

//De aquí hacia abajo son algunos métodos que validan si el mouse entró, salió, etc de un txtField para dejar al usuario escribir

    private void txtFieldUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldUserMouseEntered
        if (txtFieldUser.getText().equals("Ingrese su usuario"))
            txtFieldUser.setText("");
    }//GEN-LAST:event_txtFieldUserMouseEntered

    private void txtFieldUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldUserMouseExited
        if (txtFieldUser.getText().equals("")) {
            txtFieldUser.setText("Ingrese su usuario");
        } else if (!txtFieldUser.getText().equals("Ingrese su usuario")) {
            evt.consume();
        }

    }//GEN-LAST:event_txtFieldUserMouseExited

    private void txtFieldUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldUserFocusLost
        if (txtFieldUser.getText().equals("")) {
            txtFieldUser.setText("Ingrese su usuario");
        }
    }//GEN-LAST:event_txtFieldUserFocusLost

    private void txtFieldUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldUserKeyTyped
        txtFieldUser.setText(txtFieldUser.getText().trim());
        if (txtFieldUser.getText().equals("Ingrese su usuario")) {
            txtFieldUser.setText("");
        }
    }//GEN-LAST:event_txtFieldUserKeyTyped

    private void pswFieldPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pswFieldPasswordMouseEntered
        if (pswFieldPassword.getText().equals("Ingrese su contraseña")) {
            pswFieldPassword.setText("");
            this.pswFieldPassword.setEchoChar('*');
        }


    }//GEN-LAST:event_pswFieldPasswordMouseEntered

    private void pswFieldPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pswFieldPasswordMouseExited
        if (pswFieldPassword.getText().equals("")) {
            pswFieldPassword.setText("Ingrese su contraseña");
            this.pswFieldPassword.setEchoChar((char) 0);
        } else if (!pswFieldPassword.getText().equals("Ingrese su contraseña")) {
            evt.consume();
        }
    }//GEN-LAST:event_pswFieldPasswordMouseExited

    private void pswFieldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswFieldPasswordKeyTyped
        pswFieldPassword.setText(pswFieldPassword.getText().trim());
        if (pswFieldPassword.getText().equals("Ingrese su contraseña")) {
            pswFieldPassword.setEchoChar('*');
            pswFieldPassword.setText("");

        }
    }//GEN-LAST:event_pswFieldPasswordKeyTyped

    private void pswFieldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswFieldPasswordFocusLost
        if (pswFieldPassword.getText().equals("")) {
            pswFieldPassword.setText("Ingrese su contraseña");
            this.pswFieldPassword.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_pswFieldPasswordFocusLost

    /**
     * Consulta las credenciales de los campos de texto para iniciar sesión y si
     * el inicio es exitoso pasamos al FrmCuentas
     *
     * @param evt
     */
    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        try {
            Cliente cliente = this.clientesDao.consultar(txtFieldUser.getText(), pswFieldPassword.getText());
            if (cliente == null) {
                new JOptionPane().showMessageDialog(this, "Credenciales incorrectas", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ICuentasClientesDAO cuentasClientesDAO = new CuentasClientesDAO(this.clientesDao.getGENERADOR_CONEXIONES());
            new FrmCuentas(cuentasClientesDAO, cliente).setVisible(true);
            this.dispose();
        } catch (PersistenciaException ex) {
            new JOptionPane().showMessageDialog(this, "Credenciales incorrectas", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    /**
     * Botón que inicia el proceso de realizar un retiro sin cuenta mediante un
     * folio y una clave de retiro
     *
     * @param evt
     */
    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
//        new FrmRegister(this.clientesDao).setVisible(true);
//        this.dispose();
        String folioRetiro = null;
        String claveRetiro = null;
        try {
            folioRetiro = new JOptionPane().showInputDialog(this, "Ingrese su folio");
            if (folioRetiro.matches("^([+]?\\d*\\.?\\d*)$")) {
                claveRetiro = new JOptionPane().showInputDialog(this, "Ingrese su clave");
                if (!claveRetiro.matches("^([+]?\\d*\\.?\\d*)$")) {
                    new JOptionPane().showMessageDialog(this, "Formato incorrecto, recuerdo usar solo numeros y un punto para decimales, no se aceptan negativos", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
                }
                if (folioRetiro.equals("") || claveRetiro.equals("")) {
                    new JOptionPane().showMessageDialog(this, "Formato incorrecto, Por favor llene las casillas", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int folio = Integer.parseInt(folioRetiro);
                int clave = Integer.parseInt(claveRetiro);

                this.restiroSinCuentaDAO.retirar(clave, folio);
                  new JOptionPane().showMessageDialog(this, "Retirado de manera correcta", "¡Bien!", JOptionPane.INFORMATION_MESSAGE);

            } else {
                new JOptionPane().showMessageDialog(this, "Formato incorrecto, recuerdo usar solo numeros, no se aceptan negativos", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed

    private void btnEasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEasterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEasterActionPerformed

    private void lblRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistroMouseClicked
        new FrmRegister(this.clientesDao).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblRegistroMouseClicked

    private void txtFieldUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldUserKeyReleased
        // TODO add your handling code here:
        txtFieldUser.setText(txtFieldUser.getText().trim());
    }//GEN-LAST:event_txtFieldUserKeyReleased

    private void pswFieldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswFieldPasswordKeyReleased
        // TODO add your handling code here:
        pswFieldPassword.setText(pswFieldPassword.getText().trim());
    }//GEN-LAST:event_pswFieldPasswordKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEaster;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIconos;
    private javax.swing.JLabel lblNoEstasRegistrado;
    private javax.swing.JLabel lblRecuadro;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPasswordField pswFieldPassword;
    private javax.swing.JTextField txtFieldUser;
    // End of variables declaration//GEN-END:variables
}
