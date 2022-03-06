import java.sql.ResultSet;
import java.sql.Statement;
public class officer_bill_entry extends javax.swing.JFrame 
{

    
    dbmsconnection obj;
    Statement stmt;
    ResultSet rs2,rs1;
    String cid,eid,s1;
    float prev,consum,rate,amt,curr,fine_base;
    int i=0,n;
    String a[];
    public officer_bill_entry(String eid) 
    {
        this.eid=eid;
        initComponents();
        customer_cid();
    }
    public void customer_cid()
    {
        try
        {
            obj=new dbmsconnection();
            stmt=stmt=obj.stmt;
            String query0="SELECT COUNT(CID) FROM CUSTOMER";
            rs2=stmt.executeQuery(query0);
            if(rs2.next())
                n=rs2.getInt(1);
            a=new String[n];
            String query1="SELECT CID FROM CUSTOMER";
            rs2=stmt.executeQuery(query1);
            while(rs2.next())
                a[i++]=rs2.getString(1);
            i=0;
            set_Text();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void set_Text()
    {
        try
        {
//            System.out.println("here");
//            if(rs2.next())
//            {
//                System.out.println("here");
//                cid=rs2.getString(1);
//                jt1.setText(cid); 
//            }
//            else
//                jl5.setText("All bills generated");
            System.out.println("here");
            if(i<n)
            {
                System.out.println("here");
                cid=a[i];
                jt1.setText(a[i++]); 
            }
            else
                jl5.setText("All bills generated");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl1 = new javax.swing.JLabel();
        jl2 = new javax.swing.JLabel();
        jl3 = new javax.swing.JLabel();
        jt1 = new javax.swing.JTextField();
        jt2 = new javax.swing.JTextField();
        jt3 = new javax.swing.JTextField();
        jb1 = new javax.swing.JButton();
        jl4 = new javax.swing.JLabel();
        jt4 = new javax.swing.JTextField();
        jb2 = new javax.swing.JButton();
        jl5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jl1.setText("Customer ID");

        jl2.setText("Date");

        jl3.setText("Reading");

        jb1.setText("Calculate Bill");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });

        jl4.setText("Amount ");

        jb2.setText("Next Bill");
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 24)); // NOI18N
        jLabel1.setText("BILL AMOUNT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jl5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl4)
                            .addComponent(jl3)
                            .addComponent(jl2)
                            .addComponent(jl1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb1)
                            .addComponent(jt1)
                            .addComponent(jt2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jt3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jt4)
                            .addComponent(jb2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl1)
                    .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl2)
                    .addComponent(jt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl3)
                    .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jb1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl4)
                    .addComponent(jt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jb2)
                .addGap(18, 18, 18)
                .addComponent(jl5)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        s1=jt2.getText();
        curr=Float.parseFloat(jt3.getText());
        prev=0.0f;
        consum=0.0f;
        rate=0.0f;
        amt=0.0f;
        
        try
        {
            String query2="SELECT PREV_READ FROM CUSTOMER WHERE CID='"+cid+"'";
            rs1=stmt.executeQuery(query2);
            if(rs1.next())
                prev=Float.parseFloat(rs1.getString(1));
            consum=curr-prev;
            String query3="SELECT RATE FROM TARIFF WHERE ("+consum+" BETWEEN START_UNIT AND END_UNIT)";
            
            
            rs1=stmt.executeQuery(query3);
            if(rs1.next())
                rate=Float.parseFloat(rs1.getString(1));
            amt=rate*consum;
            jt4.setText(String.valueOf(amt));
            System.out.println("prev : "+prev+" rate :"+rate+" amt : "+amt);
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jb1ActionPerformed

    private void jb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb2ActionPerformed
        fine_base=0.0f;
        try
        {
            
            String query6="SELECT SUM(AMT) FROM BILL WHERE CID='"+cid+"' AND STATUS='Unpaid'";
            rs1=stmt.executeQuery(query6);
            if(rs1.next())
              fine_base=rs1.getFloat(1);
            
            int flag=0;
            String query7="SELECT CID FROM DEFAULTERS WHERE CID='"+cid+"'";
            rs1=stmt.executeQuery(query7);
            if(rs1.next())
              flag=1;
            
            String query8="";
            if(flag==1)
                query8="UPDATE DEFAULTERS SET FINE=FINE+"+fine_base*0.1+" WHERE CID='"+cid+"'";
            else
                query8="INSERT INTO DEFAULTERS VALUES ('"+cid+"',"+fine_base*0.1+")";
            flag=stmt.executeUpdate(query8);
            
            
            
            String query4="INSERT INTO BILL (EID,CID,BILL_DATE,PREV,CURR,CONSUMPTION,AMT,STATUS) VALUES ('"+eid+"','"+cid+"','"+s1+"',"+prev+","+curr+","+consum+","+amt+",'Unpaid')";
            String query5="UPDATE BILL SET DIS_DATE=(SELECT BILL_DATE + INTERVAL '20' DAY FROM BILL WHERE CID='"+cid+"' AND BILL_DATE='"+s1+"') WHERE CID='"+cid+"' AND BILL_DATE='"+s1+"'";
            int k=stmt.executeUpdate(query4);
            k=stmt.executeUpdate(query5);
            if(k==1)
                System.out.println("success");
            else
                System.out.println("error");
            jt3.setText("");
            jt4.setText("");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        set_Text();
    }//GEN-LAST:event_jb2ActionPerformed

    public static void main(String args[]) 
    {
        officer_bill_entry ob1=new officer_bill_entry("E001");
        ob1.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jb1;
    private javax.swing.JButton jb2;
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl2;
    private javax.swing.JLabel jl3;
    private javax.swing.JLabel jl4;
    private javax.swing.JLabel jl5;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt2;
    private javax.swing.JTextField jt3;
    private javax.swing.JTextField jt4;
    // End of variables declaration//GEN-END:variables
}
