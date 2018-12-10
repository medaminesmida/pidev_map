package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Holidays database table.
 * 
 */
@Entity
@Table(name="Holidays")
@NamedQuery(name="Holiday.findAll", query="SELECT h FROM Holiday h")
public class Holiday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HolidayId")
	private int holidayId;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="History")
	private Timestamp history;

	@Column(name="StartDate")
	private Timestamp startDate;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="holidays",cascade=CascadeType.PERSIST)
	private List<User> users;

	public Holiday() {
	}

	public int getHolidayId() {
		return this.holidayId;
	}

	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getHistory() {
		return this.history;
	}

	public void setHistory(Timestamp history) {
		this.history = history;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}