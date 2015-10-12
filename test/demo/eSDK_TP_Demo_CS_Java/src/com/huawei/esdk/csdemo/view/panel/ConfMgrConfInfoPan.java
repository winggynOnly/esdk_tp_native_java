package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.view.ScheduleConfFrame;

public class ConfMgrConfInfoPan extends JPanel
{
    /** * */
    private static final long serialVersionUID = 1L;

    private int xx = 10;

    private int yy = 20;

    private final float labelWidthRate = 0.1f;

    private final float labelHeightRate = 0.1f;

    private final float textWidthRate = 0.2f;

    private final float textHeightRate = 0.1f;

    private Vector<Vector<String>> vectorData = null;

    private Rectangle rectangle;

    private JLabel confIdLabel = new JLabel();

    private JTextField confIdText = new JTextField();

    private JLabel confNameLabel = new JLabel();

    private JTextField confNameText = new JTextField();

    private JLabel confBeginTimeLabel = new JLabel();

    private JTextField confBeginTimeText = new JTextField();

    private JLabel confHowLongLabel = new JLabel();

    private JTextField confHowLongText = new JTextField();

    private JLabel confHowLongUnitLabel = new JLabel();

    private JLabel reTimeLabel = new JLabel();

    private JComboBox reTime = new JComboBox();

    private JPanel siteListPanel = new JPanel();

    private JPanel confParameterPanel = new JPanel();

    private JButton scheduleConfBut = new JButton();

    private JButton editConfBut = new JButton();

    private JButton deleteConfBut = new JButton();

    private JButton proConfBut = new JButton();

    // siteListPanel
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

    private JButton refreshSiteBut = new JButton();
    
    private JButton connectSiteBut = new JButton();

    private JButton addsiteBut = new JButton();

    private JButton deletesiteBut = new JButton();

    // confParameterPanel

    private JLabel accessCodeLabel = new JLabel();

    private JTextField accessCodeText = new JTextField();

    private JLabel passwordLabel = new JLabel();

    private JLabel passwordMethodLabel = new JLabel();

    private JLabel continuousPresenceLabel = new JLabel();

    private JLabel vedio1TypeLabel = new JLabel();

    private JLabel vedio2TypeLabel = new JLabel();

    private JLabel supportPresenceLabel = new JLabel();

    private JButton supportPresenceBut = new JButton();

    private JButton moreInfoBut = new JButton();


    private ScheduleConfFrame scheduleConfFrame;

    public ConfMgrConfInfoPan(Rectangle rectangle)
    {
        this.rectangle = rectangle;
        this.setLayout(null);

        // this.setBorder(BorderFactory.createEtchedBorder());

    }

