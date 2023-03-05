package com.qazi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Objects;

public class ProjectSem4 extends Frame implements ActionListener, ItemListener{

    String sfn,smn,sln,sph,sem, string_nationality, string_passport,FileName;
    String concatStringsInRepo="Entries:\n";
    String concatStringsInReader="Details:\n";
    TextField first_name, middle_name, last_name,mob,email,nationality,passport,readfile,checkout;
    Button b1,b2,b3,clear,checkOutButton;  //b1-> gets all files, b2-> writes files, b3-> reads files
    Checkbox r1,r2,r3,r4,r5,r6;
    CheckboxGroup cbg1;
    Choice c1, c2,c3,c4,c5,c6,c7,c8;
    Image image;
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    TextArea ta1, ta2;
    Font f1 = new Font("Helvetica", Font.BOLD,14);
    Font f2 = new Font("Times New Roman", Font.ITALIC+Font.BOLD, 20);

    ProjectSem4() {
        setFont(f1);

        readImage();
        label();
        textfield();
        button();
        checkbox();
        choice();
        textarea();

        setBoundsButtons();
        setBoundsCheckbox();
        setBoundsLabels();
        setBoundsTextFields();
        setBoundsChoice();
        setBoundsTextArea();

        addButton();
        addTextFields();
        addCheckBox();
        addLabel();
        addChoice();
        addTextArea();

        buttonActionListener();
        choiceActionListener();
        checkboxActionListener();

        systemExit();
    }

    public void readImage(){
        try {
            image = ImageIO.read(new File("logo.png"));
        }
        catch(Exception ignored){}
    }

    public void label(){
        l1 = new Label("First Name * ");
        l2 = new Label("Middle Name");
        l3 = new Label("Last Name");
        l4 = new Label("Mobile *");
        l5 = new Label("Email");
        l6 = new Label("Nationality");
        l7 = new Label("Passport *");
        l8 = new Label("Check In");
        l9 = new Label("Check Out");
        l10 = new Label("Room No");
    }

    public void textarea(){
        ta1 = new TextArea();
        ta2 = new TextArea();
    }

    public void textfield(){
        first_name = new TextField(100);
        middle_name = new TextField(100);
        last_name = new TextField(100);
        mob = new TextField(100);
        email= new TextField(100);
        nationality= new TextField(100);
        passport= new TextField(100);
        readfile=new TextField(100);
        checkout=new TextField(100);
    }

    public void button(){
        b1 = new Button("GET ENTRIES");
        b2 = new Button("PROCEED");
        b3 = new Button("READ");
        checkOutButton = new Button("CHECK OUT");
        clear = new Button("Clear");
    }
    public void checkbox(){
        cbg1 = new CheckboxGroup();
        r1 = new Checkbox("Mr", cbg1,true);
        r2 = new Checkbox("Mrs", cbg1, true);
        r3 = new Checkbox("Ms", cbg1, true);
        r4 = new Checkbox("Prof", cbg1, true);
        r5 = new Checkbox("Dr", cbg1, true);
        r6 = new Checkbox("Gen", cbg1, true);
    }
    public void choice(){
        c1 = new Choice();
        c2 = new Choice();
        c3 = new Choice();
        c4 = new Choice();
        c5 = new Choice();
        c6 = new Choice();
        c7 = new Choice();
        c8 = new Choice();

        for(int i=1;i<=31;i++){
            c1.add(String.valueOf(i));
            c4.add(String.valueOf(i));
        }
        for(int i=1;i<=12;i++){
            c2.add(String.valueOf(i));
            c5.add(String.valueOf(i));
        }
        for(int i=2022;i<=2100;i++){
            c3.add(String.valueOf(i));
            c6.add(String.valueOf(i));
        }
        c7.add("X");c7.add("L");c7.add("S");c7.add("P");c7.add("E");
        for(int i=1;i<=5999;i++){
            c8.add(String.valueOf(i));
        }
    }

    public void setBoundsTextArea(){
        ta1.setBounds(550,120,300,520);
        ta2.setBounds(900,160,400,320);
    }

    public void setBoundsButtons(){
        b1.setBounds(550,700,300,50);
        b2.setBounds(200,700,300,50);
        b3.setBounds(1100,120,200,30);
        checkOutButton.setBounds(1100,500,200,30);
        clear.setBounds(900,550,400,30);
    }

