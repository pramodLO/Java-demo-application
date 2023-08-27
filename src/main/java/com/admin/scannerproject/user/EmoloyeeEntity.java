//package com.admin.scannerproject.user;
//
//import java.util.List;
//
//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import jakarta.transaction.Transactional;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//
//@Entity
//@Transactional
//@Data
//@NoArgsConstructor
//@Table(name = "userdetails")
//
//public class EmoloyeeEntity {
//	
//	 @Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
//	    @Column(name = "emp_id")
//	    private Long empId;
//	    private String empName;
//	    private Integer empAge;
//	    //address_add_id - default fk column name
//	    //@OneToOne(cascade = CascadeType.ALL)
//	    //@JoinColumn(name = "fk_add_id")
//
//	    //unidirectional one-to-many
//	    @OneToMany(cascade = CascadeType.ALL)
//	    @JoinColumn(name = "fk_emp_id",referencedColumnName = "emp_id")
//	    private List<Address> address;
//
//
//
//	}
//
//
//
