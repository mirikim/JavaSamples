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
  JButton ret = new JButton("반납");
  JButton button03f[]=new JButton[80];
  JButton button04f[]=new JButton[80];
  JButton button05f[]=new JButton[80];
  
  JLabel label0,label1,label2,label3,label4,la,la1;
  
  JTextField tf1 = new JTextField(7);
  JPasswordField tf2 = new JPasswordField(8);
  JButton b1 = new JButton("자리 배정");
  JLabel idl= new JLabel("학번: ");
  JLabel pwl= new JLabel("비밀번호: ");
  //학생들의 학번과 임의의 비밀번호가 저장되어 있는 배열
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
     if (idpw[i][0].equals(tf1.getText()) //배열안의 정보와 필드에 입력받은 값이 같다면
     && idpw[i][1].equals(tf2.getText())){ //로그인을 허용한다.
      both.append("인증에 성공하였습니다. 자리를 선택해주세요.\n");
      idpw[i][2]="1";
      break;
     }
     else if(i==9&&!(idpw[i][0].equals(tf1.getText()) //배열안의 모든 정보와 비교후
                    && idpw[i][1].equals(tf2.getText()))){ //틀린 정보를 입력한다면
     JOptionPane.showMessageDialog(f, "인증에 실패하였습니다.\n올바른 정보를 입력해주세요");
      break; // 경고창을 발생시킨다.
     }
     else {
      continue; //배열안의 값들과 비교를 다 하지 못한 상태라면 다음 배열안의 값과 비교해본다.
     }
    }
    tf1.setText("");
    tf2.setText("");
    
   }
   else if(o == ret){
    for (int i = 0; i < 10; i++) {
     if (idpw[i][0].equals(tf1.getText()) //배열안의 정보와 필드에 입력받은 값이 같다면
     && idpw[i][1].equals(tf2.getText())){ //로그인을 허용한다.
      both.append("인증에 성공하였습니다. 반납하실 자리를 선택해주세요.\n");
      idpw[i][2]="0";
      break;
     }
     else if(i==9&&!(idpw[i][0].equals(tf1.getText()) //배열안의 모든 정보와 비교후
     && idpw[i][1].equals(tf2.getText()))){ //틀린 정보를 입력한다면
     JOptionPane.showMessageDialog(f, "인증에 실패하였습니다.\n올바른 정보를 입력해주세요");
      break; // 경고창을 발생시킨다.
     }
     else {
      continue; //배열안의 값들과 비교를 다 하지 못한 상태라면 다음 배열안의 값과 비교해본다.
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
   
   JPanel sitPanel_3f = new JPanel();    //3층 열람실의  좌석을 패널을 담는 패널
  JPanel sitPanel_4f = new JPanel();    //4층 열람실의  좌석을 패널을 담는 패널
  JPanel sitPanel_5f = new JPanel();    //5층 열람실의  좌석을 패널을 담는 패널
  
   JPanel stuInfoPanel = new JPanel();  // 학생의 정보가 출력되는 패널
  JPanel loginPanel= new JPanel();     // 로그인 패널
  
   JPanel sit01_20_3f = new JPanel();    //3층 좌석 72개 담는 4개의 패널
  JPanel sit21_36_3f = new JPanel();   
   JPanel sit37_52_3f = new JPanel();   
   JPanel sit53_72_3f = new JPanel();
   
   JPanel sit01_08_4f = new JPanel();    //4층 좌석 72개 담는 4개의 패널
  JPanel sit09_16_4f = new JPanel();   
   JPanel sit17_24_4f = new JPanel();   
   JPanel sit25_32_4f = new JPanel();
   JPanel sit33_40_4f = new JPanel();
   JPanel sit41_48_4f = new JPanel();
   
   JPanel sit01_10_5f = new JPanel();    //5층 좌석 72개 담는 4개의 패널
  JPanel sit11_20_5f = new JPanel();   
   JPanel sit21_30_5f = new JPanel();   
   JPanel sit31_40_5f = new JPanel();
   
   sitPanel_3f.setLayout(new GridLayout(1, 7));  //층당 전체적 좌석 배치
  sitPanel_4f.setLayout(new GridLayout(3, 5));
   sitPanel_5f.setLayout(new GridLayout(3, 3));
   
   sit01_20_3f.setLayout(new GridLayout(10, 2));  // 3층 좌석 배열
  sit21_36_3f.setLayout(new GridLayout(10, 2));
   sit37_52_3f.setLayout(new GridLayout(10, 2));
   sit53_72_3f.setLayout(new GridLayout(10, 2));
   
   sit01_08_4f.setLayout(new GridLayout(4, 2));   // 4층 좌석 배열
  sit09_16_4f.setLayout(new GridLayout(4, 2));
   sit17_24_4f.setLayout(new GridLayout(4, 2));
   sit25_32_4f.setLayout(new GridLayout(4, 2));
   sit33_40_4f.setLayout(new GridLayout(4, 2));
   sit41_48_4f.setLayout(new GridLayout(4, 2));
   
   sit01_10_5f.setLayout(new GridLayout(2, 1));  // 5층 좌석 배열
  sit11_20_5f.setLayout(new GridLayout(2, 1));
   sit21_30_5f.setLayout(new GridLayout(2, 1));
   sit31_40_5f.setLayout(new GridLayout(2, 1));
   
   Font font1 = new Font("Dial Size", Font.BOLD, 50);
   // JLabel label0 = new JLabel("      한성대학교     도서관    ");
   // label0.setFont(font1);
   
   JLabel la = new JLabel("      34           ");
   la.setSize(10,700);
   JLabel la1 = new JLabel("        12         ");
   la1.setSize(10,700);
   
   
   for(int i=0; i<80; i++){          // 3층 버튼 80개 생성
   Integer I = new Integer(i);
    button03f[i] = new JButton(I.toString());
   }
   
   for(int ii=0; ii<80; ii++){        // 4층 버튼 80개 생성
   Integer I = new Integer(ii);
    button04f[ii] = new JButton(I.toString());
   }
   
   for(int iii=0; iii<80; iii++){     // 5층 버튼 80개 생성
   Integer I = new Integer(iii);
    button05f[iii] = new JButton(I.toString());
   }
   
   //3층 좌석 사이띄움을 위한 라벨
  JLabel label13 = new JLabel(" ");
   JLabel label23 = new JLabel(" ");
   JLabel label33 = new JLabel(" ");
   JLabel label43 = new JLabel(" ");
   
   //4층 좌석 사이띄움을 위한 라벨
  JLabel label14 = new JLabel(" ");
   JLabel label24 = new JLabel(" ");
   JLabel label34 = new JLabel(" ");
   JLabel label44 = new JLabel(" ");
   JLabel label54 = new JLabel(" ");
   JLabel label64 = new JLabel(" ");
   JLabel label74 = new JLabel(" ");
   JLabel label84 = new JLabel(" ");
   JLabel label94 = new JLabel(" ");
   
   
   
   
   //5층 좌석 사이띄움을 위한 라벨
  JLabel label15 = new JLabel(" ");
   JLabel label25 = new JLabel(" ");
   JLabel label35 = new JLabel(" ");
   JLabel label45 = new JLabel(" ");
   JLabel label55 = new JLabel(" ");
   
   // 3층 패널에 버튼 삽입
  int j;
   for(j=1; j<21; j++){   // 패널1에 버튼 20개 삽입
   sit01_20_3f.add(button03f[j]);
   }
   int k;
   for(k=21; k<37; k++){  // 패널2에 버튼 20개 삽입
   sit21_36_3f.add(button03f[k]);
   }
   int l;
   for(l=37; l<53; l++){  // 패널3에 버튼 20개 삽입
   sit37_52_3f.add(button03f[l]);
   }
   int m;
   for(m=53; m<73; m++){  // 패널4에 버튼 20개 삽입
   sit53_72_3f.add(button03f[m]);
   }
   
   //4층 패널에 버튼 삽입
  int jj;
   for(jj=1; jj<9; jj++){   // 패널1에 버튼 8개 삽입
   sit01_08_4f.add(button04f[jj]);
   }
   int kk;
   for(kk=9; kk<17; kk++){  // 패널2에 버튼 8개 삽입
   sit09_16_4f.add(button04f[kk]);
   }
   int ll;
   for(ll=17; ll<25; ll++){  // 패널3에 버튼 8개 삽입
   sit17_24_4f.add(button04f[ll]);
   }
   int mm;
   for(mm=25; mm<33; mm++){  // 패널4에 버튼 8개 삽입
   sit25_32_4f.add(button04f[mm]);
   }
   int oo;
   for(oo=33; oo<41; oo++){   // 패널5에 버튼 8개 삽입
   sit33_40_4f.add(button04f[oo]);
   }
   int pp;
   for(pp=41; pp<49; pp++){  // 패널6에 버튼 8개 삽입
   sit41_48_4f.add(button04f[pp]);
   }
   
   
   
   //5층 패널에 버튼 삽입
  int jjj;
   for(jjj=1; jjj<11; jjj++){   // 패널1에 버튼 10개 삽입
   sit01_10_5f.add(button05f[jjj]);
   }
   int kkk;
   for(kkk=11; kkk<21; kkk++){  // 패널2에 버튼 10개 삽입
   sit11_20_5f.add(button05f[kkk]);
   }
   int lll;
   for(lll=21; lll<31; lll++){  // 패널3에 버튼 10개 삽입
   sit21_30_5f.add(button05f[lll]);
   }
   int mmm;
   for(mmm=31; mmm<41; mmm++){  // 패널4에 버튼 10개 삽입
   sit31_40_5f.add(button05f[mmm]);
   }
   
   //로그인 패널에 라벨 삽입
  
   
   loginPanel.add(idl);
   loginPanel.add(tf1);
   loginPanel.add(pwl);
   loginPanel.add(tf2);
   loginPanel.add(b1);
   loginPanel.add(ret);
   loginPanel.add(both);
   
   //3층 패널 정렬
  sitPanel_3f.add("West",sit01_20_3f);
   sitPanel_3f.add(label13);
   sitPanel_3f.add(sit21_36_3f);
   sitPanel_3f.add(label23);
   sitPanel_3f.add(sit37_52_3f);
   sitPanel_3f.add(label33);
   sitPanel_3f.add("East",sit53_72_3f);
   
   //4층 패널 정렬
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
   
   //5층 패널 정렬
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
 //  readingRoom.setIconAt(0, new ImageIcon("이름없음.png"));
  // readingRoom.setIconAt(1, new ImageIcon("이름없음.png"));
  // readingRoom.setIconAt(2, new ImageIcon("이름없ㅇ.png"));


   
   f.add(readingRoom,"North");
   f.setSize(800, 650);
   f.setVisible(true);
  }
  public static void main(String []args){
   L_Board l=  new L_Board();
  }
  
 }
