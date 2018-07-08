package view;

import javax.swing.*;
import java.awt.*;

public class IndexView extends JFrame implements Runnable{

    public static void main(String[] args) {
        new Thread(IndexView.instance());
        indexView.open();
    }

    public static RecommendPanel p1;
    public static StoryPanel p2;
    public static EditorPanel p3;
    public static RobotPanel p4;
    public static IndexView indexView;

    private JMenu menu; //菜单
    private JMenuBar jMenuBar;   //菜单条

    public static IndexView instance() {
        if (indexView == null) {
            indexView = new IndexView();
        }
        return indexView;
    }

    private IndexView() {

        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.setTitle("首页");
        this.setResizable(false);

        menu = new JMenu("TravelToShare");//创建菜单
        jMenuBar = new  JMenuBar() ;  //创建菜单工具栏
        jMenuBar.add(menu) ;      //将菜单增加到菜单栏
        this.setJMenuBar(jMenuBar) ;  //为窗体设置菜单工具栏

        JTabbedPane  jp=new JTabbedPane(JTabbedPane.LEFT) ;    //设置选项卡的坐标
        //创建多个容器
        p1 = new RecommendPanel();
        p2 = new StoryPanel();
        p3 = new EditorPanel();
        p4 = new RobotPanel();

        //添加子容器  并且为选项卡添加名字
        jp.add("景点推荐", p1);
        jp.add("旅游故事", p2);
        jp.add("创建故事", p3);
        jp.add("旅游小助手",p4);
        //将选项卡窗体添加到 主窗体上去
        this.add(jp,BorderLayout.CENTER);

    }

    public void open() {
        this.setVisible(true);
    }
    public void run() {
        IndexView.instance();
    }

}
