public class Info {
    public String City;
    public String District;
    public String Town;
    public String Citizen;

    public Info(String City, String District, String Town, String Citizen) {
        this.City = City;
        this.District = District;
        this.Town = Town;
        this.Citizen = Citizen;
    }

    @Override
    public String toString() {
        return "\tName: " + Citizen + 
                "\n\tCity: " + City + 
                "\n\tDistrict: " + District + 
                "\n\tTown: " + Town;
    }

}
