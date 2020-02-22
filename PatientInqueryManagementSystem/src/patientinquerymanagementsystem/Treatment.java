/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientinquerymanagementsystem;

/**
 *
 * @author Tech Land
 */
public class Treatment {
      private int id;
    private String name;
    private String medicine_name;
    private String admissionDate;
    private String releaseDate;
    private String cabin;
    private float chargedAmount;
    private float billPaid;
    private float dueBill;
    private byte[] picture;
    
    public Treatment(int i,String nm,String mdcn,String adate,String rdate,String cab,float camount,float bpaid,float dbl,byte[] pimg)
    {
        this.id = i;
        this.name = nm;
        this.medicine_name = mdcn;
        this.admissionDate = adate;
        this.releaseDate = rdate;
        this.cabin =cab;
        this.chargedAmount = camount;
        this.billPaid = bpaid;
        this.dueBill = dbl;
        this.picture = pimg;
    }
    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getMedicine()
    {
        return medicine_name;
    }
    public String getAdmissionDate()
    {
        return admissionDate;
    }
    public String getReleaseDate()
    {
        return releaseDate;
    }
    public String getCabin()
    {
        return cabin;
    }
    public float getChargedAmount()
    {
        return chargedAmount;
    }
     public float getBillPaid()
    {
        return billPaid;
    }
      public float getDueBill(float a,float b)
    {
        return a-b;
    }
      
      public byte[] getPicture()
    {
        return picture;
    }
      
}
