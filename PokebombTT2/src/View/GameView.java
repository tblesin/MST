package View;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameManager;
import Controller.ModeMulti;
import Controller.ModeSolo;


public class GameView extends JFrame implements ActionListener{
	
	Timer mainTimer ;							
	
	GamePanel pan ;
	BarreInfo barreinfo;
	BarreInfoSolo barreinfosolo;
	String mode;
	
	GameManager manager ; //new !
	
	//barre d'outils
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Aide");
	private JMenuItem item1 = new JMenuItem("Retour au menu");
	private JMenuItem item2 = new JMenuItem("Aide");
	private JMenuItem item3 = new JMenuItem("Nouvelle partie");
	
	//menu principal 
	Menu menupage1;   
	public static Bouton bsolo = new Bouton("","Solo.png",350,150,150,40);
	public static Bouton bmulti = new Bouton("","menu.png",50,150,150,40);
	
	//menu multi page 1
	Menu menupage2;
	public static Bouton p2 = new Bouton("","2Joueurs.png",140,120,70,70);
	public static Bouton p3 = new Bouton("","3Joueurs.png",240,120,70,70);
	public static Bouton p4 = new Bouton("","4Joueurs.png",340,120,70,70);
	public static Bouton lvl1multi = new Bouton("","lvl1solo.jpg",140,260,50,50);
	public static Bouton lvl2multi = new Bouton("","lvl2solo.jpg",200,260,50,50);
	public static Bouton lvl3multi = new Bouton("","lvl3solo.png",260,260,50,50);
	public static Bouton lvl4multi = new Bouton("","lvl4solo.jpg",320,260,50,50);
	public static Bouton lvl5multi = new Bouton("","lvl5solo.jpg",380,260,50,50);
	
	//pour choisir le nbre de joueurs et le niveau
	static int nbplayer;
	static String chosenlevelmulti;
	
	//menu multi page 2
	private Bouton player1_1 = new Bouton("","Player1down1.png",140,100,50,50);
	private Bouton player2_1 = new Bouton("","Player2down1.png",200,100,50,50);
	private Bouton player3_1 = new Bouton("","player3down1.png",260,100,50,50);
	private Bouton player4_1 = new Bouton("","player4down1.png",320,100,50,50);
	private Bouton player1_2 = new Bouton("","Player1down1.png",140,200,50,50);
	private Bouton player2_2 = new Bouton("","Player2down1.png","SoloMenuB.jpg",200,200,50,50);
	private Bouton player3_2 = new Bouton("","player3down1.png",260,200,50,50);
	private Bouton player4_2 = new Bouton("","player4down1.png",320,200,50,50);
	private Bouton player1_3 = new Bouton("","Player1down1.png","SoloMenuB.jpg",140,300,50,50);
	private Bouton player2_3 = new Bouton("","Player2down1.png","SoloMenuB.jpg",200,300,50,50);
	private Bouton player3_3 = new Bouton("","player3down1.png",260,300,50,50);
	private Bouton player4_3 = new Bouton("","player4down1.png",320,300,50,50);
	private Bouton player1_4 = new Bouton("","Player1down1.png","SoloMenuB.jpg",140,400,50,50);
	private Bouton player2_4 = new Bouton("","Player2down1.png","SoloMenuB.jpg",200,400,50,50);
	private Bouton player3_4 = new Bouton("","player3down1.png",260,400,50,50);
	private Bouton player4_4 = new Bouton("","player4down1.png",320,400,50,50);
	
	//Pour Choisir son Sprite
	static int player1img;
	static int player2img;
	static int player3img;
	static int player4img;
	
	//menu solo
	private JFormattedTextField name= new JFormattedTextField ();  
	private JLabel label = new JLabel("Nom");	
	private JButton ok = new JButton("ok");
	private Bouton lvl1solo = new Bouton("","bouton1SoloLevel1.png",20,60,100,100);
	private Bouton lvl2solo = new Bouton("","bouton2SoloLevel1.png",130,60,100,100);
	private Bouton lvl3solo = new Bouton("","bouton3SoloLevel1.png",240,60,100,100);
	private Bouton lvl4solo = new Bouton("","lvl4solo.jpg",350,60,100,100);
	private Bouton lvl5solo = new Bouton("","lvl5solo.jpg",460,60,100,100);
	private Bouton player1 = new Bouton("","Player1down1.png",170,400,50,50);
	private Bouton player2 = new Bouton("","Player2down1.png",230,400,50,50);
	private Bouton player3 = new Bouton("","player3down1.png",290,400,50,50);
	private Bouton player4 = new Bouton("","player4down1.png",350,400,50,50);
	//pour choisir son niveau et son sprite
	static String chosenlevelsolo; 
	private static int playerimg;
	
	//contructeur
	public GameView() {
		InitMenu();
		InitToolbar();	
	}
	
