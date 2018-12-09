/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trello;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author ubaidullah
 */
public class CreateNewCard extends javax.swing.JFrame {

    /**
     * Creates new form CreateNewCard
     */
     User user1;
    Team_Management tm2;
    String teamname;
    String listname;
    public CreateNewCard() {
        initComponents();
    }
     public CreateNewCard(String tn,String ln,User u1) {
         teamname=tn;
         listname=ln;
         user1=u1;
         //initTM();
         tm2=Team_Management.getinstancetillassignedmembers();
        initComponents();
        setResizable(false);
    }
      public void initTM(){
        Connection myConnection =null;
    
     Statement myStatement=null;
     ResultSet myResult=null;
     ResultSet myResult2=null;
     ResultSet myResult3=null;
     ResultSet myResult4=null;
  String url = "jdbc:derby://localhost:1527/TrelloApp";
        try{
            myConnection = DriverManager.getConnection(url,"ubaid","12345");
            myStatement = myConnection.createStatement();
            myResult = myStatement.executeQuery("Select * from AllTeams ");
            while(myResult.next())  {
             tm2.addTeam(myResult.getString(1));
            //System.out.println(myResult.getString(1));
            }
            
            for (int i=0;i<tm2.gettotalteams();i++){
                 myResult = myStatement.executeQuery("Select Members from "+tm2.getTeam(i).getName()+" where Members is not null ");
                 while(myResult.next()){
                      tm2.getTeam(i).adduser(myResult.getString(1));
                    
                 }
                 myResult2=myStatement.executeQuery("Select ListNames from "+tm2.getTeam(i).getName()+" where ListNames is not null ");
                 
                 while(myResult2.next()){
                     List l=new List(myResult2.getString(1));
                     tm2.getTeam(i).addlist(l);
                 }
                 for (int j=0;j<tm2.getTeam(i).getLists().size();j++){
                     myResult3=myStatement.executeQuery("Select cardname from "+tm2.getTeam(i).getName()+tm2.getTeam(i).getLists().get(j).getname()+" where cardname is not null ");
                     while(myResult3.next()){
                         Card c=new Card(myResult3.getString(1));
                         tm2.getTeam(i).getLists().get(j).addcard(c);
                        // System.out.println(myResult3.getString(1));
                     }
                     
                     for (int k=0;k<tm2.getTeam(i).getLists().get(j).getcards().size();k++){
                          myResult4=myStatement.executeQuery("Select Members from "+tm2.getTeam(i).getName()+tm2.getTeam(i).getLists().get(j).getname()+tm2.getTeam(i).getLists().get(j).getcards().get(k).getname()+" where Members is not null ");
                         while(myResult4.next()){
                           //  System.out.println(myResult4.getString(1));
                             tm2.getTeam(i).getLists().get(j).getcards().get(k).addmemberTocard(myResult4.getString(1));
                         }
                         
                     }
                     
                 }
            }
        }
                catch(SQLException E){
            E.printStackTrace();
            System.out.println("Connection not made");
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("    Enter Name:");

        jLabel2.setBackground(new java.awt.Color(30, 47, 47));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("     Ok");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Felix Titling", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 63, 65));
        jLabel4.setText("   Create Card");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-back-arrow-32.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setBackground(new Color(61,92,92));
        jLabel2.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        jLabel2.setBackground(new Color(30,47,47));
        jLabel2.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        if(!jTextField1.getText().equals("")){
            if(tm2.ispresentcard(teamname, listname, jTextField1.getText())){
                JOptionPane.showMessageDialog(this, "Please choose a different name this name is already taken" );
            }
            else{
                Connection myConnection =null;

                Statement myStatement=null;
                ResultSet myResult=null;

                String url = "jdbc:derby://localhost:1527/TrelloApp";
                try{
                    myConnection = DriverManager.getConnection(url,"ubaid","12345");
                    myStatement = myConnection.createStatement();
                    myStatement.executeUpdate("Insert into " +teamname+listname +" (cardname) values ('"+jTextField1.getText()+"')");
                    myStatement.executeUpdate("create table "+teamname +listname+jTextField1.getText()+"(members varchar(30),checklist varchar(30),comments varchar(100))");
                   
                    tm2.addcard(teamname,listname, jTextField1.getText());

                    JOptionPane.showMessageDialog(this, "Card added" );

                }
                catch(SQLException E){
                    E.printStackTrace();
                    System.out.println("Connection not made");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please enter a name" );
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:

        ListDisplay d=new ListDisplay(teamname,listname,user1);
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