    public void repaintCompomentName()
    {
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                LabelText.conference_detail[DataBase.getInstance().getLanguageFlag()]));

        siteListPanel
                .setBorder(BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(),
                        LabelText.confCtol_middle_siteListPanel_border[DataBase.getInstance().getLanguageFlag()]));
        confParameterPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                LabelText.advance_parameters[DataBase.getInstance().getLanguageFlag()]));

        scheduleConfBut.setText(LabelText.schedule_conf[DataBase.getInstance().getLanguageFlag()]);
        editConfBut.setText(LabelText.edit_conf[DataBase.getInstance().getLanguageFlag()]);
        deleteConfBut.setText(LabelText.delete_conf[DataBase.getInstance().getLanguageFlag()]);
        proConfBut.setText(LabelText.prolong_conf[DataBase.getInstance().getLanguageFlag()]);

        confIdLabel.setText(LabelText.conference_id[DataBase.getInstance().getLanguageFlag()]
                + ":");
        confNameLabel.setText(LabelText.conference_name[DataBase.getInstance().getLanguageFlag()] + ":");
        confBeginTimeLabel
                .setText(LabelText.conference_begin_time[DataBase.getInstance().getLanguageFlag()] + ":");
        confHowLongLabel
                .setText(LabelText.conference_keep_time[DataBase.getInstance().getLanguageFlag()] + ":");
        reTimeLabel
                .setText(LabelText.recurrence_time[DataBase.getInstance().getLanguageFlag()]);
        // RecurrenceLabel.setText("周期性会议");
        // RecurrenceDetailBut.setText("周期详情");
        confHowLongUnitLabel
                .setText(LabelText.confCtol_middle_confHowLongUnitLabel[DataBase.getInstance().getLanguageFlag()]);
        // siteListPanel

        refreshSiteBut.setText(LabelText.refresh_site[DataBase.getInstance().getLanguageFlag()]);
        connectSiteBut.setText(LabelText.connect_site[DataBase.getInstance().getLanguageFlag()]);
        addsiteBut.setText(LabelText.add_site[DataBase.getInstance().getLanguageFlag()]);
        deletesiteBut.setText(LabelText.delete_site[DataBase.getInstance().getLanguageFlag()]);
        addsiteBut
                .setToolTipText("AddSiteToConfExResponse result =  addSiteToConfEx(AddSiteToConfEx parameters)");
        deletesiteBut
                .setToolTipText("DelSiteFromConfExResponse result =  delSiteFromConfEx( DelSiteFromConfEx parameters)");

        // confParameterPanel
        accessCodeLabel.setText(LabelText.access_code[DataBase.getInstance().getLanguageFlag()]);
        passwordLabel
                .setText(LabelText.loginFrame_userPswd[DataBase.getInstance().getLanguageFlag()]);
        passwordMethodLabel
                .setText(LabelText.encrypt_type[DataBase.getInstance().getLanguageFlag()]);
        continuousPresenceLabel
                .setText(LabelText.confCtol_bottom_duohuamianTypeLabel[DataBase.getInstance().getLanguageFlag()]);
        vedio1TypeLabel
                .setText(LabelText.aux_stream_type[DataBase.getInstance().getLanguageFlag()]);
        vedio2TypeLabel.setText(LabelText.video_format[DataBase.getInstance().getLanguageFlag()]
                + ":");

        supportPresenceLabel
                .setText(LabelText.multi_cast[DataBase.getInstance().getLanguageFlag()]);
        supportPresenceBut
                .setText(LabelText.multi_cast_info[DataBase.getInstance().getLanguageFlag()]);
        moreInfoBut.setText(LabelText.other_param[DataBase.getInstance().getLanguageFlag()]);

    }

    public void addJComboBox(JComboBox jb)
    {
        this.reTime = jb;
        int labelHeight = (int) (this.rectangle.height * labelHeightRate);
        reTime.setBounds(this.rectangle.width - 380 - 30,
                yy + labelHeight + 10, 200, labelHeight + 5);
        this.add(reTime);
    }

    public void initCompomentBouds()
    {

        int labelWidth = (int) (this.rectangle.width * labelWidthRate);
        int labelHeight = (int) (this.rectangle.height * labelHeightRate);
        int textWidth = (int) (this.rectangle.width * textWidthRate);
        int textHeight = (int) (this.rectangle.height * textHeightRate);

        labelWidth = 130;
        labelHeight = 20;
        textWidth = 150;
        textHeight = 20;

        this.setBounds(this.rectangle);

        confIdLabel.setBounds(xx, yy, labelWidth, labelHeight);
        
        confIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        confIdText.setBounds(xx + labelWidth + 5, yy, textWidth, textHeight);

        confNameLabel.setBounds(xx + labelWidth + textWidth + 10, yy,
                labelWidth, labelHeight);
        confNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        confNameText.setBounds(xx + labelWidth * 2 + textWidth + 15, yy,
                this.rectangle.width - labelWidth * 2 - textWidth - xx - 30,
                labelHeight);

        confBeginTimeLabel.setBounds(xx, yy + labelHeight + 10, labelWidth,
                labelHeight);
        confBeginTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        confBeginTimeText.setBounds(xx + labelWidth + 5, yy + labelHeight + 10,
                textWidth, textHeight);

        confHowLongLabel.setBounds(xx + labelWidth + textWidth + 10, yy
                + labelHeight + 10, labelWidth, labelHeight);
        confHowLongLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        confHowLongText.setBounds(xx + labelWidth * 2 + textWidth + 15, yy
                + labelHeight + 10, textWidth, labelHeight);
        confHowLongUnitLabel.setBounds(
                xx + 2 * labelWidth + 2 * textWidth + 15,
                yy + labelHeight + 10, labelWidth, labelHeight);

        reTimeLabel.setBounds(this.rectangle.width - 220 - labelWidth, yy
                + labelHeight + 10, labelWidth, labelHeight);
        reTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        reTime.setBounds(this.rectangle.width - 180 - 30,
                yy + labelHeight + 10, 140, labelHeight + 5);

        int moddlePanelHeight = this.rectangle.height - 2 * yy - labelHeight
                * 3 - 30;
        int moddlePanelwidth = (this.rectangle.width - 2 * xx) * 3 / 4 - 25;

        siteListPanel.setBounds(xx, yy + 2 * labelHeight + 20,
                moddlePanelwidth, moddlePanelHeight);

        scheduleConfBut.setBounds(this.rectangle.width - 650 - xx,
                this.rectangle.height - 35, 160, 25);
        editConfBut.setBounds(this.rectangle.width - 470 - xx,
                this.rectangle.height - 35, 140, 25);
        deleteConfBut.setBounds(this.rectangle.width - 310 - xx,
                this.rectangle.height - 35, 140, 25);
        proConfBut.setBounds(this.rectangle.width - 160 - xx,
                this.rectangle.height - 35, 160, 25);

        // siteListPanel

        siteListJS.setBounds(5, 20, moddlePanelwidth - 10,
                moddlePanelHeight - 60);
        refreshSiteBut.setBounds(moddlePanelwidth - 640, moddlePanelHeight - 30, 150, 25);
        connectSiteBut.setBounds(moddlePanelwidth - 480,
                moddlePanelHeight - 30, 150, 25);
        addsiteBut.setBounds(moddlePanelwidth - 315, moddlePanelHeight - 30,
                150, 25);
        deletesiteBut.setBounds(moddlePanelwidth - 155, moddlePanelHeight - 30,
                150, 25);
        jtable.setSize(moddlePanelwidth - 10, moddlePanelHeight - 60);

        // moddlePanelwidth
        labelWidth = 80;
        textWidth = 130;
         accessCodeLabel.setBounds(10, 20, 80 , labelHeight);
         accessCodeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
         accessCodeText.setBounds(10 + labelWidth + 15, 20, textWidth,
         labelHeight);

        confParameterPanel.setBounds((this.rectangle.width * 3 / 4) - 25, yy + 2
                * labelHeight + 20, moddlePanelwidth / 3 + 30, moddlePanelHeight);
    }

    public void addCompomentToPanel()
    {
        this.add(confIdLabel);
        this.add(confIdText);
        this.add(confNameLabel);
        this.add(confNameText);
        this.add(confBeginTimeLabel);
        this.add(confBeginTimeText);
        this.add(confHowLongLabel);
        this.add(confHowLongText);
        this.add(confHowLongUnitLabel);
        // this.add(RecurrenceFlag);
        // this.add(RecurrenceLabel);
        // this.add(RecurrenceDetailBut);

        this.add(reTimeLabel);
        this.add(reTime);

        this.add(siteListPanel);
        this.add(confParameterPanel);

        this.add(scheduleConfBut);
        this.add(editConfBut);
        this.add(deleteConfBut);
        this.add(proConfBut);
        // siteListPanel
        siteListPanel.setLayout(null);
        siteListPanel.add(siteListJS);
        siteListPanel.add(refreshSiteBut);
        siteListPanel.add(connectSiteBut);
        siteListPanel.add(addsiteBut);
        siteListPanel.add(deletesiteBut);
        siteListJS.add(jtable);
        jtable.setModel(tableMode);
        siteListJS.setViewportView(jtable);

        // moddlePanelwidth
        confParameterPanel.setLayout(null);
        confParameterPanel.add(accessCodeLabel);
        confParameterPanel.add(accessCodeText);
    }

    public void repaintComponentVal()
    {
        confIdText.setText("");
        confIdText.setEnabled(false);
        confNameText.setText("");
        confNameText.setEnabled(false);
        confHowLongText.setEnabled(false);
        accessCodeText.setEnabled(false);
    }

    public void createPanel()
    {
//        addComponentToList();
        repaintCompomentName();
        initCompomentBouds();
        addCompomentToPanel();
        repaintComponentVal();
        refreshSiteTable(new String[0][0]);
    }

    @SuppressWarnings("unchecked")
    public void refreshSiteTable(String[][] datas)
    {
        String[] title = new String[]
        { "URI", LabelText.site_name[DataBase.getInstance().getLanguageFlag()],
                LabelText.site_type[DataBase.getInstance().getLanguageFlag()],
                LabelText.site_status[DataBase.getInstance().getLanguageFlag()],
                LabelText.site_conn_type[DataBase.getInstance().getLanguageFlag()],
                LabelText.site_speed[DataBase.getInstance().getLanguageFlag()],
                LabelText.video_format[DataBase.getInstance().getLanguageFlag()],
                LabelText.video_info[DataBase.getInstance().getLanguageFlag()] };
        tableMode.setDataVector(datas, title);
        tableMode.fireTableDataChanged();
        vectorData = tableMode.getDataVector();
    }

    public void addRefreshSiteTable(Vector<Vector<String>> datas)
    {
        Vector<String> titles = new Vector<String>();
        titles.add("URI");
        titles.add(LabelText.site_name[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_status[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_conn_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_speed[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_format[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_info[DataBase.getInstance().getLanguageFlag()]);
        Vector<String> vector = new Vector<String>();
        for (String data : datas.get(0))
        {
            vector.add(data);
        }
        vectorData.add(vector);
        tableMode.setDataVector(vectorData, titles);
        tableMode.fireTableDataChanged();
    }

    public void removeRefreshTable(Integer row)
    {
        Vector<String> titles = new Vector<String>();
        titles.add("URI");
        titles.add(LabelText.site_name[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_status[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_conn_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_speed[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_format[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_info[DataBase.getInstance().getLanguageFlag()]);
        vectorData.removeElementAt(row);
        tableMode.setDataVector(vectorData, titles);
        tableMode.fireTableDataChanged();
    }
    

    public void clearTable()
    {
        Vector<String> titles = new Vector<String>();
        titles.add("URI");
        titles.add(LabelText.site_name[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_status[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_conn_type[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_speed[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_format[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.video_info[DataBase.getInstance().getLanguageFlag()]);
        vectorData = new Vector<Vector<String>>();
        tableMode.setDataVector(vectorData, titles);
        tableMode.fireTableDataChanged();
    }

    public JButton getScheduleConfBut()
    {
        return scheduleConfBut;
    }

    public ScheduleConfFrame getScheduleConfFrame()
    {
        return scheduleConfFrame;
    }

    public JTextField getConfIdText()
    {
        return confIdText;
    }

    public JTextField getConfNameText()
    {
        return confNameText;
    }

    public JTextField getConfBeginTimeText()
    {
        return confBeginTimeText;
    }

    public JTextField getConfHowLongText()
    {
        return confHowLongText;
    }

    public JTextField getAccessCodeText()
    {
        return accessCodeText;
    }

    public JButton getEditConfBut()
    {
        return editConfBut;
    }

    public JButton getDeleteConfBut()
    {
        return deleteConfBut;
    }

    public JButton getConnectSiteBut()
    {
        return connectSiteBut;
    }

    public JButton getAddsiteBut()
    {
        return addsiteBut;
    }

    public JButton getDeletesiteBut()
    {
        return deletesiteBut;
    }

    public JTable getJtable()
    {
        return jtable;
    }

    public JButton getProConfBut()
    {
        return proConfBut;
    }

    public JComboBox getReTime()
    {
        return reTime;
    }

    public void setReTime(JComboBox reTime)
    {
        this.reTime = reTime;
    }

    public DefaultTableModel getTableMode()
    {
        return tableMode;
    }

    public JButton getRefreshSiteBut()
    {
        return refreshSiteBut;
    }
}