	//Setter, permettent de choisir le niveau, le sprite et le nbre de joueurs
	public static void setplayerimg(int a){
		playerimg = a;
	}
	public static void setchosenlevelsolo(String str){
		chosenlevelsolo = str;
	}
	public static void setchosenlevelmulti(String str){
		chosenlevelmulti = str;
	}
	public static  void setnbplayer(int a){
		nbplayer = a;
	}
	public static  void setplayer1img(int a){
		player1img = a;
	}
	public static  void setplayer2img(int a){
		player2img = a;
	}
	public static  void setplayer3img(int a){
		player3img = a;
	}
	public static  void setplayer4img(int a){
		player4img = a;
	}
	
	//Lance la barre d'outils
	public void InitToolbar(){
		this.menu1.add(item1);
		this.menu2.add(item2);
		this.menuBar.add(menu1);
		this.menuBar.add(menu2);
		item2.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent ar0){
    		Help zd = new Help(null,"Aide",true);
    		}
    	});
		item1.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent ar0){
    		
    		}
    	});
		this.setJMenuBar(menuBar);	
	}
	
	//change la barre d'outil lors d'une nouvelle partie
	public void changetoolbar(String mode){
		this.menu1.add(item3);
		if(mode=="solo"){
			item3.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent ar0){
	            manager = new GameManager(); //new !		A quoi ça sert ent fait ?
	    	}	
	    	});
			}
		if (mode=="multi"){
			item3.addActionListener(new ActionListener(){
		    	public void actionPerformed(ActionEvent ar0){
		            manager = new GameManager(); //new !	Pourquoi mettre ça ici ?
		    	}	
		    	});
		}
	}
	
	//initie le menu principal
	public void InitMenu(){	
		this.setSize(600,600);
		this.add(bsolo);
		this.add(bmulti);
		this.menupage1 = new Menu("menu2.png",600,600,0,0);
		getContentPane().add(menupage1) ;
		this.bmulti.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){
				   MenuMultipage1Launch();
				   menupage1.setVisible(false);
				   bmulti.setVisible(false);
				   bsolo.setVisible(false);
			   }
			 });
		this.bsolo.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){
				   MenuSoloLaunch();
				   menupage1.setVisible(false);
				   bsolo.setVisible(false);
				   bmulti.setVisible(false);
			   }
			 });
	}
		//lance le menu solo
		public void MenuSoloLaunch(){
			setLayout(null);
			this.add(lvl1solo);
			this.add(lvl2solo);
			this.add(lvl3solo);
			this.add(lvl4solo);
			this.add(lvl5solo);
			this.add(player1);
			this.add(player2);
			this.add(player3);
			this.add(player4);
			
			setLayout(new BorderLayout());
			this.add(ok,BorderLayout.SOUTH);
			
			//choix du niveau en solo
			this.lvl1solo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					GameView.setchosenlevelsolo("levelsolo1");
				   }
			 });
			this.lvl2solo.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					GameView.setchosenlevelsolo("levelsolo2");
				   }
			 });
			this.lvl3solo.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelsolo("levelsolo3");
				   }
			 });
			this.lvl4solo.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelsolo("levelsolo3");
				   }
			 });
			this.lvl5solo.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelsolo("levelsolo3");
				   }
			 });
			
			//choix du perso en solo
			this.player1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayerimg(1);
				   }
			 });
			this.player2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayerimg(2);
				   }
			 });
			this.player3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayerimg(3);
				   }
			 });
			this.player4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayerimg(4);
				   }
			 });
			
			//clic sur le bouton ok
			this.ok.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   Gamelaunch("solo"); 
					   player1.setVisible(false);
					   player2.setVisible(false);
					   player3.setVisible(false);
					   player4.setVisible(false);
					   ok.setVisible(false);
					   lvl1solo.setVisible(false);
					   lvl2solo.setVisible(false);
					   lvl3solo.setVisible(false);
					   lvl4solo.setVisible(false);
					   lvl5solo.setVisible(false);
					  
				   }
			 });
			
			
			
		}
		
		//lance le menu multi (a mettre en une seule fonction)
		public void MenuMultipage1Launch(){
			setLayout(null);
			this.add(p2);
			this.add(p3);
			this.add(p4);
			this.add(lvl1multi);
			this.add(lvl2multi);
			this.add(lvl3multi);
			this.add(lvl4multi);
			this.add(lvl5multi);
			setLayout(new BorderLayout());
			this.add(ok,BorderLayout.SOUTH);
			
			//choix du nombre de joueurs en multi
			this.p2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setnbplayer(2);
					   menupage1.setVisible(false);
				   }
				 });
			this.p3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setnbplayer(3);
					   menupage1.setVisible(false);
				   }
				 });
			this.p4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setnbplayer(4);
					   menupage1.setVisible(false);
				   }
				 });
			
			//choix du niveau en multi
			this.lvl1multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti1");
				   }
			 });
			this.lvl2multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti2");
				   }
			 });
			this.lvl3multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti3");
				   }
			 });
			this.lvl4multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti4");
				   }
			 });
			this.lvl5multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti5");
				   }
			 });
			
			//clic sur le bouton ok
			this.ok.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   //ModeSolo.startGame(playerimg,chosenlevel);
					   gamemenumultipage2launch(nbplayer);
					   p2.setVisible(false);
					   p3.setVisible(false);
					   p4.setVisible(false);
					   lvl1multi.setVisible(false);
					   lvl2multi.setVisible(false);
					   lvl3multi.setVisible(false);
					   lvl4multi.setVisible(false);
					   lvl5multi.setVisible(false);
				   }
			 });
		}
		
		
		//permet le choix du joueur en multi
		private void gamemenumultipage2launch(int nbplayer) {
			setLayout(null);
			if (nbplayer==2){
				this.add(player1_1);
				this.add(player2_1);
				this.add(player3_1);
				this.add(player4_1);
				this.add(player1_2);
				this.add(player2_2);
				this.add(player3_2);
				this.add(player4_2);
			}			
			else if (nbplayer==3){
				this.add(player1_1);
				this.add(player2_1);
				this.add(player3_1);
				this.add(player4_1);
				this.add(player1_2);
				this.add(player2_2);
				this.add(player3_2);
				this.add(player4_2);
				this.add(player1_3);
				this.add(player2_3);
				this.add(player3_3);
				this.add(player4_3);
			}
			else if (nbplayer==4){
				this.add(player1_1);
				this.add(player2_1);
				this.add(player3_1);
				this.add(player4_1);
				this.add(player1_2);
				this.add(player2_2);
				this.add(player3_2);
				this.add(player4_2);
				this.add(player1_3);
				this.add(player2_3);
				this.add(player3_3);
				this.add(player4_3);
				this.add(player1_4);
				this.add(player2_4);
				this.add(player3_4);
				this.add(player4_4);
			}
			setLayout(new BorderLayout());
			this.add(ok,BorderLayout.SOUTH);		
			this.player1_1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
						GameView.setplayer1img(1);
				   }
			 });
			this.player2_1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer1img(2);
				   }
			 });
			this.player3_1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer1img(3);
				   }
			 });
			this.player4_1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer1img(4);
				   }
			 });
			this.player1_2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer2img(1);
				   }
			 });
	
			this.player2_2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer2img(2);
				   }
			 });
			this.player3_2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer2img(3);
				   }
			 });
			this.player4_2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer2img(4);
				   }
			 });
			this.player1_3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer3img(1);
				   }
			 });
			this.player2_3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer3img(2);
				   }
			 });
			this.player3_3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer3img(3);
				   }
			 });
			this.player4_3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer3img(4);
				   }
			 });
			this.player1_4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer4img(1);
				   }
			 });
			this.player2_4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer4img(2);
				   }
			 });
			this.player3_4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer4img(3);
				   }
			 });
			this.player4_4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer4img(4);
				   }
			 });
			this.ok.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   
					   player1_1.setVisible(false);
					   player2_1.setVisible(false);
					   player3_1.setVisible(false);
					   player4_1.setVisible(false);
					   player1_2.setVisible(false);
					   player2_2.setVisible(false);
					   player3_2.setVisible(false);
					   player4_2.setVisible(false);
					   player1_3.setVisible(false);
					   player2_3.setVisible(false);
					   player3_3.setVisible(false);
					   player4_3.setVisible(false);
					   player1_4.setVisible(false);
					   player2_4.setVisible(false);
					   player3_4.setVisible(false);
					   player4_4.setVisible(false);
					   
					   Gamelaunch("multi");
				   }
			 });
			
			
			
		}
		public void Gamelaunch(String mode){
			
			this.manager = new GameManager();
			
			
			changetoolbar("mode");		//normal que ce soit "mode" et pas mode ?
			if (mode=="multi"){
			
			this.manager.startGame( this.nbplayer,  player1img, player2img, player3img, player4img, this.chosenlevelmulti);
			this.setSize(840,650);
			this.setTitle("Bombermon !!!");
			this.setFocusable(true);
		
			addKeyListener(manager);	
			getContentPane().setLayout(null);
			this.barreinfo = new BarreInfo();
			getContentPane().add(barreinfo);
			Dimension size1 = barreinfo.getPreferredSize();
			barreinfo.setBounds(600,0,size1.width, size1.height);
			this.pan = new GamePanel();
			getContentPane().add(pan) ;
			pan.setBounds(0,0,620, 620);
			
			ok.setVisible(false);//
			
			mainTimer = new Timer(10,this);
			mainTimer.start();
			}
			
			
			if (mode=="solo"){
			this.manager.startGameSolo(chosenlevelsolo, playerimg);
			this.setTitle("Pokebombs !!!");	
			this.setSize(430,250);
		
			this.setFocusable(true);
			addKeyListener(manager);
			this.barreinfosolo = new BarreInfoSolo();
			Dimension size2 = barreinfosolo.getPreferredSize();
			barreinfosolo.setBounds(220,0,size2.width, size2.height);
			getContentPane().add(barreinfosolo);
			this.pan = new GamePanel() ;
			getContentPane().add(pan) ;
			pan.setBounds(0,0,200, 220);
			
			ok.setVisible(false);//
			
			mainTimer = new Timer(10,this);
			mainTimer.start();
			}

			
		}
	public void actionPerformed(ActionEvent e) {		//� terminer
		manager.update() ; 			//� modifier
		repaint() ;
		
	}

}
