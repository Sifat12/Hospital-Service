
package patientinquerymanagementsystem;

/**
 *
 * @author Tech Land
 */
public class Patient {
    private int id;
    private String name;
    private String sex;
    private String age;
    private String contact;
    private String address;
    private String patient_Type;
    private String doctor;
    private byte[] picture;
    private String modified_Date;
    private String modified_Time;
    
    public Patient(int i,String nm,String s,String g,String cNumber,String ad,String pType,String d,byte[] pimg,String mDate,String mTime)
    {
        this.id = i;
        this.name = nm;
        this.sex = s;
        this.age = g;
        this.contact = cNumber;
        this.address =ad;
        this.patient_Type = pType;
        this.doctor = d;
         this.picture = pimg;
        this.modified_Date = mDate;
        this.modified_Time = mTime;
       
    }
    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getsex()
    {
        return sex;
    }
    public String getAge()
    {
        return age;
    }
    public String getContactNumber()
    {
        return contact;
    }
    public String getAddress()
    {
        return address;
    }
    public String getPatientType()
    {
        return patient_Type;
    }
     public String getDoctor()
    {
        return doctor;
    }
      public String getModifyDate()
    {
        return modified_Date;
    }
       public String getModifyTime()
    {
        return modified_Time;
    }
      public byte[] getPicture()
    {
        return picture;
    }
    
    
}
