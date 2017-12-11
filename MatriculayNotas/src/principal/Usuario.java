package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Color;

public class Usuario extends JFrame {

	private JPanel contentPane;
	private imagenFondo desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario() {
		setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuario.class.getResource("/imagenes/JOSE PARDO.1.jpg")));
		setTitle("SISTEMA DE MATRICULA (Usuarios)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 312);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 192, 203));
		menuBar.setForeground(new Color(128, 128, 0));
		menuBar.setMargin(new Insets(5, 5, 5, 5));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("ARCHIVO");
		mnArchivo.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/contactos-aurora-carpetas-texto-icono-5473-32.png")));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n =JOptionPane.showConfirmDialog(rootPane, "Desear salir?", "Seleccione su opcion", JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION)
					System.exit(0); 
			}
		});
		
		JMenu mnRegistroAlumno = new JMenu("Registro alumno");
		mnRegistroAlumno.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/nuevo-archivo-de-documento-escrito-en-papel-pluma-icono-3934-16.png")));
		mnRegistroAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		mnArchivo.add(mnRegistroAlumno);
		
		JMenuItem mntmRegistroDeFichas = new JMenuItem("Registro de  fichas");
		mntmRegistroDeFichas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				alumnos b=new alumnos();
				b.setVisible(true);
				desktopPane.add(b);
				
				
			}
		});
		mnRegistroAlumno.add(mntmRegistroDeFichas);
		
		JMenu mnCursos = new JMenu("Cursos");
		mnArchivo.add(mnCursos);
		
		JMenu mnNotas = new JMenu("Notas");
		mnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistroNotas g=new RegistroNotas();
				g.setVisible(true);
				desktopPane.add(g);
			}
		});
		mnArchivo.add(mnNotas);
	
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmSalir);
		
		JMenu mnInformes = new JMenu("CURSOS");
		mnInformes.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/libros-de-la-biblioteca-icono-5623-32.png")));
		menuBar.add(mnInformes);
		
		JMenu mnUtilitarios = new JMenu("CICLOS ");
		mnUtilitarios.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/archivo-comprimido-icono-9234-32.png")));
		menuBar.add(mnUtilitarios);
		
		JMenu mnAyuda = new JMenu("NOTAS");
		mnAyuda.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/equipo-editar-icono-6468-32.png")));
		menuBar.add(mnAyuda);
		
		JMenuItem mntmFichaDeNotas = new JMenuItem("Ficha de notas ");
		mntmFichaDeNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroNotas g=new RegistroNotas();
				g.setVisible(true);
				desktopPane.add(g);
			}
		});
		mnAyuda.add(mntmFichaDeNotas);
		
		JMenu mnPagos = new JMenu("PAGOS");
		mnPagos.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/cambio-de-registro-de-documentos-una-pluma-para-escribir-texto-icono-5178-32.png")));
		menuBar.add(mnPagos);
		
		JMenu mnReportes = new JMenu("REPORTES");
		mnReportes.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/pdf-icono-3839-32.png")));
		menuBar.add(mnReportes);
		
		JMenuItem mntmEstudiantes = new JMenuItem("Reporte de estudiantes");
		mntmEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		mnReportes.add(mntmEstudiantes);
		
		JMenuItem mntmDocentes = new JMenuItem("Reporte de docentes");
		mnReportes.add(mntmDocentes);
		
		JMenu mnAtencin = new JMenu("ATENCI\u00D3N");
		mnAtencin.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/anadir-mas-icono-6734-16.png")));
		menuBar.add(mnAtencin);
		
		JMenuItem mntmAtencionDeUsuarios = new JMenuItem("Atencion de usuarios");
		mntmAtencionDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroNombres s =new RegistroNombres();
				s.setVisible(true);
				desktopPane.add(s);
			}
		});
		mnAtencin.add(mntmAtencionDeUsuarios);
		
		JMenu mnAyuda_1 = new JMenu("AYUDA");
		mnAyuda_1.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/globos-de-ayuda-icono-5985-32.png")));
		menuBar.add(mnAyuda_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new imagenFondo();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
}
