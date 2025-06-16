package UI;
import Controller.*;
import Model.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.OrderController;

import javax.swing.event.ListSelectionEvent;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel title;
	private JPanel searchList_Panel;
	private JPanel infoList_Panel;
	private JPanel bottomButtons_Panel;
	private JButton bottomButton1;
	private JButton bottomButton2;
	private JButton bottomButton3;
	private JLabel infoList_Label;
	private JLabel infoList_Customer_Label;
	private JList<String> infoList_List;
	private JLabel searchList_Label;
	private JTextField searchList_textField;
	private JList<String> searchList_List;
	private JPanel middleButtons_Panel;
	private JButton middleButton1;
	
	private DefaultListModel<String> searchListModel;
	private DefaultListModel<String> orderListModel;
	private ArrayList<SimpleProduct> products;
	private ArrayList<Customer> customers;
	private Customer selectedCustomer;

	enum SearchListMode { PRODUCT, CUSTOMER	}
	SearchListMode searchListMode;	
	
	private OrderController orderController;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 720, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		title = new JLabel("Title");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		searchList_Panel = new JPanel();
		searchList_Panel.setBackground(new Color(255, 0, 0));
		
		infoList_Panel = new JPanel();
		infoList_Panel.setBackground(new Color(128, 255, 0));
		
		bottomButtons_Panel = new JPanel();
		
		middleButtons_Panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(178)
							.addComponent(title, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
							.addGap(178))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(searchList_Panel, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(middleButtons_Panel, GroupLayout.PREFERRED_SIZE, 140, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(infoList_Panel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(bottomButtons_Panel, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
					.addGap(40))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(title, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(infoList_Panel, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
								.addComponent(searchList_Panel, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
							.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(142)
							.addComponent(middleButtons_Panel, GroupLayout.PREFERRED_SIZE, 115, Short.MAX_VALUE)
							.addGap(121)))
					.addGap(18)
					.addComponent(bottomButtons_Panel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		middleButton1 = new JButton("Create order");
		middleButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddProductPage();
			}
		});
		middleButton1.setFont(new Font("Tahoma", Font.BOLD, 16));
		middleButtons_Panel.add(middleButton1);
		bottomButtons_Panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		bottomButton1 = new JButton("Button1");
		bottomButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (searchListMode) {
					case SearchListMode.PRODUCT:
						showAddCustomerPage();
						break;
					case SearchListMode.CUSTOMER:
						showAddProductPage();
						break;
				}
			}
		});
		bottomButton1.setFont(new Font("Tahoma", Font.BOLD, 16));
		bottomButtons_Panel.add(bottomButton1);
		
		bottomButton2 = new JButton("Send list to customer");
		bottomButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bottomButton2.setFont(new Font("Tahoma", Font.BOLD, 16));
		bottomButtons_Panel.add(bottomButton2);
		
		bottomButton3 = new JButton("Confirm order");
		bottomButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmOrder();
			}
		});
		bottomButton3.setFont(new Font("Tahoma", Font.BOLD, 16));
		bottomButtons_Panel.add(bottomButton3);
		GridBagLayout gbl_infoList_Panel = new GridBagLayout();
		gbl_infoList_Panel.columnWidths = new int[] {150};
		gbl_infoList_Panel.rowHeights = new int[] {22, 0, 0};
		gbl_infoList_Panel.columnWeights = new double[]{1.0};
		gbl_infoList_Panel.rowWeights = new double[]{0.0, 0.0, 1.0};
		infoList_Panel.setLayout(gbl_infoList_Panel);
		
		infoList_Label = new JLabel("Order");
		infoList_Label.setHorizontalAlignment(SwingConstants.CENTER);
		infoList_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_infoList_Label = new GridBagConstraints();
		gbc_infoList_Label.insets = new Insets(5, 5, 5, 0);
		gbc_infoList_Label.gridx = 0;
		gbc_infoList_Label.gridy = 0;
		infoList_Panel.add(infoList_Label, gbc_infoList_Label);
		
		orderListModel = new DefaultListModel<>();
		
		infoList_Customer_Label = new JLabel("Customer: ");
		infoList_Customer_Label.setHorizontalAlignment(SwingConstants.CENTER);
		infoList_Customer_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_infoList_Customer_Label = new GridBagConstraints();
		gbc_infoList_Customer_Label.anchor = GridBagConstraints.WEST;
		gbc_infoList_Customer_Label.insets = new Insets(0, 5, 5, 0);
		gbc_infoList_Customer_Label.gridx = 0;
		gbc_infoList_Customer_Label.gridy = 1;
		infoList_Panel.add(infoList_Customer_Label, gbc_infoList_Customer_Label);
		infoList_List = new JList<>(orderListModel);
		GridBagConstraints gbc_infoList_List = new GridBagConstraints();
		gbc_infoList_List.insets = new Insets(5, 5, 5, 5);
		gbc_infoList_List.fill = GridBagConstraints.BOTH;
		gbc_infoList_List.gridx = 0;
		gbc_infoList_List.gridy = 2;
		infoList_Panel.add(infoList_List, gbc_infoList_List);
		GridBagLayout gbl_searchList_Panel = new GridBagLayout();
		gbl_searchList_Panel.columnWidths = new int[]{150, 0};
		gbl_searchList_Panel.rowHeights = new int[]{22, 0, 0, 0};
		gbl_searchList_Panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_searchList_Panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		searchList_Panel.setLayout(gbl_searchList_Panel);
		
		searchList_Label = new JLabel("Search products");
		searchList_Label.setHorizontalAlignment(SwingConstants.CENTER);
		searchList_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_searchList_Label = new GridBagConstraints();
		gbc_searchList_Label.insets = new Insets(5, 5, 5, 5);
		gbc_searchList_Label.gridx = 0;
		gbc_searchList_Label.gridy = 0;
		searchList_Panel.add(searchList_Label, gbc_searchList_Label);
		
		searchList_textField = new JTextField();
		searchList_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSearchList(searchList_textField.getText());
			}
		});
		searchList_textField.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_searchList_textField = new GridBagConstraints();
		gbc_searchList_textField.insets = new Insets(5, 5, 5, 5);
		gbc_searchList_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchList_textField.gridx = 0;
		gbc_searchList_textField.gridy = 1;
		searchList_Panel.add(searchList_textField, gbc_searchList_textField);
		searchList_textField.setColumns(10);
		
		searchListModel = new DefaultListModel<>();
		searchList_List = new JList<>(searchListModel);
		searchList_List.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (searchList_List.getSelectedIndex() > -1) {
						updateInfoList(searchList_List.getSelectedValue().toString());
					}					
                }
			}
		});
		GridBagConstraints gbc_searchList_List = new GridBagConstraints();
		gbc_searchList_List.insets = new Insets(5, 5, 5, 5);
		gbc_searchList_List.fill = GridBagConstraints.BOTH;
		gbc_searchList_List.gridx = 0;
		gbc_searchList_List.gridy = 2;
		searchList_Panel.add(searchList_List, gbc_searchList_List);
		contentPane.setLayout(gl_contentPane);	
		
		bottomButton2.setEnabled(false);
		bottomButton3.setEnabled(false);
		
		products = new ArrayList<SimpleProduct>();
		customers = new ArrayList<Customer>();
		orderController = new OrderController();
		
		addFakeProductsAndCustomersForTestingPurposes();
		showFrontPage();
	}
	
	public void showFrontPage() {
		title.setText("Front page");
		middleButton1.setVisible(true);
		searchList_Panel.setVisible(false);
		infoList_Panel.setVisible(false);		
		bottomButtons_Panel.setVisible(false);
	}
	
	public void showAddProductPage() {
		title.setText("Add products");
		middleButton1.setVisible(false);
		searchListModel.clear();
		searchList_textField.setText("");
		searchListMode = SearchListMode.PRODUCT;
		searchList_Panel.setVisible(true);
		searchList_Panel.setBackground(new Color(255, 0, 0));
		searchList_Label.setText("Search products");
		infoList_Panel.setVisible(true);		
		bottomButtons_Panel.setVisible(true);
		bottomButton1.setText("Add customer");
	}
	
	public void showAddCustomerPage() {
		title.setText("Add customer");
		middleButton1.setVisible(false);
		searchListModel.clear();
		searchList_textField.setText("");
		searchListMode = SearchListMode.CUSTOMER;
		searchList_Panel.setVisible(true);
		searchList_Panel.setBackground(new Color(128, 128, 255));
		searchList_Label.setText("Search customers");
		infoList_Panel.setVisible(true);
		bottomButtons_Panel.setVisible(true);
		bottomButton1.setText("Add products");
	}
	
	public void updateSearchList(String searchString) {
		ArrayList<String> container = new ArrayList<>();		
		
		switch (searchListMode) {
			case SearchListMode.PRODUCT:
				products = orderController.searchProducts(searchString);
				
				searchListModel.clear();
				
				for (SimpleProduct p: products) {
					if (p.getName().toLowerCase().contains(searchString.toLowerCase())) {
						searchListModel.addElement(p.getName());
					}
				}
				
				break;
			case SearchListMode.CUSTOMER:
				customers = orderController.searchCustomer(searchString);
				
				for (Customer c : customers) {
					if (c.getName().toLowerCase().contains(searchString.toLowerCase())) {
						searchListModel.addElement(c.getName());
					}
				}				
				
				break;
		}
	}
	
	public void updateInfoList(String selection) {
		switch (searchListMode) {
			case SearchListMode.PRODUCT:
				orderListModel.addElement(selection);				
				break;
			case SearchListMode.CUSTOMER:
				for (Customer c : customers) {
					if (c.getName() == selection) {
						selectedCustomer = c;
					}
				}
				
				infoList_Customer_Label.setText("Customer: " + selectedCustomer.getName());				
				break;
		}
		
		if (selectedCustomer != null && !orderListModel.isEmpty()) {
			bottomButton3.setEnabled(true);
		}
		
		searchList_List.clearSelection();
	}
	
	public void confirmOrder() {
		orderController.makeNewOrder("Unprocessed", (int)(Math.random()), LocalDate.now());

		//lav en get all products i container
		ArrayList<SimpleProduct> products = orderController.searchProducts("a");
		
		for (SimpleProduct p : products) {
			orderController.addProduct(p, 1);
		}
		
		//den her linje er også skod, skriv den på en bedre måde. getcustomerbyname()
		orderController.selectCustomer(selectedCustomer);
		orderController.confirmOrder();
		orderListModel.clear();
		showFrontPage();
		title.setText("Order confirmed");
	}
	
	public void addFakeProductsAndCustomersForTestingPurposes() {
		SimpleProduct product1 = new SimpleProduct(1, "Grim hammer", "a", "a", "a", "a", 1, 1, 1, 1, 1, 1, "a-20-20");
		SimpleProduct product2 = new SimpleProduct(1, "Flot hammer", "a", "a", "a", "a", 1, 1, 1, 1, 1, 1, "a-20-20");
        SimpleProduct product3 = new SimpleProduct(1, "Skruetrækker", "a", "a", "a", "a", 1, 1, 1, 1, 1, 1, "a-20-20");
        SimpleProductContainer.getInstance().addProduct(product1);
        SimpleProductContainer.getInstance().addProduct(product2);
        
        Customer customer1 = new Customer("Bob Børgesen", "a", "a", "a");
        Customer customer2 = new Customer("Bob Hansen", "a", "a", "a");
        Customer customer3 = new Customer("Arne fra Vejle", "a", "a", "a");
        CustomerContainer.getInstance().addCustomer(customer1);
        CustomerContainer.getInstance().addCustomer(customer2);
        CustomerContainer.getInstance().addCustomer(customer3);
	}
}
