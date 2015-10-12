package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.huawei.esdk.csdemo.common.LabelText;

import com.huawei.esdk.csdemo.memorydb.DataBase;

public class SiteControlSiteListPan extends JPanel
{

    private static final long serialVersionUID = 1L;

    private Rectangle rectangle;

    private int xx = 8;

    private int yy = 20;

    private JTable siteList = new JTable()
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

    public SiteControlSiteListPan(Rectangle rectangle)
    {
        this.rectangle = rectangle;
        this.setLayout(null);
    }

    public void repaintCompomentName()
    {
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), LabelText.siteCtol_sitelist_panelBorder[DataBase.getInstance().getLanguageFlag()]));
        this.setBounds(rectangle);

        String[] tableTitle = new String[4];
        tableTitle[0] = LabelText.siteCtol_sitelist_tableTitle1[DataBase.getInstance().getLanguageFlag()];
        tableTitle[1] = LabelText.siteCtol_sitelist_tableTitle2[DataBase.getInstance().getLanguageFlag()];
        tableTitle[2] = LabelText.siteCtol_sitelist_tableTitle3[DataBase.getInstance().getLanguageFlag()];
        tableTitle[3] = LabelText.siteCtol_sitelist_tableTitle4[DataBase.getInstance().getLanguageFlag()];
        
 
        tableMode.setColumnIdentifiers(tableTitle);

    }

    public void initCompomentBouds()
    {
        jscroll.setBounds(xx, yy, this.rectangle.width - 2 * xx,
                this.rectangle.height - 2 * yy);
    }

    public void addCompomentToPanel()
    {
        siteList.setModel(tableMode);
        tableMode.fireTableDataChanged();
        jscroll.add(siteList);
        jscroll.setViewportView(siteList);
        this.add(jscroll);
    }

    public void repaintComponentVal()
    {

    }

    public void createPanel()
    {
        repaintCompomentName();
        initCompomentBouds();
        addCompomentToPanel();
        repaintComponentVal();
    }

    public Rectangle getRectangle()
    {
        return rectangle;
    }

    public JTable getSiteList()
    {
        return siteList;
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
