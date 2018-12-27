package design;

public abstract class AbstractOOP implements Employee {
    public final String owner = "Tozammel Khan";
    static String addressHeadOffice = "161-54 3rd Ave, Woodhaven Blvd, NY, 11433";

    public void describeCompany() {
        System.out.println(owner+" is the owner of the company located at : " + addressHeadOffice + ".");
    }

    public abstract void describeCompany(String Mission);

}
