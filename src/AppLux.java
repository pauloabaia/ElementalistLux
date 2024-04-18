import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class AppLux {

	private JFrame frame;
	private JRadioButton waterButton;
	private JRadioButton fireButton;
	private JButton button;
	private JRadioButton natureButton;
	private JRadioButton airButton;
	private JPanel panel;
	private Map<String, ImageIcon> iconMap; //Map mapeia chaves para valores 
	private Map<String, Color> corMap;
	//Orientação: Map<chave,valor>
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppLux window = new AppLux();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppLux() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//carrega o hash
		iconMap = new HashMap<>(); //HASH MAP armazena os elementos em uma estrutura de tabela hash.
		corMap = new HashMap<>();
		iconMap.put("storm", new ImageIcon(getClass().getResource("imgs/luxStorm.png")));corMap.put("storm", new Color(188, 191, 122));
		iconMap.put("magma", new ImageIcon(getClass().getResource("imgs/luxMagma.png")));corMap.put("magma", new Color(230, 115, 115));
		iconMap.put("mystic", new ImageIcon(getClass().getResource("imgs/luxMystic.png")));corMap.put("mystic", new Color(147, 152, 219));
		iconMap.put("dark", new ImageIcon(getClass().getResource("imgs/luxDark.png")));corMap.put("dark", new Color(141, 137, 163));
		iconMap.put("ice", new ImageIcon(getClass().getResource("imgs/luxIce.png")));corMap.put("ice", new Color(237, 230, 230));
		iconMap.put("air", new ImageIcon(getClass().getResource("imgs/luxAir.png")));corMap.put("air", new Color(52, 235, 216));
		iconMap.put("fire", new ImageIcon(getClass().getResource("imgs/luxFire.png")));corMap.put("fire", new Color(235, 131, 52));
		iconMap.put("water", new ImageIcon(getClass().getResource("imgs/luxWater.png")));corMap.put("water", new Color(97, 162, 237));
		iconMap.put("nature", new ImageIcon(getClass().getResource("imgs/luxNature.png")));corMap.put("nature", new Color(52, 235, 79));
		iconMap.put("light", new ImageIcon(getClass().getResource("imgs/light.png")));corMap.put("light", new Color(255, 255, 255));
		//starta o frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 400, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		///iconL
		ImageIcon iconElementalist = new ImageIcon(getClass().getResource("imgs/LoL_Icon_Flat_GOLD.png"));
		frame.setIconImage(iconElementalist.getImage());
		
		//start jpanel
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(110, 117, 150, 130);
		frame.getContentPane().add(panel);
		ImageIcon iconLight = new ImageIcon(getClass().getResource("imgs/light.png"));
		JLabel label = new JLabel(iconLight);
		label.setBackground(new Color(255, 255, 255));
		panel.add(label);
        panel.revalidate();
        panel.repaint();
		
		//WATER
		waterButton = new JRadioButton("Water");
		waterButton.setBackground(new Color(255, 255, 255));
		waterButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		waterButton.setBounds(297, 87, 64, 23);
		frame.getContentPane().add(waterButton);
		//FIRE
		fireButton = new JRadioButton("Fire");
		fireButton.setBackground(new Color(255, 255, 255));
		fireButton.setFont(new Font("Yu Gothic UI Semilight",  Font.BOLD, 14));
		fireButton.setBounds(107, 50, 64, 23);
		frame.getContentPane().add(fireButton);
		//NATURE
		natureButton = new JRadioButton("Nature");
		natureButton.setBackground(new Color(255, 255, 255));
		natureButton.setFont(new Font("Yu Gothic UI Semilight",  Font.BOLD, 14));
		natureButton.setBounds(198, 50, 82, 23);
		frame.getContentPane().add(natureButton);
		//AIR
		airButton = new JRadioButton("Air");
		airButton.setBackground(new Color(255, 255, 255));
		airButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		airButton.setBounds(23, 82, 48, 33);
		frame.getContentPane().add(airButton);
		//BUTTON GENERATE
		button = new JButton("Gerar");
		button.setBackground(new Color(128, 255, 255));
		button.setFont(new Font("Yu Gothic UI Semilight",  Font.BOLD, 16));
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if ((airButton.isSelected() && fireButton.isSelected() &&
		    		waterButton.isSelected() && natureButton.isSelected()) 
		    		|| (airButton.isSelected() && fireButton.isSelected() && waterButton.isSelected())
		    		|| (airButton.isSelected() && fireButton.isSelected() && natureButton.isSelected())
		    		|| (airButton.isSelected() && natureButton.isSelected() && waterButton.isSelected())
		    		|| (fireButton.isSelected() && natureButton.isSelected() && waterButton.isSelected())) {
		    		JOptionPane.showMessageDialog(panel, "Você não pode selecionar o mesmo elemento duas vezes.", "Erro", JOptionPane.ERROR_MESSAGE);
		            airButton.setSelected(false);
		            waterButton.setSelected(false);
		            fireButton.setSelected(false);
		            natureButton.setSelected(false);
		    	}
		    		
		    	else if (airButton.isSelected() && fireButton.isSelected()) {
		            displayChange("storm");
		        } 
		        else if (airButton.isSelected() && waterButton.isSelected()) {
		            displayChange("ice");
		        } 
		        else if (airButton.isSelected() && natureButton.isSelected()) {
		            displayChange("dark");	      
		        } 
		        else if (fireButton.isSelected() && waterButton.isSelected()) {
		            displayChange("dark"); 
		        } 
		        else if (fireButton.isSelected() && natureButton.isSelected()) {
		            displayChange("magma");
		        } 
		        else if (waterButton.isSelected() && natureButton.isSelected()) {
		            displayChange("mystic");
		        } 
		        else if (airButton.isSelected()) {
		            displayChange("air");
		        } 
		        else if (fireButton.isSelected()) {
		            displayChange("fire");
		        } 
		        else if (waterButton.isSelected()) {
		            displayChange("water");
		        } 
		        else if (natureButton.isSelected()) {
		            displayChange("nature");
		        } 
		        else {
		            // Nenhum botão selecionado, set default (light skin)
		            displayChange("light");
		        }
		    	
			}
		    
		});
		
		button.setBounds(144, 274, 89, 23);
		frame.getContentPane().add(button);

	}
	private void displayChange(String luxFormName) {
		ImageIcon icon = iconMap.get(luxFormName);
		Color cor = corMap.get(luxFormName);
        JLabel label = new JLabel(icon);
        label.setOpaque(true);
        label.setBackground(cor);
        panel.removeAll();
        panel.add(label);
        panel.revalidate();
        panel.repaint();
        airButton.setSelected(false);
        waterButton.setSelected(false);
        fireButton.setSelected(false);
        natureButton.setSelected(false);
        label.setBackground(cor);
        panel.setBackground(cor);
        frame.getContentPane().setBackground(cor);
        airButton.setBackground(cor);
        waterButton.setBackground(cor);
        fireButton.setBackground(cor);
        natureButton.setBackground(cor);       
	}
}