    public void setBoundsCheckbox(){
        r1.setBounds(200,100,50,50);
        r2.setBounds(250,100,50,50);
        r3.setBounds(300,100,50,50);
        r4.setBounds(400,100,50,50);
        r5.setBounds(350,100,50,50);
        r6.setBounds(450,100,50,50);
    }

    public void setBoundsLabels(){
        l1.setBounds(200,150,100,50);
        l2.setBounds(200,200,100,50);
        l3.setBounds(200,250,100,50);
        l4.setBounds(200,300,100,50);
        l5.setBounds(200,350,100,50);
        l6.setBounds(200,400,100,50);
        l7.setBounds(200,450,100,50);
        l8.setBounds(200,500,100,50);
        l9.setBounds(200,550,100,50);
        l10.setBounds(200,600,100,50);
    }

    public void setBoundsTextFields(){
        first_name.setBounds(300,160,200,30);
        middle_name.setBounds(300,210,200,30);
        last_name.setBounds(300,260,200,30);
        mob.setBounds(300,310,200,30);
        email.setBounds(300,360,200,30);
        nationality.setBounds(300,410,200,30);
        passport.setBounds(300,460,200,30);
        readfile.setBounds(900,121,200,30);
        checkout.setBounds(900,500,200,30);
    }
    public void setBoundsChoice(){
        c1.setBounds(300,510,40,100);
        c2.setBounds(340,510,40,100);
        c3.setBounds(380,510,55,100);
        c4.setBounds(300,560,40,100);
        c5.setBounds(340,560,40,100);
        c6.setBounds(380,560,55,100);
        c7.setBounds(300,610,40,100);
        c8.setBounds(340,610,55,100);
    }
    public void addTextArea(){add(ta1);add(ta2);
    }

    public void addButton(){
        add(b1);add(b2);add(b3);add(checkOutButton);add(clear);
    }

    public void addTextFields(){
        add(first_name);add(middle_name);add(last_name);add(mob);add(email);add(nationality);add(passport);add(readfile);add(checkout);
    }

    public void addCheckBox(){
        add(r1);add(r2);add(r3);add(r4);add(r5);add(r6);
    }

    public void addLabel(){
        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(l10);
    }

    public void addChoice(){
        add(c1);add(c2);add(c3);add(c4);add(c5);add(c6);add(c7);add(c8);
    }

