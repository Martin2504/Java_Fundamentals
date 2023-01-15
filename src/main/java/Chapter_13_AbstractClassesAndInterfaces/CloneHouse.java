package Chapter_13_AbstractClassesAndInterfaces;

public class CloneHouse implements Cloneable, Comparable<CloneHouse> {
    private int id;
    private double area;
    private java.util.Date whenBuilt;

    public CloneHouse(int id, double area) {
        this.id = id;
        this.area = area;
        whenBuilt = new java.util.Date();
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public java.util.Date getWhenBuilt() {
        return whenBuilt;
    }

    @Override
    /** Override the protected clone method defined in
     the Object class, and strengthen its accessibility */
    public Object clone() throws CloneNotSupportedException {
        // Perform a shallow copy
        CloneHouse houseClone = (CloneHouse)super.clone();
        // Deep copy on whenBuilt
        houseClone.whenBuilt = (java.util.Date)(whenBuilt.clone());
        return houseClone;
    }

    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(CloneHouse o) {
        if (area > o.area)
            return 1;
        else if (area < o.area)
            return -1;
        else
            return 0;
    }
}
