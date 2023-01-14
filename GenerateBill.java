
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GenerateBill extends JFrame{

   JTextField food,quantity;
   String[] columnNames = {"Food Name",
                        "Quantity",
                        "Price"
            };
   JTable cart;
   
   
  // JLabel totalP = new JLabel("TOTAL PRICE : 0.0tk");
   JLabel totalP = new JLabel();
   Object data[][] = new Object[100][3];
   int i = 0;
   double totalprice = 0;
    ArrayList<foodCart> foodList = new ArrayList<>();

   GenerateBill(){
       JPanel jp1 = new JPanel();
		
		setBackground(Color.red);
		//jp1.getContentPane().setBackground(Color.orange);
		 
       this.setLayout(new GridLayout(2,2));
	   
       JLabel a = new JLabel("Food Name : ");
       jp1.add(a);
       food = new JTextField(50);
       jp1.add(food);
       JLabel b = new JLabel("Quantity : ");
       jp1.add(b);
       quantity = new JTextField(50);
       jp1.add(quantity);

       JButton ok = new JButton("OK");

       JPanel jp2 = new JPanel();
       jp2.setSize(700, 400);
       jp1.add(ok);
       ok.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
           
         }
      });
       cart = new JTable(data, columnNames);
       cart.setSize(300, 450);
       //cart.setEnabled(false);
//       jp2.setLayout(new GridLayout(1,1));
       jp2.setLayout(new FlowLayout());
       jp2.add(totalP);
       jp2.add(new JScrollPane(cart, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
       JButton checkOut = new JButton("CheckOut");
       checkOut.setSize(40, 50);
       jp2.add(checkOut);
       checkOut.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             int count = 1;
            for(foodCart fc : foodList){
                System.out.println(count + ": Food Name : " + fc.name + " Quantity : "+ fc.quantity + " Price : " + fc.totalPer + "tk");

            }
            double vat = 15;
            System.out.println("Total Cost : " + (totalprice+totalprice*vat) + "tk");

            JOptionPane.showMessageDialog(null, "Total Cost : " + (totalprice+totalprice*vat/100) + "tk with vat " + vat+"%");
            hide();
         }
      });


       this.add(jp1);
       this.add(jp2);
       this.setSize(600,550);
	    this.setLocationRelativeTo(null);
       this.setVisible(true);
   }


class foodCart{
    String name;
    Double totalPer;
    int quantity;
}

}
