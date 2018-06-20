package com.manzuraz.project.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import com.manzuraz.project.models.User;

@Entity
@Table(name="ideas")
public class Idea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty
	private String name;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MMMM/dd/yyyy")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern="MMMM/dd/yyyy")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User creator;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_ideas", 
            joinColumns = @JoinColumn(name = "idea_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> likedUsers;
	
	public Idea() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getLikedUsers() {
		return likedUsers;
	}

	public void setLikedUsers(List<User> likedUsers) {
		this.likedUsers = likedUsers;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
}
