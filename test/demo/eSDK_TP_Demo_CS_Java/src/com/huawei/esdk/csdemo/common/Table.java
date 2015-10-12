package com.huawei.esdk.csdemo.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;


public class Table{
    private int width;
    private int height;
    private int rowNum;
    private int columnNum;
    private String rows[];
    private String columns[];
    private Map<Integer,Integer> alignment = new HashMap<Integer,Integer>();
    
    public static final int xx = 10;
    public static final int yy = 10;
    public static final int componentHeight = 20;
    public static final int btnHeight = 25;
    public static final  int spaceWidth = 5;
    public static final  int spaceHeight = 5;
    public static final  int checkboxSize = 25;
    public static final  Integer labelAlignmentX = SwingConstants.RIGHT;
    public static final  Integer labelAlignmentY = SwingConstants.CENTER;
    public static final  Integer textAlignmentX = SwingConstants.LEFT;
//    public static final  Integer textAlignmentY = SwingConstants.CENTER;
    
    public Table(){
        
    }
    
    public Table(int width, int height,int rowNum,int columnNum,String rows[],String columns[]){
        this.width = width - 2*Table.xx;
        this.height = height - 2*Table.yy;
        this.rowNum = rowNum;
        this.columnNum =columnNum;
        this.rows =rows;
        this.columns =columns;
    }
    
    public List<Integer> getDefaultBounds(){
        
        return null;
    }
    
    public static int getYy()
    {
        return yy;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getRowNum()
    {
        return rowNum;
    }
    public void setRowNum(int rowNum)
    {
        this.rowNum = rowNum;
    }
    public int getColumnNum()
    {
        return columnNum;
    }
    public void setColumnNum(int columnNum)
    {
        this.columnNum = columnNum;
    }
    public String[] getRows()
    {
        return rows;
    }
    public void setRows(String[] rows)
    {
        this.rows = rows;
    }
    public String[] getColumns()
    {
        return columns;
    }
    public void setColumns(String[] columns)
    {
        this.columns = columns;
    }

    public int getXx()
    {
        return xx;
    }

    public static int getComponentheight()
    {
        return componentHeight;
    }

    public static int getSpacewidth()
    {
        return spaceWidth;
    }

    public static int getSpaceheight()
    {
        return spaceHeight;
    }

    public static int getCheckboxsize()
    {
        return checkboxSize;
    }

    public static Integer getLabelalignmentx()
    {
        return labelAlignmentX;
    }

    public static Integer getLabelalignmenty()
    {
        return labelAlignmentY;
    }

    public static Integer getTextalignmentx()
    {
        return textAlignmentX;
    }

    public Map<Integer, Integer> getAlignment()
    {
        return alignment;
    }

    public void setAlignment(Map<Integer, Integer> alignment)
    {
        this.alignment = alignment;
    }

}
