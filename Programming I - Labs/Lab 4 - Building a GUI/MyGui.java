package introduceGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * last revised on June 7, 2023
 * version 1.0
 * @author C0535365 Justin
 */
public class MyGui {

    
    public static void main(String[] args) {
        
        // ===========================
        // build the "Editor" subPanel
        // ===========================
        JPanel personPanel = new JPanel();
        Color c = new Color(123, 213, 12);
        personPanel.setBackground(c);
        personPanel.setBorder(new TitledBorder("Person Information"));

        
        // ========================
        // build the "Person" panel
        // ========================
        JPanel personEditor = new JPanel();
        personEditor.setBackground(Color.LIGHT_GRAY);
        
        GridLayout grid = new GridLayout(3, 2);
        personEditor.setLayout(grid);
                
        BorderLayout border = new BorderLayout();
        personPanel.setLayout(border);
        JLabel first = new JLabel("First Name: ");
        JLabel last = new JLabel("Last Name: ");
        JLabel id = new JLabel("ID: ");
        
        JTextField firstText = new JTextField(10);
        JTextField lastText = new JTextField(10);
        JTextField idText = new JTextField(10);
        
        // attach all the components to the subpanel
        personEditor.add(first);
        personEditor.add(firstText);
        
        personEditor.add(last);
        personEditor.add(lastText);
        
        personEditor.add(id);
        personEditor.add(idText);
        
        // add the subpanel to the panel
        personPanel.add(personEditor, BorderLayout.NORTH);
        
        
        //=============================
        // build the "button" sub panel
        //=============================
        JPanel personButtons = new JPanel();
        personButtons.setBackground(Color.cyan);
        
        // create the button and anchor to personButton Panel
        JButton createPerson = new JButton("Add");
        personButtons.add(createPerson);
        
        JButton deletePerson = new JButton("Delete");
        personButtons.add(deletePerson);    
        
        // anchor the button panels to the personPanel
        personPanel.add(personButtons, BorderLayout.SOUTH);
        
        
        //==========================
        // Build the "output" panel
        //==========================
        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.YELLOW);
        outputPanel.setBorder(new TitledBorder("Display Results"));
        outputPanel.setLayout(new BorderLayout());
        
        JTextArea outputArea = new JTextArea();
        
        // add scrolling to text area
        JScrollPane scrollArea = new JScrollPane(outputArea);
        
        outputPanel.add(scrollArea, BorderLayout.CENTER);
        //------------------------------------
        // build the "output Button" sub panel
        //------------------------------------
        
        JPanel outputButtons = new JPanel();
        outputButtons.setBackground(Color.ORANGE);
        
        JButton draw = new JButton("Draw Matrix");
        
        // anchor the button to the panel
        outputButtons.add(draw);
        
        // anchor the subpanel - outputButtons - to the output panel
        outputPanel.add(outputButtons, BorderLayout.SOUTH);
        
        
        //=============================
        // Build the "calculator" panel
        //=============================
        JPanel calculatorPanel = new JPanel();
        calculatorPanel.setBackground(Color.PINK);
        calculatorPanel.setBorder(new TitledBorder("Calculator"));
        
        //--------------------------------------
        // build the "CalculatorInner" sub panel
        //--------------------------------------
        // use an inner JPanel to prevent vertical stretching
        
        JPanel calculatorInner = new JPanel();
        calculatorInner.setBackground(Color.red);
        calculatorInner.setLayout(
                new BoxLayout(calculatorInner, 
            BoxLayout.Y_AXIS)
                );
        
        // anchor the calculator inner to the calculator panel
        calculatorPanel.add(calculatorInner);
        
        JSpinner leftOperand = new JSpinner();
        JSpinner rightOperand = new JSpinner();
        
        // achor the fields to the calculator Inner
        calculatorInner.add(leftOperand);
        calculatorInner.add(rightOperand);
        
        //--------------------------------------
        // build the "CalculatorButton" sub panel
        //--------------------------------------
        JPanel calculatorButtons = new JPanel(); // layout mgr is a flow layout
        calculatorButtons.setBackground(Color.blue);
        
        JButton add = new JButton("+");
        JButton minus = new JButton("-");
        
        // anchor the fields to the calculatorButton panel
        calculatorButtons.add(add);
        calculatorButtons.add(minus);
        
        // anchor the calculatorButtons to the calculator panel
        calculatorInner.add(calculatorButtons);
        
        JTextField calculatorResult = new JTextField("==??");
        
        calculatorResult.setHorizontalAlignment(JTextField.CENTER);
        calculatorResult.setEditable(false); // do not allow for rewrite
        
        calculatorInner.add(calculatorResult);
        
        
        
        
        // ===========================================
        // My window, and it packs everything together
        // ===========================================
        JFrame window = new JFrame();
        window.setTitle("GUI with no Action Listener!");
        
        window.add(personPanel, BorderLayout.WEST);
        window.add(outputPanel, BorderLayout.CENTER);
        window.add(calculatorPanel, BorderLayout.EAST);
        
        // Set size and described dimensions
        Dimension d = new Dimension(400, 500);
        window.setSize(d);
        window.setMinimumSize(window.getSize());
        
        // show it!
        window.setVisible(true);
        
        // ends the program and closes the window properly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
