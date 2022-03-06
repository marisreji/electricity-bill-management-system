import java.sql.ResultSet;
import java.sql.Statement;
public class customer_bill_pay extends javax.swing.JFrame 
{

    Statement stmt=null;
    String cid="";
    ResultSet rs=null;
    public customer_bill_pay(String cid) 
    {
        this.cid=cid;
        initComponents();
        find_bills();
    }
    public void find_bills()
    {
       try
        {
            String s="<html>";
            dbmsconnection obj=new dbmsconnection();
            stmt=obj.stmt;
            String query="SELECT BILL_DATE,AMT FROM BILL WHERE CID='"+cid+"' AND STATUS='Unpaid' ORDER BY BILL_DATE ASC";
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String s1=rs.getString(1);
                
                s+=s1.substring(0,10)+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+rs.getFloat(2)+"<br>";
            }
            String query1="SELECT FINE FROM DEFAULTERS WHERE CID='"+cid+"'";
            rs=stmt.executeQuery(query1);
            if(rs.next())
                s+="Fine Amount &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+rs.getFloat(1)+"<br>";
            String query2="SELECT TOTAL_AMT FROM CUSTOMER WHERE CID='"+cid+"'";
            rs=stmt.executeQuery(query2);
            if(rs.next())
                s+="Total Amount &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+rs.getFloat(1)+"<br>";
            s+="</html>";
//            stmt.close();
//            obj.con.close();
            jl1.setText(s);    
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jl1 = new javax.swing.JLabel();
        jl2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jButton1.setText("Pay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jl2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jl1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(jl2)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String query3="DELETE FROM DEFAULTERS WHERE CID='"+cid+"'";
        String query4="UPDATE BILL SET STATUS='Paid' WHERE STATUS='Unpaid' AND CID='"+cid+"'";
        String query5="UPDATE CUSTOMER SET TOTAL_AMT=0 WHERE CID='"+cid+"'";
        try
        {
            int i=stmt.executeUpdate(query3);
            i=stmt.executeUpdate(query4);
            i=stmt.executeUpdate(query5);
            jl2.setText("Payment Successful");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
               
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(customer_bill_pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customer_bill_pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customer_bill_pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer_bill_pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                customer_bill_pay obj=new customer_bill_pay("C001");
                obj.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl2;
    // End of variables declaration//GEN-END:variables
}
