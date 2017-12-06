package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainMenu2 {
   private JFrame mainFrame;
   private JPanel pPAGE_START;
   private JPanel pPAGE_END;
   private JPanel pLINE_START;
   private JPanel pLINE_START_GRID;
   private JPanel pLINE_END;
   private JPanel pCENTER;
   private JPanel pLINE_END_GRID;
   private JPanel pCENTER_GRID;
   private JLabel lCENTER_HEAD;
   private JLabel lLINE_START_HEAD;
   private JLabel lLINE_END_HEAD;
   //panel Head Search
   private JPanel pHSearch;
   private Font fontButton =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 22);
   private Font fontText =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 18);
   private JLabel lHeadTitle;
   private JButton bSearch1;
   private JButton bSearch2;
   private JButton bSearch3;
   private JButton bReset;
   
   
   //Test Fram moi
   
   private JPanel pLINE_START_START;
   private JPanel pLINE_START_CENTER;
   private JPanel pLINE_START_END;
   
   //Het test
   
   private JTextField textSearch;

	public MainMenu2()
	{
		guiStart();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenu2 mainMenu = new MainMenu2();

	}
	private void guiStart()
	{
		mainFrame = new JFrame("ãÅêlèÓïÒ");
		mainFrame.setSize(1000,500);
		mainFrame.setLayout(new  BorderLayout());

		PAGE_START();
		PAGE_END();
		LINE_START();
		CENTER();
		LINE_END();
		
		
		mainFrame.add(pPAGE_START,BorderLayout.PAGE_START);
		mainFrame.add(pLINE_START,BorderLayout.LINE_START);
		mainFrame.add(pCENTER,BorderLayout.CENTER);
		//mainFrame.add(pLINE_END,BorderLayout.LINE_END);
		mainFrame.add(pPAGE_END,BorderLayout.PAGE_END);
	  	
		mainFrame.setVisible(true);
	
	  
	
	}
	private void PAGE_START()
	{
		pPAGE_START = new JPanel(new GridLayout(2, 1));
		pPAGE_START.setBackground(Color.CYAN);
		lHeadTitle = new JLabel("ãÅêlÇíTÇ∑",JLabel.CENTER );
		lHeadTitle.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 40));
		lHeadTitle.setForeground(Color.BLUE);
		pHSearch = new JPanel(new FlowLayout());
		pHSearch.setBackground(Color.LIGHT_GRAY);
		textSearch = new JTextField("Search");
		textSearch.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ", 2, 25));
		textSearch.setSize(800,25);
		textSearch.setColumns(25);
		textSearch.addMouseMotionListener(new MouseMotionListener() {
			
			public void mouseMoved(MouseEvent e) {
				//textSearch.setText(null);
				
			}
			
			public void mouseDragged(MouseEvent e) {
				textSearch.setText(null);
				
			}
			public void mousePressed(MouseEvent e) {
				//textSearch.setText(null);
		      }
		});
		textSearch.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					System.out.println("Mhay vao cau search nhe");
				}
				
			}
		});
		bSearch1 = new JButton("Search");
		bSearch1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String url = "https://www.google.com";
		        try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		bSearch1.setFont(fontButton);
		pHSearch.add(textSearch);
		pHSearch.add(bSearch1);
		pPAGE_START.add(lHeadTitle);
		pPAGE_START.add(pHSearch);
	}
	private void PAGE_END()
	{
		pPAGE_END = new JPanel(new FlowLayout());
		bReset = new JButton("Reset");
		bReset.setFont(fontButton);
		bSearch2 = new JButton("Detail Search");
		bSearch2.setFont(fontButton);
		bSearch3 = new JButton("Search");
		bSearch3.setFont(fontButton);
		pPAGE_END.add(bReset);
		pPAGE_END.add(bSearch2);
		pPAGE_END.add(bSearch3);
		pPAGE_END.setBackground(Color.LIGHT_GRAY);
		pPAGE_END.setSize(1000,100);
		
		
	}
	private void LINE_START()
	{
//		pLINE_START = new JPanel();
//		pLINE_START.setFont(fontText);
//		
//		lLINE_START_HEAD = new JLabel("êEéÌ");
//		lLINE_START_HEAD.setFont(fontText);
//		
//		pLINE_START_GRID = new JPanel(new GridLayout(3, 2));
//		for(int i=0;i<6;i++)
//		{
//			
//			JCheckBox checkBox = new JCheckBox("CHekbok"+i);
//			checkBox.setFont(fontText);
//			pLINE_START_GRID.add(checkBox);
//		}
//		pLINE_START.add(lLINE_START_HEAD);
//		pLINE_START.add(pLINE_START_GRID);
		pLINE_START = new JPanel(new GridLayout(3, 1));
		
		
		pLINE_START_START = new JPanel(new GridLayout(3, 2));
		pLINE_START_START.setBorder(BorderFactory.createTitledBorder("êEéÌ"));
		for(int i=0;i<6;i++)
			{
				
				JCheckBox checkBox = new JCheckBox("êEéÌ"+i);
				checkBox.setFont(fontText);
				pLINE_START_START.add(checkBox);
			}
		
		pLINE_START_CENTER = new JPanel(new GridLayout(3, 2));
		pLINE_START_CENTER.setBorder(BorderFactory.createTitledBorder("èÍèä"));
		for(int i=0;i<6;i++)
			{
				
				JCheckBox checkBox = new JCheckBox("èÍèä"+i);
				checkBox.setFont(fontText);
				pLINE_START_CENTER.add(checkBox);
			}
		pLINE_START_END= new JPanel();
		pLINE_START_END.add(bReset);
		pLINE_START_END.add(bSearch2);
		//pLINE_START_END.add(bSearch3);
		pLINE_START_END.setBackground(Color.LIGHT_GRAY);
		
		pLINE_START.add(pLINE_START_START);
		pLINE_START.add(pLINE_START_CENTER);
		pLINE_START.add(pLINE_START_END);
		
		
		
		
		
	}
	private void CENTER()
	{
//		pCENTER = new JPanel();
//		pCENTER.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 20));
//		
//		lCENTER_HEAD = new JLabel("èÍèä");
//		lCENTER_HEAD.setFont(fontText);
//		
//		pCENTER_GRID = new JPanel(new GridLayout(3, 2));
//		for(int i=0;i<6;i++)
//		{
//			
//			JCheckBox checkBox = new JCheckBox("èÍèä"+i);
//			checkBox.setFont(fontText);
//			pCENTER_GRID.add(checkBox);
//		}
//		pCENTER.add(lCENTER_HEAD);
//		pCENTER.add(pCENTER_GRID);
		pCENTER = new JPanel(new GridLayout(3, 2));
		pCENTER.setBorder(BorderFactory.createTitledBorder("èÍèä"));
		for(int i=0;i<6;i++)
			{
				
				JCheckBox checkBox = new JCheckBox("èÍèä"+i);
				checkBox.setFont(fontText);
				pCENTER.add(checkBox);
			}
		
	}
	private void LINE_END()
	{
//		pLINE_END = new JPanel();
//		pLINE_END.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 20));
//		
//		lLINE_END_HEAD = new JLabel("ããó^");
//		lLINE_END_HEAD.setFont(fontText);
//		
//		pLINE_END_GRID = new JPanel(new GridLayout(3, 2));
//		for(int i=0;i<6;i++)
//		{
//			JCheckBox checkBox = new JCheckBox("ããó^"+i);
//			checkBox.setFont(fontText);
//			pLINE_START_GRID.add(checkBox);
//		}
//		pLINE_END.add(lLINE_END_HEAD);
//		pLINE_END.add(pLINE_END_GRID);
		pLINE_END = new JPanel(new GridLayout(3, 2));
		pLINE_END.setBorder(BorderFactory.createTitledBorder("èÍèä"));
		for(int i=0;i<6;i++)
			{
				
				JCheckBox checkBox = new JCheckBox("èÍèäèÍèä"+i);
				checkBox.setFont(fontText);
				pLINE_END.add(checkBox);
			}
		
	}

}
