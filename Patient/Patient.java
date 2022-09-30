package Patient;

/**
 * Class Patient representing a patient with fields: id , last_name , first_name , middle_name , address , phone_number , med_card , diagnosis
 * has constructors for creating objects and public methods setValue(), getValue(), toString() for accessing object fields.
 */
public class Patient {
    private int id;
    private String last_name;
    private String first_name;
    private String middle_name;
    private String address;
    private String phone_number;
    private int med_card;
    private String diagnosis;

    /**
     * Constructor without parameters
     */
    public Patient(){
    };

    /**
     * Constructor with parameters
     * @param id
     * @param last_name
     * @param first_name
     * @param middle_name
     * @param address
     * @param phone_number
     * @param med_card
     * @param diagnosis
     */
    public Patient(int id, String last_name, String first_name, String middle_name, String address,String phone_number, int med_card, String diagnosis){
        this.address = address;
        this.diagnosis = diagnosis;
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.med_card = med_card;
        this.middle_name = middle_name;
        this.phone_number = phone_number;
    }

    /**
     * Setter for the address field
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter for the id field
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for the diagnosis field
     * @param diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Setter for the first_name field
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Setter for the last_name field
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Setter for the med_card field
     * @param med_card
     */
    public void setMed_card(int med_card) {
        this.med_card = med_card;
    }

    /**
     * Setter for the middle_name field
     * @param middle_name
     */
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    /**
     * Setter for the phone_number field
     * @param phone_number
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * getter for the id field
     * @return id field
     */
    public int getId() {
        return id;
    }

    /**
     * getter for the med_card field
     * @return med_card field
     */
    public int getMed_card() {
        return med_card;
    }

    /**
     * getter for the address field
     * @return address field
     */
    public String getAddress() {
        return address;
    }

    /**
     * getter for the diagnosis field
     * @return diagnosis field
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * getter for the first_name field
     * @return first_name field
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * getter for the last_name field
     * @return last_name field
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * getter for the middle_name field
     * @return middle_name field
     */
    public String getMiddle_name() {
        return middle_name;
    }

    /**
     * getter for the phone_number field
     * @return phone_number field
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * Override toString methode that create and return string with data of Patient object
     * @return string with data of Patient object
     */
    @Override
    public String toString() {
        return "Patient: " +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", med_card=" + med_card +
                ", diagnosis='" + diagnosis + '\'';
    }
}
