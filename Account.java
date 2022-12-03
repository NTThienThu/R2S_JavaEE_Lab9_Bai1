public class Account {
    private static int idTemp = 1;
    private int id;
    private String name;
    private String gender;
    private String birthday;
    private String address;
    private String email;
    private int numberOfTrans;
    private long money;

    public Account(String name, String gender, String birthday, String address, String email) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
    }


    public Account() {
        this.id = idTemp++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getNumberOfTrans() {
        return numberOfTrans;
    }

    public void setNumberOfTrans(int numberOfTrans) {
        this.numberOfTrans = numberOfTrans;
    }

    @Override
    public String toString() {
        return
                "[ Account number=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", numberOfTrans=" + numberOfTrans +
                ", money=" + money +
                ']';
    }
}