    public void buttonActionListener(){
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);checkOutButton.addActionListener(this);clear.addActionListener(this);

    }

    public void choiceActionListener(){
        c1.addItemListener(this);c2.addItemListener(this);c3.addItemListener(this);c4.addItemListener(this);c5.addItemListener(this);c6.addItemListener(this);
    }

    public void checkboxActionListener(){
        r1.addItemListener(this);r2.addItemListener(this);r3.addItemListener(this);r4.addItemListener(this);r5.addItemListener(this);r6.addItemListener(this);
    }

    public void systemExit(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void clearTextFields(){
        first_name.setText("");
        middle_name.setText("");
        last_name.setText("");
        mob.setText("");
        email.setText("");
        nationality.setText("");
        passport.setText("");
    }

    public void getTextFields(){
        sfn= first_name.getText();
        smn= middle_name.getText();
        sln= last_name.getText();
        sph=mob.getText();
        sem=email.getText();
        string_nationality =nationality.getText();
        string_passport =passport.getText();
    }


    public void writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\JavaProjectFiles\\"+ sfn+" "+sln+" ("+string_passport+")",true));
            writer.write("Name: "+cbg1.getSelectedCheckbox().getLabel()+". "+sfn+" "+smn+" "+sln+"\n");
            writer.write("Mob: "+sph+"\n");
            writer.write("Email: "+sem+"\n");
            writer.write("Nationality: "+ string_nationality +"\n");
            writer.write("Passport No: "+ string_passport +"\n");
            writer.write("Check In (dd\\mm\\yyyy): "+c1.getSelectedItem()+"\\"+c2.getSelectedItem()+"\\"+c3.getSelectedItem()+"\n");
            writer.write("Check Out (dd\\mm\\yyyy): "+c4.getSelectedItem()+"\\"+c5.getSelectedItem()+"\\"+c6.getSelectedItem()+"\n");
            writer.write("ALLOCATED ROOM NO: "+c7.getSelectedItem()+" - "+c8.getSelectedItem()+"\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void getFilesFromRepo(){
        Graphics g = getGraphics();
        File file = new File("D:\\JavaProjectFiles\\");

        // returns an array of all files
        String[] fileList = file.list();
        int i=0;
        assert fileList != null;
        for (String str : fileList) {
            System.out.println(str);
            concatStringsInRepo=concatStringsInRepo+"\n"+str;
            i++;
        }
        ta1.setText(concatStringsInRepo+"\n\nTotal Entries : "+i);
    }

    public void readFile(){
        Graphics g = getGraphics();
        FileName=readfile.getText();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjectFiles\\"+FileName));
            String Line;
            while((Line = reader.readLine()) !=null){
                System.out.println(Line);
                concatStringsInReader=concatStringsInReader+"\n"+Line+"\n";
            }
            reader.close();
            ta2.setText(concatStringsInReader);
        }
        catch (Exception ignored){}
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b2) {

            getTextFields();
            clearTextFields();

            Graphics g = getGraphics();
            g.setFont(f2);
            g.setColor(Color.BLACK);

            if(Objects.equals(sph, "") || Objects.equals(string_passport, "") || Objects.equals(sfn, "")){
                g.drawString("Name/Phone/Passport Cannot be Blank",900,700);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                g.setColor(Color.WHITE);
                g.drawString("Name/Phone/Passport Cannot be Blank",900,700);
            }

            else{
                writeFile();


                g.drawString("Data Saved Successfully : " + cbg1.getSelectedCheckbox().getLabel() + ". " + sfn + " " + sln, 900, 700);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                g.setColor(Color.WHITE);
                g.drawString("Data Saved Successfully : " + cbg1.getSelectedCheckbox().getLabel() + ". " + sfn + " " + sln, 900, 700);
            }

        }

        if(e.getSource()==b1){
            Graphics g = getGraphics();
            g.setFont(f2);
            ta1.setText(null);
            getFilesFromRepo();
        }

        if(e.getSource()==b3){
            Graphics g = getGraphics();
            g.setFont(f2);
            readFile();
        }
        if(e.getSource()==clear){
            concatStringsInReader="Entries:\n";
            concatStringsInRepo="Details:\n";
            ta1.setText("");
            ta2.setText("");
            readfile.setText("");
            checkout.setText("");
        }
        if(e.getSource()==checkOutButton){

            FileName=checkout.getText();
            File file = new File("D:\\JavaProjectFiles\\"+FileName);

            if (file.delete()) {
                System.out.println("File deleted successfully");
            }
            else {
                System.out.println("Failed to delete the file");
            }

            ta1.setText("");
            ta2.setText("");
            readfile.setText("");
            checkout.setText("");
            concatStringsInReader="Entries:\n";
            concatStringsInRepo="Details:\n";
            getFilesFromRepo();

            Graphics g = getGraphics();
            g.setFont(f2);
            g.setColor(Color.BLACK);
            g.drawString(" Checked Out",900,620);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            g.setColor(Color.WHITE);
            g.drawString(" Checked Out",900,620);

        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {}

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 5, 30, 100, 84, this);
        g.setColor(Color.blue);
        g.fillRect(165,80,1170,700);
        g.setColor(Color.WHITE);
        g.fillRect(175,90,1150,680);
        g.setColor(Color.CYAN);
        g.fillRect(175,90,350,680);
        g.setColor(Color.WHITE);
        g.fillRect(185,100,330,660);
        Color purple = new Color(128,0,128);
        g.setColor(purple);
        g.fillRect(525,90,350,680);
        g.setColor(Color.WHITE);
        g.fillRect(535,100,330,660);
        g.setColor(Color.CYAN);
        g.fillRect(875,90,450,680);
        g.setColor(Color.WHITE);
        g.fillRect(885,100,430,660);
    }

    public static void main(String[] args) {
        ProjectSem4 d = new ProjectSem4();
        d.setLayout(null);
        d.setSize(1920,1080);
        d.setVisible(true);
        d.setBackground(Color.MAGENTA);
        d.setTitle("TAJ Property Management System (Beta)");
    }
}