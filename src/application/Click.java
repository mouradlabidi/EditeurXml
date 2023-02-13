package application;
	
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Optional;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;


public class Click extends Application {
	
	public String savedText = "";
	
	
	@Override
	public void start(Stage primaryStage) {
			//button new file
		    Button btn = new Button();
		    Image img = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\addfile.png",23, 23,false, false);
		    ImageView nv = new ImageView();
		    nv.setImage(img);
		    btn.setGraphic(nv);
		    btn.setTooltip(new Tooltip("nouveau fichier"));
		    //
		    

		    //button open folder
		    Button btn1 = new Button();
		    Image img2 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\openfolder.png",23, 23,false, false);
		    ImageView nv2 =  new ImageView();
		    nv2.setImage(img2);
		    btn1.setGraphic(nv2);
		    btn1.setTooltip(new Tooltip("ouvrir un fichier"));
		    
		    //button save
		    Button btn2 = new Button();
		    Image img3 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\Save.png",23, 23,false, false);
		    ImageView nv3 =  new ImageView();
		    nv3.setImage(img3);
		    btn2.setGraphic(nv3);
		    btn2.setTooltip(new Tooltip("Enregistrer"));
		    
		    //button vérifier la justesse du fichier
		    Button btn3 = new Button();
		    Image img4 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\juste.png",23, 23,false, false);
		    ImageView nv4 = new ImageView();
		    nv4.setImage(img4);
		    btn3.setGraphic(nv4);
		    btn3.setTooltip(new Tooltip("Bien formé!"));
		    
		    //button validité
		    Button btn4 = new Button();
		    Image img5 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\valide.png",23, 23,false, false);
		    ImageView nv5 = new ImageView();
		    nv5.setImage(img5);
		    btn4.setGraphic(nv5);
		    btn4.setTooltip(new Tooltip("Valide"));
		    
		    //button search Element searchElement
		    Button btn5 = new Button();
		    Image img6 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\searchElement.png",23, 23,false, false);
		    ImageView nv6 = new ImageView();
		    nv6.setImage(img6);
		    btn5.setGraphic(nv6);
		    btn5.setTooltip(new Tooltip("chercher un Element"));
		    
		    //button search atrribut
		    Button btn6 = new Button();
		    Image img7 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\findAttribut.png",23, 23,false, false);
		    ImageView nv7 = new ImageView();
		    nv7.setImage(img7);
		    btn6.setGraphic(nv7);
		    btn6.setTooltip(new Tooltip("chercher un Attribut"));
		    //button transforme
		    Button btn7 = new Button();
		    Image img8 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\Transforme.png",23, 23,false, false);
		    ImageView nv8 = new ImageView();
		    nv8.setImage(img8);
		    btn7.setGraphic(nv8);
		    btn7.setTooltip(new Tooltip("Transforme"));
		    
		    
		    
		   
		    
			BorderPane root = new BorderPane();
			
			// create a VBox
			VBox rootVbox = new VBox();
			VBox footerVbox = new VBox();
			//create a HBox
			HBox rootHbox = new HBox();
			//
			rootHbox.setPadding(new Insets(2,0,2,13));
			rootHbox.setSpacing(2);
			rootHbox.getChildren().addAll(btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7);
			
			
			 // create a menu
	        Menu m = new Menu("Fichier");
	        Menu menu2 = new Menu("Analyser");
	        Menu menu3 = new Menu("Rechercher");
	        Menu menu4 = new Menu("Transformer");
	  
	        // create menuitems to Menu (File) with icon
	        MenuItem m1 = new MenuItem("Créer");
	        ImageView create= new ImageView();
	        create.setImage(img);
	        m1.setGraphic(create);
	        m1.setAccelerator(KeyCombination.keyCombination("Alt + shift + N"));
	        MenuItem m2 = new MenuItem("Ouvrir");
	        ImageView open= new ImageView();
	        open.setImage(img2);
	        m2.setGraphic(open);
	        m2.setAccelerator(KeyCombination.keyCombination("Ctrl + O"));
	        MenuItem m3 = new MenuItem("Enregistrer");
	        ImageView save= new ImageView();
	        save.setImage(img3);
	        m3.setGraphic(save);
	        m3.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
	        MenuItem m4 = new MenuItem("Quitter");
	        ImageView exit= new ImageView();
	        Image img10 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\exit.png",23, 23,false, false);
	        exit.setImage(img10);
	        m4.setGraphic(exit);
	       
	        
	        // add menu items to menu (File)
	        m.getItems().addAll(m1, m2, m3, m4);
	        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
	        m.getItems().add(3, separatorMenuItem);
	        
	  
	        // create menuitems to Menu (Analyser) with icons
	        MenuItem mA1 = new MenuItem("Vérifier justesse de forme");
	        ImageView vérifier= new ImageView();
	        vérifier.setImage(img4);
	        mA1.setGraphic(vérifier);
	        MenuItem mA2 = new MenuItem("Validé");
	        ImageView valider= new ImageView();
	        valider.setImage(img5);
	        mA2.setGraphic(valider);
	        /*MenuItem mA3 = new MenuItem("Enregistrer");
	        MenuItem mA4 = new MenuItem("Quitter");*/
	        
	        // add menu items to menu (Analyser)
	        menu2.getItems().add(mA1);
	        menu2.getItems().add(mA2);
	        /*menu2.getItems().add(mA3);
	        menu2.getItems().add(mA4);*/
	        
	        
	        // create menuitems to Menu (Rechercher) with icons
	        MenuItem mR1 = new MenuItem("Elément");
	        ImageView element= new ImageView();
	        element.setImage(img6);
	        mR1.setGraphic(element);
	        MenuItem mR2 = new MenuItem("Attribut");
	        ImageView attribut= new ImageView();
	        attribut.setImage(img7);
	        mR2.setGraphic(attribut);
	        
	        // add menu items to menu (Analyser) 
	        menu3.getItems().add(mR1);
	        menu3.getItems().add(mR2);
	        
	        // create menuitems to Menu (Transformer) woth icons
	        MenuItem mT1 = new MenuItem("Transformer");
	        ImageView transforme= new ImageView();
	        transforme.setImage(img8);
	        mT1.setGraphic(transforme);
	        
	        // add menu items to menu (Transformer)
	        menu4.getItems().add(mT1);
	        
	        // create a menubar
	        MenuBar mb = new MenuBar();
	  
	        // add menu to menubar
	        mb.getMenus().addAll(m, menu2, menu3, menu4);
	        
	        // add menubar and Hbox to VBox
	        rootVbox.getChildren().addAll(mb, rootHbox);
	        
	        Label labelInfo = new Label("");
	        Label labeldisplay = new Label(" ");
	        
	        labelInfo.setPadding(new Insets(5,0,0,15));
	        labelInfo.setTextFill(Color.BLUE);
	        labelInfo.setText("Information");
	        
	        labeldisplay.setPadding(new Insets(5,10,20,23)); 

	        
	        footerVbox.getChildren().addAll(labelInfo, labeldisplay);
			
	        //TabPane pour text area
	        final TabPane tabPane = new TabPane();
	        
	        Tab tab1 = new Tab("Tab "+1);
	        
	        StackPane pane1 = new StackPane();
	        Label lbl=new Label();
	        lbl.setText("ctrl + O\n Alt + shift + N\n");        
	        lbl.setTextAlignment(TextAlignment.CENTER);
	        //TextArea textar1= new TextArea();       
	        pane1.getChildren().add(lbl);
	        tab1.setContent(pane1);
		    tabPane.getTabs().add(tab1);	       
	        Tab NewTab = new Tab("+");
	        tabPane.getTabs().add(NewTab);
	        NewTab.setOnSelectionChanged(e->{	
	        	
        		opentab(tabPane);	        		 
        });
	        
	        final BooleanProperty fileModified = new SimpleBooleanProperty(false);
	        final BooleanProperty titleModified = new SimpleBooleanProperty(false);
	        //final BooleanProperty Modified = new SimpleBooleanProperty(false);
	        
	        //**************************************-----------------------------
	       
	        
		//écouteur pour mettre à jour le titre de l'onglet  lorsqu'un utilisateur modifie le contenu de la zone de texte associée
	        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	            try {
		        	StackPane stackPane = (StackPane) newValue.getContent();
		            TextArea textArea = (TextArea) stackPane.lookup("TextArea");
		            String s = textArea.getText();
		            textArea.textProperty().addListener((observableTextArea, oldText, newText) -> {
		            	if (!textArea.getText().equals(savedText)) {
			                fileModified.set(true);
			                String title = newValue.getText();
			                if (!title.endsWith(" *")) {
			                    newValue.setText(title + " *");
			                }
			                titleModified.set(true);
		                }
		            	else {
		            		 String title = newValue.getText();
					         String result = title.replace(" *", "");
					         newValue.setText(result);
		            	}
		            });
	            }catch(Exception e) {
	            	//
	            }
	        });
	        
	        	     
	        
	        
	       
	        
	        
			Scene scene = new Scene(root,900,600);
			//root.add(btn, 2, 2);
			
			root.setTop(rootVbox);
			root.setCenter(tabPane);
			//root.setCenter(hbtext);
			root.setBottom(footerVbox);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Editor XML");
			Image img9 = new Image("C:\\Users\\dreams\\Documents\\Eclipse Project\\Click\\src\\EditorXml.png");
			primaryStage.getIcons().add(img9);
			//primaryStage
			primaryStage.show();
			
			
			
			
			//add event createTab to menuitem and Button
	        m1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					opentab(tabPane);
				}
	        	
	        });
	        btn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					opentab(tabPane);
				}
	        	
	        });
			
			//---------------------------------------------------------------------------------------------------------------//
			//add event filechooser to menuitem and button
			
			m2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					openFile(primaryStage,tabPane);		
			
				}	} );
			btn1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					openFile(primaryStage,tabPane);			
				}
				
			});
			

			
			//add event save ---------------------------------------------
			m3.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					if(fileModified.get()) {
					     
					      //String name=selectedFile.getName();
		                  Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();	
		             
			                  try {
			                	  
			                	  String title =selectedTab.getText();
							      String result = title.replace(" *", "");
							      System.out.println(result);
			                	  Path filea = Paths.get(result);
				                  System.out.println("Chemin absolu du fichier : " + filea.toAbsolutePath().toString());
				                  File file = new File(filea.toAbsolutePath().toString());
				                  if (!file.exists()) {
				                	  	//file.delete();
				                	    throw new FileNotFoundException("Le fichier n'existe pas.");
				                	  }
				                  savefile(file,tabPane);
				                  
			                     
			                    } catch (FileNotFoundException e) {
			                      
			                      	FileChooser fileChooser=file();
									fileChooser.setTitle("Enregistrer Sous");
									 File file = fileChooser.showSaveDialog(primaryStage);
									 System.out.println("Le fichier n'existe pas." + file.getName().toString());
									 selectedTab.setText(file.getName().toString());
									 savefile(file,tabPane);
			                    }
		                 
		                 // }
			         titleModified.set(false);
			         fileModified.set(false);
			         String title = selectedTab.getText();
			         
			         String result = title.replace(" *", "");
			         selectedTab.setText(result);
			         //Modified.set(true);
					    
				} }
			});
			btn2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(fileModified.get()) {
					     
					      //String name=selectedFile.getName();
		                  Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();	
		             
			                  try {
			                	  
			                	  String title =selectedTab.getText();
							      String result = title.replace(" *", "");
							      System.out.println(result);
			                	  Path filea = Paths.get(result);
				                  System.out.println("Chemin absolu du fichier : " + filea.toAbsolutePath().toString());
				                  File file = new File(filea.toAbsolutePath().toString());
				                  if (!file.exists()) {
				                	  	//file.delete();
				                	    throw new FileNotFoundException("Le fichier n'existe pas.");
				                	  }
				                  savefile(file,tabPane);
				                  
			                     
			                    } catch (FileNotFoundException e) {
			                      
			                      	FileChooser fileChooser=file();
									fileChooser.setTitle("Enregistrer Sous");
									 File file = fileChooser.showSaveDialog(primaryStage);
									 System.out.println("Le fichier n'existe pas." + file.getName().toString());
									 selectedTab.setText(file.getName().toString());
									 savefile(file,tabPane);
			                    }
		                 
		                 // }
			         titleModified.set(false);
			         fileModified.set(false);
			         String title = selectedTab.getText();
			         
			         String result = title.replace(" *", "");
			         selectedTab.setText(result);
			         //Modified.set(true);
					    
				} }
				
			});
			
			
			
			//add event exit
			m4.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			});
			
			
			//addevent Bien formé to Button and menuItem
			mA1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					bienformé(tabPane,labeldisplay);
				}
				
			});
			
			btn3.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					bienformé(tabPane,labeldisplay);
				}
				
			});
           
			
			//add event Validé to Button and MeniItem
			btn4.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Valide(tabPane,labeldisplay);
				}
				
			});
			
			mA2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Valide(tabPane,labeldisplay);
				}
				
			});
			
			//add event charcher un élément
			btn5.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					ChercherElement(tabPane,labeldisplay);
				} 
				
			});
			
			mR1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					ChercherElement(tabPane,labeldisplay);
				} 
				
			});
			
			//add event chercher un attribut
			btn6.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					ChercherAttribut(tabPane,labeldisplay);
				}
				
			});			
			
			mR2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					ChercherAttribut(tabPane,labeldisplay);
				}
				
			});
			
			// add event to transformer
			mT1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();	
					String tit = selectedTab.getText();
	                if (tit.endsWith(".xsl")) {
						try {
						
							String xsld = tit.replace(" *", "");
						      System.out.println(xsld);
		                	  Path filea = Paths.get(xsld);
			                  System.out.println("Chemin absolu du fichier : " + filea.toAbsolutePath().toString());
			                  /*File file = new File(filea.toAbsolutePath().toString());
			                  if (!file.exists()) {
			                	  	//file.delete();
			                	    throw new FileNotFoundException("Le fichier n'existe pas.");
			                	  }*/
			                  String xmld = xsld.replace(".xsl", ".xml");
			                  Path fileb = Paths.get(xmld);
							//Obtenir une nouvelle instance de a TransformerFactory
					        
	
					        Source xslDoc=new StreamSource(filea.toAbsolutePath().toString());
					        Source xmlDoc=new StreamSource(fileb.toAbsolutePath().toString());
					       
					        String outputFileName=xsld.replace(".xsl", ".html");

					        TransformerFactory tFactory=TransformerFactory.newInstance(); 
					        OutputStream htmlFile=new FileOutputStream(outputFileName);
					      //Une instance de cette classe abstraite peut transformer une arborescence source en une arborescence de résultats.
					        Transformer trasform=tFactory.newTransformer(xslDoc);
					        trasform.transform(xmlDoc, new StreamResult(htmlFile));
					        System.out.print("aaa");
					        
					        if (Desktop.isDesktopSupported()) {
					            Desktop desktop = Desktop.getDesktop();
					            try {
					                File file = new File(outputFileName);
					                desktop.open(file);
					            } catch (IOException e) {
					                e.printStackTrace();
					            }
					        }
					        
				    } 
				    catch (FileNotFoundException e) 
				    {
				        e.printStackTrace();
				    }
				    catch (TransformerConfigurationException e) 
				    {
				        e.printStackTrace();
				    }
				    catch (TransformerFactoryConfigurationError e) 
				    {
				        e.printStackTrace();
				    }
				    catch (TransformerException e) 
				    {
				        e.printStackTrace();
				    }
				}}
				
			});
			
			btn7.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();	
					String tit = selectedTab.getText();
	                if (tit.endsWith(".xsl")) {
	                	//tit.setText(tit + " *");
							try {
								
								  String xsld = tit.replace(" *", "");
							      System.out.println(xsld);
			                	  Path filea = Paths.get(xsld);
				                  System.out.println("Chemin absolu du fichier : " + filea.toAbsolutePath().toString());
				                  /*File file = new File(filea.toAbsolutePath().toString());
				                  if (!file.exists()) {
				                	  	//file.delete();
				                	    throw new FileNotFoundException("Le fichier n'existe pas.");
				                	  }*/
				                  String xmld = xsld.replace(".xsl", ".xml");
				                  Path fileb = Paths.get(xmld);
								//Obtenir une nouvelle instance de a TransformerFactory
						        TransformerFactory tFactory=TransformerFactory.newInstance(); 
		
						        Source xslDoc=new StreamSource(filea.toAbsolutePath().toString());
						        Source xmlDoc=new StreamSource(fileb.toAbsolutePath().toString());
						       
						        String outputFileName=xsld.replace(".xsl", ".html");
		
						        OutputStream htmlFile=new FileOutputStream(outputFileName);
						      //Une instance de cette classe abstraite peut transformer une arborescence source en une arborescence de résultats.
						        Transformer trasform=tFactory.newTransformer(xslDoc);
						        trasform.transform(xmlDoc, new StreamResult(htmlFile));
						        System.out.print("aaa");
						        
						        if (Desktop.isDesktopSupported()) {
						            Desktop desktop = Desktop.getDesktop();
						            try {
						                File file = new File(outputFileName);
						                desktop.open(file);
						            } catch (IOException e) {
						                e.printStackTrace();
						            }
						        }
						        
						    } 
						    catch (FileNotFoundException e) 
						    {
						        e.printStackTrace();
						    }
						    catch (TransformerConfigurationException e) 
						    {
						        e.printStackTrace();
						    }
						    catch (TransformerFactoryConfigurationError e) 
						    {
						        e.printStackTrace();
						    }
						    catch (TransformerException e) 
						    {
						        e.printStackTrace();
						    }
				}
				}
				
			});
			/*--------------------------------------------------------------------------------------

			 
			  
			  
			 */
			// ajouter les raccourcis 
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			    @Override
			    public void handle(KeyEvent event) {
			        if (event.getCode() == KeyCode.O && event.isControlDown()) {
			            // Code pour ouvrir le fichier ici
			        	openFile(primaryStage,tabPane);
			        }
			    }
			});
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			    @Override
			    public void handle(KeyEvent event) {
			        if (event.getCode() == KeyCode.S && event.isControlDown()) {
			            // Code pour sauvegarder le fichier ici
			        	if(fileModified.get()) {
						     
						      //String name=selectedFile.getName();
			                  Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();	
			             
				                  try {
				                	  
				                	  String title =selectedTab.getText();
								      String result = title.replace(" *", "");
								      System.out.println(result);
				                	  Path filea = Paths.get(result);
					                  System.out.println("Chemin absolu du fichier : " + filea.toAbsolutePath().toString());
					                  File file = new File(filea.toAbsolutePath().toString());
					                  if (!file.exists()) {
					                	  	//file.delete();
					                	    throw new FileNotFoundException("Le fichier n'existe pas.");
					                	  }
					                  savefile(file,tabPane);
					                  
				                     
				                    } catch (FileNotFoundException e) {
				                      
				                      	FileChooser fileChooser=file();
										fileChooser.setTitle("Enregistrer Sous");
										 File file = fileChooser.showSaveDialog(primaryStage);
										 System.out.println("Le fichier n'existe pas." + file.getName().toString());
										 selectedTab.setText(file.getName().toString());
										 savefile(file,tabPane);
				                    }
			                 
			                 // }
				         titleModified.set(false);
				         fileModified.set(false);
				         String title = selectedTab.getText();
				         
				         String result = title.replace(" *", "");
				         selectedTab.setText(result);
				         //Modified.set(true);
						    
					} 
			        }
			    }
			});
			
			KeyCodeCombination keyCodeCombination = new KeyCodeCombination(KeyCode.N, KeyCombination.SHIFT_DOWN, KeyCombination.ALT_DOWN);
			
			scene.getAccelerators().put(keyCodeCombination, new Runnable() {
			    @Override public void run() {
			        // Code to be executed when the key combination is pressed
			    	// Code pour créer le fichier ici
			    	opentab(tabPane);
			    }
			});
		//*************************************************************************************************************//
	}
	
	
	
	
	public File savefile(File file, TabPane tabPane) {
		if (file != null) {
            String filePath = file.getPath();
            try {
            	 Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
     			Node selectedTabContent = selectedTab.getContent();
     			if (selectedTabContent instanceof StackPane) {
     				StackPane selectedStackPane = (StackPane) selectedTabContent;
     			    
     			    ObservableList<Node> children = selectedStackPane.getChildren();
     			    for (Node child : children) {
     			        if (child instanceof TextArea) {
     			            TextArea textArea = (TextArea) child;
			                FileOutputStream fos = new FileOutputStream(filePath);
			                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			                BufferedWriter bw = new BufferedWriter(osw);
			                bw.write(textArea.getText());
			                savedText = "";
			                savedText = textArea.getText();
			                bw.flush();
			                bw.close();
     			        }}}
                 }
            catch (IOException ioe) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText("Opps.. There is a problem");
                alert.setContentText(ioe.getMessage());
                alert.show();
            }
		}
		return file;
	}
	
	
	public TextArea opentab(TabPane tabPane) {
		
		Tab tab = new Tab("Tab "+tabPane.getTabs().size());
    	StackPane pane = new StackPane();
    	TextArea textar= new TextArea();
    	pane.getChildren().add(textar);
    	tab.setContent(pane);
    	tabPane.getTabs().add(tabPane.getTabs().size()-1, tab);
    	tabPane.getSelectionModel().select(tabPane.getTabs().size()-2);
    	return textar;
	}
	
	 final void openFile(Stage primaryStage,TabPane tabPane) {
		 		FileChooser fileChooser=file();
				// TODO Auto-generated method stub
				fileChooser.setTitle("Ouvrir");
	            File selectedFile = fileChooser.showOpenDialog(primaryStage);
				if (selectedFile != null) {
	                 String filePath = selectedFile.getPath();
	                 
	                 try {
	                     BufferedReader br = new BufferedReader(new FileReader(filePath));
	                     String line = "";
	                     String text = "";
	                     while ((line = br.readLine()) != null) {
	                         text += line + "\n";
	                     }
	                     TextArea textar1=opentab(tabPane);
	                     textar1.setText(text);
	                     
	                     String name=selectedFile.getName();
	                     Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();	
	 					 selectedTab.setText(name);
	                     
	                     br.close();
	                     
	                 }
	                 catch (IOException ioe) {
	                     Alert alert = new Alert(AlertType.INFORMATION);
	                     alert.setTitle("ERROR");
	                     alert.setHeaderText("Opps.. There is a problem");
	                     alert.setContentText(ioe.getMessage());
	                     alert.show();
	                 }
	                 
             }
			
		 
         /*if (file != null) {
        	 try {   
        		 
        			this.desktop.open(file);
        			List<File> files = Arrays.asList(file);
             String name=file.getName();
             try {
					Scanner scanner= new Scanner(file);
					TextArea textar1=opentab(tabPane);
					Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();						
					selectedTab.setText(name);
					while(scanner.hasNextLine()) {								
						textar1.appendText(scanner.nextLine()+"\n");							
					}
					scanner.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	     }catch(IOException e){
        	    	 e.printStackTrace();
        	     }           	        
         }*/
			
	     
	    }
	public FileChooser file() {
		 final FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().addAll(//
					new FileChooser.ExtensionFilter("All Files", "*.*"),//
					new FileChooser.ExtensionFilter("XML","*.xml"),//
					new FileChooser.ExtensionFilter("XHML","*.html"),//
					new FileChooser.ExtensionFilter("DTD","*.dtd"),//
					new FileChooser.ExtensionFilter("XML Shema","*.xsd"),//
					new FileChooser.ExtensionFilter("XSL","*.xsl"));
			fileChooser.setTitle("Selectionner un Fichier");
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			return fileChooser;
	}
	
	public void bienformé(TabPane tabPane, Label labeldisplay) {
		 
		try {
			Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
			Node selectedTabContent = selectedTab.getContent();
			if (selectedTabContent instanceof StackPane) {
				StackPane selectedStackPane = (StackPane) selectedTabContent;
			    
			    ObservableList<Node> children = selectedStackPane.getChildren();
			    for (Node child : children) {
			        if (child instanceof TextArea) {
			            TextArea textArea = (TextArea) child;
			            // Do something with the text area
			            
			            SAXBuilder saxBuilder = new SAXBuilder();
	                    
	                    String content = textArea.getText();

	                    Document document = saxBuilder.build(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
	                    //saxBuilder.setValidation(true);
	                    labeldisplay.setText("Document bien formé");
			            break;
			        }
			    }						    
			}
            }       	
                catch (Exception e1) { //Catch the exception if any occurs and print the error message in console output.
                       // System.out.println(e1.getMessage());
                     // Header Text: null
                	labeldisplay.setText("Document n'est pas bien formé\n"+" à cause de "+e1.getMessage());
                }
	}
	
	public void Valide(TabPane tabPane, Label labeldisplay) {
		
		
		// par rapport à un xmlshéma
		Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();	
		String tit = selectedTab.getText();
        if (tit.endsWith(".xml") || tit.endsWith(".xsl")) {
        	
				try {
					
					String xmld = tit.replace(" *", "");
				      System.out.println(xmld);
				      // path of file xml
				      Path filea = Paths.get(xmld);
	                  System.out.println("Chemin absolu du fichier : " + filea.toAbsolutePath().toString());
	                  String xsdd = xmld.replace(".xml", ".xsd");
	                  //cheimn of file xsd
	                  Path fileb = Paths.get(xsdd);
	                  
					System.out.println("------validation par rapport xsd-------");
					SchemaFactory schemaFactory = SchemaFactory
							  .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
					Schema schema = schemaFactory.newSchema(new File(fileb.toAbsolutePath().toString()));
					//Schema schema = schemaFactory.newSchema(new File("C:\\Users\\dreams\\AppData\\Local\\XML Copy Editor\\XML COPY TP\\galeries.xsd"));
					Validator validator = schema.newValidator();
					validator.validate(new StreamSource(new File(filea.toAbsolutePath().toString())));
					//validator.validate(new StreamSource(new File("C:\\Users\\dreams\\AppData\\Local\\XML Copy Editor\\XML COPY TP\\galeries.xml")));
					
					System.out.println("validé par rapport xsd");
					labeldisplay.setText("Validé par rapport xsd");
					}   catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("à cause de "+e.getMessage());
						}
						catch (SAXParseException e) {
						labeldisplay.setText("Erreur lors du validation du xml par rapport au xml shéma\n"+e.getMessage()+"\n"+"ligne : "+e.getLineNumber()+"\n"+"colonne : "+e.getColumnNumber());
						 System.out.println("Erreur lors du validation du xml par rapport au xml shéma");
						 System.out.println(e.getMessage());
						 System.out.println("ligne : "+e.getLineNumber());
						 System.out.println("colonne : "+e.getColumnNumber());
						 }
						catch (SAXException e) {
							// TODO Auto-generated catch block
							labeldisplay.setText("à cause de "+e.getMessage());
							System.out.println("à cause de "+e.getMessage());			
						}
        }
        /*try {
		Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
		Node selectedTabContent = selectedTab.getContent();
		if (selectedTabContent instanceof StackPane) {
			StackPane selectedStackPane = (StackPane) selectedTabContent;
		    
		    ObservableList<Node> children = selectedStackPane.getChildren();
		    for (Node child : children) {
		        if (child instanceof TextArea) {
		            TextArea textArea = (TextArea) child;
		            // Do something with the text area
			    	
			    	SAXBuilder saxBuilder = new SAXBuilder();
			    	String content = textArea.getText();
			    	try {
			    		Document document = saxBuilder.build(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
			    		labeldisplay.setText("document est valide");
						
						}
					 catch (JDOMException e) {
						 labeldisplay.setText("document n'est pas valide\n");
						 labeldisplay.setText("à cause de "+e.getMessage());
					 }catch(IOException e){
						 	labeldisplay.setText("Could not check ");
						 	labeldisplay.setText("à cause de "+e.getMessage());
						}
		            break;
		        }
		    }						    
		 }            
        }catch (Exception e1) { //Catch the exception if any occurs and print the error message in console output.
                   // System.out.println(e1.getMessage());
                 // Header Text: null
        	labeldisplay.setText("document n'est pas bien formé\n");
			labeldisplay.setText("à cause de "+e1.getMessage());
            }*/
	}
	
	public void ChercherElement(TabPane tabPane, Label labeldisplay) {
		Optional<String> name;
        // Fetch user input
        TextInputDialog textDialog = new TextInputDialog();
        textDialog.setTitle("Recherche Element");
        textDialog.setHeaderText(null);

        textDialog.setContentText("Element");
        name = textDialog.showAndWait();
        
	        try {
	         SAXBuilder saxBuilder = new SAXBuilder();
	         String element= name.get();
	            
	            Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
				Node selectedTabContent = selectedTab.getContent();
				if (selectedTabContent instanceof StackPane) {
					StackPane selectedStackPane = (StackPane) selectedTabContent;
				    
				    ObservableList<Node> children = selectedStackPane.getChildren();
				    for (Node child : children) {
				        if (child instanceof TextArea) {
				            TextArea textArea = (TextArea) child;
				            // Do something with the text area
				            String content = textArea.getText();
	
				            Document document = saxBuilder.build(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
				            XPathFactory xFactory = XPathFactory.instance();
				            // System.out.println(xFactory.getClass());
	
				            // select all elements
				            XPathExpression<Element> expr = xFactory.compile("//"+element, Filters.element());
				            List<Element> links = expr.evaluate(document);
				            String result = "";
				            for (Element linkElement : links) {
				            	result += new XMLOutputter().outputString(linkElement) + "\n";
				            }
				         if(result!="") {labeldisplay.setText(result);} 
				         else {
				        	labeldisplay.setText("element introuvable");
				         }
				           
				        }}}
				        }catch(Exception ex) {
				        	labeldisplay.setText("element introuvable");
					    Alert alert = new Alert(AlertType.ERROR);
					        alert.setTitle("Recherche");
					        alert.setHeaderText(null);
					        alert.setContentText("element introuvable");
					        alert.showAndWait();
				         		           
	        }
	}
	
	public void ChercherAttribut(TabPane tabPane, Label labeldisplay) {
		// Recherche attribut
	       
	     
	        Optional<String> name;
	           // Fetch user input
	        TextInputDialog textDialog = new TextInputDialog();
	           textDialog.setTitle("Recherche Attribut");
	           textDialog.setHeaderText(null);

	           textDialog.setContentText("Attribut");
	           name = textDialog.showAndWait();
	       
	           try {
	            SAXBuilder saxBuilder = new SAXBuilder();
	               String attribute= name.get();
	               Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
				   Node selectedTabContent = selectedTab.getContent();
				if (selectedTabContent instanceof StackPane) {
					StackPane selectedStackPane = (StackPane) selectedTabContent;
				    
				    ObservableList<Node> children = selectedStackPane.getChildren();
				    for (Node child : children) {
				        if (child instanceof TextArea) {
				            TextArea textArea = (TextArea) child;
				            // Do something with the text area
				            String content = textArea.getText();
				            
	   
				            Document document = saxBuilder.build(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
				            XPathFactory xFactory = XPathFactory.instance();
				            // System.out.println(xFactory.getClass());
	   
				            // select all links
				            XPathExpression<Attribute> exp = xFactory.compile("//@"+attribute, Filters.attribute());
				            List<Attribute> ids = exp.evaluate(document);
				            String result = "";
				            
					         for (Attribute id  : ids) {
					              result +=  id + "\n";
				
					           }
					         if(result!="") {labeldisplay.setText(result);} 
					         else {
					        	labeldisplay.setText("Attribut introuvable");
					         }
				        }}}    
							    }catch(Exception ex) {
							    labeldisplay.setText("Attribut introuvable");
							    Alert alert = new Alert(AlertType.ERROR);
							        alert.setTitle("Recherche");
							        alert.setHeaderText(null);
							        alert.setContentText("attribut introuvable");
							        alert.showAndWait();
							           
							           }
	       
	           
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}