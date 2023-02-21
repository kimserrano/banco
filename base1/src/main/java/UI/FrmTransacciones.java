/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import dominio.Cliente;
import dominio.CuentasClientesRecord;
import dominio.RetirosSinCuenta;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.CuentasClientesDAO;
import implementaciones.RetirosSinCuentaDAO;
import interfaces.ICuentasClientesDAO;
import interfaces.IRetiroSinCuentaDAO;
import interfaces.ITransaccionesDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kim y Elmer
 */
public class FrmTransacciones extends javax.swing.JFrame {

    private final ITransaccionesDAO transaccionesDAO;
    private final Cliente cliente;
    private ArrayList<CuentasClientesRecord> cuentas;
    private final ICuentasClientesDAO cuentasClientesDAO;
    private final IRetiroSinCuentaDAO restiroSinCuentaDAO;

    /**
     * Creates new form FrmTransacciones
     */
    public FrmTransacciones(ITransaccionesDAO transaccionesDAO, Cliente cliente) {
        initComponents();
        this.transaccionesDAO = transaccionesDAO;
        this.cuentasClientesDAO = new CuentasClientesDAO(transaccionesDAO.getGENERADOR_CONEXIONES());
        this.restiroSinCuentaDAO = new RetirosSinCuentaDAO(transaccionesDAO.getGENERADOR_CONEXIONES());
        this.cliente = cliente;
        cargarCuentas();
        mostrarSaldo();
    }

