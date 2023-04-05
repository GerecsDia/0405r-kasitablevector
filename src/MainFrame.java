import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;


public class MainFrame extends JFrame implements ActionListener {

    private JTable table;
    private DefaultTableModel dft;

    MainFrame() {

        initComponents();
    }

    private void initComponents() {

        this.setSize(400, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setLayout(new GridLayout(1, 1));
        this.setLayout(null);

        JButton button = new JButton("Go");
        button.setBounds(310, 130, 80, 25);
        this.add(button);


        Vector<String> columnNames = new Vector<>();
        columnNames.add("Első");
        columnNames.add("Második");
        columnNames.add("Harmadik");

        Vector<Vector<String>> data = new Vector<>();           //a külső vectorba a belső vectort beleraknom, nem a Stringet
        
        Vector<String> row = new Vector<>();
        row.add("1-1");
        row.add("1-2");
        row.add("1-3");
        data.add(row);
        row = null;                             //itt kinullázzuk, uh utána tölthetjük bele újra az adatot

        row = new Vector<>();
        row.add("2-1");
        row.add("2-2");
        row.add("2-3");
        data.add(row);
        row = null;

        row = new Vector<>();
        row.add("3-1");
        row.add("3-2");
        row.add("3-3");
        data.add(row);
        
        dft = new DefaultTableModel(data, columnNames);
        table = new JTable();                      //nem adok neki át adatot, mert a modelben vannak az adatok
        table.setModel(dft);
        

        JScrollPane jsp = new JScrollPane(table); 
        jsp.setBounds(0, 0, 400, 100);                  
        this.add(jsp);    
        
        button.addActionListener(new ActionListener() {
            
            
            public void actionPerformed(ActionEvent event) {

                getProperties();
                getSelectData();
                setData();
                addRows();


            }
        });

        
    }
    
    private void getProperties() {

        int row = table.getRowCount();
        System.out.println(row);
        int col = table.getColumnCount();
        System.out.println(col);
    }

    private void getSelectData() {

        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();

        String data = dft.getValueAt(row, col).toString();
        System.out.println(data);

    }

    private void setData() {

        table.setValueAt("Módosítva", 0, 1);       //az adatot a getValueAt adta, a setValueAt meg írja
    }

    //hogyan tudunk hozzáadni új sort:

    private void addRows() {

        Vector<String> newRow = new Vector<>();
        newRow.add("New01");
        newRow.add("New02");
        newRow.add("New03");

        for( int i = 0; i <5; i++) {

        dft.addRow(newRow);

        

        }


        

    }

    
}
