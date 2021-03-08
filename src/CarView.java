import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements IObserver {
    private static final int X = 1200;
    private static final int Y = 700;

    // The controller member
    CarController carController;
    CarModel carModel;
    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    int brakeAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    private Timer timer = new Timer(delay, new TimerListener());


    // Constructor
    public CarView(String framename, CarModel carModel){
        this.carModel = carModel;
        this.drawPanel = new DrawPanel(X, Y-240, carModel);
        carModel.register(this);
        initComponents(framename);
        timer.start();
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    @Override
    public void update() {
        System.out.println("Im updated");
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carModel.update();
            drawPanel.repaint();
            carModel.checkIfOutOfBounds(CarView.X);
        }
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                brakeAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);


        // Listeners ****************************************************


        // End listeners ****************************************************

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    void addGasButtonListener(ActionListener listener){
        gasButton.addActionListener(listener);
    }

    void addBrakeButtonListener(ActionListener listener){
        brakeButton.addActionListener(listener);
    }

    void addStartButtonListener(ActionListener listener){
        startButton.addActionListener(listener);
    }

    void addStopButtonListener(ActionListener listener){
        stopButton.addActionListener(listener);
    }

    void addTurboOnButtonListener(ActionListener listener){
        turboOnButton.addActionListener(listener);
    }

    void addTurboOffButtonListener(ActionListener listener){
        turboOffButton.addActionListener(listener);
    }

    void addLiftBedButtonListener(ActionListener listener){
        liftBedButton.addActionListener(listener);
    }

    void addLowerBedButtonListener(ActionListener listener){
        lowerBedButton.addActionListener(listener);
    }

    void addAddCarButtonListener(ActionListener listener){
        addCarButton.addActionListener(listener);
    }

    void addRemoveCarButtonListener(ActionListener listener){
        removeCarButton.addActionListener(listener);
    }

}