package com.tampashev.micro.user.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "user_schema", name = "user_content")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen", schema = "user_schema", sequenceName = "user_content_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "user_name", updatable = false, nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false)
    private boolean expired;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date", nullable = false, updatable = false)
    private Date registrationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_visit_date", nullable = false)
    private Date lastVisitDate;

    @PrePersist
    private void setRegistrationDate(){
        registrationDate = (registrationDate == null) ? new Date() : registrationDate;
        lastVisitDate = (lastVisitDate == null) ? registrationDate : lastVisitDate;
    }

    @PostLoad
    private void setLastVisitDate(){
        lastVisitDate = new Date();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
