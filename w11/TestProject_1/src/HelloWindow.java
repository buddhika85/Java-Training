import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HelloWindow extends JFrame
{
    private HelloPanel panel = new HelloPanel();
	public HelloWindow()
	{
		super("Hello Window");
		setup();
		build();
	}

	private void setup()
	{
		setSize(500,300);
		setLocation(500, 500);
		setVisible(true);
	}

	private void build()
	{
		add(panel);
	}


	private class HelloPanel extends JPanel
	{
		private JButton btn = new JButton("Hello");
		public HelloPanel()
		{
			setup();
			build();
		}

		private void setup()
		{
			btn.addActionListener(new HelloListener());
		}

		private void build()
		{
			add(btn);
		}

		private class HelloListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Hello");
			}
		}
	}
}
