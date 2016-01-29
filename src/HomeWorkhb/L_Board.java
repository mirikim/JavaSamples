package HomeWorkhb;

import java.awt.*;

import javax.swing.*;
 import java.io.IOException;
 import java.awt.event.*;
 import java.io.IOException;

import javax.swing.event.*;

public class L_Board implements ActionListener, ChangeListener {
  
  private static final long serialVersionUID = 1L;
  JFrame f;
  JButton ret = new JButton("�ݳ�");
  JButton button03f[]=new JButton[80];
  JButton button04f[]=new JButton[80];
  JButton button05f[]=new JButton[80];
  
  JLabel label0,label1,label2,label3,label4,la,la1;
  
  JTextField tf1 = new JTextField(7);
  JPasswordField tf2 = new JPasswordField(8);
  JButton b1 = new JButton("�ڸ� ����");
  JLabel idl= new JLabel("�й�: ");
  JLabel pwl= new JLabel("��й�ȣ: ");
  //�л����� �й��� ������ ��й�ȣ�� ����Ǿ� �ִ� �迭
 String[][] idpw={{"0392023","1212","0",""},{"0392024","1212","0",""},{"0392025","1212","0",""},
  {"0392028","1212","0",""},{"0392011","1212","0",""},{"0692013","1212","0",""},{"0892056","1212","0",""},
  {"0492040","1212","0",""},{"0192021","1212","0",""},{"0246011","1212","0",""}};
  
  TextArea both = new TextArea("", 4, 40);
  String str = "";
  
  JTabbedPane readingRoom;
  
  public L_Board(){
   interF();
  }
 public void actionPerformed(ActionEvent e) {
   
   Object o = e.getSource();
   if (o == b1) {
    for (int i = 0; i < 10; i++) {
     if (idpw[i][0].equals(tf1.getText()) //�迭���� ������ �ʵ忡 �Է¹��� ���� ���ٸ�
     && idpw[i][1].equals(tf2.getText())){ //�α����� ����Ѵ�.
      both.append("������ �����Ͽ����ϴ�. �ڸ��� �������ּ���.\n");
      idpw[i][2]="1";
      break;
     }
     else if(i==9&&!(idpw[i][0].equals(tf1.getText()) //�迭���� ��� ������ ����
                    && idpw[i][1].equals(tf2.getText()))){ //Ʋ�� ������ �Է��Ѵٸ�
     JOptionPane.showMessageDialog(f, "������ �����Ͽ����ϴ�.\n�ùٸ� ������ �Է����ּ���");
      break; // ���â�� �߻���Ų��.
     }
     else {
      continue; //�迭���� ����� �񱳸� �� ���� ���� ���¶�� ���� �迭���� ���� ���غ���.
     }
    }
    tf1.setText("");
    tf2.setText("");
    
   }
   else if(o == ret){
    for (int i = 0; i < 10; i++) {
     if (idpw[i][0].equals(tf1.getText()) //�迭���� ������ �ʵ忡 �Է¹��� ���� ���ٸ�
     && idpw[i][1].equals(tf2.getText())){ //�α����� ����Ѵ�.
      both.append("������ �����Ͽ����ϴ�. �ݳ��Ͻ� �ڸ��� �������ּ���.\n");
      idpw[i][2]="0";
      break;
     }
     else if(i==9&&!(idpw[i][0].equals(tf1.getText()) //�迭���� ��� ������ ����
     && idpw[i][1].equals(tf2.getText()))){ //Ʋ�� ������ �Է��Ѵٸ�
     JOptionPane.showMessageDialog(f, "������ �����Ͽ����ϴ�.\n�ùٸ� ������ �Է����ּ���");
      break; // ���â�� �߻���Ų��.
     }
     else {
      continue; //�迭���� ����� �񱳸� �� ���� ���� ���¶�� ���� �迭���� ���� ���غ���.
     }
    }
    tf1.setText("");
    tf2.setText("");
   }
  }
 public void stateChanged(ChangeEvent e)
  {
   int curSelIndex = readingRoom.getSelectedIndex();
   String curPaneTitle = readingRoom.getTitleAt(curSelIndex);
  }
  
