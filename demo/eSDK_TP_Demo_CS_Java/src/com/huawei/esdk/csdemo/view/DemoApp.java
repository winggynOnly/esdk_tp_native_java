package com.huawei.esdk.csdemo.view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DemoApp
{
    public static LoginFrame loginFrame;

    public static MainFrame mainFrame;

    public static ProgressFrame progressFrame;

    public static void main(String[] args)
    {
        try
        {
            System.setProperty("org.apache.cxf.JDKBugHacks.defaultUsesCaches", "true");
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        loginFrame = new LoginFrame();
        loginFrame.lunchFrame();
    }
}
