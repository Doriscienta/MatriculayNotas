package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.print.*;


import dao.conectar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class alumnos extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtnom;
	private JTextField txtape;
	private JTextField txtdir;
	private JTable table;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;


	JTable ss = new JTable();


	DefaultTableModel modelo;
	private JLabel lblNewLabel_1;
	private JTextField txtBuscar;
	private JLabel lblTelefono;
	private JTextField txttel;
	private JTextField txtgen;
	private JLabel lblGnero;
	private JLabel lblDni;
	private JTextField txtdni;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alumnos frame = new alumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public alumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 627);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("....REGISTRO DE ALUMNOS....");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel.setBounds(106, 11, 265, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("CODIGO:");
		lblId.setBounds(31, 87, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblTitulo = new JLabel("NOMBRES:");
		lblTitulo.setBounds(31, 167, 69, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblEditorial = new JLabel("APELLIDOS:");
		lblEditorial.setBounds(31, 227, 69, 14);
		contentPane.add(lblEditorial);
		
		JLabel lblArea = new JLabel("DIRECCI\u00D3N:");
		lblArea.setBounds(325, 112, 68, 14);
		contentPane.add(lblArea);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(110, 81, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setBounds(110, 109, 122, 20);
		contentPane.add(txtnom);
		txtnom.setColumns(10);
		
		txtape = new JTextField();
		txtape.setBounds(110, 224, 164, 20);
		contentPane.add(txtape);
		txtape.setColumns(10);
		
		txtdir = new JTextField();
		txtdir.setBounds(403, 109, 128, 20);
		contentPane.add(txtdir);
		txtdir.setColumns(10);
		
		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(alumnos.class.getResource("/imagenes/cambio-de-cepillo-de-escoba-de-barrer-claro-icono-5768-48.png")));
		btnNuevo.setBounds(51, 284, 69, 46);
		contentPane.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(alumnos.class.getResource("/imagenes/disquetes-excepto-icono-7120-48.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{	insertar();
			}
		});
		btnGuardar.setBounds(130, 284, 69, 46);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(alumnos.class.getResource("/imagenes/configurar-icono-9107-48.png")));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{ modificar();
			}
		});
		btnModificar.setBounds(229, 284, 61, 46);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(alumnos.class.getResource("/imagenes/papelera-vacia-icono-8255-48.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				int n =JOptionPane.showConfirmDialog(rootPane, "Desear eliminar ?", "Seleccione su opcion", JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION)
					 
				eliminar();
			}
		});
		btnEliminar.setBounds(358, 284, 69, 46);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 400, 521, 178);
		contentPane.add(scrollPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				eliminar();
			}
		});
		popupMenu.add(mntmEliminar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	int fila = table.getSelectedRow();
				
				if(fila>=0)
				{	txtId.setText(table.getValueAt(fila, 0).toString());
				txtgen.setText(table.getValueAt(fila, 6).toString());	
	
					txtnom.setText(table.getValueAt(fila, 1).toString());
					txtdni.setText(table.getValueAt(fila, 2).toString());	
					txtape.setText(table.getValueAt(fila, 3).toString());
					txtdir.setText(table.getValueAt(fila, 4).toString());	
					txttel.setText(table.getValueAt(fila, 5).toString());
					txtgen.setText(table.getValueAt(fila, 6).toString());	
				
				}
				else
					JOptionPane.showMessageDialog(null, "No seleccion nada");
				
			}
		});
		popupMenu.add(mntmModificar);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(alumnos.class.getResource("/imagenes/salir-de-mi-perfil-icono-3964-48.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int n =JOptionPane.showConfirmDialog(rootPane, "Desear salir?", "Seleccione su opcion", JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION)
					 
				
				setVisible(false);
			}
		});
		btnSalir.setBounds(457, 284, 69, 46);
		contentPane.add(btnSalir);
		
		lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setBounds(31, 375, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				cargar(txtBuscar.getText()) ;
			}
		});
		txtBuscar.setBounds(110, 369, 150, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		///***************//
		table.setComponentPopupMenu(popupMenu);
		
		lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(325, 167, 68, 14);
		contentPane.add(lblTelefono);
		
		txttel = new JTextField();
		txttel.setColumns(10);
		txttel.setBounds(403, 167, 128, 20);
		contentPane.add(txttel);
		
		txtgen = new JTextField();
		txtgen.setColumns(10);
		txtgen.setBounds(381, 224, 150, 20);
		contentPane.add(txtgen);
		
		lblGnero = new JLabel("G\u00C9NERO:");
		lblGnero.setBounds(325, 227, 46, 14);
		contentPane.add(lblGnero);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(31, 112, 46, 14);
		contentPane.add(lblDni);
		
		txtdni = new JTextField();
		txtdni.setBounds(116, 164, 144, 20);
		contentPane.add(txtdni);
		txtdni.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MessageFormat header= new MessageFormat("holaaa");
				MessageFormat footer= new MessageFormat("pegar");
				
				
				try {
					ss.print(JTable.PrintMode .FIT_WIDTH,header, footer);
					
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog(null, "NO SE PUEDE IMPRIMIR");
					
				}
					
			}
		});
		button.setIcon(new ImageIcon(alumnos.class.getResource("/imagenes/impresora-icono-6275-48.png")));
		button.setBounds(450, 343, 81, 46);
		contentPane.add(button);
		//***************//
		cargar(""); 
	}
	
	public void insertar() 
	{	try 
		{	conectar cc= new conectar();
			Connection cn= cc.conexion();
			String sql=null;
			String dni,nom,ape,dir,tel,gen;
			
			dni=txtdni.getText();
			nom= txtnom.getText();
			ape= txtape.getText();
			dir= txtdir.getText();
			tel=txttel.getText();
			gen=txtgen.getText();
						
			sql= "INSERT INTO alumno (dni,nombre, apellido, direccion,telefono,genero) values (?,?,?,?,?,?)";
			
			PreparedStatement pst= cn.prepareStatement(sql);
			pst.setString(1, dni);
			pst.setString(2, nom);
			pst.setString(3, ape);
			pst.setString(4, dir);
			pst.setString(5, tel);
			pst.setString(6, gen);
			
			
			int n= pst.executeUpdate();
			if(n>0)
			{	JOptionPane.showMessageDialog(null, "Registro guardado con exito");									
			}
			
			pst.close();
			cn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	cargar("");
	}
	public void cargar( String valor) 
	{	String [] titulos= {"CODIGO","DNI", "NOMBRE", "APELLIDO", "DIRECCION","TELÉFONO","GÉNERO"};
		String [] filas= new String[7];
		String sql= "Select *from alumno where nombre like '%" + valor + "%'";
		
		modelo= new DefaultTableModel (null, titulos);
		
		conectar cc= new conectar();
		
		Connection cn;
		
			
		
		Statement st;
		try 
		{	cn = cc.conexion();
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{	
				filas[0] = rs.getString("codigo");
				filas[1] = rs.getString("dni");
				filas[2] = rs.getString("nombre");
				filas[3] = rs.getString("apellido");
				filas[4] = rs.getString("direccion");
				filas[5] = rs.getString("telefono");
				filas[6] = rs.getString("genero");
				
				modelo.addRow(filas);
			}
			table.setModel(modelo);
			st.close();
			cn.close();
		} 
		catch (SQLException e) 
		{	e.printStackTrace();
		}
				
	}
	
	public void modificar()
	{	String sql= "UPDATE alumno SET nombre='"+ txtnom.getText()
					 + "',apellido='"+txtape.getText()
					 + "',direccion='"+txtdir.getText()
					 + "',telefono='"+txttel.getText()
					 + "',genero='" + txtgen.getText() + "' where codigo='"
					 + txtId.getText() + "'";
	
		try
		{	conectar cc = new conectar();
			Connection cn = cc.conexion();
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Registro actualizado");
			cargar("");
			pst.close();
			cn.close();
		}
		catch (SQLException e) 
		{	e.printStackTrace();
		}
		
	}
	
	public void eliminar()
	{
		int fila = table.getSelectedRow();
		int cod = Integer.parseInt(table.getValueAt(fila, 0).toString());
		String sql = "DELETE from alumno where codigo='"
						+ cod + "'";
						
		try
		{
			conectar cc= new conectar();
			Connection cn=cc.conexion();
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Registro eliminado");
			cargar("");
			pst.close();
			cn.close();
		}
		catch (SQLException e) 
		{	e.printStackTrace();
		}
		
		
	}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
