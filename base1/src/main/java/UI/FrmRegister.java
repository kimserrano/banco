/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import dominio.Cliente;
import implementaciones.ClientesDAO;
import interfaces.IClientesDAO;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 * Frm Register 1, primera parte del registro de un cliente
 *
 * @author Elmer y Kim
 */
public class FrmRegister extends javax.swing.JFrame {

    /**
     * Objeto tipo cliente que será llenado con los datos del nuevo cliente
     */
    private Cliente cliente;
    /**
     * Interfaz ClientesDAO
     */
    private final IClientesDAO clientesDao;

    /**
     * Creates new form FrmLogin
     */
    public FrmRegister(IClientesDAO clientesDao) {
        initComponents();
        this.clientesDao = clientesDao;
    }

    public FrmRegister(IClientesDAO clientesDao, Cliente cliente) {
        initComponents();
        this.clientesDao = clientesDao;
        this.cliente=cliente;
        cargarCliente();
    }
    
    private void cargarCliente(){
        this.txtFieldApellidoMat.setText(cliente.getApellidoMaterno());
        this.txtFieldApellidoPat.setText(this.cliente.getApellidoPaterno());
        this.txtFieldNombre.setText(this.cliente.getNombre());
        this.jDateChooser1.setDate(cliente.getFechaNacimiento());
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnAtras = new javax.swing.JButton();
        btnSig = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();
        txtFieldFechaNacimiento = new javax.swing.JTextField();
        txtFieldApellidoMat = new javax.swing.JTextField();
        txtFieldApellidoPat = new javax.swing.JTextField();
        txtFieldNombre = new javax.swing.JTextField();
        lblIconos = new javax.swing.JLabel();
        lblRecuadro = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setResizable(false);

        pnlFondo.setFocusable(false);
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlFondo.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 120, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/atrasRegister.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtrasMouseEntered(evt);
            }
        });
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        pnlFondo.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        btnSig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flechaSig..png"))); // NOI18N
        btnSig.setBorder(null);
        btnSig.setBorderPainted(false);
        btnSig.setContentAreaFilled(false);
        btnSig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSigMouseEntered(evt);
            }
        });
        btnSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSig, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, -1, -1));

        btnRetiroSinCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiro.png"))); // NOI18N
        btnRetiroSinCuenta.setBorder(null);
        btnRetiroSinCuenta.setBorderPainted(false);
        btnRetiroSinCuenta.setContentAreaFilled(false);
        btnRetiroSinCuenta.setFocusable(false);
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRetiroSinCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 423, -1, -1));

        txtFieldFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldFechaNacimiento.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldFechaNacimiento.setText("Fecha Nacimiento");
        txtFieldFechaNacimiento.setBorder(null);
        txtFieldFechaNacimiento.setFocusable(false);
        txtFieldFechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldFechaNacimientoFocusLost(evt);
            }
        });
        txtFieldFechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldFechaNacimientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldFechaNacimientoMouseExited(evt);
            }
        });
        txtFieldFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldFechaNacimientoActionPerformed(evt);
            }
        });
        txtFieldFechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldFechaNacimientoKeyTyped(evt);
            }
        });
        pnlFondo.add(txtFieldFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 424, 100, -1));

        txtFieldApellidoMat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldApellidoMat.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldApellidoMat.setText("Apellido Mat.");
        txtFieldApellidoMat.setBorder(null);
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
        pnlFondo.add(txtFieldApellidoMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 378, 310, -1));

        txtFieldApellidoPat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldApellidoPat.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldApellidoPat.setText("Apellido Pat.");
        txtFieldApellidoPat.setBorder(null);
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
        pnlFondo.add(txtFieldApellidoPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 334, 310, -1));

        txtFieldNombre.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldNombre.setText("Nombre");
        txtFieldNombre.setBorder(null);
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
        pnlFondo.add(txtFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 310, -1));

        lblIconos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblIconos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lineaCredenciales.png"))); // NOI18N
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

    private void txtFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombreActionPerformed

    }//GEN-LAST:event_txtFieldNombreActionPerformed

