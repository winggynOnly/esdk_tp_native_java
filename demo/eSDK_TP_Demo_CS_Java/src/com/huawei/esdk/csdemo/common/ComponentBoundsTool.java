package com.huawei.esdk.csdemo.common;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.huawei.esdk.csdemo.memorydb.DataBase;

public class ComponentBoundsTool
{
    private List<JComponent> components;
    private Table table;
    private List<Integer[]> bounds;
    private int[] rowsVal;
    private int[] cloumnVal;
    
    public  List<JComponent> getInitedBoundsComponent(List<JComponent> components, List<Integer[]> bounds, Table table ){
        this.components = components;
        this.table = table;
        this.bounds = bounds;
        initRowColumnVal();
        initComponentsBounds();
        return null;
    }
    
    private boolean initRowColumnVal(){
        rowsVal = new int[this.table.getRowNum()];
        cloumnVal = new int[this.table.getColumnNum()];
        if(this.table.getRowNum() != this.table.getRows().length || 
            this.table.getColumnNum() != this.table.getColumns().length ){
            return false;
        }
        
        int leftWidth = this.table.getHeight();
        int leftWidthIndex = -1;
        int i = 0;
        for(String str : this.table.getRows()){
            if(str.indexOf("%") == -1){
                int value = Integer.parseInt(str);
                if(0 != value){
                    rowsVal[i] = value;
                    leftWidth = leftWidth - value;
                }else{
                    leftWidthIndex = i;
                }
            }
            else
            {
                int numval = Integer.parseInt(str.substring(0, str.length()-1));
                rowsVal[i] = this.table.getHeight()*numval/100;
                leftWidth = leftWidth - rowsVal[i];
            }
            
            i++;
        }
            
        if(-1 != leftWidthIndex){
            rowsVal[leftWidthIndex] = leftWidth;
        }
        
        
        int leftHeight = this.table.getWidth();
        int leftHeightIndex = -1;
        int j = 0;
        for(String str : this.table.getColumns()){
            if(str.indexOf("%") == -1){
                int value = Integer.parseInt(str);
                if(0 != value){
                    cloumnVal[j] = value;
                    leftHeight = leftHeight - value;
                }else{
                    leftHeightIndex = j;
                }
            }
            else
            {
                int numval = Integer.parseInt(str.substring(0, str.length()-1));
                cloumnVal[j] = this.table.getWidth()*numval/100;
                leftHeight = leftHeight - cloumnVal[j];
            }
            
            j++;
        }
            
        if(-1 != leftHeightIndex){
            cloumnVal[leftHeightIndex] = leftHeight;
        }
        
//        for (int ii : rowsVal)
//        {
//            System.out.println("rowsHeight:" + ii);
//        }
//        
//        for (int ii : cloumnVal)
//        {
//            System.out.println("columnHeight:" + ii);
//        }
        
        return true;
    }
    
    public void initComponentsBounds(){
        int i = 0;
        
        for(JComponent comp : this.components){
            
            if(JLabel.class.isInstance(comp)){
                JLabel label = (JLabel)comp;
                
                if(0 == DataBase.getInstance().getLanguageFlag())
                {
                    label.setFont(FontConstants.normalFont);
                }
                else
                {
                    label.setFont(FontConstants.smallFont);
                }
                
                if(this.table.getAlignment().containsKey(i)){
                    label.setHorizontalAlignment(this.table.getAlignment().get(i));
                }else{
                    label.setHorizontalAlignment(Table.labelAlignmentX);
                }
                
                label.setVerticalAlignment(Table.labelAlignmentY);
                
                Integer [] bounds = getComponentBouds(this.bounds.get(i));
                bounds[1] = bounds[1] + (bounds[3]-Table.componentHeight)/2;
                bounds[3] = Table.componentHeight;

                label.setBounds(bounds[0], bounds[1], bounds[2],bounds[3]);
                

            }
            else if(JTextField.class.isInstance(comp)){
                JTextField text = (JTextField)comp;
                
                text.setHorizontalAlignment(Table.textAlignmentX);
                
                Integer [] bounds = getComponentBouds(this.bounds.get(i));
                bounds[1] = bounds[1] + (bounds[3]-Table.componentHeight)/2;
                bounds[3] = Table.componentHeight;
                    
                text.setBounds(bounds[0], bounds[1], bounds[2],bounds[3]);
            }
            else if(JCheckBox.class.isInstance(comp)){
                JCheckBox text = (JCheckBox)comp;

                Integer [] bounds = getComponentBouds(this.bounds.get(i));
                
                if(this.table.getAlignment().containsKey(i)){
                    if(SwingConstants.RIGHT == this.table.getAlignment().get(i)){
                        bounds[0] = bounds[0] + bounds[2] - Table.checkboxSize;
                    }
                }
                
                bounds[1] = bounds[1] + (bounds[3]-Table.checkboxSize)/2;
                bounds[2] = Table.checkboxSize;
                bounds[3] = Table.checkboxSize;
                    
                text.setBounds(bounds[0], bounds[1], bounds[2],bounds[3]);
            }
            else if(JButton.class.isInstance(comp)){
                JButton btn = (JButton)comp;
                
                if(0 == DataBase.getInstance().getLanguageFlag())
                {
                    btn.setFont(FontConstants.normalFont);
                }
                else
                {
                    btn.setFont(FontConstants.smallFont);
                }
                
                
                Integer [] bounds = getComponentBouds(this.bounds.get(i));
                
                bounds[1] = bounds[1] + (bounds[3]-Table.btnHeight)/2;
                bounds[3] = Table.btnHeight;
                    
                btn.setBounds(bounds[0], bounds[1], bounds[2],bounds[3]);
            }
            else if(JPanel.class.isInstance(comp))
            {
                Integer [] bounds = getComponentBouds(this.bounds.get(i));
                
//                bounds[1] = bounds[1] + (bounds[3]-Table.componentHeight)/2;
//                bounds[3] = Table.componentHeight;
                    
                comp.setBounds(bounds[0], bounds[1], bounds[2],bounds[3]);
            }
            else
            {
                Integer [] bounds = getComponentBouds(this.bounds.get(i));
                
                bounds[1] = bounds[1] + (bounds[3]-Table.componentHeight)/2;
                bounds[3] = Table.componentHeight;
                    
                comp.setBounds(bounds[0], bounds[1], bounds[2],bounds[3]);
            }
            
            i++;
        }

    }
    
