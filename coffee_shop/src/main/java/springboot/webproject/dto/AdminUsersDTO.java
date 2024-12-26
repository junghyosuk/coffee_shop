package springboot.webproject.dto;



//@Entity
public class AdminUsersDTO {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usersNo;
    private String usersId;
    private String usersPw;
    private String usersName;
    private String usersZipcode;
    private String usersAddress1;
    private String usersAddress2;
    private String usersPhone;
    private String usersEmail;
    private String usersSigndate;
    private String usersLastLogin;
    private int usersStatus;

    public AdminUsersDTO() {
        // TODO Auto-generated constructor stub
    }

    public AdminUsersDTO(int usersNo, String usersId, String usersPw, String usersName, String usersZipcode,
                         String usersAddress1, String usersAddress2, String usersPhone, String usersEmail, String usersSigndate,
                         String usersLastLogin, int usersStatus) {
        super();
        this.usersNo = usersNo;
        this.usersId = usersId;
        this.usersPw = usersPw;
        this.usersName = usersName;
        this.usersZipcode = usersZipcode;
        this.usersAddress1 = usersAddress1;
        this.usersAddress2 = usersAddress2;
        this.usersPhone = usersPhone;
        this.usersEmail = usersEmail;
        this.usersSigndate = usersSigndate;
        this.usersLastLogin = usersLastLogin;
        this.usersStatus = usersStatus;
    }
    public int getUsersNo() {
        return usersNo;
    }
    public void setUsersNo(int usersNo) {
        this.usersNo = usersNo;
    }
    public String getUsersId() {
        return usersId;
    }
    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }
    public String getUsersPw() {
        return usersPw;
    }
    public void setUsersPw(String usersPw) {
        this.usersPw = usersPw;
    }
    public String getUsersName() {
        return usersName;
    }
    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }
    public String getUsersZipcode() {
        return usersZipcode;
    }
    public void setUsersZipcode(String usersZipcode) {
        this.usersZipcode = usersZipcode;
    }
    public String getUsersAddress1() {
        return usersAddress1;
    }
    public void setUsersAddress1(String usersAddress1) {
        this.usersAddress1 = usersAddress1;
    }
    public String getUsersAddress2() {
        return usersAddress2;
    }
    public void setUsersAddress2(String usersAddress2) {
        this.usersAddress2 = usersAddress2;
    }
    public String getUsersPhone() {
        return usersPhone;
    }
    public void setUsersPhone(String usersPhone) {
        this.usersPhone = usersPhone;
    }
    public String getUsersEmail() {
        return usersEmail;
    }
    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }
    public String getUsersSigndate() {
        return usersSigndate;
    }
    public void setUsersSigndate(String usersSigndate) {
        this.usersSigndate = usersSigndate;
    }
    public String getUsersLastLogin() {
        return usersLastLogin;
    }
    public void setUsersLastLogin(String usersLastLogin) {
        this.usersLastLogin = usersLastLogin;
    }
    public int getUsersStatus() {
        return usersStatus;
    }
    public void setUsersStatus(int usersStatus) {
        this.usersStatus = usersStatus;
    }


}
