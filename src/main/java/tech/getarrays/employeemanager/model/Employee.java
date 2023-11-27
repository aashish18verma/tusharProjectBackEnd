package tech.getarrays.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "q1rating_id")
    private Q1Rating q1Rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "q2rating_id", referencedColumnName = "id")
    private Q2Rating q2Rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "q3rating_id", referencedColumnName = "id")
    private Q3Rating q3Rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "q4rating_id", referencedColumnName = "id")
    private Q4Rating q4Rating;

    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;
}
