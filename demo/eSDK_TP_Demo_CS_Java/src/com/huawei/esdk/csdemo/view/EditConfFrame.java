package com.huawei.esdk.csdemo.view;

import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.huawei.esdk.csdemo.common.FontConstants;
import com.huawei.esdk.csdemo.common.ItemObject;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.enums.CpResourceMode;
import com.huawei.esdk.csdemo.listener.EditConfListener;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.utils.DateChooserJTextField;

public class EditConfFrame extends JDialog
{
private static final long serialVersionUID = 1L;
    
    private EditSelectSiteFrame frame;

    public static int[] selectedSiteIndex = {};
    
    private Vector<Vector<String>> siteVector = new Vector<Vector<String>>();
    
    private RecurrenceConfFrame recurrenceConfDetail;
    
    private Rectangle rectangle;

    private JPanel contentPane = new JPanel();

    private JPanel contentPane1 = new JPanel();

    // top panel
    private JLabel confIdLabel = new JLabel();

    private JTextField confIdText = new JTextField();

    private JLabel confNameLabel = new JLabel();

    private JTextField confNameText = new JTextField();

    private JLabel confBeginTimeLabel = new JLabel();

    private DateChooserJTextField confBeginTimeText = new DateChooserJTextField();

    private JLabel confHowLongLabel = new JLabel();

    private JTextField confHowLongText = new JTextField();

    private JLabel confHowLongUnitLabel = new JLabel();

    private JCheckBox recurrenceFlag = new JCheckBox();

    private JLabel recurrenceLabel = new JLabel();

    private JButton recurrenceDetailBut = new JButton();

    // site list

    private JPanel siteListPanel = new JPanel();

    private JPanel jtablePanel = new JPanel();

    private JScrollPane siteListJS = new JScrollPane();

    private JTable jtable = new JTable()
    {
        /** * */
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };

    private DefaultTableModel tableMode = new DefaultTableModel();

    private JButton addsiteBut = new JButton();

    private JButton addsiteBut1 = new JButton();

    private JButton deletesiteBut = new JButton();

    // high param

    private JLabel accessCodeLabel = new JLabel();

    private JTextField accessCodeText = new JTextField();

    private JLabel passwordLabel = new JLabel();

    private JTextField passwordText = new JTextField();
    
    private JLabel chairmanPasswordLabel = new JLabel();

    private JTextField chairmanPasswordText = new JTextField();

    private JLabel passwordMethodLabel = new JLabel();

    private JComboBox passwordMethodJC = new JComboBox();

    private JLabel continuousPresenceLabel = new JLabel();

    private JComboBox continuousPresenceJC = new JComboBox();

    private JLabel vedio1TypeLabel = new JLabel();

    private JComboBox vedio1TypeJC = new JComboBox();

    private JLabel vedio2TypeLabel = new JLabel();

    private JComboBox vedio2TypeJC = new JComboBox();

//    private JLabel recordType = new JLabel();
//
//    private JCheckBox supportRecordCK = new JCheckBox();
//
//    private JLabel supportRecordLabel = new JLabel();
//
//    private JCheckBox supportLivingCK = new JCheckBox();
//
//    private JLabel supportLivingLabel = new JLabel();

    private JLabel speedRateLabel = new JLabel();

    private JComboBox speedRateJC = new JComboBox();

    // bottom button
    private JButton scheConfBut = new JButton();

    private JButton closeBut = new JButton();

    public EditConfFrame(JFrame owner,Boolean isModal,Rectangle rectangle)
    {
        super(owner,isModal);
        this.rectangle = rectangle;
        this.setLayout(null);

    }

    public void lunchFrame()
    {
        repaintCompomentName();
        initCompomentBouds();
        addCompomentToPanel();
        repaintComponentVal();
        
        EditConfListener editConfListener = new EditConfListener();
        editConfListener.register(this);
        this.setResizable(false);
        
        Rectangle rect = new Rectangle(300, 200, 350, 400);
        RecurrenceConfFrame recurrenceConfFrame = new RecurrenceConfFrame(
                this, true, rect);
        recurrenceConfFrame.lunchFrame();
        recurrenceConfFrame.setVisible(false);
        this.setRecurrenceConfDetail(recurrenceConfFrame);
//        this.setVisible(true);
    }