    private Integer[] getComponentBouds(Integer val[]){
        Integer[] bounds = new Integer[4];
        bounds[0] = getX(val[1]);
        bounds[1] = getY(val[0]);
        bounds[2] = getWidth(val[1],val[3]);
        bounds[3] = getHeight(val[0], val[2]);
        return bounds;
    }
    
    private int getX(int val){
        int result = 0;
        for(int i = 0 ; i<val;i++){
            result = result + cloumnVal[i];
        }
        return result + Table.xx+Table.spaceWidth;
    }
    
    private int getY(int val){
        int result = 0;
        for(int i = 0 ; i<val;i++){
            result = result + rowsVal[i];
        }
        return result + Table.yy + Table.spaceHeight; 
    }
    
    private int getWidth(int start,int end){
        int result = 0;

        for(int i = start ; i<start+ end;i++){
            result = result + cloumnVal[i];
        }
        return result - 2*Table.spaceWidth;
    }
    
    private int getHeight(int start,int end){
        int result = 0;
        for(int i = start ; i< start+ end;i++){
            result = result + rowsVal[i];
        }
        return result - 2*Table.spaceHeight;
        
    }
    
//    public static void main(String[] args)
//    {
//        JFrame frame = new JFrame();
//        JLabel label = new JLabel("1label");
//        JTextField text = new JTextField("1text");
//        
//        JLabel label1 = new JLabel("2label");
//        JTextField text1 = new JTextField("2text");
//        
//        JLabel label2 = new JLabel("3label");
//        JTextField text2 = new JTextField("3text");
//        
//        JLabel label3 = new JLabel("4label");
//        JTextField text3 = new JTextField("4text");
//        
//        JLabel label4 = new JLabel("5label");
//        JTextField text4 = new JTextField("5text");
//        
//        Table table = new Table(800,600,3,4, new String[]{"40%","40%","0"}, new String[]{"10%","10%","10%","10%"});
////        new ComponentPositionUtil().getInitedBoundsComponent(new ArrayList<JComponent>(),new ArrayList<Integer[]>(),table);
//        
//        List<JComponent> coms = new ArrayList<JComponent>();
//        coms.add(label);
//        coms.add(text);
//        coms.add(label1);
//        coms.add(text1);
//        coms.add(label2);
//        coms.add(text2);
//        coms.add(label3);
//        coms.add(text3);
//        
//        coms.add(label4);
//        coms.add(text4);
//        
//        List<Integer[]> bounds = new ArrayList<Integer[]>();
//        bounds.add(new Integer[]{0,0,1,1});
//        bounds.add(new Integer[]{0,1,1,1});
//        bounds.add(new Integer[]{0,2,1,1});
//        bounds.add(new Integer[]{0,3,1,1});
//        bounds.add(new Integer[]{1,0,1,1});
//        bounds.add(new Integer[]{1,1,1,1});
//        bounds.add(new Integer[]{1,2,1,1});
//        bounds.add(new Integer[]{1,3,1,1});
//        
//        bounds.add(new Integer[]{2,2,1,1});
//        bounds.add(new Integer[]{2,3,1,1});
//        
//        new ComponentBoundsTool().getInitedBoundsComponent(coms, bounds, table);
//        
//        frame.setLayout(null);
//        
//        for(JComponent jj  : coms){
//            frame.add(jj);
//        }
//        frame.setBounds(0, 0, 600, 700);
//        frame.setVisible(true);
//        
//    }
}
