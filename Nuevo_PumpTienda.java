package interfaz;

import AppPackage.AnimationClass;
import static interfaz.Foro.id;
import static interfaz.Pump_It.apellido;
import static interfaz.Pump_It.correo;
import static interfaz.Pump_It.id;
import static interfaz.Pump_It.idBiblioteca;
import static interfaz.Pump_It.juego;
import static interfaz.Pump_It.nacimiento;
import static interfaz.Pump_It.nombre;
import static interfaz.Pump_It.pass;
import java.awt.Color;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marval
 */
public class Nuevo_PumpTienda extends javax.swing.JFrame {

    /**
     * Creates new form Nuevo_PumpTienda
     */
    public Nuevo_PumpTienda() {
        initComponents();
        getContentPane().setBackground(Color.darkGray);
        JTableHeader th; 
        th = dgvVideojuegos.getTableHeader(); 
        Font fuente = new Font("Myriad Pro", Font.ITALIC, 20); 
        th.setFont(fuente); 
        
        m = (DefaultTableModel) dgvVideojuegos.getModel();
        llenarVideoJuegos();
        JTableHeader header = dgvVideojuegos.getTableHeader();

        dgvVideojuegos.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String N[] = new String[m.getRowCount()];
                int L[] = new int[m.getRowCount()];
                int col = dgvVideojuegos.columnAtPoint(e.getPoint());
                switch (col) {
                    case (0):
                        for (int i = 0; i < m.getRowCount(); i++) {
                            N[i] = m.getValueAt(i, 0).toString();
                        }
                        if (!tbtOrd.isSelected()) {
                            Data.metodosOrd.quickSortString(N, 0, N.length - 1);
                            for (int i = 0; i < m.getRowCount(); i++) {
                                for (int j = 0; j < N.length; j++) {
                                    if (N[i].equals(m.getValueAt(j, 0))) {
                                        m.moveRow(j, j, i);
                                    }
                                }
                            }
                        } else {
                            Data.metodosOrd.quickSortStringDes(N, 0, N.length - 1);
                            for (int i = 0; i < m.getRowCount(); i++) {
                                for (int j = 0; j < N.length; j++) {
                                    if (N[i].equals(m.getValueAt(j, 0))) {
                                        m.moveRow(j, j, i);
                                    }//if
                                }//for
                            }//for
                        }//else                             
                        break;
                    case 1:
                        for (int i = 0; i < m.getRowCount(); i++) {
                            L[i] = Integer.parseInt(m.getValueAt(i, 1).toString());
                        }
                        if (!tbtOrd.isSelected()) {
                            Data.metodosOrd.quickSort(L, 0, L.length - 1);
                            for (int i = 0; i < m.getRowCount(); i++) {
                                for (int j = 0; j < N.length; j++) {
                                    if (L[i] == Integer.parseInt(m.getValueAt(j, 1).toString())) {
                                        m.moveRow(j, j, i);

                                    }
                                }
                            }
                        } else {
                            Data.metodosOrd.quickSortDes(L, 0, L.length - 1);
                            for (int i = 0; i < m.getRowCount(); i++) {
                                for (int j = 0; j < N.length; j++) {
                                    if (L[i] == Integer.parseInt(m.getValueAt(j, 1).toString())) {
                                        m.moveRow(j, j, i);

                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < m.getRowCount(); i++) {
                            L[i] = Integer.parseInt(m.getValueAt(i, 2).toString());
                        }
                        if (!tbtOrd.isSelected()) {
                            Data.metodosOrd.quickSort(L, 0, L.length - 1);
                            for (int i = 0; i < m.getRowCount(); i++) {
                                for (int j = 0; j < N.length; j++) {
                                    if (L[i] == Integer.parseInt(m.getValueAt(j, 2).toString())) {
                                        m.moveRow(j, j, i);

                                    }
                                }
                            }
                        } else {
                            Data.metodosOrd.quickSortDes(L, 0, L.length - 1);
                            for (int i = 0; i < m.getRowCount(); i++) {
                                for (int j = 0; j < N.length; j++) {
                                    if (L[i] == Integer.parseInt(m.getValueAt(j, 2).toString())) {
                                        m.moveRow(j, j, i);

                                    }
                                }
                            }
                        }
                        break;
                    case (3):
                        for (int i = 0; i < m.getRowCount(); i++) {
                            N[i] = m.getValueAt(i, 3).toString();
                        }
                        if (!tbtOrd.isSelected()) {
                            Data.metodosOrd.quickSortString(N, 0, N.length - 1);
                            for (int i = 0; i < m.getRowCount(); i++) {
                                for (int j = 0; j < N.length; j++) {
                                    if (N[i].equals(m.getValueAt(j, 3))) {
                                        m.moveRow(j, j, i);
                                    }
                                }
                            }
                        } else {
                            Data.metodosOrd.quickSortStringDes(N, 0, N.length - 1);
                            for (int i = 0; i < m.getRowCount(); i++) {
                                for (int j = 0; j < N.length; j++) {
                                    if (N[i].equals(m.getValueAt(j, 3))) {
                                        m.moveRow(j, j, i);
                                    }//if
                                }//for
                            }//for
                        }//else                             
                        break;
                }//Switch de columnas

            }//switch de "MouseReleased"

        });
    }//public nuevo_pumptienda()

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        btnLibreria = new javax.swing.JButton();
        btnTienda = new javax.swing.JButton();
        btnForo = new javax.swing.JButton();
        tbtOrd = new javax.swing.JToggleButton();
        btnAnade = new javax.swing.JButton();
        btnCuenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvVideojuegos = new javax.swing.JTable();
        lblError = new javax.swing.JLabel();
        lblbus = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtPass1 = new javax.swing.JPasswordField();
        txtPass2 = new javax.swing.JPasswordField();
        txtBiblio = new javax.swing.JTextField();
        txtCE = new javax.swing.JTextField();
        lblFondoLogin1 = new javax.swing.JLabel();
        btnAcep = new javax.swing.JButton();
        lblUsua = new javax.swing.JLabel();
        lblreg = new javax.swing.JLabel();
        lblAP = new javax.swing.JLabel();
        lblFechNac = new javax.swing.JLabel();
        lblContra1 = new javax.swing.JLabel();
        lblContra2 = new javax.swing.JLabel();
        lblBiblio = new javax.swing.JLabel();
        lblCE = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tienda");
        setMaximumSize(new java.awt.Dimension(1160, 600));
        setMinimumSize(new java.awt.Dimension(1160, 600));
        setPreferredSize(new java.awt.Dimension(1160, 600));
        setSize(new java.awt.Dimension(1160, 600));
        getContentPane().setLayout(null);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnLibreria.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        btnLibreria.setForeground(new java.awt.Color(255, 153, 51));
        btnLibreria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Bag-icon.png"))); // NOI18N
        btnLibreria.setText("Librería");
        btnLibreria.setFocusable(false);
        btnLibreria.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLibreria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibreriaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLibreria);

        btnTienda.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        btnTienda.setForeground(new java.awt.Color(255, 153, 51));
        btnTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Basket-icon.png"))); // NOI18N
        btnTienda.setText("Tienda");
        btnTienda.setEnabled(false);
        btnTienda.setFocusable(false);
        btnTienda.setIconTextGap(6);
        btnTienda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiendaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTienda);

        btnForo.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        btnForo.setForeground(new java.awt.Color(255, 153, 51));
        btnForo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Chat-6-icon.png"))); // NOI18N
        btnForo.setText("Foro");
        btnForo.setFocusable(false);
        btnForo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnForo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnForo);

        tbtOrd.setBackground(new java.awt.Color(255, 153, 51));
        tbtOrd.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        tbtOrd.setForeground(new java.awt.Color(255, 153, 51));
        tbtOrd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Arrow-Updown-icon.png"))); // NOI18N
        tbtOrd.setText("Orden");
        tbtOrd.setContentAreaFilled(false);
        jToolBar1.add(tbtOrd);

        btnAnade.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        btnAnade.setForeground(new java.awt.Color(255, 153, 51));
        btnAnade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Plus-icon.png"))); // NOI18N
        btnAnade.setText("¡Añade a la biblioteca!");
        btnAnade.setEnabled(false);
        btnAnade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAnade);

        btnCuenta.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        btnCuenta.setForeground(new java.awt.Color(255, 153, 51));
        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Settings-2-icon.png"))); // NOI18N
        btnCuenta.setText("Cuenta");
        btnCuenta.setFocusable(false);
        btnCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCuenta);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 1047, 80);

        dgvVideojuegos.setBackground(new java.awt.Color(51, 51, 51));
        dgvVideojuegos.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        dgvVideojuegos.setForeground(new java.awt.Color(255, 153, 51));
        dgvVideojuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Rating", "Desarrolladora"
            }
        ));
        dgvVideojuegos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvVideojuegosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvVideojuegos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 227, 470, 360);

        lblError.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 153, 51));
        lblError.setOpaque(true);
        //lblError.setVisible(false);
        getContentPane().add(lblError);
        lblError.setBounds(331, 115, 359, 33);

        lblbus.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblbus.setForeground(new java.awt.Color(255, 153, 51));
        lblbus.setText("Buscar");
        getContentPane().add(lblbus);
        lblbus.setBounds(10, 122, 51, 19);

        txtBuscar.setBackground(new java.awt.Color(51, 51, 51));
        txtBuscar.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 153, 51));
        txtBuscar.setText("Introduce el nombre del juego...");
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(65, 122, 223, 21);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search-icon (3).png"))); // NOI18N
        btnBuscar.setAutoscrolls(true);
        btnBuscar.setBorder(null);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search-icon (2).png"))); // NOI18N
        btnBuscar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search-icon (2).png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(294, 115, 33, 33);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 166, 1228, 19);

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Lista de juegos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 191, 151, 25);
        getContentPane().add(lbl1);
        lbl1.setBounds(331, 87, 359, 22);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(490, 230, 641, 360);

        txtNombre.setBackground(new java.awt.Color(51, 51, 51));
        txtNombre.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(1160, 70, 140, 30);

        txtApellido.setBackground(new java.awt.Color(51, 51, 51));
        txtApellido.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        getContentPane().add(txtApellido);
        txtApellido.setBounds(1160, 130, 140, 30);

        txtMes.setBackground(new java.awt.Color(51, 51, 51));
        txtMes.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        txtMes.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtMes);
        txtMes.setBounds(1160, 190, 140, 30);

        txtPass1.setText("jPasswordField1");
        txtPass1.setVisible(false);
        txtPass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPass1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPass1FocusLost(evt);
            }
        });
        getContentPane().add(txtPass1);
        txtPass1.setBounds(1160, 250, 140, 30);

        txtPass2.setText("jPasswordField1");
        txtPass2.setVisible(false);
        txtPass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPass2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPass2FocusLost(evt);
            }
        });
        txtPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPass2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass2);
        txtPass2.setBounds(1160, 310, 140, 30);

        txtBiblio.setBackground(new java.awt.Color(51, 51, 51));
        txtBiblio.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        txtBiblio.setForeground(new java.awt.Color(255, 255, 255));
        txtBiblio.setEnabled(false);
        getContentPane().add(txtBiblio);
        txtBiblio.setBounds(1160, 370, 140, 30);

        txtCE.setBackground(new java.awt.Color(51, 51, 51));
        txtCE.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        txtCE.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtCE);
        txtCE.setBounds(1160, 430, 140, 30);

        lblFondoLogin1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblFondoLogin1.setForeground(new java.awt.Color(255, 255, 255));
        lblFondoLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo-negro-detalles-naranjas_1408-69.jpg"))); // NOI18N
        lblFondoLogin1.setText("z");
        lblFondoLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFondoLogin1MouseClicked(evt);
            }
        });
        getContentPane().add(lblFondoLogin1);
        lblFondoLogin1.setBounds(1160, 0, 200, 590);

        btnAcep.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnAcep.setForeground(new java.awt.Color(255, 153, 51));
        btnAcep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Plus-icon.png"))); // NOI18N
        btnAcep.setText("Aceptar");
        btnAcep.setContentAreaFilled(false);
        btnAcep.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAcep.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcepActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcep);
        btnAcep.setBounds(1160, 470, 100, 80);

        lblUsua.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblUsua.setForeground(new java.awt.Color(255, 255, 255));
        lblUsua.setText("Usuario:");
        getContentPane().add(lblUsua);
        lblUsua.setBounds(1160, 40, 80, 20);

        lblreg.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblreg.setForeground(new java.awt.Color(255, 255, 255));
        lblreg.setText("Cuenta.");
        getContentPane().add(lblreg);
        lblreg.setBounds(1160, 0, 170, 40);

        lblAP.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblAP.setForeground(new java.awt.Color(255, 255, 255));
        lblAP.setText("Nombre Completo:");
        getContentPane().add(lblAP);
        lblAP.setBounds(1160, 110, 130, 15);

        lblFechNac.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblFechNac.setForeground(new java.awt.Color(255, 255, 255));
        lblFechNac.setText("Fecha de nacimiento:");
        getContentPane().add(lblFechNac);
        lblFechNac.setBounds(1160, 170, 150, 15);

        lblContra1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblContra1.setForeground(new java.awt.Color(255, 255, 255));
        lblContra1.setText("Contraseña:");
        getContentPane().add(lblContra1);
        lblContra1.setBounds(1160, 230, 70, 15);

        lblContra2.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblContra2.setForeground(new java.awt.Color(255, 255, 255));
        lblContra2.setText("Confirma contraseña:");
        getContentPane().add(lblContra2);
        lblContra2.setBounds(1160, 290, 140, 15);

        lblBiblio.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblBiblio.setText("IdBiblioteca:");
        getContentPane().add(lblBiblio);
        lblBiblio.setBounds(1160, 350, 110, 15);

        lblCE.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblCE.setForeground(new java.awt.Color(255, 255, 255));
        lblCE.setText("Correo electronico:");
        getContentPane().add(lblCE);
        lblCE.setBounds(1160, 410, 120, 15);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTiendaActionPerformed

    private void btnLibreriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibreriaActionPerformed
        Pump_It.id=id;
        Pump_It.nombre=nombre;
        Pump_It.apellido=apellido;
        Pump_It.nacimiento=nacimiento;
        Pump_It.pass=pass;
        Pump_It.idBiblioteca=idBiblioteca;
        Pump_It.correo=correo;
        Pump_It ventana = new Pump_It();
        ventana.show(true);
        this.dispose();
    }//GEN-LAST:event_btnLibreriaActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        if (txtBuscar.getText().equals("Introduce el nombre del juego...")) {
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if (txtBuscar.getText().equalsIgnoreCase("")) {
            txtBuscar.setText("Introduce el nombre del juego...");
        }
    }//GEN-LAST:event_txtBuscarFocusLost

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String[] A = new String[m.getRowCount()];
        double[] B = new double[m.getRowCount()];
        String N[] = new String[m.getRowCount()];
        int L[] = new int[m.getRowCount()];
        int[] C = new int[m.getRowCount()];
        if (txtBuscar.getText().isEmpty()) {
            showMessageDialog(null, "Ingrese un dato a buscar");
        } else {
            for (int i = 0; i < m.getRowCount(); i++) {
                A[i] = m.getValueAt(i, 0).toString();
            }
            Data.metodosOrd.quickSortString(A, 0, A.length - 1);
            int pivote = Data.metodosOrd.buscaBin(A, txtBuscar.getText());
            if (pivote != -1) {
                //------------------------
                for (int i = 0; i < m.getRowCount(); i++) {
                    N[i] = m.getValueAt(i, 0).toString();
                }
                    Data.metodosOrd.quickSortString(N, 0, N.length - 1);
                    for (int i = 0; i < m.getRowCount(); i++) {
                        for (int j = 0; j < N.length; j++) {
                            if (N[i].equals(m.getValueAt(j, 0))) {
                                m.moveRow(j, j, i);
                            }
                        }
                    }
                //------------------------
                dgvVideojuegos.setRowSelectionInterval(pivote, pivote);
                dgvVideojuegos.scrollRectToVisible(new Rectangle(dgvVideojuegos.getCellRect(pivote, 0, true)));
                 lblError.setText("Dato encontrador/!\\");
                desaparecerLabel();
            } else {
                sonidos s = new sonidos();
                s.PumpItIntroFailSound();
                lblError.setVisible(true);
                lblError.setText("Error/!\\ No existe el titulo. Vuelva a interntarlo");
                desaparecerLabel();
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnForoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForoActionPerformed
        Foro.id=id;
        Foro.nombre=nombre;
        Foro.apellido=apellido;
        Foro.nacimiento=nacimiento;
        Foro.pass=pass;
        Foro.idBiblioteca=idBiblioteca;
        Foro.correo=correo;
        Foro ventana = new Foro();
        ventana.show(true);
        this.dispose();
    }//GEN-LAST:event_btnForoActionPerformed

    private void dgvVideojuegosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvVideojuegosMouseClicked
        btnAnade.setEnabled(true);
        int fila = dgvVideojuegos.getSelectedRow();
        juego=(dgvVideojuegos.getValueAt(fila, 0).toString());
        if(juego.equals("Geometry Wars") || juego.equals("Geometry War")){
             try {
            Image img = ImageIO.read(getClass().getResource("/imagenes/19116914790_254033af20_b.jpg"));
            lblImagen.setIcon(new ImageIcon(img));
            idd="1";
        } catch (IOException ex) {
            showMessageDialog(this,ex.getMessage());
        }
        }else if(juego.equals("Osu!")){
             try {
            Image img = ImageIO.read(getClass().getResource("/imagenes/osu_game_screenshot.jpg"));
            lblImagen.setIcon(new ImageIcon(img));
            idd="2";
        } catch (IOException ex) {
            showMessageDialog(this,ex.getMessage());
        }
        }else if(juego.equals("LIMBO")){
             try {
            Image img = ImageIO.read(getClass().getResource("/imagenes/limbo-img-4.jpg"));
            lblImagen.setIcon(new ImageIcon(img));
            idd="3";
        } catch (IOException ex) {
            showMessageDialog(this,ex.getMessage());
        }
        }else if(juego.equals("DEFCON")){
             try {
            Image img = ImageIO.read(getClass().getResource("/imagenes/dc-25-website-header-2-900x506.png"));
            lblImagen.setIcon(new ImageIcon(img));
            idd="4";
        } catch (IOException ex) {
            showMessageDialog(this,ex.getMessage());
        }
        }else if(juego.equals("Papers, Please")){
             try {
            Image img = ImageIO.read(getClass().getResource("/imagenes/ss_c133e1bf1da17a3f3719c74696c61da23e38eefe.1920x1080.jpg"));
            lblImagen.setIcon(new ImageIcon(img));
            idd="5";
        } catch (IOException ex) {
            showMessageDialog(this,ex.getMessage());
        }
        }else if(juego.equals("Sora")){
             try {
            Image img = ImageIO.read(getClass().getResource("/imagenes/Sora-no-game-no-life-anime-37119012-1280-720.jpg"));
            lblImagen.setIcon(new ImageIcon(img));
            idd="6";
        } catch (IOException ex) {
            showMessageDialog(this,ex.getMessage());
        }
        }else if(juego.equals("Project64")){
             try {
            Image img = ImageIO.read(getClass().getResource("/imagenes/Project64-Nintendo-64-Emulator-cover-Inmortalgame.jpg"));
           lblImagen.setIcon(new ImageIcon(img));
           idd="7";
        } catch (IOException ex) {
            showMessageDialog(this,ex.getMessage());
        }
        }else if(juego.equals("Winkawaks")){
             try {
            Image img = ImageIO.read(getClass().getResource("/imagenes/maxresdefault (1).jpg"));
           lblImagen.setIcon(new ImageIcon(img));
           idd="8";
        } catch (IOException ex) {
            showMessageDialog(this,ex.getMessage());
        }
        }else showMessageDialog(this,"ay. :( ");
    }//GEN-LAST:event_dgvVideojuegosMouseClicked

    private void btnAnadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadeActionPerformed
            String cad="";
            String ola="102";
            int n=(int)(Math.random()*1000);
            ola=ola+n+"";
            try{
            cad = "insert into VIDEOJUEGOS (idVideojuego,idBiblioteca, nombre, desarrolladora,rating,precio,clave_compra) Values('"
                                                                                      + idd + "','"+ idBiblioteca +"','"+ juego +"','"+"no"+"','" + 10 + "','"+ 10 + "','"+ola+"')";

                    st = conn.createStatement();
                    st.executeUpdate(cad);
                    System.out.println("inserted");
                    st.close();
                    showMessageDialog(this,"Se ha insertado el nuevo juego:)");
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(RegistrarClienteException.class.getName()).log(Level.SEVERE, null, ex);
                    showMessageDialog(this,"Ay. :[");
                }
    }//GEN-LAST:event_btnAnadeActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        /*  int r = 0;
        String h = "";
        int b = (int) (Math.random() * 100);
        h = "700" + b + "";
        txtBiblio.setText(h);*/
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) && (c < ',' || c > '.')) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtPass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass1FocusGained
        txtPass1.setEchoChar((char)0);

    }//GEN-LAST:event_txtPass1FocusGained

    private void txtPass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass1FocusLost
        txtPass1.setEchoChar('*');
    }//GEN-LAST:event_txtPass1FocusLost

    private void txtPass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass2FocusGained
        txtPass2.setEchoChar((char)0);
    }//GEN-LAST:event_txtPass2FocusGained

    private void txtPass2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass2FocusLost
        txtPass2.setEchoChar('*');
    }//GEN-LAST:event_txtPass2FocusLost

    private void txtPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPass2ActionPerformed

    private void lblFondoLogin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoLogin1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFondoLogin1MouseClicked

    private void btnAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcepActionPerformed
        try{
            String pwd = new String(txtPass1.getPassword());
            String pwd2 = new String(txtPass2.getPassword());
            if(pwd.equals(pwd2)){
                conectar();
                String nuevoNombre = txtNombre.getText();//usuario
                String nuevoApellido = txtApellido.getText();//nombre del usuario
                String nuevoNacimiento = txtMes.getText();
                String nuevoCE = txtCE.getText();
                String nuevoPass = pwd;
                String sql;
                String sql2;
                sql2="update USUARIOS set nombre='"+nuevoNombre+"',apellido='"+nuevoApellido+"' ,nacimiento='"+nuevoNacimiento+"',pass='"+nuevoPass+"'where nombre='"+nuevoNombre+"'";
                //st.execute(sql);
                //sql="update USUARIOS set nombre='"+nuevoNombre+"',apellido='"+nuevoApellido+"' ,nacimiento='"+nuevoNacimiento+"',pass='"+nuevoPass+",correo='"+nuevoCE+"'where id='"+id+"'";
                st.executeUpdate(sql2);
            }else{showMessageDialog(this,"Las contraseñas no coinciden.");}
        }catch(SQLException ex){
            Logger.getLogger(Pump_It.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAcepActionPerformed

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtMes.setText(nacimiento);
        txtBiblio.setText(idBiblioteca);
        txtCE.setText(correo);
        txtPass1.setText(pass);

        AnimationClass lbl11 = new AnimationClass();
        lbl11.jLabelXLeft(1160,960,10,5, lblFondoLogin1);
        AnimationClass txt11 = new AnimationClass();
        txt11.jTextFieldXLeft(1160,990,10,5, txtNombre);
        AnimationClass txt22 = new AnimationClass();
        txt22.jTextFieldXLeft(1160,990,10,5, txtApellido);
        AnimationClass lbl22 = new AnimationClass();
        lbl22.jLabelXLeft(1160,980,10,5, lblreg);
        AnimationClass lbl33 = new AnimationClass();
        lbl33.jLabelXLeft(1160,990,10,5, lblUsua);
        AnimationClass btn11 = new AnimationClass();
        btn11.jButtonXLeft(1160,1010,10,5, btnAcep);
        AnimationClass lbl44 = new AnimationClass();
        lbl44.jLabelXLeft(1160,990,10,5, lblAP);
        AnimationClass lbl55 = new AnimationClass();
        lbl55.jLabelXLeft(1160,990,10,5, lblFechNac);
        AnimationClass lbl66 = new AnimationClass();
        lbl66.jLabelXLeft(1160,990,10,5, lblContra1);
        AnimationClass lbl77 = new AnimationClass();
        lbl77.jLabelXLeft(1160,990,10,5, lblContra2);
        txtPass1.setVisible(true);
        txtPass2.setVisible(true);
        AnimationClass lbl88 = new AnimationClass();
        lbl88.jLabelXLeft(1160,990,10,5, lblBiblio);
        AnimationClass lbl99 = new AnimationClass();
        lbl99.jLabelXLeft(1160,990,10,5, lblCE);
        AnimationClass lbl1010 = new AnimationClass();
        AnimationClass txtb = new AnimationClass();
        txtb.jTextFieldXLeft(1160,1040,10,5, txtMes);
        AnimationClass txtd = new AnimationClass();
        txtd.jTextFieldXLeft(1160,990,10,5, txtBiblio);
        AnimationClass txte = new AnimationClass();
        txte.jTextFieldXLeft(1160,990,10,5, txtCE);
        AnimationClass psw1 = new AnimationClass();
        psw1.jPasswordFieldXLeft(1160, 990, 10, 5, txtPass1);
        AnimationClass psw2 = new AnimationClass();
        psw2.jPasswordFieldXLeft(1160, 990, 10,5, txtPass2);

        //izq
        AnimationClass lbl1 = new AnimationClass();
        lbl1.jLabelXRight(960,1160,10,5, lblFondoLogin1);
        AnimationClass txt1 = new AnimationClass();
        txt1.jTextFieldXRight(990,1160,10,5, txtNombre);
        AnimationClass txt2 = new AnimationClass();
        txt1.jTextFieldXRight(990,1160,10,5, txtApellido);
        AnimationClass lbl2 = new AnimationClass();
        lbl2.jLabelXRight(980,1160,10,5, lblreg);
        AnimationClass lbl3 = new AnimationClass();
        lbl3.jLabelXRight(990,1160,10,5, lblUsua);
        AnimationClass btn1 = new AnimationClass();
        btn1.jButtonXRight(1010,1160,10,5, btnAcep);
        AnimationClass lbl4 = new AnimationClass();
        lbl4.jLabelXRight(990,1160,10,5, lblAP);
        AnimationClass lbl5 = new AnimationClass();
        lbl5.jLabelXRight(990,1160,10,5, lblFechNac);
        AnimationClass lbl6 = new AnimationClass();
        lbl6.jLabelXRight(990,1160,10,5, lblContra1);
        AnimationClass lbl7 = new AnimationClass();
        lbl7.jLabelXRight(990,1160,10,5, lblContra2);
        //txtPass1.setVisible(false);
        //txtPass2.setVisible(false);
        AnimationClass lbl8 = new AnimationClass();
        lbl8.jLabelXRight(990,1160,10,5, lblBiblio);
        AnimationClass lbl9 = new AnimationClass();
        lbl9.jLabelXRight(990,1160,10,5, lblCE);
        AnimationClass lbl10 = new AnimationClass();
        AnimationClass txtbb = new AnimationClass();
        txtbb.jTextFieldXRight(1040,1160,10,5, txtMes);
        AnimationClass txtdd = new AnimationClass();
        txtdd.jTextFieldXRight(990,1160,10,5, txtBiblio);
        AnimationClass txtee = new AnimationClass();
        txtee.jTextFieldXRight(990,1160,10,5, txtCE);
        AnimationClass psw11 = new AnimationClass();
        psw11.jPasswordFieldXRight(990,1160,10,5, txtPass1);
        AnimationClass psw22 = new AnimationClass();
        psw22.jPasswordFieldXRight(990,1160,10,5, txtPass2);
    }//GEN-LAST:event_btnCuentaActionPerformed

        public void desaparecerLabel() {
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                lblError.setText("----");
            }
        };
        t.schedule(task, 3000);
    }
    
    public void conectar() {
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        } catch (ClassNotFoundException cnfex) {

            System.out.println("Problema al cargar o "
                    + "registrar:  MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(dbURL);
            st = conn.createStatement();
            System.out.println("Conexion establecida");

        } catch (SQLException ex) {

            System.out.println("error de conexion");
        }
        System.out.println("Proceso de conexión finalizado.");
    }

    private void llenarVideoJuegos() {
        try {
            conectar();
            Object O[] = new Object[4];
            st = conn.createStatement();
            st.execute("select nombre, precio, rating, desarrolladora from VIDEOJUEGOS");
            rs = st.getResultSet();
            m.setRowCount(0);
            if (rs != null && rs.isFirst() == false) {
                while (rs.next()) {
                    O[0] = rs.getString("Nombre");
                    O[1] = rs.getInt("Precio");
                    O[2] = rs.getInt("Rating");
                    O[3] = rs.getString("Desarrolladora");
                    m.addRow(O);
                }
            } else {
                showMessageDialog(this, "Error, no se encontraron registros");
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pump_It.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Nuevo_PumpTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nuevo_PumpTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nuevo_PumpTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nuevo_PumpTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nuevo_PumpTienda().setVisible(true);
            }
        });
    }
    public static String idd="";
    public static String idJuego="";
    public static String juegos="";
    public static String id="";
    public static String nombre="";
    public static String apellido="";
    public static String nacimiento="";
    public static String pass="";
    public static String idBiblioteca="";
    public static String correo="";
    private Statement st;
    private ResultSet rs;
    private Connection conn = null;
    private String msAccDB = "C:\\Users\\marva\\Dropbox (Tecnológico)\\ED\\Pump_it!\\src\\Data\\Pump_ItDB.accdb";
    private String dbURL = "jdbc:ucanaccess://" + msAccDB;
    DefaultTableModel m;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcep;
    private javax.swing.JButton btnAnade;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnForo;
    private javax.swing.JButton btnLibreria;
    private javax.swing.JButton btnTienda;
    private javax.swing.JTable dgvVideojuegos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblAP;
    private javax.swing.JLabel lblBiblio;
    private javax.swing.JLabel lblCE;
    private javax.swing.JLabel lblContra1;
    private javax.swing.JLabel lblContra2;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFechNac;
    private javax.swing.JLabel lblFondoLogin1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblUsua;
    private javax.swing.JLabel lblbus;
    private javax.swing.JLabel lblreg;
    private javax.swing.JToggleButton tbtOrd;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBiblio;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCE;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JPasswordField txtPass2;
    // End of variables declaration//GEN-END:variables
}
