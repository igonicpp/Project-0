public class Appliances{
  private String type;
  private int onWat;
  private double probOn;
  private int location;
  private boolean isSmart;

  public Appliances(int l, String t, int o, double p, boolean i){
    location = l;
    type = t;
    onWat = o;
    probOn = p;
    isSmart = i;
  }
  public int getOnWat(){
    return onWat;
  }
  public double getProbOn(){
    return probOn;
  }
  public int getLocation(){
    return location;
  }
  public boolean getIsSmart(){
    return isSmart;
  }
  public String getType(){
    return type;
  }
  public void setOnWat(int w){
    onWat = w;
  }
  public void setProbOn(double p){
    probOn = p;
  }
  public void setLocation(int l){
    location = l;
  }
  public void setIsSmart(boolean i){
    isSmart = i;
  }
  public void setType(String t){
    type = t;
  }
}