public class SmartAppliance extends Appliances{
  double lowWat;

  public SmartAppliance(int l, String t, int o, double p, boolean i,double low){
    super(l, t, o, p, i);
    lowWat = low;
  }
  public double getLowWat(){
    return lowWat;
  }
  public void setLowWat(double low){
    lowWat = low;
  }
}