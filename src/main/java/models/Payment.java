package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String number;

    @Column
    private LocalDateTime date;

    @Column
    private BigDecimal amount;

    @Column
    private String purpose;

    @Column
    private BigDecimal tax;

    @Column
    private boolean isDone;

    @Column
    private String comment;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfPayment typeOfPayment;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Task> tasks;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Document> documents;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY)
    private PaymentExpenditure paymentExpenditure;
}
