package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class Interfaz extends JFrame {
	
	private JPanel miPanel;
	private JTextField textUsuario;
	private JPasswordField passwordField;

	public Interfaz() {
		setTitle("Gesti\u00F3n Empresarial");
		
		
		
		this.setSize(800,600);
		this.setResizable(false);

	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		miPanel = new JPanel();
		miPanel.setBackground(Color.GRAY);
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(37, 84, 97, 42);
		miPanel.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContraseña.setBounds(37, 135, 97, 42);
		miPanel.add(lblContraseña);
		
		
		
		textUsuario = new JTextField();
		textUsuario.setBounds(158, 98, 232, 20);
		miPanel.add(textUsuario);
		textUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 149, 232, 20);
		miPanel.add(passwordField);
		passwordField.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String userName = textUsuario.getText();
					String passWord = passwordField.getText();
					
					String bd="swing_pruebas";
					String url ="jdbc:mysql://localhost:3306/" + bd;
					
					String usuario = "root";
					String password = null;

					java.sql.Connection conn= null;
					
					java.sql.Statement stmt = null;
					
					ResultSet rs = null;
					
					
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							
							conn=DriverManager.getConnection(url, usuario, password);
							
							stmt= conn.createStatement();
							
							
							
							String query= "Select user,pass From datos where user='"+ userName + "' && pass='" +passWord+ "'";
							
							rs=((java.sql.Statement) stmt).executeQuery(query);
							
							String user="";
							String pass="";
							
							while(rs.next()) {
								user=rs.getString("user");
								pass=rs.getString("pass");
							}
							
							if(userName.equals(user) && passWord.equals(pass)) {
								System.out.println("Login exitoso");
								 dispose();
								 
				                 JOptionPane.showMessageDialog(null, "Bienvenido\n"
				                    + "Has ingresado correctamente al sistema",   "Mensaje de bienvenida",
				                 JOptionPane.INFORMATION_MESSAGE);
							}else {
								System.out.println("Nombre o contraseña incorrectos");
								 
				                 JOptionPane.showMessageDialog(null, "Acceso denegado\n"
				                    + "Ingresa correctamente los datos", "Acceso denegado",
				                 JOptionPane.ERROR_MESSAGE);
							}
							
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
				}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Interfaz.class.getResource("/interfaz/gemlogotransdefinitivo1.png")));
		lblNewLabel.setBounds(114, 11, 208, 66);
		miPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Iniciar sesi\u00F3n");
		btnNewButton.setBounds(147, 203, 129, 23);
		miPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evt) {
				
				String userName = textUsuario.getText();
				String passWord = passwordField.getText();
				
				String bd="swing_pruebas";
				String url ="jdbc:mysql://localhost:3306/" + bd;
				
				String usuario = "root";
				String password = null;

				java.sql.Connection conn= null;
				
				java.sql.Statement stmt = null;
				
				ResultSet rs = null;
				
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						conn=DriverManager.getConnection(url, usuario, password);
						
						stmt= conn.createStatement();
						
						if(!userName.equals("") && !passWord.equals("")) {
							
						
							String query= "Select user,pass From datos where user='"+ userName + "' && pass='" +passWord+ "'";
						
							rs=((java.sql.Statement) stmt).executeQuery(query);
						
							String user="";
							String pass="";
						
							while(rs.next()) {
								user=rs.getString("user");
								pass=rs.getString("pass");
							}
						
							if(userName.equals(user) && passWord.equals(pass)) {
								System.out.println("Login exitoso");
								dispose();
								 
				                 JOptionPane.showMessageDialog(null, "Bienvenido\n"
				                		 + "Has ingresado correctamente al sistema",   "Mensaje de bienvenida",
				                		 JOptionPane.INFORMATION_MESSAGE);
							}else {
								System.out.println("Nombre o contraseña incorrectos");
							 
								JOptionPane.showMessageDialog(null, "Acceso denegado\n"
										+ "Ingresa correctamente los datos", "Acceso denegado",
										JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Acceso denegado\n"
									+ "Ingresa correctamente los datos", "Acceso denegado",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			
		});
			
		setVisible(true);
	}
}

