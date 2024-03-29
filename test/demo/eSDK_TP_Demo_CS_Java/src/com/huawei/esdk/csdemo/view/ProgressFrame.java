package com.huawei.esdk.csdemo.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.huawei.esdk.csdemo.common.FontConstants;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class ProgressFrame extends JFrame{
	/** * */
    private static final long serialVersionUID = 1L;

    private JPanel messContent = new JPanel();
	
	private JLabel lodingImg = new JLabel();
	private JLabel lodingtxt = new JLabel("LOADING . . .");
	private  JEditorPane mess = new JEditorPane();

	public ProgressFrame(){
	    this.setTitle("loading");
//	    this.setUndecorated(true);
		this.setLayout(null);
		this.setBounds(400, 300, 400, 250);
//		messContent.setBounds(30, 50, 240, 150);
		messContent.setLayout(null);
		
		lodingImg.setIcon(new ImageIcon(DataBase.getInstance().getPath("loading.gif")));
		
		messContent.setBounds(0, 0, 400, 250);
		messContent.setBackground(Color.white);
		
		lodingImg.setBounds(130, 80, 48, 48);
		lodingtxt.setBounds(190, 90, 80, 30);
		mess.setBounds(50, 150, 300, 40);
		mess.setFont(FontConstants.normalFont);
		mess.setForeground(Color.blue);
//		mess.set
//		mess.setHorizontalAlignment(SwingConstants.CENTER);
		
		messContent.add(lodingtxt);
        messContent.add(lodingImg);
		messContent.add(mess);
		
	    this.add(messContent);
		this.setResizable(false);
		this.setAlwaysOnTop(true);

	}
	public  void showProgressMessage(String msg){

			mess.setText(msg);
			mess.repaint();
			this.repaint();
	}
	
}
