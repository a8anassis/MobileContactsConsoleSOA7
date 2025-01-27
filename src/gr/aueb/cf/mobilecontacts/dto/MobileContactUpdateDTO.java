package gr.aueb.cf.mobilecontacts.dto;

public class MobileContactUpdateDTO extends BaseDTO {
    private String firstname;
    private String lastname;
    private String phoneNumber;

    public MobileContactUpdateDTO() {

    }

    public MobileContactUpdateDTO(Long id, String firstname, String lastname, String phoneNumber) {
        setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