  private void interF(){
   
   b1.addActionListener(this);
   f = new JFrame("Jiyoung's Board");
   f.setLayout(new BorderLayout());
   
   readingRoom = new JTabbedPane();
   readingRoom.addChangeListener(this);
   
   
   both.append(str);
   // f1=new Frame();
   // f1.setLayout(new BorderLayout());
   Font font = new Font("Dial Size", Font.BOLD, 20);
   //
   
   JPanel sitPanel_3f = new JPanel();    //3�� ��������  �¼��� �г��� ��� �г�
  JPanel sitPanel_4f = new JPanel();    //4�� ��������  �¼��� �г��� ��� �г�
  JPanel sitPanel_5f = new JPanel();    //5�� ��������  �¼��� �г��� ��� �г�
  
   JPanel stuInfoPanel = new JPanel();  // �л��� ������ ��µǴ� �г�
  JPanel loginPanel= new JPanel();     // �α��� �г�
  
   JPanel sit01_20_3f = new JPanel();    //3�� �¼� 72�� ��� 4���� �г�
  JPanel sit21_36_3f = new JPanel();   
   JPanel sit37_52_3f = new JPanel();   
   JPanel sit53_72_3f = new JPanel();
   
   JPanel sit01_08_4f = new JPanel();    //4�� �¼� 72�� ��� 4���� �г�
  JPanel sit09_16_4f = new JPanel();   
   JPanel sit17_24_4f = new JPanel();   
   JPanel sit25_32_4f = new JPanel();
   JPanel sit33_40_4f = new JPanel();
   JPanel sit41_48_4f = new JPanel();
   
   JPanel sit01_10_5f = new JPanel();    //5�� �¼� 72�� ��� 4���� �г�
  JPanel sit11_20_5f = new JPanel();   
   JPanel sit21_30_5f = new JPanel();   
   JPanel sit31_40_5f = new JPanel();
   
   sitPanel_3f.setLayout(new GridLayout(1, 7));  //���� ��ü�� �¼� ��ġ
  sitPanel_4f.setLayout(new GridLayout(3, 5));
   sitPanel_5f.setLayout(new GridLayout(3, 3));
   
   sit01_20_3f.setLayout(new GridLayout(10, 2));  // 3�� �¼� �迭
  sit21_36_3f.setLayout(new GridLayout(10, 2));
   sit37_52_3f.setLayout(new GridLayout(10, 2));
   sit53_72_3f.setLayout(new GridLayout(10, 2));
   
   sit01_08_4f.setLayout(new GridLayout(4, 2));   // 4�� �¼� �迭
  sit09_16_4f.setLayout(new GridLayout(4, 2));
   sit17_24_4f.setLayout(new GridLayout(4, 2));
   sit25_32_4f.setLayout(new GridLayout(4, 2));
   sit33_40_4f.setLayout(new GridLayout(4, 2));
   sit41_48_4f.setLayout(new GridLayout(4, 2));
   
   sit01_10_5f.setLayout(new GridLayout(2, 1));  // 5�� �¼� �迭
  sit11_20_5f.setLayout(new GridLayout(2, 1));
   sit21_30_5f.setLayout(new GridLayout(2, 1));
   sit31_40_5f.setLayout(new GridLayout(2, 1));
   
   Font font1 = new Font("Dial Size", Font.BOLD, 50);
   // JLabel label0 = new JLabel("      �Ѽ����б�     ������    ");
   // label0.setFont(font1);
   
   JLabel la = new JLabel("      34           ");
   la.setSize(10,700);
   JLabel la1 = new JLabel("        12         ");
   la1.setSize(10,700);
   
   
   for(int i=0; i<80; i++){          // 3�� ��ư 80�� ����
   Integer I = new Integer(i);
    button03f[i] = new JButton(I.toString());
   }
   
   for(int ii=0; ii<80; ii++){        // 4�� ��ư 80�� ����
   Integer I = new Integer(ii);
    button04f[ii] = new JButton(I.toString());
   }
   
   for(int iii=0; iii<80; iii++){     // 5�� ��ư 80�� ����
   Integer I = new Integer(iii);
    button05f[iii] = new JButton(I.toString());
   }
   
   //3�� �¼� ���̶���� ���� ��
  JLabel label13 = new JLabel(" ");
   JLabel label23 = new JLabel(" ");
   JLabel label33 = new JLabel(" ");
   JLabel label43 = new JLabel(" ");
   
   //4�� �¼� ���̶���� ���� ��
  JLabel label14 = new JLabel(" ");
   JLabel label24 = new JLabel(" ");
   JLabel label34 = new JLabel(" ");
   JLabel label44 = new JLabel(" ");
   JLabel label54 = new JLabel(" ");
   JLabel label64 = new JLabel(" ");
   JLabel label74 = new JLabel(" ");
   JLabel label84 = new JLabel(" ");
   JLabel label94 = new JLabel(" ");
   
   
   
   
   //5�� �¼� ���̶���� ���� ��
  JLabel label15 = new JLabel(" ");
   JLabel label25 = new JLabel(" ");
   JLabel label35 = new JLabel(" ");
   JLabel label45 = new JLabel(" ");
   JLabel label55 = new JLabel(" ");
   
   // 3�� �гο� ��ư ����
  int j;
   for(j=1; j<21; j++){   // �г�1�� ��ư 20�� ����
   sit01_20_3f.add(button03f[j]);
   }
   int k;
   for(k=21; k<37; k++){  // �г�2�� ��ư 20�� ����
   sit21_36_3f.add(button03f[k]);
   }
   int l;
   for(l=37; l<53; l++){  // �г�3�� ��ư 20�� ����
   sit37_52_3f.add(button03f[l]);
   }
   int m;
   for(m=53; m<73; m++){  // �г�4�� ��ư 20�� ����
   sit53_72_3f.add(button03f[m]);
   }
   
   //4�� �гο� ��ư ����
  int jj;
   for(jj=1; jj<9; jj++){   // �г�1�� ��ư 8�� ����
   sit01_08_4f.add(button04f[jj]);
   }
   int kk;
   for(kk=9; kk<17; kk++){  // �г�2�� ��ư 8�� ����
   sit09_16_4f.add(button04f[kk]);
   }
   int ll;
   for(ll=17; ll<25; ll++){  // �г�3�� ��ư 8�� ����
   sit17_24_4f.add(button04f[ll]);
   }
   int mm;
   for(mm=25; mm<33; mm++){  // �г�4�� ��ư 8�� ����
   sit25_32_4f.add(button04f[mm]);
   }
   int oo;
   for(oo=33; oo<41; oo++){   // �г�5�� ��ư 8�� ����
   sit33_40_4f.add(button04f[oo]);
   }
   int pp;
   for(pp=41; pp<49; pp++){  // �г�6�� ��ư 8�� ����
   sit41_48_4f.add(button04f[pp]);
   }
   
   
   
   //5�� �гο� ��ư ����
  int jjj;
   for(jjj=1; jjj<11; jjj++){   // �г�1�� ��ư 10�� ����
   sit01_10_5f.add(button05f[jjj]);
   }
   int kkk;
   for(kkk=11; kkk<21; kkk++){  // �г�2�� ��ư 10�� ����
   sit11_20_5f.add(button05f[kkk]);
   }
   int lll;
   for(lll=21; lll<31; lll++){  // �г�3�� ��ư 10�� ����
   sit21_30_5f.add(button05f[lll]);
   }
   int mmm;
   for(mmm=31; mmm<41; mmm++){  // �г�4�� ��ư 10�� ����
   sit31_40_5f.add(button05f[mmm]);
   }
   
   //�α��� �гο� �� ����
  
   
   loginPanel.add(idl);
   loginPanel.add(tf1);
   loginPanel.add(pwl);
   loginPanel.add(tf2);
   loginPanel.add(b1);
   loginPanel.add(ret);
   loginPanel.add(both);
   
   //3�� �г� ����
  sitPanel_3f.add("West",sit01_20_3f);
   sitPanel_3f.add(label13);
   sitPanel_3f.add(sit21_36_3f);
   sitPanel_3f.add(label23);
   sitPanel_3f.add(sit37_52_3f);
   sitPanel_3f.add(label33);
   sitPanel_3f.add("East",sit53_72_3f);
   
   //4�� �г� ����
  sitPanel_4f.add(sit01_08_4f);
   sitPanel_4f.add(label14);
   sitPanel_4f.add(sit09_16_4f);
   sitPanel_4f.add(label24);
   sitPanel_4f.add(sit17_24_4f);
   sitPanel_4f.add(label34);
   sitPanel_4f.add(label44);
   sitPanel_4f.add(label54);
   sitPanel_4f.add(label64);
   sitPanel_4f.add(label74);
   sitPanel_4f.add(sit25_32_4f);
   sitPanel_4f.add(label84);
   sitPanel_4f.add(sit33_40_4f);
   sitPanel_4f.add(label94);
   sitPanel_4f.add(sit41_48_4f);
   
   //5�� �г� ����
  sitPanel_5f.add(sit01_10_5f);
   sitPanel_5f.add(label15);
   sitPanel_5f.add(sit11_20_5f);
   sitPanel_5f.add(label25);
   sitPanel_5f.add(label35);
   sitPanel_5f.add(label45);
   sitPanel_5f.add(sit21_30_5f);
   sitPanel_5f.add(label55);
   sitPanel_5f.add(sit31_40_5f);
   
   f.add(loginPanel);
   
   readingRoom.addTab("1",sitPanel_3f);
   readingRoom.addTab("2",sitPanel_4f);
   readingRoom.addTab("3",sitPanel_5f);
 //  readingRoom.setIconAt(0, new ImageIcon("�̸�����.png"));
  // readingRoom.setIconAt(1, new ImageIcon("�̸�����.png"));
  // readingRoom.setIconAt(2, new ImageIcon("�̸�����.png"));


   
   f.add(readingRoom,"North");
   f.setSize(800, 650);
   f.setVisible(true);
  }
  public static void main(String []args){
   L_Board l=  new L_Board();
  }
  
 }