    public void cargarCuentas() {
        try {
            cuentas = cuentasClientesDAO.cargarCuentas(cliente.getId());
            for (int i = 0; i < cuentas.size(); i++) {
                if (cuentas.get(i) != null) {
                    this.cBoxCuentas.addItem(cuentas.get(i).nombre());
                }
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        cBoxCuentas = new javax.swing.JComboBox<>();
        btnTransaccion = new javax.swing.JButton();
        btnTransacciones = new javax.swing.JButton();
        btnCuenta = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnDesconectarse = new javax.swing.JButton();
        lblPestanaCuenta = new javax.swing.JLabel();
        lblPestanaUser = new javax.swing.JLabel();
        lblPestanaTransac = new javax.swing.JLabel();
        lblCuentas = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblNumSaldo = new javax.swing.JLabel();
        lblRecuadro = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transferencias🔥");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cBoxCuentas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cBoxCuentasItemStateChanged(evt);
            }
        });
        cBoxCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxCuentasActionPerformed(evt);
            }
        });
        jPanel1.add(cBoxCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 190, -1));

        btnTransaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgTransacciones/btnTransferencia.png"))); // NOI18N
        btnTransaccion.setBorder(null);
        btnTransaccion.setBorderPainted(false);
        btnTransaccion.setContentAreaFilled(false);
        btnTransaccion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSinCuentaSelected.png"))); // NOI18N
        btnTransaccion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSinCuentaSelected.png"))); // NOI18N
        btnTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, -1));

        btnTransacciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgTransacciones/btnTransaccionesSelected.png"))); // NOI18N
        btnTransacciones.setBorder(null);
        btnTransacciones.setBorderPainted(false);
        btnTransacciones.setContentAreaFilled(false);
        btnTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 110, 50, -1));

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

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/btnUser.png"))); // NOI18N
        btnUser.setBorder(null);
        btnUser.setBorderPainted(false);
        btnUser.setContentAreaFilled(false);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 111, 40, -1));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSinCuenta.png"))); // NOI18N
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSinCuentaSelected.png"))); // NOI18N
        btnRegistrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnRetiroSinCuentaSelected.png"))); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, -1, -1));

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

        lblPestanaCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        jPanel1.add(lblPestanaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        lblPestanaUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        jPanel1.add(lblPestanaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 1140, -1));

        lblPestanaTransac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        jPanel1.add(lblPestanaTransac, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1080, -1));

        lblCuentas.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblCuentas.setForeground(new java.awt.Color(153, 153, 153));
        lblCuentas.setText("Cuenta:");
        jPanel1.add(lblCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 70, 40));

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(153, 153, 153));
        lblSaldo.setText("Saldo:");
        jPanel1.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 70, 30));

        lblNumSaldo.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblNumSaldo.setForeground(new java.awt.Color(153, 153, 153));
        lblNumSaldo.setFocusable(false);
        lblNumSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblNumSaldoKeyTyped(evt);
            }
        });
        jPanel1.add(lblNumSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 200, 30));

        lblRecuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgTransacciones/recuadro.png"))); // NOI18N
        jPanel1.add(lblRecuadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png"))); // NOI18N
        lblFondo.setAlignmentY(0.0F);
        lblFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxCuentasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cBoxCuentasItemStateChanged
        //        CuentasClientesRecord cuentaSeleccionada = (CuentasClientesRecord) cBoxCuentas.getSelectedItem();
        //        String saldoCadena = Float.toString(cuentaSeleccionada.saldo());
        //        lblSaldo1.setText(saldoCadena);
    }//GEN-LAST:event_cBoxCuentasItemStateChanged

    private void cBoxCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxCuentasActionPerformed
        mostrarSaldo();
    }//GEN-LAST:event_cBoxCuentasActionPerformed

    private void lblNumSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblNumSaldoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_lblNumSaldoKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        String montoRetirar = null;
        try {
            montoRetirar = new JOptionPane().showInputDialog(this, "Monto que deseas retirar");
            if (montoRetirar.matches("^([+]?\\d*\\.?\\d*)$")) {

                float monto = Float.parseFloat(montoRetirar);
                CuentasClientesRecord cuenta = this.cuentasClientesDAO.consultar((String) this.cBoxCuentas.getModel().getSelectedItem(), this.cliente.getId()); 
                int idRetiroSinCuenta = this.restiroSinCuentaDAO.crearRetiro(cuenta.idCuentasClientes(), monto);
                System.out.println("PRIMARY KEY   "+ idRetiroSinCuenta);
                RetirosSinCuenta retiroCreado =this.restiroSinCuentaDAO.consultar(idRetiroSinCuenta);
                new JOptionPane().showMessageDialog(this, "Tu folio es: "+ retiroCreado.getFolio()+"  y tu clave es: "+
                        retiroCreado.getClave(), "Información para cobrar retiro", JOptionPane.YES_OPTION);
            } else {
                new JOptionPane().showMessageDialog(this, "Formato incorrecto, recuerdo usar solo numeros, no se aceptan negativos", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
            }

        } catch (PersistenciaException e) {
            Logger.getLogger(FrmTransacciones.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * Metodo que carga el salgo de la cuenta que esté seleccionada en la
     * comboBox cuentas para mostrarlo
     */
    public void mostrarSaldo() {
        for (int i = 0; i < this.cuentas.size(); i++) {
            if (this.cBoxCuentas.getModel().getSelectedItem().equals(cuentas.get(i).nombre())) {
                this.lblNumSaldo.setText(String.valueOf(this.cuentas.get(i).saldo()));
            }
        }
    }

    private void btnTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionActionPerformed
        String numCuentaTransferencia = null;
        String montoTransferencia = null;
        try {
            numCuentaTransferencia = new JOptionPane().showInputDialog(this, "Número de cuenta al que quieres transferir");
            if (numCuentaTransferencia.matches("^([+]?\\d*\\.?\\d*)$")) {
                montoTransferencia = new JOptionPane().showInputDialog(this, "Monto que deseas transferir");
                if (!montoTransferencia.matches("^([+]?\\d*\\.?\\d*)$")) {
                    new JOptionPane().showMessageDialog(this, "Formato incorrecto, recuerdo usar solo numeros y un punto para decimales, no se aceptan negativos", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
                }
                int numCuenta = Integer.parseInt(numCuentaTransferencia);
                float monto = Float.parseFloat(montoTransferencia);
                CuentasClientesRecord cuenta = this.cuentasClientesDAO.consultar((String) this.cBoxCuentas.getModel().getSelectedItem(), this.cliente.getId());
                this.transaccionesDAO.realizarTransferencia(cuenta.idCuentasClientes(), numCuenta, monto);
            } else {
                new JOptionPane().showMessageDialog(this, "Formato incorrecto, recuerdo usar solo numeros, no se aceptan negativos", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
            }

        } catch (PersistenciaException e) {
            Logger.getLogger(FrmTransacciones.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnTransaccionActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed

        new FrmCuentas(cuentasClientesDAO, cliente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCuentaActionPerformed

    private void btnTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransaccionesActionPerformed

    private void btnDesconectarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarseActionPerformed

        new FrmLogin(new ClientesDAO(cuentasClientesDAO.getGENERADOR_CONEXIONES())).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDesconectarseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnDesconectarse;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnTransaccion;
    private javax.swing.JButton btnTransacciones;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox<String> cBoxCuentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCuentas;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNumSaldo;
    private javax.swing.JLabel lblPestanaCuenta;
    private javax.swing.JLabel lblPestanaTransac;
    private javax.swing.JLabel lblPestanaUser;
    private javax.swing.JLabel lblRecuadro;
    private javax.swing.JLabel lblSaldo;
    // End of variables declaration//GEN-END:variables
}
