import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BBallLineup extends JFrame {
    static JButton button = new JButton("Generate a new lineup");
    static JLabel lineup =new JLabel("This will display the lineup");  
    public static void main(String[] args){
        JFrame frame = new JFrame("Generate roster");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] names = {"Joe","Jim","Jeremy","Joshua","Jane","Jean", "Jimbob","Joshua", "Jeanie","Jeremy2"};
        generate(names);
        
        button.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    generate(names);
                }  
            }
        ); 
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        button.setAlignmentX(Box.CENTER_ALIGNMENT);
        lineup.setAlignmentX(Box.CENTER_ALIGNMENT);
        button.setAlignmentY(Box.CENTER_ALIGNMENT);
        lineup.setAlignmentY(Box.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(500,100));
       p.add(Box.createVerticalGlue());
        p.add(button);
        p.add(lineup);
        p.add(Box.createVerticalGlue());
        frame.add(p);
        button.setBackground(Color.cyan);
        lineup.setForeground(Color.cyan);
        p.setBackground(Color.red);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        
    }
    public static void generate(String[] arr){
        String[] mokey = new String[arr.length];
        Random rand = new Random();
        for(int i = 0; i<mokey.length; i++){
            int rng = rand.nextInt(arr.length);
            while(true){
                if(mokey[rng] == null){
                    break;
                }
                rng = rand.nextInt(arr.length);
            }
            mokey[rng] = i+1 + " " + arr[i];
        }
        lineup.setText(Arrays.toString(mokey));
    }
}