
public class Car {
 
 private String identifier;
 private int milage;
 private int fuelUsed;
 private int cost;
 private int year;
 
 public Car() {
  identifier = "";
  milage = 0;
  fuelUsed = 0;
 }

 public Car(String identifier) {
  this.identifier = identifier;
  milage = 0;
  fuelUsed = 0;
 }
 
 public Car(String identifier, int milage, int fuelUsed) {
  this.identifier = identifier;
  this.milage = milage;
  this.fuelUsed = fuelUsed;
 }
 
 public Car(String identifier, int milage, int fuelUsed, int cost, int year) {
	  this.identifier = identifier;
	  this.milage = milage;
	  this.fuelUsed = fuelUsed;
	  this.cost = cost;
	  this.year = year;
 }
 
 public int getCost() {
	return cost;
}

public void setCost(int cost) {
	this.cost = cost;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public void addFuel(int fuel) {
  fuelUsed += fuel;
 }
 
 public void addMiles(int miles) {
  milage += miles;
 }
 
 public double getMPG() {
  return (double)milage / fuelUsed;
 }

 public String getIdentifier() {
  return identifier;
 }

 public void setIdentifier(String identifier) {
  this.identifier = identifier;
 }

 public int getMiles() {
  return milage;
 }

 public void setMiles(int milage) {
  this.milage = milage;
 }

 public int getFuelUsed() {
  return fuelUsed;
 }

 public void setFuelUsed(int fuelUsed) {
  this.fuelUsed = fuelUsed;
 }
 
 public int compareMPG(Car otherCar) {
	 double myMPG = getMPG();
	 double otherMPG = otherCar.getMPG();
	 if (myMPG == otherMPG) return 0;
	 if (myMPG - otherMPG > 0) return 1;
		return -1;
 }
 
 public int compareMiles (Car otherCar) {
	 double myMiles = getMiles();
	 double otherMiles = otherCar.getMiles();
	 if (myMiles == otherMiles) return 0;
	 if (myMiles - otherMiles > 0) return 1;
	 return -1;
 }


 public boolean equals(Object obj){
   if (this==obj) return true;
   if (obj==null) return false;
   if (this.getClass()!=obj.getClass()) return false;
   final Car other = (Car)obj;
   if ((this.getIdentifier().equals(other.getIdentifier()) &&
       this.getMPG()==other.getMPG()))
         return true;
       return false;
 }
 
 
 public String toString() {
  return "Car [identifier=" + identifier + ", milage=" + milage + ", fuelUsed=" + fuelUsed + "]";
 }

}