//De aquí hacia abajo son algunos métodos que validan si el mouse entró, salió, etc de un txtField para dejar al usuario escribir

    private void txtFieldNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseEntered
        if (txtFieldNombre.getText().equals("Nombre"))
            txtFieldNombre.setText("");
    }//GEN-LAST:event_txtFieldNombreMouseEntered

    private void txtFieldNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseExited
        if (txtFieldNombre.getText().equals("")) {
            txtFieldNombre.setText("Nombre");
        } else if (!txtFieldNombre.getText().equals("Nombre")) {
            evt.consume();
        }

    }//GEN-LAST:event_txtFieldNombreMouseExited

    private void txtFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusLost
        if (txtFieldNombre.getText().equals("")) {
            txtFieldNombre.setText("Nombre");
        }
    }//GEN-LAST:event_txtFieldNombreFocusLost

    private void txtFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyTyped
        txtFieldNombre.setText(txtFieldNombre.getText().trim());
        if (txtFieldNombre.getText().length() >= 50) {
            evt.consume();
        }

        if (txtFieldNombre.getText().equals("Nombre")) {
            txtFieldNombre.setText("");
        }
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume(); // Descarta el evento si no es una letra, tecla de borrado o tecla de suprimir.
        }
    }//GEN-LAST:event_txtFieldNombreKeyTyped

    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed

    private void txtFieldApellidoPatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatFocusLost
        if (txtFieldApellidoPat.getText().equals("")) {
            txtFieldApellidoPat.setText("Apellido Pat.");
        }
    }//GEN-LAST:event_txtFieldApellidoPatFocusLost

    private void txtFieldApellidoPatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatMouseEntered
        if (txtFieldApellidoPat.getText().equals("Apellido Pat."))
            txtFieldApellidoPat.setText("");
    }//GEN-LAST:event_txtFieldApellidoPatMouseEntered

    private void txtFieldApellidoPatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatMouseExited
        if (txtFieldApellidoPat.getText().equals("")) {
            txtFieldApellidoPat.setText("Apellido Pat.");
        } else if (!txtFieldApellidoPat.getText().equals("Apellido Pat.")) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtFieldApellidoPatMouseExited

    private void txtFieldApellidoPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoPatActionPerformed

    private void txtFieldApellidoPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatKeyTyped
        txtFieldApellidoPat.setText(txtFieldApellidoPat.getText().trim());
        if (txtFieldApellidoPat.getText().length() >= 50) {
            evt.consume();
        }
        if (txtFieldApellidoPat.getText().equals("Apellido Pat.")) {
            txtFieldApellidoPat.setText("");
        }
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume(); // Descarta el evento si no es una letra, tecla de borrado o tecla de suprimir.
        }
    }//GEN-LAST:event_txtFieldApellidoPatKeyTyped

    private void txtFieldApellidoMatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatFocusLost
        if (txtFieldApellidoMat.getText().equals("")) {
            txtFieldApellidoMat.setText("Apellido Mat.");
        }
    }//GEN-LAST:event_txtFieldApellidoMatFocusLost

    private void txtFieldApellidoMatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatMouseEntered
        if (txtFieldApellidoMat.getText().equals("Apellido Mat."))
            txtFieldApellidoMat.setText("");
    }//GEN-LAST:event_txtFieldApellidoMatMouseEntered

    private void txtFieldApellidoMatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatMouseExited
        if (txtFieldApellidoMat.getText().equals("")) {
            txtFieldApellidoMat.setText("Apellido Mat.");
        } else if (!txtFieldApellidoMat.getText().equals("Apellido Mat.")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldApellidoMatMouseExited

    private void txtFieldApellidoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoMatActionPerformed

    private void txtFieldApellidoMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatKeyTyped
        txtFieldApellidoMat.setText(txtFieldApellidoMat.getText().trim());
        if (txtFieldApellidoMat.getText().length() >= 50) {
            evt.consume();
        }
        if (txtFieldApellidoMat.getText().equals("Apellido Mat.")) {
            txtFieldApellidoMat.setText("");
        }
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume(); // Descarta el evento si no es una letra, tecla de borrado o tecla de suprimir.
        }
    }//GEN-LAST:event_txtFieldApellidoMatKeyTyped

    private void txtFieldFechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldFechaNacimientoFocusLost

    }//GEN-LAST:event_txtFieldFechaNacimientoFocusLost

    private void txtFieldFechaNacimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldFechaNacimientoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldFechaNacimientoMouseEntered

    private void txtFieldFechaNacimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldFechaNacimientoMouseExited

    }//GEN-LAST:event_txtFieldFechaNacimientoMouseExited

    private void txtFieldFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldFechaNacimientoActionPerformed

    private void txtFieldFechaNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldFechaNacimientoKeyTyped

    }//GEN-LAST:event_txtFieldFechaNacimientoKeyTyped

    /**
     * Pasamos al FrmRegister 2 el cual recibe los datos de este cliente y su
     * clientesDAO
     *
     * @param evt se ejecuta al activarse el evento
     */
    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed
        if (this.jDateChooser1.getDate() == null) {
            new JOptionPane().showMessageDialog(this, "Llene la fecha por favor", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.txtFieldApellidoMat.getText().equals("Apellido Mat.")
                || this.txtFieldApellidoPat.getText().equals("Apellido Pat.") || this.txtFieldNombre.getText().equals("Nombre")) {
            new JOptionPane().showMessageDialog(this, "Asegúrese de llenar todos los campos", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int ano = this.jDateChooser1.getDate().getYear();
        int mes = this.jDateChooser1.getDate().getMonth();
        int dia = this.jDateChooser1.getDate().getDay();

        Date fechaNacimiento = new Date(ano, mes, dia);

        this.cliente = new Cliente(fechaNacimiento, this.txtFieldNombre.getText(), this.txtFieldApellidoPat.getText(), this.txtFieldApellidoMat.getText());
        new FrmRegister2(cliente, this.clientesDao).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSigActionPerformed

    private void btnSigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSigMouseEntered

    }//GEN-LAST:event_btnSigMouseEntered
    //De aquí hacia abajo son algunos métodos que validan si el mouse entró, salió, etc de un txtField para dejar al usuario escribir

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        new FrmLogin(this.clientesDao).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtFieldApellidoPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldApellidoPatKeyReleased
        txtFieldApellidoPat.setText(txtFieldApellidoPat.getText().trim());
    }//GEN-LAST:event_txtFieldApellidoPatKeyReleased

    private void txtFieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyReleased
        // TODO add your handling code here:
        txtFieldNombre.setText(txtFieldNombre.getText().trim());
    }//GEN-LAST:event_txtFieldNombreKeyReleased

    private void txtFieldApellidoMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldApellidoMatKeyReleased
        // TODO add your handling code here:
        txtFieldApellidoMat.setText(txtFieldApellidoMat.getText().trim());
    }//GEN-LAST:event_txtFieldApellidoMatKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JButton btnSig;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIconos;
    private javax.swing.JLabel lblRecuadro;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtFieldApellidoMat;
    private javax.swing.JTextField txtFieldApellidoPat;
    private javax.swing.JTextField txtFieldFechaNacimiento;
    private javax.swing.JTextField txtFieldNombre;
    // End of variables declaration//GEN-END:variables
}
