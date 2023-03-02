package repository;

import models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepository extends JpaRepository<Payment,Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.PaymentDto(" +
            "p.id," +
            "p.number," +
            "p.date," +
            "p.amount," +
            "p.purpose," +
            "p.tax," +
            "p.isDone," +
            "p.comment," +
            "p.typeOfPayment," +
            "c.id," +
            "cr.id," +
            "co.id," +
            "co.number," +
            "pr.id," +
            "pr.name," +
            "pe.id," +
            "pe.name)"+
            "FROM Payment p " +
            "left join Company c on (p.company.id = c.id)" +
            "left join Contractor cr on (p.contractor.id = cr.id)" +
            "left join Contract co on (p.contract.id = co.id)" +
            "left join Project pr on (p.project.id = pr.id)" +
            "left join PaymentExpenditure pe on (p.paymentExpenditure.id = pe.id)")
    List<PaymentDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.PaymentDto(" +
            "p.id," +
            "p.number," +
            "p.date," +
            "p.amount," +
            "p.purpose," +
            "p.tax," +
            "p.isDone," +
            "p.comment," +
            "p.typeOfPayment," +
            "c.id," +
            "cr.id," +
            "co.id," +
            "co.number," +
            "pr.id," +
            "pr.name," +
            "pe.id," +
            "pe.name)"+
            "FROM Payment p " +
            "left join Company c on (p.company.id = c.id)" +
            "left join Contractor cr on (p.contractor.id = cr.id)" +
            "left join Contract co on (p.contract.id = co.id)" +
            "left join Project pr on (p.project.id = pr.id)" +
            "left join PaymentExpenditure pe on (p.paymentExpenditure.id = pe.id)" +
            "WHERE p.id = :id")
    PaymentDto getById(@Param("id") Long id);

}
