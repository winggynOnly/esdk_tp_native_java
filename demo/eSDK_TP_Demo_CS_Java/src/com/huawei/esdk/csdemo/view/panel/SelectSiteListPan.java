package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.view.ScheduleConfFrame;

public class SelectSiteListPan extends JPanel
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

    public SelectSiteListPan(Rectangle rectangle)
    {
        this.rectangle = rectangle;
        this.setLayout(null);
    }

    public void repaintCompomentName()
    {
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), LabelText.site_list[DataBase.getInstance().getLanguageFlag()]));
        this.setBounds(rectangle);

        // TPSDKResponseEx<List<SiteInfoEx>> sites = confService.querySitesEx();
        // List<SiteInfoEx> siteList = sites.getResult();

        // String[] tableTitle = new String[3];
        // String[][] tableData = new String[siteList.size()][3];
        // tableTitle[0] = "会场URI";
        // tableTitle[1] = "会场名称";
        // tableTitle[2] = "会场类型";
        
    }
    
    public void freshTable(Vector<Vector<String>> vector)
    {
        Vector<String> titles = new Vector<String>();
        titles.add("URI");
        titles.add(LabelText.site_name[DataBase.getInstance().getLanguageFlag()]);
        titles.add(LabelText.site_type[DataBase.getInstance().getLanguageFlag()]);

        tableMode.setDataVector(vector, titles);
        tableMode.fireTableDataChanged();
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

    @SuppressWarnings("unchecked")
    public Vector<Vector<String>> getSelectedData()
    {
        int[] rows = siteList.getSelectedRows();
        ScheduleConfFrame.selectedSiteIndex = rows;
        Vector<Vector<String>> vector = tableMode.getDataVector();
        Vector<Vector<String>> selectedSites = new Vector<Vector<String>>();
        for (int i = 0; i < rows.length; i++)
        {
            selectedSites.add(vector.get(rows[i]));
        }
        return selectedSites;
//        scheduleConfFrame.refreshSitesList(selectedSites);
    }

    public JTable getSiteList()
    {
        return siteList;
    }
    
    
}
