import java.awt.*;
import java.awt.event.*;
class MyFrame extends Frame implements AdjustmentListener,ActionListener
{
    Scrollbar red,green,blue;
    TextField tf,redInput,blueInput,greenInput;
    Label l,l1,l2,l3,l4;
    TextArea ta;
    Button updateButton,resetButton;
    public MyFrame(){
        super("RGB");
        red = new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,255);
        green = new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,255);
        blue = new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,255);
        l = new Label("Your Color will appear here");
        l1= new Label("Red");
        l2= new Label("Green");
        l3= new Label("Blue");
        l4= new Label("Your Color has Rgb Values");
        tf = new TextField(20);
        ta =new TextArea();
        redInput = new TextField(3);
        greenInput = new TextField(3);
        blueInput = new TextField(3);
        updateButton = new Button("Set Color");
        resetButton = new Button("Reset");
        tf.setBounds(50,50,300,50);
        red.setBounds(50,150,300,30);
        green.setBounds(50,200,300,30);
        blue.setBounds(50,250,300,30);
        l.setBounds(50, 100, 300, 30);
        l1.setBounds(10, 150, 30, 30);
        l2.setBounds(10, 200, 30, 30);
        l3.setBounds(10, 250, 30, 30);
        l4.setBounds(10,300,300,30);
        redInput.setBounds(360, 150, 50, 30);
        greenInput.setBounds(360, 200, 50, 30);
        blueInput.setBounds(360, 250, 50, 30);
        ta.setBounds(50, 350,300,50);
        updateButton.setBounds(360, 300, 100, 30);
        resetButton.setBounds(360, 350, 100, 30);
        l.setAlignment(Label.CENTER);
        l1.setAlignment(Label.LEFT);
        l2.setAlignment(Label.LEFT);
        l3.setAlignment(Label.LEFT);
        l4.setAlignment(Label.CENTER);
        setLayout(null);
        add(l);
        add(tf);
        add(l1);
        add(red);
        add(l2);
        add(green);
        add(l3);
        add(blue);
        add(l4);
        add(ta);
        add(redInput);
        add(greenInput);
        add(blueInput);
        add(updateButton);
        add(resetButton);
        red.addAdjustmentListener(this);
        green.addAdjustmentListener(this);
        blue.addAdjustmentListener(this);
        updateButton.addActionListener(this);
        resetButton.addActionListener(e -> resetColors());
    }
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        tf.setBackground(new Color(red.getValue(),green.getValue(),blue.getValue()));
        ta.setText("RGB: (" + red.getValue() + ", " + green.getValue() + ", " + blue.getValue() + ")");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int r = Integer.parseInt(redInput.getText());
            int g = Integer.parseInt(greenInput.getText());
            int b = Integer.parseInt(blueInput.getText());
            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                ta.setText("Error: RGB values must be between 0 and 255.");
                return;
            }
            red.setValue(r);
            green.setValue(g);
            blue.setValue(b);
            adjustmentValueChanged(null);
        } catch (NumberFormatException ex) {
            ta.setText("Error: Please enter valid integer RGB values.");
        }
        
    }
    private void resetColors() {
        red.setValue(0);
        green.setValue(0);
        blue.setValue(0);
        redInput.setText("");
        greenInput.setText("");
        blueInput.setText("");
        tf.setBackground(new Color(0, 0, 0));
        ta.setText("RGB: (0, 0, 0)");
    
    }
}

public class RGBProject {
    public static void main(String args[]){
        MyFrame f = new MyFrame();
        f.setSize(500,500);
        f.setVisible(true);
    }
}