    public void repaintCompomentName()
    {
        this.setTitle(LabelText.edit_conf[DataBase.getInstance().getLanguageFlag()]);
        
        contentPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), LabelText.conference_detail[DataBase.getInstance().getLanguageFlag()]));
        contentPane1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), LabelText.advance_parameters[DataBase.getInstance().getLanguageFlag()]));

        confIdLabel.setText(LabelText.conference_id[DataBase.getInstance().getLanguageFlag()] + ":");
        confNameLabel.setText(LabelText.conference_name[DataBase.getInstance().getLanguageFlag()] + ":");
        confBeginTimeLabel.setText(LabelText.conference_begin_time[DataBase.getInstance().getLanguageFlag()] + ":");
        confHowLongLabel.setText(LabelText.conference_keep_time[DataBase.getInstance().getLanguageFlag()] + ":");
        recurrenceLabel.setText(LabelText.recurrence_conf[DataBase.getInstance().getLanguageFlag()]);
        recurrenceDetailBut.setText(LabelText.recurrence_conference_detail[DataBase.getInstance().getLanguageFlag()]);
        confHowLongUnitLabel.setText(LabelText.confCtol_middle_confHowLongUnitLabel[DataBase.getInstance().getLanguageFlag()]);
        // site lsir

        siteListPanel.setBorder(BorderFactory.createEtchedBorder());
        jtablePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), LabelText.site_list[DataBase.getInstance().getLanguageFlag()]));
        
        refreshSitesList(siteVector);

        addsiteBut.setText(LabelText.add_anonymous_site[DataBase.getInstance().getLanguageFlag()]);
        addsiteBut1.setText(LabelText.add_site[DataBase.getInstance().getLanguageFlag()]);

        deletesiteBut.setText(LabelText.delete_site[DataBase.getInstance().getLanguageFlag()]);
        // bottom buttton
        scheConfBut.setText(LabelText.edit_conference[DataBase.getInstance().getLanguageFlag()]);
        closeBut.setText(LabelText.loginFrame_menuItemClose[DataBase.getInstance().getLanguageFlag()]);

        // high param panel

        accessCodeLabel.setText(LabelText.access_code[DataBase.getInstance().getLanguageFlag()]);
        passwordLabel.setText(LabelText.loginFrame_userPswd[DataBase.getInstance().getLanguageFlag()]);
        chairmanPasswordLabel.setText(LabelText.scheduleConf_chairmanPwd[DataBase
                                                                         .getInstance().getLanguageFlag()]);
        passwordMethodLabel.setText(LabelText.encrypt_type[DataBase.getInstance().getLanguageFlag()]);
        continuousPresenceLabel.setText(LabelText.confCtol_bottom_duohuamianTypeLabel[DataBase.getInstance().getLanguageFlag()]);
        vedio1TypeLabel.setText(LabelText.aux_stream_type[DataBase.getInstance().getLanguageFlag()]);
        vedio2TypeLabel.setText(LabelText.video_format[DataBase.getInstance().getLanguageFlag()] + ":");

