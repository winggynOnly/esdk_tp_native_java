package com.huawei.esdk.csdemo.view;

import java.awt.Dialog;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.common.ItemObject;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.utils.DateChooserJTextField;

public class RecurrenceConfFrame extends JDialog
{

    /** * */
    private static final long serialVersionUID = 1L;

    private Rectangle rect;

    private JLabel frequencyLabel = new JLabel();

    private JComboBox frequencyBox = new JComboBox();

    private JLabel intervalLabel = new JLabel();

    private JTextField intervalText = new JTextField();

    private JLabel weekDaysLabel = new JLabel();

    private JList weekDaysList;

    private JLabel weekDayLabel = new JLabel();

    private JTextField weekDayText = new JTextField();

    private JLabel monthDayLabel = new JLabel();

    private JTextField monthDayText = new JTextField();

    private JLabel countLabel = new JLabel();

    private JTextField countText = new JTextField();

    private JLabel endDateLabel = new JLabel();

    private DateChooserJTextField dateText = new DateChooserJTextField();

    private JButton okButton = new JButton();

    public RecurrenceConfFrame(Dialog owner, Boolean isModal, Rectangle rect)
    {
        super(owner, isModal);
        this.rect = rect;
    }

    public void lunchFrame()
    {
        this.setTitle(LabelText.recurrence_conference_detail[DataBase
                .getInstance().getLanguageFlag()]);
        this.setBounds(rect);
        this.setLayout(null);

        this.frequencyLabel.setText(LabelText.time_type[DataBase.getInstance()
                .getLanguageFlag()]);
        this.intervalLabel.setText(LabelText.interval[DataBase.getInstance()
                .getLanguageFlag()]);
        this.weekDaysLabel.setText(LabelText.weekDays[DataBase.getInstance()
                .getLanguageFlag()]);
        this.weekDayLabel.setText(LabelText.weekDay[DataBase.getInstance()
                .getLanguageFlag()]);
        this.monthDayLabel.setText(LabelText.monthDay[DataBase.getInstance()
                .getLanguageFlag()]);
        this.countLabel.setText(LabelText.count[DataBase.getInstance()
                .getLanguageFlag()]);
        this.endDateLabel.setText(LabelText.endDate[DataBase.getInstance()
                .getLanguageFlag()]);
        okButton.setText(LabelText.okBtn[DataBase.getInstance()
                .getLanguageFlag()]);

        ItemObject obj0 = new ItemObject();
        obj0.setKey("0");
        obj0.setValue(LabelText.daily[DataBase.getInstance().getLanguageFlag()]);
        frequencyBox.addItem(obj0);

        ItemObject obj1 = new ItemObject();
        obj1.setKey("1");
        obj1.setValue(LabelText.weekly[DataBase.getInstance().getLanguageFlag()]);
        frequencyBox.addItem(obj1);

        ItemObject obj2 = new ItemObject();
        obj2.setKey("2");
        obj2.setValue(LabelText.monthly[DataBase.getInstance()
                .getLanguageFlag()]);
        frequencyBox.addItem(obj2);

        ItemObject day0 = new ItemObject();
        day0.setKey("0");
        day0.setValue(LabelText.sunday[DataBase.getInstance().getLanguageFlag()]);
        ItemObject day1 = new ItemObject();
        day1.setKey("1");
        day1.setValue(LabelText.monday[DataBase.getInstance().getLanguageFlag()]);
        ItemObject day2 = new ItemObject();
        day2.setKey("2");
        day2.setValue(LabelText.tuesday[DataBase.getInstance()
                .getLanguageFlag()]);
        ItemObject day3 = new ItemObject();
        day3.setKey("3");
        day3.setValue(LabelText.wednesday[DataBase.getInstance()
                .getLanguageFlag()]);
        ItemObject day4 = new ItemObject();
        day4.setKey("4");
        day4.setValue(LabelText.thursday[DataBase.getInstance()
                .getLanguageFlag()]);
        ItemObject day5 = new ItemObject();
        day5.setKey("5");
        day5.setValue(LabelText.friday[DataBase.getInstance().getLanguageFlag()]);
        ItemObject day6 = new ItemObject();
        day6.setKey("6");
        day6.setValue(LabelText.saturday[DataBase.getInstance()
                .getLanguageFlag()]);

        ItemObject[] data =
        { day0, day1, day2, day3, day4, day5, day6 };
        weekDaysList = new JList(data);

        frequencyLabel.setBounds(30, 30, 120, 20);
        frequencyBox.setBounds(120, 30, 200, 20);

        intervalLabel.setBounds(30, 60, 120, 20);
        intervalText.setBounds(120, 60, 200, 20);

        weekDaysLabel.setBounds(30, 90, 120, 20);
        weekDaysList.setBounds(120, 90, 200, 120);

        weekDayLabel.setBounds(30, 220, 120, 20);
        weekDayText.setBounds(120, 220, 200, 20);

        monthDayLabel.setBounds(30, 250, 120, 20);
        monthDayText.setBounds(120, 250, 200, 20);

        countLabel.setBounds(30, 280, 120, 20);
        countText.setBounds(120, 280, 200, 20);

        endDateLabel.setBounds(30, 310, 120, 20);
        dateText.setBounds(120, 310, 200, 20);

        okButton.setBounds(140, 340, 80, 25);

        final RecurrenceConfFrame frame = this;
        okButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                frame.setVisible(false);
            }
        });
        
        weekDaysList.setEnabled(false);
        weekDayText.setEnabled(false);
        monthDayText.setEnabled(false);

        this.add(frequencyLabel);
        this.add(frequencyBox);
        this.add(intervalLabel);
        this.add(intervalText);
        this.add(weekDaysLabel);
        this.add(weekDaysList);
        this.add(weekDayLabel);
        this.add(weekDayText);
        this.add(monthDayLabel);
        this.add(monthDayText);
        this.add(countLabel);
        this.add(countText);
        this.add(endDateLabel);
        this.add(dateText);

        this.add(okButton);

        this.setResizable(false);

        frequencyBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e)
            {
                ItemObject obj = (ItemObject) e.getItem();
                if (obj.getKey().equals("0"))
                {
//                    weekDaysList.clearSelection();
                    weekDaysList.setEnabled(false);
                    weekDayText.setEnabled(false);
                    monthDayText.setEnabled(false);
                }
                else if (obj.getKey().equals("1"))
                {
//                    weekDaysList.clearSelection();
                    weekDaysList.setEnabled(true);
                    weekDayText.setEnabled(false);
                    monthDayText.setEnabled(false);
                }
                else
                {
//                    weekDaysList.clearSelection();
                    weekDaysList.setEnabled(true);
                    weekDayText.setEnabled(true);
                    monthDayText.setEnabled(true);
                }
            }
        });
    }

    public JComboBox getFrequencyBox()
    {
        return frequencyBox;
    }

    public JTextField getIntervalText()
    {
        return intervalText;
    }

    public JList getWeekDaysList()
    {
        return weekDaysList;
    }

    public JTextField getWeekDayText()
    {
        return weekDayText;
    }

    public JTextField getMonthDayText()
    {
        return monthDayText;
    }

    public JTextField getCountText()
    {
        return countText;
    }

    public DateChooserJTextField getDateText()
    {
        return dateText;
    }
}
