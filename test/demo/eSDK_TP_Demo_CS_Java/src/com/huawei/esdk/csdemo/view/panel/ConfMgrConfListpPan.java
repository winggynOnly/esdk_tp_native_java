package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class ConfMgrConfListpPan extends JPanel
{

    private static final long serialVersionUID = 1L;

    public ConfMgrConfListpPan(Rectangle rectangle)
    {
        this.rectangle = rectangle;
        this.setLayout(null);
        this.setBounds(rectangle);
        // this.setBorder(BorderFactory.createEtchedBorder());
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                LabelText.conference_list[DataBase.getInstance().getLanguageFlag()]));
    }

    private Rectangle rectangle;

    private JTable confList = new JTable()
    {
        /** * */
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };

    private DefaultTableModel tableMode = new DefaultTableModel();

    private JScrollPane jscroll = new JScrollPane();

    private int xx = 8;

    private int yy = 20;

    public void initLabelName()
    {
        // btm_userName.setText(LabelText.btm_userName[LoginFrame.languageFlag]);
        // btm_connStastus.setText(LabelText.btm_connStastus[LoginFrame.languageFlag]);
        // btm_serverAddress.setText(LabelText.btm_serverAddress[LoginFrame.languageFlag]);
        // btm_exitLoginBut.setText(LabelText.btm_exitLoginBut[LoginFrame.languageFlag]);
        // btm_description_1.setText(LabelText.btm_description_1[LoginFrame.languageFlag]);
        // btm_description_2.setText(LabelText.btm_description_2[LoginFrame.languageFlag]);

    }

    public void addValueToTable()
    {

        Vector<String> columnIdentifiers = new Vector<String>();
        columnIdentifiers.add(LabelText.conference_id[DataBase.getInstance().getLanguageFlag()]);
        columnIdentifiers.add(LabelText.conference_name[DataBase.getInstance().getLanguageFlag()]);
        columnIdentifiers
                .add(LabelText.conference_begin_time[DataBase.getInstance().getLanguageFlag()]);
        columnIdentifiers
                .add(LabelText.conference_keep_time[DataBase.getInstance().getLanguageFlag()]);
        columnIdentifiers
                .add(LabelText.access_code_column[DataBase.getInstance().getLanguageFlag()]);
        columnIdentifiers
                .add(LabelText.conference_status[DataBase.getInstance().getLanguageFlag()]);

        tableMode.setDataVector(DataBase.getInstance().getConfVector(), columnIdentifiers);
        confList.setModel(tableMode);
        // 只允许单选
        confList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jscroll.add(confList);
        jscroll.setViewportView(confList);

        jscroll.setBounds(xx, yy, this.rectangle.width - 2 * xx,
                this.rectangle.height - 2 * yy);
        this.add(jscroll);
        // 刷新表格数据
        refreshTable();
    }

    public void refreshTable()
    {
        tableMode.fireTableDataChanged();
    }

    public JTable getConfList()
    {
        return confList;
    }

    public DefaultTableModel getTableMode()
    {
        return tableMode;
    }

    public JScrollPane getJscroll()
    {
        return jscroll;
    }
}
