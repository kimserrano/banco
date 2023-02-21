/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import dominio.Cliente;
import dominio.CuentasClientesRecord;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.TransaccionesDAO;
import interfaces.IClientesDAO;
import interfaces.ICuentasClientesDAO;
import interfaces.ITransaccionesDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author eruma
 */
public class FrmCuentas extends javax.swing.JFrame {

    private final ICuentasClientesDAO cuentasClientesDAO;
    private final Cliente cliente;
    private ArrayList<CuentasClientesRecord> cuentas;

    /**
     * Creates new form Cuentas
     */
    public FrmCuentas(ICuentasClientesDAO cuentasClientesDAO, Cliente cliente) {
        initComponents();
        this.cuentasClientesDAO = cuentasClientesDAO;
        this.cliente = cliente;
        this.cargarCuentas();
        mostrarSaldo();
    }

    /**
     * Metodo vacío que carga todas las cuentas del cliente a la comboBox
     * mediante un ArrayList
     */
    private void cargarCuentas() {
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
     * Metodo que carga el salgo de la cuenta que esté seleccionada en la
     * comboBox cuentas para mostrarlo
     */
    
    private void mostrarSaldo() {
        for (int i = 0; i < this.cuentas.size(); i++) {
            if (this.cBoxCuentas.getModel().getSelectedItem().equals(cuentas.get(i).nombre())) {
                this.lblNumSaldo.setText(String.valueOf(this.cuentas.get(i).saldo()));
                this.lblNumTarjeta.setText(this.cuentas.get(i).numCuenta());
            }
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

        pnlFondo = new javax.swing.JPanel();
        pnlTablaHistoriales = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnAnadirFondos = new javax.swing.JButton();
        btnDesconectarse = new javax.swing.JButton();
        btnTransacciones = new javax.swing.JButton();
        btnCuenta = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnAgregarCuenta = new javax.swing.JButton();
        lblNumTarjeta = new javax.swing.JLabel();
        cBoxCuentas = new javax.swing.JComboBox<>();
        btnUser = new javax.swing.JButton();
        lblNumSaldo = new javax.swing.JLabel();
        lblTarjeta = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblOperacion = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHistorial = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblCuentas = new javax.swing.JLabel();
        lblPestanaTransac = new javax.swing.JLabel();
        lblPestanaUser = new javax.swing.JLabel();
        lblPestanaCuenta = new javax.swing.JLabel();
        lblRecuadro = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cuentas");
        setResizable(false);

        pnlFondo.setPreferredSize(new java.awt.Dimension(1200, 800));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Operación", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlTablaHistoriales.setViewportView(tblClientes);

        pnlFondo.add(pnlTablaHistoriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 320, 390));

        btnAnadirFondos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/btnAnadirFondos.png"))); // NOI18N
        btnAnadirFondos.setBorder(null);
        btnAnadirFondos.setBorderPainted(false);
        btnAnadirFondos.setContentAreaFilled(false);
        btnAnadirFondos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirFondosActionPerformed(evt);
            }
        });
        pnlFondo.add(btnAnadirFondos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, -1));

        btnDesconectarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/desconectarse.png"))); // NOI18N
        btnDesconectarse.setBorder(null);
        btnDesconectarse.setBorderPainted(false);
        btnDesconectarse.setContentAreaFilled(false);
        btnDesconectarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarseActionPerformed(evt);
            }
        });
        pnlFondo.add(btnDesconectarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 740, -1, -1));

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
        pnlFondo.add(btnTransacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 110, 50, -1));

        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/btnCuentas.png"))); // NOI18N
        btnCuenta.setBorder(null);
        btnCuenta.setBorderPainted(false);
        btnCuenta.setContentAreaFilled(false);
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 120, 50, -1));

        btnEliminarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/eliminarCuenta.png"))); // NOI18N
        btnEliminarCuenta.setBorder(null);
        btnEliminarCuenta.setBorderPainted(false);
        btnEliminarCuenta.setContentAreaFilled(false);
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEliminarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, 20));

        btnAgregarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/anadirCuenta.png"))); // NOI18N
        btnAgregarCuenta.setBorder(null);
        btnAgregarCuenta.setBorderPainted(false);
        btnAgregarCuenta.setContentAreaFilled(false);
        btnAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentaActionPerformed(evt);
            }
        });
        pnlFondo.add(btnAgregarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, 20));

        lblNumTarjeta.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblNumTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        lblNumTarjeta.setFocusable(false);
        lblNumTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblNumTarjetaKeyTyped(evt);
            }
        });
        pnlFondo.add(lblNumTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 220, 30));

        cBoxCuentas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cBoxCuentasItemStateChanged(evt);
            }
        });
        cBoxCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cBoxCuentasMouseClicked(evt);
            }
        });
        cBoxCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxCuentasActionPerformed(evt);
            }
        });
        pnlFondo.add(cBoxCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 190, -1));

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/btnUser.png"))); // NOI18N
        btnUser.setBorder(null);
        btnUser.setBorderPainted(false);
        btnUser.setContentAreaFilled(false);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        pnlFondo.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 111, 40, -1));

        lblNumSaldo.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblNumSaldo.setForeground(new java.awt.Color(153, 153, 153));
        lblNumSaldo.setFocusable(false);
        lblNumSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblNumSaldoKeyTyped(evt);
            }
        });
        pnlFondo.add(lblNumSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 200, 30));

        lblTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/tarjeta.png"))); // NOI18N
        pnlFondo.add(lblTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        lblEstado.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(153, 153, 153));
        lblEstado.setText("Estado");
        pnlFondo.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 200, 60, 20));

        lblOperacion.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblOperacion.setForeground(new java.awt.Color(153, 153, 153));
        lblOperacion.setText("Operación");
        pnlFondo.add(lblOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 200, 90, 20));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(153, 153, 153));
        lblFecha.setText("Fecha");
        pnlFondo.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 50, 20));

        lblHistorial.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblHistorial.setForeground(new java.awt.Color(153, 153, 153));
        lblHistorial.setText("Historial:");
        pnlFondo.add(lblHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 80, 40));

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(153, 153, 153));
        lblSaldo.setText("Saldo:");
        pnlFondo.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 70, 30));

        lblCuentas.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblCuentas.setForeground(new java.awt.Color(153, 153, 153));
        lblCuentas.setText("Cuenta:");
        pnlFondo.add(lblCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 70, 40));

        lblPestanaTransac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        pnlFondo.add(lblPestanaTransac, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1080, -1));

        lblPestanaUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        pnlFondo.add(lblPestanaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        lblPestanaCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/penstana.png"))); // NOI18N
        pnlFondo.add(lblPestanaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblRecuadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuentas/recuadro.png"))); // NOI18N
        pnlFondo.add(lblRecuadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png"))); // NOI18N
        lblFondo.setAlignmentY(0.0F);
        lblFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxCuentasActionPerformed
        mostrarSaldo();
    }//GEN-LAST:event_cBoxCuentasActionPerformed

    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
            String respuesta = new JOptionPane().showInputDialog(this, "Para eliminar esta cuenta escriba ' SI ' ","CUIDADO");
            if(respuesta.equals("SI")){
                try {
                    this.cuentasClientesDAO.eliminar(cuentasClientesDAO.consultar((String) this.cBoxCuentas.getModel().getSelectedItem(), cliente.getId()).idCuentasClientes());
                    new FrmCuentas(this.cuentasClientesDAO,this.cliente).setVisible(true);
                    this.dispose();
                } catch (PersistenciaException ex) {
                    Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void lblNumTarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblNumTarjetaKeyTyped
        // TODO add your handling code here:


    }//GEN-LAST:event_lblNumTarjetaKeyTyped


    private void cBoxCuentasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cBoxCuentasItemStateChanged
//        CuentasClientesRecord cuentaSeleccionada = (CuentasClientesRecord) cBoxCuentas.getSelectedItem();
//        String saldoCadena = Float.toString(cuentaSeleccionada.saldo());
//        lblSaldo1.setText(saldoCadena);
    }//GEN-LAST:event_cBoxCuentasItemStateChanged

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCuentaActionPerformed

    private void btnDesconectarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarseActionPerformed
        
        new FrmLogin(new ClientesDAO(cuentasClientesDAO.getGENERADOR_CONEXIONES())).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDesconectarseActionPerformed


   
    
    private void cargarSaldoALista(CuentasClientesRecord cuenta){
        for(int i=0;i<this.cuentas.size();i++){
            if(this.cuentas.get(i).idCuentasClientes()==cuenta.idCuentasClientes()){
                cuentas.set(i, new CuentasClientesRecord(cuenta.idCuentasClientes(), cuenta.fechaHoraApertura(), cuenta.nombre(),Float.parseFloat(this.lblNumSaldo.getText()) , cuenta.numCuenta(), cuenta.idClientes()));
            }
        }
    }
    
    private void btnAnadirFondosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirFondosActionPerformed
        try {
            String saldoAnadido = new JOptionPane().showInputDialog(this, "Ingrese la cantidad a añadir");
            if (saldoAnadido.matches("^([+]?\\d*\\.?\\d*)$")) {

                CuentasClientesRecord cuentaParaAnadir = this.cuentasClientesDAO.consultar((String) cBoxCuentas.getModel().getSelectedItem(), this.cliente.getId());
                cuentaParaAnadir = this.cuentasClientesDAO.anadirSaldo(Float.parseFloat(saldoAnadido), cuentaParaAnadir.idCuentasClientes());

                //Se actualiza el saldo en el label
                this.lblNumSaldo.setText(String.valueOf((Float) cuentaParaAnadir.saldo()));
                new JOptionPane().showMessageDialog(this, "🔥🔥Saldo añadido bro🔥🔥", "¡Bien!", JOptionPane.INFORMATION_MESSAGE);
                this.cargarSaldoALista(cuentaParaAnadir);
            } else {
                new JOptionPane().showMessageDialog(this, "Formato incorrecto, recuerdo usar solo numeros y un punto para decimales y no se acpetan negativos", "¡Aviso!", JOptionPane.ERROR_MESSAGE);

            }
        } catch (PersistenciaException e) {
            new JOptionPane().showMessageDialog(this, "Formato incorrecto, recuerdo usar solo numeros y un punto para decimales", "¡Aviso!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, e);

        }
    }//GEN-LAST:event_btnAnadirFondosActionPerformed

    private void btnTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionesActionPerformed
        ITransaccionesDAO transaccionesDAO = new TransaccionesDAO(this.cuentasClientesDAO.getGENERADOR_CONEXIONES());
        new FrmTransacciones(transaccionesDAO, this.cliente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransaccionesActionPerformed

    private void cBoxCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cBoxCuentasMouseClicked

    }//GEN-LAST:event_cBoxCuentasMouseClicked

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
            new FrmUsuario(new ClientesDAO(this.cuentasClientesDAO.getGENERADOR_CONEXIONES()),this.cliente).setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
            new FrmRegistroCuentasBancarias(cuentasClientesDAO, cliente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

    private void lblNumSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblNumSaldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNumSaldoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCuenta;
    private javax.swing.JButton btnAnadirFondos;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnDesconectarse;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnTransacciones;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox<String> cBoxCuentas;
    private javax.swing.JLabel lblCuentas;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblNumSaldo;
    private javax.swing.JLabel lblNumTarjeta;
    private javax.swing.JLabel lblOperacion;
    private javax.swing.JLabel lblPestanaCuenta;
    private javax.swing.JLabel lblPestanaTransac;
    private javax.swing.JLabel lblPestanaUser;
    private javax.swing.JLabel lblRecuadro;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTarjeta;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JScrollPane pnlTablaHistoriales;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
