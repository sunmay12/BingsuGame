import javax.swing.*;
import java.awt.*;

public class EditPanel extends JPanel {
	private JTextField edit = new JTextField(20);
	private JButton addButton = new JButton("add");
	private JButton saveButton = new JButton("save");
	
	
	public EditPanel() {
		this.setBackground(Color.BLUE);
		this.setLayout(new FlowLayout());
		add(edit);
		add(addButton);
		add(saveButton);
	}
	
}