//        recordType.setText(LabelText.play_record_mode[DataBase.getInstance().getLanguageFlag()]);
//
//        supportRecordLabel.setText(LabelText.play_record[DataBase.getInstance().getLanguageFlag()]);
//        supportLivingLabel.setText(LabelText.live[DataBase.getInstance().getLanguageFlag()]);
        speedRateLabel.setText(LabelText.speed[DataBase.getInstance().getLanguageFlag()]);

    }

    public void initCompomentBouds()
    {
        int labelWidth = 130;
        int labelHeight = 20;
        int textWidth = 120;
        int textHeight = 20;
        int xx = 10;
        int yy = 30;

        contentPane.setBounds(10, 10, 800, 300);
        contentPane1.setBounds(10, 320, 800, 200);
        this.setBounds(this.rectangle);

        confIdLabel.setBounds(xx, yy, 100, labelHeight);
        confIdText.setBounds(xx + 105, yy, textWidth, textHeight);

        confNameLabel.setBounds(xx + 100 + textWidth + 10, yy,
                labelWidth, labelHeight);
        confNameText.setBounds(xx + 230 + textWidth + 15, yy, 800
                - labelWidth * 2 - textWidth - xx - 30, labelHeight);

        confBeginTimeLabel.setBounds(xx, yy + labelHeight + 10, 100,
                labelHeight);
        confBeginTimeText.setBounds(xx + 105, yy + labelHeight + 10,
                textWidth, textHeight);

        confHowLongLabel.setBounds(xx + 100 + textWidth + 10, yy
                + labelHeight + 10, labelWidth, labelHeight);
        confHowLongText.setBounds(xx + 230 + textWidth + 15, yy
                + labelHeight + 10, textWidth, labelHeight);
        confHowLongUnitLabel.setBounds(
                xx + 230 +  2 * textWidth + 15,
                yy + labelHeight + 10, 30, labelHeight);

        recurrenceFlag.setBounds(800 - 160 - 100 - labelHeight, yy + labelHeight
            + 10, labelHeight, labelHeight);
        recurrenceLabel.setBounds(800 - 160 - 100, yy + labelHeight + 10, 120,
                labelHeight);
        recurrenceLabel.setFont(FontConstants.smallFont);
        
        recurrenceDetailBut.setBounds(800 - 120 - 20, yy + labelHeight + 10,
                130, labelHeight + 5);
        recurrenceDetailBut.setVisible(false);
        recurrenceDetailBut.setFont(FontConstants.smallFont);
        // site lsit
        //
        siteListPanel.setBounds(10, 100, 780, 150);
        jtablePanel.setBounds(5, 5, 770, 140);

        siteListJS.setBounds(5, 20, 760, 115);

        addsiteBut.setBounds(800 - 405, 265, 170, 25);
        addsiteBut1.setBounds(800 - 225, 265, 100, 25);
        deletesiteBut.setBounds(800 - 115, 265, 100, 25);
        // jtable.setSize(moddlePanelwidth - 10, moddlePanelHeight- 60);

        // high param
        int moddlePanelwidth = 800;
        int moddlePanelHeight = 200;
        labelWidth = 120;
        textWidth = 230;
        accessCodeLabel.setBounds(10, 20, labelWidth, labelHeight);
        accessCodeText.setBounds(10 + labelWidth + 15, 20, textWidth,
                labelHeight);
        passwordLabel.setBounds(moddlePanelwidth - textWidth - labelWidth - 20,
                20, labelWidth, labelHeight);
        passwordText.setBounds(moddlePanelwidth - 10 - textWidth, 20,
                textWidth, labelHeight);

        passwordMethodLabel.setBounds(10, 40 + labelHeight, labelWidth,
                labelHeight);
        passwordMethodJC.setBounds(10 + labelWidth + 15, 40 + labelHeight,
                textWidth, labelHeight);
        continuousPresenceLabel.setBounds(moddlePanelwidth - textWidth
                - labelWidth - 20, 40 + labelHeight, labelWidth, labelHeight);
        continuousPresenceJC.setBounds(moddlePanelwidth - 10 - textWidth,
                40 + labelHeight, textWidth, labelHeight);

        vedio1TypeLabel.setBounds(10, 60 + 2 * labelHeight, labelWidth,
                labelHeight);
        vedio1TypeJC.setBounds(10 + labelWidth + 15, 60 + 2 * labelHeight,
                textWidth, labelHeight);
        vedio2TypeLabel.setBounds(moddlePanelwidth - textWidth - labelWidth
                - 20, 60 + 2 * labelHeight, labelWidth, labelHeight);
        vedio2TypeJC.setBounds(moddlePanelwidth - 10 - textWidth,
                60 + 2 * labelHeight, textWidth, labelHeight);

//        recordType.setBounds(10, moddlePanelHeight - labelHeight - 20,
//                labelWidth, labelHeight);
//        supportRecordCK.setBounds(10 + labelWidth, moddlePanelHeight
//                - labelHeight - 20, 20, 20);
//        supportRecordLabel.setBounds(10 + labelWidth + 30, moddlePanelHeight
//                - labelHeight - 20, 80, 20);
//        supportLivingCK.setBounds(10 + labelWidth + 110, moddlePanelHeight
//                - labelHeight - 20, 20, 20);
//        supportLivingLabel.setBounds(10 + labelWidth + 140, moddlePanelHeight
//                - labelHeight - 20, 80, 20);

        speedRateLabel.setBounds(10, moddlePanelHeight - labelHeight - 20,
                labelWidth, labelHeight);
        speedRateJC.setBounds(10 + labelWidth + 15, moddlePanelHeight - labelHeight
                - 20, textWidth, labelHeight);
        speedRateJC.addItem("1920k");
        
        //DTS2014052105833
        chairmanPasswordLabel.setBounds(moddlePanelwidth - textWidth - labelWidth - 20,
        		moddlePanelHeight - labelHeight - 20, labelWidth, labelHeight);
        chairmanPasswordText.setBounds(moddlePanelwidth - 10 - textWidth, moddlePanelHeight - labelHeight - 20,
                textWidth, labelHeight);
//        speedRateJC.setRenderer(aRenderer);
        // bottom button
        scheConfBut.setBounds(415 - 50 - 20, 610 - 65, 100, 25);
        closeBut.setBounds(400 + 50 + 20, 610 - 65, 100, 25);
    }

    public void addCompomentToPanel()
    {
        this.add(contentPane);
        this.add(contentPane1);
        this.add(scheConfBut);
        this.add(closeBut);

        contentPane.setLayout(null);
        contentPane.add(confIdLabel);
        contentPane.add(confIdText);
        contentPane.add(confNameLabel);
        contentPane.add(confNameText);
        contentPane.add(confBeginTimeLabel);
        contentPane.add(confBeginTimeText);
        contentPane.add(confHowLongLabel);
        contentPane.add(confHowLongText);
        contentPane.add(confHowLongUnitLabel);
        contentPane.add(recurrenceFlag);
        contentPane.add(recurrenceLabel);
        contentPane.add(recurrenceDetailBut);

        siteListPanel.setLayout(null);
        jtablePanel.setLayout(null);

        siteListPanel.add(jtablePanel);
        jtablePanel.add(siteListJS);

        contentPane.add(siteListPanel);

        contentPane.add(addsiteBut);
        contentPane.add(addsiteBut1);
        contentPane.add(deletesiteBut);

        siteListJS.add(jtable);
        jtable.setModel(tableMode);
        siteListJS.setViewportView(jtable);

        // high param panel

        contentPane1.setLayout(null);

        contentPane1.add(accessCodeLabel);
        contentPane1.add(accessCodeText);
        contentPane1.add(passwordLabel);
        contentPane1.add(passwordText);

        contentPane1.add(chairmanPasswordLabel);
        contentPane1.add(chairmanPasswordText);
        
        contentPane1.add(passwordMethodLabel);
        contentPane1.add(passwordMethodJC);
        contentPane1.add(continuousPresenceLabel);
        contentPane1.add(continuousPresenceJC);
        
        int i = 1;
        for(CpResourceMode item : CpResourceMode.values()){
            ItemObject selectItem = new ItemObject();
            selectItem.setKey(String.valueOf(i));
            selectItem.setValue(item.value());
            continuousPresenceJC.addItem(selectItem);
            i++;
        }

        contentPane1.add(vedio1TypeLabel);
        contentPane1.add(vedio1TypeJC);
        contentPane1.add(vedio2TypeLabel);
        contentPane1.add(vedio2TypeJC);

//        contentPane1.add(recordType);
//        contentPane1.add(supportRecordCK);
//        contentPane1.add(supportLivingCK);
//        contentPane1.add(supportRecordLabel);
//        contentPane1.add(supportLivingLabel);
        contentPane1.add(speedRateLabel);
        contentPane1.add(speedRateJC);

    }

    public JComboBox getContinuousPresenceJC()
    {
        return continuousPresenceJC;
    }

    public void setContinuousPresenceJC(
        JComboBox continuousPresenceJC)
    {
        this.continuousPresenceJC =
            continuousPresenceJC;
    }

    public void repaintComponentVal()
    {
        confIdText.setEnabled(false);
    }

    public void clearTable()
    {
        // this.siteVector = selectedSites;
        Vector<String> titles = new Vector<String>();
        titles.add("URI");
        titles.add(LabelText.site_name[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_status[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_conn_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_speed[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_format[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_info[DataBase.getInstance().getLanguageFlag()]);
        // tableMode.setColumnIdentifiers(title);
        Vector<Vector<String>> vector = new Vector<Vector<String>>();
        tableMode.setDataVector(vector, titles);
        tableMode.fireTableDataChanged();
    }
    
    
    /**
     * 预约会议会场列表刷新
     * * @param selectedSites
     */
    @SuppressWarnings("unchecked")
    public void refreshSitesList(Vector<Vector<String>> selectedSites)
    {
//        this.siteVector = selectedSites;
        Vector<String> titles = new Vector<String>();
        titles.add("URI");
        titles.add(LabelText.site_name[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_status[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_conn_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_speed[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_format[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_info[DataBase.getInstance().getLanguageFlag()]);
//        tableMode.setColumnIdentifiers(title);
        Vector<Vector<String>> vector = tableMode.getDataVector();
        vector.addAll(selectedSites);
        tableMode.setDataVector(vector, titles);
        tableMode.fireTableDataChanged();
    }

    public JButton getScheConfBut()
    {
        return scheConfBut;
    }

    public JButton getAddsiteBut1()
    {
        return addsiteBut1;
    }

    public JButton getCloseBut()
    {
        return closeBut;
    }

    public JCheckBox getRecurrenceFlag()
    {
        return recurrenceFlag;
    }

    public JTextField getConfIdText()
    {
        return confIdText;
    }

    public JTextField getConfNameText()
    {
        return confNameText;
    }

    public DateChooserJTextField getConfBeginTimeText()
    {
        return confBeginTimeText;
    }

    public JTextField getConfHowLongText()
    {
        return confHowLongText;
    }

    public JComboBox getSpeedRateJC()
    {
        return speedRateJC;
    }

    public DefaultTableModel getTableMode()
    {
        return tableMode;
    }

    public JButton getRecurrenceDetailBut()
    {
        return recurrenceDetailBut;
    }

    public RecurrenceConfFrame getRecurrenceConfDetail()
    {
        return recurrenceConfDetail;
    }

    public void setRecurrenceConfDetail(RecurrenceConfFrame recurrenceConfDetail)
    {
        this.recurrenceConfDetail = recurrenceConfDetail;
    }

    public JButton getAddsiteBut()
    {
        return addsiteBut;
    }

    public JLabel getRecurrenceLabel()
    {
        return recurrenceLabel;
    }

    public EditSelectSiteFrame getFrame()
    {
        return frame;
    }

    public void setFrame(EditSelectSiteFrame frame)
    {
        this.frame = frame;
    }

    public JButton getDeletesiteBut()
    {
        return deletesiteBut;
    }

    public JTable getJtable()
    {
        return jtable;
    }

    public JTextField getPasswordText()
    {
        return passwordText;
    }

	public JLabel getChairmanPasswordLabel() {
		return chairmanPasswordLabel;
	}

	public JTextField getChairmanPasswordText() {
		return chairmanPasswordText;
	}
    
    
}
