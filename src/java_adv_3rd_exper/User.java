package java_adv_3rd_exper;

@Table("user")
public class User{
	@Column("id")
    private int id;

	@Column("username")
    private String username;
    
	@Column("age")
    private int age;

    @Column("email")
    private String email;

    @Column("telephone")
    private String telephone;
 
    public void setId(int id) {
    	this.id = id;
    }
    public void setUsername(String userName) {
    	this.username = userName;
    }
    public void setAge(int age) {
    	this.age = age;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    public void setTelephone(String telephone) {
    	this.telephone = telephone;
    }
}
